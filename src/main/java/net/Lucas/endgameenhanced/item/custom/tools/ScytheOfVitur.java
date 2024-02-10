package net.Lucas.endgameenhanced.item.custom.tools;

import com.google.common.collect.Sets;
import com.mojang.datafixers.util.Pair;
import net.Lucas.endgameenhanced.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScytheOfVitur extends HoeItem {
    public ScytheOfVitur(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        final Set<ToolAction> SCYTHE_ACTIONS = of(ToolActions.SHEARS_DIG, ToolActions.SHEARS_HARVEST,
                ToolActions.SHEARS_CARVE, ToolActions.SHEARS_DISARM, ToolActions.HOE_TILL, ToolActions.HOE_TILL,
                ToolActions.SWORD_SWEEP);
        return SCYTHE_ACTIONS.contains(toolAction);
    }

    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(0, pAttacker, (p_41007_) -> {
            p_41007_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    private static Set<ToolAction> of(ToolAction... actions) {
        return Stream.of(actions).collect(Collectors.toCollection(Sets::newIdentityHashSet));
    }

    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        pStack.hurtAndBreak(0, pEntityLiving, (p_40992_) -> {
            p_40992_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return super.isCorrectToolForDrops(stack, state) || state.is(Blocks.COBWEB) || state.is(Blocks.REDSTONE_WIRE) || state.is(Blocks.TRIPWIRE);
    }

    @Override
    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        if (pState.is(Blocks.COBWEB) || pState.is(BlockTags.LEAVES)) {
            return 15.0F;
        }
        if (pState.is(BlockTags.WOOL) || pState.is(Blocks.VINE) || pState.is(Blocks.GLOW_LICHEN)) {
                return 5.0F;
            } else return super.getDestroySpeed(pStack, pState);
    }

    @Override
    public net.minecraft.world.InteractionResult interactLivingEntity(ItemStack stack, net.minecraft.world.entity.player.Player playerIn, LivingEntity entity, net.minecraft.world.InteractionHand hand) {
        if (entity instanceof net.minecraftforge.common.IForgeShearable target) {//shears
            if (entity.level().isClientSide) return net.minecraft.world.InteractionResult.SUCCESS;
            BlockPos pos = BlockPos.containing(entity.position());
            if (target.isShearable(stack, entity.level(), pos)) {
                java.util.List<ItemStack> drops = target.onSheared(playerIn, stack, entity.level(), pos,
                        net.minecraft.world.item.enchantment.EnchantmentHelper.getTagEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.BLOCK_FORTUNE, stack));
                java.util.Random rand = new java.util.Random();
                drops.forEach(d -> {
                    net.minecraft.world.entity.item.ItemEntity ent = entity.spawnAtLocation(d, 1.0F);
                    ent.setDeltaMovement(ent.getDeltaMovement().add((double)((rand.nextFloat() - rand.nextFloat()) * 0.1F), (double)(rand.nextFloat() * 0.05F), (double)((rand.nextFloat() - rand.nextFloat()) * 0.1F)));
                });
                stack.hurtAndBreak(0, playerIn, e -> e.broadcastBreakEvent(hand));
            }
            return net.minecraft.world.InteractionResult.SUCCESS;
        }
        return net.minecraft.world.InteractionResult.PASS;
    }

    public InteractionResult useOn(UseOnContext pContext) {
        ItemStack itemInHand = pContext.getItemInHand();
        Player player = pContext.getPlayer();
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        BlockEntity blockentity = blockstate.hasBlockEntity() ? level.getBlockEntity(blockpos) : null;
        int fortuneLevel = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.BLOCK_FORTUNE, itemInHand);
        ItemStack fortuneHoe = new ItemStack(ModItems.SCYTHE_OF_VITUR.get());
        fortuneHoe.enchant(Enchantments.BLOCK_FORTUNE, fortuneLevel);
        BlockState toolModifiedState = level.getBlockState(blockpos).getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.HOE_TILL, false);
        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = toolModifiedState == null ? null : Pair.of(ctx -> true, changeIntoState(toolModifiedState));
        //breaks the crop and drops loot based on fortune level, then resets it to its default state
        if (block instanceof CropBlock) {
            int cropAge = ((CropBlock) block).getAge(blockstate);
            int cropMaxAge = ((CropBlock) block).getMaxAge();
            boolean cropGrown = cropAge == cropMaxAge;
            if (cropGrown) {
                Block.dropResources(blockstate, level, blockpos, blockentity, null, fortuneHoe);
                level.destroyBlock(blockpos, false);
                level.setBlockAndUpdate(blockpos, block.defaultBlockState());
                return InteractionResult.sidedSuccess(level.isClientSide);
            }

        }
        if (block instanceof PotatoBlock) {
            int cropAge = ((PotatoBlock) block).getAge(blockstate);
            int cropMaxAge = ((PotatoBlock) block).getMaxAge();
            boolean cropGrown = cropAge == cropMaxAge;
            if (cropGrown) {
                Block.dropResources(blockstate, level, blockpos, blockentity, null, fortuneHoe);
                level.destroyBlock(blockpos, false);
                level.setBlockAndUpdate(blockpos, block.defaultBlockState());
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        if (block instanceof BeetrootBlock) {
            int cropAge = ((BeetrootBlock) block).getAge(blockstate);
            int cropMaxAge = ((BeetrootBlock) block).getMaxAge();
            boolean cropGrown = cropAge == cropMaxAge;
            if (cropGrown) {
                Block.dropResources(blockstate, level, blockpos, blockentity, null, fortuneHoe);
                level.destroyBlock(blockpos, false);
                level.setBlockAndUpdate(blockpos, block.defaultBlockState());
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        if (block instanceof CarrotBlock) {
            int cropAge = ((CarrotBlock) block).getAge(blockstate);
            int cropMaxAge = ((CarrotBlock) block).getMaxAge();
            boolean cropGrown = cropAge == cropMaxAge;
            if (cropGrown) {
                Block.dropResources(blockstate, level, blockpos, blockentity, null, fortuneHoe);
                level.destroyBlock(blockpos, false);
                level.setBlockAndUpdate(blockpos, block.defaultBlockState());
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        if (block instanceof NetherWartBlock) {
            int cropAge = blockstate.getValue(NetherWartBlock.AGE);
            int cropMaxAge = 3;
            boolean cropGrown = cropAge == cropMaxAge;
            if (cropGrown) {
                Block.dropResources(blockstate, level, blockpos, blockentity, null, fortuneHoe);
                level.destroyBlock(blockpos, false);
                level.setBlockAndUpdate(blockpos, block.defaultBlockState());
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        if (block instanceof GrowingPlantHeadBlock growingplantheadblock) {//shears
            if (!growingplantheadblock.isMaxAge(blockstate)) {
                ItemStack itemstack = pContext.getItemInHand();
                if (player instanceof ServerPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
                }

                level.playSound(player, blockpos, SoundEvents.GROWING_PLANT_CROP, SoundSource.BLOCKS, 1.0F, 1.0F);
                BlockState blockstate1 = growingplantheadblock.getMaxAgeState(blockstate);
                level.setBlockAndUpdate(blockpos, blockstate1);
                level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(pContext.getPlayer(), blockstate1));
                if (player != null) {
                    itemstack.hurtAndBreak(0, player, (p_186374_) -> {
                        p_186374_.broadcastBreakEvent(pContext.getHand());
                    });
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        if (pair == null) {//hoe
            return InteractionResult.PASS;
        } else {
            Predicate<UseOnContext> predicate = pair.getFirst();
            Consumer<UseOnContext> consumer = pair.getSecond();
            if (predicate.test(pContext)) {
                level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!level.isClientSide) {
                    consumer.accept(pContext);
                    if (player != null) {
                        pContext.getItemInHand().hurtAndBreak(0, player, (p_150845_) -> {
                            p_150845_.broadcastBreakEvent(pContext.getHand());
                        });
                    }
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        }

    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        final ChatFormatting GREEN_TEXT = ChatFormatting.DARK_GREEN;
        Component scythe_lore = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:scythe_lore.red_text"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component scythe_lore_two = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:scythe_lore.red_text_two"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        Component scythe_stats_header_arrow = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:scythe_lore.grey_text_arrow"))).withStyle(GREY_TEXT);
        Component scythe_stats_arrow_seven = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:scythe_lore.green_text_arrow_seven"))).withStyle(GREEN_TEXT);
        Component scythe_stats_arrow_eight = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:scythe_lore.green_text_arrow_eight"))).withStyle(GREEN_TEXT);
        Component scythe_stats_arrow_nine = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:scythe_lore.green_text_arrow_nine"))).withStyle(GREEN_TEXT);
        Component scythe_stats_arrow_ten = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation
                ("endgameenhanced:scythe_lore.green_text_arrow_ten"))).withStyle(RED_TEXT);

        pTooltipComponents.add(scythe_lore);
        pTooltipComponents.add(scythe_lore_two);
        pTooltipComponents.add(scythe_stats_header_arrow);
        pTooltipComponents.add(scythe_stats_arrow_seven);
        pTooltipComponents.add(scythe_stats_arrow_eight);
        pTooltipComponents.add(scythe_stats_arrow_nine);
        pTooltipComponents.add(scythe_stats_arrow_ten);
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
