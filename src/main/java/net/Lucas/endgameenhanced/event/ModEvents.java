package net.Lucas.endgameenhanced.event;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.block.ModBlocks;
import net.Lucas.endgameenhanced.item.ModItems;
import net.Lucas.endgameenhanced.blockFacing.PlayerBlockFacing;
import net.Lucas.endgameenhanced.blockFacing.PlayerBlockFacingProvider;
import net.Lucas.endgameenhanced.toolChange.PlayerToolChange;
import net.Lucas.endgameenhanced.toolChange.PlayerToolChangeProvider;
import net.Lucas.endgameenhanced.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = EndGameEnhanced.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void endGameEnhancedOnAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            if (!event.getObject().getCapability(PlayerToolChangeProvider.PLAYER_TOOL_CHANGE).isPresent()) {
                event.addCapability(new ResourceLocation(EndGameEnhanced.MOD_ID, "properties"), new PlayerToolChangeProvider());
            }
            if (!event.getObject().getCapability(PlayerBlockFacingProvider.PLAYER_BLOCK_FACING).isPresent()) {
                event.addCapability(new ResourceLocation(EndGameEnhanced.MOD_ID, "properties_two"), new PlayerBlockFacingProvider());
            }
        }
    }

    @SubscribeEvent
    public static void endGameEnhancedOnPlayerCloned(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerToolChangeProvider.PLAYER_TOOL_CHANGE).ifPresent(
                    oldStore -> event.getOriginal().getCapability(PlayerToolChangeProvider.PLAYER_TOOL_CHANGE).ifPresent(
                            newStore -> newStore.copyFrom(oldStore)));
            event.getOriginal().getCapability(PlayerBlockFacingProvider.PLAYER_BLOCK_FACING).ifPresent(
                    oldStore -> event.getOriginal().getCapability(PlayerBlockFacingProvider.PLAYER_BLOCK_FACING).ifPresent(
                            newStore -> newStore.copyFrom(oldStore)));
        }
    }
    @SubscribeEvent
    public static void endGameEnhancedOnRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerToolChange.class);
        event.register(PlayerBlockFacing.class);
    }

    @SubscribeEvent
    public static void endGameEnhancedTotemFixes(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player player) {
            ItemStack offHandItem = player.getItemInHand(InteractionHand.OFF_HAND);
            if (offHandItem.is(ModItems.CHARGING_TOTEM_OF_UNDYING.get()) && offHandItem.getDamageValue() == 0) {
                player.setHealth(0.01F);
                offHandItem.setDamageValue(6000);
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 1, false, true, true));
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0, false, true, true));
                player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1, false, true, true));
                event.setCanceled(true);
            }
            if (offHandItem.is(ModItems.RAPID_TOTEM_OF_UNDYING.get()) && offHandItem.getDamageValue() == 0) {
                player.setHealth(0.01F);
                offHandItem.setDamageValue(3000);
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 1, false, true, true));
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0, false, true, true));
                player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1, false, true, true));
                event.setCanceled(true);
            }
            if (offHandItem.is(ModItems.OVERCLOCKED_TOTEM_OF_UNDYING.get()) && offHandItem.getDamageValue() == 0) {
                player.setHealth(0.01F);
                offHandItem.setDamageValue(1200);
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 1, false, true, true));
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0, false, true, true));
                player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1, false, true, true));
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void endGameEnhancedOnLivingHurtDamageFixes(LivingHurtEvent event) {
        LivingEntity damagedMob = event.getEntity();
        float initialDamage = event.getAmount();
        if (event.getSource().getEntity() instanceof Player player) {
            double distanceToTarget = getDistanceToTarget(player, damagedMob);
            if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ModItems.WEBWEAVER_BOW.get())) {
                damagedMob.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 3, false, true, true));
                if (distanceToTarget > 16 && distanceToTarget < 50) {
                    double damageChange = (distanceToTarget-16)/2;
                    if (damageChange > 5) {
                        damageChange = 5;
                    }
                    event.setAmount((float) (initialDamage+damageChange));
                }
                if (distanceToTarget < 16) {
                    double damageChange = (16-distanceToTarget)/1.5;
                    if (damageChange > 5) {
                        damageChange = 5;
                    }
                    event.setAmount((float) (initialDamage-damageChange));
                }
                if (distanceToTarget >= 50) {
                    double damageChange = 10;
                    event.setAmount((float) (initialDamage+damageChange));
                }
            }
            if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ModItems.SCULK_SLINGER.get())) {
                damagedMob.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 300, 0, false, true, true));
                if (distanceToTarget > 16) {
                    double damageChange = (distanceToTarget-16)/2;
                    if (damageChange > 5) {
                        damageChange = 5;
                    }
                    event.setAmount((float) (initialDamage-damageChange));
                }
                if (distanceToTarget < 16) {
                    double damageChange = (16-distanceToTarget)/1.5;
                    if (damageChange > 5) {
                        damageChange = 5;
                    }
                    event.setAmount((float) (initialDamage+damageChange));
                }
            }
            if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ModItems.UNKEMPT_HAROLD.get())) {
                if (distanceToTarget > 5 && initialDamage > 5) {
                    event.setAmount(5);
                }
            }
            if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ModItems.SCYTHE_OF_VITUR.get())) {
                if (initialDamage == 1) {
                    if (damagedMob.isBaby()) {
                        event.setAmount(0);
                    } else {
                        event.setAmount(12);
                    }
                }
            }
            if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ModItems.NETHERRATH.get())) {
                damagedMob.setSecondsOnFire(15);
            }
            if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ModItems.VOIDWAKER.get())) {
                damagedMob.addEffect(new MobEffectInstance(MobEffects.WITHER, 300, 1, false, true, true));
            }
//            player.sendSystemMessage(Component.literal("Damage: "+event.getAmount()));
        }
    }

    private static double getDistanceToTarget(Player player, LivingEntity damagedMob) {
        //using the pythagorean theorem to find a line from the player to the mob that was hit
        //first finding the diagonal of a 2d square using the X and Z to find D
        //then using that, finding the diagonal of a 3d cube with Y and D to find A
        double diffX = player.getX() - damagedMob.getX();
        double diffY = player.getY() - damagedMob.getY();
        double diffZ = player.getZ() - damagedMob.getZ();
        double triangleOne = Math.sqrt((diffX*diffX)+(diffZ*diffZ));
        return Math.sqrt((triangleOne*triangleOne)+(diffY*diffY));
    }

    @SubscribeEvent
    public static void endGameEnhancedChangeTooltipComponents(ItemTooltipEvent event) {
        final List<Component> tooltipElements = event.getToolTip();
        if (event.getItemStack().is(ModItems.SCULK_BRINGER.get()) || event.getItemStack().is(ModItems.NETHERRATH.get())
                || event.getItemStack().is(ModItems.VOIDWAKER.get()) || event.getItemStack().is(ModItems.TIDE_BREAKER.get())
                || event.getItemStack().is(ModItems.LEVIATHANS_AXE.get()) || event.getItemStack().is(ModItems.SCYTHE_OF_VITUR.get())
                || event.getItemStack().is(ModItems.UNKEMPT_HAROLD.get()) || event.getItemStack().is(ModItems.INFERNAL_PICKAXE.get())) {
            if (!event.getFlags().isAdvanced()) {
                for (int i = 0; i < 4; i++) {
                    tooltipElements.remove(tooltipElements.size() - 1);
                }
            }
            if (event.getFlags().isAdvanced()) {
                String durabilityCheck = String.valueOf(tooltipElements.get(tooltipElements.size() - 3));
                boolean containsDurability = durabilityCheck.contains("item.durability");
                if (containsDurability) {
                    for (int i = 0; i < 4; i++) {
                        tooltipElements.remove(tooltipElements.size() - 4);
                    }
                } else {
                    for (int i = 0; i < 4; i++) {
                        tooltipElements.remove(tooltipElements.size() - 3);
                    }

                }

            }
        }
        if (event.getItemStack().is(ModItems.INEVITABLE_HELMET.get()) || event.getItemStack().is(ModItems.INEVITABLE_CHESTPLATE.get())
                || event.getItemStack().is(ModItems.INEVITABLE_LEGGINGS.get()) || event.getItemStack().is(ModItems.INEVITABLE_BOOTS.get())) {
            if (!event.getFlags().isAdvanced()) {
                for (int i = 0; i < 5; i++) {
                    tooltipElements.remove(tooltipElements.size() - 1);
                }
            }
            if (event.getFlags().isAdvanced()) {
                String durabilityCheck = String.valueOf(tooltipElements.get(tooltipElements.size() - 3));
                boolean containsDurability = durabilityCheck.contains("item.durability");
                if (containsDurability) {
                    for (int i = 0; i < 5; i++) {
                        tooltipElements.remove(tooltipElements.size() - 4);
                    }
                } else {
                    for (int i = 0; i < 5; i++) {
                        tooltipElements.remove(tooltipElements.size() - 3);
                    }

                }

            }
        }
    }

    @SubscribeEvent
    public static void endGameEnhancedChangeTooltipSize(RenderTooltipEvent.GatherComponents event) {
        event.setMaxWidth(200);
    }

    @SubscribeEvent
    public static void endGameEnhancedSetPlayerBlockFacing(PlayerInteractEvent.LeftClickBlock event) {
        //changes the player stored value for which face of the block they were last hitting
        Player player = event.getEntity();
        Direction blockDirection = event.getFace();
        assert blockDirection != null;
        String facing = blockDirection.getName();
        player.getCapability(PlayerBlockFacingProvider.PLAYER_BLOCK_FACING).ifPresent(blockFacing -> {
            if (facing.equals("up") || facing.equals("down")) {
                blockFacing.changeToZero();
            }
            if (facing.equals("north") || facing.equals("south")) {
                blockFacing.changeToOne();
            }
            if (facing.equals("east") || facing.equals("west")) {
                blockFacing.changeToTwo();
            }
        });
    }
    @SubscribeEvent
    public static void endGameEnhancedThreeByThreeBreaking(BlockEvent.BreakEvent event) {
        //determines if/how inevitable tools should act, based on the destruction setting
        BlockPos blockPos = event.getPos();
        BlockState blockState = event.getLevel().getBlockState(blockPos);
        Level level = (Level) event.getLevel();
        Player player = event.getPlayer();
        boolean silkTouch = EnchantmentHelper.hasSilkTouch(player.getMainHandItem());
        int blockPosX = blockPos.getX();
        int blockPosY = blockPos.getY();
        int blockPosZ = blockPos.getZ();
        player.getCapability(PlayerToolChangeProvider.PLAYER_TOOL_CHANGE).ifPresent(toolChange -> {
            int currentToolChange = toolChange.getToolChange();
            if (currentToolChange == 1) {
                if (player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == ModItems.UNKEMPT_HAROLD.get() && blockState.is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                    player.getCapability(PlayerBlockFacingProvider.PLAYER_BLOCK_FACING).ifPresent(blockFacing -> {
                        int facing = blockFacing.getBlockFacing();
                        ItemStack silkShovel = new ItemStack(ModItems.UNKEMPT_HAROLD.get());
                        silkShovel.enchant(Enchantments.SILK_TOUCH, 1);
                        if (facing == 1) {
                            int[] newblockX = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
                            int[] newblockY = {1, 1, 1, 0, -1, -1, -1, 0, 0};
                            for (int i = 0; i < 8; i ++) {
                                BlockPos blockToDestroy0 = new BlockPos(newblockX[i] + blockPosX, newblockY[i] + blockPosY, blockPosZ);
                                if (level.getBlockState(blockToDestroy0).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                                    if (silkTouch) {
                                        BlockState blockToDestroy0BlockState = level.getBlockState(blockToDestroy0);
                                        BlockEntity blockentity = blockToDestroy0BlockState.hasBlockEntity() ? level.getBlockEntity(blockToDestroy0) : null;
                                        Block.dropResources(blockToDestroy0BlockState, level, blockToDestroy0, blockentity, null, silkShovel);
                                        level.destroyBlock(blockToDestroy0, false);
                                    } else level.destroyBlock(blockToDestroy0, true);
                                }
                            }
                        }
                        if (facing == 2) {
                            int[] newblockZ = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
                            int[] newblockY = {1, 1, 1, 0, -1, -1, -1, 0, 0};
                            for (int i = 0; i < 8; i ++) {
                                BlockPos blockToDestroy0 = new BlockPos(blockPosX, newblockY[i] + blockPosY, newblockZ[i] + blockPosZ);
                                if (level.getBlockState(blockToDestroy0).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                                    if (silkTouch) {
                                        BlockState blockToDestroy0BlockState = level.getBlockState(blockToDestroy0);
                                        BlockEntity blockentity = blockToDestroy0BlockState.hasBlockEntity() ? level.getBlockEntity(blockToDestroy0) : null;
                                        Block.dropResources(blockToDestroy0BlockState, level, blockToDestroy0, blockentity, null, silkShovel);
                                        level.destroyBlock(blockToDestroy0, false);
                                    } else level.destroyBlock(blockToDestroy0, true);
                                }
                            }
                        }
                        if (facing == 0) {
                            int[] newblockX = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
                            int[] newblockZ = {1, 1, 1, 0, -1, -1, -1, 0, 0};
                            for (int i = 0; i < 8; i ++) {
                                BlockPos blockToDestroy0 = new BlockPos(newblockX[i] + blockPosX, blockPosY, newblockZ[i] + blockPosZ);
                                if (level.getBlockState(blockToDestroy0).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                                    if (silkTouch) {
                                        BlockState blockToDestroy0BlockState = level.getBlockState(blockToDestroy0);
                                        BlockEntity blockentity = blockToDestroy0BlockState.hasBlockEntity() ? level.getBlockEntity(blockToDestroy0) : null;
                                        Block.dropResources(blockToDestroy0BlockState, level, blockToDestroy0, blockentity, null, silkShovel);
                                        level.destroyBlock(blockToDestroy0, false);
                                    } else level.destroyBlock(blockToDestroy0, true);
                                }
                            }
                        }
                    });
                }
                if (player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == ModItems.INFERNAL_PICKAXE.get() && blockState.is(ModTags.Blocks.INFERNAL_PICKAXE_MINEABLES)) {
                    player.getCapability(PlayerBlockFacingProvider.PLAYER_BLOCK_FACING).ifPresent(blockFacing -> {
                        int facing = blockFacing.getBlockFacing();
                        ItemStack silkPick = new ItemStack(ModItems.INFERNAL_PICKAXE.get());
                        silkPick.enchant(Enchantments.SILK_TOUCH, 1);
                        if (facing == 1) {
                            int[] newblockX = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
                            int[] newblockY = {1, 1, 1, 0, -1, -1, -1, 0, 0};
                            for (int i = 0; i < 8; i ++) {
                                BlockPos blockToDestroy0 = new BlockPos(newblockX[i] + blockPosX, newblockY[i] + blockPosY, blockPosZ);
                                if (level.getBlockState(blockToDestroy0).is(ModTags.Blocks.INFERNAL_PICKAXE_MINEABLES)) {
                                    if (silkTouch) {
                                        BlockState blockToDestroy0BlockState = level.getBlockState(blockToDestroy0);
                                        BlockEntity blockentity = blockToDestroy0BlockState.hasBlockEntity() ? level.getBlockEntity(blockToDestroy0) : null;
                                        Block.dropResources(blockToDestroy0BlockState, level, blockToDestroy0, blockentity, null, silkPick);
                                        level.destroyBlock(blockToDestroy0, false);
                                    } else level.destroyBlock(blockToDestroy0, true);
                                }
                            }
                        }
                        if (facing == 2) {
                            int[] newblockZ = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
                            int[] newblockY = {1, 1, 1, 0, -1, -1, -1, 0, 0};
                            for (int i = 0; i < 8; i ++) {
                                BlockPos blockToDestroy0 = new BlockPos(blockPosX, newblockY[i] + blockPosY, newblockZ[i] + blockPosZ);
                                if (level.getBlockState(blockToDestroy0).is(ModTags.Blocks.INFERNAL_PICKAXE_MINEABLES)) {
                                    if (silkTouch) {
                                        BlockState blockToDestroy0BlockState = level.getBlockState(blockToDestroy0);
                                        BlockEntity blockentity = blockToDestroy0BlockState.hasBlockEntity() ? level.getBlockEntity(blockToDestroy0) : null;
                                        Block.dropResources(blockToDestroy0BlockState, level, blockToDestroy0, blockentity, null, silkPick);
                                        level.destroyBlock(blockToDestroy0, false);
                                    } else level.destroyBlock(blockToDestroy0, true);
                                }
                            }
                        }
                        if (facing == 0) {
                            int[] newblockX = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
                            int[] newblockZ = {1, 1, 1, 0, -1, -1, -1, 0, 0};
                            for (int i = 0; i < 8; i ++) {
                                BlockPos blockToDestroy0 = new BlockPos(newblockX[i] + blockPosX, blockPosY, newblockZ[i] + blockPosZ);
                                if (level.getBlockState(blockToDestroy0).is(ModTags.Blocks.INFERNAL_PICKAXE_MINEABLES)) {
                                    if (silkTouch) {
                                        BlockState blockToDestroy0BlockState = level.getBlockState(blockToDestroy0);
                                        BlockEntity blockentity = blockToDestroy0BlockState.hasBlockEntity() ? level.getBlockEntity(blockToDestroy0) : null;
                                        Block.dropResources(blockToDestroy0BlockState, level, blockToDestroy0, blockentity, null, silkPick);
                                        level.destroyBlock(blockToDestroy0, false);
                                    } else level.destroyBlock(blockToDestroy0, true);
                                }
                            }
                        }
                    });
                }
                if (player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == ModItems.SCYTHE_OF_VITUR.get() && blockState.is(ModTags.Blocks.SANGUINE_SCYTHE_HOEABLES)) {
                    player.getCapability(PlayerBlockFacingProvider.PLAYER_BLOCK_FACING).ifPresent(blockFacing -> {
                        int facing = blockFacing.getBlockFacing();
                        ItemStack silkHoe = new ItemStack(ModItems.SCYTHE_OF_VITUR.get());
                        silkHoe.enchant(Enchantments.SILK_TOUCH, 1);
                        if (facing == 1) {
                            int[] newblockX = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
                            int[] newblockY = {1, 1, 1, 0, -1, -1, -1, 0, 0};
                            for (int i = 0; i < 8; i ++) {
                                BlockPos blockToDestroy0 = new BlockPos(newblockX[i] + blockPosX, newblockY[i] + blockPosY, blockPosZ);
                                if (level.getBlockState(blockToDestroy0).is(ModTags.Blocks.SANGUINE_SCYTHE_HOEABLES)) {
                                    if (silkTouch) {
                                        BlockState blockToDestroy0BlockState = level.getBlockState(blockToDestroy0);
                                        BlockEntity blockentity = blockToDestroy0BlockState.hasBlockEntity() ? level.getBlockEntity(blockToDestroy0) : null;
                                        Block.dropResources(blockToDestroy0BlockState, level, blockToDestroy0, blockentity, null, silkHoe);
                                        level.destroyBlock(blockToDestroy0, false);
                                    } else level.destroyBlock(blockToDestroy0, true);
                                }
                            }
                        }
                        if (facing == 2) {
                            int[] newblockZ = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
                            int[] newblockY = {1, 1, 1, 0, -1, -1, -1, 0, 0};
                            for (int i = 0; i < 8; i ++) {
                                BlockPos blockToDestroy0 = new BlockPos(blockPosX, newblockY[i] + blockPosY, newblockZ[i] + blockPosZ);
                                if (level.getBlockState(blockToDestroy0).is(ModTags.Blocks.SANGUINE_SCYTHE_HOEABLES)) {
                                    if (silkTouch) {
                                        BlockState blockToDestroy0BlockState = level.getBlockState(blockToDestroy0);
                                        BlockEntity blockentity = blockToDestroy0BlockState.hasBlockEntity() ? level.getBlockEntity(blockToDestroy0) : null;
                                        Block.dropResources(blockToDestroy0BlockState, level, blockToDestroy0, blockentity, null, silkHoe);
                                        level.destroyBlock(blockToDestroy0, false);
                                    } else level.destroyBlock(blockToDestroy0, true);
                                }
                            }
                        }
                        if (facing == 0) {
                            int[] newblockX = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
                            int[] newblockZ = {1, 1, 1, 0, -1, -1, -1, 0, 0};
                            for (int i = 0; i < 8; i ++) {
                                BlockPos blockToDestroy0 = new BlockPos(newblockX[i] + blockPosX, blockPosY, newblockZ[i] + blockPosZ);
                                if (level.getBlockState(blockToDestroy0).is(ModTags.Blocks.SANGUINE_SCYTHE_HOEABLES)) {
                                    if (silkTouch) {
                                        BlockState blockToDestroy0BlockState = level.getBlockState(blockToDestroy0);
                                        BlockEntity blockentity = blockToDestroy0BlockState.hasBlockEntity() ? level.getBlockEntity(blockToDestroy0) : null;
                                        Block.dropResources(blockToDestroy0BlockState, level, blockToDestroy0, blockentity, null, silkHoe);
                                        level.destroyBlock(blockToDestroy0, false);
                                    } else level.destroyBlock(blockToDestroy0, true);
                                }
                            }
                        }
                    });
                }
                if (player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == ModItems.LEVIATHANS_AXE.get() && blockState.is(ModTags.Blocks.LEVIATHANS_AXE_AXEABLES)) {
                    player.getCapability(PlayerBlockFacingProvider.PLAYER_BLOCK_FACING).ifPresent(blockFacing -> {
                        int facing = blockFacing.getBlockFacing();
                        ItemStack silkAxe = new ItemStack(ModItems.LEVIATHANS_AXE.get());
                        silkAxe.enchant(Enchantments.SILK_TOUCH, 1);
                        if (facing == 1) {
                            int[] newblockX = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
                            int[] newblockY = {1, 1, 1, 0, -1, -1, -1, 0, 0};
                            for (int i = 0; i < 8; i ++) {
                                BlockPos blockToDestroy0 = new BlockPos(newblockX[i] + blockPosX, newblockY[i] + blockPosY, blockPosZ);
                                if (level.getBlockState(blockToDestroy0).is(ModTags.Blocks.LEVIATHANS_AXE_AXEABLES)) {
                                    if (silkTouch) {
                                        BlockState blockToDestroy0BlockState = level.getBlockState(blockToDestroy0);
                                        BlockEntity blockentity = blockToDestroy0BlockState.hasBlockEntity() ? level.getBlockEntity(blockToDestroy0) : null;
                                        Block.dropResources(blockToDestroy0BlockState, level, blockToDestroy0, blockentity, null, silkAxe);
                                        level.destroyBlock(blockToDestroy0, false);
                                    } else level.destroyBlock(blockToDestroy0, true);
                                }
                            }
                        }
                        if (facing == 2) {
                            int[] newblockZ = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
                            int[] newblockY = {1, 1, 1, 0, -1, -1, -1, 0, 0};
                            for (int i = 0; i < 8; i ++) {
                                BlockPos blockToDestroy0 = new BlockPos(blockPosX, newblockY[i] + blockPosY, newblockZ[i] + blockPosZ);
                                if (level.getBlockState(blockToDestroy0).is(ModTags.Blocks.LEVIATHANS_AXE_AXEABLES)) {
                                    if (silkTouch) {
                                        BlockState blockToDestroy0BlockState = level.getBlockState(blockToDestroy0);
                                        BlockEntity blockentity = blockToDestroy0BlockState.hasBlockEntity() ? level.getBlockEntity(blockToDestroy0) : null;
                                        Block.dropResources(blockToDestroy0BlockState, level, blockToDestroy0, blockentity, null, silkAxe);
                                        level.destroyBlock(blockToDestroy0, false);
                                    } else level.destroyBlock(blockToDestroy0, true);
                                }
                            }
                        }
                        if (facing == 0) {
                            int[] newblockX = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
                            int[] newblockZ = {1, 1, 1, 0, -1, -1, -1, 0, 0};
                            for (int i = 0; i < 8; i ++) {
                                BlockPos blockToDestroy0 = new BlockPos(newblockX[i] + blockPosX, blockPosY, newblockZ[i] + blockPosZ);
                                if (level.getBlockState(blockToDestroy0).is(ModTags.Blocks.LEVIATHANS_AXE_AXEABLES)) {
                                    if (silkTouch) {
                                        BlockState blockToDestroy0BlockState = level.getBlockState(blockToDestroy0);
                                        BlockEntity blockentity = blockToDestroy0BlockState.hasBlockEntity() ? level.getBlockEntity(blockToDestroy0) : null;
                                        Block.dropResources(blockToDestroy0BlockState, level, blockToDestroy0, blockentity, null, silkAxe);
                                        level.destroyBlock(blockToDestroy0, false);
                                    } else level.destroyBlock(blockToDestroy0, true);

                                }
                            }
                        }
                    });
                }
                if (player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == ModItems.LEVIATHANS_AXE.get() && blockState.is(BlockTags.LOGS)) {
                    boolean stillFindLogs = true;
                    List<BlockPos> logPos = new ArrayList<>();
                    logPos.add(blockPos);
                    while (stillFindLogs) {
                        BlockPos newLogToCheck = logPos.get(logPos.size() - 1).above();
                        logPos.add(newLogToCheck);
                        if (level.getBlockState(newLogToCheck).is(BlockTags.LOGS)) {
                            level.destroyBlock(newLogToCheck, true);
                        } else stillFindLogs = false;
                    }
                }
            }
        });

        if (player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == ModItems.SCULK_BRINGER.get()) {
            if (blockState.getBlock() == Blocks.SCULK_SENSOR || blockState.getBlock() == Blocks.SCULK_SHRIEKER) {
                BlockEntity blockentity = blockState.hasBlockEntity() ? level.getBlockEntity(blockPos) : null;
                ItemStack useHoe = new ItemStack(ModItems.SCYTHE_OF_VITUR.get());
                event.setCanceled(true);
                Block.dropResources(blockState, level, blockPos, blockentity, null, useHoe);
                level.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 1);
            }
        }
    }

    @SubscribeEvent
    public static void endGameEnhancedCropFixes(BlockEvent.CropGrowEvent.Post event) {
        Level level = (Level) event.getLevel();
        BlockState newBlockState = event.getState();
        BlockPos blockPos = event.getPos();
        if (newBlockState.getBlock() == Blocks.ATTACHED_MELON_STEM) {
            int randomInt = RandomSource.create().nextIntBetweenInclusive(0, 499);
            boolean spawnCustom = randomInt == 69;
            Direction stemFacing = newBlockState.getValue(FaceAttachedHorizontalDirectionalBlock.FACING);
            if (stemFacing == Direction.NORTH && spawnCustom) {
                BlockPos spawnBlock = blockPos.north();
                level.setBlock(spawnBlock, ModBlocks.GOLDEN_MELON.get().defaultBlockState(), 1);
            }
            if (stemFacing == Direction.EAST && spawnCustom) {
                BlockPos spawnBlock = blockPos.east();
                level.setBlock(spawnBlock, ModBlocks.GOLDEN_MELON.get().defaultBlockState(), 1);
            }
            if (stemFacing == Direction.SOUTH && spawnCustom) {
                BlockPos spawnBlock = blockPos.south();
                level.setBlock(spawnBlock, ModBlocks.GOLDEN_MELON.get().defaultBlockState(), 1);
            }
            if (stemFacing == Direction.WEST && spawnCustom) {
                BlockPos spawnBlock = blockPos.west();
                level.setBlock(spawnBlock, ModBlocks.GOLDEN_MELON.get().defaultBlockState(), 1);
            }
        }
        if (newBlockState.getBlock() == Blocks.ATTACHED_PUMPKIN_STEM) {
            int randomInt = RandomSource.create().nextIntBetweenInclusive(0, 499);
            boolean spawnCustom = randomInt == 69;
            Direction stemFacing = newBlockState.getValue(FaceAttachedHorizontalDirectionalBlock.FACING);
            if (stemFacing == Direction.NORTH && spawnCustom) {
                BlockPos spawnBlock = blockPos.north();
                level.setBlock(spawnBlock, ModBlocks.WHITE_PUMPKIN.get().defaultBlockState(), 1);
            }
            if (stemFacing == Direction.EAST && spawnCustom) {
                BlockPos spawnBlock = blockPos.east();
                level.setBlock(spawnBlock, ModBlocks.WHITE_PUMPKIN.get().defaultBlockState(), 1);
            }
            if (stemFacing == Direction.SOUTH && spawnCustom) {
                BlockPos spawnBlock = blockPos.south();
                level.setBlock(spawnBlock, ModBlocks.WHITE_PUMPKIN.get().defaultBlockState(), 1);
            }
            if (stemFacing == Direction.WEST && spawnCustom) {
                BlockPos spawnBlock = blockPos.west();
                level.setBlock(spawnBlock, ModBlocks.WHITE_PUMPKIN.get().defaultBlockState(), 1);
            }
        }
    }
}

