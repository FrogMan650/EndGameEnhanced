package net.Lucas.endgameenhanced.item.custom.weapons;

import net.Lucas.endgameenhanced.item.ModItems;
import net.Lucas.endgameenhanced.item.custom.arrows.SapphireArrow;
import net.Lucas.endgameenhanced.util.ModTags;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WebweaverBow extends BowItem {
    public WebweaverBow(Properties pProperties) {
        super(pProperties);
    }

    public void releaseUsing(ItemStack bowStack, Level worldIn, LivingEntity entityLiving, int pTimeLeft) {
        if (entityLiving instanceof Player player) {
            boolean hasCreative = player.getAbilities().instabuild;
            boolean hasInfinity = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.INFINITY_ARROWS, bowStack) > 0;
            boolean hasInfinityOrCreative = hasCreative || hasInfinity;
            ItemStack ammoStack = player.getProjectile(bowStack);
            int timeDrawn = this.getUseDuration(bowStack) - pTimeLeft;
            timeDrawn = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(bowStack, worldIn, player, timeDrawn, !ammoStack.isEmpty() || hasInfinityOrCreative);
            if (timeDrawn < 0) return;
            boolean shouldRoll = true;
            if (ammoStack.isEmpty()) {
                shouldRoll = false;
                ammoStack = new ItemStack(ModItems.WEBWEAVER_ARROW.get());//default arrow
            }
            float velocity = getPowerForTime(timeDrawn);
            if (!((double)velocity < 0.1D)) {
                boolean flag1 = hasCreative || (ammoStack.getItem() instanceof ArrowItem && ((ArrowItem)ammoStack.getItem()).isInfinite(ammoStack, bowStack, player));
                boolean isTippedArrow = ammoStack.is(ModTags.Items.NO_PICKUP_ARROWS);
                if (!worldIn.isClientSide) {
                    ArrowItem arrowitem = (ArrowItem)(ammoStack.getItem() instanceof ArrowItem ? ammoStack.getItem() : Items.ARROW);
                    AbstractArrow arrowEntity = createArrow(worldIn, ammoStack, player, arrowitem);
                    arrowEntity = customArrow(arrowEntity);
                    arrowEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, velocity * 4.5F, 0.5F);
                    if (velocity >= 1.0F) {
                        arrowEntity.setCritArrow(true);
                    }
                    //damage
                    double damage = getArrowDamage(bowStack, ammoStack, hasInfinityOrCreative);
                    arrowEntity.setBaseDamage(damage);
                    //knockback
                    int knockback = getArrowKnockback(bowStack, arrowEntity);
                    arrowEntity.setKnockback(knockback);
                    //fire
                    if (EnchantmentHelper.getTagEnchantmentLevel(Enchantments.FLAMING_ARROWS, bowStack) > 0) {
                        arrowEntity.setSecondsOnFire(100);
                    }

                    bowStack.hurtAndBreak(0, player, (p_289501_) -> {
                        p_289501_.broadcastBreakEvent(player.getUsedItemHand());
                    });
                    if (hasInfinityOrCreative || isTippedArrow) {
                        arrowEntity.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                    }
                    //spawn arrow entity
                    worldIn.addFreshEntity(arrowEntity);
                }

                worldIn.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (worldIn.getRandom().nextFloat() * 0.4F + 1.2F) + velocity * 0.5F);
                boolean shouldConsumeArrow = !hasInfinityOrCreative || isTippedArrow;

                //25% chance to save ammo
                float randomFloat = RandomSource.create().nextFloat();
                int saveChance = 0;
                if (randomFloat >= 0 && randomFloat <= 0.25F && shouldRoll) {
                    saveChance = 1;
                }

                if (shouldConsumeArrow && !hasCreative) {
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

    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        pPlayer.startUsingItem(pHand);
        return InteractionResultHolder.consume(itemstack);
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
        int bowKnockback = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.PUNCH_ARROWS, bowStack);
        return bowKnockback;
    }

    protected double getArrowDamage(ItemStack bowStack, ItemStack ammoStack, boolean hasInfinityOrCreative) {
        double baseDamage = 2.2D;
        int bowPower = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.POWER_ARROWS, bowStack);
        if (ammoStack.is(ModItems.WEBWEAVER_ARROW.get()) && !hasInfinityOrCreative && bowPower > 0) {
            return 1.5D + (double)bowPower * 0.15D + 0.2D;
        }
        if (ammoStack.is(ModItems.WEBWEAVER_ARROW.get()) && !hasInfinityOrCreative) {
            return 1.5D;
        }
        if (bowPower > 0) return baseDamage + (double)bowPower * 0.15D + 0.2D;
        else return baseDamage;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        final ChatFormatting GOLD_TEXT = ChatFormatting.GOLD;
        final ChatFormatting GREEN_TEXT = ChatFormatting.DARK_GREEN;
        final ChatFormatting WHITE_TEXT = ChatFormatting.DARK_GRAY;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        int bowPower = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.POWER_ARROWS, pStack);
        boolean bowInfinity = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.INFINITY_ARROWS, pStack) > 0;
        String damageTranslation = "endgameenhanced:webweaver.damage."+ bowPower;
        String noAmmoDamageTranslation = "endgameenhanced:webweaver.damage.without_ammo."+ (bowPower+10);

        Component webweaver_lore = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:webweaver.lore"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        pTooltipComponents.add(webweaver_lore);

        Component webweaver_space = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.tooltip.space"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        pTooltipComponents.add(webweaver_space);

        Component webweaver_damage = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                (damageTranslation))).withStyle(GREEN_TEXT);

        Component webweaver_drawn_no_ammo = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:webweaver.drawn.no_ammo"))).withStyle(GREY_TEXT);
        pTooltipComponents.add(webweaver_drawn_no_ammo);

        Component webweaver_damage_no_ammo = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                (noAmmoDamageTranslation))).withStyle(GREEN_TEXT);
        if (bowInfinity) {
            pTooltipComponents.add(webweaver_damage);
        } else {
            pTooltipComponents.add(webweaver_damage_no_ammo);
        }

        Component webweaver_drawn = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:webweaver.drawn"))).withStyle(GREY_TEXT);
        pTooltipComponents.add(webweaver_drawn);

        pTooltipComponents.add(webweaver_damage);

        pTooltipComponents.add(webweaver_space);

        Component webweaver_trait = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:webweaver.trait"))).withStyle(WHITE_TEXT);
        pTooltipComponents.add(webweaver_trait);

        Component trait_full_description = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:webweaver.trait.description"))).withStyle(GOLD_TEXT);

        Component hold_shift = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.tooltip.hold_shift"))).withStyle(GOLD_TEXT);

        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(trait_full_description);
        } else {
            pTooltipComponents.add(hold_shift);
        }
    }
}
