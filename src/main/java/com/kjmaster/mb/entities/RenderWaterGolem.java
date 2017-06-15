package com.kjmaster.mb.entities;

import com.kjmaster.mb.util.AssetUtil;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

/**
 * Created by pbill_000 on 15/06/2017.
 */
public class RenderWaterGolem extends Render<WaterGolem> {
    private static final ResourceLocation WATERGOLEM_TEXTURES = new ResourceLocation("mb:textures/entity/watergolem");
    public static final IRenderFactory FACTORY = new IRenderFactory() {
        @Override
        public Render createRenderFor(RenderManager manager) {
            return new RenderWaterGolem(manager);
        }
    };
    protected RenderWaterGolem(RenderManager renderManager) {
        super(renderManager);
    }

    protected ResourceLocation getEntityTexture(WaterGolem entity) {
        return WATERGOLEM_TEXTURES;
    }

    public void doRender(WaterGolem entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.pushMatrix();
        GlStateManager.popMatrix();
    }
}
