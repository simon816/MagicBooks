package com.kjmaster.mb.spellmanager.water.waterwolf;

import com.kjmaster.mb.spellmanager.water.waterwolf.IWaterWolfManager;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

/**
 * Created by pbill_000 on 18/06/2017.
 */
public class WaterWolfManagerStorage implements Capability.IStorage<IWaterWolfManager>  {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IWaterWolfManager> capability, IWaterWolfManager instance, EnumFacing side) {
        return new NBTTagFloat(instance.getWaterWolf());
    }

    @Override
    public void readNBT(Capability<IWaterWolfManager> capability, IWaterWolfManager instance, EnumFacing side, NBTBase nbt) {
        instance.setWaterWolf(((NBTPrimitive) nbt).getFloat());
    }
}
