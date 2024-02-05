package net.Lucas.endgameenhanced.block;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EndGameEnhanced.MOD_ID);

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));
    public static final RegistryObject<Block> OPAL_BLOCK = registerBlock("opal_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));
    public static final RegistryObject<Block> JADE_BLOCK = registerBlock("jade_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));
    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));
    public static final RegistryObject<Block> ONYX_BLOCK = registerBlock("onyx_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));
    public static final RegistryObject<Block> WHITE_PUMPKIN = registerBlock("white_pumpkin",
            () -> new PumpkinBlock(BlockBehaviour.Properties.copy(Blocks.PUMPKIN)));
    public static final RegistryObject<Block> GOLDEN_MELON = registerBlock("golden_melon",
            () -> new MelonBlock(BlockBehaviour.Properties.copy(Blocks.MELON)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
