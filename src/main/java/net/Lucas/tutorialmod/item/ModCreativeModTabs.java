package net.Lucas.tutorialmod.item;

import net.Lucas.tutorialmod.TutorialMod;
import net.Lucas.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    //creating the custom tab
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    //setting the icon and name of the tab and adding the items to the tab
    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        //adding my custom items
                        pOutput.accept(ModItems.SAPPHIRE.get());
                        pOutput.accept(ModItems.RAW_SAPPHIRE.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());

                        //adding vanilla items
                        pOutput.accept(Items.DIAMOND);
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> FARMING_TAB = CREATIVE_MODE_TABS.register("gem_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.DIAMOND))
                    .title(Component.translatable("creativetab.gem_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        //adding my custom items
                        pOutput.accept(ModItems.OPAL.get());
                        pOutput.accept(ModBlocks.OPAL_BLOCK.get());
                        pOutput.accept(ModItems.JADE.get());
                        pOutput.accept(ModBlocks.JADE_BLOCK.get());
                        pOutput.accept(ModItems.SAPPHIRE.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(Items.EMERALD);
                        pOutput.accept(Items.EMERALD_BLOCK);
                        pOutput.accept(ModItems.RUBY.get());
                        pOutput.accept(ModBlocks.RUBY_BLOCK.get());
                        pOutput.accept(Items.DIAMOND);
                        pOutput.accept(Items.DIAMOND_BLOCK);
                        pOutput.accept(ModItems.ONYX.get());
                        pOutput.accept(ModBlocks.ONYX_BLOCK.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
