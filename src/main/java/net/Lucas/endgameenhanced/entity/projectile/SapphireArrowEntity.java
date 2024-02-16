package net.Lucas.endgameenhanced.entity.projectile;

import net.Lucas.endgameenhanced.entity.ModEntities;
import net.Lucas.endgameenhanced.entity.custom.TideBreakerEntity;
import net.Lucas.endgameenhanced.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class SapphireArrowEntity extends AbstractArrow {
    private static final ItemStack DEFAULT_ARROW_STACK = new ItemStack(ModItems.SAPPHIRE_ARROW.get());

    public SapphireArrowEntity(EntityType<? extends SapphireArrowEntity> p_37561_, Level p_37562_) {
        super(p_37561_, p_37562_, DEFAULT_ARROW_STACK);
    }

    public SapphireArrowEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(ModEntities.SAPPHIRE_ARROW.get(), pShooter, pLevel, pStack);
    }

    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(ModItems.SAPPHIRE_ARROW.get());
    }

    @Override
    public void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        Entity player = this.getOwner();
        if (this.level() instanceof ServerLevel) {
            float randomFloat = RandomSource.create().nextFloat();
            BlockPos blockpos = entity.blockPosition();
            if ((this.level().canSeeSky(blockpos) && randomFloat <= 0.5) || (this.level().canSeeSky(blockpos) && this.level().isThundering())) {
                LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(this.level());
                if (lightningbolt != null) {
                    lightningbolt.moveTo(Vec3.atBottomCenterOf(blockpos));
                    lightningbolt.setCause(player instanceof ServerPlayer ? (ServerPlayer) player : null);
                    this.level().addFreshEntity(lightningbolt);
                }
            }
        }
    }


    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        Entity player = this.getOwner();
        BlockPos blockHit = pResult.getBlockPos();
        Level level = player.level();
        if (level.getBlockState(blockHit.above(1)) == Blocks.AIR.defaultBlockState() && level.getBlockState(blockHit.above(2)) == Blocks.AIR.defaultBlockState()) {
            player.setPosRaw(blockHit.above().getX()+0.5, blockHit.above().getY(), blockHit.above().getZ()+0.5);
        }
    }
}