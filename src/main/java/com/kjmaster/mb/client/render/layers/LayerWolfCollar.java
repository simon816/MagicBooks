package com.kjmaster.mb.client.render.layers;

import com.kjmaster.mb.client.render.RenderWaterWolf;
import com.kjmaster.mb.entities.WaterWolf;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by pbill_000 on 17/06/2017.
 */
@SideOnly(Side.CLIENT)
public class LayerWolfCollar implements LayerRenderer<WaterWolf> {
    private static final ResourceLocation WOLF_COLLAR = new ResourceLocation("textures/entity/wolf/wolf_collar.png");
    private final RenderWaterWolf renderWaterWolf;

    public LayerWolfCollar(RenderWaterWolf waterRenderIn) {
        this.renderWaterWolf = waterRenderIn;
    }

    @Override
    public void doRenderLayer(WaterWolf entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if(entitylivingbaseIn.isTamed() && !entitylivingbaseIn.isInvisible()) {
            this.renderWaterWolf.bindTexture(WOLF_COLLAR);
            float[] afloat = EntitySheep.getDyeRgb(entitylivingbaseIn.getCollarColor());
            GlStateManager.color(afloat[0], afloat[1], afloat[2]);
            this.renderWaterWolf.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }

    public boolean shouldCombineTextures() {
        return true;
    }
}
