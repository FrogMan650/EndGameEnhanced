package net.Lucas.endgameenhanced.item.custom.armor;

import net.Lucas.endgameenhanced.item.ModItems;
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
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ObsidianChestplate extends ArmorItem {
    public ObsidianChestplate(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player) {
            if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.INEVITABLE_CHESTPLATE.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 220, 0, false, false, true));
                if (isDamaged(player.getItemBySlot(EquipmentSlot.CHEST))) {
                    setDamage(player.getItemBySlot(EquipmentSlot.CHEST), 0);
                }
            }
        }
    }

    @Override
    public boolean canElytraFly(ItemStack stack, net.minecraft.world.entity.LivingEntity entity) {
        if (entity instanceof Player player) {
            boolean setEffectHead = player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.INEVITABLE_HELMET.get();
            boolean setEffectChest = player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.INEVITABLE_CHESTPLATE.get();
            boolean setEffectLegs = player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.INEVITABLE_LEGGINGS.get();
            boolean setEffectBoots = player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.INEVITABLE_BOOTS.get();
            return setEffectHead && setEffectChest && setEffectLegs && setEffectBoots;
        }
        return false;
    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, net.minecraft.world.entity.LivingEntity entity, int flightTicks) {
        if (!entity.level().isClientSide) {
            int nextFlightTick = flightTicks + 1;
            if (nextFlightTick % 10 == 0) {
                if (nextFlightTick % 20 == 0) {
                    stack.hurtAndBreak(0, entity, e -> e.broadcastBreakEvent(net.minecraft.world.entity.EquipmentSlot.CHEST));
                }
                entity.gameEvent(net.minecraft.world.level.gameevent.GameEvent.ELYTRA_GLIDE);
            }
        }
        return true;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        final ChatFormatting GOLD_TEXT = ChatFormatting.GOLD;
        final ChatFormatting PURPLE_TEXT = ChatFormatting.DARK_PURPLE;
        final ChatFormatting BLUE_TEXT = ChatFormatting.BLUE;
        Component obsidian_chestplate_lore = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:obsidian_chestplate.lore"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        pTooltipComponents.add(obsidian_chestplate_lore);

        Component obsidian_chestplate_space = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.tooltip.space"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        pTooltipComponents.add(obsidian_chestplate_space);

        Component obsidian_chestplate_equipped = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.armor.equipped"))).withStyle(GREY_TEXT);
        pTooltipComponents.add(obsidian_chestplate_equipped);

        Component obsidian_chestplate_armor_value = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:obsidian_chestplate.armor_value"))).withStyle(BLUE_TEXT);
        pTooltipComponents.add(obsidian_chestplate_armor_value);

        Component obsidian_chestplate_armor_toughness = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.armor.armor_toughness"))).withStyle(BLUE_TEXT);
        pTooltipComponents.add(obsidian_chestplate_armor_toughness);

        Component obsidian_chestplate_knockback_res = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.armor.knockback_res"))).withStyle(BLUE_TEXT);
        pTooltipComponents.add(obsidian_chestplate_knockback_res);

        pTooltipComponents.add(obsidian_chestplate_space);

        Component obsidian_chestplate_trait = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:obsidian_chestplate.trait"))).withStyle(PURPLE_TEXT);
        pTooltipComponents.add(obsidian_chestplate_trait);

        Component trait_full_description = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:obsidian_chestplate.trait.description"))).withStyle(GOLD_TEXT);

        Component hold_shift = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.tooltip.hold_shift"))).withStyle(GOLD_TEXT);

        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(trait_full_description);
        } else {
            pTooltipComponents.add(hold_shift);
        }
    }
}
