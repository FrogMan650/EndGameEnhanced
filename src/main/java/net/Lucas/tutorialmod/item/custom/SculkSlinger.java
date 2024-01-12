package net.Lucas.tutorialmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SculkSlinger extends CustomCrossbowItem {
    public SculkSlinger(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        final ChatFormatting GREEN_TEXT = ChatFormatting.DARK_GREEN;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        Component sculkslinger_lore = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("sculkslinger_lore.red_text"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component sculkslinger_lore_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("sculkslinger_lore.red_text_two"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component sculkslinger_lore_three = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("sculkslinger_lore.red_text_three"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component sculkslinger_lore_four = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("sculkslinger_lore.red_text_four"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component sculkslinger_lore_five = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("sculkslinger_lore.red_text_five"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);


        Component sculkslinger_stats_header_arrow = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("sculkslinger_lore.grey_text_arrow"))).withStyle(GREY_TEXT);
        Component sculkslinger_stats_arrow = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("sculkslinger_lore.green_text_arrow"))).withStyle(GREEN_TEXT);
        Component sculkslinger_stats_arrow_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("sculkslinger_lore.green_text_arrow_two"))).withStyle(GREEN_TEXT);
        Component sculkslinger_stats_arrow_three = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("sculkslinger_lore.green_text_arrow_three"))).withStyle(GREEN_TEXT);
        Component sculkslinger_stats_arrow_four = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("sculkslinger_lore.green_text_arrow_four"))).withStyle(GREEN_TEXT);






        pTooltipComponents.add(sculkslinger_lore);
        pTooltipComponents.add(sculkslinger_lore_two);
        pTooltipComponents.add(sculkslinger_lore_three);
        pTooltipComponents.add(sculkslinger_lore_four);
        pTooltipComponents.add(sculkslinger_lore_five);
        pTooltipComponents.add(sculkslinger_stats_header_arrow);
        pTooltipComponents.add(sculkslinger_stats_arrow);
        pTooltipComponents.add(sculkslinger_stats_arrow_two);
        pTooltipComponents.add(sculkslinger_stats_arrow_three);
        pTooltipComponents.add(sculkslinger_stats_arrow_four);
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
