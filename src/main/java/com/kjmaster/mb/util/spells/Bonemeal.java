package com.kjmaster.mb.util.spells;

import com.kjmaster.mb.client.ConfigHandler;
import com.kjmaster.mb.init.ModItems;
import com.kjmaster.mb.items.ItemMagicBook;
import com.kjmaster.mb.spellmanager.earth.bone.BoneMealManagerProvider;
import com.kjmaster.mb.spellmanager.earth.bone.IBoneMealManager;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

/**
 * Created by pbill_000 on 25/07/2017.
 */
public class Bonemeal {
    public static void castBonemeal(World world, EntityPlayer player, ItemStack itemStack) {
        if (ConfigHandler.isBonemealEnabled) {
            if (!(player.world.isRemote)) {
                IBoneMealManager BONEMEAL_UNLOCKED = player.getCapability(BoneMealManagerProvider.SPELL_MANAGER_CAP, null);
                float BoneMeal = BONEMEAL_UNLOCKED.getBonemeal();
                if (BoneMeal == 1) {
                    RayTraceResult lastPosition = player.rayTrace(100, 1.0F);
                    BlockPos pos = lastPosition.getBlockPos();
                    Block block = player.world.getBlockState(pos).getBlock();
                    if ((block instanceof IGrowable || block instanceof IPlantable)) {
                        Item item = itemStack.getItem();
                        if(item.equals(ModItems.MagicBook)) {
                            ItemMagicBook magicBook = (ItemMagicBook) item;
                            if(magicBook.getEarthManaStored(itemStack) >= 100) {
                                magicBook.extractEarthMana(itemStack, 100, false);
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
    }
}
