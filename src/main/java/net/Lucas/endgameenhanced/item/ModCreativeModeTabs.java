package net.Lucas.endgameenhanced.item;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EndGameEnhanced.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GEM_TAB = CREATIVE_MODE_TABS.register("gem_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ONYX.get()))
                    .title(Component.translatable("endgameenhanced.creativetab.gem_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.GEM_ORE.get());
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
                        pOutput.accept(ModItems.SAPPHIRE_ARROW.get());
                        pOutput.accept(Items.EMERALD);
                        pOutput.accept(Items.EMERALD_BLOCK);
                        pOutput.accept(ModItems.EMERALD_SWORD.get());
                        pOutput.accept(ModItems.EMERALD_PICKAXE.get());
                        pOutput.accept(ModItems.EMERALD_SHOVEL.get());
                        pOutput.accept(ModItems.EMERALD_AXE.get());
                        pOutput.accept(ModItems.EMERALD_HOE.get());
                        pOutput.accept(ModItems.EMERALD_ARROW.get());
                        pOutput.accept(ModItems.RUBY.get());
                        pOutput.accept(ModBlocks.RUBY_BLOCK.get());
                        pOutput.accept(ModItems.RUBY_SWORD.get());
                        pOutput.accept(ModItems.RUBY_PICKAXE.get());
                        pOutput.accept(ModItems.RUBY_SHOVEL.get());
                        pOutput.accept(ModItems.RUBY_AXE.get());
                        pOutput.accept(ModItems.RUBY_HOE.get());
                        pOutput.accept(ModItems.RUBY_ARROW.get());
                        pOutput.accept(Items.DIAMOND);
                        pOutput.accept(Items.DIAMOND_BLOCK);
                        pOutput.accept(Items.DIAMOND_SWORD);
                        pOutput.accept(Items.DIAMOND_PICKAXE);
                        pOutput.accept(Items.DIAMOND_SHOVEL);
                        pOutput.accept(Items.DIAMOND_AXE);
                        pOutput.accept(Items.DIAMOND_HOE);
                        pOutput.accept(ModItems.DIAMOND_ARROW.get());
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
                        pOutput.accept(ModItems.ONYX_ARROW.get());
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
                        pOutput.accept(Items.QUARTZ);
                        pOutput.accept(ModBlocks.BIG_QUARTZ_BLOCK.get());
                        pOutput.accept(ModItems.QUARTZ_SWORD.get());
                        pOutput.accept(ModItems.QUARTZ_PICKAXE.get());
                        pOutput.accept(ModItems.QUARTZ_SHOVEL.get());
                        pOutput.accept(ModItems.QUARTZ_AXE.get());
                        pOutput.accept(ModItems.QUARTZ_HOE.get());
                        pOutput.accept(Items.AMETHYST_SHARD);
                        pOutput.accept(ModBlocks.BIG_AMETHYST_BLOCK.get());
                        pOutput.accept(ModItems.AMETHYST_SWORD.get());
                        pOutput.accept(ModItems.AMETHYST_PICKAXE.get());
                        pOutput.accept(ModItems.AMETHYST_SHOVEL.get());
                        pOutput.accept(ModItems.AMETHYST_AXE.get());
                        pOutput.accept(ModItems.AMETHYST_HOE.get());
                        pOutput.accept(Items.ECHO_SHARD);
                        pOutput.accept(ModBlocks.ECHO_BLOCK.get());
                        pOutput.accept(ModItems.ECHO_SWORD.get());
                        pOutput.accept(ModItems.ECHO_PICKAXE.get());
                        pOutput.accept(ModItems.ECHO_SHOVEL.get());
                        pOutput.accept(ModItems.ECHO_AXE.get());
                        pOutput.accept(ModItems.ECHO_HOE.get());
                    }).build());
    public static final RegistryObject<CreativeModeTab> UNIQUE_MOB_DROP_TAB = CREATIVE_MODE_TABS.register("unique_mob_drop_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SMOULDERING_STONE.get()))
                    .title(Component.translatable("endgameenhanced.creativetab.unique_mob_drop_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SMOULDERING_STONE.get());
                        pOutput.accept(ModItems.ENDER_DRAGON_SCALE.get());
                        pOutput.accept(ModItems.SCULK_CRYSTAL.get());
                        pOutput.accept(ModItems.CHARGED_BLAZE_ROD.get());
                        pOutput.accept(ModItems.WITHER_SKELETON_BONE.get());
                        pOutput.accept(ModItems.SPIDER_FANG.get());
                        pOutput.accept(ModItems.CREEPER_FUSE.get());
                        pOutput.accept(ModItems.SOAKED_FLESH.get());
                        pOutput.accept(ModItems.FLESH_JERKY.get());
                        pOutput.accept(ModItems.MAGMA_BUTTER.get());
                        pOutput.accept(ModItems.RIB_BONE.get());
                        pOutput.accept(ModItems.SLIME_GLOB.get());
                        pOutput.accept(ModItems.FROZEN_BONE.get());
                        pOutput.accept(ModItems.NOT_SO_ROTTEN_FLESH.get());
                        pOutput.accept(ModItems.PIGLINS_GOLD_COIN.get());
                        pOutput.accept(ModItems.CAVE_SPIDER_EYE.get());
                        pOutput.accept(ModItems.ENDERMITE_EGG.get());
                        pOutput.accept(ModItems.GHAST_TENTACLE.get());
                        pOutput.accept(ModItems.GUARDIAN_SPIKE.get());
                        pOutput.accept(ModItems.HOGLIN_TUSK.get());
                        pOutput.accept(ModItems.PHANTOM_WING.get());
                        pOutput.accept(ModItems.DAMAGED_CROSSBOW.get());
                        pOutput.accept(ModItems.DISCOLORED_SHULKER_SHELL.get());
                        pOutput.accept(ModItems.WITCHS_BREW.get());
                        pOutput.accept(ModItems.FLAWLESS_ENDER_PEARL.get());
                        pOutput.accept(ModItems.ELDER_GUARDIAN_SPIKE.get());
                        pOutput.accept(ModItems.RITUAL_BOOK.get());
                        pOutput.accept(ModItems.AXE_HEAD.get());
                        pOutput.accept(ModItems.RAVAGER_LEATHER.get());
                        pOutput.accept(ModItems.BROKEN_AXE.get());
                        pOutput.accept(ModItems.SENSOR_TENDRIL.get());
                        pOutput.accept(ModItems.SHRIEKER_NOISE_BOX.get());
                    }).build());
    public static final RegistryObject<CreativeModeTab> TEMPLATE_TAB = CREATIVE_MODE_TABS.register("template_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get()))
                    .title(Component.translatable("endgameenhanced.creativetab.template_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.ONYX_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.NETHERRATH_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.VOIDWAKER_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.SCULK_BRINGER_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.SCULK_SLINGER_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.WEBWEAVER_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.TIDE_BREAKER_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.INFERNAL_PICKAXE_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.UNKEMPT_HAROLD_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.LEVIATHANS_AXE_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.SCYTHE_OF_VITUR_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.OBSIDIAN_ARMOR_UPGRADE_SMITHING_TEMPLATE.get());
                    }).build());
    public static final RegistryObject<CreativeModeTab> ESSENCE_TAB = CREATIVE_MODE_TABS.register("essence_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BASIC_ESSENCE.get()))
                    .title(Component.translatable("endgameenhanced.creativetab.essence_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.EXPERIENCE_BOTTLE_NETHER_WART.get());
                        pOutput.accept(ModItems.EXPERIENCE_BOTTLE_NETHER_WART_CHORUS_FRUIT.get());
                        pOutput.accept(ModItems.BASIC_ESSENCE.get());
                        pOutput.accept(ModItems.SPIDER_ESSENCE.get());
                        pOutput.accept(ModItems.DRENCHED_ESSENCE.get());
                        pOutput.accept(ModItems.MINESHAFT_ESSENCE.get());
                        pOutput.accept(ModItems.VOLATILE_ESSENCE.get());
                        pOutput.accept(ModItems.CORRUPTING_ESSENCE.get());
                        pOutput.accept(ModItems.PRISMATIC_ESSENCE.get());
                        pOutput.accept(ModItems.SCULK_ESSENCE.get());
                        pOutput.accept(ModItems.OCEAN_ESSENCE.get());
                        pOutput.accept(ModItems.SMOULDERING_ESSENCE.get());
                        pOutput.accept(ModItems.VOIDED_ESSENCE.get());
                        pOutput.accept(ModItems.PILLAGED_ESSENCE.get());
                        pOutput.accept(ModItems.NETHER_ESSENCE.get());
                        pOutput.accept(ModItems.END_ESSENCE.get());
                        pOutput.accept(ModItems.ANCIENT_ESSENCE.get());
                        pOutput.accept(ModItems.WARNING_ESSENCE.get());
                        pOutput.accept(ModItems.LAVA_ESSENCE.get());
                        pOutput.accept(ModItems.DARKNESS_ESSENCE.get());
                        pOutput.accept(ModItems.WATER_ESSENCE.get());
                        pOutput.accept(ModItems.ORE_ESSENCE.get());
                        pOutput.accept(ModItems.GEM_ESSENCE.get());
                        pOutput.accept(ModItems.TREE_ESSENCE.get());
                        pOutput.accept(ModItems.HARVEST_ESSENCE.get());
                        pOutput.accept(ModItems.SMALL_PLANT_ESSENCE.get());
                        pOutput.accept(ModItems.TALL_PLANT_ESSENCE.get());
                        pOutput.accept(ModItems.EARTHLY_ESSENCE.get());
                        pOutput.accept(ModItems.SECLUDED_ESSENCE.get());
                        pOutput.accept(ModItems.EXPLOSIVE_ESSENCE.get());
                        pOutput.accept(ModItems.TOUGHNESS_ESSENCE.get());
                        pOutput.accept(ModItems.SPEED_ESSENCE.get());
                        pOutput.accept(ModItems.BOOST_ESSENCE.get());
                        pOutput.accept(ModItems.VISION_ESSENCE.get());
                        pOutput.accept(ModItems.CONDUIT_ESSENCE.get());
                        pOutput.accept(ModItems.INFERNAL_ESSENCE.get());
                        pOutput.accept(ModItems.UNKEMPT_ESSENCE.get());
                        pOutput.accept(ModItems.SANGUINE_ESSENCE.get());
                        pOutput.accept(ModItems.BREACH_ESSENCE.get());
                        pOutput.accept(ModItems.STABILIZED_ESSENCE.get());
                        pOutput.accept(ModItems.SWIFT_ESSENCE.get());
                        pOutput.accept(ModItems.UNDYING_ESSENCE.get());
                        pOutput.accept(ModItems.RAPID_ESSENCE.get());
                        pOutput.accept(ModItems.CHARGING_ESSENCE.get());
                        pOutput.accept(ModItems.SUSTAINING_ESSENCE.get());
                        pOutput.accept(ModItems.MAINTAINING_ESSENCE.get());
                        pOutput.accept(ModItems.NURTURING_ESSENCE.get());
                        pOutput.accept(ModItems.PROVIDING_ESSENCE.get());
                        pOutput.accept(ModItems.NOURISHING_ESSENCE.get());
                        pOutput.accept(ModItems.BOTTOMLESS_ESSENCE.get());

                        pOutput.accept(ModItems.PURE_NETHER_ESSENCE.get());
                        pOutput.accept(ModItems.PURE_END_ESSENCE.get());
                        pOutput.accept(ModItems.PURE_SCULK_ESSENCE.get());
                        pOutput.accept(ModItems.PURE_EVIL_ESSENCE.get());
                        pOutput.accept(ModItems.PURE_SPIDER_ESSENCE.get());
                        pOutput.accept(ModItems.PURE_OCEAN_ESSENCE.get());
                        pOutput.accept(ModItems.PURE_FIRE_ESSENCE.get());
                        pOutput.accept(ModItems.PURE_EXPLOSIVE_ESSENCE.get());
                        pOutput.accept(ModItems.PURE_NATURE_ESSENCE.get());
                        pOutput.accept(ModItems.PURE_BLOOD_ESSENCE.get());
                        pOutput.accept(ModItems.PURE_TOUGH_ESSENCE.get());
                        pOutput.accept(ModItems.PURE_RESOLUTE_ESSENCE.get());
                        pOutput.accept(ModItems.PURE_RESILIENT_ESSENCE.get());
                        pOutput.accept(ModItems.PURE_RESISTANT_ESSENCE.get());
                        pOutput.accept(ModItems.PURE_UNDYING_ESSENCE.get());
                        pOutput.accept(ModItems.PURE_NOURISHING_ESSENCE.get());
                        pOutput.accept(ModItems.PURE_BOTTOMLESS_ESSENCE.get());
                    }).build());
    public static final RegistryObject<CreativeModeTab> INEVITABLE_TAB = CREATIVE_MODE_TABS.register("inevitable_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.NETHERRATH.get()))
                    .title(Component.translatable("endgameenhanced.creativetab.inevitable_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.NETHERRATH.get());
                        pOutput.accept(ModItems.VOIDWAKER.get());
                        pOutput.accept(ModItems.SCULK_BRINGER.get());
                        pOutput.accept(ModItems.WEBWEAVER_BOW.get());
                        pOutput.accept(ModItems.SCULK_SLINGER.get());
                        pOutput.accept(ModItems.TIDE_BREAKER.get());
                        pOutput.accept(ModItems.LEVIATHANS_AXE.get());
                        pOutput.accept(ModItems.SCYTHE_OF_VITUR.get());
                        pOutput.accept(ModItems.UNKEMPT_HAROLD.get());
                        pOutput.accept(ModItems.INFERNAL_PICKAXE.get());
                        pOutput.accept(ModItems.INEVITABLE_HELMET.get());
                        pOutput.accept(ModItems.INEVITABLE_CHESTPLATE.get());
                        pOutput.accept(ModItems.INEVITABLE_LEGGINGS.get());
                        pOutput.accept(ModItems.INEVITABLE_BOOTS.get());
                    }).build());
    public static final RegistryObject<CreativeModeTab> UNIQUE_CROPS = CREATIVE_MODE_TABS.register("unique_crops_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PLENTIFUL_WHEAT.get()))
                    .title(Component.translatable("endgameenhanced.creativetab.unique_crops_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.PLENTIFUL_WHEAT.get());
                        pOutput.accept(ModItems.ODD_SHAPED_BEETROOT.get());
                        pOutput.accept(ModItems.SMALL_CARROT.get());
                        pOutput.accept(ModItems.ODD_SHAPED_POTATO.get());
                        pOutput.accept(ModItems.HUGE_NETHER_WART.get());
                        pOutput.accept(ModItems.DISCOLORED_PITCHER_PLANT.get());
                        pOutput.accept(ModItems.BIOLUMINESCENT_TORCHFLOWER.get());
                        pOutput.accept(ModBlocks.WHITE_PUMPKIN.get());
                        pOutput.accept(ModBlocks.GOLDEN_MELON.get());
                        pOutput.accept(ModItems.THICK_SUGAR_CANE.get());
                        pOutput.accept(ModItems.CACTUS_SPINE.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> MISC_TAB = CREATIVE_MODE_TABS.register("misc_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CHARGING_TOTEM_OF_UNDYING.get()))
                    .title(Component.translatable("endgameenhanced.creativetab.misc_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.UNATTUNED_TOTEM.get());
                        pOutput.accept(Items.TOTEM_OF_UNDYING);
                        pOutput.accept(ModItems.CHARGING_TOTEM_OF_UNDYING.get());
                        pOutput.accept(ModItems.RAPID_TOTEM_OF_UNDYING.get());
                        pOutput.accept(ModItems.OVERCLOCKED_TOTEM_OF_UNDYING.get());
                        pOutput.accept(ModItems.TOTEM_OF_NOURISHING.get());
                        pOutput.accept(ModItems.AMPLE_TOTEM_OF_NOURISHING.get());
                        pOutput.accept(ModItems.GENEROUS_TOTEM_OF_NOURISHING.get());
                        pOutput.accept(ModItems.ABUNDANT_TOTEM_OF_NOURISHING.get());
                        pOutput.accept(ModItems.PLENTIFUL_TOTEM_OF_NOURISHING.get());
                        pOutput.accept(ModItems.BOUNTIFUL_TOTEM_OF_NOURISHING.get());
                        pOutput.accept(ModItems.SMALL_FLASK.get());
                        pOutput.accept(ModItems.SMALL_FLASK_POTION.get());
                        pOutput.accept(ModItems.MEDIUM_FLASK.get());
                        pOutput.accept(ModItems.MEDIUM_FLASK_POTION.get());
                        pOutput.accept(ModItems.LARGE_FLASK.get());
                        pOutput.accept(ModItems.LARGE_FLASK_POTION.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
