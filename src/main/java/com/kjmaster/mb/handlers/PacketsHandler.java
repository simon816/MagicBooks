package com.kjmaster.mb.handlers;

import com.google.common.base.Predicate;
import com.kjmaster.mb.entities.WaterGolem;
import com.kjmaster.mb.network.PointsPacket;
import com.kjmaster.mb.skillpoints.air.AirSkillPointsProvider;
import com.kjmaster.mb.skillpoints.earth.EarthSkillPointsProvider;
import com.kjmaster.mb.skillpoints.air.IAirSkillPoints;
import com.kjmaster.mb.skillpoints.earth.IEarthSkillPoints;
import com.kjmaster.mb.skillpoints.fire.FireSkillPointsProvider;
import com.kjmaster.mb.skillpoints.fire.IFireSkillPoints;
import com.kjmaster.mb.spellmanager.earth.bone.IBoneMealManager;
import com.kjmaster.mb.spellmanager.earth.bone.BoneMealManagerProvider;
import com.kjmaster.mb.spellmanager.air.Invisibility.IInvisibilityManager;
import com.kjmaster.mb.spellmanager.air.Invisibility.InvisibilityManagerProvider;
import com.kjmaster.mb.spellmanager.fire.fireblast.FireBlastManagerProvider;
import com.kjmaster.mb.spellmanager.fire.fireblast.IFireBlastManager;
import com.kjmaster.mb.spellmanager.air.lightning.ILightningManager;
import com.kjmaster.mb.spellmanager.air.lightning.LightningManagerProvider;
import com.kjmaster.mb.util.LightningCooldown;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.*;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pbill_000 on 07/06/2017.
 */
public class PacketsHandler implements IMessageHandler<PointsPacket, IMessage> {
    @Override
    public IMessage onMessage(PointsPacket message, MessageContext ctx) {
        EntityPlayerMP serverPlayer = ctx.getServerHandler().playerEntity;
        float amount = message.toSend;
        if (amount == 1) {
            IBoneMealManager BONEMEAL_UNLOCKED = serverPlayer.getCapability(BoneMealManagerProvider.SPELL_MANAGER_CAP, null);
            float BoneMeal = BONEMEAL_UNLOCKED.getBonemeal();
            IEarthSkillPoints earthSkillPoints = serverPlayer.getCapability(EarthSkillPointsProvider.EARTHSKILLPOINTS_CAP, null);
            float points = earthSkillPoints.getEarthSkillPoints();
            if (points < 4 && BoneMeal == 0 ) {
                serverPlayer.sendMessage(new TextComponentString(TextFormatting.GREEN + "You need 4 earth skill points for this spell!"));

            } else {
                if (BoneMeal == 0) {
                    BONEMEAL_UNLOCKED.addBonemeal(1);
                    IEarthSkillPoints earthSkillPoints2 = serverPlayer.getCapability(EarthSkillPointsProvider.EARTHSKILLPOINTS_CAP, null);
                    earthSkillPoints2.consumeEarth(4);
                    float points2 = earthSkillPoints2.getEarthSkillPoints();
                    float BoneMeal2 = BONEMEAL_UNLOCKED.getBonemeal();
                    if (BoneMeal2 == 1) {
                        serverPlayer.sendMessage(new TextComponentString(TextFormatting.GREEN + "You unlocked the bonemeal spell!"));
                        serverPlayer.sendMessage(new TextComponentString(TextFormatting.GREEN + "You now have " + points2 + " earth skill points"));
                    }

                }
            }
        }
        if (amount == 2) {
            IBoneMealManager BONEMEAL_UNLOCKED = serverPlayer.getCapability(BoneMealManagerProvider.SPELL_MANAGER_CAP, null);
            float BoneMeal = BONEMEAL_UNLOCKED.getBonemeal();
            if (BoneMeal == 1) {
                RayTraceResult lastPosition = serverPlayer.rayTrace(100, 1.0F);
                BlockPos pos = lastPosition.getBlockPos();
                Block block = serverPlayer.world.getBlockState(pos).getBlock();
                if ((block instanceof IGrowable || block instanceof IPlantable)) {
                    for (int i = 0; i < 21; i++) {
                        block.updateTick(serverPlayer.world, pos, serverPlayer.world.getBlockState(pos), serverPlayer.world.rand);
                    }


                }
            }
        }
        if (amount == 3) {
            IInvisibilityManager INVIS_UNLOCKED = serverPlayer.getCapability(InvisibilityManagerProvider.INVISIBILITY_MANAGER_CAP, null);
            float Invis = INVIS_UNLOCKED.getInvisibility();
            IAirSkillPoints airSkillPoints = serverPlayer.getCapability(AirSkillPointsProvider.AIRSKILLPOINTS_CAP, null);
            float points = airSkillPoints.getAirSkillPoints();
            if (points < 8 && Invis == 0) {
                serverPlayer.sendMessage(new TextComponentString(TextFormatting.WHITE + "You need 8 air skill points for this spell!"));

            } else {
                if (Invis == 0) {
                    INVIS_UNLOCKED.addInvisibility(1);
                    IAirSkillPoints airSkillPoints1 = serverPlayer.getCapability(AirSkillPointsProvider.AIRSKILLPOINTS_CAP, null);
                    airSkillPoints1.consumeAir(8);
                    float points2 = airSkillPoints1.getAirSkillPoints();
                    float Invis2 = INVIS_UNLOCKED.getInvisibility();
                    if (Invis2 == 1) {
                        serverPlayer.sendMessage(new TextComponentString(TextFormatting.WHITE + "You unlocked the invisibility spell!"));
                        serverPlayer.sendMessage(new TextComponentString(TextFormatting.WHITE + "You now have " + points2 + " air skill points"));
                    }

                }
            }

        }
        if (amount == 4) {
            IInvisibilityManager INVIS_UNLOCKED = serverPlayer.getCapability(InvisibilityManagerProvider.INVISIBILITY_MANAGER_CAP, null);
            float Invis = INVIS_UNLOCKED.getInvisibility();
            if (Invis == 1) {
                if (serverPlayer.isInvisible()) {
                    serverPlayer.setInvisible(false);
                } else {
                    serverPlayer.setInvisible(true);
                }

            }

        }
        if (amount == 5) {
            IAirSkillPoints airSkillPoints = serverPlayer.getCapability(AirSkillPointsProvider.AIRSKILLPOINTS_CAP, null);
            float points = airSkillPoints.getAirSkillPoints();
            ILightningManager LIGHTNING_UNLOCKED = serverPlayer.getCapability(LightningManagerProvider.LIGHTNING_MANAGER_CAPABILITY, null);
            float Lightning = LIGHTNING_UNLOCKED.getLightning();
            if (points < 16 && Lightning == 0) {
                serverPlayer.sendMessage(new TextComponentString(TextFormatting.WHITE + "You need 16 air skill points for this spell!"));

            } else {
                if (Lightning == 0) {
                    LIGHTNING_UNLOCKED.addLightning(1);
                    IAirSkillPoints airSkillPoints1 = serverPlayer.getCapability(AirSkillPointsProvider.AIRSKILLPOINTS_CAP, null);
                    airSkillPoints1.consumeAir(16);
                    float points2 = airSkillPoints1.getAirSkillPoints();
                    float Lightning2 = LIGHTNING_UNLOCKED.getLightning();
                    if (Lightning2 == 1) {
                        serverPlayer.sendMessage(new TextComponentString(TextFormatting.WHITE + "You unlocked the lightning spell!"));
                        serverPlayer.sendMessage(new TextComponentString(TextFormatting.WHITE + "You now have " + points2 + " air skill points"));
                    }

                }
            }

        }
        if (amount == 6) {
                if (LightningCooldown.LightningCooldown <= 0) {
                    LightningCooldown.LightningCooldown = 600;
                    ILightningManager LIGHTNING_UNLOCKED = serverPlayer.getCapability(LightningManagerProvider.LIGHTNING_MANAGER_CAPABILITY, null);
                    float Lightning = LIGHTNING_UNLOCKED.getLightning();
                    if (Lightning == 1) {
                        serverPlayer.sendMessage(new TextComponentString(TextFormatting.WHITE + "LIGHTNING BOLT!"));
                        List<BlockPos> blocks = new ArrayList<BlockPos>();
                        int range = 10;
                        for (int x = -range; x < range + 1; x++) {
                            for (int z = -range; z < range + 1; z++) {
                                for (int y = -range; y < range + 1; y++) {
                                    int theX = MathHelper.floor(serverPlayer.posX + x);
                                    int theY = MathHelper.floor(serverPlayer.posY + y);
                                    int theZ = MathHelper.floor(serverPlayer.posZ + z);
                                    BlockPos posInQuestion = new BlockPos(theX, theY, theZ);
                                    blocks.add(posInQuestion);
                                }
                            }
                        }
                        if (!blocks.isEmpty()) {
                            for(int i = 0; i < 45; i++){
                                World world = serverPlayer.world;
                                for (EntityMob e:world.getEntities(EntityMob.class, new Predicate<EntityMob>() {

                                    @Override
                                    public boolean apply(EntityMob input) {
                                        return (input.getDistanceToEntity(serverPlayer) <= 20);
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
                    }

                }else{
                    serverPlayer.sendMessage(new TextComponentString(TextFormatting.WHITE + "ticks left on cooldown: " + LightningCooldown.LightningCooldown));
                }
            }



        if (amount == 7) {
            IFireSkillPoints fireSkillPoints = serverPlayer.getCapability(FireSkillPointsProvider.FIRESKILLPOINTS_CAP, null);
            float points = fireSkillPoints.getFireSkillPoints();
            IFireBlastManager FIREBLAST_UNLOCKED = serverPlayer.getCapability(FireBlastManagerProvider.FIREBLAST_MANAGER_CAP, null);
            float FireBlast = FIREBLAST_UNLOCKED.getFireBlast();
            if (points < 16 && FireBlast == 0) {
                serverPlayer.sendMessage(new TextComponentString(TextFormatting.RED + "You need 16 fire skill points for this spell!"));

            } else {
                if (FireBlast == 0) {
                    FIREBLAST_UNLOCKED.addFireBlast(1);
                    IFireSkillPoints fireSkillPoints1 = serverPlayer.getCapability(FireSkillPointsProvider.FIRESKILLPOINTS_CAP, null);
                    fireSkillPoints1.consumeFire(16);
                    float points2 = fireSkillPoints1.getFireSkillPoints();
                    float FireBlast2 = FIREBLAST_UNLOCKED.getFireBlast();
                    if (FireBlast2 == 1) {
                        serverPlayer.sendMessage(new TextComponentString(TextFormatting.RED + "You unlocked the fire blast spell!"));
                        serverPlayer.sendMessage(new TextComponentString(TextFormatting.RED + "You now have " + points2 + " fire skill points"));
                    }

                }
            }

        }
        if (amount == 8) {
            IFireBlastManager FIREBLAST_UNLOCKED = serverPlayer.getCapability(FireBlastManagerProvider.FIREBLAST_MANAGER_CAP, null);
            float FireBlast = FIREBLAST_UNLOCKED.getFireBlast();
            if (FireBlast == 1) {
                serverPlayer.sendMessage(new TextComponentString(TextFormatting.RED + "FIRE BLAST!"));
                EntityPlayer player = serverPlayer;
                World world2 = serverPlayer.getServerWorld();
                World world = player.world;
                WaterGolem waterGolem = new WaterGolem(world2);
                waterGolem.setLocationAndAngles(serverPlayer.posX, serverPlayer.posY, serverPlayer.posZ, 0F, 0F);
                world2.spawnEntity(waterGolem);
                List<BlockPos> blocks = new ArrayList<BlockPos>();
                int range = 10;
                for (int x = -range; x < range + 1; x++) {
                    for (int z = -range; z < range + 1; z++) {
                        for (int y = -range; y < range + 1; y++) {
                            int theX = MathHelper.floor(serverPlayer.posX + x);
                            int theY = MathHelper.floor(serverPlayer.posY + y);
                            int theZ = MathHelper.floor(serverPlayer.posZ + z);
                            BlockPos posInQuestion = new BlockPos(theX, theY, theZ);
                            blocks.add(posInQuestion);
                        }
                    }
                }
                if (!blocks.isEmpty()) {
                    for(int i = 0; i < 45; i++){
                        for (EntityMob e:world.getEntities(EntityMob.class, new Predicate<EntityMob>() {

                            @Override
                            public boolean apply(EntityMob input) {
                                return (input.getDistanceToEntity(serverPlayer) <= 20);
                            }
                        })) {
                            BlockPos pos = e.getPosition();
                            double x = pos.getX();
                            double y = pos.getY();
                            double z = pos.getZ();
                            e.setFire(20);
                            e.attackEntityFrom(new DamageSource("magic"), 2F);

                        }
                    }

                }
            }
        }
        return null;
    }
}

