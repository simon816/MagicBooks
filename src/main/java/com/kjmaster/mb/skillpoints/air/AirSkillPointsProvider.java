package com.kjmaster.mb.skillpoints.air;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Created by pbill_000 on 06/06/2017.
 */
public class AirSkillPointsProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IAirSkillPoints.class)
    public static final Capability<IAirSkillPoints> AIRSKILLPOINTS_CAP = null;

    private IAirSkillPoints Airinstance = AIRSKILLPOINTS_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == AIRSKILLPOINTS_CAP;

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == AIRSKILLPOINTS_CAP ? AIRSKILLPOINTS_CAP.<T>cast(this.Airinstance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return AIRSKILLPOINTS_CAP.getStorage().writeNBT(AIRSKILLPOINTS_CAP, this.Airinstance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        AIRSKILLPOINTS_CAP.getStorage().readNBT(AIRSKILLPOINTS_CAP, this.Airinstance, null, nbt);
    }
}




