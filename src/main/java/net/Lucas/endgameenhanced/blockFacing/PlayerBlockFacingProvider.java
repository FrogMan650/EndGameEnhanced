package net.Lucas.endgameenhanced.blockFacing;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.capabilities.EntityCapability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerBlockFacingProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerBlockFacing> PLAYER_BLOCK_FACING = CapabilityManager.get(new CapabilityToken<PlayerBlockFacing>() { });
    
    private PlayerBlockFacing blockFacing = null;
    private final LazyOptional<PlayerBlockFacing> optional = LazyOptional.of(this::createPlayerBlockFacing);

    private PlayerBlockFacing createPlayerBlockFacing() {
        if (this.blockFacing == null) {
            this.blockFacing = new PlayerBlockFacing();
        }
        return this.blockFacing;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_BLOCK_FACING) {
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerBlockFacing().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerBlockFacing().loadNBTData(nbt);
    }
}
