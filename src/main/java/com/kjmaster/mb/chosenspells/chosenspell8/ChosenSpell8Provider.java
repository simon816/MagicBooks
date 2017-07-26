package com.kjmaster.mb.chosenspells.chosenspell8;

import com.kjmaster.mb.chosenspells.chosenspell2.IChosenSpell2;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Created by pbill_000 on 26/07/2017.
 */
public class ChosenSpell8Provider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IChosenSpell8.class)
    public static final Capability<IChosenSpell8> CHOSENSPELL8_CAP = null;

    private IChosenSpell8 ChosenSpell8instance = CHOSENSPELL8_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == CHOSENSPELL8_CAP;

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == CHOSENSPELL8_CAP ? CHOSENSPELL8_CAP.<T>cast(this.ChosenSpell8instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return CHOSENSPELL8_CAP.getStorage().writeNBT(CHOSENSPELL8_CAP, this.ChosenSpell8instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        CHOSENSPELL8_CAP.getStorage().readNBT(CHOSENSPELL8_CAP, this.ChosenSpell8instance, null, nbt);
    }
}
