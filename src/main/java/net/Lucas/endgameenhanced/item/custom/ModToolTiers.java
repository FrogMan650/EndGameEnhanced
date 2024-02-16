package net.Lucas.endgameenhanced.item.custom;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.item.ModItems;
import net.Lucas.endgameenhanced.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier SAPPHIRE = TierSortingRegistry.registerTier(
            new SimpleTier(2, 400, 6F, 2F, 10,
                    ModTags.Blocks.NEEDS_SAPPHIRE_TOOL, () -> Ingredient.of(ModItems.SAPPHIRE.get())),
            new ResourceLocation(EndGameEnhanced.MOD_ID, "sapphire"), List.of(Tiers.IRON), List.of());
    public static final Tier JADE = TierSortingRegistry.registerTier(
            new SimpleTier(1, 200, 5F, 1F, 5,
                    ModTags.Blocks.NEEDS_JADE_TOOL, () -> Ingredient.of(ModItems.JADE.get())),
            new ResourceLocation(EndGameEnhanced.MOD_ID, "jade"), List.of(Tiers.STONE), List.of());
    public static final Tier OPAL = TierSortingRegistry.registerTier(
            new SimpleTier(1, 150, 4F, 1F, 5,
                    ModTags.Blocks.NEEDS_OPAL_TOOL, () -> Ingredient.of(ModItems.OPAL.get())),
            new ResourceLocation(EndGameEnhanced.MOD_ID, "opal"), List.of(Tiers.STONE), List.of());
    public static final Tier EMERALD = TierSortingRegistry.registerTier(
            new SimpleTier(2, 750, 7F, 2F, 10,
                    ModTags.Blocks.NEEDS_EMERALD_TOOL, () -> Ingredient.of(Items.EMERALD)),
            new ResourceLocation(EndGameEnhanced.MOD_ID, "emerald"), List.of(Tiers.IRON), List.of());
    public static final Tier RUBY = TierSortingRegistry.registerTier(
            new SimpleTier(3, 1000, 7F, 3F, 10,
                    ModTags.Blocks.NEEDS_RUBY_TOOL, () -> Ingredient.of(ModItems.RUBY.get())),
            new ResourceLocation(EndGameEnhanced.MOD_ID, "ruby"), List.of(Tiers.IRON), List.of());
    public static final Tier ONYX = TierSortingRegistry.registerTier(
            new SimpleTier(4, 1790, 8F, 3F, 13,
                    ModTags.Blocks.NEEDS_ONYX_TOOL, () -> Ingredient.of(ModItems.ONYX.get())),
            new ResourceLocation(EndGameEnhanced.MOD_ID, "onyx"), List.of(Tiers.DIAMOND), List.of());
    public static final Tier INEVITABLE = TierSortingRegistry.registerTier(
            new SimpleTier(5, 6969, 12F, 5F, 20,
                    ModTags.Blocks.NEEDS_INEVITABLE_TOOL, () -> Ingredient.of(Items.NETHERITE_INGOT)),
            new ResourceLocation(EndGameEnhanced.MOD_ID, "inevitable"), List.of(Tiers.NETHERITE), List.of());





}
