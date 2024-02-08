package net.Lucas.endgameenhanced.item.custom;

import net.Lucas.endgameenhanced.entity.client.ObsidianElytraLayer;
import net.Lucas.endgameenhanced.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
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
            if (player.getItemBySlot(EquipmentSlot.MAINHAND).getItem() == ModItems.NETHER_BLADE.get() && player.level().dimension().toString().contains("the_nether")) {
                if (player.isOnFire()) {
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 1, false, true, true));
                    if (!player.hasEffect(MobEffects.REGENERATION)) {
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 1, false, true, true));
                    }
                    if (player.getRemainingFireTicks() == 20) {
                        player.setSecondsOnFire(10);
                    }
                }
            }
            if (player.getItemBySlot(EquipmentSlot.MAINHAND).getItem() == ModItems.END_BLADE.get() && player.level().dimension().toString().contains("the_end")) {
                if (player.hasEffect(MobEffects.WITHER)) {
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 2, false, true, true));
                    if (player.getEffect(MobEffects.WITHER).getDuration() == 1) {
                        player.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 0, false, true, true));
                    }
                    if (!player.hasEffect(MobEffects.REGENERATION)) {
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 0, false, true, true));
                    }
                }
            }
            if (player.getItemBySlot(EquipmentSlot.MAINHAND).getItem() == ModItems.SCULK_BLADE.get() && player.level().getBiome(player.getOnPos()).toString().contains("deep_dark")) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 1, false, true, true));
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 20, 0, false, true, true));
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, 20, 1, false, true, true));
            }
        }

    }
}
