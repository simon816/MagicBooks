package com.kjmaster.mb.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by pbill_000 on 13/06/2017.
 */
public class AssetUtil {
    @SideOnly(Side.CLIENT)
    public static void renderItemWithoutScrewingWithColors(ItemStack stack){
        if(StackUtil.isValid(stack)){
            Minecraft mc = Minecraft.getMinecraft();
            RenderItem renderer = mc.getRenderItem();
            TextureManager manager = mc.getTextureManager();

            IBakedModel model = renderer.getItemModelWithOverrides(stack, null, null);

            manager.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            manager.getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).setBlurMipmap(false, false);
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableBlend();
            GlStateManager.pushMatrix();
            model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.FIXED, false);
            renderer.renderItem(stack, model);
            GlStateManager.cullFace(GlStateManager.CullFace.BACK);
            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
            GlStateManager.disableBlend();
            manager.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            manager.getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).restoreLastBlurMipmap();
        }
    }

}
