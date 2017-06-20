package com.kjmaster.mb.network;

import com.kjmaster.mb.guis.GuiAirSpells;
import com.kjmaster.mb.guis.GuiEarthSpells;
import com.kjmaster.mb.guis.GuiFireSpells;
import com.kjmaster.mb.guis.GuiWaterSpells;
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
    public static final int FireSpells = 2;
    public static final int WaterSpells = 3;
    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == EarthSpells)
            return new GuiEarthSpells();
        if(ID == AirSpells)
            return new GuiAirSpells();
        if(ID == FireSpells)
            return new GuiFireSpells();
        if(ID == WaterSpells)
            return new GuiWaterSpells();
        return null;
    }

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        return null;
    }
}
