package net.Lucas.tutorialmod.datagen;

import net.Lucas.tutorialmod.TutorialMod;
import net.Lucas.tutorialmod.item.ModItems;
import net.Lucas.tutorialmod.loot.AddItemModifier;
import net.Lucas.tutorialmod.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, TutorialMod.MOD_ID);
    }

    @Override
    protected void start() {
//        add("raw_sapphire_from_coal_ore", new AddItemModifier(new LootItemCondition[]{
//                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.COAL_ORE).build(),
//                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.RAW_SAPPHIRE.get()));
//
//        add("raw_sapphire_from_zombie", new AddItemModifier(new LootItemCondition[]{
//                LootTableIdCondition.builder(new ResourceLocation("entities/zombie")).build(),
//        LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.RAW_SAPPHIRE.get()));


        //opal
        add("opal_from_coal_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.COAL_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.OPAL.get()));
        add("opal_from_stone", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STONE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 10F)).build()}, ModItems.OPAL.get()));
        add("opal_from_copper_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.COPPER_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.OPAL.get()));
        add("opal_from_diamond_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DIAMOND_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.OPAL.get()));
        add("opal_from_emerald_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.EMERALD_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.OPAL.get()));
        add("opal_from_gold_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GOLD_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.OPAL.get()));
        add("opal_from_iron_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.IRON_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.OPAL.get()));
        add("opal_from_lapis_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.LAPIS_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.OPAL.get()));
        add("opal_from_quartz_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.NETHER_QUARTZ_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.OPAL.get()));
        add("opal_from_redstone_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.REDSTONE_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.OPAL.get()));

        //jade
        add("jade_from_coal_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.COAL_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 10F)).build()}, ModItems.JADE.get()));
        add("jade_from_stone", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STONE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 25F)).build()}, ModItems.JADE.get()));
        add("jade_from_copper_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.COPPER_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 10F)).build()}, ModItems.JADE.get()));
        add("jade_from_diamond_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DIAMOND_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 10F)).build()}, ModItems.JADE.get()));
        add("jade_from_emerald_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.EMERALD_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 10F)).build()}, ModItems.JADE.get()));
        add("jade_from_gold_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GOLD_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 10F)).build()}, ModItems.JADE.get()));
        add("jade_from_iron_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.IRON_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 10F)).build()}, ModItems.JADE.get()));
        add("jade_from_lapis_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.LAPIS_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 10F)).build()}, ModItems.JADE.get()));
        add("jade_from_quartz_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.NETHER_QUARTZ_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 10F)).build()}, ModItems.JADE.get()));
        add("jade_from_redstone_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.REDSTONE_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 10F)).build()}, ModItems.JADE.get()));

        //sapphire
        add("sapphire_from_coal_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.COAL_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 50F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_stone", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STONE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 150F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_copper_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.COPPER_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 50F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_diamond_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DIAMOND_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 50F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_emerald_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.EMERALD_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 50F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_gold_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GOLD_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 50F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_iron_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.IRON_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 50F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_lapis_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.LAPIS_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 50F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_quartz_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.NETHER_QUARTZ_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 50F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_redstone_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.REDSTONE_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 50F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_deepslate_coal_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_COAL_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_deepslate", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 30F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_deepslate_copper_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_COPPER_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_deepslate_diamond_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_DIAMOND_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_deepslate_emerald_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_EMERALD_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_deepslate_gold_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_GOLD_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_deepslate_iron_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_IRON_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_deepslate_lapis_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_LAPIS_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_deepslate_redstone_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_REDSTONE_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_zombie", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/zombie")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 20F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_spider", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/spider")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 20F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_skeleton", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/skeleton")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 20F)).build()}, ModItems.SAPPHIRE.get()));
        add("sapphire_from_creeper", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/creeper")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 20F)).build()}, ModItems.SAPPHIRE.get()));


        //emerald
        add("emerald_from_coal_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.COAL_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 100F)).build()}, Items.EMERALD));
        add("emerald_from_copper_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.COPPER_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 100F)).build()}, Items.EMERALD));
        add("emerald_from_diamond_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DIAMOND_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 100F)).build()}, Items.EMERALD));
        add("emerald_from_emerald_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.EMERALD_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 100F)).build()}, Items.EMERALD));
        add("emerald_from_gold_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GOLD_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 100F)).build()}, Items.EMERALD));
        add("emerald_from_iron_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.IRON_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 100F)).build()}, Items.EMERALD));
        add("emerald_from_lapis_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.LAPIS_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 100F)).build()}, Items.EMERALD));
        add("emerald_from_quartz_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.NETHER_QUARTZ_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 100F)).build()}, Items.EMERALD));
        add("emerald_from_redstone_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.REDSTONE_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 100F)).build()}, Items.EMERALD));
        add("emerald_from_deepslate_coal_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_COAL_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 15F)).build()}, Items.EMERALD));
        add("emerald_from_deepslate", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 50F)).build()}, Items.EMERALD));
        add("emerald_from_deepslate_copper_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_COPPER_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 15F)).build()}, Items.EMERALD));
        add("emerald_from_deepslate_diamond_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_DIAMOND_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 15F)).build()}, Items.EMERALD));
        add("emerald_from_deepslate_emerald_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_EMERALD_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 15F)).build()}, Items.EMERALD));
        add("emerald_from_deepslate_gold_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_GOLD_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 15F)).build()}, Items.EMERALD));
        add("emerald_from_deepslate_iron_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_IRON_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 15F)).build()}, Items.EMERALD));
        add("emerald_from_deepslate_lapis_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_LAPIS_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 15F)).build()}, Items.EMERALD));
        add("emerald_from_deepslate_redstone_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_REDSTONE_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 15F)).build()}, Items.EMERALD));
        add("emerald_from_zombie", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/zombie")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 100F)).build()}, Items.EMERALD));
        add("emerald_from_spider", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/spider")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 100F)).build()}, Items.EMERALD));
        add("emerald_from_skeleton", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/skeleton")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 100F)).build()}, Items.EMERALD));
        add("emerald_from_creeper", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/creeper")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 100F)).build()}, Items.EMERALD));

        //ruby
        add("ruby_from_deepslate_coal_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_COAL_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 25F)).build()}, ModItems.RUBY.get()));
        add("ruby_from_deepslate", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 100F)).build()}, ModItems.RUBY.get()));
        add("ruby_from_deepslate_copper_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_COPPER_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 25F)).build()}, ModItems.RUBY.get()));
        add("ruby_from_deepslate_diamond_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_DIAMOND_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 25F)).build()}, ModItems.RUBY.get()));
        add("ruby_from_deepslate_emerald_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_EMERALD_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 25F)).build()}, ModItems.RUBY.get()));
        add("ruby_from_deepslate_gold_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_GOLD_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 25F)).build()}, ModItems.RUBY.get()));
        add("ruby_from_deepslate_iron_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_IRON_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 25F)).build()}, ModItems.RUBY.get()));
        add("ruby_from_deepslate_lapis_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_LAPIS_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 25F)).build()}, ModItems.RUBY.get()));
        add("ruby_from_deepslate_redstone_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_REDSTONE_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 25F)).build()}, ModItems.RUBY.get()));
        add("ruby_from_zombie", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/zombie")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 250F)).build()}, ModItems.RUBY.get()));
        add("ruby_from_spider", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/spider")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 250F)).build()}, ModItems.RUBY.get()));
        add("ruby_from_skeleton", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/skeleton")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 250F)).build()}, ModItems.RUBY.get()));
        add("ruby_from_creeper", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/creeper")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 250F)).build()}, ModItems.RUBY.get()));

        //diamond
        add("diamond_from_deepslate_coal_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_COAL_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 250F)).build()}, Items.DIAMOND));
        add("diamond_from_deepslate", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 2000F)).build()}, Items.DIAMOND));
        add("diamond_from_deepslate_copper_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_COPPER_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 250F)).build()}, Items.DIAMOND));
        add("diamond_from_deepslate_diamond_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_DIAMOND_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 250F)).build()}, Items.DIAMOND));
        add("diamond_from_deepslate_emerald_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_EMERALD_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 250F)).build()}, Items.DIAMOND));
        add("diamond_from_deepslate_gold_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_GOLD_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 250F)).build()}, Items.DIAMOND));
        add("diamond_from_deepslate_iron_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_IRON_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 250F)).build()}, Items.DIAMOND));
        add("diamond_from_deepslate_lapis_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_LAPIS_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 250F)).build()}, Items.DIAMOND));
        add("diamond_from_deepslate_redstone_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_REDSTONE_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 250F)).build()}, Items.DIAMOND));
        add("diamond_from_zombie", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/zombie")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 1000F)).build()}, Items.DIAMOND));
        add("diamond_from_spider", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/spider")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 1000F)).build()}, Items.DIAMOND));
        add("diamond_from_skeleton", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/skeleton")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 1000F)).build()}, Items.DIAMOND));
        add("diamond_from_creeper", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/creeper")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 1000F)).build()}, Items.DIAMOND));

        //onyx
        add("onyx_from_zombie", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/zombie")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 2500F)).build()}, ModItems.ONYX.get()));
        add("onyx_from_spider", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/spider")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 2500F)).build()}, ModItems.ONYX.get()));
        add("onyx_from_skeleton", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/skeleton")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 2500F)).build()}, ModItems.ONYX.get()));
        add("onyx_from_creeper", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/creeper")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 2500F)).build()}, ModItems.ONYX.get()));
        add("onyx_from_pillager", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/pillager")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 500F)).build()}, ModItems.ONYX.get()));
        add("onyx_from_witch", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/witch")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 500F)).build()}, ModItems.ONYX.get()));
        add("onyx_from_wither_skeleton", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/wither_skeleton")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 500F)).build()}, ModItems.ONYX.get()));
        add("onyx_from_enderman", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/enderman")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 500F)).build()}, ModItems.ONYX.get()));
        add("onyx_from_piglin_brute", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/piglin_brute")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 500F)).build()}, ModItems.ONYX.get()));
        add("onyx_from_evoker", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/evoker")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 250F)).build()}, ModItems.ONYX.get()));
        add("onyx_from_vindicator", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/vindicator")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 250F)).build()}, ModItems.ONYX.get()));
        add("onyx_from_ravager", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/ravager")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 250F)).build()}, ModItems.ONYX.get()));

        //smouldering stone
        add("smouldering_stone_from_wither", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/wither")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.SMOULDERING_STONE.get()));

        //ender dragon scale
        add("ender_dragon_scale_from_ender_dragon", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/ender_dragon")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.ENDER_DRAGON_SCALE.get()));

        //sculk crystal
        add("sculk_crystal_from_warden", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/warden")).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.SCULK_CRYSTAL.get()));












    }
    public float oneInNumber(float a, float b) {

        return a/b; }
}
