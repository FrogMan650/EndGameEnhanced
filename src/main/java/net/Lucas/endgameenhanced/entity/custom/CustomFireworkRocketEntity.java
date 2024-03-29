package net.Lucas.endgameenhanced.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.OptionalInt;

public class CustomFireworkRocketEntity extends Projectile implements ItemSupplier {
   private static final EntityDataAccessor<ItemStack> DATA_ID_FIREWORKS_ITEM = SynchedEntityData.defineId(CustomFireworkRocketEntity.class, EntityDataSerializers.ITEM_STACK);
   private static final EntityDataAccessor<OptionalInt> DATA_ATTACHED_TO_TARGET = SynchedEntityData.defineId(CustomFireworkRocketEntity.class, EntityDataSerializers.OPTIONAL_UNSIGNED_INT);
   private static final EntityDataAccessor<Boolean> DATA_SHOT_AT_ANGLE = SynchedEntityData.defineId(CustomFireworkRocketEntity.class, EntityDataSerializers.BOOLEAN);
   private int life;
   private int lifetime;
   @Nullable
   private LivingEntity attachedToEntity;

   public CustomFireworkRocketEntity(Level pLevel, double pX, double pY, double pZ, ItemStack pStack) {
      super(EntityType.FIREWORK_ROCKET, pLevel);
      this.life = 0;
      this.setPos(pX, pY, pZ);
      int i = 1;
      if (!pStack.isEmpty() && pStack.hasTag()) {
         this.entityData.set(DATA_ID_FIREWORKS_ITEM, pStack.copy());
         i += pStack.getOrCreateTagElement("Fireworks").getByte("Flight");
      }

      this.setDeltaMovement(this.random.triangle(0.0D, 0.002297D), 0.05D, this.random.triangle(0.0D, 0.002297D));
      this.lifetime = 10 * i + this.random.nextInt(6) + this.random.nextInt(7);
   }

   public CustomFireworkRocketEntity(Level pLevel, ItemStack pStack, double pX, double pY, double pZ, boolean pShotAtAngle) {
      this(pLevel, pX, pY, pZ, pStack);
      this.entityData.set(DATA_SHOT_AT_ANGLE, pShotAtAngle);
   }

   public CustomFireworkRocketEntity(Level pLevel, ItemStack pStack, Entity pShooter, double pX, double pY, double pZ, boolean pShotAtAngle) {
      this(pLevel, pStack, pX, pY, pZ, pShotAtAngle);
      this.setOwner(pShooter);
   }

   @Override
   protected void defineSynchedData() {
      this.entityData.define(DATA_ID_FIREWORKS_ITEM, ItemStack.EMPTY);
      this.entityData.define(DATA_ATTACHED_TO_TARGET, OptionalInt.empty());
      this.entityData.define(DATA_SHOT_AT_ANGLE, false);
   }

   @Override
   public boolean shouldRenderAtSqrDistance(double pDistance) {
      return pDistance < 4096.0D && !this.isAttachedToEntity();
   }

   @Override
   public boolean shouldRender(double pX, double pY, double pZ) {
      return super.shouldRender(pX, pY, pZ) && !this.isAttachedToEntity();
   }

   @Override
   public void tick() {
      super.tick();
      if (this.isAttachedToEntity()) {
         if (this.attachedToEntity == null) {
            this.entityData.get(DATA_ATTACHED_TO_TARGET).ifPresent((p_309220_) -> {
               Entity entity = this.level().getEntity(p_309220_);
               if (entity instanceof LivingEntity) {
                  this.attachedToEntity = (LivingEntity)entity;
               }

            });
         }

         if (this.attachedToEntity != null) {
            Vec3 vec3;
            if (this.attachedToEntity.isFallFlying()) {
               Vec3 vec31 = this.attachedToEntity.getLookAngle();
               double d0 = 1.5D;
               double d1 = 0.1D;
               Vec3 vec32 = this.attachedToEntity.getDeltaMovement();
               this.attachedToEntity.setDeltaMovement(vec32.add(vec31.x * d1 + (vec31.x * d0 - vec32.x) * 0.5D, vec31.y * d1 + (vec31.y * d0 - vec32.y) * 0.5D, vec31.z * d1 + (vec31.z * d0 - vec32.z) * 0.5D));
               vec3 = this.attachedToEntity.getHandHoldingItemAngle(Items.FIREWORK_ROCKET);
            } else {
               vec3 = Vec3.ZERO;
            }

            this.setPos(this.attachedToEntity.getX() + vec3.x, this.attachedToEntity.getY() + vec3.y, this.attachedToEntity.getZ() + vec3.z);
            this.setDeltaMovement(this.attachedToEntity.getDeltaMovement());
         }
      } else {
         if (!this.isShotAtAngle()) {
            double d2 = this.horizontalCollision ? 1.0D : 1.15D;
            this.setDeltaMovement(this.getDeltaMovement().multiply(d2, 1.0D, d2).add(0.0D, 0.04D, 0.0D));
         }

         Vec3 vec33 = this.getDeltaMovement();
         this.move(MoverType.SELF, vec33);
         this.setDeltaMovement(vec33);
      }

      HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
      if (!this.noPhysics) {
         this.onHit(hitresult);
         this.hasImpulse = true;
      }

      this.updateRotation();
      if (this.life == 0 && !this.isSilent()) {
         this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.FIREWORK_ROCKET_LAUNCH, SoundSource.AMBIENT, 3.0F, 1.0F);
      }

      ++this.life;
      if (this.level().isClientSide && this.life % 2 < 2) {
         this.level().addParticle(ParticleTypes.FIREWORK, this.getX(), this.getY(), this.getZ(), this.random.nextGaussian() * 0.05D, -this.getDeltaMovement().y * 0.5D, this.random.nextGaussian() * 0.05D);
      }

      if (!this.level().isClientSide && this.life > this.lifetime) {
         this.explode();
      }

   }

   @Override
   protected void onHit(HitResult result) {
      if (result.getType() == HitResult.Type.MISS || !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, result)) {
         super.onHit(result);
      }
   }

   private void explode() {
      this.level().broadcastEntityEvent(this, (byte)17);
      this.gameEvent(GameEvent.EXPLODE, this.getOwner());
      this.dealExplosionDamage();
      this.discard();
   }

   @Override
   protected void onHitEntity(@NotNull EntityHitResult pResult) {
      super.onHitEntity(pResult);
      if (!this.level().isClientSide) {
         this.explode();
      }
   }

   @Override
   protected void onHitBlock(BlockHitResult pResult) {
      BlockPos blockpos = new BlockPos(pResult.getBlockPos());
      this.level().getBlockState(blockpos).entityInside(this.level(), blockpos, this);
      if (!this.level().isClientSide() && this.hasExplosion()) {
         this.explode();
      }

      super.onHitBlock(pResult);
   }

   private boolean hasExplosion() {
      ItemStack itemstack = this.entityData.get(DATA_ID_FIREWORKS_ITEM);
      CompoundTag compoundtag = itemstack.isEmpty() ? null : itemstack.getTagElement("Fireworks");
      ListTag listtag = compoundtag != null ? compoundtag.getList("Explosions", 10) : null;
      return listtag != null && !listtag.isEmpty();
   }

   private void dealExplosionDamage() {
      float damage = 0.0F;
      ItemStack itemstack = this.entityData.get(DATA_ID_FIREWORKS_ITEM);
      CompoundTag compoundtag = itemstack.isEmpty() ? null : itemstack.getTagElement("Fireworks");
      ListTag listtag = compoundtag != null ? compoundtag.getList("Explosions", 10) : null;
      if (listtag != null && !listtag.isEmpty()) {
         damage = (float)(listtag.size() * 3.5);
      }

      if (damage > 0.0F) {
         if (this.attachedToEntity != null) {
            this.attachedToEntity.hurt(this.damageSources().explosion(this, this.getOwner()), damage);
         }

         double d0 = 5.0D;
         Vec3 vec3 = this.position();

         for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(d0))) {
            if (livingentity != this.attachedToEntity && !(this.distanceToSqr(livingentity) > 25.0D)) {
               boolean flag = false;

               for(int i = 0; i < 2; ++i) {
                  Vec3 vec31 = new Vec3(livingentity.getX(), livingentity.getY(0.5D * (double)i), livingentity.getZ());
                  HitResult hitresult = this.level().clip(new ClipContext(vec3, vec31, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
                  if (hitresult.getType() == HitResult.Type.MISS) {
                     flag = true;
                     break;
                  }
               }

               if (flag) {
                  float f1 = damage * (float)Math.sqrt((d0 - (double)this.distanceTo(livingentity)) / d0);
                  livingentity.hurt(this.damageSources().explosion(this, this.getOwner()), f1);
               }
            }
         }
      }

   }

   private boolean isAttachedToEntity() {
      return this.entityData.get(DATA_ATTACHED_TO_TARGET).isPresent();
   }

   public boolean isShotAtAngle() {
      return this.entityData.get(DATA_SHOT_AT_ANGLE);
   }

   @Override
   public void handleEntityEvent(byte pId) {
      if (pId == 17 && this.level().isClientSide) {
         if (!this.hasExplosion()) {
            for(int i = 0; i < this.random.nextInt(3) + 2; ++i) {
               this.level().addParticle(ParticleTypes.POOF, this.getX(), this.getY(), this.getZ(), this.random.nextGaussian() * 0.05D, 0.005D, this.random.nextGaussian() * 0.05D);
            }
         } else {
            ItemStack itemstack = this.entityData.get(DATA_ID_FIREWORKS_ITEM);
            CompoundTag compoundtag = itemstack.isEmpty() ? null : itemstack.getTagElement("Fireworks");
            Vec3 vec3 = this.getDeltaMovement();
            this.level().createFireworks(this.getX(), this.getY(), this.getZ(), vec3.x, vec3.y, vec3.z, compoundtag);
         }
      }

      super.handleEntityEvent(pId);
   }

   @Override
   public void addAdditionalSaveData(@NotNull CompoundTag pCompound) {
      super.addAdditionalSaveData(pCompound);
      pCompound.putInt("Life", this.life);
      pCompound.putInt("LifeTime", this.lifetime);
      ItemStack itemstack = this.entityData.get(DATA_ID_FIREWORKS_ITEM);
      if (!itemstack.isEmpty()) {
         pCompound.put("FireworksItem", itemstack.save(new CompoundTag()));
      }

      pCompound.putBoolean("ShotAtAngle", this.entityData.get(DATA_SHOT_AT_ANGLE));
   }

   @Override
   public void readAdditionalSaveData(@NotNull CompoundTag pCompound) {
      super.readAdditionalSaveData(pCompound);
      this.life = pCompound.getInt("Life");
      this.lifetime = pCompound.getInt("LifeTime");
      ItemStack itemstack = ItemStack.of(pCompound.getCompound("FireworksItem"));
      if (!itemstack.isEmpty()) {
         this.entityData.set(DATA_ID_FIREWORKS_ITEM, itemstack);
      }

      if (pCompound.contains("ShotAtAngle")) {
         this.entityData.set(DATA_SHOT_AT_ANGLE, pCompound.getBoolean("ShotAtAngle"));
      }
   }

   @Override
   public @NotNull ItemStack getItem() {
      ItemStack itemstack = this.entityData.get(DATA_ID_FIREWORKS_ITEM);
      return itemstack.isEmpty() ? new ItemStack(Items.FIREWORK_ROCKET) : itemstack;
   }

   @Override
   public boolean isAttackable() {
      return false;
   }
}
