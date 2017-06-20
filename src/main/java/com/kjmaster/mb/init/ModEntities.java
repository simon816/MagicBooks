package com.kjmaster.mb.init;

import com.kjmaster.mb.MagicBooks;
import com.kjmaster.mb.entities.WaterWolf;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * Created by pbill_000 on 15/06/2017.
 */
public class ModEntities {
    public static void registerEntities() {
        EntityRegistry.registerModEntity(new ResourceLocation("mb:textures/entity/watergolem.png"), WaterWolf.class, "mb_watergolem", 0, MagicBooks.instance, 64, 2, true);
    }
    public static void generateSpawnEgg() {
        EntityRegistry.registerEgg(new ResourceLocation("mb:textures/entity/watergolem.png"), 3, 3);
    }
}