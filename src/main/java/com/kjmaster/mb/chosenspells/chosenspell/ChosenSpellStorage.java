package com.kjmaster.mb.chosenspells.chosenspell;

import com.kjmaster.mb.Ref;
import net.minecraft.nbt.*;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

/**
 * Created by pbill_000 on 25/07/2017.
 */
public class ChosenSpellStorage implements Capability.IStorage<IChosenSpell> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IChosenSpell> capability, IChosenSpell instance, EnumFacing side) {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString(Ref.MODID, instance.getChosenSpell());
        return nbt;
    }

    @Override
    public void readNBT(Capability<IChosenSpell> capability, IChosenSpell instance, EnumFacing side, NBTBase nbt) {
        NBTTagCompound tags = (NBTTagCompound) nbt;
        instance.setChosenSpell(tags.getString(Ref.MODID));
    }
}
