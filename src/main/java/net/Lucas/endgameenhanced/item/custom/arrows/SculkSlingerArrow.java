package net.Lucas.endgameenhanced.item.custom.arrows;

import net.Lucas.endgameenhanced.entity.projectile.DefaultSculkSlingerArrowEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SculkSlingerArrow extends ArrowItem {
    public final float damage;
    public SculkSlingerArrow(Properties pProperties, float damage) {
        super(pProperties);
        this.damage = damage;
    }

    @Override
    public @NotNull AbstractArrow createArrow(@NotNull Level pLevel, ItemStack pStack, @NotNull LivingEntity pShooter) {
        DefaultSculkSlingerArrowEntity arrow = new DefaultSculkSlingerArrowEntity(pLevel, pShooter, pStack.copyWithCount(1));
        arrow.setBaseDamage(this.damage);
        return arrow;
    }
}
