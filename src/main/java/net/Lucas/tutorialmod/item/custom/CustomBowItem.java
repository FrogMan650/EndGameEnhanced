package net.Lucas.tutorialmod.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class CustomBowItem extends BowItem {
    //https://www.youtube.com/watch?v=43H--qCpQYQ&ab_channel=OptimisticNanobot
    public CustomBowItem(Properties pProperties) {
        super(pProperties);
    }

    public void releaseUsing(ItemStack bowStack, Level worldIn, LivingEntity entityLiving, int pTimeLeft) {
        if (entityLiving instanceof Player player) {
            boolean hasInfinity = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, bowStack) > 0;
            ItemStack ammoStack = player.getProjectile(bowStack);

            int timeDrawn = this.getUseDuration(bowStack) - pTimeLeft;
            timeDrawn = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(bowStack, worldIn, player, timeDrawn, !ammoStack.isEmpty() || hasInfinity);
            if (timeDrawn < 0) return;

            if (!ammoStack.isEmpty() || hasInfinity) {
                if (ammoStack.isEmpty()) {
                    ammoStack = new ItemStack(Items.ARROW);
                }

                float velocity = getPowerForTime(timeDrawn);
                if (!((double)velocity < 0.1D)) {
                    boolean flag1 = player.getAbilities().instabuild || (ammoStack.getItem() instanceof ArrowItem && ((ArrowItem)ammoStack.getItem()).isInfinite(ammoStack, bowStack, player));
                    boolean isTippedArrow = ammoStack.getItem() == Items.SPECTRAL_ARROW || ammoStack.getItem() == Items.TIPPED_ARROW;
                    if (!worldIn.isClientSide) {
                        ArrowItem arrowitem = (ArrowItem)(ammoStack.getItem() instanceof ArrowItem ? ammoStack.getItem() : Items.ARROW);
                        AbstractArrow arrowEntity = createArrow(worldIn, ammoStack, player, arrowitem);
                        arrowEntity = customArrow(arrowEntity);
                        arrowEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, velocity * 10.0F, 5.0F);
                        if (velocity >= 1.0F) {
                            arrowEntity.setCritArrow(true);
                        }
                        
                        double damage = getArrowDamage(bowStack, arrowEntity);
                        arrowEntity.setBaseDamage(damage);

                        int knockback = getArrowKnockback(bowStack, arrowEntity);
                        arrowEntity.setKnockback(knockback);

                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, bowStack) > 0) {
                            arrowEntity.setSecondsOnFire(100);
                        }

                        bowStack.hurtAndBreak(1, player, (p_289501_) -> {
                            p_289501_.broadcastBreakEvent(player.getUsedItemHand());
                        });
                        if (hasInfinity && !isTippedArrow) {
                            arrowEntity.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }

                        worldIn.addFreshEntity(arrowEntity);
                    }

                    worldIn.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (worldIn.getRandom().nextFloat() * 0.4F + 1.2F) + velocity * 0.5F);
                    boolean shouldConsumeArrow = !hasInfinity || isTippedArrow;
                    if (shouldConsumeArrow) {
                        ammoStack.shrink(1);
                        if (ammoStack.isEmpty()) {
                            player.getInventory().removeItem(ammoStack);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    protected AbstractArrow createArrow(Level worldIn, ItemStack ammoStack, Player player, ArrowItem arrowitem) {
        return arrowitem.createArrow(worldIn, ammoStack, player);
    }

    protected int getArrowKnockback(ItemStack bowStack, AbstractArrow arrowEntity) {
        int bowKnockback = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, bowStack);
        return EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, bowStack);
    }

    protected double getArrowDamage(ItemStack bowStack, AbstractArrow arrowEntity) {
        int bowPower = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, bowStack);
        if (bowPower > 0) return arrowEntity.getBaseDamage() + (double)bowPower * 0.5D + 0.5D;
        else return arrowEntity.getBaseDamage();
    }
}
