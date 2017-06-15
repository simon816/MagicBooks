package com.kjmaster.mb.spellmanager.fire.fireblast;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

/**
 * Created by pbill_000 on 12/06/2017.
 */
public class FireBlastManagerStorage implements Capability.IStorage<IFireBlastManager>  {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IFireBlastManager> capability, IFireBlastManager instance, EnumFacing side) {
        return new NBTTagFloat(instance.getFireBlast());
    }

    @Override
    public void readNBT(Capability<IFireBlastManager> capability, IFireBlastManager instance, EnumFacing side, NBTBase nbt) {
        instance.setFireBlast(((NBTPrimitive) nbt).getFloat());
    }
}