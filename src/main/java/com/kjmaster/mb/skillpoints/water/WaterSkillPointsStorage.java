package com.kjmaster.mb.skillpoints.water;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

/**
 * Created by pbill_000 on 07/06/2017.
 */
public class WaterSkillPointsStorage implements Capability.IStorage<IWaterSkillPoints> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IWaterSkillPoints> capability, IWaterSkillPoints instance, EnumFacing side) {
        return new NBTTagFloat(instance.getWaterSkillPoints());
    }

    @Override
    public void readNBT(Capability<IWaterSkillPoints> capability, IWaterSkillPoints instance, EnumFacing side, NBTBase nbt) {
        instance.setWater(((NBTPrimitive) nbt).getFloat());
    }
}
