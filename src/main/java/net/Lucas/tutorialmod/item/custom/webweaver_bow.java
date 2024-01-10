package net.Lucas.tutorialmod.item.custom;

import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;

public class webweaver_bow extends CustomBowItem{
    public webweaver_bow(Properties pProperties) {
        super(pProperties);
    }

    protected double getArrowDamage(ItemStack bowStack, AbstractArrow arrowEntity) {
        //base damage is 2.0D
        double baseDamage = 3.0D;
        int bowPower = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, bowStack);
        if (bowPower > 0) return baseDamage + (double)bowPower * 0.5D + 0.5D;
        else return baseDamage;
    }
}
