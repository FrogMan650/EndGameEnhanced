package net.Lucas.endgameenhanced.event;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.entity.client.ObsidianElytraLayer;
import net.Lucas.endgameenhanced.entity.client.ObsidianElytraModel;
import net.Lucas.endgameenhanced.item.ModItems;
import net.Lucas.endgameenhanced.blockFacing.PlayerBlockFacing;
import net.Lucas.endgameenhanced.blockFacing.PlayerBlockFacingProvider;
import net.Lucas.endgameenhanced.toolChange.PlayerToolChange;
import net.Lucas.endgameenhanced.toolChange.PlayerToolChangeProvider;
import net.Lucas.endgameenhanced.util.ModTags;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
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
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
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
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerToolChangeProvider.PLAYER_TOOL_CHANGE).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerToolChangeProvider.PLAYER_TOOL_CHANGE).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
            event.getOriginal().getCapability(PlayerBlockFacingProvider.PLAYER_BLOCK_FACING).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerBlockFacingProvider.PLAYER_BLOCK_FACING).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerToolChange.class);
        event.register(PlayerBlockFacing.class);
    }

    @SubscribeEvent
    public static void onLivingHurtDamageFixes(LivingHurtEvent event) {
        LivingEntity damagedMob = event.getEntity();
        float initialDamage = event.getAmount();
        if (event.getSource().getEntity() instanceof Player player) {
            if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ModItems.SCYTHE_OF_VITUR.get())) {
                if (initialDamage == 1) {
                    if (damagedMob.isBaby()) {
                        event.setAmount(0);
                    } else event.setAmount(12);
                }
            }
        }
    }

    //attempt at rewriting the damage when having certain enchantments
//            if (player.isHolding(ModItems.TIDE_BREAKER.get()) && damagedMob.isInWaterOrRain()) {
//                int impalingLevel = player.getMainHandItem().getEnchantmentLevel(Enchantments.IMPALING);
//                int riptideLevel = player.getMainHandItem().getEnchantmentLevel(Enchantments.RIPTIDE);
//                event.setAmount(16 + (impalingLevel * 2f) + (riptideLevel * 1.5f));
//            }
//            if (player.isHolding(ModItems.SCULK_BLADE.get()) || player.isHolding(ModItems.END_BLADE.get()) || player.isHolding(ModItems.NETHER_BLADE.get())) {
//                int sharpnessLevel = player.getMainHandItem().getEnchantmentLevel(Enchantments.SHARPNESS);
//                int smiteLevel = player.getMainHandItem().getEnchantmentLevel(Enchantments.SMITE);
//                int arthropodLevel = player.getMainHandItem().getEnchantmentLevel(Enchantments.BANE_OF_ARTHROPODS);
//                if (damagedMob.getMobType() == MobType.UNDEAD) {
//                    if (initialDamage == ((12 + 6 + (smiteLevel * 2.5)) * 1.5f)) {
//                        event.setAmount((12 + 6 + (smiteLevel * 4)) * 1.5f);
//                    } else if (initialDamage == ((12 + 3 + (smiteLevel * 2.5)) * 1.5f)) {
//                        event.setAmount((12 + 3 + (smiteLevel * 4)) * 1.5f);
//                    } else if (initialDamage == ((12 + (smiteLevel * 2.5)) * 1.5f)) {
//                        event.setAmount((12 + (smiteLevel * 4)) * 1.5f);
//                    } else if (initialDamage == (12 + 6 + (smiteLevel * 2.5))) {
//                        event.setAmount(12 + 6 + (smiteLevel * 4));
//                    } else if (initialDamage == (12 + 3 + (smiteLevel * 2.5))) {
//                        event.setAmount(12 + 3 + (smiteLevel * 4));
//                    } else if (initialDamage == (12 + (smiteLevel * 2.5))) {
//                        event.setAmount(12 + (smiteLevel * 4));
//                    }
//                } else if (damagedMob.getMobType() == MobType.ARTHROPOD) {
//                    if (initialDamage == ((12 + 6 + (arthropodLevel * 2.5)) * 1.5f)) {
//                        event.setAmount((12 + 6 + (arthropodLevel * 4)) * 1.5f);
//                    } else if (initialDamage == ((12 + 3 + (arthropodLevel * 2.5)) * 1.5f)) {
//                        event.setAmount((12 + 3 + (arthropodLevel * 4)) * 1.5f);
//                    } else if (initialDamage == ((12 + (arthropodLevel * 2.5)) * 1.5f)) {
//                        event.setAmount((12 + (arthropodLevel * 4)) * 1.5f);
//                    } else if (initialDamage == (12 + 6 + (arthropodLevel * 2.5))) {
//                        event.setAmount(12 + 6 + (arthropodLevel * 4));
//                    } else if (initialDamage == (12 + 3 + (arthropodLevel * 2.5))) {
//                        event.setAmount(12 + 3 + (arthropodLevel * 4));
//                    } else if (initialDamage == (12 + (arthropodLevel * 2.5))) {
//                        event.setAmount(12 + (arthropodLevel * 4));
//                    }
//                } else {
//                    if (initialDamage == ((12 + 6 + (sharpnessLevel * 0.5 + 0.5)) * 1.5f)) {
//                        event.setAmount((12 + 6 + (sharpnessLevel * 2)) * 1.5f);
//                    } else if (initialDamage == ((12 + 3 + (sharpnessLevel * 0.5 + 0.5)) * 1.5f)) {
//                        event.setAmount((12 + 3 + (sharpnessLevel * 2)) * 1.5f);
//                    } else if (initialDamage == ((12 + (sharpnessLevel * 0.5 + 0.5)) * 1.5f)) {
//                        event.setAmount((12 + (sharpnessLevel * 2)) * 1.5f);
//                    } else if (initialDamage == (12 + 6 + (sharpnessLevel * 0.5 + 0.5))) {
//                        event.setAmount(12 + 6 + (sharpnessLevel * 2));
//                    } else if (initialDamage == (12 + 3 + (sharpnessLevel * 0.5 + 0.5))) {
//                        event.setAmount(12 + 3 + (sharpnessLevel * 2));
//                    } else if (initialDamage == (12 + (sharpnessLevel * 0.5 + 0.5))) {
//                        event.setAmount(12 + (sharpnessLevel * 2));
//                    }
//                }
//            }
//        }
//    }

    @SubscribeEvent
    public static void changeTooltipComponents(ItemTooltipEvent event) {
        final List<Component> tooltipElements = event.getToolTip();
        if (event.getItemStack().is(ModItems.SCULK_BLADE.get()) || event.getItemStack().is(ModItems.NETHER_BLADE.get())
                || event.getItemStack().is(ModItems.END_BLADE.get()) || event.getItemStack().is(ModItems.TIDE_BREAKER.get())
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
    public static void changeTooltipSize(RenderTooltipEvent.GatherComponents event) {
        event.setMaxWidth(200);
    }

    @SubscribeEvent
    public static void setPlayerBlockFacing(PlayerInteractEvent.LeftClickBlock event) {
        //changes the player stored value for which face of the block they're facing
        BlockPos blockPos = event.getPos();
        BlockState blockState = event.getLevel().getBlockState(blockPos);
        Player player = event.getEntity();
        Direction blockDirection = event.getFace();
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
    public static void threeByThreeBreaking(BlockEvent.BreakEvent event) {
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
    }




    @SubscribeEvent
    public static void onRenderPlayer(RenderPlayerEvent.Pre event) {
        Player player = event.getEntity();
        PlayerRenderer renderer = event.getRenderer();
        PlayerModel pModel = event.getRenderer().getModel();
        EntityModelSet modelSet = new EntityModelSet();
        renderer.addLayer(new ObsidianElytraLayer<>(renderer, modelSet));
    }


//    @SubscribeEvent
//    public static void threeByThreeTill(BlockEvent.BlockToolModificationEvent event) {
//        //attempt to make scythe till 3x3
//        BlockPos blockPos = event.getPos();
//        BlockState blockState = event.getLevel().getBlockState(blockPos);
//        Block block = blockState.getBlock();
//        Level level = (Level) event.getLevel();
//        Player player = event.getPlayer();
//        int blockPosX = blockPos.getX();
//        int blockPosY = blockPos.getY();
//        int blockPosZ = blockPos.getZ();
//        player.getCapability(PlayerToolChangeProvider.PLAYER_TOOL_CHANGE).ifPresent(toolChange -> {
//            int currentToolChange = toolChange.getToolChange();
//            int[] newblockX = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
//            int[] newblockZ = {1, 1, 1, 0, -1, -1, -1, 0, 0};
//            BlockPos blockToTill0 = new BlockPos(newblockX[0] + blockPosX, blockPosY, newblockZ[0] + blockPosZ);
//            BlockPos blockToTill1 = new BlockPos(newblockX[1] + blockPosX, blockPosY, newblockZ[1] + blockPosZ);
//            BlockPos blockToTill2 = new BlockPos(newblockX[2] + blockPosX, blockPosY, newblockZ[2] + blockPosZ);
//            BlockPos blockToTill3 = new BlockPos(newblockX[3] + blockPosX, blockPosY, newblockZ[3] + blockPosZ);
//            BlockPos blockToTill4 = new BlockPos(newblockX[4] + blockPosX, blockPosY, newblockZ[4] + blockPosZ);
//            BlockPos blockToTill5 = new BlockPos(newblockX[5] + blockPosX, blockPosY, newblockZ[5] + blockPosZ);
//            BlockPos blockToTill6 = new BlockPos(newblockX[6] + blockPosX, blockPosY, newblockZ[6] + blockPosZ);
//            BlockPos blockToTill7 = new BlockPos(newblockX[7] + blockPosX, blockPosY, newblockZ[7] + blockPosZ);
//            if (currentToolChange == 1) {
//                if (player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == ModItems.SCYTHE_OF_VITUR.get()) {
//                }
//            }
//        });
//    }
}

