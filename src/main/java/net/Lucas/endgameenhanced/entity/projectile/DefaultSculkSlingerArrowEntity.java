package net.Lucas.endgameenhanced.entity.projectile;

import net.Lucas.endgameenhanced.entity.ModEntities;
import net.Lucas.endgameenhanced.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class DefaultSculkSlingerArrowEntity extends AbstractArrow {
    private static final ItemStack DEFAULT_ARROW_STACK = new ItemStack(ModItems.SCULK_SLINGER_ARROW.get());

    public DefaultSculkSlingerArrowEntity(EntityType<? extends DefaultSculkSlingerArrowEntity> p_37561_, Level p_37562_) {
        super(p_37561_, p_37562_);
    }

    public DefaultSculkSlingerArrowEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(ModEntities.SCULK_SLINGER_DEFAULT_ARROW_ENTITY.get(), pShooter, pLevel);
    }

    @Override
    public @NotNull ItemStack getPickupItem() {
        return new ItemStack(Items.AIR);
    }

    @Override
    public void tick() {
        super.tick();
        Vec3 vec34 = this.getDeltaMovement();
        if (!super.inGround && super.isCritArrow() && !this.isInWater()) {
            this.level().addParticle(ParticleTypes.SONIC_BOOM, this.getX() + vec34.x / 4.0D, this.getY() + vec34.y / 4.0D, this.getZ() + vec34.z / 4.0D, -vec34.x, -vec34.y + 0.2D, -vec34.z);
        }
    }
}