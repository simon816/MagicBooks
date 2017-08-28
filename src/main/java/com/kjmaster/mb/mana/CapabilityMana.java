package com.kjmaster.mb.mana;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nullable;

/**
 * Created by pbill_000 on 03/08/2017.
 */
public class CapabilityMana implements ICapabilitySerializable<NBTBase>{
    @CapabilityInject(IManaStorage.class)
    public static Capability<IManaStorage> MANA = null;
    private IManaStorage instance = MANA.getDefaultInstance();
    public static int capacity = 0;
    public CapabilityMana(int capacity) {
        this.capacity = capacity;
    }
    public static void register()
    {
        CapabilityManager.INSTANCE.register(IManaStorage.class, new IStorage<IManaStorage>()
                {
                    @Override
                    public NBTBase writeNBT(Capability<IManaStorage> capability, IManaStorage instance, EnumFacing side)
                    {
                        return new NBTTagInt(instance.getManaStored());
                    }

                    @Override
                    public void readNBT(Capability<IManaStorage> capability, IManaStorage instance, EnumFacing side, NBTBase nbt)
                    {
                        if (!(instance instanceof ManaStorage))
                            throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");
                        ((ManaStorage)instance).mana = ((NBTTagInt)nbt).getInt();
                    }
                },
                () -> new ManaStorage(capacity));
    }
    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == MANA;

    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == MANA ? MANA.<T>cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return MANA.getStorage().writeNBT(MANA, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        MANA.getStorage().readNBT(MANA, this.instance, null, nbt);
    }
}