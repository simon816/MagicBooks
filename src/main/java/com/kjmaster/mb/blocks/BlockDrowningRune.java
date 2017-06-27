package com.kjmaster.mb.blocks;

import com.kjmaster.mb.init.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by pbill_000 on 27/06/2017.
 */
public class BlockDrowningRune extends BlockBase {
    public BlockDrowningRune(String name,
                            Material mat,
                            CreativeTabs tab,
                            float hardness,
                            float resistance,
                            String tool,
                            int harvest) {
        super(name, mat, tab, hardness, resistance, tool, harvest);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(ModBlocks.wallingRuneBlock);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if(entityIn instanceof EntityMob) {
            ((EntityMob) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS,9600, 9000 ));
            entityIn.attackEntityFrom(DamageSource.DROWN, 1.0F);

        }
    }
}
