package net.Lucas.endgameenhanced.datagen.loot;

import net.Lucas.endgameenhanced.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.OPAL_BLOCK.get());
        this.dropSelf(ModBlocks.JADE_BLOCK.get());
        this.dropSelf(ModBlocks.RUBY_BLOCK.get());
        this.dropSelf(ModBlocks.ONYX_BLOCK.get());
        this.dropSelf(ModBlocks.BIG_QUARTZ_BLOCK.get());
        this.dropSelf(ModBlocks.BIG_AMETHYST_BLOCK.get());
        this.dropSelf(ModBlocks.ECHO_BLOCK.get());
        this.dropSelf(ModBlocks.WHITE_PUMPKIN.get());
        this.dropSelf(ModBlocks.GOLDEN_MELON.get());
        this.dropSelf(ModBlocks.GEM_ORE.get());

    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
