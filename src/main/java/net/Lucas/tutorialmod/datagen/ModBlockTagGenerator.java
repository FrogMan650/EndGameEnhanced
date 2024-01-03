package net.Lucas.tutorialmod.datagen;

import net.Lucas.tutorialmod.TutorialMod;
import net.Lucas.tutorialmod.block.ModBlocks;
import net.Lucas.tutorialmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
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

        //this adds 3 mod blocks to the tag: MINEABLE_WITH_PICKAXE
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.SAPPHIRE_ORE.get(),
        ModBlocks.SAPPHIRE_BLOCK.get(),
        ModBlocks.RAW_SAPPHIRE_BLOCK.get());

        //Ex: this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.SAPPHIRE_ORE.get());
    }
}
