package net.Lucas.endgameenhanced.item.custom.arrows;

import net.Lucas.endgameenhanced.entity.projectile.DiamondArrowEntity;
import net.Lucas.endgameenhanced.entity.projectile.SapphireArrowEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DiamondArrow extends ArrowItem {
    public final float damage;
    public DiamondArrow(Properties pProperties, float damage) {
        super(pProperties);
        this.damage = damage;
    }

    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        DiamondArrowEntity arrow = new DiamondArrowEntity(pLevel, pShooter, pStack.copyWithCount(1));
        arrow.setBaseDamage(this.damage);
        return arrow;
    }

    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getTagEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == DiamondArrow.class;
    }
}
