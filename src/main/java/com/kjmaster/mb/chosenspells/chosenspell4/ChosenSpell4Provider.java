package com.kjmaster.mb.chosenspells.chosenspell4;

import com.kjmaster.mb.chosenspells.chosenspell2.IChosenSpell2;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Created by pbill_000 on 26/07/2017.
 */
public class ChosenSpell4Provider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IChosenSpell4.class)
    public static final Capability<IChosenSpell4> CHOSENSPELL4_CAP = null;

    private IChosenSpell4 ChosenSpell4instance = CHOSENSPELL4_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == CHOSENSPELL4_CAP;

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == CHOSENSPELL4_CAP ? CHOSENSPELL4_CAP.<T>cast(this.ChosenSpell4instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return CHOSENSPELL4_CAP.getStorage().writeNBT(CHOSENSPELL4_CAP, this.ChosenSpell4instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        CHOSENSPELL4_CAP.getStorage().readNBT(CHOSENSPELL4_CAP, this.ChosenSpell4instance, null, nbt);
    }
}
