package net.Lucas.endgameenhanced.item.custom.weapons;

import net.Lucas.endgameenhanced.item.ModItems;
import net.Lucas.endgameenhanced.item.custom.CustomSwordItem;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.gui.screens.Screen;
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

public class VoidwakerSword extends CustomSwordItem implements Vanishable{

    public VoidwakerSword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player) {
            if (player.getItemBySlot(EquipmentSlot.MAINHAND).getItem() == ModItems.VOIDWAKER.get() && player.level().dimension().toString().contains("the_end")) {
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
        final ChatFormatting GOLD_TEXT = ChatFormatting.GOLD;
        final ChatFormatting GREEN_TEXT = ChatFormatting.DARK_GREEN;
        final ChatFormatting PURPLE_TEXT = ChatFormatting.DARK_PURPLE;
        int sharpnessLevel = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.SHARPNESS, pStack);
        int smiteLevel = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.SMITE, pStack);
        int arthropodLevel = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.BANE_OF_ARTHROPODS, pStack);
        double swordSharpnessMeleeDamage = sharpnessLevel+9;
        double swordSmiteMeleeDamage = smiteLevel+19;
        double swordArthropodMeleeDamage = arthropodLevel+19;
        String meleeDamageTranslation = "endgameenhanced:generic.sword.damage.0";
        Component sword_damage = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                (meleeDamageTranslation))).withStyle(GREEN_TEXT);

        if (sharpnessLevel > 0) {
            meleeDamageTranslation = "endgameenhanced:generic.sword.damage."+ swordSharpnessMeleeDamage;
            sword_damage = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                    (meleeDamageTranslation))).withStyle(GREEN_TEXT);
        }
        if (smiteLevel > 0) {
            meleeDamageTranslation = "endgameenhanced:generic.sword.damage."+ swordSmiteMeleeDamage;
            sword_damage = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                    (meleeDamageTranslation))).withStyle(GREEN_TEXT);
        }
        if (arthropodLevel > 0) {
            meleeDamageTranslation = "endgameenhanced:generic.sword.damage."+ swordArthropodMeleeDamage;
            sword_damage = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                    (meleeDamageTranslation))).withStyle(GREEN_TEXT);
        }
        Component voidwaker_lore = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:voidwaker.lore"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        pTooltipComponents.add(voidwaker_lore);

        Component voidwaker_space = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.tooltip.space"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        pTooltipComponents.add(voidwaker_space);

        Component voidwaker_main_hand = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.weapon.main_hand"))).withStyle(GREY_TEXT);
        pTooltipComponents.add(voidwaker_main_hand);

        pTooltipComponents.add(sword_damage);

        Component voidwaker_attack_speed = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.weapon.attack_speed_1.6"))).withStyle(GREEN_TEXT);
        pTooltipComponents.add(voidwaker_attack_speed);

        pTooltipComponents.add(voidwaker_space);

        Component voidwaker_trait = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:voidwaker.trait"))).withStyle(PURPLE_TEXT);
        pTooltipComponents.add(voidwaker_trait);

        Component trait_full_description = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:voidwaker.trait.description"))).withStyle(GOLD_TEXT);

        Component hold_shift = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.tooltip.hold_shift"))).withStyle(GOLD_TEXT);

        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(trait_full_description);
        } else {
            pTooltipComponents.add(hold_shift);
        }
    }
}
