package net.Lucas.tutorialmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class CustomSmithingTemplateItem extends SmithingTemplateItem {
    public CustomSmithingTemplateItem(Component pAppliesTo, Component pIngredients, Component pUpdradeDescription, Component pBaseSlotDescription, Component pAdditionsSlotDescription, List<ResourceLocation> pBaseSlotEmptyIcons, List<ResourceLocation> pAdditonalSlotEmptyIcons) {
        super(pAppliesTo, pIngredients, pUpdradeDescription, pBaseSlotDescription, pAdditionsSlotDescription, pBaseSlotEmptyIcons, pAdditonalSlotEmptyIcons);
    }
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final Component ONYX_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.diamond_upgrade"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component ONYX_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("tutorialmod:onyx"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component ONYX_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("onyx_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component ONYX_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.base_slot_description")));
    private static final Component ONYX_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.additions_slot_description")));
    private static final Component NETHERITE_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.onyx_equipment"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component NETHERITE_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component NETHERITE_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("netherite_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component NETHERITE_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.base_slot_description")));
    private static final Component NETHERITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.additions_slot_description")));
    private static final Component INEVITABLE_NETHER_SWORD_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.inevitable_upgrade.sword"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_NETHER_SWORD_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("tutorialmod:pure_nether_essence"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_NETHER_SWORD_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("inevitable_nether_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component INEVITABLE_NETHER_SWORD_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.base_slot_description")));
    private static final Component INEVITABLE_NETHER_SWORD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.additions_slot_description")));
    private static final Component INEVITABLE_END_SWORD_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.inevitable_upgrade.sword"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_END_SWORD_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("tutorialmod:pure_end_essence"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_END_SWORD_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("inevitable_end_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component INEVITABLE_END_SWORD_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.base_slot_description")));
    private static final Component INEVITABLE_END_SWORD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.additions_slot_description")));
    private static final Component INEVITABLE_SCULK_SWORD_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.inevitable_upgrade.sword"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_SCULK_SWORD_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("tutorialmod:pure_sculk_essence"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_SCULK_SWORD_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("inevitable_sculk_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component INEVITABLE_SCULK_SWORD_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.base_slot_description")));
    private static final Component INEVITABLE_SCULK_SWORD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.additions_slot_description")));
    private static final Component INEVITABLE_SCULK_CROSSBOW_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.inevitable_upgrade.crossbow"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_SCULK_CROSSBOW_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("tutorialmod:pure_evil_essence"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_SCULK_CROSSBOW_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("inevitable_sculk_crossbow_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component INEVITABLE_SCULK_CROSSBOW_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.base_slot_description")));
    private static final Component INEVITABLE_SCULK_CROSSBOW_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.additions_slot_description")));
    private static final Component INEVITABLE_BOW_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.inevitable_upgrade.bow"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_BOW_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("tutorialmod:pure_spider_essence"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component INEVITABLE_BOW_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("inevitable_bow_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component INEVITABLE_BOW_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.base_slot_description")));
    private static final Component INEVITABLE_BOW_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.additions_slot_description")));


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
    private static final ResourceLocation EMPTY_SLOT_ESSENCE = new ResourceLocation("tutorialmod:item/empty_essence");
    private static final ResourceLocation EMPTY_SLOT_CROSSBOW = new ResourceLocation("tutorialmod:item/empty_crossbow");
    private static final ResourceLocation EMPTY_SLOT_BOW = new ResourceLocation("tutorialmod:item/empty_bow");

    private static List<ResourceLocation> createOnyxUpgradeIconList() {
        return List.of(EMPTY_SLOT_SWORD, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_AXE, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL,
                EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS);
    }
    private static List<ResourceLocation> createOnyxUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_EMERALD);
    }

    public static CustomSmithingTemplateItem createOnyxUpgradeTemplate() {
        return new CustomSmithingTemplateItem(ONYX_UPGRADE_APPLIES_TO, ONYX_UPGRADE_INGREDIENTS, ONYX_UPGRADE,
                ONYX_UPGRADE_BASE_SLOT_DESCRIPTION, ONYX_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createOnyxUpgradeIconList(), createOnyxUpgradeMaterialList());
    }
    private static List<ResourceLocation> createNetheriteUpgradeIconList() {
        return List.of(EMPTY_SLOT_SWORD, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_AXE, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL,
                EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS);
    }
    private static List<ResourceLocation> createNetheriteUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }
    public static CustomSmithingTemplateItem createNetheriteUpgradeTemplate() {
        return new CustomSmithingTemplateItem(
                NETHERITE_UPGRADE_APPLIES_TO, NETHERITE_UPGRADE_INGREDIENTS, NETHERITE_UPGRADE,
                NETHERITE_UPGRADE_BASE_SLOT_DESCRIPTION, NETHERITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createNetheriteUpgradeIconList(), createNetheriteUpgradeMaterialList());
    }
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



}
