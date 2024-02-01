package net.Lucas.endgameenhanced.entity.client;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.minecraft.client.model.ElytraModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class CustomElytraModel<T extends LivingEntity> extends ElytraModel<T> {
    public static final ModelLayerLocation WINGS_LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(EndGameEnhanced.MOD_ID, "custom_elytra"), "main");
    public CustomElytraModel(ModelPart pRoot) {
        super(pRoot);
    }
}
