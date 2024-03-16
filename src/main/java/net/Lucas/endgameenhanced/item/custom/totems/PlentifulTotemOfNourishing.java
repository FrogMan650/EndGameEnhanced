package net.Lucas.endgameenhanced.item.custom.totems;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlentifulTotemOfNourishing extends Item {
    public PlentifulTotemOfNourishing(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player && player.getItemInHand(InteractionHand.OFF_HAND).is(this) && player.getItemInHand(InteractionHand.OFF_HAND).getDamageValue() < player.getItemInHand(InteractionHand.OFF_HAND).getMaxDamage()-1) {
            int foodLevel = player.getFoodData().getFoodLevel();
            float saturationLevel = player.getFoodData().getSaturationLevel();
            int foodRestore = 6;
            float saturationRestore = 9.6F;
            if (saturate() && saturationLevel < foodLevel) {
                player.getFoodData().setSaturation(saturationLevel+1);
            }
            if (foodLevel < 20) {
                player.getFoodData().setFoodLevel(foodLevel+foodRestore);
                player.getFoodData().setSaturation(saturationLevel+saturationRestore);
                if (player.getFoodData().getFoodLevel() > 20) {
                    player.getFoodData().setFoodLevel(20);
                }
                if (player.getFoodData().getSaturationLevel() > player.getFoodData().getFoodLevel()) {
                    player.getFoodData().setSaturation(player.getFoodData().getFoodLevel());
                }
                pStack.hurtAndBreak(1, player, (p_289501_) -> {
                    p_289501_.broadcastBreakEvent(player.getUsedItemHand());
                });
            }
        }
    }

    @Override
    public void onCraftedBy(ItemStack pStack, Level pLevel, Player pPlayer) {
        pStack.setDamageValue(pStack.getMaxDamage()-1);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand pHand) {
        ItemStack totemStack = player.getItemInHand(pHand);
        ItemStack itemStack;
        if (player.getInventory().contains(Items.COOKED_SALMON.getDefaultInstance()) && player.getItemInHand(pHand).getDamageValue() != 0) {
            itemStack = player.getInventory().getItem(player.getInventory().findSlotMatchingItem(Items.COOKED_SALMON.getDefaultInstance()));
        } else if (player.getInventory().contains(Items.COOKED_CHICKEN.getDefaultInstance()) && player.getItemInHand(pHand).getDamageValue() != 0) {
            itemStack = player.getInventory().getItem(player.getInventory().findSlotMatchingItem(Items.COOKED_CHICKEN.getDefaultInstance()));
        } else if (player.getInventory().contains(Items.COOKED_MUTTON.getDefaultInstance()) && player.getItemInHand(pHand).getDamageValue() != 0) {
            itemStack = player.getInventory().getItem(player.getInventory().findSlotMatchingItem(Items.COOKED_MUTTON.getDefaultInstance()));
        } else return InteractionResultHolder.fail(totemStack);

        totemStack.setDamageValue(totemStack.getDamageValue()-1);
        itemStack.shrink(1);
        if (itemStack.isEmpty()) {
            player.getInventory().removeItem(itemStack);
        }
        return InteractionResultHolder.consume(totemStack);
    }

    public boolean saturate() {
        int randomInteger = RandomSource.create().nextIntBetweenInclusive(0, 1200);
        return randomInteger == 1169;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        ChatFormatting VARIABLE_TEXT = ChatFormatting.DARK_GREEN;
        int currentCharges = pStack.getDamageValue();
        int maxCharges = pStack.getMaxDamage()-1;
        int remainingCharges = maxCharges-currentCharges;
        double percentChargesRemaining = (double) remainingCharges / maxCharges;
        if (percentChargesRemaining > 0.25 && percentChargesRemaining <= 0.5) {
            VARIABLE_TEXT = ChatFormatting.YELLOW;
        }
        if (percentChargesRemaining <= 0.25) {
            VARIABLE_TEXT = ChatFormatting.RED;
        }

        Component totem_charges_remaining = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.totem.charges_remaining"))).withStyle(GREY_TEXT);
        pTooltipComponents.add(totem_charges_remaining);

        Component totem_current_charges = Component.literal(" "+remainingCharges+" / "+maxCharges).withStyle(VARIABLE_TEXT);
        pTooltipComponents.add(totem_current_charges);
    }
}
