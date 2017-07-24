package com.kjmaster.mb.handlers;

import com.google.common.base.Predicate;
import com.kjmaster.mb.blocks.BlockWallingRune;
import com.kjmaster.mb.entities.WaterWolf;
import com.kjmaster.mb.guis.GuiAirSpells;
import com.kjmaster.mb.guis.GuiEarthSpells;
import com.kjmaster.mb.guis.GuiFireSpells;
import com.kjmaster.mb.guis.GuiWaterSpells;
import com.kjmaster.mb.init.ModBlocks;
import com.kjmaster.mb.blocks.BlockWalling;
import com.kjmaster.mb.network.PointsPacket;
import com.kjmaster.mb.skillpoints.air.AirSkillPointsProvider;
import com.kjmaster.mb.skillpoints.earth.EarthSkillPointsProvider;
import com.kjmaster.mb.skillpoints.air.IAirSkillPoints;
import com.kjmaster.mb.skillpoints.earth.IEarthSkillPoints;
import com.kjmaster.mb.skillpoints.fire.FireSkillPointsProvider;
import com.kjmaster.mb.skillpoints.fire.IFireSkillPoints;
import com.kjmaster.mb.skillpoints.water.IWaterSkillPoints;
import com.kjmaster.mb.skillpoints.water.WaterSkillPointsProvider;
import com.kjmaster.mb.spellmanager.earth.bone.IBoneMealManager;
import com.kjmaster.mb.spellmanager.earth.bone.BoneMealManagerProvider;
import com.kjmaster.mb.spellmanager.air.Invisibility.IInvisibilityManager;
import com.kjmaster.mb.spellmanager.air.Invisibility.InvisibilityManagerProvider;
import com.kjmaster.mb.spellmanager.earth.clearwall.ClearWallManagerProvider;
import com.kjmaster.mb.spellmanager.earth.clearwall.IClearWallManager;
import com.kjmaster.mb.spellmanager.earth.spawnwallingrune.ISpawnWallingRuneManager;
import com.kjmaster.mb.spellmanager.earth.spawnwallingrune.SpawnWallingRuneManagerProvider;
import com.kjmaster.mb.spellmanager.fire.fireblast.FireBlastManagerProvider;
import com.kjmaster.mb.spellmanager.fire.fireblast.IFireBlastManager;
import com.kjmaster.mb.spellmanager.air.lightning.ILightningManager;
import com.kjmaster.mb.spellmanager.air.lightning.LightningManagerProvider;
import com.kjmaster.mb.spellmanager.water.waterwolf.IWaterWolfManager;
import com.kjmaster.mb.spellmanager.water.waterwolf.WaterWolfManagerProvider;
import com.kjmaster.mb.util.LightningCooldown;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockFire;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.BlockStateBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
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

import static com.kjmaster.mb.client.ConfigHandler.*;

/**
 * Created by pbill_000 on 07/06/2017.
 */
public class PacketsHandler implements IMessageHandler<PointsPacket, IMessage> {
    @Override
    public IMessage onMessage(PointsPacket message, MessageContext ctx) {
        EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
        float amount = message.toSend;
        if (amount == 1 && isBonemealEnabled) {
            IBoneMealManager BONEMEAL_UNLOCKED = serverPlayer.getCapability(BoneMealManagerProvider.SPELL_MANAGER_CAP, null);
            float BoneMeal = BONEMEAL_UNLOCKED.getBonemeal();
            IEarthSkillPoints earthSkillPoints = serverPlayer.getCapability(EarthSkillPointsProvider.EARTHSKILLPOINTS_CAP, null);
            float points = earthSkillPoints.getEarthSkillPoints();
            if (points < 4 && BoneMeal == 0) {
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
        } else if (amount == 1) {
            serverPlayer.sendMessage(new TextComponentString(TextFormatting.GREEN + "This spell has been disabled!"));
        }
        if (amount == 2 && isBonemealEnabled) {
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
        } else if (amount == 2) {
            serverPlayer.sendMessage(new TextComponentString(TextFormatting.GREEN + "This spell has been disabled!"));
        }
        if (amount == 3 && isInvisibilityEnabled) {
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

        } else if (amount == 3) {
            serverPlayer.sendMessage(new TextComponentString(TextFormatting.WHITE + "This spell has been disabled!"));
        }
        if (amount == 4 && isInvisibilityEnabled) {
            IInvisibilityManager INVIS_UNLOCKED = serverPlayer.getCapability(InvisibilityManagerProvider.INVISIBILITY_MANAGER_CAP, null);
            float Invis = INVIS_UNLOCKED.getInvisibility();
            if (Invis == 1) {
                if (serverPlayer.isInvisible()) {
                    serverPlayer.setInvisible(false);
                } else {
                    serverPlayer.setInvisible(true);
                }

            }

        } else if (amount == 4) {
            serverPlayer.sendMessage(new TextComponentString(TextFormatting.WHITE + "This spell has been disabled!"));
        }
        if (amount == 5 && isLightningEnabled) {
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

        } else if (amount == 5) {
            serverPlayer.sendMessage(new TextComponentString(TextFormatting.WHITE + "This spell has been disabled!"));
        }
        if (amount == 6 && isLightningEnabled) {
            if (LightningCooldown.LightningCooldown <= 0) {
                LightningCooldown.LightningCooldown = configuredLightningCooldown;
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
                        for (int i = 0; i < 45; i++) {
                            World world = serverPlayer.world;
                            for (EntityMob e : world.getEntities(EntityMob.class, new Predicate<EntityMob>() {

                                @Override
                                public boolean apply(EntityMob input) {
                                    return (input.getDistanceToEntity(serverPlayer) <= 20);
                                }
                            })) {
                                BlockPos pos = e.getPosition();
                                double x = pos.getX();
                                double y = pos.getY();
                                double z = pos.getZ();
                                world.addWeatherEffect(new EntityLightningBolt(world, x, y, z, true));

                            }
                        }

                    }
                }
            } else {
                serverPlayer.sendMessage(new TextComponentString(TextFormatting.WHITE + "ticks left on cooldown: " + LightningCooldown.LightningCooldown));
            }
        } else if (amount == 6) {
            serverPlayer.sendMessage(new TextComponentString(TextFormatting.WHITE + "This spell has been disabled!"));
        }


        if (amount == 7 && isFireBlastEnabled) {
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

        } else if (amount == 7) {
            serverPlayer.sendMessage(new TextComponentString(TextFormatting.RED + "This spell has been disabled!"));
        }
        if (amount == 8 && isFireBlastEnabled) {
            IFireBlastManager FIREBLAST_UNLOCKED = serverPlayer.getCapability(FireBlastManagerProvider.FIREBLAST_MANAGER_CAP, null);
            float FireBlast = FIREBLAST_UNLOCKED.getFireBlast();
            if (FireBlast == 1) {
                serverPlayer.sendMessage(new TextComponentString(TextFormatting.RED + "FIRE BLAST!"));
                EntityPlayer player = serverPlayer;
                World world = player.world;
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
                    for (int i = 0; i < 45; i++) {
                        for (EntityMob e : world.getEntities(EntityMob.class, new Predicate<EntityMob>() {

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
        } else if (amount == 8) {
            serverPlayer.sendMessage(new TextComponentString(TextFormatting.RED + "This spell has been disabled!"));
        }
        if (amount == 9 && isWaterWolfEnabled) {
            IWaterSkillPoints waterSkillPoints = serverPlayer.getCapability(WaterSkillPointsProvider.WATERSKILLPOINTS_CAP, null);
            float points = waterSkillPoints.getWaterSkillPoints();
            IWaterWolfManager WATERWOLF_UNLOCKED1 = serverPlayer.getCapability(WaterWolfManagerProvider.WATERWOLF_MANAGER_CAP, null);
            float WaterWolf = WATERWOLF_UNLOCKED1.getWaterWolf();
            if (points < 16 && WaterWolf == 0) {
                serverPlayer.sendMessage(new TextComponentString(TextFormatting.BLUE + "You need 16 water skill points for this spell!"));

            } else {
                if (WaterWolf == 0) {
                    WATERWOLF_UNLOCKED1.addWaterWolf(1);
                    IWaterSkillPoints waterSkillPoints1 = serverPlayer.getCapability(WaterSkillPointsProvider.WATERSKILLPOINTS_CAP, null);
                    waterSkillPoints1.consumeWater(16);
                    float points2 = waterSkillPoints1.getWaterSkillPoints();
                    float WaterWolf2 = WATERWOLF_UNLOCKED1.getWaterWolf();
                    if (WaterWolf2 == 1) {
                        serverPlayer.sendMessage(new TextComponentString(TextFormatting.BLUE + "You unlocked the water wolf spell!"));
                        serverPlayer.sendMessage(new TextComponentString(TextFormatting.BLUE + "You now have " + points2 + " water skill points"));
                    }

                }
            }
        } else if (amount == 9) {
            serverPlayer.sendMessage(new TextComponentString(TextFormatting.BLUE + "This spell has been disabled!"));
        }
        if (amount == 10 && isWaterWolfEnabled) {
            IWaterWolfManager WATERWOLF_UNLOCKED1 = serverPlayer.getCapability(WaterWolfManagerProvider.WATERWOLF_MANAGER_CAP, null);
            float WaterWolf = WATERWOLF_UNLOCKED1.getWaterWolf();
            if (WaterWolf < (maxWaterWolves + 1) && WaterWolf >= 1) {
                EntityPlayer player = serverPlayer;
                World world2 = serverPlayer.getServerWorld();
                com.kjmaster.mb.entities.WaterWolf waterWolf = new WaterWolf(world2, player);
                waterWolf.setLocationAndAngles(serverPlayer.posX, serverPlayer.posY, serverPlayer.posZ, 0F, 0F);
                world2.spawnEntity(waterWolf);
                WATERWOLF_UNLOCKED1.addWaterWolf(1);

            } else {
                serverPlayer.sendMessage(new TextComponentString(TextFormatting.BLUE + "You can only spawn 10 water wolves per world, make sure you breed them for more!"));
            }

        } else if (amount == 10) {
            serverPlayer.sendMessage(new TextComponentString(TextFormatting.BLUE + "This spell has been disabled!"));
        }
        if (amount == 11 && isWallingRuneEnabled) {
            IEarthSkillPoints earthSkillPoints = serverPlayer.getCapability(EarthSkillPointsProvider.EARTHSKILLPOINTS_CAP, null);
            float points = earthSkillPoints.getEarthSkillPoints();
            ISpawnWallingRuneManager WALLINGRUNE_UNLOCKED1 = serverPlayer.getCapability(SpawnWallingRuneManagerProvider.WALLING_RUNE_MANAGER_CAP, null);
            float WallingRune = WALLINGRUNE_UNLOCKED1.getWallingRune();
            if (points < 16 && WallingRune == 0) {
                serverPlayer.sendMessage(new TextComponentString(TextFormatting.GREEN + "You need 16 earth skill points for this spell!"));

            } else {
                if (WallingRune == 0) {
                    WALLINGRUNE_UNLOCKED1.addWallingRune(1);
                    IEarthSkillPoints earthSkillPoints1 = serverPlayer.getCapability(EarthSkillPointsProvider.EARTHSKILLPOINTS_CAP, null);
                    earthSkillPoints1.consumeEarth(16);
                    float points2 = earthSkillPoints1.getEarthSkillPoints();
                    float WallingRune2 = WALLINGRUNE_UNLOCKED1.getWallingRune();
                    if (WallingRune2 == 1) {
                        serverPlayer.sendMessage(new TextComponentString(TextFormatting.GREEN + "You unlocked the spawn walling rune spell!"));
                        serverPlayer.sendMessage(new TextComponentString(TextFormatting.GREEN + "You now have " + points2 + " earth skill points"));
                    }

                }
            }
        } else if (amount == 11) {
            serverPlayer.sendMessage(new TextComponentString(TextFormatting.GREEN + "This spell has been disabled!"));
        }
        if (amount == 12 && isWallingRuneEnabled) {
            ISpawnWallingRuneManager WALLINGRUNE_UNLOCKED = serverPlayer.getCapability(SpawnWallingRuneManagerProvider.WALLING_RUNE_MANAGER_CAP, null);
            float WallingRune = WALLINGRUNE_UNLOCKED.getWallingRune();
            if (WallingRune == 1) {
                serverPlayer.addItemStackToInventory(new ItemStack(ModBlocks.wallingRuneBlock, 1, 0));
            }
        } else if (amount == 12) {
            serverPlayer.sendMessage(new TextComponentString(TextFormatting.GREEN + "This spell has been disabled!"));
        }
        if (amount == 13 && isClearWallEnabled) {
            IEarthSkillPoints earthSkillPoints = serverPlayer.getCapability(EarthSkillPointsProvider.EARTHSKILLPOINTS_CAP, null);
            float points = earthSkillPoints.getEarthSkillPoints();
            IClearWallManager CLEARWALL_UNLOCKED1 = serverPlayer.getCapability(ClearWallManagerProvider.CLEAR_WALL_MANAGER_CAP, null);
            float ClearWall = CLEARWALL_UNLOCKED1.getClearWall();
            if (points < 1 && ClearWall == 0) {
                serverPlayer.sendMessage(new TextComponentString(TextFormatting.GREEN + "You need 1 earth skill point for this spell!"));

            } else {
                if (ClearWall == 0) {
                    CLEARWALL_UNLOCKED1.addClearWall(1);
                    IEarthSkillPoints earthSkillPoints1 = serverPlayer.getCapability(EarthSkillPointsProvider.EARTHSKILLPOINTS_CAP, null);
                    earthSkillPoints1.consumeEarth(1);
                    float points2 = earthSkillPoints1.getEarthSkillPoints();
                    float WallingRune2 = CLEARWALL_UNLOCKED1.getClearWall();
                    if (WallingRune2 == 1) {
                        serverPlayer.sendMessage(new TextComponentString(TextFormatting.GREEN + "You unlocked the clear wall spell!"));
                        serverPlayer.sendMessage(new TextComponentString(TextFormatting.GREEN + "You now have " + points2 + " earth skill points"));
                    }

                }
            }
        } else if (amount == 13) {
            serverPlayer.sendMessage(new TextComponentString(TextFormatting.GREEN + "This spell has been disabled!"));
        }
        if (amount == 14 && isClearWallEnabled) {
            serverPlayer.sendMessage(new TextComponentString(TextFormatting.GREEN + "test1"));
            IClearWallManager CLEARWALL_UNLOCKED = serverPlayer.getCapability(ClearWallManagerProvider.CLEAR_WALL_MANAGER_CAP, null);
            float ClearWall = CLEARWALL_UNLOCKED.getClearWall();
            if (ClearWall == 1) {
                serverPlayer.sendMessage(new TextComponentString(TextFormatting.GREEN + "test2"));
                EntityPlayer player = serverPlayer;
                World world = player.world;
                RayTraceResult lastPosition = serverPlayer.rayTrace(100, 1.0F);
                BlockPos pos = lastPosition.getBlockPos();
                Block block = serverPlayer.world.getBlockState(pos).getBlock();
                if ((block instanceof BlockWallingRune)) {
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
                }
            }
        } else if (amount == 14) {
            serverPlayer.sendMessage(new TextComponentString(TextFormatting.GREEN + "This spell has been disabled!"));
        } if (amount == 15) {
            IAirSkillPoints airSkillPoints = serverPlayer.getCapability(AirSkillPointsProvider.AIRSKILLPOINTS_CAP, null);
             float points = airSkillPoints.getAirSkillPoints();
             GuiAirSpells.airpoints = points;
        } if (amount == 16) {
            IEarthSkillPoints earthSkillPoints = serverPlayer.getCapability(EarthSkillPointsProvider.EARTHSKILLPOINTS_CAP, null);
            float points = earthSkillPoints.getEarthSkillPoints();
            GuiEarthSpells.earthpoints = points;
        } if (amount == 17) {
            IFireSkillPoints fireSkillPoints = serverPlayer.getCapability(FireSkillPointsProvider.FIRESKILLPOINTS_CAP, null);
            float points = fireSkillPoints.getFireSkillPoints();
            GuiFireSpells.firepoints = points;
        } if (amount == 18) {
            IWaterSkillPoints waterSkillPoints = serverPlayer.getCapability(WaterSkillPointsProvider.WATERSKILLPOINTS_CAP, null);
            float points = waterSkillPoints.getWaterSkillPoints();
            GuiWaterSpells.waterpoints = points;
        }
        return null;
    }
}


