package net.Lucas.endgameenhanced.item.custom.essence;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class PureSpiderEssence extends Item {
    public PureSpiderEssence(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}
