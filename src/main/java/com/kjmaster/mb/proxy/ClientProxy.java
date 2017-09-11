package com.kjmaster.mb.proxy;

/**
 * Created by pbill_000 on 05/06/2017.
 */
import com.kjmaster.mb.Ref;
import com.kjmaster.mb.blocks.BlockEarthCrystal;
import com.kjmaster.mb.handlers.HUDHandler;
import com.kjmaster.mb.handlers.UpdatePointsHandler;
import com.kjmaster.mb.init.ModBlocks;
import com.kjmaster.mb.init.ModEntities;
import com.kjmaster.mb.init.ModItems;
import com.kjmaster.mb.network.UpdatePointsPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.collection.parallel.ParIterableLike;


import static com.kjmaster.mb.network.mbPacketHandler.INSTANCE;

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
        MinecraftForge.EVENT_BUS.register(new HUDHandler());
        ModEntities.initModels();
        OBJLoader.INSTANCE.addDomain(Ref.MODID);
        super.preInit(event);
        BlockEarthCrystal.initModel();
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
    @SideOnly(Side.CLIENT)
    @Override
    public EntityPlayer getPlayerEntity(MessageContext ctx) {
        return (ctx.side.isClient() ? Minecraft.getMinecraft().player : super.getPlayerEntity(ctx));
    }
    @SideOnly(Side.CLIENT)
    @Override
    public IThreadListener getThreadFromContext(MessageContext ctx) {
        return (ctx.side.isClient() ? Minecraft.getMinecraft() : super.getThreadFromContext(ctx));
    }

}
