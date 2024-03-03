package net.Lucas.endgameenhanced.item.custom.misc;

import net.Lucas.endgameenhanced.item.ModItems;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class TierThreeHungerTotem extends Item {
    public TierThreeHungerTotem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player && player.getItemInHand(InteractionHand.OFF_HAND).is(this) && player.getItemInHand(InteractionHand.OFF_HAND).getDamageValue() < player.getItemInHand(InteractionHand.OFF_HAND).getMaxDamage()-1) {
            int foodLevel = player.getFoodData().getFoodLevel();
            float saturationLevel = player.getFoodData().getSaturationLevel();
            int foodRestore = 5;
            float saturationRestore = 6F;
            if (saturate() && saturationLevel < foodLevel) {
                player.getFoodData().setSaturation(saturationLevel+1);
            }
            if (foodLevel < 20) {
                player.getFoodData().setFoodLevel(foodLevel+foodRestore);
                player.getFoodData().setSaturation(saturationRestore);
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
        if (player.getInventory().contains(Items.BAKED_POTATO.getDefaultInstance()) && player.getItemInHand(pHand).getDamageValue() != 0) {
            ItemStack itemstack = player.getInventory().getItem(player.getInventory().findSlotMatchingItem(Items.BAKED_POTATO.getDefaultInstance()));
            totemStack.setDamageValue(totemStack.getDamageValue()-1);
            itemstack.shrink(1);
            if (itemstack.isEmpty()) {
                player.getInventory().removeItem(itemstack);
            }
            return InteractionResultHolder.consume(totemStack);
        } else if (player.getInventory().contains(Items.BREAD.getDefaultInstance()) && player.getItemInHand(pHand).getDamageValue() != 0) {
            ItemStack itemstack = player.getInventory().getItem(player.getInventory().findSlotMatchingItem(Items.BREAD.getDefaultInstance()));
            totemStack.setDamageValue(totemStack.getDamageValue()-1);
            itemstack.shrink(1);
            if (itemstack.isEmpty()) {
                player.getInventory().removeItem(itemstack);
            }
            return InteractionResultHolder.consume(totemStack);
        } else if (player.getInventory().contains(Items.COOKED_COD.getDefaultInstance()) && player.getItemInHand(pHand).getDamageValue() != 0) {
            ItemStack itemstack = player.getInventory().getItem(player.getInventory().findSlotMatchingItem(Items.COOKED_COD.getDefaultInstance()));
            totemStack.setDamageValue(totemStack.getDamageValue()-1);
            itemstack.shrink(1);
            if (itemstack.isEmpty()) {
                player.getInventory().removeItem(itemstack);
            }
            return InteractionResultHolder.consume(totemStack);
        } else if (player.getInventory().contains(Items.COOKED_RABBIT.getDefaultInstance()) && player.getItemInHand(pHand).getDamageValue() != 0) {
            ItemStack itemstack = player.getInventory().getItem(player.getInventory().findSlotMatchingItem(Items.COOKED_RABBIT.getDefaultInstance()));
            totemStack.setDamageValue(totemStack.getDamageValue()-1);
            itemstack.shrink(1);
            if (itemstack.isEmpty()) {
                player.getInventory().removeItem(itemstack);
            }
            return InteractionResultHolder.consume(totemStack);
        } else return InteractionResultHolder.fail(totemStack);
    }

    public boolean saturate() {
        int randomInteger = RandomSource.create().nextIntBetweenInclusive(0, 1200);
        return randomInteger == 1169;
    }
}
