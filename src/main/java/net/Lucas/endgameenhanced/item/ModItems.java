package net.Lucas.endgameenhanced.item;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.item.custom.*;
import net.Lucas.endgameenhanced.item.custom.armor.*;
import net.Lucas.endgameenhanced.item.custom.mobdrops.*;
import net.Lucas.endgameenhanced.item.custom.tools.InfernalPickaxe;
import net.Lucas.endgameenhanced.item.custom.tools.LeviathansAxe;
import net.Lucas.endgameenhanced.item.custom.tools.ScytheOfVitur;
import net.Lucas.endgameenhanced.item.custom.tools.UnkemptHarold;
import net.Lucas.endgameenhanced.item.custom.weapons.*;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EndGameEnhanced.MOD_ID);
    //Common = white text
    //Uncommon = yellow text
    //Rare = aqua text
    //Epic = light_purple text
    //when enchanted they go up a rarity tier

//gems
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OPAL = ITEMS.register("opal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> JADE = ITEMS.register("jade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ONYX = ITEMS.register("onyx",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));

//mob drops
    public static final RegistryObject<Item> SMOULDERING_STONE = ITEMS.register("smouldering_stone", () -> new SmoulderingStone(new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> ENDER_DRAGON_SCALE = ITEMS.register("ender_dragon_scale", () -> new EnderDragonScale(new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> SCULK_CRYSTAL = ITEMS.register("sculk_crystal", () -> new SculkCrystal(new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> CHARGED_BLAZE_ROD = ITEMS.register("charged_blaze_rod", () -> new ChargedBlazeRod(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> HUGE_NETHER_WART = ITEMS.register("huge_nether_wart", () -> new HugeNetherWart(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> WITHER_SKELETON_BONE = ITEMS.register("wither_skeleton_bone", () -> new WitherSkeletonBone(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> SPIDER_FANG = ITEMS.register("spider_fang", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> CREEPER_FUSE = ITEMS.register("creeper_fuse", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> SOAKED_FLESH = ITEMS.register("soaked_flesh", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> FLESH_JERKY = ITEMS.register("flesh_jerky", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> MAGMA_BUTTER = ITEMS.register("magma_butter", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> RIP_BONE = ITEMS.register("rib_bone", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> SLIME_GLOB = ITEMS.register("slime_glob", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> FROZEN_BONE = ITEMS.register("frozen_bone", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> NOT_SO_ROTTEN_FLESH = ITEMS.register("not_so_rotten_flesh", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> PIGLINS_GOLD_COIN = ITEMS.register("piglins_gold_coin", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> CAVE_SPIDER_EYE = ITEMS.register("cave_spider_eye", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ENDERMITE_EGG = ITEMS.register("endermite_egg", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> GHAST_TENTACLE = ITEMS.register("ghast_tentacle", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> GUARDIAN_SPIKE = ITEMS.register("guardian_spike", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> HOGLIN_TUSK = ITEMS.register("hoglin_tusk", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> PHANTOM_WING = ITEMS.register("phantom_wing", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> DAMAGED_CROSSBOW = ITEMS.register("damaged_crossbow", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> DISCOLORED_SHULKER_SHELL = ITEMS.register("discolored_shulker_shell", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> WITCHS_BREW = ITEMS.register("witchs_brew", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> FLAWLESS_ENDER_PEARL = ITEMS.register("flawless_ender_pearl", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ELDER_GUARDIAN_SPIKE = ITEMS.register("elder_guardian_spike", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> RITUAL_BOOK = ITEMS.register("ritual_book", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> AXE_HILT = ITEMS.register("axe_hilt", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> RAVAGER_HORN = ITEMS.register("ravager_horn", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BROKEN_AXE = ITEMS.register("broken_axe", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> SENSOR_TENDRIL = ITEMS.register("sensor_tendril", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> SHRIEKER_NOISE_BOX = ITEMS.register("shrieker_noise_box", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> PLENTIFUL_WHEAT = ITEMS.register("plentiful_wheat", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ODD_SHAPED_BEETROOT = ITEMS.register("odd_shaped_beetroot", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> SMALL_CARROT = ITEMS.register("small_carrot", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ODD_SHAPED_POTATO = ITEMS.register("odd_shaped_potato", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> HUGE_PITCHER_PLANT = ITEMS.register("huge_pitcher_plant", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> CACTUS_SPINE = ITEMS.register("cactus_spine", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BIOLUMINESCENT_TORCHFLOWER = ITEMS.register("bioluminescent_torchflower", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> THICK_SUGAR_CANE = ITEMS.register("thick_sugar_cane", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));

    //inevitable weapons/tools
    public static final RegistryObject<Item> NETHER_BLADE = ITEMS.register("nether_blade",
            () -> new NetherBlade(ModToolTiers.INEVITABLE, 6, -2.4F,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> END_BLADE = ITEMS.register("end_blade",
            () -> new EndBlade(ModToolTiers.INEVITABLE, 6, -2.4F,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SCULK_BLADE = ITEMS.register("sculk_blade",
            () -> new SculkBlade(ModToolTiers.INEVITABLE, 6, -2.4F,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> WEBWEAVER_BOW = ITEMS.register("webweaver_bow",
            () -> new WebweaverBow(new Item.Properties().fireResistant().rarity(Rarity.EPIC).durability(6969)));
    public static final RegistryObject<Item> SCULK_SLINGER = ITEMS.register("sculk_slinger",
            () -> new SculkSlingerCrossbow(new Item.Properties().fireResistant().rarity(Rarity.EPIC).durability(6969)));
    public static final RegistryObject<Item> TIDE_BREAKER = ITEMS.register("tide_breaker",
            () -> new TideBreakerTrident(new Item.Properties().fireResistant().rarity(Rarity.EPIC).durability(6969)));
    public static final RegistryObject<Item> LEVIATHANS_AXE = ITEMS.register("leviathans_axe",
            () -> new LeviathansAxe(ModToolTiers.INEVITABLE, 9, -3F, new
                    Item.Properties().rarity(Rarity.EPIC).fireResistant()));
    public static final RegistryObject<Item> SCYTHE_OF_VITUR = ITEMS.register("scythe_of_vitur",
            () -> new ScytheOfVitur(ModToolTiers.INEVITABLE, 6, -3F, new
                    Item.Properties().rarity(Rarity.EPIC).fireResistant()));
    public static final RegistryObject<Item> UNKEMPT_HAROLD = ITEMS.register("unkempt_harold",
            () -> new UnkemptHarold(ModToolTiers.INEVITABLE, 1.5f, -3F, new
                    Item.Properties().rarity(Rarity.EPIC).fireResistant()));
    public static final RegistryObject<Item> INFERNAL_PICKAXE = ITEMS.register("infernal_pickaxe",
            () -> new InfernalPickaxe(ModToolTiers.INEVITABLE, 1, -2.8F, new
                    Item.Properties().rarity(Rarity.EPIC).fireResistant()));



    public static final RegistryObject<Item> DIAMOND_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("diamond_upgrade_smithing_template", CustomSmithingTemplateItem::createOnyxUpgradeTemplate);
    public static final RegistryObject<Item> ONYX_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("onyx_upgrade_smithing_template", CustomSmithingTemplateItem::createNetheriteUpgradeTemplate);




    //onyx tools
    public static final RegistryObject<Item> ONYX_SWORD = ITEMS.register("onyx_sword",
            () -> new SwordItem(ModToolTiers.ONYX, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> ONYX_SHOVEL = ITEMS.register("onyx_shovel",
            () -> new ShovelItem(ModToolTiers.ONYX, 1.5F, -3F, new Item.Properties()));
    public static final RegistryObject<Item> ONYX_PICKAXE = ITEMS.register("onyx_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ONYX, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> ONYX_AXE = ITEMS.register("onyx_axe",
            () -> new AxeItem(ModToolTiers.ONYX, 5, -3F, new Item.Properties()));
    public static final RegistryObject<Item> ONYX_HOE = ITEMS.register("onyx_hoe",
            () -> new HoeItem(ModToolTiers.ONYX, -3, 0, new Item.Properties()));

    //jade tools
    public static final RegistryObject<Item> JADE_SWORD = ITEMS.register("jade_sword",
            () -> new SwordItem(ModToolTiers.JADE, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> JADE_SHOVEL = ITEMS.register("jade_shovel",
            () -> new ShovelItem(ModToolTiers.JADE, 1.5F, -3F, new Item.Properties()));
    public static final RegistryObject<Item> JADE_PICKAXE = ITEMS.register("jade_pickaxe",
            () -> new PickaxeItem(ModToolTiers.JADE, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> JADE_AXE = ITEMS.register("jade_axe",
            () -> new AxeItem(ModToolTiers.JADE, 6, -3.2F, new Item.Properties()));
    public static final RegistryObject<Item> JADE_HOE = ITEMS.register("jade_hoe",
            () -> new HoeItem(ModToolTiers.JADE, -1, -2, new Item.Properties()));

    //opal tools
    public static final RegistryObject<Item> OPAL_SWORD = ITEMS.register("opal_sword",
            () -> new SwordItem(ModToolTiers.OPAL, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> OPAL_SHOVEL = ITEMS.register("opal_shovel",
            () -> new ShovelItem(ModToolTiers.OPAL, 1.5F, -3F, new Item.Properties()));
    public static final RegistryObject<Item> OPAL_PICKAXE = ITEMS.register("opal_pickaxe",
            () -> new PickaxeItem(ModToolTiers.OPAL, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> OPAL_AXE = ITEMS.register("opal_axe",
            () -> new AxeItem(ModToolTiers.OPAL, 6, -3.2F, new Item.Properties()));
    public static final RegistryObject<Item> OPAL_HOE = ITEMS.register("opal_hoe",
            () -> new HoeItem(ModToolTiers.OPAL, -1, -2, new Item.Properties()));

    //sapphire tools
    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",
            () -> new SwordItem(ModToolTiers.SAPPHIRE, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",
            () -> new ShovelItem(ModToolTiers.SAPPHIRE, 1.5F, -3F, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SAPPHIRE, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe",
            () -> new AxeItem(ModToolTiers.SAPPHIRE, 6, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe",
            () -> new HoeItem(ModToolTiers.SAPPHIRE, -2, -1, new Item.Properties()));

    //emerald tools
    public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword",
            () -> new SwordItem(ModToolTiers.EMERALD, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel",
            () -> new ShovelItem(ModToolTiers.EMERALD, 1.5F, -3F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe",
            () -> new PickaxeItem(ModToolTiers.EMERALD, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe",
            () -> new AxeItem(ModToolTiers.EMERALD, 6, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe",
            () -> new HoeItem(ModToolTiers.EMERALD, -2, -1, new Item.Properties()));

    //ruby tools
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ModToolTiers.RUBY, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModToolTiers.RUBY, 1.5F, -3F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModToolTiers.RUBY, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModToolTiers.RUBY, 5, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModToolTiers.RUBY, -3, 0, new Item.Properties()));

//onyx armor
    public static final RegistryObject<Item> ONYX_HELMET = ITEMS.register("onyx_helmet",
            () -> new ArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ONYX_CHESTPLATE = ITEMS.register("onyx_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ONYX_LEGGINGS = ITEMS.register("onyx_leggings",
            () -> new ArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ONYX_BOOTS = ITEMS.register("onyx_boots",
            () -> new ArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.BOOTS, new Item.Properties()));

//inevitable armor
    public static final RegistryObject<Item> INEVITABLE_HELMET = ITEMS.register("inevitable_helmet",
            () -> new ObsidianHelmet(ModArmorMaterials.INEVITABLE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> INEVITABLE_CHESTPLATE = ITEMS.register("inevitable_chestplate",
            () -> new ObsidianChestplate(ModArmorMaterials.INEVITABLE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> INEVITABLE_LEGGINGS = ITEMS.register("inevitable_leggings",
            () -> new ObsidianLeggings(ModArmorMaterials.INEVITABLE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> INEVITABLE_BOOTS = ITEMS.register("inevitable_boots",
            () -> new ObsidianBoots(ModArmorMaterials.INEVITABLE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));


//potions
    public static final RegistryObject<Item> EXPERIENCE_BOTTLE_NETHER_WART = ITEMS.register("experience_bottle_nether_wart",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EXPERIENCE_BOTTLE_NETHER_WART_CHORUS_FRUIT = ITEMS.register("experience_bottle_nether_wart_chorus_fruit",
            () -> new Item(new Item.Properties()));

//essence
    public static final RegistryObject<Item> BASIC_ESSENCE = ITEMS.register("basic_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SPIDER_ESSENCE = ITEMS.register("spider_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRENCHED_ESSENCE = ITEMS.register("drenched_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MINESHAFT_ESSENCE = ITEMS.register("mineshaft_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VOLATILE_ESSENCE = ITEMS.register("volatile_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CORRUPTING_ESSENCE = ITEMS.register("corrupting_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PRISMATIC_ESSENCE = ITEMS.register("prismatic_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SCULK_ESSENCE = ITEMS.register("sculk_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OCEAN_ESSENCE = ITEMS.register("ocean_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMOULDERING_ESSENCE = ITEMS.register("smouldering_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VOIDED_ESSENCE = ITEMS.register("voided_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PILLAGED_ESSENCE = ITEMS.register("pillaged_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHER_ESSENCE = ITEMS.register("nether_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> END_ESSENCE = ITEMS.register("end_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_ESSENCE = ITEMS.register("ancient_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WARNING_ESSENCE = ITEMS.register("warning_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LAVA_ESSENCE = ITEMS.register("lava_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DARKNESS_ESSENCE = ITEMS.register("darkness_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WATER_ESSENCE = ITEMS.register("water_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORE_ESSENCE = ITEMS.register("ore_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_ESSENCE = ITEMS.register("gem_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TREE_ESSENCE = ITEMS.register("tree_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HARVEST_ESSENCE = ITEMS.register("harvest_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_PLANT_ESSENCE = ITEMS.register("small_plant_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TALL_PLANT_ESSENCE = ITEMS.register("tall_plant_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EARTHLY_ESSENCE = ITEMS.register("earthly_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SECLUDED_ESSENCE = ITEMS.register("secluded_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EXPLOSIVE_ESSENCE = ITEMS.register("explosive_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOUGHNESS_ESSENCE = ITEMS.register("toughness_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SPEED_ESSENCE = ITEMS.register("speed_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BOOST_ESSENCE = ITEMS.register("boost_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VISION_ESSENCE = ITEMS.register("vision_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CONDUIT_ESSENCE = ITEMS.register("conduit_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INFERNAL_ESSENCE = ITEMS.register("infernal_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNKEMPT_ESSENCE = ITEMS.register("unkempt_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SANGUINE_ESSENCE = ITEMS.register("sanguine_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BREACH_ESSENCE = ITEMS.register("breach_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STABILIZED_ESSENCE = ITEMS.register("stabilized_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SWIFT_ESSENCE = ITEMS.register("swift_essence", () -> new Item(new Item.Properties()));



//inevitable templates and pure essence
    public static final RegistryObject<Item> NETHERRATH_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("netherrath_upgrade_smithing_template", CustomSmithingTemplateItem::createNetherrathUpgradeTemplate);
    public static final RegistryObject<Item> PURE_NETHER_ESSENCE = ITEMS.register("pure_nether_essence",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> VOIDWAKER_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("voidwaker_upgrade_smithing_template", CustomSmithingTemplateItem::createVoidwakerUpgradeTemplate);
    public static final RegistryObject<Item> PURE_END_ESSENCE = ITEMS.register("pure_end_essence",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> SCULK_BRINGER_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("sculk_bringer_upgrade_smithing_template", CustomSmithingTemplateItem::createSculkBringerUpgradeTemplate);
    public static final RegistryObject<Item> PURE_SCULK_ESSENCE = ITEMS.register("pure_sculk_essence",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> SCULK_SLINGER_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("sculk_slinger_upgrade_smithing_template", CustomSmithingTemplateItem::createSculkSlingerUpgradeTemplate);
    public static final RegistryObject<Item> PURE_EVIL_ESSENCE = ITEMS.register("pure_evil_essence",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> WEBWEAVER_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("webweaver_upgrade_smithing_template", CustomSmithingTemplateItem::createWebweaverUpgradeTemplate);
    public static final RegistryObject<Item> PURE_SPIDER_ESSENCE = ITEMS.register("pure_spider_essence",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> TIDE_BREAKER_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("tide_breaker_upgrade_smithing_template", CustomSmithingTemplateItem::createTideBreakerUpgradeTemplate);
    public static final RegistryObject<Item> PURE_OCEAN_ESSENCE = ITEMS.register("pure_ocean_essence",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> INFERNAL_PICKAXE_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("infernal_pickaxe_upgrade_smithing_template", CustomSmithingTemplateItem::createInfernalPickaxeUpgradeTemplate);
    public static final RegistryObject<Item> PURE_FIRE_ESSENCE = ITEMS.register("pure_fire_essence",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> UNKEMPT_HAROLD_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("unkempt_harold_upgrade_smithing_template", CustomSmithingTemplateItem::createUnkemptHaroldUpgradeTemplate);
    public static final RegistryObject<Item> PURE_EXPLOSIVE_ESSENCE = ITEMS.register("pure_explosive_essence",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> LEVIATHANS_AXE_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("leviathans_axe_upgrade_smithing_template", CustomSmithingTemplateItem::createLeviathansAxeUpgradeTemplate);
    public static final RegistryObject<Item> PURE_NATURE_ESSENCE = ITEMS.register("pure_nature_essence",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> SCYTHE_OF_VITUR_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("scythe_of_vitur_upgrade_smithing_template", CustomSmithingTemplateItem::createScytheOfViturUpgradeTemplate);
    public static final RegistryObject<Item> PURE_BLOOD_ESSENCE = ITEMS.register("pure_blood_essence",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> OBSIDIAN_ARMOR_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("obsidian_armor_upgrade_smithing_template", CustomSmithingTemplateItem::createObsidianArmorUpgradeTemplate);
    public static final RegistryObject<Item> PURE_TOUGH_ESSENCE = ITEMS.register("pure_tough_essence",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> PURE_RESOLUTE_ESSENCE = ITEMS.register("pure_resolute_essence",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> PURE_RESILIENT_ESSENCE = ITEMS.register("pure_resilient_essence",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> PURE_RESISTANT_ESSENCE = ITEMS.register("pure_resistant_essence",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
