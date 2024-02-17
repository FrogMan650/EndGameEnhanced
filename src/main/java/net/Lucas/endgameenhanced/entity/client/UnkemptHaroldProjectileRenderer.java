package net.Lucas.endgameenhanced.entity.client;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.entity.projectile.UnkemptHaroldProjectileEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class UnkemptHaroldProjectileRenderer extends ArrowRenderer<UnkemptHaroldProjectileEntity> {
    private static final ResourceLocation WITHER_INVULNERABLE_LOCATION = new ResourceLocation("textures/entity/wither/wither_invulnerable.png");
    private static final ResourceLocation PROJECTILE_LOCATION = new ResourceLocation(EndGameEnhanced.MOD_ID, "textures/entity/sapphire_arrow.png");
    public UnkemptHaroldProjectileRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(UnkemptHaroldProjectileEntity pEntity) {
        return PROJECTILE_LOCATION;
    }
}
