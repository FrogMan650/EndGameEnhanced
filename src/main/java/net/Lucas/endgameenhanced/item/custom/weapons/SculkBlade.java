package net.Lucas.endgameenhanced.item.custom.weapons;

import net.Lucas.endgameenhanced.item.ModItems;
import net.Lucas.endgameenhanced.item.custom.CustomSwordItem;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SculkBlade extends CustomSwordItem implements Vanishable {

    public SculkBlade(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player) {
            if (player.getItemBySlot(EquipmentSlot.MAINHAND).getItem() == ModItems.SCULK_BLADE.get() && player.level().getBiome(player.getOnPos()).toString().contains("deep_dark")) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 1, false, true, true));
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 20, 0, false, true, true));
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, 20, 1, false, true, true));
            }
            if (player.getItemBySlot(EquipmentSlot.MAINHAND).getItem() == ModItems.SCULK_BLADE.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 20, 0, false, true, true));
            }
        }
    }

    @Override
    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        if (pState.is(Blocks.SCULK_SHRIEKER) || pState.is(Blocks.SCULK_SENSOR)) {
            return 100.0F;
        } else if (pState.is(Blocks.COBWEB)) {
            return 15.0F;
        } else {
            return pState.is(BlockTags.SWORD_EFFICIENT) ? 1.5F : 1.0F;
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        final ChatFormatting GREEN_TEXT = ChatFormatting.DARK_GREEN;
        int sharpnessLevel = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.SHARPNESS, pStack);
        int smiteLevel = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.SMITE, pStack);
        int arthropodLevel = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.BANE_OF_ARTHROPODS, pStack);
        double swordSharpnessMeleeDamage = sharpnessLevel+9;
        double swordSmiteMeleeDamage = smiteLevel+19;
        double swordArthropodMeleeDamage = arthropodLevel+19;
        String meleeDamageTranslation = "endgameenhanced:sword_lore.green_text_arrow.melee.0";
        Component sword_stats_arrow_five = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                (meleeDamageTranslation))).withStyle(GREEN_TEXT);

        if (sharpnessLevel > 0) {
            meleeDamageTranslation = "endgameenhanced:sword_lore.green_text_arrow.melee."+ swordSharpnessMeleeDamage;
            sword_stats_arrow_five = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                    (meleeDamageTranslation))).withStyle(GREEN_TEXT);
        }
        if (smiteLevel > 0) {
            meleeDamageTranslation = "endgameenhanced:sword_lore.green_text_arrow.melee."+ swordSmiteMeleeDamage;
            sword_stats_arrow_five = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                    (meleeDamageTranslation))).withStyle(GREEN_TEXT);
        }
        if (arthropodLevel > 0) {
            meleeDamageTranslation = "endgameenhanced:sword_lore.green_text_arrow.melee."+ swordArthropodMeleeDamage;
            sword_stats_arrow_five = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                    (meleeDamageTranslation))).withStyle(GREEN_TEXT);
        }
        Component sculkblade_lore = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:sculk_blade_lore.red_text"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component sculkblade_lore_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:sculk_blade_lore.red_text_two"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component sword_stats_header_arrow = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:sword_lore.grey_text_arrow"))).withStyle(GREY_TEXT);
        Component sword_stats_arrow_seven = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:sword_lore.green_text_arrow_seven"))).withStyle(GREEN_TEXT);
        Component sword_stats_arrow_eight = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:sword_lore.green_text_arrow_eight"))).withStyle(GREEN_TEXT);
        pTooltipComponents.add(sculkblade_lore);
        pTooltipComponents.add(sculkblade_lore_two);
        pTooltipComponents.add(sword_stats_header_arrow);
        pTooltipComponents.add(sword_stats_arrow_five);
        pTooltipComponents.add(sword_stats_arrow_seven);
        pTooltipComponents.add(sword_stats_arrow_eight);
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }


}
