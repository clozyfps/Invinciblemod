package net.mcreator.invincible.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class DimensionalPortalModel extends GeoModel<DimensionalPortalEntity> {
	@Override
	public ResourceLocation getAnimationResource(DimensionalPortalEntity entity) {
		return new ResourceLocation("invincible", "animations/flaxanportal.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DimensionalPortalEntity entity) {
		return new ResourceLocation("invincible", "geo/flaxanportal.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DimensionalPortalEntity entity) {
		return new ResourceLocation("invincible", "textures/entities/" + entity.getTexture() + ".png");
	}

}