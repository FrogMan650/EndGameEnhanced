package net.Lucas.endgameenhanced.datagen;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static final LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EndGameEnhanced.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.WEBWEAVER_ARROW);
        simpleItem(ModItems.SCULK_SLINGER_ARROW);
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.OPAL);
        simpleItem(ModItems.JADE);
        simpleItem(ModItems.RUBY);
        simpleItem(ModItems.ONYX);
        simpleItem(ModItems.SAPPHIRE_ARROW);
        simpleItem(ModItems.EMERALD_ARROW);
        simpleItem(ModItems.RUBY_ARROW);
        simpleItem(ModItems.DIAMOND_ARROW);
        simpleItem(ModItems.ONYX_ARROW);
        simpleItem(ModItems.SMOULDERING_STONE);
        simpleItem(ModItems.ENDER_DRAGON_SCALE);
        simpleItem(ModItems.SCULK_CRYSTAL);
        simpleItem(ModItems.CHARGED_BLAZE_ROD);
        simpleItem(ModItems.HUGE_NETHER_WART);
        simpleItem(ModItems.WITHER_SKELETON_BONE);
        simpleItem(ModItems.SPIDER_FANG);
        simpleItem(ModItems.CREEPER_FUSE);
        simpleItem(ModItems.SOAKED_FLESH);
        simpleItem(ModItems.FLESH_JERKY);
        simpleItem(ModItems.MAGMA_BUTTER);
        simpleItem(ModItems.RIB_BONE);
        simpleItem(ModItems.SLIME_GLOB);
        simpleItem(ModItems.FROZEN_BONE);
        simpleItem(ModItems.NOT_SO_ROTTEN_FLESH);
        simpleItem(ModItems.PIGLINS_GOLD_COIN);
        simpleItem(ModItems.CAVE_SPIDER_EYE);
        simpleItem(ModItems.ENDERMITE_EGG);
        simpleItem(ModItems.GHAST_TENTACLE);
        simpleItem(ModItems.GUARDIAN_SPIKE);
        simpleItem(ModItems.HOGLIN_TUSK);
        simpleItem(ModItems.PHANTOM_WING);
        simpleItem(ModItems.DAMAGED_CROSSBOW);
        simpleItem(ModItems.DISCOLORED_SHULKER_SHELL);
        simpleItem(ModItems.WITCHS_BREW);
        simpleItem(ModItems.FLAWLESS_ENDER_PEARL);
        simpleItem(ModItems.ELDER_GUARDIAN_SPIKE);
        simpleItem(ModItems.RITUAL_BOOK);
        simpleItem(ModItems.AXE_HEAD);
        simpleItem(ModItems.RAVAGER_HORN);
        simpleItem(ModItems.BROKEN_AXE);
        simpleItem(ModItems.SENSOR_TENDRIL);
        simpleItem(ModItems.SHRIEKER_NOISE_BOX);
        simpleItem(ModItems.PLENTIFUL_WHEAT);
        simpleItem(ModItems.ODD_SHAPED_BEETROOT);
        simpleItem(ModItems.SMALL_CARROT);
        simpleItem(ModItems.ODD_SHAPED_POTATO);
        simpleItem(ModItems.DISCOLORED_PITCHER_PLANT);
        simpleItem(ModItems.CACTUS_SPINE);
        simpleItem(ModItems.BIOLUMINESCENT_TORCHFLOWER);
        simpleItem(ModItems.THICK_SUGAR_CANE);

        simpleItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE);
        simpleItem(ModItems.ONYX_UPGRADE_SMITHING_TEMPLATE);

        simpleItem(ModItems.BASIC_ESSENCE);
        simpleItem(ModItems.SPIDER_ESSENCE);
        simpleItem(ModItems.DRENCHED_ESSENCE);
        simpleItem(ModItems.MINESHAFT_ESSENCE);
        simpleItem(ModItems.VOLATILE_ESSENCE);
        simpleItem(ModItems.CORRUPTING_ESSENCE);
        simpleItem(ModItems.PRISMATIC_ESSENCE);
        simpleItem(ModItems.SCULK_ESSENCE);
        simpleItem(ModItems.OCEAN_ESSENCE);
        simpleItem(ModItems.SMOULDERING_ESSENCE);
        simpleItem(ModItems.VOIDED_ESSENCE);
        simpleItem(ModItems.PILLAGED_ESSENCE);
        simpleItem(ModItems.NETHER_ESSENCE);
        simpleItem(ModItems.END_ESSENCE);
        simpleItem(ModItems.ANCIENT_ESSENCE);
        simpleItem(ModItems.WARNING_ESSENCE);
        simpleItem(ModItems.LAVA_ESSENCE);
        simpleItem(ModItems.DARKNESS_ESSENCE);
        simpleItem(ModItems.WATER_ESSENCE);
        simpleItem(ModItems.ORE_ESSENCE);
        simpleItem(ModItems.GEM_ESSENCE);
        simpleItem(ModItems.TREE_ESSENCE);
        simpleItem(ModItems.HARVEST_ESSENCE);
        simpleItem(ModItems.SMALL_PLANT_ESSENCE);
        simpleItem(ModItems.TALL_PLANT_ESSENCE);
        simpleItem(ModItems.EARTHLY_ESSENCE);
        simpleItem(ModItems.SECLUDED_ESSENCE);
        simpleItem(ModItems.EXPLOSIVE_ESSENCE);
        simpleItem(ModItems.TOUGHNESS_ESSENCE);
        simpleItem(ModItems.SPEED_ESSENCE);
        simpleItem(ModItems.BOOST_ESSENCE);
        simpleItem(ModItems.VISION_ESSENCE);
        simpleItem(ModItems.CONDUIT_ESSENCE);
        simpleItem(ModItems.INFERNAL_ESSENCE);
        simpleItem(ModItems.UNKEMPT_ESSENCE);
        simpleItem(ModItems.SANGUINE_ESSENCE);
        simpleItem(ModItems.BREACH_ESSENCE);
        simpleItem(ModItems.STABILIZED_ESSENCE);
        simpleItem(ModItems.SWIFT_ESSENCE);
        simpleItem(ModItems.UNDYING_ESSENCE);
        simpleItem(ModItems.QUICK_CHARGE_ESSENCE);

        simpleItem(ModItems.EXPERIENCE_BOTTLE_NETHER_WART);
        simpleItem(ModItems.EXPERIENCE_BOTTLE_NETHER_WART_CHORUS_FRUIT);

        simpleItem(ModItems.PURE_NETHER_ESSENCE);
        simpleItem(ModItems.NETHERRATH_UPGRADE_SMITHING_TEMPLATE);
        simpleItem(ModItems.PURE_END_ESSENCE);
        simpleItem(ModItems.VOIDWAKER_UPGRADE_SMITHING_TEMPLATE);
        simpleItem(ModItems.PURE_SCULK_ESSENCE);
        simpleItem(ModItems.SCULK_BRINGER_UPGRADE_SMITHING_TEMPLATE);
        simpleItem(ModItems.PURE_EVIL_ESSENCE);
        simpleItem(ModItems.SCULK_SLINGER_UPGRADE_SMITHING_TEMPLATE);
        simpleItem(ModItems.PURE_SPIDER_ESSENCE);
        simpleItem(ModItems.WEBWEAVER_UPGRADE_SMITHING_TEMPLATE);
        simpleItem(ModItems.PURE_OCEAN_ESSENCE);
        simpleItem(ModItems.TIDE_BREAKER_UPGRADE_SMITHING_TEMPLATE);
        simpleItem(ModItems.PURE_FIRE_ESSENCE);
        simpleItem(ModItems.INFERNAL_PICKAXE_UPGRADE_SMITHING_TEMPLATE);
        simpleItem(ModItems.PURE_EXPLOSIVE_ESSENCE);
        simpleItem(ModItems.UNKEMPT_HAROLD_UPGRADE_SMITHING_TEMPLATE);
        simpleItem(ModItems.PURE_NATURE_ESSENCE);
        simpleItem(ModItems.LEVIATHANS_AXE_UPGRADE_SMITHING_TEMPLATE);
        simpleItem(ModItems.PURE_BLOOD_ESSENCE);
        simpleItem(ModItems.SCYTHE_OF_VITUR_UPGRADE_SMITHING_TEMPLATE);
        simpleItem(ModItems.PURE_TOUGH_ESSENCE);
        simpleItem(ModItems.PURE_RESOLUTE_ESSENCE);
        simpleItem(ModItems.PURE_RESILIENT_ESSENCE);
        simpleItem(ModItems.PURE_RESISTANT_ESSENCE);
        simpleItem(ModItems.OBSIDIAN_ARMOR_UPGRADE_SMITHING_TEMPLATE);
        simpleItem(ModItems.PURE_UNDYING_ESSENCE);


        handheldItem(ModItems.ONYX_SWORD);
        handheldItem(ModItems.ONYX_SHOVEL);
        handheldItem(ModItems.ONYX_PICKAXE);
        handheldItem(ModItems.ONYX_AXE);
        handheldItem(ModItems.ONYX_HOE);
        handheldItem(ModItems.QUARTZ_SWORD);
        handheldItem(ModItems.QUARTZ_SHOVEL);
        handheldItem(ModItems.QUARTZ_PICKAXE);
        handheldItem(ModItems.QUARTZ_AXE);
        handheldItem(ModItems.QUARTZ_HOE);
        handheldItem(ModItems.AMETHYST_SWORD);
        handheldItem(ModItems.AMETHYST_SHOVEL);
        handheldItem(ModItems.AMETHYST_PICKAXE);
        handheldItem(ModItems.AMETHYST_AXE);
        handheldItem(ModItems.AMETHYST_HOE);
        handheldItem(ModItems.ECHO_SWORD);
        handheldItem(ModItems.ECHO_SHOVEL);
        handheldItem(ModItems.ECHO_PICKAXE);
        handheldItem(ModItems.ECHO_AXE);
        handheldItem(ModItems.ECHO_HOE);
        handheldItem(ModItems.RUBY_SWORD);
        handheldItem(ModItems.RUBY_SHOVEL);
        handheldItem(ModItems.RUBY_PICKAXE);
        handheldItem(ModItems.RUBY_AXE);
        handheldItem(ModItems.RUBY_HOE);
        handheldItem(ModItems.EMERALD_SWORD);
        handheldItem(ModItems.EMERALD_SHOVEL);
        handheldItem(ModItems.EMERALD_PICKAXE);
        handheldItem(ModItems.EMERALD_AXE);
        handheldItem(ModItems.EMERALD_HOE);
        handheldItem(ModItems.SAPPHIRE_SWORD);
        handheldItem(ModItems.SAPPHIRE_SHOVEL);
        handheldItem(ModItems.SAPPHIRE_PICKAXE);
        handheldItem(ModItems.SAPPHIRE_AXE);
        handheldItem(ModItems.SAPPHIRE_HOE);
        handheldItem(ModItems.JADE_SWORD);
        handheldItem(ModItems.JADE_SHOVEL);
        handheldItem(ModItems.JADE_PICKAXE);
        handheldItem(ModItems.JADE_AXE);
        handheldItem(ModItems.JADE_HOE);
        handheldItem(ModItems.OPAL_SWORD);
        handheldItem(ModItems.OPAL_SHOVEL);
        handheldItem(ModItems.OPAL_PICKAXE);
        handheldItem(ModItems.OPAL_AXE);
        handheldItem(ModItems.OPAL_HOE);
        handheldItem(ModItems.NETHERRATH);
        handheldItem(ModItems.VOIDWAKER);
        handheldItem(ModItems.SCULK_BRINGER);


        trimmedArmorItem(ModItems.ONYX_HELMET);
        trimmedArmorItem(ModItems.ONYX_CHESTPLATE);
        trimmedArmorItem(ModItems.ONYX_LEGGINGS);
        trimmedArmorItem(ModItems.ONYX_BOOTS);
        trimmedArmorItem(ModItems.INEVITABLE_HELMET);
        trimmedArmorItem(ModItems.INEVITABLE_CHESTPLATE);
        trimmedArmorItem(ModItems.INEVITABLE_LEGGINGS);
        trimmedArmorItem(ModItems.INEVITABLE_BOOTS);


    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EndGameEnhanced.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(EndGameEnhanced.MOD_ID, "item/" + item.getId().getPath()));
    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        //method made by El_Redstoniano
        //generates the json files for each trim type on new armors ~45 jsons per set of armor
        final String MOD_ID = EndGameEnhanced.MOD_ID;

        if (itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial= entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath);
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                getBuilder(currentTrimName).parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                this.withExistingParent(itemRegistryObject.getId().getPath(), mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0", new ResourceLocation(MOD_ID, "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }
}
