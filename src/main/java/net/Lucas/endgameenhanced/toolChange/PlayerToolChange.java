package net.Lucas.endgameenhanced.toolChange;

import net.minecraft.nbt.CompoundTag;

public class PlayerToolChange {
    private int toolChange;

    public int getToolChange() {
        return toolChange;
    }

    public void changeToZero() {
        toolChange = 0;
    }
    public void changeToOne() {
        toolChange = 1;
    }

    public void copyFrom(PlayerToolChange source) {
        this.toolChange = source.toolChange;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("tool_change", toolChange);
    }

    public void loadNBTData(CompoundTag nbt) {
        toolChange = nbt.getInt("tool_change");
    }
}
