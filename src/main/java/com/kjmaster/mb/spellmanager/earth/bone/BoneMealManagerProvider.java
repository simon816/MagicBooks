package com.kjmaster.mb.spellmanager.earth.bone;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Created by pbill_000 on 08/06/2017.
 */
public class BoneMealManagerProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IBoneMealManager.class)
    public static final Capability<IBoneMealManager> SPELL_MANAGER_CAP = null;

    private IBoneMealManager Spellinstance = SPELL_MANAGER_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == SPELL_MANAGER_CAP;

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == SPELL_MANAGER_CAP ? SPELL_MANAGER_CAP.<T>cast(this.Spellinstance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return SPELL_MANAGER_CAP.getStorage().writeNBT(SPELL_MANAGER_CAP, this.Spellinstance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        SPELL_MANAGER_CAP.getStorage().readNBT(SPELL_MANAGER_CAP, this.Spellinstance, null, nbt);
    }
}
