package net.Lucas.endgameenhanced.item.custom.mobdrops;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChargedBlazeRod extends Item {
    public ChargedBlazeRod(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        Component charged_blaze_rod_lore = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:charged_blaze_rod_lore.red_text"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component charged_blaze_rod_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:charged_blaze_rod_lore.red_text_two"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);



        pTooltipComponents.add(charged_blaze_rod_lore);
        pTooltipComponents.add(charged_blaze_rod_two);
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
