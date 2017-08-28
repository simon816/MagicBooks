package com.kjmaster.mb.items;

import com.kjmaster.mb.tileentities.*;
import com.kjmaster.mb.tileentities.crystals.TileEntityAirCrystal;
import com.kjmaster.mb.tileentities.crystals.TileEntityEarthCrystal;
import com.kjmaster.mb.tileentities.crystals.TileEntityFireCrystal;
import com.kjmaster.mb.tileentities.crystals.TileEntityWaterCrystal;
import com.kjmaster.mb.tileentities.greatercrystals.TileEntityGreaterAirCrystal;
import com.kjmaster.mb.tileentities.greatercrystals.TileEntityGreaterEarthCrystal;
import com.kjmaster.mb.tileentities.greatercrystals.TileEntityGreaterFireCrystal;
import com.kjmaster.mb.tileentities.greatercrystals.TileEntityGreaterWaterCrystal;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

/**
 * Created by pbill_000 on 03/08/2017.
 */
public class ItemCrystalLinker extends ItemBase {
    private BlockPos storedPos = null;
    public ItemCrystalLinker(String name, CreativeTabs tab, int maxSize) {
        super(name, tab, maxSize);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (storedPos != null) {
            if(pos.equals(storedPos) && !worldIn.isRemote) {
                player.sendMessage(new TextComponentString("You cannot connect a crystal to itself!"));
                storedPos = null;
                player.sendMessage(new TextComponentString("Stored position has been deleted"));
            }
            else if (!isInRange(pos, storedPos) && !worldIn.isRemote) {
                player.sendMessage(new TextComponentString("Out of range! (the range is 10)"));
                storedPos = null;
                player.sendMessage(new TextComponentString("Stored position has been deleted"));
            }
            else if(worldIn.getTileEntity(pos) instanceof TileEntityGreaterAirCrystal && !worldIn.isRemote && worldIn.getTileEntity(storedPos) instanceof TileEntityAirCrystal) {
                TileEntityGreaterAirCrystal entityGreaterAirCrystal = (TileEntityGreaterAirCrystal) worldIn.getTileEntity(pos);
                entityGreaterAirCrystal.addConnectedToPos(storedPos.getX(), storedPos.getY(), storedPos.getZ());
                entityGreaterAirCrystal.connections++;
                player.sendMessage(new TextComponentString("This crystal will now send earth mana to: x: " + storedPos.getX() + " y: " + storedPos.getY() + " z: " + storedPos.getZ()));
                storedPos = null;
                player.sendMessage(new TextComponentString("Stored position has been deleted"));
            }
            else if(worldIn.getTileEntity(pos) instanceof TileEntityGreaterEarthCrystal && !worldIn.isRemote && worldIn.getTileEntity(storedPos) instanceof TileEntityEarthCrystal) {
                TileEntityGreaterEarthCrystal entityGreaterEarthCrystal = (TileEntityGreaterEarthCrystal) worldIn.getTileEntity(pos);
                entityGreaterEarthCrystal.addConnectedToPos(storedPos.getX(), storedPos.getY(), storedPos.getZ());
                entityGreaterEarthCrystal.connections++;
                player.sendMessage(new TextComponentString("This crystal will now send earth mana to: x: " + storedPos.getX() + " y: " + storedPos.getY() + " z: " + storedPos.getZ()));
                storedPos = null;
                player.sendMessage(new TextComponentString("Stored position has been deleted"));
            }
            else if(worldIn.getTileEntity(pos) instanceof TileEntityGreaterFireCrystal && !worldIn.isRemote && worldIn.getTileEntity(storedPos) instanceof TileEntityFireCrystal) {
                TileEntityGreaterFireCrystal entityGreaterFireCrystal = (TileEntityGreaterFireCrystal) worldIn.getTileEntity(pos);
                entityGreaterFireCrystal.addConnectedToPos(storedPos.getX(), storedPos.getY(), storedPos.getZ());
                entityGreaterFireCrystal.connections++;
                player.sendMessage(new TextComponentString("This crystal will now send earth mana to: x: " + storedPos.getX() + " y: " + storedPos.getY() + " z: " + storedPos.getZ()));
                storedPos = null;
                player.sendMessage(new TextComponentString("Stored position has been deleted"));
            }
            else if(worldIn.getTileEntity(pos) instanceof TileEntityGreaterWaterCrystal && !worldIn.isRemote && worldIn.getTileEntity(storedPos) instanceof TileEntityWaterCrystal) {
                TileEntityGreaterWaterCrystal entityGreaterWaterCrystal = (TileEntityGreaterWaterCrystal) worldIn.getTileEntity(pos);
                entityGreaterWaterCrystal.addConnectedToPos(storedPos.getX(), storedPos.getY(), storedPos.getZ());
                entityGreaterWaterCrystal.connections++;
                player.sendMessage(new TextComponentString("This crystal will now send earth mana to: x: " + storedPos.getX() + " y: " + storedPos.getY() + " z: " + storedPos.getZ()));
                storedPos = null;
                player.sendMessage(new TextComponentString("Stored position has been deleted"));
            }
            else if(worldIn.getTileEntity(pos) instanceof TileEntityEarthCrystal && !worldIn.isRemote && (worldIn.getTileEntity(storedPos) instanceof TileEntityEarthCrystal || worldIn.getTileEntity(storedPos) instanceof TileEntityWoodCutRune || worldIn.getTileEntity(storedPos) instanceof TileEntityManaInfuser))  {
                TileEntityEarthCrystal entityEarthCrystal = (TileEntityEarthCrystal) worldIn.getTileEntity(pos);
                if (!(entityEarthCrystal.getHasConnection())) {
                    entityEarthCrystal.setConnectedToPos(storedPos);
                    entityEarthCrystal.setHasConnection(true);
                    player.sendMessage(new TextComponentString("This crystal will now send earth mana to: x: " + storedPos.getX() + " y: " + storedPos.getY() + " z: " + storedPos.getZ()));
                    storedPos = null;
                    player.sendMessage(new TextComponentString("Stored position has been deleted"));
                }
            }
            else if (worldIn.getTileEntity(pos) instanceof TileEntityAirCrystal && !worldIn.isRemote && (worldIn.getTileEntity(storedPos) instanceof TileEntityAirCrystal || worldIn.getTileEntity(storedPos) instanceof TileEntityManaInfuser)) {
                TileEntityAirCrystal entityAirCrystal = (TileEntityAirCrystal) worldIn.getTileEntity(pos);
                if (!(entityAirCrystal.getHasConnection())) {
                    entityAirCrystal.setConnectedToPos(storedPos);
                    entityAirCrystal.setHasConnection(true);
                    player.sendMessage(new TextComponentString("This crystal will now send air mana to: x: " + storedPos.getX() + " y: " + storedPos.getY() + " z: " + storedPos.getZ()));
                    storedPos = null;
                    player.sendMessage(new TextComponentString("Stored position has been deleted"));
                }
            }
            else if (worldIn.getTileEntity(pos) instanceof TileEntityFireCrystal && !worldIn.isRemote && (worldIn.getTileEntity(storedPos) instanceof TileEntityFireCrystal || worldIn.getTileEntity(storedPos) instanceof TileEntityManaInfuser)) {
                TileEntityFireCrystal entityFireCrystal = (TileEntityFireCrystal) worldIn.getTileEntity(pos);
                if (!(entityFireCrystal.getHasConnection())) {
                    entityFireCrystal.setConnectedToPos(storedPos);
                    entityFireCrystal.setHasConnection(true);
                    player.sendMessage(new TextComponentString("This crystal will now send fire mana to: x: " + storedPos.getX() + " y: " + storedPos.getY() + " z: " + storedPos.getZ()));
                    storedPos = null;
                    player.sendMessage(new TextComponentString("Stored position has been deleted"));
                }
            }
            else if (worldIn.getTileEntity(pos) instanceof TileEntityWaterCrystal && !worldIn.isRemote && (worldIn.getTileEntity(storedPos) instanceof TileEntityWaterCrystal || worldIn.getTileEntity(storedPos) instanceof TileEntityManaInfuser)) {
                TileEntityWaterCrystal entityWaterCrystal = (TileEntityWaterCrystal) worldIn.getTileEntity(pos);
                if (!(entityWaterCrystal.getHasConnection())) {
                    entityWaterCrystal.setConnectedToPos(storedPos);
                    entityWaterCrystal.setHasConnection(true);
                    player.sendMessage(new TextComponentString("This crystal will now send water mana to: x: " + storedPos.getX() + " y: " + storedPos.getY() + " z: " + storedPos.getZ()));
                    storedPos = null;
                    player.sendMessage(new TextComponentString("Stored position has been deleted"));
                }
            }
        } else if (worldIn.getTileEntity(pos) instanceof TileEntityEarthCrystal && !worldIn.isRemote) {
            TileEntityEarthCrystal entityEarthCrystal = (TileEntityEarthCrystal) worldIn.getTileEntity(pos);
            storedPos = pos;
            player.sendMessage(new TextComponentString("Position stored as x: " + pos.getX() + " y: " + pos.getY() + " z: " + pos.getZ()));
        } else if (worldIn.getTileEntity(pos) instanceof TileEntityWoodCutRune && !worldIn.isRemote) {
            TileEntityWoodCutRune entityWoodCutRune = (TileEntityWoodCutRune) worldIn.getTileEntity(pos);
            storedPos = pos;
            player.sendMessage(new TextComponentString("Position stored as x: " + pos.getX() + " y: " + pos.getY() + " z: " + pos.getZ()));
        } else if (worldIn.getTileEntity(pos) instanceof TileEntityAirCrystal && !worldIn.isRemote) {
            TileEntityAirCrystal entityAirCrystal = (TileEntityAirCrystal) worldIn.getTileEntity(pos);
            storedPos = pos;
            player.sendMessage(new TextComponentString("Position stored as x: " + pos.getX() + " y: " + pos.getY() + " z: " + pos.getZ()));
        } else if (worldIn.getTileEntity(pos) instanceof TileEntityFireCrystal && !worldIn.isRemote) {
            TileEntityFireCrystal entityFireCrystal = (TileEntityFireCrystal) worldIn.getTileEntity(pos);
            storedPos = pos;
            player.sendMessage(new TextComponentString("Position stored as x: " + pos.getX() + " y: " + pos.getY() + " z: " + pos.getZ()));
        } else if (worldIn.getTileEntity(pos) instanceof TileEntityWaterCrystal && !worldIn.isRemote) {
            TileEntityWaterCrystal entityWaterCrystal = (TileEntityWaterCrystal) worldIn.getTileEntity(pos);
            storedPos = pos;
            player.sendMessage(new TextComponentString("Position stored as x: " + pos.getX() + " y: " + pos.getY() + " z: " + pos.getZ()));
        } else if (worldIn.getTileEntity(pos) instanceof TileEntityManaInfuser && !worldIn.isRemote) {
            TileEntityManaInfuser entityManaInfuser = (TileEntityManaInfuser) worldIn.getTileEntity(pos);
            storedPos = pos;
            player.sendMessage(new TextComponentString("Position stored as x: " + pos.getX() + " y: " + pos.getY() + " z: " + pos.getZ()));
        }
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }

    public boolean isInRange(BlockPos pos, BlockPos storedPos) {
        if(pos.getX() - storedPos.getX() > 10)
            return false;
        else if (pos.getY() - storedPos.getY() > 10)
            return false;
        else if (pos.getZ() - storedPos.getZ() > 10)
            return false;
        else if (storedPos.getX() - pos.getX() > 10)
            return false;
        else if (storedPos.getY() - pos.getY() > 10)
            return false;
        else if (storedPos.getZ() - pos.getZ() > 10)
            return false;
        else
            return true;
    }
}
