package net.Lucas.endgameenhanced.toolChange;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerToolChangeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerToolChange> PLAYER_TOOL_CHANGE = CapabilityManager.get(new CapabilityToken<PlayerToolChange>() { });
    
    private PlayerToolChange toolChange = null;
    private final LazyOptional<PlayerToolChange> optional = LazyOptional.of(this::createPlayerToolChange);

    private PlayerToolChange createPlayerToolChange() {
        if (this.toolChange == null) {
            this.toolChange = new PlayerToolChange();
        }
        return this.toolChange;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_TOOL_CHANGE) {
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerToolChange().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerToolChange().loadNBTData(nbt);
    }
}
