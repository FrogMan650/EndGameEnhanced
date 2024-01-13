package net.Lucas.tutorialmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SculkBlade extends CustomSwordItem {

    public SculkBlade(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        final ChatFormatting PURPLE_TEXT = ChatFormatting.LIGHT_PURPLE;
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        Component sculkblade_lore = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("sculk_blade_lore.red_text"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component sculkblade_lore_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("sculk_blade_lore.red_text_two"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component sculkblade_lore_three = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("sculk_blade_lore.red_text_three"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component sculkblade_lore_four = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("sculk_blade_lore.red_text_four"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component sculkblade_lore_five = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("sculk_blade_lore.red_text_five"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component sculkblade_lore_prereq_header = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("sculk_blade_lore_prereq_header"))).withStyle(GREY_TEXT);
        Component sculkblade_lore_prereq_item = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("sculk_blade_lore_prereq_item"))).withStyle(PURPLE_TEXT);

//        Player pPlayer = null;
//        List<Component> tooltiplines = pStack.getTooltipLines(pPlayer, TooltipFlag.NORMAL);
//        pTooltipComponents.add(tooltiplines.get(10));
//        pTooltipComponents.add(tooltiplines.get(1));
//        pTooltipComponents.add(tooltiplines.get(2));



        pTooltipComponents.add(sculkblade_lore);
        pTooltipComponents.add(sculkblade_lore_two);
        pTooltipComponents.add(sculkblade_lore_three);
        pTooltipComponents.add(sculkblade_lore_four);
//        pTooltipComponents.add(sculkblade_lore_five);
//        pTooltipComponents.add(sculkblade_lore_prereq_header);
//        pTooltipComponents.add(sculkblade_lore_prereq_item);
    }


}
