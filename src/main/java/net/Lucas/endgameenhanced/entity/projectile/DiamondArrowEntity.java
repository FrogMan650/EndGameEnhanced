package net.Lucas.endgameenhanced.entity.projectile;

import net.Lucas.endgameenhanced.entity.ModEntities;
import net.Lucas.endgameenhanced.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class DiamondArrowEntity extends AbstractArrow {
    private static final ItemStack DEFAULT_ARROW_STACK = new ItemStack(ModItems.DIAMOND_ARROW.get());

    public DiamondArrowEntity(EntityType<? extends DiamondArrowEntity> p_37561_, Level p_37562_) {
        super(p_37561_, p_37562_, DEFAULT_ARROW_STACK);
    }

    public DiamondArrowEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(ModEntities.DIAMOND_ARROW.get(), pShooter, pLevel, pStack);
    }

    @Override
    public @NotNull ItemStack getPickupItem() {
        return new ItemStack(ModItems.DIAMOND_ARROW.get());
    }

    @Override
    public void tick() {
        super.tick();
        Vec3 vec34 = this.getDeltaMovement();
        if (!super.inGround && super.isCritArrow() && !this.isInWater()) {
            for (int i = 0; i < 4; ++i) {
                this.level().addParticle(ParticleTypes.PORTAL, this.getX() + vec34.x / 4.0D, this.getY() + vec34.y / 4.0D, this.getZ() + vec34.z / 4.0D, -vec34.x, -vec34.y + 0.2D, -vec34.z);
            }
        }
    }

    @Override
    protected void onHitBlock(@NotNull BlockHitResult pResult) {
        super.onHitBlock(pResult);
        Entity player = this.getOwner();
        BlockPos blockHit = pResult.getBlockPos();
        Level level = player != null ? player.level() : null;
        if (level != null) {
            if (level.getBlockState(blockHit.above()) == Blocks.AIR.defaultBlockState()) {
                player.teleportTo(blockHit.above().getX() + 0.5, blockHit.above().getY(), blockHit.above().getZ() + 0.5);
                player.setPose(Pose.FALL_FLYING);
            } else {
                if (pResult.getDirection() == Direction.NORTH && level.getBlockState(blockHit.north()) == Blocks.AIR.defaultBlockState()) {
                    player.teleportTo(blockHit.north().getX() + 0.5, blockHit.north().getY(), blockHit.north().getZ() + 0.5);
                    player.setPose(Pose.FALL_FLYING);
                }
                if (pResult.getDirection() == Direction.EAST && level.getBlockState(blockHit.east()) == Blocks.AIR.defaultBlockState()) {
                    player.teleportTo(blockHit.east().getX() + 0.5, blockHit.east().getY(), blockHit.east().getZ() + 0.5);
                    player.setPose(Pose.FALL_FLYING);
                }
                if (pResult.getDirection() == Direction.SOUTH && level.getBlockState(blockHit.south()) == Blocks.AIR.defaultBlockState()) {
                    player.teleportTo(blockHit.south().getX() + 0.5, blockHit.south().getY(), blockHit.south().getZ() + 0.5);
                    player.setPose(Pose.FALL_FLYING);
                }
                if (pResult.getDirection() == Direction.WEST && level.getBlockState(blockHit.west()) == Blocks.AIR.defaultBlockState()) {
                    player.teleportTo(blockHit.west().getX() + 0.5, blockHit.west().getY(), blockHit.west().getZ() + 0.5);
                    player.setPose(Pose.FALL_FLYING);
                }
                if (pResult.getDirection() == Direction.DOWN && level.getBlockState(blockHit.below()) == Blocks.AIR.defaultBlockState()) {
                    player.teleportTo(blockHit.below().getX() + 0.5, blockHit.below().getY(), blockHit.below().getZ() + 0.5);
                    player.setPose(Pose.FALL_FLYING);
                }
            }
            this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_TELEPORT, SoundSource.PLAYERS);
        }
    }
}