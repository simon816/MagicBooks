package com.kjmaster.mb.spellmanager.fireblast;


import akka.japi.pf.FI;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Created by pbill_000 on 12/06/2017.
 */
public class FireBlastManagerProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IFireBlastManager.class)
    public static final Capability<IFireBlastManager> FIREBLAST_MANAGER_CAP = null;

    private IFireBlastManager FireBlastSpellinstance = FIREBLAST_MANAGER_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == FIREBLAST_MANAGER_CAP;

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == FIREBLAST_MANAGER_CAP ? FIREBLAST_MANAGER_CAP.<T>cast(this.FireBlastSpellinstance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return FIREBLAST_MANAGER_CAP.getStorage().writeNBT(FIREBLAST_MANAGER_CAP, this.FireBlastSpellinstance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        FIREBLAST_MANAGER_CAP.getStorage().readNBT(FIREBLAST_MANAGER_CAP, this.FireBlastSpellinstance, null, nbt);
    }
}