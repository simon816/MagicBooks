package com.kjmaster.mb.proxy;

/**
 * Created by pbill_000 on 05/06/2017.
 */

import com.kjmaster.mb.handlers.PacketsHandler;
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
import com.kjmaster.mb.spellmanager.Invisibility.IInvisibilityManager;
import com.kjmaster.mb.spellmanager.Invisibility.InvisibilityManager;
import com.kjmaster.mb.spellmanager.Invisibility.InvisibilityManagerStorage;
import com.kjmaster.mb.spellmanager.bone.BoneMealManager;
import com.kjmaster.mb.spellmanager.bone.BoneMealManagerStorage;
import com.kjmaster.mb.spellmanager.bone.IBoneMealManager;
import com.kjmaster.mb.spellmanager.fireblast.FireBlastManager;
import com.kjmaster.mb.spellmanager.fireblast.FireBlastManagerStorage;
import com.kjmaster.mb.spellmanager.fireblast.IFireBlastManager;
import com.kjmaster.mb.spellmanager.lightning.ILightningManager;
import com.kjmaster.mb.spellmanager.lightning.LightningManager;
import com.kjmaster.mb.spellmanager.lightning.LightningManagerStorage;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.SidedProxy;
import com.kjmaster.mb.Ref;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.relauncher.Side;

import static com.kjmaster.mb.network.mbPacketHandler.INSTANCE;
import static com.kjmaster.mb.util.RegisterUtil.registerAll;




public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event)
    {
        registerAll(event);
    }
    public void init(FMLInitializationEvent event) {}
    public void postInit(FMLPostInitializationEvent event) {}
    public void serverStarting(FMLServerStartingEvent event) {}
    public void serverStopping(FMLServerStoppingEvent event) {}
    @SidedProxy(clientSide = Ref.CLIENT_PROXY, serverSide = Ref.COMMON_PROXY)
    public static CommonProxy proxy;
    public static void register() {
        CapabilityManager.INSTANCE.register(IAirSkillPoints.class, new AirSkillPointsStorage(), AirSkillPoints.class );
        CapabilityManager.INSTANCE.register(IEarthSkillPoints.class, new EarthSkillPointsStorage(), EarthSkillPoints.class );
        CapabilityManager.INSTANCE.register(IFireSkillPoints.class, new FireSkillPointsStorage(), FireSkillPoints.class);
        CapabilityManager.INSTANCE.register(IWaterSkillPoints.class, new WaterSkillPointsStorage(), WaterSkillPoints.class);
        CapabilityManager.INSTANCE.register(IBoneMealManager.class, new BoneMealManagerStorage(), BoneMealManager.class);
        CapabilityManager.INSTANCE.register(IInvisibilityManager.class, new InvisibilityManagerStorage(), InvisibilityManager.class);
        CapabilityManager.INSTANCE.register(ILightningManager.class, new LightningManagerStorage(), LightningManager.class);
        CapabilityManager.INSTANCE.register(IFireBlastManager.class, new FireBlastManagerStorage(), FireBlastManager.class);
        INSTANCE.registerMessage(PacketsHandler.class, PointsPacket.class, Ref.PACKET_ID_EARTHPOINTS, Side.SERVER);
    }


}
