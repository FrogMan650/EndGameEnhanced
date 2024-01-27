package net.Lucas.endgameenhanced.blockFacing;

import net.minecraft.nbt.CompoundTag;

public class PlayerBlockFacing {
    private int blockFacing;

    public int getBlockFacing() {
        return blockFacing;
    }

    public void changeToZero() {
        blockFacing = 0;
    }
    public void changeToOne() {
        blockFacing = 1;
    }
    public void changeToTwo() {
        blockFacing = 2;
    }

    public void copyFrom(PlayerBlockFacing source) {
        this.blockFacing = source.blockFacing;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("block_facing", blockFacing);
    }

    public void loadNBTData(CompoundTag nbt) {
        blockFacing = nbt.getInt("block_facing");
    }
}
