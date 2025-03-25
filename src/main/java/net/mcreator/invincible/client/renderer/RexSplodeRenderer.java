
package net.mcreator.invincible.client.renderer;

public class RexSplodeRenderer extends GeoEntityRenderer<RexSplodeEntity> {
	public RexSplodeRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new RexSplodeModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(RexSplodeEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, RexSplodeEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 0.98f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

}