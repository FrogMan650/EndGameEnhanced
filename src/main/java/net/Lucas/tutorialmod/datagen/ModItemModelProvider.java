package net.Lucas.tutorialmod.datagen;

import net.Lucas.tutorialmod.TutorialMod;
import net.Lucas.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        simpleItem(ModItems.RAW_SAPPHIRE);
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.OPAL);
        simpleItem(ModItems.JADE);
        simpleItem(ModItems.RUBY);
        simpleItem(ModItems.ONYX);
        simpleItem(ModItems.SMOULDERING_STONE);
        simpleItem(ModItems.ENDER_DRAGON_SCALE);
        simpleItem(ModItems.SCULK_CRYSTAL);
        simpleItem(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE);
        simpleItem(ModItems.ONYX_UPGRADE_SMITHING_TEMPLATE);
        handheldItem(ModItems.ONYX_SWORD);
        handheldItem(ModItems.ONYX_SHOVEL);
        handheldItem(ModItems.ONYX_PICKAXE);
        handheldItem(ModItems.ONYX_AXE);
        handheldItem(ModItems.ONYX_HOE);
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


    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TutorialMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(TutorialMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
