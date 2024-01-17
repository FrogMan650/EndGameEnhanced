package net.Lucas.tutorialmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.Lucas.tutorialmod.TutorialMod;
import net.Lucas.tutorialmod.entity.custom.LeviathansAxeEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class LeviathansAxeRenderer extends EntityRenderer<LeviathansAxeEntity> {
    public static final ResourceLocation LEVIATHANS_AXE_LOCATION = new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/leviathans_axe.png");
    private final LeviathansAxeModel model;

    public LeviathansAxeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new LeviathansAxeModel(pContext.bakeLayer(LeviathansAxeModel.LEVIATHANS_AXE_LAYER_LOCATION));
    }

    public void render(LeviathansAxeEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
        pMatrixStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
        pMatrixStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(this.getTextureLocation(pEntity)), false, pEntity.isFoil());
        this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pMatrixStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getTextureLocation(LeviathansAxeEntity pEntity) {
        return LEVIATHANS_AXE_LOCATION;
    }
}
