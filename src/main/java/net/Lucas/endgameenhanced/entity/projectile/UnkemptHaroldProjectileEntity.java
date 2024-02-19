package net.Lucas.endgameenhanced.entity.projectile;

import net.Lucas.endgameenhanced.entity.ModEntities;
import net.Lucas.endgameenhanced.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class UnkemptHaroldProjectileEntity extends AbstractArrow {
    private static final ItemStack DEFAULT_ARROW_STACK = new ItemStack(Items.TNT);

    public UnkemptHaroldProjectileEntity(EntityType<? extends UnkemptHaroldProjectileEntity> p_37561_, Level p_37562_) {
        super(p_37561_, p_37562_, DEFAULT_ARROW_STACK);
    }

    public UnkemptHaroldProjectileEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(ModEntities.UNKEMPT_HAROLD_PROJECTILE.get(), pShooter, pLevel, pStack);
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide) {
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 5.0F, false, Level.ExplosionInteraction.BLOCK);
            this.discard();
        }
    }

    @Override
    protected float getWaterInertia() {
        return 0.99F;
    }

    @Override
    public void setBaseDamage(double pBaseDamage) {
        super.setBaseDamage(0);
    }
}