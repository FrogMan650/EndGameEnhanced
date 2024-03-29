package net.Lucas.endgameenhanced.item.custom.tools;

import com.google.common.collect.Sets;
import com.mojang.datafixers.util.Pair;
import net.Lucas.endgameenhanced.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.gui.screens.Screen;
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
    public boolean canPerformAction(@NotNull ItemStack stack, net.minecraftforge.common.@NotNull ToolAction toolAction) {
        final Set<ToolAction> SCYTHE_ACTIONS = of(ToolActions.SHEARS_DIG, ToolActions.SHEARS_HARVEST,
                ToolActions.SHEARS_CARVE, ToolActions.SHEARS_DISARM, ToolActions.HOE_DIG, ToolActions.HOE_TILL,
                ToolActions.SWORD_SWEEP);
        return SCYTHE_ACTIONS.contains(toolAction);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker) {
        pStack.hurtAndBreak(0, pAttacker, (p_41007_) -> p_41007_.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        return true;
    }

    private static Set<ToolAction> of(ToolAction... actions) {
        return Stream.of(actions).collect(Collectors.toCollection(Sets::newIdentityHashSet));
    }

    @Override
    public boolean mineBlock(ItemStack pStack, @NotNull Level pLevel, @NotNull BlockState pState, @NotNull BlockPos pPos, @NotNull LivingEntity pEntityLiving) {
        pStack.hurtAndBreak(0, pEntityLiving, (p_40992_) -> p_40992_.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        return true;
    }

    @Override
    public boolean isCorrectToolForDrops(@NotNull ItemStack stack, @NotNull BlockState state) {
        return super.isCorrectToolForDrops(stack, state) || state.is(Blocks.COBWEB) || state.is(Blocks.REDSTONE_WIRE) || state.is(Blocks.TRIPWIRE);
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack pStack, BlockState pState) {
        if (pState.is(Blocks.COBWEB) || pState.is(BlockTags.LEAVES)) {
            return 15.0F;
        }
        if (pState.is(BlockTags.WOOL) || pState.is(Blocks.VINE) || pState.is(Blocks.GLOW_LICHEN)) {
                return 5.0F;
            } else return super.getDestroySpeed(pStack, pState);
    }

    @Override
    public @NotNull InteractionResult interactLivingEntity(@NotNull ItemStack stack, net.minecraft.world.entity.player.@NotNull Player playerIn, @NotNull LivingEntity entity, net.minecraft.world.@NotNull InteractionHand hand) {
        if (entity instanceof net.minecraftforge.common.IForgeShearable target) {//shears
            if (entity.level().isClientSide) return net.minecraft.world.InteractionResult.SUCCESS;
            BlockPos pos = BlockPos.containing(entity.position());
            if (target.isShearable(stack, entity.level(), pos)) {
                java.util.List<ItemStack> drops = target.onSheared(playerIn, stack, entity.level(), pos,
                        net.minecraft.world.item.enchantment.EnchantmentHelper.getTagEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.BLOCK_FORTUNE, stack));
                java.util.Random rand = new java.util.Random();
                drops.forEach(d -> {
                    net.minecraft.world.entity.item.ItemEntity ent = entity.spawnAtLocation(d, 1.0F);
                    if (ent != null) {
                        ent.setDeltaMovement(ent.getDeltaMovement().add((rand.nextFloat() - rand.nextFloat()) * 0.1F, rand.nextFloat() * 0.05F, (rand.nextFloat() - rand.nextFloat()) * 0.1F));
                    }
                });
                stack.hurtAndBreak(0, playerIn, e -> e.broadcastBreakEvent(hand));
            }
            return net.minecraft.world.InteractionResult.SUCCESS;
        }
        return net.minecraft.world.InteractionResult.PASS;
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
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
        int cropAge = 0;
        int cropMaxAge = 10;
        if (block instanceof CropBlock cropBlock) {
            cropAge = cropBlock.getAge(blockstate);
            cropMaxAge = cropBlock.getMaxAge();
        }
        if (block instanceof PotatoBlock potatoBlock) {
            cropAge = potatoBlock.getAge(blockstate);
            cropMaxAge = potatoBlock.getMaxAge();
        }
        if (block instanceof BeetrootBlock beetrootBlock) {
            cropAge = beetrootBlock.getAge(blockstate);
            cropMaxAge = beetrootBlock.getMaxAge();
        }
        if (block instanceof CarrotBlock carrotBlock) {
            cropAge = carrotBlock.getAge(blockstate);
            cropMaxAge = carrotBlock.getMaxAge();
        }
        if (block instanceof NetherWartBlock) {
            cropAge = blockstate.getValue(NetherWartBlock.AGE);
            cropMaxAge = 3;
        }
        if (cropAge == cropMaxAge) {
            Block.dropResources(blockstate, level, blockpos, blockentity, null, fortuneHoe);
            level.destroyBlock(blockpos, false);
            level.setBlockAndUpdate(blockpos, block.defaultBlockState());
            return InteractionResult.sidedSuccess(level.isClientSide);
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
                    itemstack.hurtAndBreak(0, player, (p_186374_) -> p_186374_.broadcastBreakEvent(pContext.getHand()));
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
                        pContext.getItemInHand().hurtAndBreak(0, player, (p_150845_) -> p_150845_.broadcastBreakEvent(pContext.getHand()));
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
        final ChatFormatting GOLD_TEXT = ChatFormatting.GOLD;
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        final ChatFormatting GREEN_TEXT = ChatFormatting.DARK_GREEN;
        Component scythe_lore = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:scythe.lore"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        pTooltipComponents.add(scythe_lore);

        Component scythe_space = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.tooltip.space"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        pTooltipComponents.add(scythe_space);

        Component scythe_main_hand = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.weapon.main_hand"))).withStyle(GREY_TEXT);
        pTooltipComponents.add(scythe_main_hand);

        Component scythe_damage = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:scythe.damage"))).withStyle(GREEN_TEXT);
        pTooltipComponents.add(scythe_damage);

        Component scythe_attack_speed = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.weapon.attack_speed_1"))).withStyle(GREEN_TEXT);
        pTooltipComponents.add(scythe_attack_speed);

        pTooltipComponents.add(scythe_space);

        Component scythe_trait = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:scythe.trait"))).withStyle(RED_TEXT);
        pTooltipComponents.add(scythe_trait);

        Component trait_full_description = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:scythe.trait.description"))).withStyle(GOLD_TEXT);

        Component hold_shift = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.tooltip.hold_shift"))).withStyle(GOLD_TEXT);

        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(trait_full_description);
        } else {
            pTooltipComponents.add(hold_shift);
        }
    }
}
