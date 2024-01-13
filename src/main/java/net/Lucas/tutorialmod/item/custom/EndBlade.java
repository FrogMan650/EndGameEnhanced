package net.Lucas.tutorialmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EndBlade extends SwordItem {

    public EndBlade(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        final ChatFormatting PURPLE_TEXT = ChatFormatting.LIGHT_PURPLE;
        Component endblade_lore = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("end_blade_lore.red_text"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component endblade_lore_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("end_blade_lore.red_text_two"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component endblade_lore_three = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("end_blade_lore.red_text_three"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component endblade_lore_four = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("end_blade_lore.red_text_four"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component endblade_lore_five = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("end_blade_lore.red_text_five"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component endblade_lore_prereq_header = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("end_blade_lore_prereq_header"))).withStyle(GREY_TEXT);
        Component endblade_lore_prereq_item = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("end_blade_lore_prereq_item"))).withStyle(PURPLE_TEXT);





        pTooltipComponents.add(endblade_lore);
        pTooltipComponents.add(endblade_lore_two);
        pTooltipComponents.add(endblade_lore_three);
        pTooltipComponents.add(endblade_lore_four);
//        pTooltipComponents.add(endblade_lore_five);
//        pTooltipComponents.add(endblade_lore_prereq_header);
//        pTooltipComponents.add(endblade_lore_prereq_item);
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
