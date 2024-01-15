package net.Lucas.tutorialmod.event;

import com.ibm.icu.text.CaseMap;
import com.mojang.datafixers.util.Either;
import net.Lucas.tutorialmod.TutorialMod;
import net.Lucas.tutorialmod.item.ModItems;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.monster.ElderGuardian;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

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
