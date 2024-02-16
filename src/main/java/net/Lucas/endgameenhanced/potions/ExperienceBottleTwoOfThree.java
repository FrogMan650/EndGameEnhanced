package net.Lucas.endgameenhanced.potions;

import net.Lucas.endgameenhanced.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.brewing.IBrewingRecipe;

public class ExperienceBottleTwoOfThree implements IBrewingRecipe {
    private final Item input;
    private final Item output;
    private final Item ingredient;

    public ExperienceBottleTwoOfThree(Item input, Item output, Item ingredient) {
        this.input = input;
        this.output = output;
        this.ingredient = ingredient;
    }
    @Override
    public boolean isInput(ItemStack input) {
        return input.getItem() == ModItems.EXPERIENCE_BOTTLE_NETHER_WART.get();
    }

    @Override
    public boolean isIngredient(ItemStack ingredient) {
         return ingredient.getItem() == Items.CHORUS_FRUIT;
    }

    @Override
    public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
        if (!this.isInput(input) || !this.isIngredient(ingredient)) {
            return ItemStack.EMPTY;
        }
        if (isIngredient(ingredient) && isInput(input)) {
            return output.getDefaultInstance();
        } else {
            ItemStack itemStack = new ItemStack(input.getItem());
            itemStack.setTag(new CompoundTag());
            return itemStack;
        }
    }
}
