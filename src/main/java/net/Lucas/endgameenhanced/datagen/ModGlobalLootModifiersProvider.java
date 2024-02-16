package net.Lucas.endgameenhanced.datagen;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, EndGameEnhanced.MOD_ID);
    }

    @Override
    protected void start() {

    }
    public float oneInNumber(float a, float b) {

        return a/b; }
}
