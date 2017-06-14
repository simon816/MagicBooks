package com.kjmaster.mb.skillpoints.fire;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Created by pbill_000 on 07/06/2017.
 */
public class FireSkillPointsProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IFireSkillPoints.class)
    public static final Capability<IFireSkillPoints> FIRESKILLPOINTS_CAP = null;

    private IFireSkillPoints Fireinstance = FIRESKILLPOINTS_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == FIRESKILLPOINTS_CAP;

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == FIRESKILLPOINTS_CAP ? FIRESKILLPOINTS_CAP.<T>cast(this.Fireinstance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return FIRESKILLPOINTS_CAP.getStorage().writeNBT(FIRESKILLPOINTS_CAP, this.Fireinstance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        FIRESKILLPOINTS_CAP.getStorage().readNBT(FIRESKILLPOINTS_CAP, this.Fireinstance, null, nbt);
    }
}