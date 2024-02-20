package net.Lucas.endgameenhanced.entity.projectile;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import net.Lucas.endgameenhanced.entity.ModEntities;
import net.Lucas.endgameenhanced.item.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class DiamondArrowEntity extends AbstractArrow {
    private static final ItemStack DEFAULT_ARROW_STACK = new ItemStack(ModItems.DIAMOND_ARROW.get());

    public DiamondArrowEntity(EntityType<? extends DiamondArrowEntity> p_37561_, Level p_37562_) {
        super(p_37561_, p_37562_, DEFAULT_ARROW_STACK);
    }

    public DiamondArrowEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(ModEntities.DIAMOND_ARROW.get(), pShooter, pLevel, pStack);
    }

    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(ModItems.DIAMOND_ARROW.get());
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        Entity player = this.getOwner();
        BlockPos blockHit = pResult.getBlockPos();
        Level level = player.level();
        if (level.getBlockState(blockHit.above()) == Blocks.AIR.defaultBlockState()) {
            player.setPosRaw(blockHit.above().getX()+0.5, blockHit.above().getY(), blockHit.above().getZ()+0.5);
            player.setPose(Pose.FALL_FLYING);
        } else {
            if (pResult.getDirection() == Direction.NORTH && level.getBlockState(blockHit.north()) == Blocks.AIR.defaultBlockState()) {
                player.setPosRaw(blockHit.north().getX()+0.5, blockHit.north().getY(), blockHit.north().getZ()+0.5);
                player.setPose(Pose.FALL_FLYING);
            }
            if (pResult.getDirection() == Direction.EAST && level.getBlockState(blockHit.east()) == Blocks.AIR.defaultBlockState()) {
                player.setPosRaw(blockHit.east().getX()+0.5, blockHit.east().getY(), blockHit.east().getZ()+0.5);
                player.setPose(Pose.FALL_FLYING);
            }
            if (pResult.getDirection() == Direction.SOUTH && level.getBlockState(blockHit.south()) == Blocks.AIR.defaultBlockState()) {
                player.setPosRaw(blockHit.south().getX()+0.5, blockHit.south().getY(), blockHit.south().getZ()+0.5);
                player.setPose(Pose.FALL_FLYING);
            }
            if (pResult.getDirection() == Direction.WEST && level.getBlockState(blockHit.west()) == Blocks.AIR.defaultBlockState()) {
                player.setPosRaw(blockHit.west().getX()+0.5, blockHit.west().getY(), blockHit.west().getZ()+0.5);
                player.setPose(Pose.FALL_FLYING);
            }
        }
    }
}