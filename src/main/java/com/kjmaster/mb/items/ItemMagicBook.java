package com.kjmaster.mb.items;

import com.kjmaster.mb.MagicBooks;
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
import com.kjmaster.mb.handlers.EnumHandler;
import com.kjmaster.mb.mana.IManaContainerItem;
import com.kjmaster.mb.util.NBTHelper;
import com.kjmaster.mb.util.spells.*;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by pbill_000 on 25/07/2017.
 */
public class ItemMagicBook extends Item implements IManaContainerItem {
    private int capacity;
    private int maxReceive;
    private int maxExtract;

    public ItemMagicBook(String unlocalizedName, CreativeTabs tab, int maxSize, int capacity, int maxReceive, int maxExtract) {
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(Ref.MODID, unlocalizedName));
        this.setHasSubtypes(true);
        this.setMaxStackSize(maxSize);
        this.setCreativeTab(tab);
        this.setCapacity(capacity);
        this.setMaxReceive(maxReceive);
        this.setMaxExtract(maxExtract);
    }

    public ItemMagicBook setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public void setMaxTransfer(int maxTransfer) {

        setMaxReceive(maxTransfer);
        setMaxExtract(maxTransfer);
    }

    public void setMaxReceive(int maxReceive) {

        this.maxReceive = maxReceive;
    }

    public void setMaxExtract(int maxExtract) {

        this.maxExtract = maxExtract;
    }

    //Earth Mana
    @Override
    public int receiveEarthMana(ItemStack container, int maxReceive, boolean simulate) {
        return NBTHelper.receiveEarthMana(container, maxReceive, getMaxEarthManaStored(container), simulate);
    }

    @Override
    public int extractEarthMana(ItemStack container, int maxExtract, boolean simulate) {
        return NBTHelper.extractEarthMana(container, maxExtract, simulate);
    }

    @Override
    public int getEarthManaStored(ItemStack container) {
        return NBTHelper.getEarthManaStored(container);
    }

    @Override
    public int getMaxEarthManaStored(ItemStack container) {
        return capacity;
    }

    //Air Mana
    @Override
    public int receiveAirMana(ItemStack container, int maxRecieve, boolean simulate) {
        return NBTHelper.receiveAirMana(container, maxRecieve, getMaxAirManaStored(container), simulate);
    }

    @Override
    public int extractAirMana(ItemStack container, int maxExtract, boolean simulate) {
        return NBTHelper.extractAirMana(container, maxExtract, simulate);
    }

    @Override
    public int getAirManaStored(ItemStack container) {
        return NBTHelper.getAirManaStored(container);
    }

    @Override
    public int getMaxAirManaStored(ItemStack container) {
        return capacity;
    }

    //Fire Mana
    @Override
    public int receiveFireMana(ItemStack container, int maxRecieve, boolean simulate) {
        return NBTHelper.receiveFireMana(container, maxRecieve, getMaxAirManaStored(container), simulate);
    }

    @Override
    public int extractFireMana(ItemStack container, int maxExtract, boolean simulate) {
        return NBTHelper.extractFireMana(container, maxExtract, simulate);
    }

    @Override
    public int getFireManaStored(ItemStack container) {
        return NBTHelper.getFireManaStored(container);
    }

    @Override
    public int getMaxFireManaStored(ItemStack container) {
        return capacity;
    }

    //Water Mana
    @Override
    public int receiveWaterMana(ItemStack container, int maxRecieve, boolean simulate) {
        return NBTHelper.receiveWaterMana(container, maxRecieve, getMaxAirManaStored(container), simulate);
    }

    @Override
    public int extractWaterMana(ItemStack container, int maxExtract, boolean simulate) {
        return NBTHelper.extractWaterMana(container, maxExtract, simulate);
    }

    @Override
    public int getWaterManaStored(ItemStack container) {
        return NBTHelper.getWaterManaStored(container);
    }

    @Override
    public int getMaxWaterManaStored(ItemStack container) {
        return capacity;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        int earthMana;
        int airMana;
        int fireMana;
        int waterMana;

        if(stack.getTagCompound() == null) {
            earthMana = 0;
            airMana = 0;
            fireMana = 0;
            waterMana = 0;
        } else {
            earthMana = stack.getTagCompound().getInteger("EarthMana");
            airMana = stack.getTagCompound().getInteger("AirMana");
            fireMana = stack.getTagCompound().getInteger("FireMana");
            waterMana = stack.getTagCompound().getInteger("WaterMana");
        }

        tooltip.add("Earth Mana: " + earthMana);
        tooltip.add("Air Mana: " + airMana);
        tooltip.add("Fire Mana: " + fireMana);
        tooltip.add("Water Mana: " + waterMana);

        super.addInformation(stack, worldIn, tooltip, flagIn);
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
        ItemStack bookStack = player.inventory.getCurrentItem();
        ItemMagicBook bookItem = (ItemMagicBook) bookStack.getItem();
        if(player.isSneaking()) {
           bookItem.receiveEarthMana(bookStack, 100, false);
           bookItem.receiveWaterMana(bookStack, 100, false);
           bookItem.receiveFireMana(bookStack, 100, false);
           bookItem.receiveAirMana(bookStack, 100, false);
        } else {
            if(meta == 0) {
                if(player.world.isRemote) {
                    player.openGui(MagicBooks.instance, 4, worldIn, (int)player.posX, (int)player.posY, (int)player.posZ );
                }
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
                                    Bonemeal.castBonemeal(worldIn, player, bookStack);
                                    break;
                                case "clearwall":
                                    ClearWall.castClearWall(worldIn, player, bookStack);
                                    break;
                                case "invisibility":
                                    Invisibility.castInvisibility(worldIn, player, bookStack);
                                    break;
                                case "lightning":
                                    Lightning.castLightning(worldIn, player, bookStack);
                                    break;
                                case "fireblast":
                                    FireBlast.castFireBlast(worldIn, player, bookStack);
                                    break;
                                case "waterwolf":
                                    WaterWolf.castWaterWolf(worldIn, player, bookStack);
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
                                    Bonemeal.castBonemeal(worldIn, player, bookStack);
                                    break;
                                case "clearwall":
                                    ClearWall.castClearWall(worldIn, player, bookStack);
                                    break;
                                case "invisibility":
                                    Invisibility.castInvisibility(worldIn, player, bookStack);
                                    break;
                                case "lightning":
                                    Lightning.castLightning(worldIn, player, bookStack);
                                    break;
                                case "fireblast":
                                    FireBlast.castFireBlast(worldIn, player, bookStack);
                                    break;
                                case "waterwolf":
                                    WaterWolf.castWaterWolf(worldIn, player, bookStack);
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
                                    Bonemeal.castBonemeal(worldIn, player, bookStack);
                                    break;
                                case "clearwall":
                                    ClearWall.castClearWall(worldIn, player, bookStack);
                                    break;
                                case "invisibility":
                                    Invisibility.castInvisibility(worldIn, player, bookStack);
                                    break;
                                case "lightning":
                                    Lightning.castLightning(worldIn, player, bookStack);
                                    break;
                                case "fireblast":
                                    FireBlast.castFireBlast(worldIn, player, bookStack);
                                    break;
                                case "waterwolf":
                                    WaterWolf.castWaterWolf(worldIn, player, bookStack);
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
                                    Bonemeal.castBonemeal(worldIn, player, bookStack);
                                    break;
                                case "clearwall":
                                    ClearWall.castClearWall(worldIn, player, bookStack);
                                    break;
                                case "invisibility":
                                    Invisibility.castInvisibility(worldIn, player, bookStack);
                                    break;
                                case "lightning":
                                    Lightning.castLightning(worldIn, player, bookStack);
                                    break;
                                case "fireblast":
                                    FireBlast.castFireBlast(worldIn, player, bookStack);
                                    break;
                                case "waterwolf":
                                    WaterWolf.castWaterWolf(worldIn, player, bookStack);
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
                                    Bonemeal.castBonemeal(worldIn, player, bookStack);
                                    break;
                                case "clearwall":
                                    ClearWall.castClearWall(worldIn, player, bookStack);
                                    break;
                                case "invisibility":
                                    Invisibility.castInvisibility(worldIn, player, bookStack);
                                    break;
                                case "lightning":
                                    Lightning.castLightning(worldIn, player, bookStack);
                                    break;
                                case "fireblast":
                                    FireBlast.castFireBlast(worldIn, player, bookStack);
                                    break;
                                case "waterwolf":
                                    WaterWolf.castWaterWolf(worldIn, player, bookStack);
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
                                    Bonemeal.castBonemeal(worldIn, player, bookStack);
                                    break;
                                case "clearwall":
                                    ClearWall.castClearWall(worldIn, player, bookStack);
                                    break;
                                case "invisibility":
                                    Invisibility.castInvisibility(worldIn, player, bookStack);
                                    break;
                                case "lightning":
                                    Lightning.castLightning(worldIn, player, bookStack);
                                    break;
                                case "fireblast":
                                    FireBlast.castFireBlast(worldIn, player, bookStack);
                                    break;
                                case "waterwolf":
                                    WaterWolf.castWaterWolf(worldIn, player, bookStack);
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
                                    Bonemeal.castBonemeal(worldIn, player, bookStack);
                                    break;
                                case "clearwall":
                                    ClearWall.castClearWall(worldIn, player, bookStack);
                                    break;
                                case "invisibility":
                                    Invisibility.castInvisibility(worldIn, player, bookStack);
                                    break;
                                case "lightning":
                                    Lightning.castLightning(worldIn, player, bookStack);
                                    break;
                                case "fireblast":
                                    FireBlast.castFireBlast(worldIn, player, bookStack);
                                    break;
                                case "waterwolf":
                                    WaterWolf.castWaterWolf(worldIn, player, bookStack);
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
                                    Bonemeal.castBonemeal(worldIn, player, bookStack);
                                    break;
                                case "clearwall":
                                    ClearWall.castClearWall(worldIn, player, bookStack);
                                    break;
                                case "invisibility":
                                    Invisibility.castInvisibility(worldIn, player, bookStack);
                                    break;
                                case "lightning":
                                    Lightning.castLightning(worldIn, player, bookStack);
                                    break;
                                case "fireblast":
                                    FireBlast.castFireBlast(worldIn, player, bookStack);
                                    break;
                                case "waterwolf":
                                    WaterWolf.castWaterWolf(worldIn, player, bookStack);
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
        }
        return super.onItemRightClick(worldIn, player, handIn);
    }
}
