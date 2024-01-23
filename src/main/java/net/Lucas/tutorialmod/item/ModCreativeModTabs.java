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
                        pOutput.accept(ModItems.OPAL_SWORD.get());
                        pOutput.accept(ModItems.OPAL_PICKAXE.get());
                        pOutput.accept(ModItems.OPAL_SHOVEL.get());
                        pOutput.accept(ModItems.OPAL_AXE.get());
                        pOutput.accept(ModItems.OPAL_HOE.get());
                        pOutput.accept(ModItems.JADE.get());
                        pOutput.accept(ModBlocks.JADE_BLOCK.get());
                        pOutput.accept(ModItems.JADE_SWORD.get());
                        pOutput.accept(ModItems.JADE_PICKAXE.get());
                        pOutput.accept(ModItems.JADE_SHOVEL.get());
                        pOutput.accept(ModItems.JADE_AXE.get());
                        pOutput.accept(ModItems.JADE_HOE.get());
                        pOutput.accept(ModItems.SAPPHIRE.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModItems.SAPPHIRE_SWORD.get());
                        pOutput.accept(ModItems.SAPPHIRE_PICKAXE.get());
                        pOutput.accept(ModItems.SAPPHIRE_SHOVEL.get());
                        pOutput.accept(ModItems.SAPPHIRE_AXE.get());
                        pOutput.accept(ModItems.SAPPHIRE_HOE.get());
                        pOutput.accept(Items.EMERALD);
                        pOutput.accept(Items.EMERALD_BLOCK);
                        pOutput.accept(ModItems.EMERALD_SWORD.get());
                        pOutput.accept(ModItems.EMERALD_PICKAXE.get());
                        pOutput.accept(ModItems.EMERALD_SHOVEL.get());
                        pOutput.accept(ModItems.EMERALD_AXE.get());
                        pOutput.accept(ModItems.EMERALD_HOE.get());
                        pOutput.accept(ModItems.RUBY.get());
                        pOutput.accept(ModBlocks.RUBY_BLOCK.get());
                        pOutput.accept(ModItems.RUBY_SWORD.get());
                        pOutput.accept(ModItems.RUBY_PICKAXE.get());
                        pOutput.accept(ModItems.RUBY_SHOVEL.get());
                        pOutput.accept(ModItems.RUBY_AXE.get());
                        pOutput.accept(ModItems.RUBY_HOE.get());
                        pOutput.accept(Items.DIAMOND);
                        pOutput.accept(Items.DIAMOND_BLOCK);
                        pOutput.accept(Items.DIAMOND_SWORD);
                        pOutput.accept(Items.DIAMOND_PICKAXE);
                        pOutput.accept(Items.DIAMOND_SHOVEL);
                        pOutput.accept(Items.DIAMOND_AXE);
                        pOutput.accept(Items.DIAMOND_HOE);
                        pOutput.accept(Items.DIAMOND_HELMET);
                        pOutput.accept(Items.DIAMOND_CHESTPLATE);
                        pOutput.accept(Items.DIAMOND_LEGGINGS);
                        pOutput.accept(Items.DIAMOND_BOOTS);
                        pOutput.accept(ModItems.ONYX.get());
                        pOutput.accept(ModBlocks.ONYX_BLOCK.get());
                        pOutput.accept(ModItems.ONYX_SWORD.get());
                        pOutput.accept(ModItems.ONYX_PICKAXE.get());
                        pOutput.accept(ModItems.ONYX_SHOVEL.get());
                        pOutput.accept(ModItems.ONYX_AXE.get());
                        pOutput.accept(ModItems.ONYX_HOE.get());
                        pOutput.accept(ModItems.ONYX_HELMET.get());
                        pOutput.accept(ModItems.ONYX_CHESTPLATE.get());
                        pOutput.accept(ModItems.ONYX_LEGGINGS.get());
                        pOutput.accept(ModItems.ONYX_BOOTS.get());
                        pOutput.accept(Items.NETHERITE_INGOT);
                        pOutput.accept(Items.NETHERITE_BLOCK);
                        pOutput.accept(Items.NETHERITE_SWORD);
                        pOutput.accept(Items.NETHERITE_PICKAXE);
                        pOutput.accept(Items.NETHERITE_SHOVEL);
                        pOutput.accept(Items.NETHERITE_AXE);
                        pOutput.accept(Items.NETHERITE_HOE);
                        pOutput.accept(Items.NETHERITE_HELMET);
                        pOutput.accept(Items.NETHERITE_CHESTPLATE);
                        pOutput.accept(Items.NETHERITE_LEGGINGS);
                        pOutput.accept(Items.NETHERITE_BOOTS);
                        pOutput.accept(ModItems.NETHER_BLADE.get());
                        pOutput.accept(ModItems.END_BLADE.get());
                        pOutput.accept(ModItems.SCULK_BLADE.get());
                        pOutput.accept(ModItems.WEBWEAVER_BOW.get());
                        pOutput.accept(ModItems.SCULK_SLINGER.get());
                        pOutput.accept(ModItems.TIDE_BREAKER.get());
                        pOutput.accept(ModItems.LEVIATHANS_AXE.get());
                        pOutput.accept(ModItems.SCYTHE_OF_VITUR.get());
                        pOutput.accept(ModItems.UNKEMPT_HAROLD.get());
                        pOutput.accept(ModItems.INFERNAL_PICKAXE.get());
                        pOutput.accept(ModItems.SMOULDERING_STONE.get());
                        pOutput.accept(ModItems.ENDER_DRAGON_SCALE.get());
                        pOutput.accept(ModItems.SCULK_CRYSTAL.get());
                        pOutput.accept(ModItems.CHARGED_BLAZE_ROD.get());
                        pOutput.accept(ModItems.HUGE_NETHER_WART.get());
                        pOutput.accept(ModItems.WITHER_SKELETON_BONE.get());
                        pOutput.accept(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.ONYX_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.BASIC_ESSENCE.get());
                        pOutput.accept(ModItems.PURE_NETHER_ESSENCE.get());
                        pOutput.accept(ModItems.NETHERRATH_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.PURE_END_ESSENCE.get());
                        pOutput.accept(ModItems.VOIDWAKER_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.PURE_SCULK_ESSENCE.get());
                        pOutput.accept(ModItems.SCULK_BRINGER_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.PURE_EVIL_ESSENCE.get());
                        pOutput.accept(ModItems.SCULK_SLINGER_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.PURE_SPIDER_ESSENCE.get());
                        pOutput.accept(ModItems.WEBWEAVER_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.PURE_OCEAN_ESSENCE.get());
                        pOutput.accept(ModItems.TIDE_BREAKER_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.PURE_FIRE_ESSENCE.get());
                        pOutput.accept(ModItems.INFERNAL_PICKAXE_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.PURE_EXPLOSIVE_ESSENCE.get());
                        pOutput.accept(ModItems.UNKEMPT_HAROLD_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.PURE_NATURE_ESSENCE.get());
                        pOutput.accept(ModItems.LEVIATHANS_AXE_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.PURE_BLOOD_ESSENCE.get());
                        pOutput.accept(ModItems.SCYTHE_OF_VITUR_UPGRADE_SMITHING_TEMPLATE.get());





                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
