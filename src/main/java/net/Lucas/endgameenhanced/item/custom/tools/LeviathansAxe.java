package net.Lucas.endgameenhanced.item.custom.tools;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.Lucas.endgameenhanced.entity.custom.LeviathansAxeEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class LeviathansAxe extends AxeItem {
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;

    public LeviathansAxe(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Item.Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 9.0D, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -3.0F, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }
    public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }
    public @NotNull UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.SPEAR;
    }

    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
            int i = this.getUseDuration(pStack) - pTimeLeft;
            if (i >= 8) {
                int j = EnchantmentHelper.getRiptide(pStack);
                if (j <= 0 || player.isInWaterOrRain()) {
                    if (!pLevel.isClientSide) {
                        pStack.hurtAndBreak(0, player, (p_43388_) -> {
                            p_43388_.broadcastBreakEvent(pEntityLiving.getUsedItemHand());
                        });
                        if (j == 0) {
                            LeviathansAxeEntity throwntrident = new LeviathansAxeEntity(pLevel, player, pStack);
                            throwntrident.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3F + (float)j * 0.5F, 1.0F);
                            if (player.getAbilities().instabuild) {
                                throwntrident.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                            }

                            pLevel.addFreshEntity(throwntrident);
                            pLevel.playSound((Player)null, throwntrident, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
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
                        float f5 = 3.0F * ((1.0F + (float)j) / 4.0F);
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

    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (itemstack.getDamageValue() >= itemstack.getMaxDamage() - 1) {
            return InteractionResultHolder.fail(itemstack);
        } else if (EnchantmentHelper.getRiptide(itemstack) > 0 && !pPlayer.isInWaterOrRain()) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            pPlayer.startUsingItem(pHand);
            return InteractionResultHolder.consume(itemstack);
        }
    }

    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(0, pAttacker, (p_43414_) -> {
            p_43414_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if ((double)pState.getDestroySpeed(pLevel, pPos) != 0.0D) {
            pStack.hurtAndBreak(0, pEntityLiving, (p_43385_) -> {
                p_43385_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }

        return true;
    }

    public @NotNull Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        return pEquipmentSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
    }

    public int getEnchantmentValue() {
        return 1;
    }

    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        BlockState blockstate = level.getBlockState(blockpos);
        Optional<BlockState> optional = Optional.ofNullable(blockstate.getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.AXE_STRIP, false));
        Optional<BlockState> optional1 = optional.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.AXE_SCRAPE, false));
        Optional<BlockState> optional2 = optional.isPresent() || optional1.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.AXE_WAX_OFF, false));
        ItemStack itemstack = pContext.getItemInHand();
        Optional<BlockState> optional3 = Optional.empty();
        if (optional.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            optional3 = optional;
        } else if (optional1.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.levelEvent(player, 3005, blockpos, 0);
            optional3 = optional1;
        } else if (optional2.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.levelEvent(player, 3004, blockpos, 0);
            optional3 = optional2;
        }

        if (optional3.isPresent()) {
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
            }

            level.setBlock(blockpos, optional3.get(), 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, optional3.get()));
            if (player != null) {
                itemstack.hurtAndBreak(0, player, (p_150686_) -> {
                    p_150686_.broadcastBreakEvent(pContext.getHand());
                });
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        final ChatFormatting GOLD_TEXT = ChatFormatting.GOLD;
        final ChatFormatting GREEN_TEXT = ChatFormatting.DARK_GREEN;
        final ChatFormatting AQUA_TEXT = ChatFormatting.AQUA;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        int sharpnessLevel = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.SHARPNESS, pStack);
        int smiteLevel = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.SMITE, pStack);
        int arthropodLevel = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.BANE_OF_ARTHROPODS, pStack);
        double axeSharpnessThrownDamage = sharpnessLevel+19;
        double axeSharpnessMeleeDamage = sharpnessLevel+19;
        double axeSmiteThrownDamage = smiteLevel+9;
        double axeSmiteMeleeDamage = smiteLevel+9;
        double axeArthropodThrownDamage = arthropodLevel+9;
        double axeArthropodMeleeDamage = arthropodLevel+9;
        String thrownDamageTranslation = "endgameenhanced:leviathans_axe.thrown_damage.0";
        String meleeDamageTranslation = "endgameenhanced:leviathans_axe.melee_damage.0";
        Component leviathans_axe_thrown_damage = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                (thrownDamageTranslation))).withStyle(GREEN_TEXT);
        Component leviathans_axe_melee_damage = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                (meleeDamageTranslation))).withStyle(GREEN_TEXT);

        if (sharpnessLevel > 0) {
            thrownDamageTranslation = "endgameenhanced:leviathans_axe.thrown_damage."+ axeSharpnessThrownDamage;
            meleeDamageTranslation = "endgameenhanced:leviathans_axe.melee_damage."+ axeSharpnessMeleeDamage;
            leviathans_axe_thrown_damage = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                    (thrownDamageTranslation))).withStyle(GREEN_TEXT);
            leviathans_axe_melee_damage = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                    (meleeDamageTranslation))).withStyle(GREEN_TEXT);
        }
        if (smiteLevel > 0) {
            thrownDamageTranslation = "endgameenhanced:leviathans_axe.thrown_damage."+ axeSmiteThrownDamage;
            meleeDamageTranslation = "endgameenhanced:leviathans_axe.melee_damage."+ axeSmiteMeleeDamage;
            leviathans_axe_thrown_damage = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                    (thrownDamageTranslation))).withStyle(GREEN_TEXT);
            leviathans_axe_melee_damage = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                    (meleeDamageTranslation))).withStyle(GREEN_TEXT);
        }
        if (arthropodLevel > 0) {
            thrownDamageTranslation = "endgameenhanced:leviathans_axe.thrown_damage."+ axeArthropodThrownDamage;
            meleeDamageTranslation = "endgameenhanced:leviathans_axe.melee_damage."+ axeArthropodMeleeDamage;
            leviathans_axe_thrown_damage = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                    (thrownDamageTranslation))).withStyle(GREEN_TEXT);
            leviathans_axe_melee_damage = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                    (meleeDamageTranslation))).withStyle(GREEN_TEXT);
        }
        Component leviathans_axe_lore = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:leviathans_axe.lore"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        pTooltipComponents.add(leviathans_axe_lore);

        Component leviathans_axe_space = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.tooltip.space"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        pTooltipComponents.add(leviathans_axe_space);

        Component leviathans_axe_thrown = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.weapon.thrown"))).withStyle(GREY_TEXT);
        pTooltipComponents.add(leviathans_axe_thrown);

        pTooltipComponents.add(leviathans_axe_thrown_damage);

        Component leviathans_axe_melee = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.weapon.melee"))).withStyle(GREY_TEXT);
        pTooltipComponents.add(leviathans_axe_melee);

        pTooltipComponents.add(leviathans_axe_melee_damage);

        Component leviathans_axe_attack_speed = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.weapon.attack_speed_1"))).withStyle(GREEN_TEXT);
        pTooltipComponents.add(leviathans_axe_attack_speed);

        pTooltipComponents.add(leviathans_axe_space);

        Component leviathans_axe_trait = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:leviathans_axe.trait"))).withStyle(AQUA_TEXT);
        pTooltipComponents.add(leviathans_axe_trait);

        Component trait_full_description = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:leviathans_axe.trait.description"))).withStyle(GOLD_TEXT);

        Component hold_shift = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.tooltip.hold_shift"))).withStyle(GOLD_TEXT);

        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(trait_full_description);
        } else {
            pTooltipComponents.add(hold_shift);
        }
    }
}
