package com.kjmaster.mb.util.spells;

import com.kjmaster.mb.client.ConfigHandler;
import com.kjmaster.mb.spellmanager.earth.bone.BoneMealManagerProvider;
import com.kjmaster.mb.spellmanager.earth.bone.IBoneMealManager;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by pbill_000 on 25/07/2017.
 */
public class Bonemeal {
    public static void castBonemeal(World world, EntityPlayer player) {
        if (ConfigHandler.isBonemealEnabled) {
            if (!(player.world.isRemote)) {
                IBoneMealManager BONEMEAL_UNLOCKED = player.getCapability(BoneMealManagerProvider.SPELL_MANAGER_CAP, null);
                float BoneMeal = BONEMEAL_UNLOCKED.getBonemeal();
                if (BoneMeal == 1) {
                    RayTraceResult lastPosition = player.rayTrace(100, 1.0F);
                    BlockPos pos = lastPosition.getBlockPos();
                    Block block = player.world.getBlockState(pos).getBlock();
                    if ((block instanceof IGrowable || block instanceof IPlantable)) {
                        for (int i = 0; i < 21; i++) {
                            block.updateTick(player.world, pos, player.world.getBlockState(pos), player.world.rand);
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
