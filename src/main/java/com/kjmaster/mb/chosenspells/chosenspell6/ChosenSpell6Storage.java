package com.kjmaster.mb.chosenspells.chosenspell6;

import com.kjmaster.mb.Ref;
import com.kjmaster.mb.chosenspells.chosenspell2.IChosenSpell2;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

/**
 * Created by pbill_000 on 26/07/2017.
 */
public class ChosenSpell6Storage implements Capability.IStorage<IChosenSpell6> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IChosenSpell6> capability, IChosenSpell6 instance, EnumFacing side) {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString(Ref.MODID, instance.getChosenSpell6());
        return nbt;
    }

    @Override
    public void readNBT(Capability<IChosenSpell6> capability, IChosenSpell6 instance, EnumFacing side, NBTBase nbt) {
        NBTTagCompound tags = (NBTTagCompound) nbt;
        instance.setChosenSpell6(tags.getString(Ref.MODID));
    }
}
