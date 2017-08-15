package com.kjmaster.mb.network;

import com.kjmaster.mb.containers.*;
import com.kjmaster.mb.guis.crystals.GuiAirCrystal;
import com.kjmaster.mb.guis.crystals.GuiEarthCrystal;
import com.kjmaster.mb.guis.crystals.GuiFireCrystal;
import com.kjmaster.mb.guis.crystals.GuiWaterCrystal;
import com.kjmaster.mb.guis.runes.GuiWoodCutRune;
import com.kjmaster.mb.guis.magicbook.GuiMagicBook1;
import com.kjmaster.mb.guis.magicbook.GuiMagicBook2;
import com.kjmaster.mb.guis.spellunlock.GuiAirSpells;
import com.kjmaster.mb.guis.spellunlock.GuiEarthSpells;
import com.kjmaster.mb.guis.spellunlock.GuiFireSpells;
import com.kjmaster.mb.guis.spellunlock.GuiWaterSpells;
import com.kjmaster.mb.tileentities.*;
import com.kjmaster.mb.tileentities.crystals.TileEntityAirCrystal;
import com.kjmaster.mb.tileentities.crystals.TileEntityEarthCrystal;
import com.kjmaster.mb.tileentities.crystals.TileEntityFireCrystal;
import com.kjmaster.mb.tileentities.crystals.TileEntityWaterCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
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
    public static final int MagicBook1 = 4;
    public static final int MagicBook2 = 5;
    public static final int WoodCutRune = 6;
    public static final int EarthCrystal = 7;
    public static final int AirCrystal = 8;
    public static final int FireCrystal = 9;
    public static final int WaterCrystal = 10;
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
        if(ID == MagicBook1)
            return new GuiMagicBook1();
        if(ID == MagicBook2)
            return new GuiMagicBook2();
        if(ID == WoodCutRune)
            return new GuiWoodCutRune(player.inventory, (TileEntityWoodCutRune) world.getTileEntity(new BlockPos(x,y,z) ), world);
        if(ID == EarthCrystal)
            return new GuiEarthCrystal(player.inventory, (TileEntityEarthCrystal) world.getTileEntity(new BlockPos(x,y,z) ), world);
        if(ID == AirCrystal)
            return new GuiAirCrystal(player.inventory, (TileEntityAirCrystal) world.getTileEntity(new BlockPos(x,y,z) ), world);
        if(ID == FireCrystal)
            return new GuiFireCrystal(player.inventory, (TileEntityFireCrystal) world.getTileEntity(new BlockPos(x,y,z) ), world);
        if(ID == WaterCrystal)
            return new GuiWaterCrystal(player.inventory, (TileEntityWaterCrystal) world.getTileEntity(new BlockPos(x,y,z) ), world);

        return null;
    }
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        if (ID == WoodCutRune) {
            return new ContainerWoodCutRune(player.inventory, (TileEntityWoodCutRune) world.getTileEntity(new BlockPos(x,y,z)));
        }
        if (ID == EarthCrystal) {
            return new ContainerEarthCrystal(player.inventory, (TileEntityEarthCrystal) world.getTileEntity(new BlockPos(x,y,z)));
        }
        if (ID == AirCrystal) {
            return new ContainerAirCrystal(player.inventory, (TileEntityAirCrystal) world.getTileEntity(new BlockPos(x,y,z)));
        }
        if (ID == FireCrystal) {
            return new ContainerFireCrystal(player.inventory, (TileEntityFireCrystal) world.getTileEntity(new BlockPos(x,y,z)));
        }
        if (ID == WaterCrystal) {
            return new ContainerWaterCrystal(player.inventory, (TileEntityWaterCrystal) world.getTileEntity(new BlockPos(x,y,z)));
        }
        return null;
    }
}
