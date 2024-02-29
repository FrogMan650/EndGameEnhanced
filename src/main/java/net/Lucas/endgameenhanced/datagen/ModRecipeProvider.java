package net.Lucas.endgameenhanced.datagen;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.block.ModBlocks;
import net.Lucas.endgameenhanced.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {


        //build shaped recipes like below, being sure to use '' for the .define method
        //the .unlockedBy method changes the names and images for the in game recipe (i think?)
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pRecipeOutput);

        //build shapeless recipes like this
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(pRecipeOutput);

        //unique mob item conversion recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.PUMPKIN, 25)
                .requires(ModBlocks.WHITE_PUMPKIN.get())
                .unlockedBy(getHasName(ModBlocks.WHITE_PUMPKIN.get()), has(ModBlocks.WHITE_PUMPKIN.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "pumpkin_from_white_pumpkin"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.TURTLE_SPAWN_EGG, 1)
                .requires(ModBlocks.WHITE_PUMPKIN.get())
                .requires(Items.TURTLE_EGG)
                .unlockedBy(getHasName(ModBlocks.WHITE_PUMPKIN.get()), has(ModBlocks.WHITE_PUMPKIN.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "turtle_egg_from_white_pumpkin"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.MELON, 25)
                .requires(ModBlocks.GOLDEN_MELON.get())
                .unlockedBy(getHasName(ModBlocks.GOLDEN_MELON.get()), has(ModBlocks.GOLDEN_MELON.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "melon_from_golden_melon"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.TURTLE_SPAWN_EGG, 1)
                .requires(ModBlocks.GOLDEN_MELON.get())
                .requires(Items.TURTLE_EGG)
                .unlockedBy(getHasName(ModBlocks.GOLDEN_MELON.get()), has(ModBlocks.GOLDEN_MELON.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "turtle_egg_from_golden_melon"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.MAGMA_CUBE_SPAWN_EGG, 1)
                .requires(ModItems.MAGMA_BUTTER.get())
                .unlockedBy(getHasName(ModItems.MAGMA_BUTTER.get()), has(ModItems.MAGMA_BUTTER.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "magma_cube_egg_from_magma_butter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.SLIME_SPAWN_EGG, 1)
                .requires(ModItems.SLIME_GLOB.get())
                .unlockedBy(getHasName(ModItems.SLIME_GLOB.get()), has(ModItems.SLIME_GLOB.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "slime_egg_from_slime_glob"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PIGLIN_SPAWN_EGG, 1)
                .requires(ModItems.PIGLINS_GOLD_COIN.get())
                .unlockedBy(getHasName(ModItems.PIGLINS_GOLD_COIN.get()), has(ModItems.PIGLINS_GOLD_COIN.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "piglin_egg_from_gold_coin"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ZOMBIFIED_PIGLIN_SPAWN_EGG, 1)
                .requires(ModItems.PIGLINS_GOLD_COIN.get())
                .requires(Items.ROTTEN_FLESH)
                .unlockedBy(getHasName(ModItems.PIGLINS_GOLD_COIN.get()), has(ModItems.PIGLINS_GOLD_COIN.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "zombie_piglin_egg_from_gold_coin"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CAVE_SPIDER_SPAWN_EGG, 1)
                .requires(ModItems.CAVE_SPIDER_EYE.get())
                .unlockedBy(getHasName(ModItems.CAVE_SPIDER_EYE.get()), has(ModItems.CAVE_SPIDER_EYE.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "cave_spider_egg_from_cave_spider_eye"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GHAST_SPAWN_EGG, 1)
                .requires(ModItems.GHAST_TENTACLE.get())
                .unlockedBy(getHasName(ModItems.GHAST_TENTACLE.get()), has(ModItems.GHAST_TENTACLE.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "ghast_egg_from_ghast_tentacle"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CREEPER_SPAWN_EGG, 1)
                .requires(ModItems.CREEPER_FUSE.get())
                .unlockedBy(getHasName(ModItems.CREEPER_FUSE.get()), has(ModItems.CREEPER_FUSE.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "creeper_egg_from_creeper_fuse"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.SKELETON_SPAWN_EGG, 1)
                .requires(ModItems.RIB_BONE.get())
                .unlockedBy(getHasName(ModItems.RIB_BONE.get()), has(ModItems.RIB_BONE.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "skeleton_egg_from_rib_bone"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.STRAY_SPAWN_EGG, 1)
                .requires(ModItems.FROZEN_BONE.get())
                .unlockedBy(getHasName(ModItems.FROZEN_BONE.get()), has(ModItems.FROZEN_BONE.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "stray_egg_from_frozen_bone"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.SPONGE, 5)
                .requires(ModItems.GUARDIAN_SPIKE.get())
                .unlockedBy(getHasName(ModItems.GUARDIAN_SPIKE.get()), has(ModItems.GUARDIAN_SPIKE.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "sponge_from_guardian_spike"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.SPONGE, 10)
                .requires(ModItems.ELDER_GUARDIAN_SPIKE.get())
                .unlockedBy(getHasName(ModItems.ELDER_GUARDIAN_SPIKE.get()), has(ModItems.ELDER_GUARDIAN_SPIKE.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "sponge_from_elder_guardian_spike"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.HOGLIN_SPAWN_EGG, 1)
                .requires(ModItems.HOGLIN_TUSK.get())
                .unlockedBy(getHasName(ModItems.HOGLIN_TUSK.get()), has(ModItems.HOGLIN_TUSK.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "hoglin_egg_from_hoglin_tusk"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PHANTOM_SPAWN_EGG, 1)
                .requires(ModItems.PHANTOM_WING.get())
                .unlockedBy(getHasName(ModItems.PHANTOM_WING.get()), has(ModItems.PHANTOM_WING.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "phantom_egg_from_phantom_wing"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.SHULKER_SPAWN_EGG, 1)
                .requires(ModItems.DISCOLORED_SHULKER_SHELL.get())
                .unlockedBy(getHasName(ModItems.DISCOLORED_SHULKER_SHELL.get()), has(ModItems.DISCOLORED_SHULKER_SHELL.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "shulker_egg_from_discolored_shulker_shell"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BLAZE_SPAWN_EGG, 1)
                .requires(ModItems.CHARGED_BLAZE_ROD.get())
                .unlockedBy(getHasName(ModItems.CHARGED_BLAZE_ROD.get()), has(ModItems.CHARGED_BLAZE_ROD.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "blaze_egg_from_charged_rod"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ENDERMAN_SPAWN_EGG, 1)
                .requires(ModItems.FLAWLESS_ENDER_PEARL.get())
                .unlockedBy(getHasName(ModItems.FLAWLESS_ENDER_PEARL.get()), has(ModItems.FLAWLESS_ENDER_PEARL.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "enderman_egg_from_flawless_pearl"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.WITHER_SKELETON_SPAWN_EGG, 1)
                .requires(ModItems.WITHER_SKELETON_BONE.get())
                .unlockedBy(getHasName(ModItems.WITHER_SKELETON_BONE.get()), has(ModItems.WITHER_SKELETON_BONE.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "wither_skeleton_egg_from_wither_skeleton_bone"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.EVOKER_SPAWN_EGG, 1)
                .requires(ModItems.RITUAL_BOOK.get())
                .unlockedBy(getHasName(ModItems.RITUAL_BOOK.get()), has(ModItems.RITUAL_BOOK.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "evoker_egg_from_ritual_book"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PIGLIN_BRUTE_SPAWN_EGG, 1)
                .requires(ModItems.AXE_HEAD.get())
                .unlockedBy(getHasName(ModItems.AXE_HEAD.get()), has(ModItems.AXE_HEAD.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "brute_egg_from_axe_head"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.VINDICATOR_SPAWN_EGG, 1)
                .requires(ModItems.BROKEN_AXE.get())
                .unlockedBy(getHasName(ModItems.BROKEN_AXE.get()), has(ModItems.BROKEN_AXE.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "vindicator_egg_from_broken_axe"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.WHEAT, 64)
                .requires(ModItems.PLENTIFUL_WHEAT.get())
                .unlockedBy(getHasName(ModItems.PLENTIFUL_WHEAT.get()), has(ModItems.PLENTIFUL_WHEAT.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "wheat_from_plentiful"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.COW_SPAWN_EGG, 1)
                .requires(ModItems.PLENTIFUL_WHEAT.get())
                .requires(Items.EGG)
                .unlockedBy(getHasName(ModItems.PLENTIFUL_WHEAT.get()), has(ModItems.PLENTIFUL_WHEAT.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "cow_egg_from_plentiful"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BEETROOT, 64)
                .requires(ModItems.ODD_SHAPED_BEETROOT.get())
                .unlockedBy(getHasName(ModItems.ODD_SHAPED_BEETROOT.get()), has(ModItems.ODD_SHAPED_BEETROOT.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "beetroot_from_odd_beetroot"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PIG_SPAWN_EGG, 1)
                .requires(ModItems.ODD_SHAPED_BEETROOT.get())
                .requires(Items.EGG)
                .unlockedBy(getHasName(ModItems.ODD_SHAPED_BEETROOT.get()), has(ModItems.ODD_SHAPED_BEETROOT.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "pig_egg_from_odd_beetroot"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CARROT, 64)
                .requires(ModItems.SMALL_CARROT.get())
                .unlockedBy(getHasName(ModItems.SMALL_CARROT.get()), has(ModItems.SMALL_CARROT.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "carrot_from_small_carrot"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CHICKEN_SPAWN_EGG, 1)
                .requires(ModItems.SMALL_CARROT.get())
                .requires(Items.EGG)
                .unlockedBy(getHasName(ModItems.SMALL_CARROT.get()), has(ModItems.SMALL_CARROT.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "chicken_spawn_egg_from_small_carrot"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.POTATO, 64)
                .requires(ModItems.ODD_SHAPED_POTATO.get())
                .unlockedBy(getHasName(ModItems.ODD_SHAPED_POTATO.get()), has(ModItems.ODD_SHAPED_POTATO.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "potato_from_odd_potato"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.SHEEP_SPAWN_EGG, 1)
                .requires(ModItems.ODD_SHAPED_POTATO.get())
                .requires(Items.EGG)
                .unlockedBy(getHasName(ModItems.ODD_SHAPED_POTATO.get()), has(ModItems.ODD_SHAPED_POTATO.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "sheep_egg_from_odd_potato"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.NETHER_WART, 64)
                .requires(ModItems.HUGE_NETHER_WART.get())
                .unlockedBy(getHasName(ModItems.HUGE_NETHER_WART.get()), has(ModItems.HUGE_NETHER_WART.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "wart_from_huge_wart"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PITCHER_POD, 10)
                .requires(ModItems.DISCOLORED_PITCHER_PLANT.get())
                .unlockedBy(getHasName(ModItems.DISCOLORED_PITCHER_PLANT.get()), has(ModItems.DISCOLORED_PITCHER_PLANT.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "pod_from_discolored_pitcher"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BEE_SPAWN_EGG, 1)
                .requires(ModItems.DISCOLORED_PITCHER_PLANT.get())
                .requires(Items.HONEY_BOTTLE)
                .unlockedBy(getHasName(ModItems.DISCOLORED_PITCHER_PLANT.get()), has(ModItems.DISCOLORED_PITCHER_PLANT.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "bee_egg_from_discolored_pitcher"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.TORCHFLOWER_SEEDS, 10)
                .requires(ModItems.BIOLUMINESCENT_TORCHFLOWER.get())
                .unlockedBy(getHasName(ModItems.BIOLUMINESCENT_TORCHFLOWER.get()), has(ModItems.BIOLUMINESCENT_TORCHFLOWER.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "torchflower_seeds_from_bio_torchflower"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BEE_SPAWN_EGG, 1)
                .requires(ModItems.BIOLUMINESCENT_TORCHFLOWER.get())
                .requires(Items.HONEY_BOTTLE)
                .unlockedBy(getHasName(ModItems.BIOLUMINESCENT_TORCHFLOWER.get()), has(ModItems.BIOLUMINESCENT_TORCHFLOWER.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "bee_egg_from_bio_torchflower"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.REINFORCED_DEEPSLATE, 10)
                .requires(ModItems.SCULK_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.SCULK_CRYSTAL.get()), has(ModItems.SCULK_CRYSTAL.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "reinforced_deepslate_from_sculk_crystal"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.DRAGON_BREATH, 25)
                .requires(ModItems.ENDER_DRAGON_SCALE.get())
                .unlockedBy(getHasName(ModItems.ENDER_DRAGON_SCALE.get()), has(ModItems.ENDER_DRAGON_SCALE.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "dragons_breath_from_ender_dragon_scale"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.WITHER_ROSE, 25)
                .requires(ModItems.SMOULDERING_STONE.get())
                .unlockedBy(getHasName(ModItems.SMOULDERING_STONE.get()), has(ModItems.SMOULDERING_STONE.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "wither_rose_from_smouldering_stone"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.SPIDER_SPAWN_EGG, 1)
                .requires(ModItems.SPIDER_FANG.get())
                .unlockedBy(getHasName(ModItems.SPIDER_FANG.get()), has(ModItems.SPIDER_FANG.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "spider_spawn_egg_from_spider_fang"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.DROWNED_SPAWN_EGG, 1)
                .requires(ModItems.SOAKED_FLESH.get())
                .unlockedBy(getHasName(ModItems.SOAKED_FLESH.get()), has(ModItems.SOAKED_FLESH.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "drowned_egg_from_soaked_flesh"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ZOMBIE_VILLAGER_SPAWN_EGG, 1)
                .requires(ModItems.SOAKED_FLESH.get())
                .requires(Items.EMERALD)
                .unlockedBy(getHasName(ModItems.SOAKED_FLESH.get()), has(ModItems.SOAKED_FLESH.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "zombie_villager_egg_from_soaked_flesh"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.HUSK_SPAWN_EGG, 1)
                .requires(ModItems.FLESH_JERKY.get())
                .unlockedBy(getHasName(ModItems.FLESH_JERKY.get()), has(ModItems.FLESH_JERKY.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "husk_egg_from_flesh_jerky"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ZOMBIE_VILLAGER_SPAWN_EGG, 1)
                .requires(ModItems.FLESH_JERKY.get())
                .requires(Items.EMERALD)
                .unlockedBy(getHasName(ModItems.FLESH_JERKY.get()), has(ModItems.FLESH_JERKY.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "zombie_villager_egg_from_flesh_jerky"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ZOMBIE_SPAWN_EGG, 1)
                .requires(ModItems.NOT_SO_ROTTEN_FLESH.get())
                .unlockedBy(getHasName(ModItems.NOT_SO_ROTTEN_FLESH.get()), has(ModItems.NOT_SO_ROTTEN_FLESH.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "zombie_egg_from_not_so_rotten_flesh"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ZOMBIE_VILLAGER_SPAWN_EGG, 1)
                .requires(ModItems.NOT_SO_ROTTEN_FLESH.get())
                .requires(Items.EMERALD)
                .unlockedBy(getHasName(ModItems.NOT_SO_ROTTEN_FLESH.get()), has(ModItems.NOT_SO_ROTTEN_FLESH.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "zombie_villager_egg_from_not_so_rotten_flesh"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BEDROCK, 10)
                .requires(ModItems.ENDERMITE_EGG.get())
                .unlockedBy(getHasName(ModItems.ENDERMITE_EGG.get()), has(ModItems.ENDERMITE_EGG.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "bedrock_from_endermite_egg"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PILLAGER_SPAWN_EGG, 1)
                .requires(ModItems.DAMAGED_CROSSBOW.get())
                .unlockedBy(getHasName(ModItems.DAMAGED_CROSSBOW.get()), has(ModItems.DAMAGED_CROSSBOW.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "pillager_spawn_egg_from_damaged_crossbow"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.WITCH_SPAWN_EGG, 1)
                .requires(ModItems.WITCHS_BREW.get())
                .unlockedBy(getHasName(ModItems.WITCHS_BREW.get()), has(ModItems.WITCHS_BREW.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "witch_egg_from_witchs_brew"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.WANDERING_TRADER_SPAWN_EGG, 1)
                .requires(ModItems.RAVAGER_HORN.get())
                .unlockedBy(getHasName(ModItems.RAVAGER_HORN.get()), has(ModItems.RAVAGER_HORN.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "trader_egg_from_ravager_horn"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.WANDERING_TRADER_SPAWN_EGG, 1)
                .requires(ModItems.SHRIEKER_NOISE_BOX.get())
                .unlockedBy(getHasName(ModItems.SHRIEKER_NOISE_BOX.get()), has(ModItems.SHRIEKER_NOISE_BOX.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "wandering_trader_spawn_egg_from_noise_box"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.WANDERING_TRADER_SPAWN_EGG, 1)
                .requires(ModItems.SENSOR_TENDRIL.get())
                .unlockedBy(getHasName(ModItems.SENSOR_TENDRIL.get()), has(ModItems.SENSOR_TENDRIL.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "wandering_trader_spawn_egg_from_tendril"));

        //gems and gem blocks
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OPAL.get(), 9)
                .requires(ModBlocks.OPAL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.OPAL_BLOCK.get()), has(ModBlocks.OPAL_BLOCK.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.OPAL_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.OPAL.get())
                .unlockedBy(getHasName(ModItems.OPAL.get()), has(ModItems.OPAL.get()))
                .save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.JADE.get(), 9)
                .requires(ModBlocks.JADE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.JADE_BLOCK.get()), has(ModBlocks.JADE_BLOCK.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.JADE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.JADE.get())
                .unlockedBy(getHasName(ModItems.JADE.get()), has(ModItems.JADE.get()))
                .save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBY.get(), 9)
                .requires(ModBlocks.RUBY_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RUBY_BLOCK.get()), has(ModBlocks.RUBY_BLOCK.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
                .save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.QUARTZ, 9)
                .requires(ModBlocks.BIG_QUARTZ_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.BIG_QUARTZ_BLOCK.get()), has(ModBlocks.BIG_QUARTZ_BLOCK.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BIG_QUARTZ_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', Items.QUARTZ)
                .unlockedBy(getHasName(Items.QUARTZ), has(Items.QUARTZ))
                .save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.AMETHYST_SHARD, 9)
                .requires(ModBlocks.BIG_AMETHYST_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.BIG_AMETHYST_BLOCK.get()), has(ModBlocks.BIG_AMETHYST_BLOCK.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BIG_AMETHYST_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ECHO_SHARD, 9)
                .requires(ModBlocks.ECHO_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ECHO_BLOCK.get()), has(ModBlocks.ECHO_BLOCK.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ECHO_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', Items.ECHO_SHARD)
                .unlockedBy(getHasName(Items.ECHO_SHARD), has(Items.ECHO_SHARD))
                .save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ONYX.get(), 9)
                .requires(ModBlocks.ONYX_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ONYX_BLOCK.get()), has(ModBlocks.ONYX_BLOCK.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ONYX_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.ONYX.get())
                .unlockedBy(getHasName(ModItems.ONYX.get()), has(ModItems.ONYX.get()))
                .save(pRecipeOutput);

        //opal tools
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OPAL_SWORD.get())
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.OPAL.get())
                .unlockedBy(getHasName(ModItems.OPAL_SWORD.get()), has(ModItems.OPAL.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OPAL_SHOVEL.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.OPAL.get())
                .unlockedBy(getHasName(ModItems.OPAL_SHOVEL.get()), has(ModItems.OPAL.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OPAL_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('P', ModItems.OPAL.get())
                .unlockedBy(getHasName(ModItems.OPAL_PICKAXE.get()), has(ModItems.OPAL.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OPAL_AXE.get())
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.OPAL.get())
                .unlockedBy(getHasName(ModItems.OPAL_AXE.get()), has(ModItems.OPAL.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OPAL_HOE.get())
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.OPAL.get())
                .unlockedBy(getHasName(ModItems.OPAL_HOE.get()), has(ModItems.OPAL.get()))
                .save(pRecipeOutput);

        //jade tools
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JADE_SWORD.get())
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.JADE.get())
                .unlockedBy(getHasName(ModItems.JADE_SWORD.get()), has(ModItems.JADE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JADE_SHOVEL.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.JADE.get())
                .unlockedBy(getHasName(ModItems.JADE_SHOVEL.get()), has(ModItems.JADE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JADE_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('P', ModItems.JADE.get())
                .unlockedBy(getHasName(ModItems.JADE_PICKAXE.get()), has(ModItems.JADE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JADE_AXE.get())
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.JADE.get())
                .unlockedBy(getHasName(ModItems.JADE_AXE.get()), has(ModItems.JADE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JADE_HOE.get())
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.JADE.get())
                .unlockedBy(getHasName(ModItems.JADE_HOE.get()), has(ModItems.JADE.get()))
                .save(pRecipeOutput);

        //sapphire tools
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_SWORD.get())
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE_SWORD.get()), has(ModItems.SAPPHIRE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_SHOVEL.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE_SHOVEL.get()), has(ModItems.SAPPHIRE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('P', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE_PICKAXE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_AXE.get())
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE_AXE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_HOE.get())
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE_HOE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pRecipeOutput);

        //emerald tools
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_SWORD.get())
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', Items.EMERALD)
                .unlockedBy(getHasName(ModItems.EMERALD_SWORD.get()), has(Items.EMERALD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_SHOVEL.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', Items.EMERALD)
                .unlockedBy(getHasName(ModItems.EMERALD_SHOVEL.get()), has(Items.EMERALD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('P', Items.EMERALD)
                .unlockedBy(getHasName(ModItems.EMERALD_PICKAXE.get()), has(Items.EMERALD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_AXE.get())
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', Items.EMERALD)
                .unlockedBy(getHasName(ModItems.EMERALD_AXE.get()), has(Items.EMERALD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_HOE.get())
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', Items.EMERALD)
                .unlockedBy(getHasName(ModItems.EMERALD_HOE.get()), has(Items.EMERALD))
                .save(pRecipeOutput);

        //ruby tools
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_SWORD.get())
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY_SWORD.get()), has(ModItems.RUBY.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_SHOVEL.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY_SHOVEL.get()), has(ModItems.RUBY.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('P', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY_PICKAXE.get()), has(ModItems.RUBY.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_AXE.get())
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY_AXE.get()), has(ModItems.RUBY.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_HOE.get())
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY_HOE.get()), has(ModItems.RUBY.get()))
                .save(pRecipeOutput);

        //quartz tools
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.QUARTZ_SWORD.get())
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', Items.QUARTZ)
                .unlockedBy(getHasName(Items.QUARTZ), has(Items.QUARTZ))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.QUARTZ_SHOVEL.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', Items.QUARTZ)
                .unlockedBy(getHasName(Items.QUARTZ), has(Items.QUARTZ))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.QUARTZ_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('P', Items.QUARTZ)
                .unlockedBy(getHasName(Items.QUARTZ), has(Items.QUARTZ))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.QUARTZ_AXE.get())
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', Items.QUARTZ)
                .unlockedBy(getHasName(Items.QUARTZ), has(Items.QUARTZ))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.QUARTZ_HOE.get())
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', Items.QUARTZ)
                .unlockedBy(getHasName(Items.QUARTZ), has(Items.QUARTZ))
                .save(pRecipeOutput);

        //amethyst tools
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AMETHYST_SWORD.get())
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AMETHYST_SHOVEL.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AMETHYST_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('P', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AMETHYST_AXE.get())
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AMETHYST_HOE.get())
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pRecipeOutput);

        //echo tools
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ECHO_SWORD.get())
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', Items.ECHO_SHARD)
                .unlockedBy(getHasName(Items.ECHO_SHARD), has(Items.ECHO_SHARD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ECHO_SHOVEL.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('S', Items.STICK)
                .define('P', Items.ECHO_SHARD)
                .unlockedBy(getHasName(Items.ECHO_SHARD), has(Items.ECHO_SHARD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ECHO_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('P', Items.ECHO_SHARD)
                .unlockedBy(getHasName(Items.ECHO_SHARD), has(Items.ECHO_SHARD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ECHO_AXE.get())
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', Items.ECHO_SHARD)
                .unlockedBy(getHasName(Items.ECHO_SHARD), has(Items.ECHO_SHARD))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ECHO_HOE.get())
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .define('S', Items.STICK)
                .define('P', Items.ECHO_SHARD)
                .unlockedBy(getHasName(Items.ECHO_SHARD), has(Items.ECHO_SHARD))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ONYX_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("DPD")
                .pattern("DED")
                .pattern("DDD")
                .define('E', Items.NETHERITE_INGOT)
                .define('P', ModItems.ONYX_UPGRADE_SMITHING_TEMPLATE.get())
                .define('D', Items.DIAMOND)
                .unlockedBy(getHasName(ModItems.ONYX_UPGRADE_SMITHING_TEMPLATE.get()), has(ModItems.ONYX_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("DPD")
                .pattern("DSD")
                .pattern("DDD")
                .define('S', Items.OBSIDIAN)
                .define('P', ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get())
                .define('D', Items.DIAMOND)
                .unlockedBy(getHasName(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get()), has(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pRecipeOutput);

        //arrows
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ARROW, 2)
                .pattern(" P ")
                .pattern(" S ")
                .pattern(" D ")
                .define('P', ModItems.OPAL.get())
                .define('S', Items.STICK)
                .define('D', Items.FEATHER)
                .unlockedBy(getHasName(Items.ARROW), has(ModItems.OPAL.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "arrow_from_opal"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ARROW, 3)
                .pattern(" P ")
                .pattern(" S ")
                .pattern(" D ")
                .define('P', ModItems.JADE.get())
                .define('S', Items.STICK)
                .define('D', Items.FEATHER)
                .unlockedBy(getHasName(Items.ARROW), has(ModItems.JADE.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "arrow_from_jade"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_ARROW.get(), 5)
                .pattern(" P ")
                .pattern(" S ")
                .pattern(" D ")
                .define('P', ModItems.SAPPHIRE.get())
                .define('S', Items.STICK)
                .define('D', Items.FEATHER)
                .unlockedBy(getHasName(ModItems.SAPPHIRE_ARROW.get()), has(ModItems.SAPPHIRE.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "arrow_from_sapphire"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_ARROW.get(), 5)
                .pattern(" P ")
                .pattern(" S ")
                .pattern(" D ")
                .define('P', Items.EMERALD)
                .define('S', Items.STICK)
                .define('D', Items.FEATHER)
                .unlockedBy(getHasName(ModItems.EMERALD_ARROW.get()), has(Items.EMERALD))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "arrow_from_emerald"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_ARROW.get(), 7)
                .pattern(" P ")
                .pattern(" S ")
                .pattern(" D ")
                .define('P', ModItems.RUBY.get())
                .define('S', Items.STICK)
                .define('D', Items.FEATHER)
                .unlockedBy(getHasName(ModItems.RUBY_ARROW.get()), has(ModItems.RUBY.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "arrow_from_ruby"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_ARROW.get(), 8)
                .pattern(" P ")
                .pattern(" S ")
                .pattern(" D ")
                .define('P', Items.DIAMOND)
                .define('S', Items.STICK)
                .define('D', Items.FEATHER)
                .unlockedBy(getHasName(ModItems.DIAMOND_ARROW.get()), has(Items.DIAMOND))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "arrow_from_diamond"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ONYX_ARROW.get(), 10)
                .pattern(" P ")
                .pattern(" S ")
                .pattern(" D ")
                .define('P', ModItems.ONYX.get())
                .define('S', Items.STICK)
                .define('D', Items.FEATHER)
                .unlockedBy(getHasName(ModItems.ONYX_ARROW.get()), has(ModItems.ONYX.get()))
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "arrow_from_onyx"));


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
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_nether_essence"));
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
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_end_essence"));
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
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_sculk_essence"));
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
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_spider_essence"));
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
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_evil_essence"));
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
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_ocean_essence"));
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
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_fire_essence"));
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
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_explosive_essence"));
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
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_nature_essence"));
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
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_blood_essence"));
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
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_resolute_essence"));
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
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_tough_essence"));
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
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_resilient_essence"));
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
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "pure_resistant_essence"));

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
                .save(pRecipeOutput, new ResourceLocation(EndGameEnhanced.MOD_ID, "spider_essence"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DRENCHED_ESSENCE.get())
                .pattern("ABA")
                .pattern("DCE")
                .pattern("AFA")
                .define('A', Items.BLUE_ICE)
                .define('B', ModItems.SOAKED_FLESH.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', ModItems.GUARDIAN_SPIKE.get())
                .define('E', ModItems.ELDER_GUARDIAN_SPIKE.get())
                .define('F', Items.CONDUIT)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MINESHAFT_ESSENCE.get())
                .pattern("ABA")
                .pattern("DCD")
                .pattern("ABA")
                .define('A', Items.COBWEB)
                .define('B', Items.RAIL)
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', Items.MINECART)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.VOLATILE_ESSENCE.get())
                .pattern("ABD")
                .pattern(" C ")
                .pattern("E F")
                .define('A', ModItems.RIB_BONE.get())
                .define('B', ModItems.SMOULDERING_STONE.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', ModItems.CHARGED_BLAZE_ROD.get())
                .define('E', ModItems.GHAST_TENTACLE.get())
                .define('F', ModItems.FROZEN_BONE.get())
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CORRUPTING_ESSENCE.get())
                .pattern("ABD")
                .pattern(" C ")
                .pattern("E F")
                .define('A', ModItems.NOT_SO_ROTTEN_FLESH.get())
                .define('B', ModItems.SCULK_CRYSTAL.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', ModItems.AXE_HEAD.get())
                .define('E', ModItems.HOGLIN_TUSK.get())
                .define('F', ModItems.FLESH_JERKY.get())
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PRISMATIC_ESSENCE.get())
                .pattern("ABD")
                .pattern(" C ")
                .pattern("E F")
                .define('A', ModItems.CREEPER_FUSE.get())
                .define('B', ModItems.ENDER_DRAGON_SCALE.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', ModItems.RITUAL_BOOK.get())
                .define('E', ModItems.WITCHS_BREW.get())
                .define('F', Items.CREEPER_HEAD)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SCULK_ESSENCE.get())
                .pattern("ABA")
                .pattern("DCD")
                .pattern("AEA")
                .define('A', Items.SCULK)
                .define('B', Items.SCULK_SENSOR)
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', Items.SCULK_CATALYST)
                .define('E', Items.SCULK_SHRIEKER)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OCEAN_ESSENCE.get())
                .pattern("ABD")
                .pattern("ECE")
                .pattern("DFA")
                .define('A', Items.PRISMARINE)
                .define('B', Items.SEA_LANTERN)
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', Items.DARK_PRISMARINE)
                .define('E', Items.SPONGE)
                .define('F', Items.GOLD_BLOCK)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SMOULDERING_ESSENCE.get())
                .pattern(" A ")
                .pattern(" C ")
                .pattern("B D")
                .define('A', ModItems.MAGMA_BUTTER.get())
                .define('B', ModItems.PIGLINS_GOLD_COIN.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', ModItems.WITHER_SKELETON_BONE.get())
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.VOIDED_ESSENCE.get())
                .pattern("ABD")
                .pattern(" C ")
                .pattern("E F")
                .define('B', ModItems.DISCOLORED_SHULKER_SHELL.get())
                .define('A', Items.DRAGON_BREATH)
                .define('C', ModItems.BASIC_ESSENCE.get())
                .define('D', Items.DRAGON_HEAD)
                .define('E', ModItems.FLAWLESS_ENDER_PEARL.get())
                .define('F', ModItems.ENDERMITE_EGG.get())
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PILLAGED_ESSENCE.get())
                .pattern(" A ")
                .pattern(" C ")
                .pattern(" B ")
                .define('B', ModItems.RAVAGER_HORN.get())
                .define('A', ModItems.DAMAGED_CROSSBOW.get())
                .define('C', ModItems.BASIC_ESSENCE.get())
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NETHER_ESSENCE.get())
                .pattern("BCD")
                .pattern("EAF")
                .pattern("GHI")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', Items.SOUL_SAND)
                .define('C', ModItems.HUGE_NETHER_WART.get())
                .define('D', Items.QUARTZ_BLOCK)
                .define('E', Items.NETHERRACK)
                .define('F', Items.BLACKSTONE)
                .define('G', Items.NETHER_BRICKS)
                .define('H', Items.GOLD_BLOCK)
                .define('I', Items.MAGMA_BLOCK)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.END_ESSENCE.get())
                .pattern("BCD")
                .pattern("EAF")
                .pattern("GHG")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', Items.POPPED_CHORUS_FRUIT)
                .define('C', Items.END_STONE)
                .define('D', Items.CHORUS_FLOWER)
                .define('E', Items.PURPUR_BLOCK)
                .define('F', Items.END_ROD)
                .define('G', Items.END_CRYSTAL)
                .define('H', Items.DRAGON_HEAD)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ANCIENT_ESSENCE.get())
                .pattern("BCB")
                .pattern("EAF")
                .pattern("GHD")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', Items.SOUL_LANTERN)
                .define('C', Items.SCULK)
                .define('D', Items.DEEPSLATE)
                .define('E', Items.DEEPSLATE_BRICKS)
                .define('F', Items.CHISELED_DEEPSLATE)
                .define('G', Items.DEEPSLATE_TILES)
                .define('H', Items.POLISHED_DEEPSLATE)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WARNING_ESSENCE.get())
                .pattern("DBD")
                .pattern("DAD")
                .pattern("DCD")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', ModItems.SHRIEKER_NOISE_BOX.get())
                .define('C', ModItems.SENSOR_TENDRIL.get())
                .define('D', Items.ECHO_SHARD)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LAVA_ESSENCE.get())
                .pattern("DBD")
                .pattern("CAC")
                .pattern("DBD")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', Items.MAGMA_CREAM)
                .define('C', Items.OBSIDIAN)
                .define('D', Items.MAGMA_BLOCK)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DARKNESS_ESSENCE.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', Items.BLACK_CONCRETE)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WATER_ESSENCE.get())
                .pattern("BCD")
                .pattern("EAE")
                .pattern("DCB")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', Items.COD)
                .define('C', Items.TROPICAL_FISH)
                .define('D', Items.SALMON)
                .define('E', Items.PUFFERFISH)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ORE_ESSENCE.get())
                .pattern("BCD")
                .pattern("EAF")
                .pattern("GHI")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', Items.DEEPSLATE_EMERALD_ORE)
                .define('C', Items.DEEPSLATE_DIAMOND_ORE)
                .define('D', Items.DEEPSLATE_REDSTONE_ORE)
                .define('E', Items.DEEPSLATE_LAPIS_ORE)
                .define('F', Items.DEEPSLATE_IRON_ORE)
                .define('G', Items.DEEPSLATE_GOLD_ORE)
                .define('H', Items.DEEPSLATE_COPPER_ORE)
                .define('I', Items.DEEPSLATE_COAL_ORE)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GEM_ESSENCE.get())
                .pattern("BCD")
                .pattern("EAF")
                .pattern("GHI")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', ModBlocks.OPAL_BLOCK.get())
                .define('C', ModBlocks.JADE_BLOCK.get())
                .define('D', ModBlocks.SAPPHIRE_BLOCK.get())
                .define('E', ModBlocks.RUBY_BLOCK.get())
                .define('F', Items.EMERALD_BLOCK)
                .define('G', Items.DIAMOND_BLOCK)
                .define('H', Items.AMETHYST_BLOCK)
                .define('I', Items.LAPIS_BLOCK)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TREE_ESSENCE.get())
                .pattern("BCD")
                .pattern("EAF")
                .pattern("GHI")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', Items.OAK_LOG)
                .define('C', Items.SPRUCE_LOG)
                .define('D', Items.BIRCH_LOG)
                .define('E', Items.JUNGLE_LOG)
                .define('F', Items.ACACIA_LOG)
                .define('G', Items.DARK_OAK_LOG)
                .define('H', Items.MANGROVE_LOG)
                .define('I', Items.CHERRY_LOG)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HARVEST_ESSENCE.get())
                .pattern("BDC")
                .pattern("BAC")
                .pattern("BEC")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', Items.PUMPKIN)
                .define('C', Items.MELON)
                .define('D', ModBlocks.GOLDEN_MELON.get())
                .define('E', ModBlocks.WHITE_PUMPKIN.get())
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SMALL_PLANT_ESSENCE.get())
                .pattern("BCD")
                .pattern(" A ")
                .pattern("ECF")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', ModItems.PLENTIFUL_WHEAT.get())
                .define('C', ModItems.BIOLUMINESCENT_TORCHFLOWER.get())
                .define('D', ModItems.ODD_SHAPED_POTATO.get())
                .define('E', ModItems.SMALL_CARROT.get())
                .define('F', ModItems.ODD_SHAPED_BEETROOT.get())
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TALL_PLANT_ESSENCE.get())
                .pattern("BDC")
                .pattern("EAE")
                .pattern("BDC")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', Items.SUGAR_CANE)
                .define('C', Items.CACTUS)
                .define('D', Items.BAMBOO)
                .define('E', ModItems.DISCOLORED_PITCHER_PLANT.get())
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EARTHLY_ESSENCE.get())
                .pattern("BCD")
                .pattern("EAF")
                .pattern("GHI")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', Items.GRASS_BLOCK)
                .define('C', Items.MUD)
                .define('D', Items.MYCELIUM)
                .define('E', Items.PODZOL)
                .define('F', Items.DIRT)
                .define('G', Items.SAND)
                .define('H', Items.RED_SAND)
                .define('I', Items.GRAVEL)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SECLUDED_ESSENCE.get())
                .pattern(" B ")
                .pattern(" A ")
                .pattern("C D")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', ModItems.BROKEN_AXE.get())
                .define('C', ModItems.SLIME_GLOB.get())
                .define('D', ModItems.PHANTOM_WING.get())
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EXPLOSIVE_ESSENCE.get())
                .pattern("CBC")
                .pattern("BAB")
                .pattern("CBC")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', Items.TNT)
                .define('C', Items.GUNPOWDER)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TOUGHNESS_ESSENCE.get())
                .pattern("CBC")
                .pattern("DAD")
                .pattern("CBC")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', Items.CRYING_OBSIDIAN)
                .define('C', Items.SCUTE)
                .define('D', Items.OBSIDIAN)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SPEED_ESSENCE.get())
                .pattern("CBC")
                .pattern("DAD")
                .pattern("DDD")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', Items.ELYTRA)
                .define('C', Items.MAGMA_CREAM)
                .define('D', Items.SUGAR)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BOOST_ESSENCE.get())
                .pattern("CBC")
                .pattern("DAD")
                .pattern("DDD")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', Items.ELYTRA)
                .define('C', Items.MAGMA_CREAM)
                .define('D', Items.RABBIT_FOOT)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.VISION_ESSENCE.get())
                .pattern("CBC")
                .pattern("DAD")
                .pattern("DDD")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', Items.ELYTRA)
                .define('C', Items.MAGMA_CREAM)
                .define('D', Items.GOLDEN_CARROT)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CONDUIT_ESSENCE.get())
                .pattern("CBC")
                .pattern("DAD")
                .pattern("EFE")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', Items.ELYTRA)
                .define('C', Items.MAGMA_CREAM)
                .define('D', Items.HEART_OF_THE_SEA)
                .define('E', Items.NAUTILUS_SHELL)
                .define('F', Items.CONDUIT)
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.INFERNAL_ESSENCE.get())
                .pattern(" B ")
                .pattern(" A ")
                .pattern("C D")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', ModItems.MAGMA_BUTTER.get())
                .define('C', ModItems.ELDER_GUARDIAN_SPIKE.get())
                .define('D', ModItems.WITHER_SKELETON_BONE.get())
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.UNKEMPT_ESSENCE.get())
                .pattern(" B ")
                .pattern(" A ")
                .pattern("C D")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', ModItems.SPIDER_FANG.get())
                .define('C', ModItems.DISCOLORED_SHULKER_SHELL.get())
                .define('D', ModItems.WITHER_SKELETON_BONE.get())
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SANGUINE_ESSENCE.get())
                .pattern(" B ")
                .pattern(" A ")
                .pattern("C D")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', ModItems.SLIME_GLOB.get())
                .define('C', ModItems.CAVE_SPIDER_EYE.get())
                .define('D', ModItems.WITHER_SKELETON_BONE.get())
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BREACH_ESSENCE.get())
                .pattern(" B ")
                .pattern(" A ")
                .pattern("C D")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', ModItems.MAGMA_BUTTER.get())
                .define('C', ModItems.PHANTOM_WING.get())
                .define('D', ModItems.FLAWLESS_ENDER_PEARL.get())
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STABILIZED_ESSENCE.get())
                .pattern(" B ")
                .pattern(" A ")
                .pattern("C D")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', ModItems.SLIME_GLOB.get())
                .define('C', ModItems.DAMAGED_CROSSBOW.get())
                .define('D', ModItems.FLAWLESS_ENDER_PEARL.get())
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SWIFT_ESSENCE.get())
                .pattern(" B ")
                .pattern(" A ")
                .pattern("C D")
                .define('A', ModItems.BASIC_ESSENCE.get())
                .define('B', ModItems.SPIDER_FANG.get())
                .define('C', ModItems.PIGLINS_GOLD_COIN.get())
                .define('D', ModItems.FLAWLESS_ENDER_PEARL.get())
                .unlockedBy(getHasName(ModItems.BASIC_ESSENCE.get()), has(ModItems.BASIC_ESSENCE.get()))
                .save(pRecipeOutput);

        //misc
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SPAWNER)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.NETHER_STAR)
                .define('B', Items.IRON_BARS)
                .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                .save(pRecipeOutput);
        

        netheriteSmithing(pRecipeOutput, ModItems.VOIDWAKER_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_SWORD, ModItems.PURE_END_ESSENCE.get(), RecipeCategory.MISC, ModItems.VOIDWAKER.get());
        netheriteSmithing(pRecipeOutput, ModItems.NETHERRATH_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_SWORD, ModItems.PURE_NETHER_ESSENCE.get(), RecipeCategory.MISC, ModItems.NETHERRATH.get());
        netheriteSmithing(pRecipeOutput, ModItems.SCULK_BRINGER_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_SWORD, ModItems.PURE_SCULK_ESSENCE.get(), RecipeCategory.MISC, ModItems.SCULK_BRINGER.get());
        netheriteSmithing(pRecipeOutput, ModItems.SCULK_SLINGER_UPGRADE_SMITHING_TEMPLATE.get(), Items.CROSSBOW, ModItems.PURE_EVIL_ESSENCE.get(), RecipeCategory.MISC, ModItems.SCULK_SLINGER.get());
        netheriteSmithing(pRecipeOutput, ModItems.WEBWEAVER_UPGRADE_SMITHING_TEMPLATE.get(), Items.BOW, ModItems.PURE_SPIDER_ESSENCE.get(), RecipeCategory.MISC, ModItems.WEBWEAVER_BOW.get());
        netheriteSmithing(pRecipeOutput, ModItems.TIDE_BREAKER_UPGRADE_SMITHING_TEMPLATE.get(), Items.TRIDENT, ModItems.PURE_OCEAN_ESSENCE.get(), RecipeCategory.MISC, ModItems.TIDE_BREAKER.get());
        netheriteSmithing(pRecipeOutput, ModItems.INFERNAL_PICKAXE_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_PICKAXE, ModItems.PURE_FIRE_ESSENCE.get(), RecipeCategory.MISC, ModItems.INFERNAL_PICKAXE.get());
        netheriteSmithing(pRecipeOutput, ModItems.UNKEMPT_HAROLD_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_SHOVEL, ModItems.PURE_EXPLOSIVE_ESSENCE.get(), RecipeCategory.MISC, ModItems.UNKEMPT_HAROLD.get());
        netheriteSmithing(pRecipeOutput, ModItems.LEVIATHANS_AXE_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_AXE, ModItems.PURE_NATURE_ESSENCE.get(), RecipeCategory.MISC, ModItems.LEVIATHANS_AXE.get());
        netheriteSmithing(pRecipeOutput, ModItems.SCYTHE_OF_VITUR_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_HOE, ModItems.PURE_BLOOD_ESSENCE.get(), RecipeCategory.MISC, ModItems.SCYTHE_OF_VITUR.get());
        netheriteSmithing(pRecipeOutput, ModItems.OBSIDIAN_ARMOR_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_HELMET, ModItems.PURE_RESOLUTE_ESSENCE.get(), RecipeCategory.MISC, ModItems.INEVITABLE_HELMET.get());
        netheriteSmithing(pRecipeOutput, ModItems.OBSIDIAN_ARMOR_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_CHESTPLATE, ModItems.PURE_TOUGH_ESSENCE.get(), RecipeCategory.MISC, ModItems.INEVITABLE_CHESTPLATE.get());
        netheriteSmithing(pRecipeOutput, ModItems.OBSIDIAN_ARMOR_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_LEGGINGS, ModItems.PURE_RESILIENT_ESSENCE.get(), RecipeCategory.MISC, ModItems.INEVITABLE_LEGGINGS.get());
        netheriteSmithing(pRecipeOutput, ModItems.OBSIDIAN_ARMOR_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_BOOTS, ModItems.PURE_RESISTANT_ESSENCE.get(), RecipeCategory.MISC, ModItems.INEVITABLE_BOOTS.get());

    }


    protected static void netheriteSmithing(RecipeOutput pRecipeOutput, Item modTemplate, Item itemToUpgrade, Item itemToUpgradeWith, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(modTemplate), Ingredient.of(itemToUpgrade), Ingredient.of(itemToUpgradeWith), pCategory, pResultItem).unlocks("has_netherite_ingot", has(itemToUpgradeWith)).save(pRecipeOutput, getItemName(pResultItem) + "_smithing");
    }
}
