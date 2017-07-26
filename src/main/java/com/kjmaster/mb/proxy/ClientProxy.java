package com.kjmaster.mb.proxy;

/**
 * Created by pbill_000 on 05/06/2017.
 */
import com.kjmaster.mb.Ref;
import com.kjmaster.mb.init.ModBlocks;
import com.kjmaster.mb.init.ModEntities;
import com.kjmaster.mb.init.ModItems;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ClientProxy extends CommonProxy{

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModBlocks.registerModels();
        ModItems.registerModels();
    }

    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        ModEntities.initModels();
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

    @Override
    public void serverStarting(FMLServerStartingEvent event) {
        super.serverStarting(event);
    }

    @Override
    public void serverStopping(FMLServerStoppingEvent event) {
        super.serverStopping(event);
    }

    @Override
    public void registerModelBakeryVariants() {
        ModelBakery.registerItemVariants(ModItems.MagicBook, new ResourceLocation(Ref.MODID, "magicbook_nospell"),
                new ResourceLocation(Ref.MODID, "magicbook_spell1"),
                new ResourceLocation(Ref.MODID, "magicbook_spell2"),
                new ResourceLocation(Ref.MODID, "magicbook_spell3"),
                new ResourceLocation(Ref.MODID, "magicbook_spell4"),
                new ResourceLocation(Ref.MODID, "magicbook_spell5"),
                new ResourceLocation(Ref.MODID, "magicbook_spell6"),
                new ResourceLocation(Ref.MODID, "magicbook_spell7"),
                new ResourceLocation(Ref.MODID, "magicbook_spell8")
                );
    }
}
