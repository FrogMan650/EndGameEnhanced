package net.Lucas.endgameenhanced.entity.client;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.entity.projectile.DefaultWebweaverArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DefaultWebweaverArrowRenderer extends ArrowRenderer<DefaultWebweaverArrowEntity> {
    public static final ResourceLocation WEBWEAVER_ARROW_LOCATION = new ResourceLocation(EndGameEnhanced.MOD_ID, "textures/entity/webweaver_arrow.png");
    public DefaultWebweaverArrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(DefaultWebweaverArrowEntity pEntity) {
        return WEBWEAVER_ARROW_LOCATION;
    }
}
