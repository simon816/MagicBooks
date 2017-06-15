package com.kjmaster.mb.spellmanager.earth.bone;

import net.minecraft.nbt.*;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

/**
 * Created by pbill_000 on 08/06/2017.
 */
public class BoneMealManagerStorage implements Capability.IStorage<IBoneMealManager> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IBoneMealManager> capability, IBoneMealManager instance, EnumFacing side) {
        return new NBTTagFloat (instance.getBonemeal());
    }

    @Override
    public void readNBT(Capability<IBoneMealManager> capability, IBoneMealManager instance, EnumFacing side, NBTBase nbt) {
        instance.setBonemeal(((NBTPrimitive) nbt).getFloat());
    }
}
