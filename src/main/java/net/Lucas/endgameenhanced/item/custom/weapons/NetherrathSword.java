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
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NetherrathSword extends CustomSwordItem implements Vanishable {

    public NetherrathSword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player) {
            if (player.getItemBySlot(EquipmentSlot.MAINHAND).getItem() == ModItems.NETHERRATH.get() && player.level().dimension().toString().contains("the_nether")) {
                if (player.isOnFire()) {
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 1, false, true, true));
                    if (!player.hasEffect(MobEffects.REGENERATION)) {
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 1, false, true, true));
                    }
                    if (player.getRemainingFireTicks() == 20) {
                        player.setSecondsOnFire(10);
                    }
                }
            }
        }
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting GOLD_TEXT = ChatFormatting.GOLD;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        final ChatFormatting GREEN_TEXT = ChatFormatting.DARK_GREEN;
        final ChatFormatting REDD_TEXT = ChatFormatting.RED;
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
        Component netherrath_lore = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:netherrath.lore"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        pTooltipComponents.add(netherrath_lore);

        Component netherrath_space = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.tooltip.space"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        pTooltipComponents.add(netherrath_space);

        Component netherrath_main_hand = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.weapon.main_hand"))).withStyle(GREY_TEXT);
        pTooltipComponents.add(netherrath_main_hand);

        pTooltipComponents.add(sword_damage);

        Component netherrath_attack_speed = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.weapon.attack_speed_1.6"))).withStyle(GREEN_TEXT);
        pTooltipComponents.add(netherrath_attack_speed);

        pTooltipComponents.add(netherrath_space);

        Component netherrath_trait = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:netherrath.trait"))).withStyle(REDD_TEXT);
        pTooltipComponents.add(netherrath_trait);

        Component trait_full_description = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:netherrath.trait.description"))).withStyle(GOLD_TEXT);

        Component hold_shift = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.tooltip.hold_shift"))).withStyle(GOLD_TEXT);

        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(trait_full_description);
        } else {
            pTooltipComponents.add(hold_shift);
        }
    }
}
