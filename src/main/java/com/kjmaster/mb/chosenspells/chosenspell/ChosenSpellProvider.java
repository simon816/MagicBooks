package com.kjmaster.mb.chosenspells.chosenspell;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Created by pbill_000 on 25/07/2017.
 */
public class ChosenSpellProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IChosenSpell.class)
    public static final Capability<IChosenSpell> CHOSENSPELL_CAP = null;

    private IChosenSpell ChosenSpellinstance = CHOSENSPELL_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == CHOSENSPELL_CAP;

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == CHOSENSPELL_CAP ? CHOSENSPELL_CAP.<T> cast(this.ChosenSpellinstance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return CHOSENSPELL_CAP.getStorage().writeNBT(CHOSENSPELL_CAP, this.ChosenSpellinstance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        CHOSENSPELL_CAP.getStorage().readNBT(CHOSENSPELL_CAP, this.ChosenSpellinstance, null, nbt);
    }
}