package net.Lucas.tutorialmod.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.Lucas.tutorialmod.entity.custom.TideBreakerEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CustomTridentItem extends TridentItem {
    public static final int THROW_THRESHOLD_TIME = 10;
    public static final float BASE_DAMAGE = 15.0F;
    public static final float SHOOT_POWER = 2.5F;
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;
    public CustomTridentItem(Properties pProperties) {
        super(pProperties);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", BASE_DAMAGE, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", (double)-2.4F, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
            int i = this.getUseDuration(pStack) - pTimeLeft;
            if (i >= 7) {
                int j = EnchantmentHelper.getRiptide(pStack);
                if (j <= 0 || player.isInWaterOrRain()) {
                    if (!pLevel.isClientSide) {
                        pStack.hurtAndBreak(0, player, (p_43388_) -> {
                            p_43388_.broadcastBreakEvent(pEntityLiving.getUsedItemHand());
                        });
                        if (j == 0) {
                            TideBreakerEntity throwntidebreaker = new TideBreakerEntity(pLevel, player, pStack);
                            throwntidebreaker.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 8F + (float)j * 0.5F, 0.5F);
                            if (player.getAbilities().instabuild) {
                                throwntidebreaker.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                            }

                            pLevel.addFreshEntity(throwntidebreaker);
                            pLevel.playSound((Player)null, throwntidebreaker, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
                            if (!player.getAbilities().instabuild) {
                                player.getInventory().removeItem(pStack);
                            }
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                    if (j > 0) {
                        float f7 = player.getYRot();
                        float f = player.getXRot();
                        float f1 = -Mth.sin(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
                        float f2 = -Mth.sin(f * ((float)Math.PI / 180F));
                        float f3 = Mth.cos(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
                        float f4 = Mth.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
                        float f5 = 3.0F * ((4.0F + (float)j) / 4.0F);
                        f1 *= f5 / f4;
                        f2 *= f5 / f4;
                        f3 *= f5 / f4;
                        player.push((double)f1, (double)f2, (double)f3);
                        player.startAutoSpinAttack(20);
                        if (player.onGround()) {
                            float f6 = 1.1999999F;
                            player.move(MoverType.SELF, new Vec3(0.0D, (double)1.1999999F, 0.0D));
                        }

                        SoundEvent soundevent;
                        if (j >= 3) {
                            soundevent = SoundEvents.TRIDENT_RIPTIDE_3;
                        } else if (j == 2) {
                            soundevent = SoundEvents.TRIDENT_RIPTIDE_2;
                        } else {
                            soundevent = SoundEvents.TRIDENT_RIPTIDE_1;
                        }

                        pLevel.playSound((Player)null, player, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
                    }

                }
            }
        }
    }

    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.SPEAR;
    }

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        return pEquipmentSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
    }

    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(0, pAttacker, (p_43414_) -> {
            p_43414_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    /**
     * Called when a {@link net.minecraft.world.level.block.Block} is destroyed using this Item. Return {@code true} to
     * trigger the "Use Item" statistic.
     */
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if ((double)pState.getDestroySpeed(pLevel, pPos) != 0.0D) {
            pStack.hurtAndBreak(0, pEntityLiving, (p_43385_) -> {
                p_43385_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }

        return true;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        final ChatFormatting GREEN_TEXT = ChatFormatting.DARK_GREEN;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        int tridentPower = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.IMPALING, pStack);
        double tridentThrownDamage = (tridentPower*2.5) + 25;
        double tridentMeleeDamage = (tridentPower*2.5) + 16;
        String thrownDamageTranslation = "tide_breaker_lore.green_text_arrow.thrown."+ tridentThrownDamage;
        String meleeDamageTranslation = "tide_breaker_lore.green_text_arrow.melee."+ tridentMeleeDamage;
        Component tide_breaker_lore = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("tide_breaker_lore.red_text"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component tide_breaker_lore_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("tide_breaker_lore.red_text_two"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component tide_breaker_stats_header_arrow = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("tide_breaker_lore.grey_text_arrow"))).withStyle(GREY_TEXT);
        Component tide_breaker_stats_arrow = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                (thrownDamageTranslation))).withStyle(GREEN_TEXT);
        Component tide_breaker_stats_arrow_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("tide_breaker_lore.green_text_arrow_two"))).withStyle(GREEN_TEXT);
        Component tide_breaker_stats_arrow_three = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("tide_breaker_lore.green_text_arrow_three"))).withStyle(GREEN_TEXT);
        Component tide_breaker_stats_arrow_four = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("tide_breaker_lore.green_text_arrow_four"))).withStyle(GREEN_TEXT);
        Component tide_breaker_stats_header_arrow_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("tide_breaker_lore.grey_text_arrow_two"))).withStyle(GREY_TEXT);
        Component tide_breaker_stats_arrow_five = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                (meleeDamageTranslation))).withStyle(GREEN_TEXT);
        Component tide_breaker_stats_arrow_six = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("tide_breaker_lore.green_text_arrow_six"))).withStyle(GREEN_TEXT);
        Component tide_breaker_stats_arrow_seven = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("tide_breaker_lore.green_text_arrow_seven"))).withStyle(GREEN_TEXT);


        pTooltipComponents.add(tide_breaker_lore);
        pTooltipComponents.add(tide_breaker_lore_two);
        pTooltipComponents.add(tide_breaker_stats_header_arrow);
        pTooltipComponents.add(tide_breaker_stats_arrow);
        pTooltipComponents.add(tide_breaker_stats_arrow_two);
        pTooltipComponents.add(tide_breaker_stats_arrow_three);
        pTooltipComponents.add(tide_breaker_stats_arrow_four);
        pTooltipComponents.add(tide_breaker_stats_header_arrow_two);
        pTooltipComponents.add(tide_breaker_stats_arrow_five);
        pTooltipComponents.add(tide_breaker_stats_arrow_six);
        pTooltipComponents.add(tide_breaker_stats_arrow_seven);
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
