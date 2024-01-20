package net.Lucas.tutorialmod.util;

import net.Lucas.tutorialmod.TutorialMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");
        public static final TagKey<Block> NEEDS_SAPPHIRE_TOOL = tag("needs_sapphire_tool");
        public static final TagKey<Block> NEEDS_EMERALD_TOOL = tag("needs_emerald_tool");
        public static final TagKey<Block> NEEDS_RUBY_TOOL = tag("needs_ruby_tool");
        public static final TagKey<Block> NEEDS_ONYX_TOOL = tag("needs_onyx_tool");
        public static final TagKey<Block> NEEDS_JADE_TOOL = tag("needs_jade_tool");
        public static final TagKey<Block> NEEDS_OPAL_TOOL = tag("needs_opal_tool");
        public static final TagKey<Block> NEEDS_INEVITABLE_TOOL = tag("needs_inevitable_tool");
        public static final TagKey<Block> UNKEMPT_HAROLD_SHOVELABLES = tag("unkempt_harold_shovelables");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(TutorialMod.MOD_ID, name));
        }

    }

    public static class Items {

        public static final TagKey<Item> CHANGE_THIS_AS_ITEM_TAG_NAME = tag("name_of_the_json_file_for_tag");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(TutorialMod.MOD_ID, name));
        }

    }
}
