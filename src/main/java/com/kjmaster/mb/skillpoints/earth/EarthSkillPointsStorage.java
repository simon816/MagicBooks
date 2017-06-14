package com.kjmaster.mb.skillpoints.earth;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

/**
 * Created by pbill_000 on 06/06/2017.
 */
public class EarthSkillPointsStorage implements Capability.IStorage<IEarthSkillPoints> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IEarthSkillPoints> capability, IEarthSkillPoints instance, EnumFacing side) {
        return new NBTTagFloat(instance.getEarthSkillPoints());
    }

    @Override
    public void readNBT(Capability<IEarthSkillPoints> capability, IEarthSkillPoints instance, EnumFacing side, NBTBase nbt) {
        instance.setEarth(((NBTPrimitive) nbt).getFloat());
    }
}
