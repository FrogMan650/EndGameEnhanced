package net.Lucas.endgameenhanced.item.custom.arrows;

import net.Lucas.endgameenhanced.entity.projectile.SapphireArrowEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.gui.font.providers.TrueTypeGlyphProviderDefinition;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SapphireArrow extends ArrowItem {
    public final float damage;
    public SapphireArrow(Properties pProperties, float damage) {
        super(pProperties);
        this.damage = damage;
    }

    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        SapphireArrowEntity arrow = new SapphireArrowEntity(pLevel, pShooter, pStack.copyWithCount(1));
        arrow.setBaseDamage(this.damage);
        return arrow;
    }

    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getTagEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == SapphireArrow.class;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        final ChatFormatting GOLD_TEXT = ChatFormatting.GOLD;
        final ChatFormatting BLUE_TEXT = ChatFormatting.DARK_BLUE;

        Component arrow_effect_description = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:arrow.sapphire_arrow"))).withStyle(BLUE_TEXT);
        pTooltipComponents.add(arrow_effect_description);

        Component hold_shift = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:generic.tooltip.hold_shift"))).withStyle(GOLD_TEXT);

        Component arrow_full_description = Component.translatable(Util.makeDescriptionId("tooltip", new ResourceLocation
                ("endgameenhanced:arrow.sapphire_arrow.description"))).withStyle(GOLD_TEXT);

        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(arrow_full_description);
        } else {
            pTooltipComponents.add(hold_shift);
        }
    }
}
