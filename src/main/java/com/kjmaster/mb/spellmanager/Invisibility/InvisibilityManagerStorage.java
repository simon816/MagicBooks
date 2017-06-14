package com.kjmaster.mb.spellmanager.Invisibility;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

/**
 * Created by pbill_000 on 10/06/2017.
 */
public class InvisibilityManagerStorage implements Capability.IStorage<IInvisibilityManager>  {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IInvisibilityManager> capability, IInvisibilityManager instance, EnumFacing side) {
        return new NBTTagFloat(instance.getInvisibility());
    }

    @Override
    public void readNBT(Capability<IInvisibilityManager> capability, IInvisibilityManager instance, EnumFacing side, NBTBase nbt) {
        instance.setInvisibility(((NBTPrimitive) nbt).getFloat());
    }
}
