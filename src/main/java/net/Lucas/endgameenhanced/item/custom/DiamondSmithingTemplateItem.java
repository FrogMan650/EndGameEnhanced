package net.Lucas.endgameenhanced.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class DiamondSmithingTemplateItem extends SmithingTemplateItem {
    public DiamondSmithingTemplateItem(Component pAppliesTo, Component pIngredients, Component pUpdradeDescription, Component pBaseSlotDescription, Component pAdditionsSlotDescription, List<ResourceLocation> pBaseSlotEmptyIcons, List<ResourceLocation> pAdditonalSlotEmptyIcons) {
        super(pAppliesTo, pIngredients, pUpdradeDescription, pBaseSlotDescription, pAdditionsSlotDescription, pBaseSlotEmptyIcons, pAdditonalSlotEmptyIcons);
    }
    private static final String DESCRIPTION_ID = Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:diamond_smithing_template"));
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final Component ONYX_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.diamond_upgrade"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component ONYX_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:onyx"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component ONYX_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("endgameenhanced:onyx_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component ONYX_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.onyx_upgrade.base_slot_description")));
    private static final Component ONYX_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("endgameenhanced:smithing_template.onyx_upgrade.additions_slot_description")));
    private static final ResourceLocation EMPTY_SLOT_HELMET = new ResourceLocation("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = new ResourceLocation("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = new ResourceLocation("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = new ResourceLocation("item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_HOE = new ResourceLocation("item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE = new ResourceLocation("item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = new ResourceLocation("item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = new ResourceLocation("item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = new ResourceLocation("item/empty_slot_pickaxe");
    private static final ResourceLocation EMPTY_SLOT_EMERALD = new ResourceLocation("item/empty_slot_emerald");

    private static List<ResourceLocation> createOnyxUpgradeIconList() {
        return List.of(EMPTY_SLOT_SWORD, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_AXE, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL,
                EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS);
    }
    private static List<ResourceLocation> createOnyxUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_EMERALD);
    }

    public static DiamondSmithingTemplateItem createOnyxUpgradeTemplate() {
        return new DiamondSmithingTemplateItem(ONYX_UPGRADE_APPLIES_TO, ONYX_UPGRADE_INGREDIENTS, ONYX_UPGRADE,
                ONYX_UPGRADE_BASE_SLOT_DESCRIPTION, ONYX_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createOnyxUpgradeIconList(), createOnyxUpgradeMaterialList());
    }

    @Override
    public String getDescriptionId() {
        return DESCRIPTION_ID;
    }
}
