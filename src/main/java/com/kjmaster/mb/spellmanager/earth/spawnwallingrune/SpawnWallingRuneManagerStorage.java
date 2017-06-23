package com.kjmaster.mb.spellmanager.earth.spawnwallingrune;

import com.kjmaster.mb.spellmanager.earth.bone.IBoneMealManager;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

/**
 * Created by pbill_000 on 21/06/2017.
 */
public class SpawnWallingRuneManagerStorage implements Capability.IStorage<ISpawnWallingRuneManager> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<ISpawnWallingRuneManager> capability, ISpawnWallingRuneManager instance, EnumFacing side) {
        return new NBTTagFloat(instance.getWallingRune());
    }

    @Override
    public void readNBT(Capability<ISpawnWallingRuneManager> capability, ISpawnWallingRuneManager instance, EnumFacing side, NBTBase nbt) {
        instance.setWallingRune(((NBTPrimitive) nbt).getFloat());
    }
}
