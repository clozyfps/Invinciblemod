
package net.mcreator.invincible.client.renderer;

public class AngstromRenderer extends GeoEntityRenderer<AngstromEntity> {
	public AngstromRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new AngstromModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(AngstromEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, AngstromEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 0.98f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

}