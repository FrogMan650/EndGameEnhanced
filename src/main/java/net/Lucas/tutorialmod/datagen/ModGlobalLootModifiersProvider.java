package net.Lucas.tutorialmod.datagen;

import net.Lucas.tutorialmod.TutorialMod;
import net.Lucas.tutorialmod.item.ModItems;
import net.Lucas.tutorialmod.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
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
        add("raw_sapphire_from_coal_ore", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.COAL_ORE).build(),
                LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.RAW_SAPPHIRE.get()));

        add("raw_sapphire_from_zombie", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(new ResourceLocation("entities/zombie")).build(),
        LootItemRandomChanceCondition.randomChance(oneInNumber(1F, 5F)).build()}, ModItems.RAW_SAPPHIRE.get()));


    }
    public float oneInNumber(float a, float b) {

        return a/b; }
}
