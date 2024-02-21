package net.Lucas.endgameenhanced.entity.projectile;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import net.Lucas.endgameenhanced.entity.ModEntities;
import net.Lucas.endgameenhanced.item.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RubyArrowEntity extends AbstractArrow {
    private BlockState lastState;
    private double baseDamage;
    private final IntOpenHashSet ignoredEntities = new IntOpenHashSet();
    private int life;
    private int knockback;
    private IntOpenHashSet piercingIgnoreEntityIds;
    private List<Entity> piercedAndKilledEntities;
    private final SoundEvent soundEvent = this.getDefaultHitGroundSoundEvent();
    private static final ItemStack DEFAULT_ARROW_STACK = new ItemStack(ModItems.RUBY_ARROW.get());

    public RubyArrowEntity(EntityType<? extends RubyArrowEntity> p_37561_, Level p_37562_) {
        super(p_37561_, p_37562_, DEFAULT_ARROW_STACK);
    }

    public RubyArrowEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(ModEntities.RUBY_ARROW.get(), pShooter, pLevel, pStack);
    }

    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(ModItems.RUBY_ARROW.get());
    }

    @Override
    public void setBaseDamage(double baseDamage) {
        this.baseDamage = baseDamage;
    }

    protected void onHitEntity(EntityHitResult pResult) {
        Entity entity = pResult.getEntity();
        float f = (float)this.getDeltaMovement().length();
        float randomint = RandomSource.create().nextIntBetweenInclusive(3, 4);
        float randomFloat = RandomSource.create().nextFloat();
        float randomCombined = randomint+randomFloat;
        int i = Mth.ceil(Mth.clamp((double)randomCombined * this.baseDamage, 0.0D, (double)Integer.MAX_VALUE));
        if (this.getPierceLevel() > 0) {
            if (this.piercingIgnoreEntityIds == null) {
                this.piercingIgnoreEntityIds = new IntOpenHashSet(5);
            }

            if (this.piercedAndKilledEntities == null) {
                this.piercedAndKilledEntities = Lists.newArrayListWithCapacity(5);
            }

            if (this.piercingIgnoreEntityIds.size() >= this.getPierceLevel() + 1) {
                this.discard();
                return;
            }

            this.piercingIgnoreEntityIds.add(entity.getId());
        }

        if (this.isCritArrow()) {
            long j = (long)this.random.nextInt(i / 2 + 2);
            i = (int)Math.min(j + (long)i, 2147483647L);
        }

        Entity entity1 = this.getOwner();
        DamageSource damagesource;
        if (entity1 == null) {
            damagesource = this.damageSources().arrow(this, this);
        } else {
            damagesource = this.damageSources().arrow(this, entity1);
            if (entity1 instanceof LivingEntity) {
                ((LivingEntity)entity1).setLastHurtMob(entity);
            }
        }

        boolean flag = entity.getType() == EntityType.ENDERMAN;
        int k = entity.getRemainingFireTicks();
        boolean flag1 = entity.getType().is(EntityTypeTags.DEFLECTS_ARROWS);
        if (this.isOnFire() && !flag && !flag1) {
            entity.setSecondsOnFire(5);
        }

        if (entity.hurt(damagesource, (float)i)) {
            if (flag) {
                return;
            }

            if (entity instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity)entity;
                if (!this.level().isClientSide && this.getPierceLevel() <= 0) {
                    livingentity.setArrowCount(livingentity.getArrowCount() + 1);
                }

                if (this.knockback > 0) {
                    double d0 = Math.max(0.0D, 1.0D - livingentity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
                    Vec3 vec3 = this.getDeltaMovement().multiply(1.0D, 0.0D, 1.0D).normalize().scale((double)this.knockback * 0.6D * d0);
                    if (vec3.lengthSqr() > 0.0D) {
                        livingentity.push(vec3.x, 0.1D, vec3.z);
                    }
                }

                if (!this.level().isClientSide && entity1 instanceof LivingEntity) {
                    EnchantmentHelper.doPostHurtEffects(livingentity, entity1);
                    EnchantmentHelper.doPostDamageEffects((LivingEntity)entity1, livingentity);
                }

                this.doPostHurtEffects(livingentity);
                if (entity1 != null && livingentity != entity1 && livingentity instanceof Player && entity1 instanceof ServerPlayer && !this.isSilent()) {
                    ((ServerPlayer)entity1).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.ARROW_HIT_PLAYER, 0.0F));
                }

                if (!entity.isAlive() && this.piercedAndKilledEntities != null) {
                    this.piercedAndKilledEntities.add(livingentity);
                }

                if (!this.level().isClientSide && entity1 instanceof ServerPlayer) {
                    ServerPlayer serverplayer = (ServerPlayer)entity1;
                    if (this.piercedAndKilledEntities != null && this.shotFromCrossbow()) {
                        CriteriaTriggers.KILLED_BY_CROSSBOW.trigger(serverplayer, this.piercedAndKilledEntities);
                    } else if (!entity.isAlive() && this.shotFromCrossbow()) {
                        CriteriaTriggers.KILLED_BY_CROSSBOW.trigger(serverplayer, Arrays.asList(entity));
                    }
                }
            }

            this.playSound(this.soundEvent, 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
            if (this.getPierceLevel() <= 0) {
                this.discard();
            }
        } else if (flag1) {
            this.deflect();
        } else {
            entity.setRemainingFireTicks(k);
            this.setDeltaMovement(this.getDeltaMovement().scale(-0.1D));
            this.setYRot(this.getYRot() + 180.0F);
            this.yRotO += 180.0F;
            if (!this.level().isClientSide && this.getDeltaMovement().lengthSqr() < 1.0E-7D) {
                if (this.pickup == AbstractArrow.Pickup.ALLOWED) {
                    this.spawnAtLocation(this.getPickupItem(), 0.1F);
                }

                this.discard();
            }
        }

    }

    public void deflect() {
        float f = this.random.nextFloat() * 360.0F;
        this.setDeltaMovement(this.getDeltaMovement().yRot(f * ((float)Math.PI / 180F)).scale(0.5D));
        this.setYRot(this.getYRot() + f);
        this.yRotO += f;
    }

    public void tick() {
        boolean flag = this.isNoPhysics();
        Vec3 vec3 = this.getDeltaMovement();
        if (this.xRotO == 0.0F && this.yRotO == 0.0F) {
            double d0 = vec3.horizontalDistance();
            this.setYRot((float)(Mth.atan2(vec3.x, vec3.z) * (double)(180F / (float)Math.PI)));
            this.setXRot((float)(Mth.atan2(vec3.y, d0) * (double)(180F / (float)Math.PI)));
            this.yRotO = this.getYRot();
            this.xRotO = this.getXRot();
        }

        BlockPos blockpos = this.blockPosition();
        BlockState blockstate = this.level().getBlockState(blockpos);
        if (!blockstate.isAir() && !flag) {
            VoxelShape voxelshape = blockstate.getCollisionShape(this.level(), blockpos);
            if (!voxelshape.isEmpty()) {
                Vec3 vec31 = this.position();

                for(AABB aabb : voxelshape.toAabbs()) {
                    if (aabb.move(blockpos).contains(vec31)) {
                        this.inGround = true;
                        break;
                    }
                }
            }
        }

        if (this.shakeTime > 0) {
            --this.shakeTime;
        }

        if (this.isInWaterOrRain() || blockstate.is(Blocks.POWDER_SNOW) || this.isInFluidType((fluidType, height) -> this.canFluidExtinguish(fluidType))) {
            this.clearFire();
        }

        if (this.inGround && !flag) {
            if (this.lastState != blockstate && this.shouldFall()) {
                this.startFalling();
            } else if (!this.level().isClientSide) {
                this.tickDespawn();
            }

            ++this.inGroundTime;
        } else {
            this.inGroundTime = 0;
            Vec3 vec32 = this.position();
            Vec3 vec33 = vec32.add(vec3);
            HitResult hitresult = this.level().clip(new ClipContext(vec32, vec33, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
            if (hitresult.getType() != HitResult.Type.MISS) {
                vec33 = hitresult.getLocation();
            }

            while(!this.isRemoved()) {
                EntityHitResult entityhitresult = this.findHitEntity(vec32, vec33);
                if (entityhitresult != null) {
                    hitresult = entityhitresult;
                }

                if (hitresult != null && hitresult.getType() == HitResult.Type.ENTITY) {
                    Entity entity = ((EntityHitResult)hitresult).getEntity();
                    Entity entity1 = this.getOwner();
                    if (entity instanceof Player && entity1 instanceof Player && !((Player)entity1).canHarmPlayer((Player)entity)) {
                        hitresult = null;
                        entityhitresult = null;
                    }
                }

                if (hitresult != null && hitresult.getType() != HitResult.Type.MISS && !flag) {
                    switch (net.minecraftforge.event.ForgeEventFactory.onProjectileImpactResult(this, hitresult)) {
                        case SKIP_ENTITY:
                            if (hitresult.getType() != HitResult.Type.ENTITY) { // If there is no entity, we just return default behaviour
                                this.onHit(hitresult);
                                this.hasImpulse = true;
                                break;
                            }
                            ignoredEntities.add(entityhitresult.getEntity().getId());
                            entityhitresult = null; // Don't process any further
                            break;
                        case STOP_AT_CURRENT_NO_DAMAGE:
                            this.discard();
                            entityhitresult = null; // Don't process any further
                            break;
                        case STOP_AT_CURRENT:
                            this.setPierceLevel((byte) 0);
                        case DEFAULT:
                            this.onHit(hitresult);
                            this.hasImpulse = true;
                            break;
                    }
                }

                if (entityhitresult == null || this.getPierceLevel() <= 0) {
                    break;
                }

                hitresult = null;
            }

            if (this.isRemoved())
                return;
            //ege start
            Player player = (Player) this.getOwner();
            Level level = this.level();
            List<Entity> entityList = level.getEntities(player, this.getBoundingBox().inflate(5, 5, 5));
            Entity entityToAttack = null;
            if (!this.isInWater()) {
                for (Entity entity : entityList) {
                    if (entity instanceof Mob) {
                        if (entityToAttack == null) {
                            entityToAttack = entity;
                        } else {
                            double distance = getDistanceToTarget(this, entity);
                            if (distance < getDistanceToTarget(this, entityToAttack)) {
                                entityToAttack = entity;
                            }
                        }
                    }
                }
                if (entityToAttack != null) {
                    double entityToAttackX = entityToAttack.getX();
                    double entityToAttackY = entityToAttack.getY();
                    double entityToAttackZ = entityToAttack.getZ();
                    double arrowX = this.getX();
                    double arrowY = this.getY();
                    double arrowZ = this.getZ();
                    double arrowEntityDiffX = entityToAttackX-arrowX;
                    double arrowEntityDiffY = entityToAttackY-arrowY;
                    double arrowEntityDiffZ = entityToAttackZ-arrowZ;
                    double d5 = arrowEntityDiffX*0.4;
                    double d6 = arrowEntityDiffY*0.4;
                    double d1 = arrowEntityDiffZ*0.4;
                    this.setDeltaMovement(d5, d6, d1);
                    if (this.isCritArrow()) {
                        for(int i = 0; i < 4; ++i) {
                            this.level().addParticle(ParticleTypes.CRIT, this.getX() + d5 * (double)i / 4.0D, this.getY() + d6 * (double)i / 4.0D, this.getZ() + d1 * (double)i / 4.0D, -d5, -d6 + 0.2D, -d1);
                        }
                    }
                    double d7 = this.getX() + d5;
                    double d2 = this.getY() + d6;
                    double d3 = this.getZ() + d1;
                    vec3 = this.getDeltaMovement();
                    double d4 = vec3.horizontalDistance();
                    if (flag) {
                        this.setYRot((float)(Mth.atan2(-d5, -d1) * (double)(180F / (float)Math.PI)));
                    } else {
                        this.setYRot((float)(Mth.atan2(d5, d1) * (double)(180F / (float)Math.PI)));
                    }

                    this.setXRot((float)(Mth.atan2(d6, d4) * (double)(180F / (float)Math.PI)));
                    this.setXRot(lerpRotation(this.xRotO, this.getXRot()));
                    this.setYRot(lerpRotation(this.yRotO, this.getYRot()));
                    float f = 0.99F;
                    float f1 = 0.05F;
                    if (this.isInWater()) {
                        for(int j = 0; j < 4; ++j) {
                            float f2 = 0.25F;
                            this.level().addParticle(ParticleTypes.BUBBLE, d7 - d5 * 0.25D, d2 - d6 * 0.25D, d3 - d1 * 0.25D, d5, d6, d1);
                        }

                        f = this.getWaterInertia();
                    }

                    this.setDeltaMovement(vec3.scale((double)f));
                    if (!this.isNoGravity() && !flag) {
                        Vec3 vec34 = this.getDeltaMovement();
                        this.setDeltaMovement(vec34.x, vec34.y - (double)0.05F, vec34.z);
                    }

                    this.setPos(d7, d2, d3);
                    this.checkInsideBlocks();
                } else {//ege end
                    vec3 = this.getDeltaMovement();
                    double d5 = vec3.x;
                    double d6 = vec3.y;
                    double d1 = vec3.z;
                    if (this.isCritArrow()) {
                        for(int i = 0; i < 4; ++i) {
                            this.level().addParticle(ParticleTypes.CRIT, this.getX() + d5 * (double)i / 4.0D, this.getY() + d6 * (double)i / 4.0D, this.getZ() + d1 * (double)i / 4.0D, -d5, -d6 + 0.2D, -d1);
                        }
                    }

                    double d7 = this.getX() + d5;
                    double d2 = this.getY() + d6;
                    double d3 = this.getZ() + d1;
                    double d4 = vec3.horizontalDistance();
                    if (flag) {
                        this.setYRot((float)(Mth.atan2(-d5, -d1) * (double)(180F / (float)Math.PI)));
                    } else {
                        this.setYRot((float)(Mth.atan2(d5, d1) * (double)(180F / (float)Math.PI)));
                    }

                    this.setXRot((float)(Mth.atan2(d6, d4) * (double)(180F / (float)Math.PI)));
                    this.setXRot(lerpRotation(this.xRotO, this.getXRot()));
                    this.setYRot(lerpRotation(this.yRotO, this.getYRot()));
                    float f = 0.99F;
                    float f1 = 0.05F;
                    if (this.isInWater()) {
                        for(int j = 0; j < 4; ++j) {
                            float f2 = 0.25F;
                            this.level().addParticle(ParticleTypes.BUBBLE, d7 - d5 * 0.25D, d2 - d6 * 0.25D, d3 - d1 * 0.25D, d5, d6, d1);
                        }

                        f = this.getWaterInertia();
                    }

                    this.setDeltaMovement(vec3.scale((double)f));
                    if (!this.isNoGravity() && !flag) {
                        Vec3 vec34 = this.getDeltaMovement();
                        this.setDeltaMovement(vec34.x, vec34.y - (double)0.05F, vec34.z);
                    }

                    this.setPos(d7, d2, d3);
                    this.checkInsideBlocks();
                }
            }
        }
    }

//    @Override
//    public void tick() {
//        super.tick();
//        Player player = (Player) this.getOwner();
//        Level level = this.level();
//        List<Entity> entityList = level.getEntities(player, this.getBoundingBox().inflate(10, 10, 10));
//        Entity entityToAttack = null;
//        if (!this.inGround) {
//            player.sendSystemMessage(Component.literal(""+this.getDeltaMovement()));
//            player.sendSystemMessage(Component.literal("X: "+this.getX()+" Y: "+this.getY()+" Z: "+this.getZ()));
//            for (Entity entity : entityList) {
//                if (entity instanceof Mob) {
//                    if (entityToAttack == null) {
//                        entityToAttack = entity;
//                    } else {
//                        double distance = getDistanceToTarget(this, entity);
//                        if (distance < getDistanceToTarget(this, entityToAttack)) {
//                            entityToAttack = entity;
//                        }
//                    }
//                }
//            }
//            if (entityToAttack != null) {
//                player.sendSystemMessage(Component.literal("" + entityToAttack.getType()));
//            }
//        }
//    }

    private static double getDistanceToTarget(AbstractArrow abstractArrow, Entity entity) {
        //using the pythagorean theorem to find a line from the arrow to the mob from the list
        //first finding the diagonal of a 2d square using the X and Z to find D
        //then using that, finding the diagonal of a 3d cube with Y and D to find A
        double diffX = abstractArrow.getX() - entity.getX();
        double diffY = abstractArrow.getY() - entity.getY();
        double diffZ = abstractArrow.getZ() - entity.getZ();
        double triangleOne = Math.sqrt((diffX*diffX)+(diffZ*diffZ));
        return Math.sqrt((triangleOne*triangleOne)+(diffY*diffY));
    }

    private boolean shouldFall() {
        return this.inGround && this.level().noCollision((new AABB(this.position(), this.position())).inflate(0.06D));
    }

    private void startFalling() {
        this.inGround = false;
        Vec3 vec3 = this.getDeltaMovement();
        this.setDeltaMovement(vec3.multiply((double)(this.random.nextFloat() * 0.2F), (double)(this.random.nextFloat() * 0.2F), (double)(this.random.nextFloat() * 0.2F)));
        this.life = 0;
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