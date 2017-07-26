package com.kjmaster.mb.items;

import com.kjmaster.mb.Ref;
import com.kjmaster.mb.chosenspells.chosenspell.ChosenSpellProvider;
import com.kjmaster.mb.chosenspells.chosenspell.IChosenSpell;
import com.kjmaster.mb.chosenspells.chosenspell2.ChosenSpell2Provider;
import com.kjmaster.mb.chosenspells.chosenspell2.IChosenSpell2;
import com.kjmaster.mb.chosenspells.chosenspell3.ChosenSpell3Provider;
import com.kjmaster.mb.chosenspells.chosenspell3.IChosenSpell3;
import com.kjmaster.mb.chosenspells.chosenspell4.ChosenSpell4Provider;
import com.kjmaster.mb.chosenspells.chosenspell4.IChosenSpell4;
import com.kjmaster.mb.chosenspells.chosenspell5.ChosenSpell5Provider;
import com.kjmaster.mb.chosenspells.chosenspell5.IChosenSpell5;
import com.kjmaster.mb.chosenspells.chosenspell6.ChosenSpell6Provider;
import com.kjmaster.mb.chosenspells.chosenspell6.IChosenSpell6;
import com.kjmaster.mb.chosenspells.chosenspell7.ChosenSpell7Provider;
import com.kjmaster.mb.chosenspells.chosenspell7.IChosenSpell7;
import com.kjmaster.mb.chosenspells.chosenspell8.ChosenSpell8Provider;
import com.kjmaster.mb.chosenspells.chosenspell8.IChosenSpell8;
import com.kjmaster.mb.guis.magicbook.GuiMagicBook1;
import com.kjmaster.mb.handlers.EnumHandler;
import com.kjmaster.mb.util.spells.*;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by pbill_000 on 25/07/2017.
 */
public class ItemMagicBook extends Item {
    public ItemMagicBook(String unlocalizedName, CreativeTabs tab, int maxSize) {
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(Ref.MODID, unlocalizedName));
        this.setHasSubtypes(true);
        this.setMaxStackSize(maxSize);
        this.setCreativeTab(tab);
    }

    public void getSubItems(Item item, CreativeTabs tab, NonNullList<ItemStack> items) {
        for(int i = 0; i < EnumHandler.MagicBookTypes.values().length; i++) {
            items.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        for(int i = 0; i < EnumHandler.MagicBookTypes.values().length; i++) {
            if(stack.getItemDamage() == i) {
                return this.getUnlocalizedName() + "." + EnumHandler.MagicBookTypes.values()[i].getName();
            }
            else {
                continue;
            }
        }
        return this.getUnlocalizedName() + "." + EnumHandler.MagicBookTypes.NOSPELL.getName();
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn) {
        int meta = player.getHeldItem(handIn).getItemDamage();
        if(meta == 0) {
            Minecraft.getMinecraft().displayGuiScreen(new GuiMagicBook1());
        } else {
            if (!(player.world.isRemote)) {
                IChosenSpell ChosenSpell = player.getCapability(ChosenSpellProvider.CHOSENSPELL_CAP, null);
                String chosenspell = ChosenSpell.getChosenSpell();
                IChosenSpell2 ChosenSpell2 = player.getCapability(ChosenSpell2Provider.CHOSENSPELL2_CAP, null);
                String chosenspell2 = ChosenSpell2.getChosenSpell2();
                IChosenSpell3 ChosenSpell3 = player.getCapability(ChosenSpell3Provider.CHOSENSPELL3_CAP, null);
                String chosenspell3 = ChosenSpell3.getChosenSpell3();
                IChosenSpell4 ChosenSpell4 = player.getCapability(ChosenSpell4Provider.CHOSENSPELL4_CAP, null);
                String chosenspell4 = ChosenSpell4.getChosenSpell4();
                IChosenSpell5 ChosenSpell5 = player.getCapability(ChosenSpell5Provider.CHOSENSPELL5_CAP, null);
                String chosenspell5 = ChosenSpell5.getChosenSpell5();
                IChosenSpell6 ChosenSpell6 = player.getCapability(ChosenSpell6Provider.CHOSENSPELL6_CAP, null);
                String chosenspell6 = ChosenSpell6.getChosenSpell6();
                IChosenSpell7 ChosenSpell7 = player.getCapability(ChosenSpell7Provider.CHOSENSPELL7_CAP, null);
                String chosenspell7 = ChosenSpell7.getChosenSpell7();
                IChosenSpell8 ChosenSpell8 = player.getCapability(ChosenSpell8Provider.CHOSENSPELL8_CAP, null);
                String chosenspell8 = ChosenSpell8.getChosenSpell8();
                switch (meta) {
                    case 1 :
                        switch (chosenspell) {
                            case "bonemeal":
                                Bonemeal.castBonemeal(worldIn, player);
                                break;
                            case "clearwall":
                                ClearWall.castClearWall(worldIn, player);
                                break;
                            case "invisibility":
                                Invisibility.castInvisibility(worldIn, player);
                                break;
                            case "lightning":
                                Lightning.castLightning(worldIn, player);
                                break;
                            case "fireblast":
                                FireBlast.castFireBlast(worldIn, player);
                                break;
                            case "waterwolf":
                                WaterWolf.castWaterWolf(worldIn, player);
                                break;
                            case "nothing":
                                // do nothing
                                break;
                            default:
                                // do nothing
                                break;
                        }
                        break;
                    case 2 :
                        switch (chosenspell2) {
                            case "bonemeal":
                                Bonemeal.castBonemeal(worldIn, player);
                                break;
                            case "clearwall":
                                ClearWall.castClearWall(worldIn, player);
                                break;
                            case "invisibility":
                                Invisibility.castInvisibility(worldIn, player);
                                break;
                            case "lightning":
                                Lightning.castLightning(worldIn, player);
                                break;
                            case "fireblast":
                                FireBlast.castFireBlast(worldIn, player);
                                break;
                            case "waterwolf":
                                WaterWolf.castWaterWolf(worldIn, player);
                                break;
                            case "nothing":
                                // do nothing
                                break;
                            default:
                                // do nothing
                                break;
                        }
                        break;
                    case 3:
                        switch (chosenspell3) {
                            case "bonemeal":
                                Bonemeal.castBonemeal(worldIn, player);
                                break;
                            case "clearwall":
                                ClearWall.castClearWall(worldIn, player);
                                break;
                            case "invisibility":
                                Invisibility.castInvisibility(worldIn, player);
                                break;
                            case "lightning":
                                Lightning.castLightning(worldIn, player);
                                break;
                            case "fireblast":
                                FireBlast.castFireBlast(worldIn, player);
                                break;
                            case "waterwolf":
                                WaterWolf.castWaterWolf(worldIn, player);
                                break;
                            case "nothing":
                                // do nothing
                                break;
                            default:
                                // do nothing
                                break;
                        }
                        break;
                    case 4:
                        switch (chosenspell4) {
                            case "bonemeal":
                                Bonemeal.castBonemeal(worldIn, player);
                                break;
                            case "clearwall":
                                ClearWall.castClearWall(worldIn, player);
                                break;
                            case "invisibility":
                                Invisibility.castInvisibility(worldIn, player);
                                break;
                            case "lightning":
                                Lightning.castLightning(worldIn, player);
                                break;
                            case "fireblast":
                                FireBlast.castFireBlast(worldIn, player);
                                break;
                            case "waterwolf":
                                WaterWolf.castWaterWolf(worldIn, player);
                                break;
                            case "nothing":
                                // do nothing
                                break;
                            default:
                                // do nothing
                                break;
                        }
                        break;
                    case 5:
                        switch (chosenspell5) {
                            case "bonemeal":
                                Bonemeal.castBonemeal(worldIn, player);
                                break;
                            case "clearwall":
                                ClearWall.castClearWall(worldIn, player);
                                break;
                            case "invisibility":
                                Invisibility.castInvisibility(worldIn, player);
                                break;
                            case "lightning":
                                Lightning.castLightning(worldIn, player);
                                break;
                            case "fireblast":
                                FireBlast.castFireBlast(worldIn, player);
                                break;
                            case "waterwolf":
                                WaterWolf.castWaterWolf(worldIn, player);
                                break;
                            case "nothing":
                                // do nothing
                                break;
                            default:
                                // do nothing
                                break;
                        }
                        break;
                    case 6:
                        switch (chosenspell6) {
                            case "bonemeal":
                                Bonemeal.castBonemeal(worldIn, player);
                                break;
                            case "clearwall":
                                ClearWall.castClearWall(worldIn, player);
                                break;
                            case "invisibility":
                                Invisibility.castInvisibility(worldIn, player);
                                break;
                            case "lightning":
                                Lightning.castLightning(worldIn, player);
                                break;
                            case "fireblast":
                                FireBlast.castFireBlast(worldIn, player);
                                break;
                            case "waterwolf":
                                WaterWolf.castWaterWolf(worldIn, player);
                                break;
                            case "nothing":
                                // do nothing
                                break;
                            default:
                                // do nothing
                                break;
                        }
                        break;
                    case 7:
                        switch (chosenspell7) {
                            case "bonemeal":
                                Bonemeal.castBonemeal(worldIn, player);
                                break;
                            case "clearwall":
                                ClearWall.castClearWall(worldIn, player);
                                break;
                            case "invisibility":
                                Invisibility.castInvisibility(worldIn, player);
                                break;
                            case "lightning":
                                Lightning.castLightning(worldIn, player);
                                break;
                            case "fireblast":
                                FireBlast.castFireBlast(worldIn, player);
                                break;
                            case "waterwolf":
                                WaterWolf.castWaterWolf(worldIn, player);
                                break;
                            case "nothing":
                                // do nothing
                                break;
                            default:
                                // do nothing
                                break;
                        }
                        break;
                    case 8:
                        switch (chosenspell8) {
                            case "bonemeal":
                                Bonemeal.castBonemeal(worldIn, player);
                                break;
                            case "clearwall":
                                ClearWall.castClearWall(worldIn, player);
                                break;
                            case "invisibility":
                                Invisibility.castInvisibility(worldIn, player);
                                break;
                            case "lightning":
                                Lightning.castLightning(worldIn, player);
                                break;
                            case "fireblast":
                                FireBlast.castFireBlast(worldIn, player);
                                break;
                            case "waterwolf":
                                WaterWolf.castWaterWolf(worldIn, player);
                                break;
                            case "nothing":
                                // do nothing
                                break;
                            default:
                                // do nothing
                                break;
                        }
                        break;
                    default:
                        //do nothing
                }
            }
        }
        return super.onItemRightClick(worldIn, player, handIn);
    }
}
