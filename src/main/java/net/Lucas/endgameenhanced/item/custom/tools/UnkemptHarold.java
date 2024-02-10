package net.Lucas.endgameenhanced.item.custom.tools;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UnkemptHarold extends ShovelItem {
    public UnkemptHarold(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        Player player = pContext.getPlayer();
        if (pContext.getClickedFace() == Direction.DOWN) {
            return InteractionResult.PASS;
        } else {
            BlockState blockstate1 = blockstate.getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.SHOVEL_FLATTEN, false);
            BlockState blockstate2 = null;
            if (blockstate1 != null && level.isEmptyBlock(blockpos.above())) {
                level.playSound(player, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                blockstate2 = blockstate1;
            } else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.getValue(CampfireBlock.LIT)) {
                if (!level.isClientSide()) {
                    level.levelEvent((Player)null, 1009, blockpos, 0);
                }

                CampfireBlock.dowse(pContext.getPlayer(), level, blockpos, blockstate);
                blockstate2 = blockstate.setValue(CampfireBlock.LIT, Boolean.valueOf(false));
            }

            if (blockstate2 != null) {
                if (!level.isClientSide) {
                    level.setBlock(blockpos, blockstate2, 11);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, blockstate2));
                    if (player != null) {
                        pContext.getItemInHand().hurtAndBreak(0, player, (p_43122_) -> {
                            p_43122_.broadcastBreakEvent(pContext.getHand());
                        });
                    }
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        }
    }

    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(0, pAttacker, (p_41007_) -> {
            p_41007_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide && pState.getDestroySpeed(pLevel, pPos) != 0.0F) {
            pStack.hurtAndBreak(0, pEntityLiving, (p_40992_) -> {
                p_40992_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }

        return true;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        final ChatFormatting GREEN_TEXT = ChatFormatting.DARK_GREEN;
        final ChatFormatting YELLOW_TEXT = ChatFormatting.YELLOW;
        Component unkempt_harold_lore = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:unkempt_harold_lore.red_text"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component unkempt_harold_lore_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:unkempt_harold_lore.red_text_two"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component unkempt_harold_stats_header_arrow = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:unkempt_harold_lore.grey_text_arrow"))).withStyle(GREY_TEXT);
        Component unkempt_harold_stats_arrow_seven = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:unkempt_harold_lore.green_text_arrow_seven"))).withStyle(GREEN_TEXT);
        Component unkempt_harold_stats_arrow_eight = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:unkempt_harold_lore.green_text_arrow_eight"))).withStyle(GREEN_TEXT);
        Component unkempt_harold_stats_arrow_nine = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:unkempt_harold_lore.green_text_arrow_nine"))).withStyle(GREEN_TEXT);
        Component unkempt_harold_stats_arrow_ten = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:unkempt_harold_lore.green_text_arrow_ten"))).withStyle(YELLOW_TEXT);

        pTooltipComponents.add(unkempt_harold_lore);
        pTooltipComponents.add(unkempt_harold_lore_two);
        pTooltipComponents.add(unkempt_harold_stats_header_arrow);
        pTooltipComponents.add(unkempt_harold_stats_arrow_seven);
        pTooltipComponents.add(unkempt_harold_stats_arrow_eight);
        pTooltipComponents.add(unkempt_harold_stats_arrow_nine);
        pTooltipComponents.add(unkempt_harold_stats_arrow_ten);
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
