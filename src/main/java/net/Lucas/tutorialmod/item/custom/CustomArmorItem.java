package net.Lucas.tutorialmod.item.custom;

import net.Lucas.tutorialmod.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CustomArmorItem extends ArmorItem implements Equipable {
    public CustomArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player) {
            if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.INEVITABLE_HELMET.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0, false, false, true));
                if (isDamaged(player.getItemBySlot(EquipmentSlot.HEAD))) {
                    setDamage(player.getItemBySlot(EquipmentSlot.HEAD), 0);
                }
            }
            if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.INEVITABLE_CHESTPLATE.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 220, 0, false, false, true));
                if (isDamaged(player.getItemBySlot(EquipmentSlot.CHEST))) {
                    setDamage(player.getItemBySlot(EquipmentSlot.CHEST), 0);
                }
            }
            if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.INEVITABLE_LEGGINGS.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, 220, 0, false, false, true));
                if (isDamaged(player.getItemBySlot(EquipmentSlot.LEGS))) {
                    setDamage(player.getItemBySlot(EquipmentSlot.LEGS), 0);
                }
            }
            if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.INEVITABLE_BOOTS.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 220, 0, false, false, true));
                if (player.isUnderWater()) {
                    player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 20, 0, false, false, true));
                }
                if (isDamaged(player.getItemBySlot(EquipmentSlot.FEET))) {
                    setDamage(player.getItemBySlot(EquipmentSlot.FEET), 0);
                }
            }
            if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.INEVITABLE_HELMET.get() &&
                    player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.INEVITABLE_CHESTPLATE.get() &&
                    player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.INEVITABLE_LEGGINGS.get() &&
                    player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.INEVITABLE_BOOTS.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 220, 0, false, false, true));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 220, 0, false, false, true));
            }
        }

    }
}
