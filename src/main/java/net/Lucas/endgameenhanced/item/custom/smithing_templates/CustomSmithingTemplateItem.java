package net.Lucas.endgameenhanced.item.custom.smithing_templates;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CustomSmithingTemplateItem extends SmithingTemplateItem {
    public CustomSmithingTemplateItem(Component pAppliesTo, Component pIngredients, Component pUpdradeDescription, Component pBaseSlotDescription, Component pAdditionsSlotDescription, List<ResourceLocation> pBaseSlotEmptyIcons, List<ResourceLocation> pAdditonalSlotEmptyIcons) {
        super(pAppliesTo, pIngredients, pUpdradeDescription, pBaseSlotDescription, pAdditionsSlotDescription, pBaseSlotEmptyIcons, pAdditonalSlotEmptyIcons);
    }
    private static final String DESCRIPTION_ID = Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:inevitable_smithing_template"));
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final Component INEVITABLE_NETHER_SWORD_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.inevitable_upgrade.sword"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_NETHER_SWORD_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:pure_nether_essence"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_NETHER_SWORD_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("endgameenhanced:inevitable_nether_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component INEVITABLE_NETHER_SWORD_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.sword_upgrade.base_slot_description")));
    private static final Component INEVITABLE_NETHER_SWORD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.nether_sword_upgrade.additions_slot_description")));
    private static final Component INEVITABLE_END_SWORD_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.inevitable_upgrade.sword"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_END_SWORD_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:pure_end_essence"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_END_SWORD_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("endgameenhanced:inevitable_end_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component INEVITABLE_END_SWORD_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.sword_upgrade.base_slot_description")));
    private static final Component INEVITABLE_END_SWORD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.end_sword_upgrade.additions_slot_description")));
    private static final Component INEVITABLE_SCULK_SWORD_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.inevitable_upgrade.sword"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_SCULK_SWORD_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:pure_sculk_essence"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_SCULK_SWORD_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("endgameenhanced:inevitable_sculk_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component INEVITABLE_SCULK_SWORD_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.sword_upgrade.base_slot_description")));
    private static final Component INEVITABLE_SCULK_SWORD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.sculk_sword_upgrade.additions_slot_description")));
    private static final Component INEVITABLE_SCULK_CROSSBOW_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.inevitable_upgrade.crossbow"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_SCULK_CROSSBOW_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:pure_evil_essence"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_SCULK_CROSSBOW_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("endgameenhanced:inevitable_sculk_crossbow_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component INEVITABLE_SCULK_CROSSBOW_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.crossbow_upgrade.base_slot_description")));
    private static final Component INEVITABLE_SCULK_CROSSBOW_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.crossbow_upgrade.additions_slot_description")));
    private static final Component INEVITABLE_BOW_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.inevitable_upgrade.bow"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_BOW_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:pure_spider_essence"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_BOW_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("endgameenhanced:inevitable_bow_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component INEVITABLE_BOW_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.bow_upgrade.base_slot_description")));
    private static final Component INEVITABLE_BOW_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.bow_upgrade.additions_slot_description")));
    private static final Component INEVITABLE_TRIDENT_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.inevitable_upgrade.trident"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_TRIDENT_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:pure_ocean_essence"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_TRIDENT_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("endgameenhanced:inevitable_trident_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component INEVITABLE_TRIDENT_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.trident_upgrade.base_slot_description")));
    private static final Component INEVITABLE_TRIDENT_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.trident_upgrade.additions_slot_description")));
    private static final Component INEVITABLE_PICKAXE_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.inevitable_upgrade.pickaxe"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_PICKAXE_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:pure_fire_essence"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_PICKAXE_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("endgameenhanced:inevitable_pickaxe_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component INEVITABLE_PICKAXE_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.pickaxe_upgrade.base_slot_description")));
    private static final Component INEVITABLE_PICKAXE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.pickaxe_upgrade.additions_slot_description")));
    private static final Component INEVITABLE_SHOVEL_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.inevitable_upgrade.shovel"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_SHOVEL_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:pure_explosive_essence"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_SHOVEL_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("endgameenhanced:inevitable_shovel_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component INEVITABLE_SHOVEL_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.shovel_upgrade.base_slot_description")));
    private static final Component INEVITABLE_SHOVEL_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.shovel_upgrade.additions_slot_description")));
    private static final Component INEVITABLE_AXE_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.inevitable_upgrade.axe"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_AXE_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:pure_nature_essence"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_AXE_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("endgameenhanced:inevitable_axe_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component INEVITABLE_AXE_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.axe_upgrade.base_slot_description")));
    private static final Component INEVITABLE_AXE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.axe_upgrade.additions_slot_description")));
    private static final Component INEVITABLE_HOE_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.inevitable_upgrade.hoe"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_HOE_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:pure_blood_essence"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_HOE_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("endgameenhanced:inevitable_hoe_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component INEVITABLE_HOE_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.hoe_upgrade.base_slot_description")));
    private static final Component INEVITABLE_HOE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.hoe_upgrade.additions_slot_description")));
    private static final Component INEVITABLE_ARMOR_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.inevitable_upgrade.armor"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_ARMOR_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:pure_tough_essence_ingredient"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_ARMOR_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("endgameenhanced:inevitable_armor_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component INEVITABLE_ARMOR_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.armor_upgrade.base_slot_description")));
    private static final Component INEVITABLE_ARMOR_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.armor_upgrade.additions_slot_description")));




    private static final ResourceLocation EMPTY_SLOT_HELMET = new ResourceLocation("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = new ResourceLocation("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = new ResourceLocation("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = new ResourceLocation("item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_HOE = new ResourceLocation("item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE = new ResourceLocation("item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = new ResourceLocation("item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = new ResourceLocation("item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = new ResourceLocation("item/empty_slot_pickaxe");
    private static final ResourceLocation EMPTY_SLOT_ESSENCE = new ResourceLocation("endgameenhanced:item/empty_essence");
    private static final ResourceLocation EMPTY_SLOT_CROSSBOW = new ResourceLocation("endgameenhanced:item/empty_crossbow");
    private static final ResourceLocation EMPTY_SLOT_BOW = new ResourceLocation("endgameenhanced:item/empty_bow");
    private static final ResourceLocation EMPTY_SLOT_TRIDENT = new ResourceLocation("endgameenhanced:item/empty_trident");

    private static List<ResourceLocation> createNetherrathUpgradeIconList() { return List.of(EMPTY_SLOT_SWORD); }
    private static List<ResourceLocation> createNetherrathUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_ESSENCE);
    }
    public static CustomSmithingTemplateItem createNetherrathUpgradeTemplate() {
        return new CustomSmithingTemplateItem(
                INEVITABLE_NETHER_SWORD_UPGRADE_APPLIES_TO, INEVITABLE_NETHER_SWORD_UPGRADE_INGREDIENTS,
                INEVITABLE_NETHER_SWORD_UPGRADE, INEVITABLE_NETHER_SWORD_UPGRADE_BASE_SLOT_DESCRIPTION,
                INEVITABLE_NETHER_SWORD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createNetherrathUpgradeIconList(), createNetherrathUpgradeMaterialList());
    }
    private static List<ResourceLocation> createVoidwakerUpgradeIconList() {
        return List.of(EMPTY_SLOT_SWORD); }
    private static List<ResourceLocation> createVoidwakerUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_ESSENCE); }
    public static CustomSmithingTemplateItem createVoidwakerUpgradeTemplate() {
        return new CustomSmithingTemplateItem(
                INEVITABLE_END_SWORD_UPGRADE_APPLIES_TO, INEVITABLE_END_SWORD_UPGRADE_INGREDIENTS,
                INEVITABLE_END_SWORD_UPGRADE, INEVITABLE_END_SWORD_UPGRADE_BASE_SLOT_DESCRIPTION,
                INEVITABLE_END_SWORD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createVoidwakerUpgradeIconList(), createVoidwakerUpgradeMaterialList());
    }
    private static List<ResourceLocation> createSculkBringerUpgradeIconList() {
        return List.of(EMPTY_SLOT_SWORD); }
    private static List<ResourceLocation> createSculkBringerUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_ESSENCE); }
    public static CustomSmithingTemplateItem createSculkBringerUpgradeTemplate() {
        return new CustomSmithingTemplateItem(
                INEVITABLE_SCULK_SWORD_UPGRADE_APPLIES_TO, INEVITABLE_SCULK_SWORD_UPGRADE_INGREDIENTS,
                INEVITABLE_SCULK_SWORD_UPGRADE, INEVITABLE_SCULK_SWORD_UPGRADE_BASE_SLOT_DESCRIPTION,
                INEVITABLE_SCULK_SWORD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createSculkBringerUpgradeIconList(), createSculkBringerUpgradeMaterialList());
    }
    private static List<ResourceLocation> createSculkSlingerUpgradeIconList() {
        return List.of(EMPTY_SLOT_CROSSBOW); }
    private static List<ResourceLocation> createSculkSlingerUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_ESSENCE); }
    public static CustomSmithingTemplateItem createSculkSlingerUpgradeTemplate() {
        return new CustomSmithingTemplateItem(
                INEVITABLE_SCULK_CROSSBOW_UPGRADE_APPLIES_TO, INEVITABLE_SCULK_CROSSBOW_UPGRADE_INGREDIENTS,
                INEVITABLE_SCULK_CROSSBOW_UPGRADE, INEVITABLE_SCULK_CROSSBOW_UPGRADE_BASE_SLOT_DESCRIPTION,
                INEVITABLE_SCULK_CROSSBOW_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createSculkSlingerUpgradeIconList(), createSculkSlingerUpgradeMaterialList());
    }
    private static List<ResourceLocation> createWebweaverUpgradeIconList() {
        return List.of(EMPTY_SLOT_BOW); }
    private static List<ResourceLocation> createWebweaverUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_ESSENCE); }
    public static CustomSmithingTemplateItem createWebweaverUpgradeTemplate() {
        return new CustomSmithingTemplateItem(
                INEVITABLE_BOW_UPGRADE_APPLIES_TO, INEVITABLE_BOW_UPGRADE_INGREDIENTS,
                INEVITABLE_BOW_UPGRADE, INEVITABLE_BOW_UPGRADE_BASE_SLOT_DESCRIPTION,
                INEVITABLE_BOW_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createWebweaverUpgradeIconList(), createWebweaverUpgradeMaterialList());
    }
    private static List<ResourceLocation> createTideBreakerUpgradeIconList() {
        return List.of(EMPTY_SLOT_TRIDENT); }
    private static List<ResourceLocation> createTideBreakerUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_ESSENCE); }
    public static CustomSmithingTemplateItem createTideBreakerUpgradeTemplate() {
        return new CustomSmithingTemplateItem(
                INEVITABLE_TRIDENT_UPGRADE_APPLIES_TO, INEVITABLE_TRIDENT_UPGRADE_INGREDIENTS,
                INEVITABLE_TRIDENT_UPGRADE, INEVITABLE_TRIDENT_UPGRADE_BASE_SLOT_DESCRIPTION,
                INEVITABLE_TRIDENT_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createTideBreakerUpgradeIconList(), createTideBreakerUpgradeMaterialList());
    }
    private static List<ResourceLocation> createInfernalPickaxeUpgradeIconList() {
        return List.of(EMPTY_SLOT_PICKAXE); }
    private static List<ResourceLocation> createInfernalPickaxeUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_ESSENCE); }
    public static CustomSmithingTemplateItem createInfernalPickaxeUpgradeTemplate() {
        return new CustomSmithingTemplateItem(
                INEVITABLE_PICKAXE_UPGRADE_APPLIES_TO, INEVITABLE_PICKAXE_UPGRADE_INGREDIENTS,
                INEVITABLE_PICKAXE_UPGRADE, INEVITABLE_PICKAXE_UPGRADE_BASE_SLOT_DESCRIPTION,
                INEVITABLE_PICKAXE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createInfernalPickaxeUpgradeIconList(), createInfernalPickaxeUpgradeMaterialList());
    }
    private static List<ResourceLocation> createUnkemptHaroldUpgradeIconList() {
        return List.of(EMPTY_SLOT_SHOVEL); }
    private static List<ResourceLocation> createUnkemptHaroldUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_ESSENCE); }
    public static CustomSmithingTemplateItem createUnkemptHaroldUpgradeTemplate() {
        return new CustomSmithingTemplateItem(
                INEVITABLE_SHOVEL_UPGRADE_APPLIES_TO, INEVITABLE_SHOVEL_UPGRADE_INGREDIENTS,
                INEVITABLE_SHOVEL_UPGRADE, INEVITABLE_SHOVEL_UPGRADE_BASE_SLOT_DESCRIPTION,
                INEVITABLE_SHOVEL_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createUnkemptHaroldUpgradeIconList(), createUnkemptHaroldUpgradeMaterialList());
    }
    private static List<ResourceLocation> createLeviathansAxeUpgradeIconList() {
        return List.of(EMPTY_SLOT_AXE); }
    private static List<ResourceLocation> createLeviathansAxeUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_ESSENCE); }
    public static CustomSmithingTemplateItem createLeviathansAxeUpgradeTemplate() {
        return new CustomSmithingTemplateItem(
                INEVITABLE_AXE_UPGRADE_APPLIES_TO, INEVITABLE_AXE_UPGRADE_INGREDIENTS,
                INEVITABLE_AXE_UPGRADE, INEVITABLE_AXE_UPGRADE_BASE_SLOT_DESCRIPTION,
                INEVITABLE_AXE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createLeviathansAxeUpgradeIconList(), createLeviathansAxeUpgradeMaterialList());
    }
    private static List<ResourceLocation> createScytheOfViturUpgradeIconList() {
        return List.of(EMPTY_SLOT_HOE); }
    private static List<ResourceLocation> createScytheOfViturUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_ESSENCE); }
    public static CustomSmithingTemplateItem createScytheOfViturUpgradeTemplate() {
        return new CustomSmithingTemplateItem(
                INEVITABLE_HOE_UPGRADE_APPLIES_TO, INEVITABLE_HOE_UPGRADE_INGREDIENTS,
                INEVITABLE_HOE_UPGRADE, INEVITABLE_HOE_UPGRADE_BASE_SLOT_DESCRIPTION,
                INEVITABLE_HOE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createScytheOfViturUpgradeIconList(), createScytheOfViturUpgradeMaterialList());
    }
    private static List<ResourceLocation> createObsidianArmorUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS); }
    private static List<ResourceLocation> createObsidianArmorUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_ESSENCE); }
    public static CustomSmithingTemplateItem createObsidianArmorUpgradeTemplate() {
        return new CustomSmithingTemplateItem(
                INEVITABLE_ARMOR_UPGRADE_APPLIES_TO, INEVITABLE_ARMOR_UPGRADE_INGREDIENTS,
                INEVITABLE_ARMOR_UPGRADE, INEVITABLE_ARMOR_UPGRADE_BASE_SLOT_DESCRIPTION,
                INEVITABLE_ARMOR_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createObsidianArmorUpgradeIconList(), createObsidianArmorUpgradeMaterialList());
    }

    @Override
    public @NotNull String getDescriptionId() {
        return DESCRIPTION_ID;
    }

    @Override
    public boolean isFireResistant() {
        return true;
    }
}
