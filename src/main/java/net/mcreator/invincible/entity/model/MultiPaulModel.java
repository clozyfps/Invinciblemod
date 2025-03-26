package net.mcreator.invincible.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class MultiPaulModel extends GeoModel<MultiPaulEntity> {
	@Override
	public ResourceLocation getAnimationResource(MultiPaulEntity entity) {
		return new ResourceLocation("invincible", "animations/multi_paul.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MultiPaulEntity entity) {
		return new ResourceLocation("invincible", "geo/multi_paul.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MultiPaulEntity entity) {
		return new ResourceLocation("invincible", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(MultiPaulEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}