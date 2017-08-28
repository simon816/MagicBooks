package com.kjmaster.mb.handlers;

import com.kjmaster.mb.MagicBooks;
import com.kjmaster.mb.Ref;
import com.kjmaster.mb.init.ModItems;
import com.kjmaster.mb.items.ItemMagicBook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by pbill_000 on 16/08/2017.
 */
public class HUDHandler {
    private static final ResourceLocation earthManaBar = new ResourceLocation(Ref.MODID, "textures/gui/earth_mana_bar.png");
    private static final ResourceLocation airManaBar = new ResourceLocation(Ref.MODID, "textures/gui/air_mana_bar.png");
    private static final ResourceLocation fireManaBar = new ResourceLocation(Ref.MODID, "textures/gui/fire_mana_bar.png");
    private static final ResourceLocation waterManaBar = new ResourceLocation(Ref.MODID, "textures/gui/water_mana_bar.png");

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onDraw(RenderGameOverlayEvent.Post event) {
        if(event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            ScaledResolution resolution = event.getResolution();
            float partialTicks = event.getPartialTicks();

            drawEarthManaBar(resolution, partialTicks);
        }
    }

    @SideOnly(Side.CLIENT)
    public void drawEarthManaBar(ScaledResolution res, float pticks) {
        Minecraft mc = Minecraft.getMinecraft();
        ItemStack heldItemStack = getItemInHand(mc.player);
        if (heldItemStack != null) {
            Item heldItem = heldItemStack.getItem();
            if(heldItem.equals(ModItems.MagicBook)) {
                ItemMagicBook book = (ItemMagicBook) heldItem;
                int earthMana = book.getEarthManaStored(heldItemStack);
                int airMana = book.getAirManaStored(heldItemStack);
                int fireMana = book.getFireManaStored(heldItemStack);
                int waterMana = book.getWaterManaStored(heldItemStack);

                // Earth Bar
                int pad = 3;
                int width = 32;
                int height = 140;
                int x = -pad;
                int y = (res.getScaledHeight() / 2 - height / 2) - 20;
                mc.renderEngine.bindTexture(earthManaBar);
                Gui.drawModalRectWithCustomSizedTexture(x, y, 0, 0, width, height, 64, 256);
                x += 9;
                y += 17;

                width = 11;
                height = 44;

                Double adjustedHeightD = earthMana * 0.0044;
                int adjustedHeight = adjustedHeightD.intValue();

                Gui.drawModalRectWithCustomSizedTexture(x, y + (height - adjustedHeight), 32, height - adjustedHeight, width, adjustedHeight , 64, 256);

                //Air Bar
                mc.renderEngine.bindTexture(airManaBar);
                width = 32;
                height = 140;
                x += 20;
                y = (res.getScaledHeight() / 2 - height / 2) - 20;
                Gui.drawModalRectWithCustomSizedTexture(x, y, 0, 0, width, height, 64, 256);
                x +=9;
                y += 17;

                width = 11;
                height = 44;

                adjustedHeightD = airMana * 0.0044;
                adjustedHeight = adjustedHeightD.intValue();

                Gui.drawModalRectWithCustomSizedTexture(x, y + (height - adjustedHeight), 32, height - adjustedHeight, width, adjustedHeight, 64, 256);

                //Fire Bar
                mc.renderEngine.bindTexture(fireManaBar);
                width = 32;
                height = 140;
                x = -pad;
                y = (res.getScaledHeight() / 2 - height / 2) + 40;
                Gui.drawModalRectWithCustomSizedTexture(x, y, 0, 0, width, height, 64, 256);

                x += 9;
                y += 17;

                width = 11;
                height = 44;

                adjustedHeightD = fireMana * 0.0044;
                adjustedHeight = adjustedHeightD.intValue();

                Gui.drawModalRectWithCustomSizedTexture(x, y + (height - adjustedHeight), 32, height - adjustedHeight, width, adjustedHeight , 64, 256);

                //Water Bar
                mc.renderEngine.bindTexture(waterManaBar);
                width = 32;
                height = 140;
                x += 20;
                y = (res.getScaledHeight() / 2 - height / 2) + 40;
                Gui.drawModalRectWithCustomSizedTexture(x, y, 0, 0, width, height, 64, 256);

                x += 9;
                y += 17;

                width = 11;
                height = 44;

                adjustedHeightD = waterMana * 0.0044;
                adjustedHeight = adjustedHeightD.intValue();

                Gui.drawModalRectWithCustomSizedTexture(x, y + (height - adjustedHeight), 32, height - adjustedHeight, width, adjustedHeight , 64, 256);
            }
        }
    }

    public static ItemStack getItemInHand(EntityPlayer player) {
        if (player == null)
            return ItemStack.EMPTY;

        else {
            return  player.getHeldItemMainhand();
        }
    }
}
