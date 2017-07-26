package com.kjmaster.mb.chosenspells.chosenspell3;

import com.kjmaster.mb.chosenspells.chosenspell2.IChosenSpell2;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Created by pbill_000 on 26/07/2017.
 */
public class ChosenSpell3Provider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IChosenSpell3.class)
    public static final Capability<IChosenSpell3> CHOSENSPELL3_CAP = null;

    private IChosenSpell3 ChosenSpell3instance = CHOSENSPELL3_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == CHOSENSPELL3_CAP;

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == CHOSENSPELL3_CAP ? CHOSENSPELL3_CAP.<T>cast(this.ChosenSpell3instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return CHOSENSPELL3_CAP.getStorage().writeNBT(CHOSENSPELL3_CAP, this.ChosenSpell3instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        CHOSENSPELL3_CAP.getStorage().readNBT(CHOSENSPELL3_CAP, this.ChosenSpell3instance, null, nbt);
    }
}
