package com.kjmaster.mb.util.spells;

import com.kjmaster.mb.blocks.BlockWalling;
import com.kjmaster.mb.blocks.BlockWallingRune;
import com.kjmaster.mb.client.ConfigHandler;
import com.kjmaster.mb.init.ModItems;
import com.kjmaster.mb.items.ItemMagicBook;
import com.kjmaster.mb.spellmanager.earth.clearwall.ClearWallManagerProvider;
import com.kjmaster.mb.spellmanager.earth.clearwall.IClearWallManager;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

/**
 * Created by pbill_000 on 25/07/2017.
 */
public class ClearWall {
    public static void castClearWall(World world, EntityPlayer player, ItemStack itemStack) {
        if(ConfigHandler.isClearWallEnabled) {
            if (!(player.world.isRemote)) {
                IClearWallManager CLEARWALL_UNLOCKED = player.getCapability(ClearWallManagerProvider.CLEAR_WALL_MANAGER_CAP, null);
                float ClearWall = CLEARWALL_UNLOCKED.getClearWall();
                if (ClearWall == 1) {
                    RayTraceResult lastPosition = player.rayTrace(100, 1.0F);
                    BlockPos pos = lastPosition.getBlockPos();
                    Block block = player.world.getBlockState(pos).getBlock();
                    if ((block instanceof BlockWallingRune)) {
                        Item item = itemStack.getItem();
                        if (item.equals(ModItems.MagicBook)) {
                            ItemMagicBook magicBook = (ItemMagicBook) item;
                            if (magicBook.getEarthManaStored(itemStack) >= 25) {
                                magicBook.extractEarthMana(itemStack, 25, false);
                                double x = pos.getX();
                                double y = pos.getY();
                                double z = pos.getZ();
                                int j = 0;
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x - i, y, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x - i, y, z), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x + i, y, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x + i, y, z), Blocks.AIR.getDefaultState());
                                    }
                                }
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x - i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x + i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    j = 1;
                                }
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x - i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x + i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    j = 2;
                                }
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x - i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x + i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    j = 3;

                                }
                                for (int i = 1; i < 16; i++) {

                                    Block block1 = world.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x - i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x + i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    j = 4;
                                }
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x - i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x + i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    j = 5;
                                }
                                for (int i = 1; i < 16; i++) {

                                    Block block1 = world.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x - i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x + i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    j = 6;

                                }
                                for (int i = 1; i < 16; i++) {

                                    Block block1 = world.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x - i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x + i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    j = 7;
                                }
                                for (int i = 1; i < 16; i++) {

                                    Block block1 = world.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x - i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x + i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    j = 8;
                                }
                                for (int i = 1; i < 16; i++) {

                                    Block block1 = world.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x - i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x + i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    j = 9;
                                }
                                for (int i = 1; i < 16; i++) {

                                    Block block1 = world.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x - i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x + i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    j = 10;
                                }
                                for (int i = 1; i < 16; i++) {

                                    Block block1 = world.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x - i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x + i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    j = 11;
                                }
                                for (int i = 1; i < 16; i++) {

                                    Block block1 = world.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x - i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x + i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    j = 12;
                                }
                                for (int i = 1; i < 16; i++) {

                                    Block block1 = world.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x - i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x + i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    j = 13;
                                }
                                for (int i = 1; i < 16; i++) {

                                    Block block1 = world.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x - i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x + i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    j = 14;
                                }
                                for (int i = 1; i < 16; i++) {

                                    Block block1 = world.getBlockState(new BlockPos(x - i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x - i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x + i, y + j, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x + i, y + j, z), Blocks.AIR.getDefaultState());
                                    }
                                }
                                for (int i = 1; i < 15; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x, y + i, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + i, z), Blocks.AIR.getDefaultState());
                                    }
                                }
                                j = 0;
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x, y, z - i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y, z - i), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x, y, z + i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y, z + i), Blocks.AIR.getDefaultState());
                                    }
                                }
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z - i), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z + i), Blocks.AIR.getDefaultState());
                                    }
                                    j = 1;
                                }
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z - i), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z + i), Blocks.AIR.getDefaultState());
                                    }
                                    j = 2;
                                }
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z - i), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z + i), Blocks.AIR.getDefaultState());
                                    }
                                    j = 3;
                                }
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z - i), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z + i), Blocks.AIR.getDefaultState());
                                    }
                                    j = 4;
                                }
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z - i), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z + i), Blocks.AIR.getDefaultState());
                                    }
                                    j = 5;
                                }
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z - i), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z + i), Blocks.AIR.getDefaultState());
                                    }
                                    j = 6;
                                }
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z - i), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z + i), Blocks.AIR.getDefaultState());
                                    }
                                    j = 7;
                                }
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z - i), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z + i), Blocks.AIR.getDefaultState());
                                    }
                                    j = 8;
                                }
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z - i), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z + i), Blocks.AIR.getDefaultState());
                                    }
                                    j = 9;
                                }
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z - i), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z + i), Blocks.AIR.getDefaultState());
                                    }
                                    j = 10;
                                }
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z - i), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z + i), Blocks.AIR.getDefaultState());
                                    }
                                    j = 11;
                                }
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z - i), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z + i), Blocks.AIR.getDefaultState());
                                    }
                                    j = 12;
                                }
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z - i), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z + i), Blocks.AIR.getDefaultState());
                                    }
                                    j = 13;
                                }
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z - i), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z + i), Blocks.AIR.getDefaultState());
                                    }
                                    j = 14;
                                }
                                for (int i = 1; i < 16; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x, y + j, z - i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z - i), Blocks.AIR.getDefaultState());
                                    }
                                    block1 = world.getBlockState(new BlockPos(x, y + j, z + i)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + j, z + i), Blocks.AIR.getDefaultState());
                                    }
                                }
                                for (int i = 1; i < 15; i++) {
                                    Block block1 = world.getBlockState(new BlockPos(x, y + i, z)).getBlock();
                                    if (block1 instanceof BlockWalling) {
                                        world.setBlockState(new BlockPos(x, y + i, z), Blocks.AIR.getDefaultState());
                                    }
                                }
                            } else {
                                player.sendMessage(new TextComponentString(TextFormatting.GREEN + "Not enough earth mana!"));
                            }
                        }
                    }
                } else {
                    player.sendMessage(new TextComponentString(TextFormatting.GREEN + "This spell has not been unlocked!"));
                }
            }
        } else {
            player.sendMessage(new TextComponentString(TextFormatting.GREEN + "This spell has been disabled!"));
        }
    }
}
