package com.kjmaster.mb.chosenspells.chosenspell3;

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
public class ChosenSpell3Storage implements Capability.IStorage<IChosenSpell3> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IChosenSpell3> capability, IChosenSpell3 instance, EnumFacing side) {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString(Ref.MODID, instance.getChosenSpell3());
        return nbt;
    }

    @Override
    public void readNBT(Capability<IChosenSpell3> capability, IChosenSpell3 instance, EnumFacing side, NBTBase nbt) {
        NBTTagCompound tags = (NBTTagCompound) nbt;
        instance.setChosenSpell3(tags.getString(Ref.MODID));
    }
}
