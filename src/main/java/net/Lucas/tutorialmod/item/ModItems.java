package net.Lucas.tutorialmod.item;

import net.Lucas.tutorialmod.TutorialMod;
import net.Lucas.tutorialmod.item.custom.*;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);
    //Common = white text
    //Uncommon = yellow text
    //Rare = aqua text
    //Epic = light_purple text
    //when enchanted they go up a rarity tier

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OPAL = ITEMS.register("opal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> JADE = ITEMS.register("jade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ONYX = ITEMS.register("onyx",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> SMOULDERING_STONE = ITEMS.register("smouldering_stone",
            () -> new SmoulderingStone(new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> ENDER_DRAGON_SCALE = ITEMS.register("ender_dragon_scale",
            () -> new EnderDragonScale(new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> SCULK_CRYSTAL = ITEMS.register("sculk_crystal",
            () -> new SculkCrystal(new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> CHARGED_BLAZE_ROD = ITEMS.register("charged_blaze_rod",
            () -> new ChargedBlazeRod(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> HUGE_NETHER_WART = ITEMS.register("huge_nether_wart",
            () -> new HugeNetherWart(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> WITHER_SKELETON_BONE = ITEMS.register("wither_skeleton_bone",
            () -> new WitherSkeletonBone(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));

    //inevitable
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
            () -> new CustomBowItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC).durability(6969)));
    public static final RegistryObject<Item> SCULK_SLINGER = ITEMS.register("sculk_slinger",
            () -> new CustomCrossbowItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC).durability(6969)));
    public static final RegistryObject<Item> TIDE_BREAKER = ITEMS.register("tide_breaker",
            () -> new CustomTridentItem(new Item.Properties().fireResistant().rarity(Rarity.EPIC).durability(6969)));
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


    public static final RegistryObject<Item> ONYX_HELMET = ITEMS.register("onyx_helmet",
            () -> new ArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ONYX_CHESTPLATE = ITEMS.register("onyx_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ONYX_LEGGINGS = ITEMS.register("onyx_leggings",
            () -> new ArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ONYX_BOOTS = ITEMS.register("onyx_boots",
            () -> new ArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> INEVITABLE_HELMET = ITEMS.register("inevitable_helmet",
            () -> new ObsidianHelmet(ModArmorMaterials.INEVITABLE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> INEVITABLE_CHESTPLATE = ITEMS.register("inevitable_chestplate",
            () -> new ObsidianChestplate(ModArmorMaterials.INEVITABLE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> INEVITABLE_LEGGINGS = ITEMS.register("inevitable_leggings",
            () -> new ObsidianLeggings(ModArmorMaterials.INEVITABLE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> INEVITABLE_BOOTS = ITEMS.register("inevitable_boots",
            () -> new ObsidianBoots(ModArmorMaterials.INEVITABLE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> BASIC_ESSENCE = ITEMS.register("basic_essence",
            () -> new Item(new Item.Properties()));


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













    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
