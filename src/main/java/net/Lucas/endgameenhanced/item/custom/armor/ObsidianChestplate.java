package net.Lucas.endgameenhanced.item.custom.armor;

import net.Lucas.endgameenhanced.item.ModItems;
import net.Lucas.endgameenhanced.item.custom.CustomArmorItem;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ObsidianChestplate extends CustomArmorItem {
    public ObsidianChestplate(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
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
        final ChatFormatting BLUE_TEXT = ChatFormatting.BLUE;
        Component obsidian_chestplate_lore = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_chestplate_lore.red_text"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component obsidian_chestplate_lore_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_chestplate_lore.red_text_two"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);

        Component obsidian_chestplate_stats_header_arrow = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_chestplate_lore.grey_text_arrow"))).withStyle(GREY_TEXT);

        Component obsidian_chestplate_stats_arrow_seven = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_chestplate_lore.green_text_arrow_seven"))).withStyle(BLUE_TEXT);
        Component obsidian_chestplate_stats_arrow_eight = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_chestplate_lore.green_text_arrow_eight"))).withStyle(BLUE_TEXT);
        Component obsidian_chestplate_stats_arrow_nine = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_chestplate_lore.green_text_arrow_nine"))).withStyle(BLUE_TEXT);
        Component obsidian_chestplate_stats_arrow_ten = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_chestplate_lore.green_text_arrow_ten"))).withStyle(BLUE_TEXT);
        Component obsidian_chestplate_stats_arrow_eleven = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_chestplate_lore.green_text_arrow_eleven"))).withStyle(BLUE_TEXT);

        Component obsidian_chestplate_stats_header_arrow_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_chestplate_lore.grey_text_arrow_two"))).withStyle(GREY_TEXT);

        Component obsidian_chestplate_stats_arrow_twelve = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_chestplate_lore.green_text_arrow_twelve"))).withStyle(BLUE_TEXT);
        Component obsidian_chestplate_stats_arrow_thirteen = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_chestplate_lore.green_text_arrow_thirteen"))).withStyle(BLUE_TEXT);
        Component obsidian_chestplate_stats_arrow_fourteen = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_chestplate_lore.green_text_arrow_fourteen"))).withStyle(BLUE_TEXT);
        Component obsidian_chestplate_stats_arrow_fifteen = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:obsidian_chestplate_lore.green_text_arrow_fifteen"))).withStyle(BLUE_TEXT);





        pTooltipComponents.add(obsidian_chestplate_lore);
        pTooltipComponents.add(obsidian_chestplate_lore_two);
        pTooltipComponents.add(obsidian_chestplate_stats_header_arrow);
        pTooltipComponents.add(obsidian_chestplate_stats_arrow_seven);
        pTooltipComponents.add(obsidian_chestplate_stats_arrow_eight);
        pTooltipComponents.add(obsidian_chestplate_stats_arrow_nine);
        pTooltipComponents.add(obsidian_chestplate_stats_arrow_ten);
        pTooltipComponents.add(obsidian_chestplate_stats_arrow_eleven);
        pTooltipComponents.add(obsidian_chestplate_stats_header_arrow_two);
        pTooltipComponents.add(obsidian_chestplate_stats_arrow_twelve);
        pTooltipComponents.add(obsidian_chestplate_stats_arrow_thirteen);
        pTooltipComponents.add(obsidian_chestplate_stats_arrow_fourteen);
        pTooltipComponents.add(obsidian_chestplate_stats_arrow_fifteen);
    }
}
