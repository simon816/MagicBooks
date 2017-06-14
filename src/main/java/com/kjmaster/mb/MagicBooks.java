package com.kjmaster.mb;

/**
 * Created by pbill_000 on 05/06/2017.
 */
import com.kjmaster.mb.events.CloneEvent;
import com.kjmaster.mb.events.Tick;
import com.kjmaster.mb.handlers.CapabilityHandler;
import com.kjmaster.mb.handlers.LootHandler;
import com.kjmaster.mb.init.ModCrafting;
import com.kjmaster.mb.network.ModGuiHandler;
import com.kjmaster.mb.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.kjmaster.mb.proxy.CommonProxy.proxy;

@Mod(modid = Ref.MODID, name=Ref.NAME, version=Ref.VERSION)
public class MagicBooks {

    @Mod.Instance
    public static MagicBooks instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("Starting Pre-Initialization");
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        LOGGER.info("Starting Initialization");
        proxy.init(event);
        ModCrafting.register();
        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
        MinecraftForge.EVENT_BUS.register(new LootHandler());
        MinecraftForge.EVENT_BUS.register(new CloneEvent());
        MinecraftForge.EVENT_BUS.register(new Tick());
        CommonProxy.register();
        NetworkRegistry.INSTANCE.registerGuiHandler(MagicBooks.instance, new ModGuiHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LOGGER.info("Starting Post-Initialization");
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        LOGGER.info("Starting server...");
        proxy.serverStarting(event);
    }

    public static final Logger LOGGER = LogManager.getLogger(Ref.MODID);

}