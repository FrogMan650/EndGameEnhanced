package net.Lucas.endgameenhanced.entity.client;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.entity.projectile.OnyxArrowEntity;
import net.Lucas.endgameenhanced.entity.projectile.SapphireArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class OnyxArrowRenderer extends ArrowRenderer<OnyxArrowEntity> {
    public static final ResourceLocation ONYX_ARROW_LOCATION = new ResourceLocation(EndGameEnhanced.MOD_ID, "textures/entity/onyx_arrow.png");
    public OnyxArrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(OnyxArrowEntity pEntity) {
        return ONYX_ARROW_LOCATION;
    }
}
