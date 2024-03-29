package net.Lucas.endgameenhanced.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.entity.custom.TideBreakerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("rawtypes")
public class TideBreakerRenderer extends EntityRenderer<TideBreakerEntity> {
    public static final ResourceLocation TIDE_BREAKER_LOCATION = new ResourceLocation(EndGameEnhanced.MOD_ID, "textures/entity/tide_breaker.png");
    private final TideBreakerModel model;

    public TideBreakerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new TideBreakerModel<>(pContext.bakeLayer(TideBreakerModel.TIDE_BREAKER_LAYER_LOCATION));
    }

    @Override
    public void render(TideBreakerEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, @NotNull MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
        pMatrixStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
        pMatrixStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(this.getTextureLocation(pEntity)), false, pEntity.isFoil());
        this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pMatrixStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    public @NotNull ResourceLocation getTextureLocation(@NotNull TideBreakerEntity pEntity) {
        return TIDE_BREAKER_LOCATION;
    }
}
