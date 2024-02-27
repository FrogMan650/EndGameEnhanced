package net.Lucas.endgameenhanced.item.custom.tools;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class InfernalPickaxe extends PickaxeItem {
    public InfernalPickaxe(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(0, pAttacker, (p_41007_) -> {
            p_41007_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide && pState.getDestroySpeed(pLevel, pPos) != 0.0F) {
            pStack.hurtAndBreak(0, pEntityLiving, (p_40992_) -> {
                p_40992_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }

        return true;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        final ChatFormatting GOLD_TEXT = ChatFormatting.GOLD;
        final ChatFormatting GREEN_TEXT = ChatFormatting.DARK_GREEN;
        final ChatFormatting REDD_TEXT = ChatFormatting.RED;
        Component infernal_pickaxe_lore = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:infernal_pickaxe.lore"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        pTooltipComponents.add(infernal_pickaxe_lore);

        Component infernal_pickaxe_space = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.tooltip.space"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        pTooltipComponents.add(infernal_pickaxe_space);

        Component infernal_pickaxe_main_hand = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.weapon.main_hand"))).withStyle(GREY_TEXT);
        pTooltipComponents.add(infernal_pickaxe_main_hand);

        Component infernal_pickaxe_damage = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:infernal_pickaxe.damage"))).withStyle(GREEN_TEXT);
        pTooltipComponents.add(infernal_pickaxe_damage);

        Component infernal_pickaxe_attack_speed = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.weapon.attack_speed_1.2"))).withStyle(GREEN_TEXT);
        pTooltipComponents.add(infernal_pickaxe_attack_speed);

        pTooltipComponents.add(infernal_pickaxe_space);

        Component infernal_pickaxe_trait = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:infernal_pickaxe.trait"))).withStyle(REDD_TEXT);
        pTooltipComponents.add(infernal_pickaxe_trait);

        Component trait_full_description = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:infernal_pickaxe.trait.description"))).withStyle(GOLD_TEXT);

        Component hold_shift = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.tooltip.hold_shift"))).withStyle(GOLD_TEXT);

        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(trait_full_description);
        } else {
            pTooltipComponents.add(hold_shift);
        }
    }
}
