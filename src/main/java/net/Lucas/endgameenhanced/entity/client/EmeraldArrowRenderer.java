package net.Lucas.endgameenhanced.entity.client;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.entity.projectile.EmeraldArrowEntity;
import net.Lucas.endgameenhanced.entity.projectile.SapphireArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EmeraldArrowRenderer extends ArrowRenderer<EmeraldArrowEntity> {
    public static final ResourceLocation EMERALD_ARROW_LOCATION = new ResourceLocation(EndGameEnhanced.MOD_ID, "textures/entity/emerald_arrow.png");
    public EmeraldArrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(EmeraldArrowEntity pEntity) {
        return EMERALD_ARROW_LOCATION;
    }
}
