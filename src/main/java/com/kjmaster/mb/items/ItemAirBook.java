package com.kjmaster.mb.items;

import com.kjmaster.mb.skillpoints.air.AirSkillPointsProvider;
import com.kjmaster.mb.skillpoints.air.IAirSkillPoints;
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
public class ItemAirBook extends ItemBase {
    public ItemAirBook(String name, CreativeTabs tab, int maxSize) {
        super(name, tab, maxSize);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {

        if(!(world.isRemote)) {
            IAirSkillPoints airSkillPoints = player.getCapability(AirSkillPointsProvider.AIRSKILLPOINTS_CAP, null);
            airSkillPoints.addAir(1);
            float points = airSkillPoints.getAirSkillPoints();
            player.sendMessage(new TextComponentString(TextFormatting.WHITE + "You now have " + points + " air skill points" ));

        }
        if(world.isRemote) {
            player.sendMessage(new TextComponentString(TextFormatting.WHITE + "You earned 1 air skill point"));




        }

        player.inventory.decrStackSize(player.inventory.currentItem, 1);

        return super.onItemRightClick(world, player, hand);
    }
}

