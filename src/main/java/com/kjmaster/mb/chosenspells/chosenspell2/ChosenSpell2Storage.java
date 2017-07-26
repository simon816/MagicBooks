package com.kjmaster.mb.chosenspells.chosenspell2;

import com.kjmaster.mb.Ref;
import com.kjmaster.mb.chosenspells.chosenspell.IChosenSpell;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

/**
 * Created by pbill_000 on 25/07/2017.
 */
public class ChosenSpell2Storage implements Capability.IStorage<IChosenSpell2> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IChosenSpell2> capability, IChosenSpell2 instance, EnumFacing side) {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString(Ref.MODID, instance.getChosenSpell2());
        return nbt;
    }

    @Override
    public void readNBT(Capability<IChosenSpell2> capability, IChosenSpell2 instance, EnumFacing side, NBTBase nbt) {
        NBTTagCompound tags = (NBTTagCompound) nbt;
        instance.setChosenSpell2(tags.getString(Ref.MODID));
    }
}
