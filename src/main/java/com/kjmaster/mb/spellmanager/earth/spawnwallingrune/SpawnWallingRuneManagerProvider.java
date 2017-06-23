package com.kjmaster.mb.spellmanager.earth.spawnwallingrune;

import com.kjmaster.mb.spellmanager.earth.spawnwallingrune.ISpawnWallingRuneManager;
import com.kjmaster.mb.spellmanager.water.waterwolf.WaterWolfManager;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Created by pbill_000 on 21/06/2017.
 */
public class SpawnWallingRuneManagerProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(ISpawnWallingRuneManager.class)
    public static final Capability<ISpawnWallingRuneManager> WALLING_RUNE_MANAGER_CAP = null;

    private ISpawnWallingRuneManager WallingRuneinstance = WALLING_RUNE_MANAGER_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == WALLING_RUNE_MANAGER_CAP;

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == WALLING_RUNE_MANAGER_CAP ? WALLING_RUNE_MANAGER_CAP.<T>cast(this.WallingRuneinstance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return WALLING_RUNE_MANAGER_CAP.getStorage().writeNBT(WALLING_RUNE_MANAGER_CAP, this.WallingRuneinstance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        WALLING_RUNE_MANAGER_CAP.getStorage().readNBT(WALLING_RUNE_MANAGER_CAP, this.WallingRuneinstance, null, nbt);
    }
}
