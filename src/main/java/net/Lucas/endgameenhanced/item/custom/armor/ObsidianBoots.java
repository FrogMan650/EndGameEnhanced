package net.Lucas.endgameenhanced.item.custom.armor;

import net.Lucas.endgameenhanced.item.ModItems;
import net.Lucas.endgameenhanced.item.custom.CustomArmorItem;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ObsidianBoots extends CustomArmorItem {
    public ObsidianBoots(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player) {
            if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.INEVITABLE_BOOTS.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 220, 0, false, false, true));
                if (isDamaged(player.getItemBySlot(EquipmentSlot.FEET))) {
                    setDamage(player.getItemBySlot(EquipmentSlot.FEET), 0);
                }
            }
            //set bonus
            if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.INEVITABLE_HELMET.get() &&
                    player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.INEVITABLE_CHESTPLATE.get() &&
                    player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.INEVITABLE_LEGGINGS.get() &&
                    player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.INEVITABLE_BOOTS.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 220, 0, false, false, true));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 220, 0, false, false, true));
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        final ChatFormatting BLUE_TEXT = ChatFormatting.BLUE;
        Component obsidian_boots_lore = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_boots_lore.red_text"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component obsidian_boots_lore_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_boots_lore.red_text_two"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);

        Component obsidian_boots_stats_header_arrow = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_boots_lore.grey_text_arrow"))).withStyle(GREY_TEXT);

        Component obsidian_boots_stats_arrow_seven = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_boots_lore.green_text_arrow_seven"))).withStyle(BLUE_TEXT);
        Component obsidian_boots_stats_arrow_eight = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_boots_lore.green_text_arrow_eight"))).withStyle(BLUE_TEXT);
        Component obsidian_boots_stats_arrow_nine = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_boots_lore.green_text_arrow_nine"))).withStyle(BLUE_TEXT);
        Component obsidian_boots_stats_arrow_ten = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_boots_lore.green_text_arrow_ten"))).withStyle(BLUE_TEXT);
        Component obsidian_boots_stats_arrow_eleven = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_boots_lore.green_text_arrow_eleven"))).withStyle(BLUE_TEXT);
        Component obsidian_boots_stats_arrow_fifteen = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_boots_lore.green_text_arrow_fifteen"))).withStyle(BLUE_TEXT);


        Component obsidian_boots_stats_header_arrow_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_boots_lore.grey_text_arrow_two"))).withStyle(GREY_TEXT);

        Component obsidian_boots_stats_arrow_twelve = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_boots_lore.green_text_arrow_twelve"))).withStyle(BLUE_TEXT);
        Component obsidian_boots_stats_arrow_thirteen = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_boots_lore.green_text_arrow_thirteen"))).withStyle(BLUE_TEXT);
        Component obsidian_boots_stats_arrow_fourteen = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_boots_lore.green_text_arrow_fourteen"))).withStyle(BLUE_TEXT);
        Component obsidian_boots_stats_arrow_sixteen = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_boots_lore.green_text_arrow_sixteen"))).withStyle(BLUE_TEXT);





        pTooltipComponents.add(obsidian_boots_lore);
        pTooltipComponents.add(obsidian_boots_lore_two);
        pTooltipComponents.add(obsidian_boots_stats_header_arrow);
        pTooltipComponents.add(obsidian_boots_stats_arrow_seven);
        pTooltipComponents.add(obsidian_boots_stats_arrow_eight);
        pTooltipComponents.add(obsidian_boots_stats_arrow_nine);
        pTooltipComponents.add(obsidian_boots_stats_arrow_ten);
//        pTooltipComponents.add(obsidian_boots_stats_arrow_eleven);
        pTooltipComponents.add(obsidian_boots_stats_arrow_fifteen);
        pTooltipComponents.add(obsidian_boots_stats_header_arrow_two);
        pTooltipComponents.add(obsidian_boots_stats_arrow_twelve);
        pTooltipComponents.add(obsidian_boots_stats_arrow_thirteen);
        pTooltipComponents.add(obsidian_boots_stats_arrow_fourteen);
        pTooltipComponents.add(obsidian_boots_stats_arrow_sixteen);
    }
}
