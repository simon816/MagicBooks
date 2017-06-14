package com.kjmaster.mb.spellmanager.lightning;

import com.kjmaster.mb.spellmanager.lightning.ILightningManager;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

/**
 * Created by pbill_000 on 10/06/2017.
 */
public class LightningManagerStorage implements Capability.IStorage<ILightningManager>  {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<ILightningManager> capability, ILightningManager instance, EnumFacing side) {
        return new NBTTagFloat(instance.getLightning());
    }

    @Override
    public void readNBT(Capability<ILightningManager> capability, ILightningManager instance, EnumFacing side, NBTBase nbt) {
        instance.setLightning(((NBTPrimitive) nbt).getFloat());
    }
}