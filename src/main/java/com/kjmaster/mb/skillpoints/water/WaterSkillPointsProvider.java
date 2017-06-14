package com.kjmaster.mb.skillpoints.water;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Created by pbill_000 on 07/06/2017.
 */
public class WaterSkillPointsProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IWaterSkillPoints.class)
    public static final Capability<IWaterSkillPoints> WATERSKILLPOINTS_CAP = null;

    private IWaterSkillPoints Waterinstance = WATERSKILLPOINTS_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == WATERSKILLPOINTS_CAP;

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == WATERSKILLPOINTS_CAP ? WATERSKILLPOINTS_CAP.<T>cast(this.Waterinstance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return WATERSKILLPOINTS_CAP.getStorage().writeNBT(WATERSKILLPOINTS_CAP, this.Waterinstance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        WATERSKILLPOINTS_CAP.getStorage().readNBT(WATERSKILLPOINTS_CAP, this.Waterinstance, null, nbt);
    }
}
