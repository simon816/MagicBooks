package com.kjmaster.mb.util.spells;

import com.google.common.base.Predicate;
import com.kjmaster.mb.client.ConfigHandler;
import com.kjmaster.mb.init.ModItems;
import com.kjmaster.mb.items.ItemMagicBook;
import com.kjmaster.mb.spellmanager.fire.fireblast.FireBlastManagerProvider;
import com.kjmaster.mb.spellmanager.fire.fireblast.IFireBlastManager;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pbill_000 on 25/07/2017.
 */
public class FireBlast {
    public static void castFireBlast(World world, EntityPlayer player, ItemStack itemStack) {
        if(ConfigHandler.isFireBlastEnabled) {
            if (!(player.world.isRemote)) {
                IFireBlastManager FIREBLAST_UNLOCKED = player.getCapability(FireBlastManagerProvider.FIREBLAST_MANAGER_CAP, null);
                float FireBlast = FIREBLAST_UNLOCKED.getFireBlast();
                if (FireBlast == 1) {
                    Item item = itemStack.getItem();
                    if (item.equals(ModItems.MagicBook)) {
                        ItemMagicBook magicBook = (ItemMagicBook) item;
                        if (magicBook.getFireManaStored(itemStack) >= 1000) {
                            magicBook.extractFireMana(itemStack, 1000, false);
                            player.sendMessage(new TextComponentString(TextFormatting.RED + "FIRE BLAST!"));
                            List<BlockPos> blocks = new ArrayList<BlockPos>();
                            int range = 10;
                            for (int x = -range; x < range + 1; x++) {
                                for (int z = -range; z < range + 1; z++) {
                                    for (int y = -range; y < range + 1; y++) {
                                        int theX = MathHelper.floor(player.posX + x);
                                        int theY = MathHelper.floor(player.posY + y);
                                        int theZ = MathHelper.floor(player.posZ + z);
                                        BlockPos posInQuestion = new BlockPos(theX, theY, theZ);
                                        blocks.add(posInQuestion);

                                    }
                                }
                            }

                            if (!blocks.isEmpty()) {
                                for (int i = 0; i < 45; i++) {
                                    for (EntityMob e : world.getEntities(EntityMob.class, new Predicate<EntityMob>() {

                                        @Override
                                        public boolean apply(EntityMob input) {
                                            return (input.getDistanceToEntity(player) <= 20);
                                        }
                                    })) {
                                        BlockPos pos = e.getPosition();
                                        double x = pos.getX();
                                        double y = pos.getY();
                                        double z = pos.getZ();
                                        e.setFire(20);
                                        e.attackEntityFrom(new DamageSource("magic"), 2F);

                                    }
                                }
                            }
                        } else {
                            player.sendMessage(new TextComponentString(TextFormatting.RED + "Not enough fire mana!"));
                        }
                    }
                } else {
                    player.sendMessage(new TextComponentString(TextFormatting.RED + "This spell has not been unlocked!"));
                }
            }
        } else {
            player.sendMessage(new TextComponentString(TextFormatting.RED + "This spell has been disabled!"));
        }
    }
}
