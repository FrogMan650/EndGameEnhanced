package net.Lucas.endgameenhanced.datagen;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.block.ModBlocks;
import net.Lucas.endgameenhanced.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {


        //build shaped recipes like below, being sure to use '' for the .define method
        //the .unlockedBy method changes the names and images for the in game recipe (i think?)
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);

        //build shapeless recipes like this
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.PUMPKIN, 25)
                .requires(ModBlocks.WHITE_PUMPKIN.get())
                .unlockedBy(getHasName(ModBlocks.WHITE_PUMPKIN.get()), has(ModBlocks.WHITE_PUMPKIN.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "pumpkin_from_white_pumpkin"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.MELON, 25)
                .requires(ModBlocks.GOLDEN_MELON.get())
                .unlockedBy(getHasName(ModBlocks.GOLDEN_MELON.get()), has(ModBlocks.GOLDEN_MELON.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "melon_from_golden_melon"));


        //gems and gem blocks
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OPAL.get(), 9)
                .requires(ModBlocks.OPAL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.OPAL_BLOCK.get()), has(ModBlocks.OPAL_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.OPAL_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.OPAL.get())
                .unlockedBy(getHasName(ModItems.OPAL.get()), has(ModItems.OPAL.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.JADE.get(), 9)
                .requires(ModBlocks.JADE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.JADE_BLOCK.get()), has(ModBlocks.JADE_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.JADE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.JADE.get())
                .unlockedBy(getHasName(ModItems.JADE.get()), has(ModItems.JADE.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBY.get(), 9)
                .requires(ModBlocks.RUBY_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RUBY_BLOCK.get()), has(ModBlocks.RUBY_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ONYX.get(), 9)
                .requires(ModBlocks.ONYX_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ONYX_BLOCK.get()), has(ModBlocks.ONYX_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ONYX_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.ONYX.get())
                .unlockedBy(getHasName(ModItems.ONYX.get()), has(ModItems.ONYX.get()))
                .save(pWriter);

        //opal tools
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OPAL_SWORD.get())
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.OPAL.get())
                .unlockedBy(getHasName(ModItems.OPAL_SWORD.get()), has(ModItems.OPAL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OPAL_SHOVEL.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.OPAL.get())
                .unlockedBy(getHasName(ModItems.OPAL_SHOVEL.get()), has(ModItems.OPAL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OPAL_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('P', ModItems.OPAL.get())
                .unlockedBy(getHasName(ModItems.OPAL_PICKAXE.get()), has(ModItems.OPAL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OPAL_AXE.get())
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.OPAL.get())
                .unlockedBy(getHasName(ModItems.OPAL_AXE.get()), has(ModItems.OPAL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OPAL_HOE.get())
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.OPAL.get())
                .unlockedBy(getHasName(ModItems.OPAL_HOE.get()), has(ModItems.OPAL.get()))
                .save(pWriter);

        //jade tools
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JADE_SWORD.get())
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.JADE.get())
                .unlockedBy(getHasName(ModItems.JADE_SWORD.get()), has(ModItems.JADE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JADE_SHOVEL.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.JADE.get())
                .unlockedBy(getHasName(ModItems.JADE_SHOVEL.get()), has(ModItems.JADE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JADE_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('P', ModItems.JADE.get())
                .unlockedBy(getHasName(ModItems.JADE_PICKAXE.get()), has(ModItems.JADE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JADE_AXE.get())
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.JADE.get())
                .unlockedBy(getHasName(ModItems.JADE_AXE.get()), has(ModItems.JADE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JADE_HOE.get())
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.JADE.get())
                .unlockedBy(getHasName(ModItems.JADE_HOE.get()), has(ModItems.JADE.get()))
                .save(pWriter);

        //sapphire tools
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_SWORD.get())
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE_SWORD.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_SHOVEL.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE_SHOVEL.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('P', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE_PICKAXE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_AXE.get())
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE_AXE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_HOE.get())
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE_HOE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);

        //emerald tools
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_SWORD.get())
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', Items.EMERALD)
                .unlockedBy(getHasName(ModItems.EMERALD_SWORD.get()), has(Items.EMERALD))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_SHOVEL.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', Items.EMERALD)
                .unlockedBy(getHasName(ModItems.EMERALD_SHOVEL.get()), has(Items.EMERALD))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('P', Items.EMERALD)
                .unlockedBy(getHasName(ModItems.EMERALD_PICKAXE.get()), has(Items.EMERALD))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_AXE.get())
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', Items.EMERALD)
                .unlockedBy(getHasName(ModItems.EMERALD_AXE.get()), has(Items.EMERALD))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_HOE.get())
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', Items.EMERALD)
                .unlockedBy(getHasName(ModItems.EMERALD_HOE.get()), has(Items.EMERALD))
                .save(pWriter);

        //ruby tools
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_SWORD.get())
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY_SWORD.get()), has(ModItems.RUBY.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_SHOVEL.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY_SHOVEL.get()), has(ModItems.RUBY.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('P', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY_PICKAXE.get()), has(ModItems.RUBY.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_AXE.get())
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY_AXE.get()), has(ModItems.RUBY.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_HOE.get())
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY_HOE.get()), has(ModItems.RUBY.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ONYX_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("EPE")
                .pattern("DSD")
                .pattern("DDD")
                .define('S', Blocks.NETHER_BRICKS)
                .define('E', Items.NETHERITE_INGOT)
                .define('P', ModItems.ONYX_UPGRADE_SMITHING_TEMPLATE.get())
                .define('D', Items.DIAMOND)
                .unlockedBy(getHasName(ModItems.ONYX_UPGRADE_SMITHING_TEMPLATE.get()), has(ModItems.ONYX_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("DPD")
                .pattern("DSD")
                .pattern("DDD")
                .define('S', Items.OBSIDIAN)
                .define('P', ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get())
                .define('D', Items.DIAMOND)
                .unlockedBy(getHasName(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get()), has(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ARROW, 3)
                .pattern(" P ")
                .pattern(" S ")
                .pattern(" D ")
                .define('P', ModItems.OPAL.get())
                .define('S', Items.STICK)
                .define('D', Items.FEATHER)
                .unlockedBy(getHasName(Items.ARROW), has(ModItems.OPAL.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "arrow_from_opal"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ARROW, 4)
                .pattern(" P ")
                .pattern(" S ")
                .pattern(" D ")
                .define('P', ModItems.JADE.get())
                .define('S', Items.STICK)
                .define('D', Items.FEATHER)
                .unlockedBy(getHasName(Items.ARROW), has(ModItems.JADE.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "arrow_from_jade"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ARROW, 5)
                .pattern(" P ")
                .pattern(" S ")
                .pattern(" D ")
                .define('P', ModItems.SAPPHIRE.get())
                .define('S', Items.STICK)
                .define('D', Items.FEATHER)
                .unlockedBy(getHasName(Items.ARROW), has(ModItems.SAPPHIRE.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "arrow_from_sapphire"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ARROW, 6)
                .pattern(" P ")
                .pattern(" S ")
                .pattern(" D ")
                .define('P', Items.EMERALD)
                .define('S', Items.STICK)
                .define('D', Items.FEATHER)
                .unlockedBy(getHasName(Items.ARROW), has(Items.EMERALD))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "arrow_from_emerald"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ARROW, 7)
                .pattern(" P ")
                .pattern(" S ")
                .pattern(" D ")
                .define('P', ModItems.RUBY.get())
                .define('S', Items.STICK)
                .define('D', Items.FEATHER)
                .unlockedBy(getHasName(Items.ARROW), has(ModItems.RUBY.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "arrow_from_ruby"));


        //pure essence
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_NETHER_ESSENCE.get())
                .pattern(" A ")
                .pattern("BCD")
                .pattern(" E ")
                .define('A', ModItems.CORRUPTING_ESSENCE.get())
                .define('B', ModItems.NETHER_ESSENCE.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', ModItems.LAVA_ESSENCE.get())
                .define('E', ModItems.SMOULDERING_ESSENCE.get())
                .unlockedBy(getHasName(ModItems.PURE_NETHER_ESSENCE.get()), has(ModItems.NETHERRATH_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_nether_essence"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_END_ESSENCE.get())
                .pattern(" A ")
                .pattern("BCD")
                .pattern(" E ")
                .define('A', ModItems.CORRUPTING_ESSENCE.get())
                .define('B', ModItems.END_ESSENCE.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', ModItems.DARKNESS_ESSENCE.get())
                .define('E', ModItems.VOIDED_ESSENCE.get())
                .unlockedBy(getHasName(ModItems.PURE_END_ESSENCE.get()), has(ModItems.VOIDWAKER_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_end_essence"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_SCULK_ESSENCE.get())
                .pattern(" A ")
                .pattern("BCD")
                .pattern(" E ")
                .define('A', ModItems.CORRUPTING_ESSENCE.get())
                .define('B', ModItems.ANCIENT_ESSENCE.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', ModItems.SCULK_ESSENCE.get())
                .define('E', ModItems.WARNING_ESSENCE.get())
                .unlockedBy(getHasName(ModItems.PURE_SCULK_ESSENCE.get()), has(ModItems.SCULK_BRINGER_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_sculk_essence"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_SPIDER_ESSENCE.get())
                .pattern(" A ")
                .pattern("BCD")
                .pattern(" E ")
                .define('A', ModItems.VOLATILE_ESSENCE.get())
                .define('B', ModItems.MINESHAFT_ESSENCE.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', ModItems.SECLUDED_ESSENCE.get())
                .define('E', ModItems.SPIDER_ESSENCE.get())
                .unlockedBy(getHasName(ModItems.PURE_SPIDER_ESSENCE.get()), has(ModItems.WEBWEAVER_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_spider_essence"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_EVIL_ESSENCE.get())
                .pattern(" A ")
                .pattern("BCD")
                .pattern(" E ")
                .define('A', ModItems.VOLATILE_ESSENCE.get())
                .define('B', ModItems.ANCIENT_ESSENCE.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', ModItems.SCULK_ESSENCE.get())
                .define('E', ModItems.PILLAGED_ESSENCE.get())
                .unlockedBy(getHasName(ModItems.PURE_EVIL_ESSENCE.get()), has(ModItems.SCULK_SLINGER_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_evil_essence"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_OCEAN_ESSENCE.get())
                .pattern(" A ")
                .pattern("BCD")
                .pattern(" E ")
                .define('A', ModItems.PRISMATIC_ESSENCE.get())
                .define('B', ModItems.OCEAN_ESSENCE.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', ModItems.WATER_ESSENCE.get())
                .define('E', ModItems.DRENCHED_ESSENCE.get())
                .unlockedBy(getHasName(ModItems.PURE_OCEAN_ESSENCE.get()), has(ModItems.TIDE_BREAKER_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_ocean_essence"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_FIRE_ESSENCE.get())
                .pattern(" A ")
                .pattern("BCD")
                .pattern(" E ")
                .define('A', ModItems.VOLATILE_ESSENCE.get())
                .define('B', ModItems.GEM_ESSENCE.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', ModItems.INFERNAL_ESSENCE.get())
                .define('E', ModItems.ORE_ESSENCE.get())
                .unlockedBy(getHasName(ModItems.PURE_FIRE_ESSENCE.get()), has(ModItems.INFERNAL_PICKAXE_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_fire_essence"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_EXPLOSIVE_ESSENCE.get())
                .pattern(" A ")
                .pattern("BCD")
                .pattern(" E ")
                .define('A', ModItems.PRISMATIC_ESSENCE.get())
                .define('B', ModItems.EARTHLY_ESSENCE.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', ModItems.UNKEMPT_ESSENCE.get())
                .define('E', ModItems.EXPLOSIVE_ESSENCE.get())
                .unlockedBy(getHasName(ModItems.PURE_EXPLOSIVE_ESSENCE.get()), has(ModItems.UNKEMPT_HAROLD_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_explosive_essence"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_NATURE_ESSENCE.get())
                .pattern(" A ")
                .pattern("BCD")
                .pattern(" E ")
                .define('A', ModItems.VOLATILE_ESSENCE.get())
                .define('B', ModItems.HARVEST_ESSENCE.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', ModItems.SECLUDED_ESSENCE.get())
                .define('E', ModItems.TREE_ESSENCE.get())
                .unlockedBy(getHasName(ModItems.PURE_NATURE_ESSENCE.get()), has(ModItems.LEVIATHANS_AXE_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_nature_essence"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_BLOOD_ESSENCE.get())
                .pattern(" A ")
                .pattern("BCD")
                .pattern(" E ")
                .define('A', ModItems.CORRUPTING_ESSENCE.get())
                .define('B', ModItems.SMALL_PLANT_ESSENCE.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', ModItems.TALL_PLANT_ESSENCE.get())
                .define('E', ModItems.SANGUINE_ESSENCE.get())
                .unlockedBy(getHasName(ModItems.PURE_BLOOD_ESSENCE.get()), has(ModItems.SCYTHE_OF_VITUR_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_blood_essence"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_RESOLUTE_ESSENCE.get())
                .pattern(" A ")
                .pattern("BCD")
                .pattern(" E ")
                .define('A', ModItems.PRISMATIC_ESSENCE.get())
                .define('B', ModItems.TOUGHNESS_ESSENCE.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', ModItems.BREACH_ESSENCE.get())
                .define('E', ModItems.VISION_ESSENCE.get())
                .unlockedBy(getHasName(ModItems.PURE_RESOLUTE_ESSENCE.get()), has(ModItems.OBSIDIAN_ARMOR_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_resolute_essence"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_TOUGH_ESSENCE.get())
                .pattern(" A ")
                .pattern("BCD")
                .pattern(" E ")
                .define('A', ModItems.PRISMATIC_ESSENCE.get())
                .define('B', ModItems.TOUGHNESS_ESSENCE.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', ModItems.DRENCHED_ESSENCE.get())
                .define('E', ModItems.CONDUIT_ESSENCE.get())
                .unlockedBy(getHasName(ModItems.PURE_TOUGH_ESSENCE.get()), has(ModItems.OBSIDIAN_ARMOR_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_tough_essence"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_RESILIENT_ESSENCE.get())
                .pattern(" A ")
                .pattern("BCD")
                .pattern(" E ")
                .define('A', ModItems.PRISMATIC_ESSENCE.get())
                .define('B', ModItems.TOUGHNESS_ESSENCE.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', ModItems.STABILIZED_ESSENCE.get())
                .define('E', ModItems.BOOST_ESSENCE.get())
                .unlockedBy(getHasName(ModItems.PURE_RESILIENT_ESSENCE.get()), has(ModItems.OBSIDIAN_ARMOR_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_resilient_essence"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_RESISTANT_ESSENCE.get())
                .pattern(" A ")
                .pattern("BCD")
                .pattern(" E ")
                .define('A', ModItems.PRISMATIC_ESSENCE.get())
                .define('B', ModItems.TOUGHNESS_ESSENCE.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', ModItems.SWIFT_ESSENCE.get())
                .define('E', ModItems.SPEED_ESSENCE.get())
                .unlockedBy(getHasName(ModItems.PURE_RESISTANT_ESSENCE.get()), has(ModItems.OBSIDIAN_ARMOR_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_resistant_essence"));

        //essence
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SPIDER_ESSENCE.get())
                .pattern("AAA")
                .pattern("BCD")
                .pattern("EEE")
                .define('A', Items.FERMENTED_SPIDER_EYE)
                .define('B', ModItems.SPIDER_FANG.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', ModItems.CAVE_SPIDER_EYE.get())
                .define('E', Items.COBWEB)
                .unlockedBy(getHasName(ModItems.SPIDER_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pWriter, new ResourceLocation(EndGameEnhanced.MOD_ID, "spider_essence"));
        

        netheriteSmithing(pWriter, ModItems.VOIDWAKER_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_SWORD, ModItems.PURE_END_ESSENCE.get(), RecipeCategory.MISC, ModItems.END_BLADE.get());
        netheriteSmithing(pWriter, ModItems.NETHERRATH_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_SWORD, ModItems.PURE_NETHER_ESSENCE.get(), RecipeCategory.MISC, ModItems.NETHER_BLADE.get());
        netheriteSmithing(pWriter, ModItems.SCULK_BRINGER_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_SWORD, ModItems.PURE_SCULK_ESSENCE.get(), RecipeCategory.MISC, ModItems.SCULK_BLADE.get());
        netheriteSmithing(pWriter, ModItems.SCULK_SLINGER_UPGRADE_SMITHING_TEMPLATE.get(), Items.CROSSBOW, ModItems.PURE_EVIL_ESSENCE.get(), RecipeCategory.MISC, ModItems.SCULK_SLINGER.get());
        netheriteSmithing(pWriter, ModItems.WEBWEAVER_UPGRADE_SMITHING_TEMPLATE.get(), Items.BOW, ModItems.PURE_SPIDER_ESSENCE.get(), RecipeCategory.MISC, ModItems.WEBWEAVER_BOW.get());
        netheriteSmithing(pWriter, ModItems.TIDE_BREAKER_UPGRADE_SMITHING_TEMPLATE.get(), Items.TRIDENT, ModItems.PURE_OCEAN_ESSENCE.get(), RecipeCategory.MISC, ModItems.TIDE_BREAKER.get());
        netheriteSmithing(pWriter, ModItems.INFERNAL_PICKAXE_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_PICKAXE, ModItems.PURE_FIRE_ESSENCE.get(), RecipeCategory.MISC, ModItems.INFERNAL_PICKAXE.get());
        netheriteSmithing(pWriter, ModItems.UNKEMPT_HAROLD_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_SHOVEL, ModItems.PURE_EXPLOSIVE_ESSENCE.get(), RecipeCategory.MISC, ModItems.UNKEMPT_HAROLD.get());
        netheriteSmithing(pWriter, ModItems.LEVIATHANS_AXE_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_AXE, ModItems.PURE_NATURE_ESSENCE.get(), RecipeCategory.MISC, ModItems.LEVIATHANS_AXE.get());
        netheriteSmithing(pWriter, ModItems.SCYTHE_OF_VITUR_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_HOE, ModItems.PURE_BLOOD_ESSENCE.get(), RecipeCategory.MISC, ModItems.SCYTHE_OF_VITUR.get());
        netheriteSmithing(pWriter, ModItems.OBSIDIAN_ARMOR_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_HELMET, ModItems.PURE_RESOLUTE_ESSENCE.get(), RecipeCategory.MISC, ModItems.INEVITABLE_HELMET.get());
        netheriteSmithing(pWriter, ModItems.OBSIDIAN_ARMOR_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_CHESTPLATE, ModItems.PURE_TOUGH_ESSENCE.get(), RecipeCategory.MISC, ModItems.INEVITABLE_CHESTPLATE.get());
        netheriteSmithing(pWriter, ModItems.OBSIDIAN_ARMOR_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_LEGGINGS, ModItems.PURE_RESILIENT_ESSENCE.get(), RecipeCategory.MISC, ModItems.INEVITABLE_LEGGINGS.get());
        netheriteSmithing(pWriter, ModItems.OBSIDIAN_ARMOR_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_BOOTS, ModItems.PURE_RESISTANT_ESSENCE.get(), RecipeCategory.MISC, ModItems.INEVITABLE_BOOTS.get());

    }


    protected static void netheriteSmithing(Consumer<FinishedRecipe> pFinishedRecipeConsumer, Item modTemplate, Item itemToUpgrade, Item itemToUpgradeWith, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(modTemplate), Ingredient.of(itemToUpgrade), Ingredient.of(itemToUpgradeWith), pCategory, pResultItem).unlocks("has_netherite_ingot", has(itemToUpgradeWith)).save(pFinishedRecipeConsumer, getItemName(pResultItem) + "_smithing");
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer, EndGameEnhanced.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
