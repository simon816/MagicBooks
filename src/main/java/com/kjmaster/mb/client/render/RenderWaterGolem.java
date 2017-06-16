package com.kjmaster.mb.client.render;

import com.kjmaster.mb.Ref;
import com.kjmaster.mb.entities.WaterGolem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by pbill_000 on 15/06/2017.
 */
@SideOnly(Side.CLIENT)
public class RenderWaterGolem extends RenderLiving<WaterGolem> {
    private static final  ResourceLocation WATERGOLEM_TEXTURES = new ResourceLocation(Ref.MODID + ":textures/entity/watergolem.png");

    public RenderWaterGolem(RenderManager renderManager, ModelBase modelBase, float shadowsize) {
        super(renderManager, modelBase, shadowsize);
    }
    protected ResourceLocation getEntityTexture(WaterGolem entity) {
        return WATERGOLEM_TEXTURES;
    }

    @Override
    protected void preRenderCallback(WaterGolem entitylivingbaseIn, float partialTickTime) {}

}