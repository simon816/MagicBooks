package com.kjmaster.mb.init;

import com.kjmaster.mb.MagicBooks;
import com.kjmaster.mb.client.render.RenderWaterGolem;
import com.kjmaster.mb.entities.WaterGolem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import javax.swing.text.html.parser.Entity;

/**
 * Created by pbill_000 on 15/06/2017.
 */
public class ModEntities {
    public static void registerEntities() {
        EntityRegistry.registerModEntity(new ResourceLocation("mb:textures/entity/watergolem.png"), WaterGolem.class, "mb_watergolem", 0, MagicBooks.instance, 64, 2, true);
    }
    public static void generateSpawnEgg() {
        EntityRegistry.registerEgg(new ResourceLocation("mb:textures/entity/watergolem.png"), 3, 3);
    }
}