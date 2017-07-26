package com.kjmaster.mb.chosenspells.chosenspell7;

import com.kjmaster.mb.chosenspells.chosenspell2.IChosenSpell2;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Created by pbill_000 on 26/07/2017.
 */
public class ChosenSpell7Provider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IChosenSpell7.class)
    public static final Capability<IChosenSpell7> CHOSENSPELL7_CAP = null;

    private IChosenSpell7 ChosenSpell7instance = CHOSENSPELL7_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == CHOSENSPELL7_CAP;

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == CHOSENSPELL7_CAP ? CHOSENSPELL7_CAP.<T>cast(this.ChosenSpell7instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return CHOSENSPELL7_CAP.getStorage().writeNBT(CHOSENSPELL7_CAP, this.ChosenSpell7instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        CHOSENSPELL7_CAP.getStorage().readNBT(CHOSENSPELL7_CAP, this.ChosenSpell7instance, null, nbt);
    }
}
