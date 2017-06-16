package com.kjmaster.mb.proxy;

/**
 * Created by pbill_000 on 05/06/2017.
 */
import com.kjmaster.mb.Ref;
import com.kjmaster.mb.client.model.ModelWaterGolem;
import com.kjmaster.mb.client.render.RenderWaterGolem;
import com.kjmaster.mb.entities.WaterGolem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.*;


public class ClientProxy extends CommonProxy{

    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);

    }

    public void registerModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Ref.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
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
    public void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(WaterGolem.class, new RenderWaterGolem(Minecraft.getMinecraft().getRenderManager(), new ModelWaterGolem(), 0.7F));
    }
}
