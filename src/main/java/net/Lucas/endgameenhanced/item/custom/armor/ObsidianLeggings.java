package net.Lucas.endgameenhanced.item.custom.armor;

import net.Lucas.endgameenhanced.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ObsidianLeggings extends ArmorItem {
    public ObsidianLeggings(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player) {
            if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.INEVITABLE_LEGGINGS.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, 220, 0, false, false, true));
                if (isDamaged(player.getItemBySlot(EquipmentSlot.LEGS))) {
                    setDamage(player.getItemBySlot(EquipmentSlot.LEGS), 0);
                }
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        final ChatFormatting BLUE_TEXT = ChatFormatting.BLUE;
        Component obsidian_leggings_lore = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:obsidian_leggings.lore"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        pTooltipComponents.add(obsidian_leggings_lore);

        Component obsidian_leggings_space = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.tooltip.space"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        pTooltipComponents.add(obsidian_leggings_space);

        Component obsidian_leggings_equipped = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.armor.equipped"))).withStyle(GREY_TEXT);
        pTooltipComponents.add(obsidian_leggings_equipped);

        Component obsidian_leggings_armor_value = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:obsidian_leggings.armor_value"))).withStyle(BLUE_TEXT);
        pTooltipComponents.add(obsidian_leggings_armor_value);

        Component obsidian_leggings_armor_toughness = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.armor.armor_toughness"))).withStyle(BLUE_TEXT);
        pTooltipComponents.add(obsidian_leggings_armor_toughness);

        Component obsidian_leggings_knockback_res = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.armor.knockback_res"))).withStyle(BLUE_TEXT);
        pTooltipComponents.add(obsidian_leggings_knockback_res);

        Component obsidian_leggings_jump_boost = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:obsidian_leggings.jump_boost"))).withStyle(BLUE_TEXT);
        pTooltipComponents.add(obsidian_leggings_jump_boost);

        pTooltipComponents.add(obsidian_leggings_space);

        Component obsidian_leggings_set_bonus = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.armor.set_bonus"))).withStyle(GREY_TEXT);
        pTooltipComponents.add(obsidian_leggings_set_bonus);

        Component obsidian_leggings_fire_res = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.armor.fire_res"))).withStyle(BLUE_TEXT);
        pTooltipComponents.add(obsidian_leggings_fire_res);

        Component obsidian_leggings_res = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.armor.res"))).withStyle(BLUE_TEXT);
        pTooltipComponents.add(obsidian_leggings_res);

        Component obsidian_leggings_elytra_flight = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.armor.elytra_flight"))).withStyle(BLUE_TEXT);
        pTooltipComponents.add(obsidian_leggings_elytra_flight);

        pTooltipComponents.add(obsidian_leggings_space);
    }
}
