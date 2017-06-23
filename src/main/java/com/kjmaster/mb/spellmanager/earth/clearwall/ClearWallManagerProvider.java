package com.kjmaster.mb.spellmanager.earth.clearwall;

import com.kjmaster.mb.spellmanager.earth.spawnwallingrune.ISpawnWallingRuneManager;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Created by pbill_000 on 23/06/2017.
 */
public class ClearWallManagerProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IClearWallManager.class)
    public static final Capability<IClearWallManager> CLEAR_WALL_MANAGER_CAP = null;

    private IClearWallManager ClearWallinstance = CLEAR_WALL_MANAGER_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == CLEAR_WALL_MANAGER_CAP;

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == CLEAR_WALL_MANAGER_CAP ? CLEAR_WALL_MANAGER_CAP.<T>cast(this.ClearWallinstance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return CLEAR_WALL_MANAGER_CAP.getStorage().writeNBT(CLEAR_WALL_MANAGER_CAP, this.ClearWallinstance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        CLEAR_WALL_MANAGER_CAP.getStorage().readNBT(CLEAR_WALL_MANAGER_CAP, this.ClearWallinstance, null, nbt);
    }
}
