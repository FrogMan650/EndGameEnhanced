package net.Lucas.tutorialmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
                        arrowEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, velocity * 10.0F, 0.5F);
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

                    //25% chance to save ammo
                    float randomFloat = RandomSource.create().nextFloat();
                    int saveChance = 0;
                    if (randomFloat >= 0 && randomFloat <= 0.25F) {
                        saveChance = 1;
                    }

                    if (shouldConsumeArrow) {
                        ammoStack.shrink(1);
                        ammoStack.grow(saveChance);
                        if (ammoStack.isEmpty()) {
                            player.getInventory().removeItem(ammoStack);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public static float getPowerForTime(int pCharge) {
        float f = (float)pCharge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    protected AbstractArrow createArrow(Level worldIn, ItemStack ammoStack, Player player, ArrowItem arrowitem) {
        return arrowitem.createArrow(worldIn, ammoStack, player);
    }

    protected int getArrowKnockback(ItemStack bowStack, AbstractArrow arrowEntity) {
        int bowKnockback = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, bowStack);
        return bowKnockback;
    }

    protected double getArrowDamage(ItemStack bowStack, AbstractArrow arrowEntity) {
        double baseDamage = 2.0D;
        int bowPower = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, bowStack);
        if (bowPower > 0) return baseDamage + (double)bowPower * 0.1D + 0.2D;
        else return baseDamage;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        final ChatFormatting GREEN_TEXT = ChatFormatting.DARK_GREEN;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        int bowPower = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, pStack);
        int bowDamage = (bowPower*2) + 25;
        String damageTranslation = "webweaver_lore.green_text_arrow."+ bowDamage;
        Component webweaver_lore = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("webweaver_lore.red_text"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component webweaver_lore_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("webweaver_lore.red_text_two"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);

        Component webweaver_stats_header_arrow = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("webweaver_lore.grey_text_arrow"))).withStyle(GREY_TEXT);

        Component webweaver_stats_arrow = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                (damageTranslation))).withStyle(GREEN_TEXT);

        Component webweaver_stats_arrow_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("webweaver_lore.green_text_arrow_two"))).withStyle(GREEN_TEXT);
        Component webweaver_stats_arrow_three = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("webweaver_lore.green_text_arrow_three"))).withStyle(GREEN_TEXT);
        Component webweaver_stats_arrow_four = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("webweaver_lore.green_text_arrow_four"))).withStyle(GREEN_TEXT);
        Component webweaver_stats_arrow_five = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("webweaver_lore.green_text_arrow_five"))).withStyle(GREEN_TEXT);

        pTooltipComponents.add(webweaver_lore);
        pTooltipComponents.add(webweaver_lore_two);
        pTooltipComponents.add(webweaver_stats_header_arrow);
        pTooltipComponents.add(webweaver_stats_arrow);
        pTooltipComponents.add(webweaver_stats_arrow_two);
        pTooltipComponents.add(webweaver_stats_arrow_three);
        pTooltipComponents.add(webweaver_stats_arrow_four);
        pTooltipComponents.add(webweaver_stats_arrow_five);
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
