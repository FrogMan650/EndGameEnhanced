package net.Lucas.endgameenhanced.item.custom.arrows;

import net.Lucas.endgameenhanced.entity.projectile.DiamondArrowEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DiamondArrow extends ArrowItem {
    public final float damage;
    public DiamondArrow(Properties pProperties, float damage) {
        super(pProperties);
        this.damage = damage;
    }

    @Override
    public @NotNull AbstractArrow createArrow(@NotNull Level pLevel, ItemStack pStack, @NotNull LivingEntity pShooter) {
        DiamondArrowEntity arrow = new DiamondArrowEntity(pLevel, pShooter, pStack.copyWithCount(1));
        arrow.setBaseDamage(this.damage);
        return arrow;
    }

    @Override
    public boolean isInfinite(@NotNull ItemStack stack, @NotNull ItemStack bow, net.minecraft.world.entity.player.@NotNull Player player) {
        return player.isCreative();
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        final ChatFormatting GOLD_TEXT = ChatFormatting.GOLD;
        final ChatFormatting AQUA_TEXT = ChatFormatting.DARK_AQUA;

        Component arrow_effect_description = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:arrow.diamond_arrow"))).withStyle(AQUA_TEXT);
        pTooltipComponents.add(arrow_effect_description);

        Component arrow_full_description = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:arrow.diamond_arrow.description"))).withStyle(GOLD_TEXT);

        Component hold_shift = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.tooltip.hold_shift"))).withStyle(GOLD_TEXT);

        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(arrow_full_description);
        } else {
            pTooltipComponents.add(hold_shift);
        }
    }
}
