package net.Lucas.tutorialmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WebweaverBow extends CustomBowItem{
    public WebweaverBow(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        final ChatFormatting GREEN_TEXT = ChatFormatting.DARK_GREEN;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        Component webweaver_lore = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("webweaver_lore.red_text"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component webweaver_lore_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("webweaver_lore.red_text_two"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component webweaver_lore_three = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("webweaver_lore.red_text_three"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);

        Component webweaver_stats_header_arrow = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("webweaver_lore.grey_text_arrow"))).withStyle(GREY_TEXT);
        Component webweaver_stats_arrow = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("webweaver_lore.green_text_arrow"))).withStyle(GREEN_TEXT);
        Component webweaver_stats_arrow_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("webweaver_lore.green_text_arrow_two"))).withStyle(GREEN_TEXT);
        Component webweaver_stats_arrow_three = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("webweaver_lore.green_text_arrow_three"))).withStyle(GREEN_TEXT);
        Component webweaver_stats_arrow_four = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("webweaver_lore.green_text_arrow_four"))).withStyle(GREEN_TEXT);
        Component webweaver_stats_arrow_five = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("webweaver_lore.green_text_arrow_five"))).withStyle(GREEN_TEXT);



        pTooltipComponents.add(webweaver_lore);
        pTooltipComponents.add(webweaver_lore_two);
        pTooltipComponents.add(webweaver_lore_three);
        pTooltipComponents.add(webweaver_stats_header_arrow);
        pTooltipComponents.add(webweaver_stats_arrow);
        pTooltipComponents.add(webweaver_stats_arrow_two);
        pTooltipComponents.add(webweaver_stats_arrow_three);
        pTooltipComponents.add(webweaver_stats_arrow_four);
        pTooltipComponents.add(webweaver_stats_arrow_five);
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
