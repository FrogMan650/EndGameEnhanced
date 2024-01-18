package net.Lucas.tutorialmod.event;

import com.mojang.datafixers.util.Either;
import net.Lucas.tutorialmod.TutorialMod;
import net.Lucas.tutorialmod.entity.custom.LeviathansAxeEntity;
import net.Lucas.tutorialmod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.monster.ElderGuardian;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.swing.text.Element;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID)
public class ModEvents {

//    @SubscribeEvent
//    public static void onLivingHurtDamageFixes(LivingHurtEvent event) {
//        LivingEntity damagedMob = event.getEntity();
//        float initialDamage = event.getAmount();
//        if (event.getSource().getEntity() instanceof Player player) {
//            if (player.isHolding(ModItems.TIDE_BREAKER.get()) && damagedMob.isInWaterOrRain()) {
//                int impalingLevel = player.getMainHandItem().getEnchantmentLevel(Enchantments.IMPALING);
//                int riptideLevel = player.getMainHandItem().getEnchantmentLevel(Enchantments.RIPTIDE);
//                event.setAmount(16 + (impalingLevel * 2f) + (riptideLevel * 1.5f));
//            }
//            if (player.isHolding(ModItems.SCULK_BLADE.get()) || player.isHolding(ModItems.END_BLADE.get()) || player.isHolding(ModItems.NETHER_BLADE.get())) {
//                int sharpnessLevel = player.getMainHandItem().getEnchantmentLevel(Enchantments.SHARPNESS);
//                int smiteLevel = player.getMainHandItem().getEnchantmentLevel(Enchantments.SMITE);
//                int arthropodLevel = player.getMainHandItem().getEnchantmentLevel(Enchantments.BANE_OF_ARTHROPODS);
//                if (damagedMob.getMobType() == MobType.UNDEAD) {
//                    if (initialDamage == ((12 + 6 + (smiteLevel * 2.5)) * 1.5f)) {
//                        event.setAmount((12 + 6 + (smiteLevel * 4)) * 1.5f);
//                    } else if (initialDamage == ((12 + 3 + (smiteLevel * 2.5)) * 1.5f)) {
//                        event.setAmount((12 + 3 + (smiteLevel * 4)) * 1.5f);
//                    } else if (initialDamage == ((12 + (smiteLevel * 2.5)) * 1.5f)) {
//                        event.setAmount((12 + (smiteLevel * 4)) * 1.5f);
//                    } else if (initialDamage == (12 + 6 + (smiteLevel * 2.5))) {
//                        event.setAmount(12 + 6 + (smiteLevel * 4));
//                    } else if (initialDamage == (12 + 3 + (smiteLevel * 2.5))) {
//                        event.setAmount(12 + 3 + (smiteLevel * 4));
//                    } else if (initialDamage == (12 + (smiteLevel * 2.5))) {
//                        event.setAmount(12 + (smiteLevel * 4));
//                    }
//                } else if (damagedMob.getMobType() == MobType.ARTHROPOD) {
//                    if (initialDamage == ((12 + 6 + (arthropodLevel * 2.5)) * 1.5f)) {
//                        event.setAmount((12 + 6 + (arthropodLevel * 4)) * 1.5f);
//                    } else if (initialDamage == ((12 + 3 + (arthropodLevel * 2.5)) * 1.5f)) {
//                        event.setAmount((12 + 3 + (arthropodLevel * 4)) * 1.5f);
//                    } else if (initialDamage == ((12 + (arthropodLevel * 2.5)) * 1.5f)) {
//                        event.setAmount((12 + (arthropodLevel * 4)) * 1.5f);
//                    } else if (initialDamage == (12 + 6 + (arthropodLevel * 2.5))) {
//                        event.setAmount(12 + 6 + (arthropodLevel * 4));
//                    } else if (initialDamage == (12 + 3 + (arthropodLevel * 2.5))) {
//                        event.setAmount(12 + 3 + (arthropodLevel * 4));
//                    } else if (initialDamage == (12 + (arthropodLevel * 2.5))) {
//                        event.setAmount(12 + (arthropodLevel * 4));
//                    }
//                } else {
//                    if (initialDamage == ((12 + 6 + (sharpnessLevel * 0.5 + 0.5)) * 1.5f)) {
//                        event.setAmount((12 + 6 + (sharpnessLevel * 2)) * 1.5f);
//                    } else if (initialDamage == ((12 + 3 + (sharpnessLevel * 0.5 + 0.5)) * 1.5f)) {
//                        event.setAmount((12 + 3 + (sharpnessLevel * 2)) * 1.5f);
//                    } else if (initialDamage == ((12 + (sharpnessLevel * 0.5 + 0.5)) * 1.5f)) {
//                        event.setAmount((12 + (sharpnessLevel * 2)) * 1.5f);
//                    } else if (initialDamage == (12 + 6 + (sharpnessLevel * 0.5 + 0.5))) {
//                        event.setAmount(12 + 6 + (sharpnessLevel * 2));
//                    } else if (initialDamage == (12 + 3 + (sharpnessLevel * 0.5 + 0.5))) {
//                        event.setAmount(12 + 3 + (sharpnessLevel * 2));
//                    } else if (initialDamage == (12 + (sharpnessLevel * 0.5 + 0.5))) {
//                        event.setAmount(12 + (sharpnessLevel * 2));
//                    }
//                }
//            }
//        }
//    }
    @SubscribeEvent
    public static void onLivingHurtWarden(LivingHurtEvent event) {
        if (event.getEntity() instanceof Warden) {
            if (event.getSource().getEntity() instanceof Player player) {
                String weaponName = player.getItemInHand(InteractionHand.MAIN_HAND).toString();
                String[] weaponNameSplit = weaponName.split(" ");
                player.sendSystemMessage(Component.literal( weaponNameSplit[1] + " damage: " + event.getAmount()));
            }
        }
    }

    @SubscribeEvent
    public static void onLivingHurtCow(LivingHurtEvent event) {
        if (event.getEntity() instanceof Cow) {
            if (event.getSource().getEntity() instanceof Player player) {
                String weaponName = player.getItemInHand(InteractionHand.MAIN_HAND).toString();
                String[] weaponNameSplit = weaponName.split(" ");
                player.sendSystemMessage(Component.literal( weaponNameSplit[1] + " damage: " + event.getAmount()));
            }
        }
    }@SubscribeEvent
    public static void onLivingHurtElderGuardian(LivingHurtEvent event) {
        if (event.getEntity() instanceof ElderGuardian) {
            if (event.getSource().getEntity() instanceof Player player) {
                String weaponName = player.getItemInHand(InteractionHand.MAIN_HAND).toString();
                String[] weaponNameSplit = weaponName.split(" ");
                player.sendSystemMessage(Component.literal( weaponNameSplit[1] + " damage: " + event.getAmount()));
            }
        }
    }

    @SubscribeEvent
    public static void changeTooltip(RenderTooltipEvent.GatherComponents event) {
        event.setMaxWidth(200);
        final List<Either<FormattedText, TooltipComponent>> tooltipElements = event.getTooltipElements();
        if (event.getItemStack().is(ModItems.SCULK_BLADE.get()) || event.getItemStack().is(ModItems.NETHER_BLADE.get()) || event.getItemStack().is(ModItems.END_BLADE.get())) {
            for (int i = 0; i < 4; i ++) {
                tooltipElements.remove(tooltipElements.size() - 1);
            }
        }
        if (event.getItemStack().is(ModItems.TIDE_BREAKER.get())) {
            for (int i = 0; i < 4; i ++) {
                tooltipElements.remove(tooltipElements.size() - 1);
            }
        }
        if (event.getItemStack().is(ModItems.LEVIATHANS_AXE.get())) {
            for (int i = 0; i < 4; i ++) {
                tooltipElements.remove(tooltipElements.size() - 1);
            }
        }


    }
}
