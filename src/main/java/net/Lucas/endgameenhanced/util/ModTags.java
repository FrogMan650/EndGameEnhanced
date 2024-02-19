package net.Lucas.endgameenhanced.util;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_SAPPHIRE_TOOL = tag("needs_sapphire_tool");
        public static final TagKey<Block> NEEDS_EMERALD_TOOL = tag("needs_emerald_tool");
        public static final TagKey<Block> NEEDS_RUBY_TOOL = tag("needs_ruby_tool");
        public static final TagKey<Block> NEEDS_ONYX_TOOL = tag("needs_onyx_tool");
        public static final TagKey<Block> NEEDS_JADE_TOOL = tag("needs_jade_tool");
        public static final TagKey<Block> NEEDS_OPAL_TOOL = tag("needs_opal_tool");
        public static final TagKey<Block> NEEDS_INEVITABLE_TOOL = tag("needs_inevitable_tool");
        public static final TagKey<Block> INFERNAL_PICKAXE_MINEABLES = tag("infernal_pickaxe_mineables");
        public static final TagKey<Block> SANGUINE_SCYTHE_HOEABLES = tag("sanguine_scythe_hoeables");
        public static final TagKey<Block> LEVIATHANS_AXE_AXEABLES = tag("leviathans_axe_axeables");
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(EndGameEnhanced.MOD_ID, name));
        }

    }

    public static class Items {
        public static final TagKey<Item> NO_PICKUP_ARROWS = tag("no_pickup_arrows");


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(EndGameEnhanced.MOD_ID, name));
        }

    }
}
