package com.kjmaster.mb.spellmanager.earth.clearwall;

import com.kjmaster.mb.spellmanager.earth.spawnwallingrune.ISpawnWallingRuneManager;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

/**
 * Created by pbill_000 on 23/06/2017.
 */
public class ClearWallManagerStorage implements Capability.IStorage<IClearWallManager> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IClearWallManager> capability, IClearWallManager instance, EnumFacing side) {
        return new NBTTagFloat(instance.getClearWall());
    }

    @Override
    public void readNBT(Capability<IClearWallManager> capability, IClearWallManager instance, EnumFacing side, NBTBase nbt) {
        instance.setClearWall(((NBTPrimitive) nbt).getFloat());
    }
}
