package net.Lucas.endgameenhanced.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.entity.projectile.UnkemptHaroldProjectileEntity;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class UnkemptHaroldProjectileRenderer extends EntityRenderer<UnkemptHaroldProjectileEntity> {
    private static final ResourceLocation PROJECTILE_LOCATION = new ResourceLocation(EndGameEnhanced.MOD_ID, "textures/entity/unkempt_harold_projectile.png");
    private final UnkemptHaroldProjectileModel model;
    public UnkemptHaroldProjectileRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new UnkemptHaroldProjectileModel(pContext.bakeLayer(ModelLayers.WITHER_SKULL));
    }
    public void render(UnkemptHaroldProjectileEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.scale(-1.0F, -1.0F, 1.0F);
        float f = Mth.rotLerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot());
        float f1 = Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot());
        VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(this.getTextureLocation(pEntity)));
        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(UnkemptHaroldProjectileEntity pEntity) {
        return PROJECTILE_LOCATION;
    }
}
