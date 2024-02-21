package net.Lucas.endgameenhanced.entity.projectile;

import net.Lucas.endgameenhanced.entity.ModEntities;
import net.Lucas.endgameenhanced.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class OnyxArrowEntity extends AbstractArrow {
    private static final ItemStack DEFAULT_ARROW_STACK = new ItemStack(ModItems.ONYX_ARROW.get());

    public OnyxArrowEntity(EntityType<? extends OnyxArrowEntity> p_37561_, Level p_37562_) {
        super(p_37561_, p_37562_, DEFAULT_ARROW_STACK);
    }

    public OnyxArrowEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(ModEntities.ONYX_ARROW.get(), pShooter, pLevel, pStack);
    }

    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(ModItems.ONYX_ARROW.get());
    }

    @Override
    public void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        LivingEntity entity = (LivingEntity) pResult.getEntity();
        Player player = (Player) this.getOwner();
        if (entity.getType().is(EntityTypeTags.UNDEAD)) {
            entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 300, 0, false, true, true));
        } else {
            entity.addEffect(new MobEffectInstance(MobEffects.HARM, 300, 0, false, true, true));

        }
        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 1, false, true, true));
        entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 300, 0, false, true, true));


    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
    }

    //    protected void onHit(HitResult pResult) {
//        super.onHit(pResult);
//        if (!this.level().isClientSide) {
//            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 5.0F, false, Level.ExplosionInteraction.MOB);
//            this.discard();
//        }
//
//    }


//    @Override
//    protected void onHitBlock(BlockHitResult pResult) {
//        super.onHitBlock(pResult);
//        Entity player = this.getOwner();
//        BlockPos blockHit = pResult.getBlockPos();
//        Level level = player.level();
//        if (level.getBlockState(blockHit.above(1)) == Blocks.AIR.defaultBlockState() && level.getBlockState(blockHit.above(2)) == Blocks.AIR.defaultBlockState()) {
//            player.setPosRaw(blockHit.above().getX()+0.5, blockHit.above().getY(), blockHit.above().getZ()+0.5);
//        }
//    }
}