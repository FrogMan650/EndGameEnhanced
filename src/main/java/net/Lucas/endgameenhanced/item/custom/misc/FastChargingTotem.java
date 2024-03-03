package net.Lucas.endgameenhanced.item.custom.misc;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FastChargingTotem extends Item {
    public FastChargingTotem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player && pStack.getDamageValue() > 0 && player.getItemInHand(InteractionHand.OFF_HAND).is(this)) {
            Level level = player.level();
            pStack.setDamageValue(pStack.getDamageValue()-1);
            if (pStack.getDamageValue() > 2970) {
                for(int i = 1; i < 5; ++i) {
                    level.addParticle(ParticleTypes.TOTEM_OF_UNDYING, player.getX()+randomDouble(), player.getY()+2+randomDouble(), player.getZ()+randomDouble(), 0.0D, 0.0D, 0.0D);
                }
            }
            if (pStack.getDamageValue() == 2999) {
                level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.TOTEM_USE, player.getSoundSource(), 1.0F, 1.0F);
            }
        }
    }

    public double randomDouble() {
        double randDouble = RandomSource.create().nextDouble();
        double randDouble2 = RandomSource.create().nextDouble();
        boolean negativeOrNot = randDouble2 > 0.5;
        if (negativeOrNot) {
            randDouble *= -1.0D;
        }
        return randDouble;
    }
}
