package net.Lucas.endgameenhanced.item.custom.armor;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;

public class CustomElytra extends ElytraItem {
    public CustomElytra(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        return true;
    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
        return super.elytraFlightTick(stack, entity, flightTicks);
    }
}
