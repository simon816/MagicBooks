package com.kjmaster.mb.spellmanager.water.waterwolf;

import com.kjmaster.mb.spellmanager.water.waterwolf.IWaterWolfManager;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Created by pbill_000 on 18/06/2017.
 */

public class WaterWolfManagerProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IWaterWolfManager.class)
    public static final Capability<IWaterWolfManager> WATERWOLF_MANAGER_CAP = null;

    private IWaterWolfManager WaterWolfSpellinstance = WATERWOLF_MANAGER_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == WATERWOLF_MANAGER_CAP;

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == WATERWOLF_MANAGER_CAP ? WATERWOLF_MANAGER_CAP.<T>cast(this.WaterWolfSpellinstance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return WATERWOLF_MANAGER_CAP.getStorage().writeNBT(WATERWOLF_MANAGER_CAP, this.WaterWolfSpellinstance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        WATERWOLF_MANAGER_CAP.getStorage().readNBT(WATERWOLF_MANAGER_CAP, this.WaterWolfSpellinstance, null, nbt);
    }
}