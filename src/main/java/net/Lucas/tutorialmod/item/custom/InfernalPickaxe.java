package net.Lucas.tutorialmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class InfernalPickaxe extends PickaxeItem {
    public InfernalPickaxe(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        final ChatFormatting GREEN_TEXT = ChatFormatting.DARK_GREEN;
        Component infernal_pickaxe_lore = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("infernal_pickaxe_lore.red_text"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component infernal_pickaxe_lore_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("infernal_pickaxe_lore.red_text_two"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component infernal_pickaxe_stats_header_arrow = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("infernal_pickaxe_lore.grey_text_arrow"))).withStyle(GREY_TEXT);
        Component infernal_pickaxe_stats_arrow_seven = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("infernal_pickaxe_lore.green_text_arrow_seven"))).withStyle(GREEN_TEXT);
        Component infernal_pickaxe_stats_arrow_eight = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("infernal_pickaxe_lore.green_text_arrow_eight"))).withStyle(GREEN_TEXT);
        Component infernal_pickaxe_stats_arrow_nine = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("infernal_pickaxe_lore.green_text_arrow_nine"))).withStyle(GREEN_TEXT);

        pTooltipComponents.add(infernal_pickaxe_lore);
        pTooltipComponents.add(infernal_pickaxe_lore_two);
        pTooltipComponents.add(infernal_pickaxe_stats_header_arrow);
        pTooltipComponents.add(infernal_pickaxe_stats_arrow_seven);
        pTooltipComponents.add(infernal_pickaxe_stats_arrow_eight);
        pTooltipComponents.add(infernal_pickaxe_stats_arrow_nine);
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
