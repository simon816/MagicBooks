package com.kjmaster.mb.skillpoints.air;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

/**
 * Created by pbill_000 on 06/06/2017.
 */
public class AirSkillPointsStorage implements Capability.IStorage<IAirSkillPoints> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IAirSkillPoints> capability, IAirSkillPoints instance, EnumFacing side) {
        return new NBTTagFloat(instance.getAirSkillPoints());
    }

    @Override
    public void readNBT(Capability<IAirSkillPoints> capability, IAirSkillPoints instance, EnumFacing side, NBTBase nbt) {
        instance.setAir(((NBTPrimitive) nbt).getFloat());
    }
}
