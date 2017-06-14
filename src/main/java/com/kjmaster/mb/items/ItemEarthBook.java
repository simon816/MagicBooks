package com.kjmaster.mb.items;

import com.kjmaster.mb.skillpoints.earth.EarthSkillPointsProvider;
import com.kjmaster.mb.skillpoints.earth.IEarthSkillPoints;
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
public class ItemEarthBook extends ItemBase {
    public ItemEarthBook(String name, CreativeTabs tab, int maxSize) {
        super(name, tab, maxSize);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {

        if(!(world.isRemote)) {
            IEarthSkillPoints earthSkillPoints = player.getCapability(EarthSkillPointsProvider.EARTHSKILLPOINTS_CAP, null);
            earthSkillPoints.addEarth(1);
            float points = earthSkillPoints.getEarthSkillPoints();
            player.sendMessage(new TextComponentString(TextFormatting.GREEN + "You now have " + points + " earth skill points" ));

        }
        if(world.isRemote) {
            player.sendMessage(new TextComponentString(TextFormatting.GREEN + "You earned 1 earth skill point"));




        }

        player.inventory.decrStackSize(player.inventory.currentItem, 1);
        return super.onItemRightClick(world, player, hand);
    }
}
