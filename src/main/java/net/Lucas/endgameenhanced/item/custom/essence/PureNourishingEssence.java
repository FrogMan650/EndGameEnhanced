package net.Lucas.endgameenhanced.item.custom.essence;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PureNourishingEssence extends Item {
    public PureNourishingEssence(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFoil(@NotNull ItemStack pStack) {
        return true;
    }
}
