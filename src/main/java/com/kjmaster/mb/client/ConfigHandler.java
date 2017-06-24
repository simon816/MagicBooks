package com.kjmaster.mb.client;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by pbill_000 on 19/06/2017.
 */
public class ConfigHandler {
    public static Configuration config;

    //Earth Spells
    public static boolean isBonemealEnabled;
    public static boolean isWallingRuneEnabled;
    public static boolean isClearWallEnabled;
    //Air Spells
    public static boolean isInvisibilityEnabled;
    public static boolean isLightningEnabled;
    public static int configuredLightningCooldown;
    //Fire Spells
    public static boolean isFireBlastEnabled;
    //Water Spells
    public static boolean isWaterWolfEnabled;
    public static int maxWaterWolves;

    public static void init(File file) {
        config = new Configuration(file);
        syncConfig();
    }
    public static void syncConfig() {
        String category;
        category = "Earth Spells";
        config.addCustomCategoryComment(category, "Earth Spells Settings");
        isBonemealEnabled = config.getBoolean("isBonemealEnabled", category, true, "Sets whether the bonemeal spell is enabled or not");
        isWallingRuneEnabled = config.getBoolean("isWallingRuneEnabled", category, true, "Sets whether the spawn walling rune spell is enabled or not");
        isClearWallEnabled = config.getBoolean("isClearWallEnabled", category, true, "Sets whether the clear wall spell is enabled or not");
        category = "Air Spells";
        config.addCustomCategoryComment(category, "Air Spells Settings");
        isInvisibilityEnabled = config.getBoolean("isInvisibilityEnabled", category, true, "Sets whether the invisibility spell is enabled or not");
        isLightningEnabled = config.getBoolean("isLightningEnabled", category, true, "Sets whether the lightning spell is enabled or not");
        configuredLightningCooldown = config.getInt("configuredLightningCooldown", category, 600, 0, 8192, "Set the length of the lightning cooldown in ticks");

        category = "Fire Spells";
        config.addCustomCategoryComment(category, "Fire Spells Settings");
        isFireBlastEnabled = config.getBoolean("isFireBlastEnabled", category, true, "Sets whether the fire blast spell is enabled or not");

        category = "Water Spells";
        config.addCustomCategoryComment(category, "Water Spells Settings");
        isWaterWolfEnabled = config.getBoolean("isWaterWolfEnabled", category, true, "Sets whether the water wolf spell is enabled or not");
        maxWaterWolves = config.getInt("maxWaterWolves", category, 10, 1, 30, "Set max number of water wolves a player can spawn");
        config.save();
    }
}
