package net.Lucas.tutorialmod.event;

import com.mojang.datafixers.util.Either;
import net.Lucas.tutorialmod.TutorialMod;
import net.Lucas.tutorialmod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;
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
    public static void onLivingHurtSweepIncrease(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof Player player) {
            String weaponName = player.getItemInHand(InteractionHand.MAIN_HAND).toString();
            String[] weaponNameSplit = weaponName.split(" ");
            if (Objects.equals(weaponNameSplit[1], "nether_blade")) {
                float damageDone = event.getAmount();
                if (damageDone == 1) {
                    event.setAmount(17);
            }

            }
        }
    }

    @SubscribeEvent
    public static void onLivingHurtElderGuardian(LivingHurtEvent event) {
        if (event.getEntity() instanceof Cow) {
            if (event.getSource().getEntity() instanceof Player player) {
                String weaponName = player.getItemInHand(InteractionHand.MAIN_HAND).toString();
                String[] weaponNameSplit = weaponName.split(" ");
                player.sendSystemMessage(Component.literal( weaponNameSplit[1] + " damage: " + event.getAmount()));
            }
        }
    }

    @SubscribeEvent
    public static void changeTooltip(RenderTooltipEvent.GatherComponents event) {
        event.setMaxWidth(250);
        final List<Either<FormattedText, TooltipComponent>> tooltipElements = event.getTooltipElements();
        if (event.getItemStack().is(ModItems.SCULK_BLADE.get()) || event.getItemStack().is(ModItems.NETHER_BLADE.get()) || event.getItemStack().is(ModItems.END_BLADE.get())) {
            for (int i = 0; i < 3; i ++) {
                tooltipElements.add(3, tooltipElements.get(tooltipElements.size() - 1));
                tooltipElements.remove(tooltipElements.size() - 1);
            }
            tooltipElements.remove(tooltipElements.size() - 1);
            tooltipElements.remove(tooltipElements.size() - 1);
        }
        if (event.getItemStack().is(ModItems.TIDE_BREAKER.get())) {
            for (int i = 0; i < 4; i ++) {
                tooltipElements.remove(tooltipElements.size() - 1);
            }
        }

    }
}
