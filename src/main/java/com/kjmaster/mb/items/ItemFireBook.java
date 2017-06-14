package com.kjmaster.mb.items;

import com.kjmaster.mb.skillpoints.fire.FireSkillPointsProvider;
import com.kjmaster.mb.skillpoints.fire.IFireSkillPoints;
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
public class ItemFireBook extends ItemBase {
    public ItemFireBook(String name, CreativeTabs tab, int maxSize) {
        super(name, tab, maxSize);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {

        if(!(world.isRemote)) {
            IFireSkillPoints fireSkillPoints = player.getCapability(FireSkillPointsProvider.FIRESKILLPOINTS_CAP, null);
            fireSkillPoints.addFire(1);
            float points = fireSkillPoints.getFireSkillPoints();
            player.sendMessage(new TextComponentString(TextFormatting.RED + "You now have " + points + " fire skill points" ));

        }
        if(world.isRemote) {
            player.sendMessage(new TextComponentString(TextFormatting.RED + "You earned 1 fire skill point"));




        }

        player.inventory.decrStackSize(player.inventory.currentItem, 1);
        return super.onItemRightClick(world, player, hand);
    }
}
