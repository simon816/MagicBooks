package com.kjmaster.mb.spellmanager.lightning;

import com.kjmaster.mb.spellmanager.lightning.ILightningManager;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Created by pbill_000 on 10/06/2017.
 */
public class LightningManagerProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(ILightningManager.class)
    public static final Capability<ILightningManager> LIGHTNING_MANAGER_CAPABILITY = null;

    private ILightningManager LightningSpellinstance = LIGHTNING_MANAGER_CAPABILITY.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == LIGHTNING_MANAGER_CAPABILITY;

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == LIGHTNING_MANAGER_CAPABILITY ? LIGHTNING_MANAGER_CAPABILITY.<T>cast(this.LightningSpellinstance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return LIGHTNING_MANAGER_CAPABILITY.getStorage().writeNBT(LIGHTNING_MANAGER_CAPABILITY, this.LightningSpellinstance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        LIGHTNING_MANAGER_CAPABILITY.getStorage().readNBT(LIGHTNING_MANAGER_CAPABILITY, this.LightningSpellinstance, null, nbt);
    }
}
