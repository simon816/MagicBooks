package com.kjmaster.mb.chosenspells.chosenspell2;

import com.kjmaster.mb.chosenspells.chosenspell.IChosenSpell;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Created by pbill_000 on 25/07/2017.
 */
public class ChosenSpell2Provider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IChosenSpell2.class)
    public static final Capability<IChosenSpell2> CHOSENSPELL2_CAP = null;

    private IChosenSpell2 ChosenSpell2instance = CHOSENSPELL2_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == CHOSENSPELL2_CAP;

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == CHOSENSPELL2_CAP ? CHOSENSPELL2_CAP.<T>cast(this.ChosenSpell2instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return CHOSENSPELL2_CAP.getStorage().writeNBT(CHOSENSPELL2_CAP, this.ChosenSpell2instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        CHOSENSPELL2_CAP.getStorage().readNBT(CHOSENSPELL2_CAP, this.ChosenSpell2instance, null, nbt);
    }
}
