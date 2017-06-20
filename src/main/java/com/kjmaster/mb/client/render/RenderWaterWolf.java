package com.kjmaster.mb.client.render;

import com.kjmaster.mb.Ref;
import com.kjmaster.mb.entities.WaterWolf;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by pbill_000 on 15/06/2017.
 */
@SideOnly(Side.CLIENT)
public class RenderWaterWolf extends RenderLiving<WaterWolf> {
    private static final  ResourceLocation WATERWOLF_TEXTURES = new ResourceLocation(Ref.MODID + ":textures/entity/waterwolf/waterwolf.png");
    private static final ResourceLocation TAMED_WATERWOLF_TEXTURES = new ResourceLocation(Ref.MODID +":textures/entity/waterwolf/waterwolf_tame.png");
    private static final ResourceLocation ANRGY_WATERWOLF_TEXTURES = new ResourceLocation(Ref.MODID+":textures/entity/waterwolf/waterwolf_angry.png");
    public RenderWaterWolf(RenderManager renderManager, ModelBase modelBase, float shadowsize) {
        super(renderManager, modelBase, shadowsize);
        this.addLayer(new com.kjmaster.mb.client.render.layers.LayerWolfCollar(this));
    }
    protected ResourceLocation getEntityTexture(WaterWolf entity) {
        return entity.isTamed()?TAMED_WATERWOLF_TEXTURES:(entity.isAngry()?ANRGY_WATERWOLF_TEXTURES:WATERWOLF_TEXTURES);
    }
    protected float handleRotationFloat(WaterWolf livingBase, float partialTicks) {
        return livingBase.getTailRotation();
    }


    @Override
    protected void preRenderCallback(WaterWolf entitylivingbaseIn, float partialTickTime) {}
    public void doRender(WaterWolf entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if(entity.isWolfWet()) {
            float f = entity.getShadingWhileWet(partialTicks);
            GlStateManager.color(f, f, f);
        }

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}