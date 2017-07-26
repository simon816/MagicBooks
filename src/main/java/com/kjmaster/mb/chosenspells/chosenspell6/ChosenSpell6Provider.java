package com.kjmaster.mb.chosenspells.chosenspell6;

import com.kjmaster.mb.chosenspells.chosenspell2.IChosenSpell2;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Created by pbill_000 on 26/07/2017.
 */
public class ChosenSpell6Provider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IChosenSpell6.class)
    public static final Capability<IChosenSpell6> CHOSENSPELL6_CAP = null;

    private IChosenSpell6 ChosenSpell6instance = CHOSENSPELL6_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == CHOSENSPELL6_CAP;

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == CHOSENSPELL6_CAP ? CHOSENSPELL6_CAP.<T>cast(this.ChosenSpell6instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return CHOSENSPELL6_CAP.getStorage().writeNBT(CHOSENSPELL6_CAP, this.ChosenSpell6instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        CHOSENSPELL6_CAP.getStorage().readNBT(CHOSENSPELL6_CAP, this.ChosenSpell6instance, null, nbt);
    }
}