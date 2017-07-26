package com.kjmaster.mb.handlers;

import com.kjmaster.mb.chosenspells.chosenspell.ChosenSpellProvider;
import com.kjmaster.mb.chosenspells.chosenspell.IChosenSpell;
import com.kjmaster.mb.chosenspells.chosenspell2.ChosenSpell2Provider;
import com.kjmaster.mb.chosenspells.chosenspell2.IChosenSpell2;
import com.kjmaster.mb.chosenspells.chosenspell3.ChosenSpell3;
import com.kjmaster.mb.chosenspells.chosenspell3.ChosenSpell3Provider;
import com.kjmaster.mb.chosenspells.chosenspell3.IChosenSpell3;
import com.kjmaster.mb.chosenspells.chosenspell4.ChosenSpell4;
import com.kjmaster.mb.chosenspells.chosenspell4.ChosenSpell4Provider;
import com.kjmaster.mb.chosenspells.chosenspell4.IChosenSpell4;
import com.kjmaster.mb.chosenspells.chosenspell5.ChosenSpell5Provider;
import com.kjmaster.mb.chosenspells.chosenspell5.IChosenSpell5;
import com.kjmaster.mb.chosenspells.chosenspell6.ChosenSpell6Provider;
import com.kjmaster.mb.chosenspells.chosenspell6.IChosenSpell6;
import com.kjmaster.mb.chosenspells.chosenspell7.ChosenSpell7Provider;
import com.kjmaster.mb.chosenspells.chosenspell7.IChosenSpell7;
import com.kjmaster.mb.chosenspells.chosenspell8.ChosenSpell8Provider;
import com.kjmaster.mb.chosenspells.chosenspell8.IChosenSpell8;
import com.kjmaster.mb.guis.spellunlock.GuiAirSpells;
import com.kjmaster.mb.guis.spellunlock.GuiEarthSpells;
import com.kjmaster.mb.guis.spellunlock.GuiFireSpells;
import com.kjmaster.mb.guis.spellunlock.GuiWaterSpells;
import com.kjmaster.mb.init.ModItems;
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
import com.kjmaster.mb.spellmanager.fire.fireblast.FireBlastManagerProvider;
import com.kjmaster.mb.spellmanager.fire.fireblast.IFireBlastManager;
import com.kjmaster.mb.spellmanager.air.lightning.ILightningManager;
import com.kjmaster.mb.spellmanager.air.lightning.LightningManagerProvider;
import com.kjmaster.mb.spellmanager.water.waterwolf.IWaterWolfManager;
import com.kjmaster.mb.spellmanager.water.waterwolf.WaterWolfManagerProvider;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

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
                        serverPlayer.sendMessage(new TextComponentString(TextFormatting.GREEN + "You unlocked the Bonemeal spell!"));
                        serverPlayer.sendMessage(new TextComponentString(TextFormatting.GREEN + "You now have " + points2 + " earth skill points"));
                    }

                }
            }
        } else if (amount == 1) {
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
        if (amount == 15) {
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
        } if (amount == 19) {
            if (serverPlayer.getHeldItemMainhand().getItem() == ModItems.MagicBook) {
                int meta = serverPlayer.getHeldItemMainhand().getItemDamage();
                switch (meta) {
                    case 0:
                        serverPlayer.getHeldItemMainhand().shrink(1);
                        serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.MagicBook, 1, 1));
                        break;
                    case 1:
                        serverPlayer.getHeldItemMainhand().shrink(1);
                        serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.MagicBook, 1, 2));
                        break;
                    case 2:
                        serverPlayer.getHeldItemMainhand().shrink(1);
                        serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.MagicBook, 1, 3));
                        break;
                    case 3:
                        serverPlayer.getHeldItemMainhand().shrink(1);
                        serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.MagicBook, 1, 4));
                        break;
                    case 4:
                        serverPlayer.getHeldItemMainhand().shrink(1);
                        serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.MagicBook, 1, 5));
                        break;
                    case 5:
                        serverPlayer.getHeldItemMainhand().shrink(1);
                        serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.MagicBook, 1, 6));
                        break;
                    case 6:
                        serverPlayer.getHeldItemMainhand().shrink(1);
                        serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.MagicBook, 1, 7));
                        break;
                    case 7:
                        serverPlayer.getHeldItemMainhand().shrink(1);
                        serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.MagicBook, 1, 8));
                        break;
                    case 8:
                        serverPlayer.getHeldItemMainhand().shrink(1);
                        serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.MagicBook, 1, 0));
                        break;

                }
            }
        // chosen spell 1
        } if (amount == 20) {
            IChosenSpell ChosenSpell = serverPlayer.getCapability(ChosenSpellProvider.CHOSENSPELL_CAP, null);
            ChosenSpell.setChosenSpell("bonemeal");
        } if (amount == 21) {
            IChosenSpell ChosenSpell = serverPlayer.getCapability(ChosenSpellProvider.CHOSENSPELL_CAP, null);
            ChosenSpell.setChosenSpell("clearwall");
        } if (amount == 22) {
            IChosenSpell ChosenSpell = serverPlayer.getCapability(ChosenSpellProvider.CHOSENSPELL_CAP, null);
            ChosenSpell.setChosenSpell("invisibility");
        } if (amount == 23) {
            IChosenSpell ChosenSpell = serverPlayer.getCapability(ChosenSpellProvider.CHOSENSPELL_CAP, null);
            ChosenSpell.setChosenSpell("lightning");
        } if (amount == 24) {
            IChosenSpell ChosenSpell = serverPlayer.getCapability(ChosenSpellProvider.CHOSENSPELL_CAP, null);
            ChosenSpell.setChosenSpell("fireblast");
        } if (amount == 25) {
            IChosenSpell ChosenSpell = serverPlayer.getCapability(ChosenSpellProvider.CHOSENSPELL_CAP, null);
            ChosenSpell.setChosenSpell("waterwolf");
        // chosen spell 2
        } if (amount == 26) {
            IChosenSpell2 ChosenSpell2 = serverPlayer.getCapability(ChosenSpell2Provider.CHOSENSPELL2_CAP, null);
            ChosenSpell2.setChosenSpell2("bonemeal");
        } if (amount == 27) {
            IChosenSpell2 ChosenSpell2 = serverPlayer.getCapability(ChosenSpell2Provider.CHOSENSPELL2_CAP, null);
            ChosenSpell2.setChosenSpell2("clearwall");
        } if (amount == 28) {
            IChosenSpell2 ChosenSpell2 = serverPlayer.getCapability(ChosenSpell2Provider.CHOSENSPELL2_CAP, null);
            ChosenSpell2.setChosenSpell2("invisibility");
        } if (amount == 29) {
            IChosenSpell2 ChosenSpell2 = serverPlayer.getCapability(ChosenSpell2Provider.CHOSENSPELL2_CAP, null);
            ChosenSpell2.setChosenSpell2("lightning");
        } if (amount == 30) {
            IChosenSpell2 ChosenSpell2 = serverPlayer.getCapability(ChosenSpell2Provider.CHOSENSPELL2_CAP, null);
            ChosenSpell2.setChosenSpell2("fireblast");
        } if (amount == 31) {
            IChosenSpell2 ChosenSpell2 = serverPlayer.getCapability(ChosenSpell2Provider.CHOSENSPELL2_CAP, null);
            ChosenSpell2.setChosenSpell2("waterwolf");
        // chosen spell 3
        } if (amount == 32) {
            IChosenSpell3 ChosenSpell3 = serverPlayer.getCapability(ChosenSpell3Provider.CHOSENSPELL3_CAP, null);
            ChosenSpell3.setChosenSpell3("bonemeal");
        } if (amount == 33) {
            IChosenSpell3 ChosenSpell3 = serverPlayer.getCapability(ChosenSpell3Provider.CHOSENSPELL3_CAP, null);
            ChosenSpell3.setChosenSpell3("clearwall");
        } if (amount == 34) {
            IChosenSpell3 ChosenSpell3 = serverPlayer.getCapability(ChosenSpell3Provider.CHOSENSPELL3_CAP, null);
            ChosenSpell3.setChosenSpell3("invisibility");
        } if (amount == 35) {
            IChosenSpell3 ChosenSpell3 = serverPlayer.getCapability(ChosenSpell3Provider.CHOSENSPELL3_CAP, null);
            ChosenSpell3.setChosenSpell3("lightning");
        } if (amount == 36) {
            IChosenSpell3 ChosenSpell3 = serverPlayer.getCapability(ChosenSpell3Provider.CHOSENSPELL3_CAP, null);
            ChosenSpell3.setChosenSpell3("fireblast");
        } if (amount == 37) {
            IChosenSpell3 ChosenSpell3 = serverPlayer.getCapability(ChosenSpell3Provider.CHOSENSPELL3_CAP, null);
            ChosenSpell3.setChosenSpell3("waterwolf");
        }
        // chosen spell 4
        if (amount == 38) {
            IChosenSpell4 ChosenSpell4 = serverPlayer.getCapability(ChosenSpell4Provider.CHOSENSPELL4_CAP, null);
            ChosenSpell4.setChosenSpell4("bonemeal");
        } if (amount == 39) {
            IChosenSpell4 ChosenSpell4 = serverPlayer.getCapability(ChosenSpell4Provider.CHOSENSPELL4_CAP, null);
            ChosenSpell4.setChosenSpell4("clearwall");
        } if (amount == 40) {
            IChosenSpell4 ChosenSpell4 = serverPlayer.getCapability(ChosenSpell4Provider.CHOSENSPELL4_CAP, null);
            ChosenSpell4.setChosenSpell4("invisibility");
        } if (amount == 41) {
            IChosenSpell4 ChosenSpell4 = serverPlayer.getCapability(ChosenSpell4Provider.CHOSENSPELL4_CAP, null);
            ChosenSpell4.setChosenSpell4("lightning");
        } if (amount == 42) {
            IChosenSpell4 ChosenSpell4 = serverPlayer.getCapability(ChosenSpell4Provider.CHOSENSPELL4_CAP, null);
            ChosenSpell4.setChosenSpell4("fireblast");
        } if (amount == 43) {
            IChosenSpell4 ChosenSpell4 = serverPlayer.getCapability(ChosenSpell4Provider.CHOSENSPELL4_CAP, null);
            ChosenSpell4.setChosenSpell4("waterwolf");
        }
        // chosen spell 5
        if (amount == 44) {
            IChosenSpell5 ChosenSpell5 = serverPlayer.getCapability(ChosenSpell5Provider.CHOSENSPELL5_CAP, null);
            ChosenSpell5.setChosenSpell5("bonemeal");
        } if (amount == 45) {
            IChosenSpell5 ChosenSpell5 = serverPlayer.getCapability(ChosenSpell5Provider.CHOSENSPELL5_CAP, null);
            ChosenSpell5.setChosenSpell5("clearwall");
        } if (amount == 46) {
            IChosenSpell5 ChosenSpell5 = serverPlayer.getCapability(ChosenSpell5Provider.CHOSENSPELL5_CAP, null);
            ChosenSpell5.setChosenSpell5("invisibility");
        } if (amount == 47) {
            IChosenSpell5 ChosenSpell5 = serverPlayer.getCapability(ChosenSpell5Provider.CHOSENSPELL5_CAP, null);
            ChosenSpell5.setChosenSpell5("lightning");
        } if (amount == 48) {
            IChosenSpell5 ChosenSpell5 = serverPlayer.getCapability(ChosenSpell5Provider.CHOSENSPELL5_CAP, null);
            ChosenSpell5.setChosenSpell5("fireblast");
        } if (amount == 49) {
            IChosenSpell5 ChosenSpell5 = serverPlayer.getCapability(ChosenSpell5Provider.CHOSENSPELL5_CAP, null);
            ChosenSpell5.setChosenSpell5("waterwolf");
        }
        // chosen spell 6
        if (amount == 50) {
            IChosenSpell6 ChosenSpell6 = serverPlayer.getCapability(ChosenSpell6Provider.CHOSENSPELL6_CAP, null);
            ChosenSpell6.setChosenSpell6("bonemeal");
        } if (amount == 51) {
            IChosenSpell6 ChosenSpell6 = serverPlayer.getCapability(ChosenSpell6Provider.CHOSENSPELL6_CAP, null);
            ChosenSpell6.setChosenSpell6("clearwall");
        } if (amount == 52) {
            IChosenSpell6 ChosenSpell6 = serverPlayer.getCapability(ChosenSpell6Provider.CHOSENSPELL6_CAP, null);
            ChosenSpell6.setChosenSpell6("invisibility");
        } if (amount == 53) {
            IChosenSpell6 ChosenSpell6 = serverPlayer.getCapability(ChosenSpell6Provider.CHOSENSPELL6_CAP, null);
            ChosenSpell6.setChosenSpell6("lightning");
        } if (amount == 54) {
            IChosenSpell6 ChosenSpell6 = serverPlayer.getCapability(ChosenSpell6Provider.CHOSENSPELL6_CAP, null);
            ChosenSpell6.setChosenSpell6("fireblast");
        } if (amount == 55) {
            IChosenSpell6 ChosenSpell6 = serverPlayer.getCapability(ChosenSpell6Provider.CHOSENSPELL6_CAP, null);
            ChosenSpell6.setChosenSpell6("waterwolf");
        }
        // chosen spell 7
        if (amount == 56) {
            IChosenSpell7 ChosenSpell7 = serverPlayer.getCapability(ChosenSpell7Provider.CHOSENSPELL7_CAP, null);
            ChosenSpell7.setChosenSpell7("bonemeal");
        } if (amount == 57) {
            IChosenSpell7 ChosenSpell7 = serverPlayer.getCapability(ChosenSpell7Provider.CHOSENSPELL7_CAP, null);
            ChosenSpell7.setChosenSpell7("clearwall");
        } if (amount == 58) {
            IChosenSpell7 ChosenSpell7 = serverPlayer.getCapability(ChosenSpell7Provider.CHOSENSPELL7_CAP, null);
            ChosenSpell7.setChosenSpell7("invisibility");
        } if (amount == 59) {
            IChosenSpell7 ChosenSpell7 = serverPlayer.getCapability(ChosenSpell7Provider.CHOSENSPELL7_CAP, null);
            ChosenSpell7.setChosenSpell7("lightning");
        } if (amount == 60) {
            IChosenSpell7 ChosenSpell7 = serverPlayer.getCapability(ChosenSpell7Provider.CHOSENSPELL7_CAP, null);
            ChosenSpell7.setChosenSpell7("fireblast");
        } if (amount == 61) {
            IChosenSpell7 ChosenSpell7 = serverPlayer.getCapability(ChosenSpell7Provider.CHOSENSPELL7_CAP, null);
            ChosenSpell7.setChosenSpell7("waterwolf");
        }
        // chosen spell 8
        if (amount == 62) {
            IChosenSpell8 ChosenSpell8 = serverPlayer.getCapability(ChosenSpell8Provider.CHOSENSPELL8_CAP, null);
            ChosenSpell8.setChosenSpell8("bonemeal");
        } if (amount == 63) {
            IChosenSpell8 ChosenSpell8 = serverPlayer.getCapability(ChosenSpell8Provider.CHOSENSPELL8_CAP, null);
            ChosenSpell8.setChosenSpell8("clearwall");
        } if (amount == 64) {
            IChosenSpell8 ChosenSpell8 = serverPlayer.getCapability(ChosenSpell8Provider.CHOSENSPELL8_CAP, null);
            ChosenSpell8.setChosenSpell8("invisibility");
        } if (amount == 65) {
            IChosenSpell8 ChosenSpell8 = serverPlayer.getCapability(ChosenSpell8Provider.CHOSENSPELL8_CAP, null);
            ChosenSpell8.setChosenSpell8("lightning");
        } if (amount == 66) {
            IChosenSpell8 ChosenSpell8 = serverPlayer.getCapability(ChosenSpell8Provider.CHOSENSPELL8_CAP, null);
            ChosenSpell8.setChosenSpell8("fireblast");
        } if (amount == 67) {
            IChosenSpell8 ChosenSpell8 = serverPlayer.getCapability(ChosenSpell8Provider.CHOSENSPELL8_CAP, null);
            ChosenSpell8.setChosenSpell8("waterwolf");
        }
        return null;
    }
}


