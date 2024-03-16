package net.Lucas.endgameenhanced.item.custom.totems;

import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class NourishingTotem extends Item {
    public NourishingTotem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player && player.getItemInHand(InteractionHand.OFF_HAND).is(this)) {
            float saturationLevel = player.getFoodData().getSaturationLevel();
            int foodLevel = player.getFoodData().getFoodLevel();
            if (saturate() && saturationLevel < foodLevel) {
                player.getFoodData().setSaturation(saturationLevel+1);
                pStack.hurtAndBreak(1, player, (p_289501_) -> {
                    p_289501_.broadcastBreakEvent(player.getUsedItemHand());
                });
            }
        }
    }

    public boolean saturate() {
        int randomInteger = RandomSource.create().nextIntBetweenInclusive(0, 1200);
        return randomInteger == 1169;
    }
}
