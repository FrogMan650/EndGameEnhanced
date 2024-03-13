package net.Lucas.endgameenhanced.entity.projectile;

import net.Lucas.endgameenhanced.entity.ModEntities;
import net.Lucas.endgameenhanced.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class OnyxArrowEntity extends AbstractArrow {
    private static final ItemStack DEFAULT_ARROW_STACK = new ItemStack(ModItems.ONYX_ARROW.get());

    public OnyxArrowEntity(EntityType<? extends OnyxArrowEntity> p_37561_, Level p_37562_) {
        super(p_37561_, p_37562_, DEFAULT_ARROW_STACK);
    }

    public OnyxArrowEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(ModEntities.ONYX_ARROW.get(), pShooter, pLevel, pStack);
    }

    @Override
    public @NotNull ItemStack getPickupItem() {
        return new ItemStack(ModItems.ONYX_ARROW.get());
    }

    @Override
    public void onHitEntity(@NotNull EntityHitResult pResult) {
        super.onHitEntity(pResult);
        LivingEntity entity = (LivingEntity) pResult.getEntity();
        Player player = (Player) this.getOwner();
        if (player != null) {
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 1, false, true, true));
            entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 300, 1, false, true, true));
        }
    }

    @Override
    protected void onHit(@NotNull HitResult pResult) {
        super.onHit(pResult);
    }

    @Override
    public void tick() {
        super.tick();
        Vec3 vec34 = this.getDeltaMovement();
        if (!super.inGround && super.isCritArrow() && !this.isInWater()) {
            this.level().addParticle(ParticleTypes.DAMAGE_INDICATOR, this.getX() + vec34.x / 4.0D, this.getY() + vec34.y / 4.0D, this.getZ() + vec34.z / 4.0D, -vec34.x, -vec34.y + 0.2D, -vec34.z);
        }
    }
}