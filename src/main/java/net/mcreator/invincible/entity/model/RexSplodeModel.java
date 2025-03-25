package net.mcreator.invincible.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class RexSplodeModel extends GeoModel<RexSplodeEntity> {
	@Override
	public ResourceLocation getAnimationResource(RexSplodeEntity entity) {
		return new ResourceLocation("invincible", "animations/rex_splode.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RexSplodeEntity entity) {
		return new ResourceLocation("invincible", "geo/rex_splode.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RexSplodeEntity entity) {
		return new ResourceLocation("invincible", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(RexSplodeEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}