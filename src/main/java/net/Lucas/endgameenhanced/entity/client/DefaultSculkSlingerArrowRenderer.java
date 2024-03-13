package net.Lucas.endgameenhanced.entity.client;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.entity.projectile.DefaultSculkSlingerArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class DefaultSculkSlingerArrowRenderer extends ArrowRenderer<DefaultSculkSlingerArrowEntity> {
    public static final ResourceLocation SCULK_SLINGER_ARROW_LOCATION = new ResourceLocation(EndGameEnhanced.MOD_ID, "textures/entity/sculk_slinger_arrow.png");
    public DefaultSculkSlingerArrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull DefaultSculkSlingerArrowEntity pEntity) {
        return SCULK_SLINGER_ARROW_LOCATION;
    }
}
