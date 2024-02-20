package net.Lucas.endgameenhanced.datagen;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.item.ModItems;
import net.Lucas.endgameenhanced.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, EndGameEnhanced.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR).add(
                ModItems.ONYX_HELMET.get(),
                ModItems.ONYX_CHESTPLATE.get(),
                ModItems.ONYX_LEGGINGS.get(),
                ModItems.ONYX_BOOTS.get(),
                ModItems.INEVITABLE_HELMET.get(),
                ModItems.INEVITABLE_CHESTPLATE.get(),
                ModItems.INEVITABLE_LEGGINGS.get(),
                ModItems.INEVITABLE_BOOTS.get());

        this.tag(ModTags.Items.NO_PICKUP_ARROWS).add(Items.TIPPED_ARROW, Items.SPECTRAL_ARROW, ModItems.SAPPHIRE_ARROW.get(),
                ModItems.EMERALD_ARROW.get(), ModItems.RUBY_ARROW.get(), ModItems.DIAMOND_ARROW.get(),
                ModItems.ONYX_ARROW.get(), ModItems.WEBWEAVER_ARROW.get(), ModItems.SCULK_SLINGER_ARROW.get());
    }
}
