package net.mcreator.invincible.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class DupliKateModel extends GeoModel<DupliKateEntity> {
	@Override
	public ResourceLocation getAnimationResource(DupliKateEntity entity) {
		return new ResourceLocation("invincible", "animations/dupli_kate.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DupliKateEntity entity) {
		return new ResourceLocation("invincible", "geo/dupli_kate.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DupliKateEntity entity) {
		return new ResourceLocation("invincible", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(DupliKateEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}