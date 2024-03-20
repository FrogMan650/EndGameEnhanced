package net.Lucas.endgameenhanced.item.custom.totems;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OverclockedTotemOfUndying extends Item {
    public OverclockedTotemOfUndying(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void inventoryTick(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player && pStack.getDamageValue() > 0 && player.getItemInHand(InteractionHand.OFF_HAND).is(this)) {
            Level level = player.level();
            pStack.setDamageValue(pStack.getDamageValue()-1);
            if (pStack.getDamageValue() > 1170) {
                for(int i = 1; i < 5; ++i) {
                    level.addParticle(ParticleTypes.TOTEM_OF_UNDYING, player.getX()+randomDouble(), player.getY()+2+randomDouble(), player.getZ()+randomDouble(), 0.0D, 0.0D, 0.0D);
                }
            }
            if (pStack.getDamageValue() == 1199) {
                level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.TOTEM_USE, player.getSoundSource(), 1.0F, 1.0F);
            }
        }
    }

    @Override
    public boolean isFoil(@NotNull ItemStack pStack) {
        return true;
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

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        ChatFormatting VARIABLE_TEXT = ChatFormatting.DARK_GREEN;
        int secondsLeft = pStack.getDamageValue()/20;
        int secondsMax = pStack.getMaxDamage()/20;
        int timeLeft = secondsMax-(secondsMax-secondsLeft);
        double percentChargesRemaining = (double) timeLeft / secondsMax;
        if (percentChargesRemaining < 0.66 && percentChargesRemaining > 0.33) {
            VARIABLE_TEXT = ChatFormatting.YELLOW;
        }
        if (percentChargesRemaining >= 0.66) {
            VARIABLE_TEXT = ChatFormatting.RED;
        }

        Component totem_charges_remaining = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.totem.time_remaining"))).withStyle(GREY_TEXT);
        pTooltipComponents.add(totem_charges_remaining);

        Component totem_seconds = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.totem.time_seconds"))).withStyle(VARIABLE_TEXT);

        Component totem_ready = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.totem.time_ready"))).withStyle(VARIABLE_TEXT);

        Component totem_current_charges = Component.literal(String.valueOf(timeLeft)).withStyle(VARIABLE_TEXT);
        Component totem_current_charges_display = Component.literal(" "+totem_current_charges.getString()+" "+totem_seconds.getString()).withStyle(VARIABLE_TEXT);
        if (pStack.getDamageValue() == 0) {
            pTooltipComponents.add(totem_ready);
        } else {
            pTooltipComponents.add(totem_current_charges_display);
        }
    }
}
