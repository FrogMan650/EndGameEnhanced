package net.Lucas.tutorialmod.item.custom;

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

public class SculkCrystal extends Item {
    public SculkCrystal(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        Component sculk_crystal_lore = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("sculk_crystal_lore.red_text"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component sculk_crystal_lore_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("sculk_crystal_lore.red_text_two"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);



        pTooltipComponents.add(sculk_crystal_lore);
        pTooltipComponents.add(sculk_crystal_lore_two);
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}