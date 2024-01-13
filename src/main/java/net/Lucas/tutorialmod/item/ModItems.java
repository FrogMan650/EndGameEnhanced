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
            () -> new NetherBlade(ModToolTiers.INEVITABLE, 4, -2.4F,
                    new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> END_BLADE = ITEMS.register("end_blade",
            () -> new EndBlade(ModToolTiers.INEVITABLE, 4, -2.4F,
                    new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> SCULK_BLADE = ITEMS.register("sculk_blade",
            () -> new SculkBlade(ModToolTiers.INEVITABLE, 4, -2.4F,
                    new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> WEBWEAVER_BOW = ITEMS.register("webweaver_bow",
            () -> new CustomBowItem(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON).durability(5000)));
    public static final RegistryObject<Item> SCULK_SLINGER = ITEMS.register("sculk_slinger",
            () -> new CustomCrossbowItem(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON).durability(5000)));










    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final Component ONYX_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.diamond_upgrade"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component ONYX_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("tutorialmod:onyx"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component ONYX_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("onyx_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component ONYX_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.base_slot_description")));
    private static final Component ONYX_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.additions_slot_description")));
    private static final ResourceLocation EMPTY_SLOT_HELMET = new ResourceLocation("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = new ResourceLocation("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = new ResourceLocation("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = new ResourceLocation("item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_HOE = new ResourceLocation("item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE = new ResourceLocation("item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = new ResourceLocation("item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = new ResourceLocation("item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = new ResourceLocation("item/empty_slot_pickaxe");
    private static final ResourceLocation EMPTY_SLOT_INGOT = new ResourceLocation("item/empty_slot_ingot");
    private static final ResourceLocation EMPTY_SLOT_REDSTONE_DUST = new ResourceLocation("item/empty_slot_redstone_dust");
    private static final ResourceLocation EMPTY_SLOT_QUARTZ = new ResourceLocation("item/empty_slot_quartz");
    private static final ResourceLocation EMPTY_SLOT_EMERALD = new ResourceLocation("item/empty_slot_emerald");
    private static final ResourceLocation EMPTY_SLOT_DIAMOND = new ResourceLocation("item/empty_slot_diamond");
    private static final ResourceLocation EMPTY_SLOT_LAPIS_LAZULI = new ResourceLocation("item/empty_slot_lapis_lazuli");
    private static final ResourceLocation EMPTY_SLOT_AMETHYST_SHARD = new ResourceLocation("item/empty_slot_amethyst_shard");

    public static final RegistryObject<Item> DIAMOND_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("diamond_upgrade_smithing_template", () -> new SmithingTemplateItem(
            ONYX_UPGRADE_APPLIES_TO, ONYX_UPGRADE_INGREDIENTS, ONYX_UPGRADE, ONYX_UPGRADE_BASE_SLOT_DESCRIPTION, ONYX_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
            createOnyxUpgradeIconList(), createOnyxUpgradeMaterialList()));
    private static List<ResourceLocation> createOnyxUpgradeIconList() {
        return List.of(EMPTY_SLOT_SWORD, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_AXE, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL, EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS);
    }
    private static List<ResourceLocation> createOnyxUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_EMERALD);
    }


    private static final Component NETHERITE_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.onyx_equipment"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component NETHERITE_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component NETHERITE_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("netherite_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component NETHERITE_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.base_slot_description")));
    private static final Component NETHERITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.additions_slot_description")));

    public static final RegistryObject<Item> ONYX_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("onyx_upgrade_smithing_template", () -> new SmithingTemplateItem(
            NETHERITE_UPGRADE_APPLIES_TO, NETHERITE_UPGRADE_INGREDIENTS, NETHERITE_UPGRADE, NETHERITE_UPGRADE_BASE_SLOT_DESCRIPTION, NETHERITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
    createNetheriteUpgradeIconList(), createNetheriteUpgradeMaterialList()));

    private static List<ResourceLocation> createNetheriteUpgradeIconList() {
        return List.of(EMPTY_SLOT_SWORD, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_AXE, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL, EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS);
    }
    private static List<ResourceLocation> createNetheriteUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }

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






















    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
