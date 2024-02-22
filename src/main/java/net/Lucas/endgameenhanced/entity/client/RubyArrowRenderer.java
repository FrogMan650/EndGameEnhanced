package net.Lucas.endgameenhanced.entity.client;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.entity.projectile.RubyArrowEntity;
import net.Lucas.endgameenhanced.entity.projectile.SapphireArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RubyArrowRenderer extends ArrowRenderer<RubyArrowEntity> {
    public static final ResourceLocation RUBY_ARROW_LOCATION = new ResourceLocation(EndGameEnhanced.MOD_ID, "textures/entity/ruby_arrow.png");
    public RubyArrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(RubyArrowEntity pEntity) {
        return RUBY_ARROW_LOCATION;
    }
}
