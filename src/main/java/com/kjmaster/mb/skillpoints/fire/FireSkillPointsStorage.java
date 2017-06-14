package com.kjmaster.mb.skillpoints.fire;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

/**
 * Created by pbill_000 on 07/06/2017.
 */
public class FireSkillPointsStorage implements Capability.IStorage<IFireSkillPoints> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IFireSkillPoints> capability, IFireSkillPoints instance, EnumFacing side) {
        return new NBTTagFloat(instance.getFireSkillPoints());
    }

    @Override
    public void readNBT(Capability<IFireSkillPoints> capability, IFireSkillPoints instance, EnumFacing side, NBTBase nbt) {
        instance.setFire(((NBTPrimitive) nbt).getFloat());
    }
}
