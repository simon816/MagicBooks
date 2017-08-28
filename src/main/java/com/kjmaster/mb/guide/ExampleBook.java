package com.kjmaster.mb.guide;

import amerifrance.guideapi.api.GuideAPI;
import amerifrance.guideapi.api.GuideBook;
import amerifrance.guideapi.api.IGuideBook;
import amerifrance.guideapi.api.IPage;
import amerifrance.guideapi.api.impl.Book;
import amerifrance.guideapi.api.impl.abstraction.CategoryAbstract;
import amerifrance.guideapi.api.impl.abstraction.EntryAbstract;
import amerifrance.guideapi.category.CategoryItemStack;
import amerifrance.guideapi.entry.EntryItemStack;
import amerifrance.guideapi.page.*;
import com.kjmaster.mb.Ref;
import com.kjmaster.mb.init.ModBlocks;
import com.kjmaster.mb.init.ModItems;
import com.kjmaster.mb.util.Guide;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pbill_000 on 19/08/2017.
 */
@GuideBook
public class ExampleBook implements IGuideBook {

    public static Book magicGuide;
    public static ItemStack bookStack = null;
    @Nullable
    @Override
    public Book buildBook() {

        //Intro Category

        //Map of Entries
        Map<ResourceLocation, EntryAbstract> entries1 = new LinkedHashMap<>();

        //Creation of first entry
        List<IPage> introPages1 = new ArrayList<IPage>();
        introPages1.add(new PageText(
                "Welcome to the guide for MagicBooks.\n\n" +
                        "Within this book you will find everything you need to know about the mod and how to get started."));
        entries1.put(new ResourceLocation(Ref.MODID,"entry_intro"),
                    new EntryItemStack(introPages1, "Introduction", new ItemStack(ModItems.MagicBook)));
        //Creation of second entry
        List<IPage> introPages2 = new ArrayList<IPage>();
        introPages2.add(new PageText(
                "MagicBooks is a magic mod based around the idea that the world of Minecraft contains the four natural elements; air, earth, fire and, water." +
                        " Each of these elements has physical manifestations in the form of mana, ores and shards." +
                        " The world contains whispers of a secret fifth element known as the arcane."
                ));
        introPages2.add(new PageText(
                        "This element is said to be found when all four other elements combine.\n\n" +
                        "Through the use of magical items and blocks it is possible for you to harness the power of these elements."
        ));
        entries1.put(new ResourceLocation(Ref.MODID, "entry_intro2"),
                    new EntryItemStack(introPages2, "Explanation", new ItemStack(Item.getItemFromBlock(ModBlocks.greaterFireCrystalBlock))));

        //World Gen Category

        //Map of Entries
        Map<ResourceLocation, EntryAbstract> entries2 = new LinkedHashMap<>();

        //Creation of first entry
        List<IPage> worldGenPages1 = new ArrayList<IPage>();
        worldGenPages1.add(new PageTextImage("The first ore MagicBooks adds is air shard ore. This drops air shards.", new ResourceLocation(Ref.MODID, "textures/blocks/air_shard_ore.png"), true));
        worldGenPages1.add(new PageTextImage("Next is earth shard ore. This drops earth shards.", new ResourceLocation(Ref.MODID, "textures/blocks/earth_shard_ore.png"), true));
        worldGenPages1.add(new PageTextImage("Next is fire shard ore. This drops fire shards.", new ResourceLocation(Ref.MODID, "textures/blocks/fire_shard_ore.png"), true));
        worldGenPages1.add(new PageTextImage("Finally is water shard ore. This drops water shards.", new ResourceLocation(Ref.MODID, "textures/blocks/water_shard_ore.png"), true));
        worldGenPages1.add(new PageText(
                            "All ores will spawn between y: 5 and y: 18 and are fairly common."
                ));
        entries2.put(new ResourceLocation(Ref.MODID, "entry_worldgen1"),
                    new EntryItemStack(worldGenPages1, "Ore Generation", new ItemStack(Item.getItemFromBlock(ModBlocks.earthShardOre))));

        //Creation of second entry
        List<IPage> worldGenPages2 = new ArrayList<IPage>();
        worldGenPages2.add(new PageText("MagicBooks currently adds 4 structures to the world. This is one for each natural element." +
                        " In the centre of each structure there is a greater crystal corresponding to the element of the structure." +
                        " This greater crystal produces 500 mana of it's element type per tick. "));
        worldGenPages2.add(new PageTextImage("This is the air structure. It spawns high in the world above y: 160.", new ResourceLocation(Ref.MODID, "guide/air_structure.png"), true));
        worldGenPages2.add(new PageTextImage("This is the earth structure. It spawns on ground level in plains, forest, hills and savanna biomes.", new ResourceLocation(Ref.MODID, "guide/earth_structure.png"), true));
        worldGenPages2.add(new PageTextImage("This is the fire structure. It spawns on ground level in desert and savanna biomes.", new ResourceLocation(Ref.MODID, "guide/fire_structure.png"), true));
        worldGenPages2.add(new PageTextImage("This is the water structure. It spawns on seabed level in ocean biomes.", new ResourceLocation(Ref.MODID, "guide/water_structure.png"), true));
        entries2.put(new ResourceLocation(Ref.MODID, "entry_worldgen2"),
                    new EntryItemStack(worldGenPages2, "Structure Generation", new ItemStack(Item.getItemFromBlock(ModBlocks.greaterFireCrystalBlock))));

        //Mana Category

        //Map of Entries
        Map<ResourceLocation, EntryAbstract> entries3 = new LinkedHashMap<>();

        //Creation of first entry
        List<IPage> manaPages1 = new ArrayList<>();
        manaPages1.add(new PageText(
                "To get started with mana craft some crystals for each element, a crystal linker, a mana infuser and a magic book." +
                        " Then, find one of the element structures in the world and check out the entry about the crystal linker." +
                        " Now you know how the crystal linker works you need to link the greater crystal to a normal"));
        manaPages1.add(new PageText("crystal and then the normal crystal to a mana infuser." +
                " Now you can place your magic book in the mana infuser to fill it up with 10,000 mana of the element type of the greater crystal." +
                " Now mine the greater crystal so you can get it and bring it back to your base!"));
        entries3.put(new ResourceLocation(Ref.MODID, "entry_mana1"),
                    new EntryItemStack(manaPages1, "Mana Intro", new ItemStack(Item.getItemFromBlock(ModBlocks.greaterAirCrystalBlock))));

        //Creation of second entry
        List<IPage> manaPages2 = new ArrayList<>();
        manaPages2.add(new PageText("The crystal linker in MagicBooks is used to link crystals together (hence the name)." +
                " You can do this by first shift right clicking on the block/crystal you wish to connect a crystal to." +
                " You then shift right click the crystal." +
                " This creates a magical link between the crystal and block/crystal"));
        manaPages2.add(new PageTextImage(
                "and the crystal will now send mana to the block/crystal.",
                new ResourceLocation(Ref.MODID, "textures/items/crystal_linker.png"), true));
        manaPages2.add(new PageIRecipe(new ShapedOreRecipe(new ResourceLocation(Ref.MODID, "entry_mana2"),
                ModItems.CrystalLinker,
                "  A",
                        " S ",
                        "S  ",
                'A', ModItems.ArcaneShard,
                'S', Items.STICK)));
        entries3.put(new ResourceLocation(Ref.MODID, "entry_mana2"),
                    new EntryItemStack(manaPages2, "Crystal Linker", new ItemStack(ModItems.CrystalLinker)));

        //Spells Category

        //Map of Entries
        Map<ResourceLocation, EntryAbstract> entries4 = new LinkedHashMap<>();

        //Creation of first entry
        List<IPage> spellsPages1 = new ArrayList<>();
        spellsPages1.add(new PageText("Spells in MagicBooks are all cast using the magic book and require skill points to be unlocked." +
                " Skill points can be obtained by right clicking the elemental books." +
                " The recipes for the books are on the next few pages."));
        spellsPages1.add(new PageIRecipe(new ShapedOreRecipe(new ResourceLocation("recipe", "book_air"),
                ModItems.AirBook,
            "SSS",
                    "SBS",
                    "SSS",
                'S', ModItems.AirShard,
                'B', Items.BOOK)));
        spellsPages1.add(new PageIRecipe(new ShapedOreRecipe(new ResourceLocation("recipe", "book_earth"),
                ModItems.EarthBook,
            "SSS",
                    "SBS",
                    "SSS",
                'S', ModItems.EarthShard,
                'B', Items.BOOK)));
        spellsPages1.add(new PageIRecipe(new ShapedOreRecipe(new ResourceLocation("recipe", "book_fire"),
                ModItems.FireBook,
            "SSS",
                    "SBS",
                    "SSS",
                'S', ModItems.FireShard,
                'B', Items.BOOK)));
        spellsPages1.add(new PageIRecipe(new ShapedOreRecipe(new ResourceLocation("recipe", "book_water"),
                ModItems.WaterBook,
            "SSS",
                    "SBS",
                    "SSS",
                'S', ModItems.WaterShard,
                'B', Items.BOOK)));
        spellsPages1.add(new PageText("Once you have obtained skill points you can then use them to unlock spells in the GUI that appears when 'M' is pressed (or your chosen keybind)." +
                " Now you have unlocked spells you can use the magic book to it's full potential. Right clicking a magic book will display another GUI where spells can be"));
        spellsPages1.add(new PageText("chosen. You can then cycle through these chosen spells with 'U' (or your chosen keybind) when you are holding a magic book." +
                " Right clicking on a magic book set to a spell, with a spell chosen, will cast the chosen spell if the required amount of mana is available."));
        entries4.put(new ResourceLocation(Ref.MODID, "entry_spells1"),
                new EntryItemStack(spellsPages1, "Spells Intro", new ItemStack(ModItems.MagicBook)));

        //Creation of second entry
        List<IPage> spellsPages2 = new ArrayList<>();
        spellsPages2.add(new PageText("The first earth spell MagicBooks adds is the bonemeal spell. Using this spell on plants and crops accelerates their growth."));
        spellsPages2.add(new PageText("The next spell is the clear wall spell. This spell can be used to remove blocks made by the rune of walling by using the spell on the rune."));
        entries4.put(new ResourceLocation(Ref.MODID, "entry_spells2"),
                new EntryItemStack(spellsPages2, "Earth Spells", new ItemStack(ModItems.EarthBook)));

        //Creation of third entry
        List<IPage> spellsPages3 = new ArrayList<>();
        spellsPages3.add(new PageText("The first air spell added by MagicBooks is the invisibility spell." +
                " Casting this spell will make you invisible and make you visible if already invisible." +
                " The mana cost will only apply when turning invisible."));
        spellsPages3.add(new PageText("The next air spell is the lightning spell. This spell will smite all mobs in the surrounding area." +
                " This spell has a cooldown alongside the mana cost."));
        entries4.put(new ResourceLocation(Ref.MODID, "entry_spells3"),
                new EntryItemStack(spellsPages3, "Air Spells", new ItemStack(ModItems.AirBook)));
        //Creation of fourth entry
        List<IPage> firePage = new ArrayList<>();
        firePage.add(new PageText("MagicBooks currently adds only one fire spell. This spell lights all mobs in a surrounding area on fire."));
        entries4.put(new ResourceLocation(Ref.MODID, "fire_page"),
                new EntryItemStack(firePage, "Fire Spells", new ItemStack(ModItems.FireBook)));
        //Creation of fifth entry
        List<IPage> spellsPages5 = new ArrayList<>();
        spellsPages5.add(new PageText("MagicBooks currently adds only one water spell. This spell spawns in a water wolf and can only be casted 10 times (can be changed in config)." +
                " Remember to breed the wolves if you want more!"));
        entries4.put(new ResourceLocation(Ref.MODID, "entry_spells4"),
                new EntryItemStack(spellsPages5, "Water Spells", new ItemStack(ModItems.WaterBook)));
        //Creation of sixth entry
        List<IPage> manaCostPage = new ArrayList<>();
        manaCostPage.add(new PageText("        Earth Spells:         " + "\n" +
        "Bonemeal: 100" + "\n" +
        "Clear Wall: 25" + "\n" + "\n" +
        "        Air Spells:          " + "\n" +
        "Invisibility: 500" + "\n" +
        "Lightning: 2500" + "\n" + "\n" +
        "        Fire Spells:         " + "\n" +
        "Fire Blast: 1000"));
        manaCostPage.add(new PageText(
        "        Water Spells:         " + "\n" +
        "Water Wolf: 2500"));
        entries4.put(new ResourceLocation(Ref.MODID, "mana_cost_page"),
                new EntryItemStack(manaCostPage, "Mana Costs", new ItemStack(ModItems.MagicBook)));

        //Runes Category

        //Map of Entries
        Map<ResourceLocation, EntryAbstract> entries5 = new LinkedHashMap<>();

        //Creation of First Entry
        List<IPage> runesPages1 = new ArrayList<>();

        runesPages1.add(new PageText("The rune of drowning will slow down mobs on top of it and slowly drown them."));
        entries5.put(new ResourceLocation(Ref.MODID, "runes_entry1"),
                new EntryItemStack(runesPages1, "Rune of Drowning", new ItemStack(Item.getItemFromBlock(ModBlocks.drowningRuneBlock))));

        //Creation of Second Entry
        List<IPage> runesPages2 = new ArrayList<>();

        runesPages2.add(new PageText("The rune of walling will create a wall when it is right clicked by a player." +
                " Right click the top of the rune to spawn the wall on the z-axis." +
                " The wall can be destroyed with the clear wall spell."));
        entries5.put(new ResourceLocation(Ref.MODID, "runes_entry2"),
                new EntryItemStack(runesPages2, "Rune of Walling", new ItemStack(Item.getItemFromBlock(ModBlocks.wallingRuneBlock))));

        //Creation of Third Entry
        List<IPage> runesPages3 = new ArrayList<>();

        runesPages3.add(new PageText("The rune of lumber accepts axes and earth mana and in exchange it will cut down trees grown on it's north, south, east and west side directly adjacent." +
                "An axe used in the rune of lumber will eventually break and will need to be replaced." +
                " The rune will attempt to place any obtained items in an adjacent inventory."));
        runesPages3.add(new PageText("If the rune fails to find an inventory it will spew the items into the world."));
        entries5.put(new ResourceLocation(Ref.MODID, "runes_entry3"),
                new EntryItemStack(runesPages3, "Rune of Lumber", new ItemStack(Item.getItemFromBlock(ModBlocks.woodCutRuneBlock))));

        //Setup list of categories and add entries
        List<CategoryAbstract> categories = new ArrayList<CategoryAbstract>();
        categories.add(new CategoryItemStack(entries1, "Introduction", new ItemStack(ModItems.MagicBook)));
        categories.add(new CategoryItemStack(entries2, "World Gen", new ItemStack(Item.getItemFromBlock(ModBlocks.greaterWaterCrystalBlock))));
        categories.add(new CategoryItemStack(entries3, "Mana", new ItemStack(ModItems.CrystalLinker)));
        categories.add(new CategoryItemStack(entries4, "Spells", new ItemStack(ModItems.EarthBook)));
        categories.add(new CategoryItemStack(entries5, "Runes", new ItemStack(Item.getItemFromBlock(ModBlocks.woodCutRuneBlock))));

        //Book's base info
        magicGuide = new Book();
        magicGuide.setTitle("MagicBooks Guide");
        magicGuide.setDisplayName("MagicBooks Guide");
        magicGuide.setAuthor("kjmaster");
        magicGuide.setColor(Color.CYAN);
        magicGuide.setCategoryList(categories);
        magicGuide.setRegistryName(new ResourceLocation(Ref.MODID, "magic_books_guide"));
        return magicGuide;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void handleModel(@Nonnull ItemStack bookStack) {
        GuideAPI.setModel(magicGuide);
    }

    @Override
    public void handlePost(@Nonnull ItemStack bookStack) {
        Guide.isGuideEnabled = true;
        this.bookStack = bookStack;
    }
}

