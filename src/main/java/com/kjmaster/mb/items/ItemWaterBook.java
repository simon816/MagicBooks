package com.kjmaster.mb.items;

import com.kjmaster.mb.skillpoints.water.IWaterSkillPoints;
import com.kjmaster.mb.skillpoints.water.WaterSkillPointsProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

/**
 * Created by pbill_000 on 06/06/2017.
 */
public class ItemWaterBook extends ItemBase {
    public ItemWaterBook(String name, CreativeTabs tab, int maxSize) {
        super(name, tab, maxSize);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {

        if(!(world.isRemote)) {
            IWaterSkillPoints waterSkillPoints = player.getCapability(WaterSkillPointsProvider.WATERSKILLPOINTS_CAP, null);
            waterSkillPoints.addWater(1);
            float points = waterSkillPoints.getWaterSkillPoints();
            player.sendMessage(new TextComponentString(TextFormatting.BLUE + "You now have " + points + " water skill points" ));

        }
        if(world.isRemote) {
            player.sendMessage(new TextComponentString(TextFormatting.BLUE + "You earned 1 water skill point"));




        }
        player.inventory.decrStackSize(player.inventory.currentItem, 1);

        return super.onItemRightClick(world, player, hand);
    }
}
