package com.kjmaster.mb.proxy;

/**
 * Created by pbill_000 on 05/06/2017.
 */

import com.kjmaster.mb.chosenspells.chosenspell.ChosenSpell;
import com.kjmaster.mb.chosenspells.chosenspell.ChosenSpellStorage;
import com.kjmaster.mb.chosenspells.chosenspell.IChosenSpell;
import com.kjmaster.mb.chosenspells.chosenspell2.ChosenSpell2;
import com.kjmaster.mb.chosenspells.chosenspell2.ChosenSpell2Storage;
import com.kjmaster.mb.chosenspells.chosenspell2.IChosenSpell2;
import com.kjmaster.mb.chosenspells.chosenspell3.ChosenSpell3;
import com.kjmaster.mb.chosenspells.chosenspell3.ChosenSpell3Storage;
import com.kjmaster.mb.chosenspells.chosenspell3.IChosenSpell3;
import com.kjmaster.mb.chosenspells.chosenspell4.ChosenSpell4;
import com.kjmaster.mb.chosenspells.chosenspell4.ChosenSpell4Storage;
import com.kjmaster.mb.chosenspells.chosenspell4.IChosenSpell4;
import com.kjmaster.mb.chosenspells.chosenspell5.ChosenSpell5;
import com.kjmaster.mb.chosenspells.chosenspell5.ChosenSpell5Storage;
import com.kjmaster.mb.chosenspells.chosenspell5.IChosenSpell5;
import com.kjmaster.mb.chosenspells.chosenspell6.ChosenSpell6;
import com.kjmaster.mb.chosenspells.chosenspell6.ChosenSpell6Storage;
import com.kjmaster.mb.chosenspells.chosenspell6.IChosenSpell6;
import com.kjmaster.mb.chosenspells.chosenspell7.ChosenSpell7;
import com.kjmaster.mb.chosenspells.chosenspell7.ChosenSpell7Storage;
import com.kjmaster.mb.chosenspells.chosenspell7.IChosenSpell7;
import com.kjmaster.mb.chosenspells.chosenspell8.ChosenSpell8;
import com.kjmaster.mb.chosenspells.chosenspell8.ChosenSpell8Storage;
import com.kjmaster.mb.chosenspells.chosenspell8.IChosenSpell8;
import com.kjmaster.mb.handlers.PacketsHandler;
import com.kjmaster.mb.mana.CapabilityMana;
import com.kjmaster.mb.network.PointsPacket;
import com.kjmaster.mb.skillpoints.air.AirSkillPoints;
import com.kjmaster.mb.skillpoints.air.AirSkillPointsStorage;
import com.kjmaster.mb.skillpoints.air.IAirSkillPoints;
import com.kjmaster.mb.skillpoints.earth.EarthSkillPoints;
import com.kjmaster.mb.skillpoints.earth.EarthSkillPointsStorage;
import com.kjmaster.mb.skillpoints.earth.IEarthSkillPoints;
import com.kjmaster.mb.skillpoints.fire.FireSkillPoints;
import com.kjmaster.mb.skillpoints.fire.FireSkillPointsStorage;
import com.kjmaster.mb.skillpoints.fire.IFireSkillPoints;
import com.kjmaster.mb.skillpoints.water.IWaterSkillPoints;
import com.kjmaster.mb.skillpoints.water.WaterSkillPoints;
import com.kjmaster.mb.skillpoints.water.WaterSkillPointsStorage;
import com.kjmaster.mb.spellmanager.air.Invisibility.IInvisibilityManager;
import com.kjmaster.mb.spellmanager.air.Invisibility.InvisibilityManager;
import com.kjmaster.mb.spellmanager.air.Invisibility.InvisibilityManagerStorage;
import com.kjmaster.mb.spellmanager.earth.bone.BoneMealManager;
import com.kjmaster.mb.spellmanager.earth.bone.BoneMealManagerStorage;
import com.kjmaster.mb.spellmanager.earth.bone.IBoneMealManager;
import com.kjmaster.mb.spellmanager.earth.clearwall.ClearWallManager;
import com.kjmaster.mb.spellmanager.earth.clearwall.ClearWallManagerStorage;
import com.kjmaster.mb.spellmanager.earth.clearwall.IClearWallManager;
import com.kjmaster.mb.spellmanager.fire.fireblast.FireBlastManager;
import com.kjmaster.mb.spellmanager.fire.fireblast.FireBlastManagerStorage;
import com.kjmaster.mb.spellmanager.fire.fireblast.IFireBlastManager;
import com.kjmaster.mb.spellmanager.air.lightning.ILightningManager;
import com.kjmaster.mb.spellmanager.air.lightning.LightningManager;
import com.kjmaster.mb.spellmanager.air.lightning.LightningManagerStorage;
import com.kjmaster.mb.spellmanager.water.waterwolf.IWaterWolfManager;
import com.kjmaster.mb.spellmanager.water.waterwolf.WaterWolfManager;
import com.kjmaster.mb.spellmanager.water.waterwolf.WaterWolfManagerStorage;
import com.kjmaster.mb.tileentities.*;
import com.kjmaster.mb.tileentities.crystals.TileEntityAirCrystal;
import com.kjmaster.mb.tileentities.crystals.TileEntityEarthCrystal;
import com.kjmaster.mb.tileentities.crystals.TileEntityFireCrystal;
import com.kjmaster.mb.tileentities.crystals.TileEntityWaterCrystal;
import com.kjmaster.mb.tileentities.greatercrystals.TileEntityGreaterAirCrystal;
import com.kjmaster.mb.tileentities.greatercrystals.TileEntityGreaterEarthCrystal;
import com.kjmaster.mb.tileentities.greatercrystals.TileEntityGreaterFireCrystal;
import com.kjmaster.mb.tileentities.greatercrystals.TileEntityGreaterWaterCrystal;
import com.kjmaster.mb.worldgen.OreGen;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.SidedProxy;
import com.kjmaster.mb.Ref;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

import static com.kjmaster.mb.network.mbPacketHandler.INSTANCE;




public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {}
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new OreGen(), 0);
    }
    public void postInit(FMLPostInitializationEvent event) {}
    public void serverStarting(FMLServerStartingEvent event) {}
    public void serverStopping(FMLServerStoppingEvent event) {}
    public static void register() {
        CapabilityManager.INSTANCE.register(IAirSkillPoints.class, new AirSkillPointsStorage(), AirSkillPoints.class );
        CapabilityManager.INSTANCE.register(IEarthSkillPoints.class, new EarthSkillPointsStorage(), EarthSkillPoints.class );
        CapabilityManager.INSTANCE.register(IFireSkillPoints.class, new FireSkillPointsStorage(), FireSkillPoints.class);
        CapabilityManager.INSTANCE.register(IWaterSkillPoints.class, new WaterSkillPointsStorage(), WaterSkillPoints.class);
        CapabilityManager.INSTANCE.register(IBoneMealManager.class, new BoneMealManagerStorage(), BoneMealManager.class);
        CapabilityManager.INSTANCE.register(IInvisibilityManager.class, new InvisibilityManagerStorage(), InvisibilityManager.class);
        CapabilityManager.INSTANCE.register(ILightningManager.class, new LightningManagerStorage(), LightningManager.class);
        CapabilityManager.INSTANCE.register(IFireBlastManager.class, new FireBlastManagerStorage(), FireBlastManager.class);
        CapabilityManager.INSTANCE.register(IWaterWolfManager.class, new WaterWolfManagerStorage(), WaterWolfManager.class);
        CapabilityManager.INSTANCE.register(IClearWallManager.class, new ClearWallManagerStorage(), ClearWallManager.class);
        CapabilityManager.INSTANCE.register(IChosenSpell.class, new ChosenSpellStorage(), ChosenSpell.class);
        CapabilityManager.INSTANCE.register(IChosenSpell2.class, new ChosenSpell2Storage(), ChosenSpell2.class);
        CapabilityManager.INSTANCE.register(IChosenSpell3.class, new ChosenSpell3Storage(), ChosenSpell3.class);
        CapabilityManager.INSTANCE.register(IChosenSpell4.class, new ChosenSpell4Storage(), ChosenSpell4.class);
        CapabilityManager.INSTANCE.register(IChosenSpell5.class, new ChosenSpell5Storage(), ChosenSpell5.class);
        CapabilityManager.INSTANCE.register(IChosenSpell6.class, new ChosenSpell6Storage(), ChosenSpell6.class);
        CapabilityManager.INSTANCE.register(IChosenSpell7.class, new ChosenSpell7Storage(), ChosenSpell7.class);
        CapabilityManager.INSTANCE.register(IChosenSpell8.class, new ChosenSpell8Storage(), ChosenSpell8.class);
        CapabilityMana.register();

        //Server packets
        INSTANCE.registerMessage(PacketsHandler.class, PointsPacket.class, Ref.PACKET_ID_EARTHPOINTS, Side.SERVER);
    }

    public void registerModelBakeryVariants() {}

    public void registerTileEntities() {
        //Runes
        GameRegistry.registerTileEntity(TileEntityWoodCutRune.class, Ref.MODID + ":woodcutrune_block");
        //Crystals
        GameRegistry.registerTileEntity(TileEntityEarthCrystal.class, Ref.MODID + ":earth_crystal_block");
        GameRegistry.registerTileEntity(TileEntityAirCrystal.class, Ref.MODID + ":air_crystal_block");
        GameRegistry.registerTileEntity(TileEntityFireCrystal.class, Ref.MODID + ":fire_crystal_block");
        GameRegistry.registerTileEntity(TileEntityWaterCrystal.class, Ref.MODID + ":water_crystal_block");
        //Greater Crystals
        GameRegistry.registerTileEntity(TileEntityGreaterAirCrystal.class, Ref.MODID + ":greater_air_crystal_block");
        GameRegistry.registerTileEntity(TileEntityGreaterEarthCrystal.class, Ref.MODID + ":greater_earth_crystal_block");
        GameRegistry.registerTileEntity(TileEntityGreaterFireCrystal.class, Ref.MODID + ":greater_fire_crystal_block");
        GameRegistry.registerTileEntity(TileEntityGreaterWaterCrystal.class, Ref.MODID + ":greater_water_crystal_block");

        GameRegistry.registerTileEntity(TileEntityManaInfuser.class, Ref.MODID + ":mana_infuser");
    }
}
