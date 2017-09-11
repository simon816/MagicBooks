package com.kjmaster.mb.handlers;

import com.kjmaster.mb.MagicBooks;
import com.kjmaster.mb.blocks.BlockWalling;
import com.kjmaster.mb.blocks.BlockWallingRune;
import com.kjmaster.mb.client.ConfigHandler;
import com.kjmaster.mb.init.ModItems;
import com.kjmaster.mb.items.ItemMagicBook;
import com.kjmaster.mb.network.RayTracePacket;
import com.kjmaster.mb.network.UpdatePointsPacket;
import com.kjmaster.mb.network.mbPacketHandler;
import com.kjmaster.mb.spellmanager.earth.bone.BoneMealManagerProvider;
import com.kjmaster.mb.spellmanager.earth.bone.IBoneMealManager;
import com.kjmaster.mb.spellmanager.earth.clearwall.ClearWallManagerProvider;
import com.kjmaster.mb.spellmanager.earth.clearwall.IClearWallManager;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by pbill_000 on 10/09/2017.
 */
public class RayTracePacketHandler implements IMessageHandler<RayTracePacket, IMessage> {

    @Override
    public IMessage onMessage(RayTracePacket message, MessageContext ctx) {
        MagicBooks.proxy.getThreadFromContext(ctx).addScheduledTask(new Runnable() {
            @Override
            public void run() {
                processMessage(message, ctx);
            }
        });
        return null;
    }

    private void processMessage(RayTracePacket message, MessageContext ctx) {
        String spell = message.spell;
        BlockPos pos = new BlockPos(message.x, message.y, message.z);
        MagicBooks.LOGGER.info(pos.toString());
        EntityPlayer player = MagicBooks.proxy.getPlayerEntity(ctx);
        Block block = player.world.getBlockState(pos).getBlock();
        ItemStack itemStack = message.itemStack;
        World world = player.world;
        switch (spell) {
            case "Bonemeal":
                if (ConfigHandler.isBonemealEnabled) {
                    if (!(player.world.isRemote)) {
                        IBoneMealManager BONEMEAL_UNLOCKED = player.getCapability(BoneMealManagerProvider.SPELL_MANAGER_CAP, null);
                        float BoneMeal = BONEMEAL_UNLOCKED.getBonemeal();
                        if (BoneMeal == 1) {
                            if ((block instanceof IGrowable || block instanceof IPlantable)) {
                                Item item = itemStack.getItem();
                                if(item.equals(ModItems.MagicBook)) {
                                    ItemMagicBook magicBook = (ItemMagicBook) item;
                                    if(magicBook.getEarthManaStored(itemStack) >= 100) {
                                        for (int i = 0; i < 21; i++) {
                                            block.updateTick(player.world, pos, player.world.getBlockState(pos), player.world.rand);
                                        }
                                    } else {
                                        player.sendMessage(new TextComponentString(TextFormatting.GREEN + "You do not have enough earth mana to cast this spell!"));
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
                break;
            case "ClearWall":
                if(ConfigHandler.isClearWallEnabled) {
                    if (!(player.world.isRemote)) {
                        IClearWallManager CLEARWALL_UNLOCKED = player.getCapability(ClearWallManagerProvider.CLEAR_WALL_MANAGER_CAP, null);
                        float ClearWall = CLEARWALL_UNLOCKED.getClearWall();
                        if (ClearWall == 1) {
                            if ((block instanceof BlockWallingRune)) {
                                Item item = itemStack.getItem();
                                if (item.equals(ModItems.MagicBook)) {
                                    ItemMagicBook magicBook = (ItemMagicBook) item;
                                    if (magicBook.getEarthManaStored(itemStack) >= 25) {
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
            default:
                break;
        }
    }
}
