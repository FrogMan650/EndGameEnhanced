package net.Lucas.endgameenhanced.item.custom.weapons;

import net.Lucas.endgameenhanced.item.ModItems;
import net.Lucas.endgameenhanced.item.custom.CustomSwordItem;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EndBlade extends CustomSwordItem implements Vanishable{

    public EndBlade(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player) {
            if (player.getItemBySlot(EquipmentSlot.MAINHAND).getItem() == ModItems.END_BLADE.get() && player.level().dimension().toString().contains("the_end")) {
                if (player.hasEffect(MobEffects.WITHER)) {
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 2, false, true, true));
                    if (player.getEffect(MobEffects.WITHER).getDuration() == 1) {
                        player.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 0, false, true, true));
                    }
                    if (!player.hasEffect(MobEffects.REGENERATION)) {
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 0, false, true, true));
                    }
                }
            }
        }
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        final ChatFormatting GREEN_TEXT = ChatFormatting.DARK_GREEN;
        final ChatFormatting PURPLE_TEXT = ChatFormatting.DARK_PURPLE;
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
        Component sword_lore = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:end_blade_lore.red_text"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component sword_lore_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:end_blade_lore.red_text_two"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component sword_stats_header_arrow = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:sword_lore.grey_text_arrow"))).withStyle(GREY_TEXT);
        Component sword_stats_arrow_seven = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:sword_lore.green_text_arrow_seven"))).withStyle(GREEN_TEXT);
        Component sword_stats_arrow_eight = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:sword_lore.green_text_arrow_eight"))).withStyle(GREEN_TEXT);
        Component sword_stats_arrow_nine = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:end_blade_lore.green_text_arrow_nine"))).withStyle(PURPLE_TEXT);
        pTooltipComponents.add(sword_lore);
        pTooltipComponents.add(sword_lore_two);
        pTooltipComponents.add(sword_stats_header_arrow);
        pTooltipComponents.add(sword_stats_arrow_five);
        pTooltipComponents.add(sword_stats_arrow_seven);
        pTooltipComponents.add(sword_stats_arrow_eight);
        pTooltipComponents.add(sword_stats_arrow_nine);
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
