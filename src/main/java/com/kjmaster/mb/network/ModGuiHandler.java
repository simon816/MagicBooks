package com.kjmaster.mb.network;

import com.kjmaster.mb.guis.GuiAirSpells;
import com.kjmaster.mb.guis.GuiEarthSpells;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

/**
 * Created by pbill_000 on 07/06/2017.
 */
public class ModGuiHandler implements IGuiHandler {
    public static final int EarthSpells = 0;
    public static final int AirSpells = 1;
    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == EarthSpells)
            return new GuiEarthSpells();
        if(ID == AirSpells)
            return new GuiAirSpells();
        return null;
    }

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        return null;
    }
}
