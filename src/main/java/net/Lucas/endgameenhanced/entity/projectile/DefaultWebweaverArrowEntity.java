package net.Lucas.endgameenhanced.entity.projectile;

import net.Lucas.endgameenhanced.entity.ModEntities;
import net.Lucas.endgameenhanced.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class DefaultWebweaverArrowEntity extends AbstractArrow {
    private static final ItemStack DEFAULT_ARROW_STACK = new ItemStack(ModItems.WEBWEAVER_ARROW.get());

    public DefaultWebweaverArrowEntity(EntityType<? extends DefaultWebweaverArrowEntity> p_37561_, Level p_37562_) {
        super(p_37561_, p_37562_, DEFAULT_ARROW_STACK);
    }

    public DefaultWebweaverArrowEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(ModEntities.WEBWEAVER_DEFAULT_ARROW_ENTITY.get(), pShooter, pLevel, pStack);
    }

    @Override
    public @NotNull ItemStack getPickupItem() {
        return new ItemStack(Items.AIR);
    }
}