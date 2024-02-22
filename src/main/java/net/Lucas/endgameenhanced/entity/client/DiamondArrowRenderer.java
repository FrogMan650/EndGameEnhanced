package net.Lucas.endgameenhanced.entity.client;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.entity.projectile.DiamondArrowEntity;
import net.Lucas.endgameenhanced.entity.projectile.SapphireArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DiamondArrowRenderer extends ArrowRenderer<DiamondArrowEntity> {
    public static final ResourceLocation DIAMOND_ARROW_LOCATION = new ResourceLocation(EndGameEnhanced.MOD_ID, "textures/entity/diamond_arrow.png");
    public DiamondArrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(DiamondArrowEntity pEntity) {
        return DIAMOND_ARROW_LOCATION;
    }
}
