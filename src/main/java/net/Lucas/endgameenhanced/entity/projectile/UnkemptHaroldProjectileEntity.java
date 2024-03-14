package net.Lucas.endgameenhanced.entity.projectile;

import net.Lucas.endgameenhanced.entity.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public class UnkemptHaroldProjectileEntity extends AbstractArrow {
    private static final ItemStack DEFAULT_ARROW_STACK = new ItemStack(Items.TNT);

    public UnkemptHaroldProjectileEntity(EntityType<? extends UnkemptHaroldProjectileEntity> p_37561_, Level p_37562_) {
        super(p_37561_, p_37562_, DEFAULT_ARROW_STACK);
    }

    public UnkemptHaroldProjectileEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(ModEntities.UNKEMPT_HAROLD_PROJECTILE.get(), pShooter, pLevel, pStack);
    }

    @Override
    protected void onHit(@NotNull HitResult pResult) {
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