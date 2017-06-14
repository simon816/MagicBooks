package com.kjmaster.mb.skillpoints.earth;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Created by pbill_000 on 06/06/2017.
 */
public class EarthSkillPointsProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IEarthSkillPoints.class)
    public static final Capability<IEarthSkillPoints> EARTHSKILLPOINTS_CAP = null;

    private IEarthSkillPoints Earthinstance = EARTHSKILLPOINTS_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == EARTHSKILLPOINTS_CAP;

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == EARTHSKILLPOINTS_CAP ? EARTHSKILLPOINTS_CAP.<T>cast(this.Earthinstance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return EARTHSKILLPOINTS_CAP.getStorage().writeNBT(EARTHSKILLPOINTS_CAP, this.Earthinstance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        EARTHSKILLPOINTS_CAP.getStorage().readNBT(EARTHSKILLPOINTS_CAP, this.Earthinstance, null, nbt);
    }
}
