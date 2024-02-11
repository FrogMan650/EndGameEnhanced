package net.Lucas.endgameenhanced.datagen;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.block.ModBlocks;
import net.Lucas.endgameenhanced.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, EndGameEnhanced.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(ModTags.Blocks.INFERNAL_PICKAXE_MINEABLES).add(Blocks.STONE).add(Blocks.COBBLESTONE).add(Blocks.DEEPSLATE)
                .add(Blocks.NETHERRACK).add(Blocks.END_STONE).add(Blocks.COBBLED_DEEPSLATE).add(Blocks.ANDESITE).add(Blocks.DIORITE)
                .add(Blocks.GRANITE).add(Blocks.BLACKSTONE).add(Blocks.BASALT).add(Blocks.WHITE_CONCRETE, Blocks.ORANGE_CONCRETE,
                        Blocks.MAGENTA_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE, Blocks.YELLOW_CONCRETE, Blocks.LIME_CONCRETE,
                        Blocks.PINK_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE, Blocks.CYAN_CONCRETE,
                        Blocks.PURPLE_CONCRETE, Blocks.BLUE_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.GREEN_CONCRETE,
                        Blocks.RED_CONCRETE, Blocks.BLACK_CONCRETE).add(Blocks.CRIMSON_NYLIUM, Blocks.WARPED_NYLIUM)
                .addTag(BlockTags.ICE).addTag(BlockTags.TERRACOTTA).add(Blocks.WHITE_GLAZED_TERRACOTTA, Blocks.ORANGE_GLAZED_TERRACOTTA,
                        Blocks.MAGENTA_GLAZED_TERRACOTTA, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, Blocks.YELLOW_GLAZED_TERRACOTTA,
                        Blocks.LIME_GLAZED_TERRACOTTA, Blocks.PINK_GLAZED_TERRACOTTA, Blocks.GRAY_GLAZED_TERRACOTTA,
                        Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, Blocks.CYAN_GLAZED_TERRACOTTA, Blocks.PURPLE_GLAZED_TERRACOTTA,
                        Blocks.BLUE_GLAZED_TERRACOTTA, Blocks.BROWN_GLAZED_TERRACOTTA, Blocks.GREEN_GLAZED_TERRACOTTA,
                        Blocks.RED_GLAZED_TERRACOTTA, Blocks.BLACK_GLAZED_TERRACOTTA).add(Blocks.NETHER_BRICKS)
                .add(Blocks.BRICKS).add(Blocks.MAGMA_BLOCK);

        this.tag(ModTags.Blocks.SANGUINE_SCYTHE_HOEABLES).add(Blocks.MOSS_BLOCK).add(Blocks.SCULK).add(Blocks.SPONGE)
                .add(Blocks.WET_SPONGE).add(Blocks.DRIED_KELP_BLOCK).add(Blocks.HAY_BLOCK).add(Blocks.NETHER_WART_BLOCK)
                .add(Blocks.WARPED_WART_BLOCK).add(Blocks.SHROOMLIGHT).add(Blocks.TARGET).addTag(BlockTags.LEAVES)
                .addTag(BlockTags.WOOL).add(Blocks.COBWEB);

        this.tag(ModTags.Blocks.LEVIATHANS_AXE_AXEABLES).add(Blocks.PUMPKIN).add(Blocks.MELON)
                .add(Blocks.BOOKSHELF).addTag(BlockTags.PLANKS).add(Blocks.BAMBOO_BLOCK, Blocks.BAMBOO_MOSAIC).add(ModBlocks.GOLDEN_MELON.get())
                .add(ModBlocks.WHITE_PUMPKIN.get());

        this.tag(ModTags.Blocks.NEEDS_INEVITABLE_TOOL).add(Blocks.REINFORCED_DEEPSLATE);

        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.GEM_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.SAPPHIRE_BLOCK.get(),
                ModBlocks.OPAL_BLOCK.get(), ModBlocks.JADE_BLOCK.get(), ModBlocks.RUBY_BLOCK.get(),
                ModBlocks.ONYX_BLOCK.get(), Blocks.REINFORCED_DEEPSLATE, ModBlocks.GEM_ORE.get()
        );
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(ModBlocks.WHITE_PUMPKIN.get(), ModBlocks.GOLDEN_MELON.get()
        );

    }
}
