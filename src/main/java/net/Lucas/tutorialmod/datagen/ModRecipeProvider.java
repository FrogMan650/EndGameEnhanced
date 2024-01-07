package net.Lucas.tutorialmod.datagen;

import net.Lucas.tutorialmod.TutorialMod;
import net.Lucas.tutorialmod.block.ModBlocks;
import net.Lucas.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
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
    //can be easier to make a list like below and then feed that into making smelting recipes etc

    private static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModItems.RAW_SAPPHIRE.get(),
            ModBlocks.SAPPHIRE_ORE.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25F, 200, "sapphire");
        oreBlasting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25F, 100, "sapphire");


        //build shaped recipes like below, being sure to use '' for the .define method
        //the .unlockedBy method changes the names and images for the in game recipe (i think?)
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.RAW_SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.RAW_SAPPHIRE.get()), has(ModItems.RAW_SAPPHIRE.get()))
                .save(pWriter);

        //build shapeless recipes like this
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_SAPPHIRE.get(), 9)
                .requires(ModBlocks.RAW_SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_SAPPHIRE_BLOCK.get()), has(ModBlocks.RAW_SAPPHIRE_BLOCK.get()))
                .save(pWriter);


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
                .unlockedBy(getHasName(ModItems.OPAL_SWORD.get()), has(ModItems.OPAL_SWORD.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OPAL_SHOVEL.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.OPAL.get())
                .unlockedBy(getHasName(ModItems.OPAL_SHOVEL.get()), has(ModItems.OPAL_SHOVEL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OPAL_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('P', ModItems.OPAL.get())
                .unlockedBy(getHasName(ModItems.OPAL_PICKAXE.get()), has(ModItems.OPAL_PICKAXE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OPAL_AXE.get())
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.OPAL.get())
                .unlockedBy(getHasName(ModItems.OPAL_AXE.get()), has(ModItems.OPAL_AXE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OPAL_HOE.get())
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.OPAL.get())
                .unlockedBy(getHasName(ModItems.OPAL_HOE.get()), has(ModItems.OPAL_HOE.get()))
                .save(pWriter);

        //jade tools
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JADE_SWORD.get())
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.JADE.get())
                .unlockedBy(getHasName(ModItems.JADE_SWORD.get()), has(ModItems.JADE_SWORD.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JADE_SHOVEL.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.JADE.get())
                .unlockedBy(getHasName(ModItems.JADE_SHOVEL.get()), has(ModItems.JADE_SHOVEL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JADE_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('P', ModItems.JADE.get())
                .unlockedBy(getHasName(ModItems.JADE_PICKAXE.get()), has(ModItems.JADE_PICKAXE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JADE_AXE.get())
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.JADE.get())
                .unlockedBy(getHasName(ModItems.JADE_AXE.get()), has(ModItems.JADE_AXE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JADE_HOE.get())
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.JADE.get())
                .unlockedBy(getHasName(ModItems.JADE_HOE.get()), has(ModItems.JADE_HOE.get()))
                .save(pWriter);

        //sapphire tools
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_SWORD.get())
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE_SWORD.get()), has(ModItems.SAPPHIRE_SWORD.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_SHOVEL.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE_SHOVEL.get()), has(ModItems.SAPPHIRE_SHOVEL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('P', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE_PICKAXE.get()), has(ModItems.SAPPHIRE_PICKAXE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_AXE.get())
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE_AXE.get()), has(ModItems.SAPPHIRE_AXE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_HOE.get())
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE_HOE.get()), has(ModItems.SAPPHIRE_HOE.get()))
                .save(pWriter);

        //emerald tools
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_SWORD.get())
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', Items.EMERALD)
                .unlockedBy(getHasName(ModItems.EMERALD_SWORD.get()), has(ModItems.EMERALD_SWORD.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_SHOVEL.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', Items.EMERALD)
                .unlockedBy(getHasName(ModItems.EMERALD_SHOVEL.get()), has(ModItems.EMERALD_SHOVEL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('P', Items.EMERALD)
                .unlockedBy(getHasName(ModItems.EMERALD_PICKAXE.get()), has(ModItems.EMERALD_PICKAXE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_AXE.get())
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', Items.EMERALD)
                .unlockedBy(getHasName(ModItems.EMERALD_AXE.get()), has(ModItems.EMERALD_AXE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_HOE.get())
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', Items.EMERALD)
                .unlockedBy(getHasName(ModItems.EMERALD_HOE.get()), has(ModItems.EMERALD_HOE.get()))
                .save(pWriter);

        //ruby tools
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_SWORD.get())
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY_SWORD.get()), has(ModItems.RUBY_SWORD.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_SHOVEL.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY_SHOVEL.get()), has(ModItems.RUBY_SHOVEL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('P', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY_PICKAXE.get()), has(ModItems.RUBY_PICKAXE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_AXE.get())
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY_AXE.get()), has(ModItems.RUBY_AXE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_HOE.get())
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY_HOE.get()), has(ModItems.RUBY_HOE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ONYX_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("DPD")
                .pattern("DSD")
                .pattern("DDD")
                .define('S', Items.OBSIDIAN)
                .define('P', ModItems.ONYX_UPGRADE_SMITHING_TEMPLATE.get())
                .define('D', Items.DIAMOND)
                .unlockedBy(getHasName(ModItems.ONYX_UPGRADE_SMITHING_TEMPLATE.get()), has(ModItems.ONYX_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("DPD")
                .pattern("DSD")
                .pattern("DDD")
                .define('S', Items.DEEPSLATE)
                .define('P', ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get())
                .define('D', Items.DIAMOND)
                .unlockedBy(getHasName(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get()), has(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter);









//        netheriteSmithing(pWriter, ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get(), Items.DIAMOND_PICKAXE, ModItems.ONYX.get(), RecipeCategory.MISC, ModItems.ONYX_PICKAXE.get());
//        netheriteSmithing(pWriter, ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get(), Items.DIAMOND_AXE, ModItems.ONYX.get(), RecipeCategory.MISC, ModItems.ONYX_AXE.get());
//        netheriteSmithing(pWriter, ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get(), Items.DIAMOND_SHOVEL, ModItems.ONYX.get(), RecipeCategory.MISC, ModItems.ONYX_SHOVEL.get());
//        netheriteSmithing(pWriter, ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get(), Items.DIAMOND_HOE, ModItems.ONYX.get(), RecipeCategory.MISC, ModItems.ONYX_HOE.get());
//        netheriteSmithing(pWriter, ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get(), Items.DIAMOND_HOE, ModItems.ONYX.get(), RecipeCategory.MISC, ModItems.ONYX_HOE.get());
    }


    //must manually move generated .json to main and then delete generating code
    protected static void netheriteSmithing(Consumer<FinishedRecipe> pFinishedRecipeConsumer, Item modTemplate, Item itemToUpgrade, Item itemToUpgradeWith, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(modTemplate), Ingredient.of(itemToUpgrade), Ingredient.of(itemToUpgradeWith), pCategory, pResultItem).unlocks("has_netherite_ingot", has(itemToUpgradeWith)).save(pFinishedRecipeConsumer, getItemName(pResultItem) + "_smithing");
    }

    //these methods are used to build recipes for items or blocks that need to be processed
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer, TutorialMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}