package com.kjmaster.mb.spellmanager.Invisibility;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**
 * Created by pbill_000 on 10/06/2017.
 */
public class InvisibilityManagerProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IInvisibilityManager.class)
    public static final Capability<IInvisibilityManager> INVISIBILITY_MANAGER_CAP = null;

    private IInvisibilityManager InvisibilitySpellinstance = INVISIBILITY_MANAGER_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == INVISIBILITY_MANAGER_CAP;

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == INVISIBILITY_MANAGER_CAP ? INVISIBILITY_MANAGER_CAP.<T>cast(this.InvisibilitySpellinstance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return INVISIBILITY_MANAGER_CAP.getStorage().writeNBT(INVISIBILITY_MANAGER_CAP, this.InvisibilitySpellinstance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        INVISIBILITY_MANAGER_CAP.getStorage().readNBT(INVISIBILITY_MANAGER_CAP, this.InvisibilitySpellinstance, null, nbt);
    }
}