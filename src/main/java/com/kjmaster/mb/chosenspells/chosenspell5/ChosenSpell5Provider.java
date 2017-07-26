package com.kjmaster.mb.chosenspells.chosenspell5;

import com.kjmaster.mb.chosenspells.chosenspell2.IChosenSpell2;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Created by pbill_000 on 26/07/2017.
 */
public class ChosenSpell5Provider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IChosenSpell5.class)
    public static final Capability<IChosenSpell5> CHOSENSPELL5_CAP = null;

    private IChosenSpell5 ChosenSpell5instance = CHOSENSPELL5_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == CHOSENSPELL5_CAP;

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == CHOSENSPELL5_CAP ? CHOSENSPELL5_CAP.<T>cast(this.ChosenSpell5instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return CHOSENSPELL5_CAP.getStorage().writeNBT(CHOSENSPELL5_CAP, this.ChosenSpell5instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        CHOSENSPELL5_CAP.getStorage().readNBT(CHOSENSPELL5_CAP, this.ChosenSpell5instance, null, nbt);
    }
}
