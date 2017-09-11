package com.kjmaster.mb.events;

import com.kjmaster.mb.MagicBooks;
import com.kjmaster.mb.client.ConfigHandler;
import com.kjmaster.mb.guide.ExampleBook;
import com.kjmaster.mb.network.ModGuiHandler;
import com.kjmaster.mb.util.Guide;
import com.kjmaster.mb.util.TagUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.items.ItemHandlerHelper;

/**
 * Created by pbill_000 on 27/08/2017.
 */
public class EntityJoinEvent {
    @SubscribeEvent
    public void onPlayerLoggedIn(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event) {
        EntityPlayer player = event.player;
        NBTTagCompound playerData = player.getEntityData();
        NBTTagCompound data = TagUtil.getTagSafe(playerData, EntityPlayer.PERSISTED_NBT_TAG);
        if(!data.getBoolean("has_magic_book") && Guide.isGuideEnabled && ConfigHandler.isBookEnabled) {
            ItemHandlerHelper.giveItemToPlayer(player, ExampleBook.bookStack);
            data.setBoolean("has_magic_book", true);
            playerData.setTag(EntityPlayer.PERSISTED_NBT_TAG, data);
        }
    }
}