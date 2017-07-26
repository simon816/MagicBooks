package com.kjmaster.mb.util.spells;

import com.google.common.base.Predicate;
import com.kjmaster.mb.client.ConfigHandler;
import com.kjmaster.mb.spellmanager.air.lightning.ILightningManager;
import com.kjmaster.mb.spellmanager.air.lightning.LightningManagerProvider;
import com.kjmaster.mb.util.LightningCooldown;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

import static com.kjmaster.mb.client.ConfigHandler.configuredLightningCooldown;

/**
 * Created by pbill_000 on 25/07/2017.
 */
public class Lightning {
    public static void castLightning(World world, EntityPlayer player) {
        if(ConfigHandler.isInvisibilityEnabled) {
            if (!(player.world.isRemote)) {
                if (LightningCooldown.LightningCooldown <= 0) {
                    LightningCooldown.LightningCooldown = configuredLightningCooldown;
                    ILightningManager LIGHTNING_UNLOCKED = player.getCapability(LightningManagerProvider.LIGHTNING_MANAGER_CAPABILITY, null);
                    float Lightning = LIGHTNING_UNLOCKED.getLightning();
                    if (Lightning == 1) {
                        player.sendMessage(new TextComponentString(TextFormatting.WHITE + "LIGHTNING BOLT!"));
                        List<BlockPos> blocks = new ArrayList<BlockPos>();
                        int range = 10;
                        for (int x = -range; x < range + 1; x++) {
                            for (int z = -range; z < range + 1; z++) {
                                for (int y = -range; y < range + 1; y++) {
                                    int theX = MathHelper.floor(player.posX + x);
                                    int theY = MathHelper.floor(player.posY + y);
                                    int theZ = MathHelper.floor(player.posZ + z);
                                    BlockPos posInQuestion = new BlockPos(theX, theY, theZ);
                                    blocks.add(posInQuestion);
                                }
                            }
                        }
                        if (!blocks.isEmpty()) {
                            for (int i = 0; i < 45; i++) {
                                for (EntityMob e : world.getEntities(EntityMob.class, new Predicate<EntityMob>() {

                                    @Override
                                    public boolean apply(EntityMob input) {
                                        return (input.getDistanceToEntity(player) <= 20);
                                    }
                                })) {
                                    BlockPos pos = e.getPosition();
                                    double x = pos.getX();
                                    double y = pos.getY();
                                    double z = pos.getZ();
                                    world.addWeatherEffect(new EntityLightningBolt(world, x, y, z, false));

                                }
                            }

                        }
                    } else {
                        player.sendMessage(new TextComponentString(TextFormatting.WHITE + "This spell has not been unlocked!"));
                    }
                } else {
                    player.sendMessage(new TextComponentString(TextFormatting.WHITE + "ticks left on cooldown: " + LightningCooldown.LightningCooldown));
                }
            }
        } else {
            player.sendMessage(new TextComponentString(TextFormatting.WHITE + "This spell has been disabled!"));
        }
    }
}
