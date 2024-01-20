package net.Lucas.tutorialmod.datagen;

import net.Lucas.tutorialmod.TutorialMod;
import net.Lucas.tutorialmod.block.ModBlocks;
import net.Lucas.tutorialmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        //this adds a mod block and a tag to the tag: METAL_DETECTOR_VALUABLES
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES).add(ModBlocks.SAPPHIRE_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(ModTags.Blocks.UNKEMPT_HAROLD_SHOVELABLES).add(Blocks.CLAY).add(Blocks.COARSE_DIRT).add(Blocks.DIRT)
                .add(Blocks.DIRT_PATH).add(Blocks.FARMLAND).add(Blocks.GRASS_BLOCK).add(Blocks.GRAVEL).add(Blocks.RED_SAND)
                .add(Blocks.SOUL_SAND).add(Blocks.SOUL_SOIL).add(Blocks.SAND).add(Blocks.MUD).add(Blocks.MYCELIUM)
                .add(Blocks.PODZOL).add(Blocks.ROOTED_DIRT).add(Blocks.ROOTED_DIRT);

        //this adds 3 mod blocks to the tag: MINEABLE_WITH_PICKAXE
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.SAPPHIRE_ORE.get()
                , ModBlocks.SAPPHIRE_BLOCK.get()
                , ModBlocks.OPAL_BLOCK.get()
                , ModBlocks.JADE_BLOCK.get()
                , ModBlocks.RUBY_BLOCK.get()
                , ModBlocks.ONYX_BLOCK.get()

        );

        //Ex: this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.SAPPHIRE_ORE.get());
    }
}
