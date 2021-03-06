package com.kjmaster.mb.client.render;

import com.kjmaster.mb.Ref;
import com.kjmaster.mb.client.model.ModelWaterWolf;
import com.kjmaster.mb.entities.WaterWolf;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelWolf;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nonnull;

/**
 * Created by pbill_000 on 15/06/2017.
 */
@SideOnly(Side.CLIENT)
public class RenderWaterWolf extends RenderLiving<WaterWolf> {
    private static final  ResourceLocation WATERWOLF_TEXTURES = new ResourceLocation(Ref.MODID + ":textures/entity/waterwolf/waterwolf.png");
    private static final ResourceLocation TAMED_WATERWOLF_TEXTURES = new ResourceLocation(Ref.MODID +":textures/entity/waterwolf/waterwolf_tame.png");
    private static final ResourceLocation ANRGY_WATERWOLF_TEXTURES = new ResourceLocation(Ref.MODID+":textures/entity/waterwolf/waterwolf_angry.png");
    public static final Factory FACTORY = new Factory();
    public RenderWaterWolf(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelWaterWolf(), 0.7F);
        this.addLayer(new com.kjmaster.mb.client.render.layers.LayerWolfCollar(this));
    }
    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull WaterWolf entity) {
        if (entity.isTamed())
        {
            return TAMED_WATERWOLF_TEXTURES;
        }
        else
        {
            return entity.isAngry() ? ANRGY_WATERWOLF_TEXTURES : WATERWOLF_TEXTURES;
        }
    }
    protected float handleRotationFloat(WaterWolf livingBase, float partialTicks) {
        return livingBase.getTailRotation();
    }

    @Override
    public void doRender(WaterWolf entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if (entity.isWolfWet()) {
            float f = entity.getBrightness() * entity.getShadingWhileWet(partialTicks);
            GlStateManager.color(f,f,f);
        }

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    public static class Factory implements IRenderFactory<WaterWolf> {
        @Override
        public Render<? super WaterWolf> createRenderFor(RenderManager manager) {
            return new RenderWaterWolf(manager);
        }
    }
}