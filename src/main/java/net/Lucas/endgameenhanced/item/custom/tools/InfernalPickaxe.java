package net.Lucas.endgameenhanced.item.custom.tools;

import net.Lucas.endgameenhanced.block.ModBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InfernalPickaxe extends PickaxeItem {
    public InfernalPickaxe(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
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
    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        if (pState.is(Blocks.REINFORCED_DEEPSLATE)) {
            return 1.1F;
        } else {
            return super.getDestroySpeed(pStack, pState);
        }
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        Direction blockFace = pContext.getClickedFace();
        if (blockFace == Direction.NORTH && level.isClientSide) {
            BlockPos bottomCorner = new BlockPos(blockpos.getX()+1, blockpos.getY()-1, blockpos.getZ());
            BlockPos topCorner = new BlockPos(blockpos.getX()-1, blockpos.getY()+1, blockpos.getZ()+25);
            AABB areaToCheck = AABB.encapsulatingFullBlocks(bottomCorner, topCorner);
            containsAnyOres(areaToCheck, level, player);
        }
        if (blockFace == Direction.EAST && level.isClientSide) {
            BlockPos bottomCorner = new BlockPos(blockpos.getX(), blockpos.getY()-1, blockpos.getZ()+1);
            BlockPos topCorner = new BlockPos(blockpos.getX()-25, blockpos.getY()+1, blockpos.getZ()-1);
            AABB areaToCheck = AABB.encapsulatingFullBlocks(bottomCorner, topCorner);
            containsAnyOres(areaToCheck, level, player);
        }
        if (blockFace == Direction.SOUTH && level.isClientSide) {
            BlockPos bottomCorner = new BlockPos(blockpos.getX()-1, blockpos.getY()-1, blockpos.getZ());
            BlockPos topCorner = new BlockPos(blockpos.getX()+1, blockpos.getY()+1, blockpos.getZ()-25);
            AABB areaToCheck = AABB.encapsulatingFullBlocks(bottomCorner, topCorner);
            containsAnyOres(areaToCheck, level, player);
        }
        if (blockFace == Direction.WEST && level.isClientSide) {
            BlockPos bottomCorner = new BlockPos(blockpos.getX(), blockpos.getY()-1, blockpos.getZ()-1);
            BlockPos topCorner = new BlockPos(blockpos.getX()+25, blockpos.getY()+1, blockpos.getZ()+1);
            AABB areaToCheck = AABB.encapsulatingFullBlocks(bottomCorner, topCorner);
            containsAnyOres(areaToCheck, level, player);
        }
        if (blockFace == Direction.UP && level.isClientSide) {
            BlockPos bottomCorner = new BlockPos(blockpos.getX()+1, blockpos.getY(), blockpos.getZ()+1);
            BlockPos topCorner = new BlockPos(blockpos.getX()-1, blockpos.getY()-25, blockpos.getZ()-1);
            AABB areaToCheck = AABB.encapsulatingFullBlocks(bottomCorner, topCorner);
            containsAnyOres(areaToCheck, level, player);
        }
        if (blockFace == Direction.DOWN && level.isClientSide) {
            BlockPos bottomCorner = new BlockPos(blockpos.getX()-1, blockpos.getY(), blockpos.getZ()-1);
            BlockPos topCorner = new BlockPos(blockpos.getX()+1, blockpos.getY()+25, blockpos.getZ()+1);
            AABB areaToCheck = AABB.encapsulatingFullBlocks(bottomCorner, topCorner);
            containsAnyOres(areaToCheck, level, player);
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    public void containsAnyOres(AABB pBb, Level level, Player player) {
        boolean foundCoal = false;
        boolean foundCopper = false;
        boolean foundDiamond = false;
        boolean foundEmerald = false;
        boolean foundGold = false;
        boolean foundIron = false;
        boolean foundLapis = false;
        boolean foundRedstone = false;
        boolean foundDebris = false;
        boolean foundGemOre = false;
        int minX = Mth.floor(pBb.minX);
        int maxX = Mth.ceil(pBb.maxX);
        int minY = Mth.floor(pBb.minY);
        int maxY = Mth.ceil(pBb.maxY);
        int minZ = Mth.floor(pBb.minZ);
        int maxZ = Mth.ceil(pBb.maxZ);
        BlockPos.MutableBlockPos blockPosToCheck = new BlockPos.MutableBlockPos();

        player.sendSystemMessage(Component.translatable(Util.makeDescriptionId("chat", new ResourceLocation
                ("endgameenhanced:generic.found_ores"))));

        for(int i = minX; i < maxX; ++i) {
            for(int j = minY; j < maxY; ++j) {
                for(int k = minZ; k < maxZ; ++k) {
                    BlockState blockState = level.getBlockState(blockPosToCheck.set(i, j, k));
                    if (blockState.is(Tags.Blocks.ORES_COAL) && !foundCoal) {
                        foundCoal = true;
                        player.sendSystemMessage(Component.translatable(Util.makeDescriptionId("block", new ResourceLocation
                                ("coal_ore"))).withStyle(ChatFormatting.DARK_GRAY));
                    }
                    if (blockState.is(Tags.Blocks.ORES_COPPER) && !foundCopper) {
                        foundCopper = true;
                        player.sendSystemMessage(Component.translatable(Util.makeDescriptionId("block", new ResourceLocation
                                ("copper_ore"))).withStyle(ChatFormatting.RED));
                    }
                    if (blockState.is(Tags.Blocks.ORES_DIAMOND) && !foundDiamond) {
                        foundDiamond = true;
                        player.sendSystemMessage(Component.translatable(Util.makeDescriptionId("block", new ResourceLocation
                                ("diamond_ore"))).withStyle(ChatFormatting.AQUA));
                    }
                    if (blockState.is(Tags.Blocks.ORES_EMERALD) && !foundEmerald) {
                        foundEmerald = true;
                        player.sendSystemMessage(Component.translatable(Util.makeDescriptionId("block", new ResourceLocation
                                ("emerald_ore"))).withStyle(ChatFormatting.DARK_GREEN));
                    }
                    if (blockState.is(Tags.Blocks.ORES_GOLD) && !foundGold) {
                        foundGold = true;
                        player.sendSystemMessage(Component.translatable(Util.makeDescriptionId("block", new ResourceLocation
                                ("gold_ore"))).withStyle(ChatFormatting.GOLD));
                    }
                    if (blockState.is(Tags.Blocks.ORES_IRON) && !foundIron) {
                        foundIron = true;
                        player.sendSystemMessage(Component.translatable(Util.makeDescriptionId("block", new ResourceLocation
                                ("iron_ore"))).withStyle(ChatFormatting.GRAY));
                    }
                    if (blockState.is(Tags.Blocks.ORES_LAPIS) && !foundLapis) {
                        foundLapis = true;
                        player.sendSystemMessage(Component.translatable(Util.makeDescriptionId("block", new ResourceLocation
                                ("lapis_ore"))).withStyle(ChatFormatting.BLUE));
                    }
                    if (blockState.is(Tags.Blocks.ORES_REDSTONE) && !foundRedstone) {
                        foundRedstone = true;
                        player.sendSystemMessage(Component.translatable(Util.makeDescriptionId("block", new ResourceLocation
                                ("redstone_ore"))).withStyle(ChatFormatting.DARK_RED));
                    }
                    if (blockState.is(Tags.Blocks.ORES_NETHERITE_SCRAP) && !foundDebris) {
                        foundDebris = true;
                        player.sendSystemMessage(Component.translatable(Util.makeDescriptionId("block", new ResourceLocation
                                ("ancient_debris"))).withStyle(ChatFormatting.DARK_RED));
                    }
                    if (blockState.is(ModBlocks.GEM_ORE.get()) && !foundGemOre) {
                        foundGemOre = true;
                        player.sendSystemMessage(Component.translatable(Util.makeDescriptionId("block", new ResourceLocation
                                ("endgameenhanced:gem_ore"))).withStyle(ChatFormatting.LIGHT_PURPLE));
                    }
                }
            }
        }
        if (!foundCoal && !foundCopper && !foundDebris && !foundDiamond && !foundGold && !foundEmerald &&
                !foundGemOre && !foundIron && !foundLapis && !foundRedstone) {
            player.sendSystemMessage(Component.translatable(Util.makeDescriptionId("chat", new ResourceLocation
                    ("endgameenhanced:generic.found_nothing"))));
        }
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        final ChatFormatting RED_TEXT = ChatFormatting.DARK_RED;
        final ChatFormatting ITALIC_TEXT = ChatFormatting.ITALIC;
        final ChatFormatting GREY_TEXT = ChatFormatting.GRAY;
        final ChatFormatting GOLD_TEXT = ChatFormatting.GOLD;
        final ChatFormatting GREEN_TEXT = ChatFormatting.DARK_GREEN;
        final ChatFormatting REDD_TEXT = ChatFormatting.RED;
        Component infernal_pickaxe_lore = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:infernal_pickaxe.lore"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        pTooltipComponents.add(infernal_pickaxe_lore);

        Component infernal_pickaxe_space = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.tooltip.space"))).withStyle(RED_TEXT).withStyle(ITALIC_TEXT);
        pTooltipComponents.add(infernal_pickaxe_space);

        Component infernal_pickaxe_main_hand = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.weapon.main_hand"))).withStyle(GREY_TEXT);
        pTooltipComponents.add(infernal_pickaxe_main_hand);

        Component infernal_pickaxe_damage = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:infernal_pickaxe.damage"))).withStyle(GREEN_TEXT);
        pTooltipComponents.add(infernal_pickaxe_damage);

        Component infernal_pickaxe_attack_speed = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.weapon.attack_speed_1.2"))).withStyle(GREEN_TEXT);
        pTooltipComponents.add(infernal_pickaxe_attack_speed);

        pTooltipComponents.add(infernal_pickaxe_space);

        Component infernal_pickaxe_trait = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:infernal_pickaxe.trait"))).withStyle(REDD_TEXT);
        pTooltipComponents.add(infernal_pickaxe_trait);

        Component trait_full_description = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:infernal_pickaxe.trait.description"))).withStyle(GOLD_TEXT);

        Component hold_shift = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.tooltip.hold_shift"))).withStyle(GOLD_TEXT);

        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(trait_full_description);
        } else {
            pTooltipComponents.add(hold_shift);
        }
    }
}
