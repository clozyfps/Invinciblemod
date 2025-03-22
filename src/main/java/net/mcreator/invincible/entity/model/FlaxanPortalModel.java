package net.mcreator.invincible.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.invincible.entity.FlaxanPortalEntity;

public class FlaxanPortalModel extends GeoModel<FlaxanPortalEntity> {
	@Override
	public ResourceLocation getAnimationResource(FlaxanPortalEntity entity) {
		return new ResourceLocation("invincible", "animations/flaxanportal.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FlaxanPortalEntity entity) {
		return new ResourceLocation("invincible", "geo/flaxanportal.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FlaxanPortalEntity entity) {
		return new ResourceLocation("invincible", "textures/entities/" + entity.getTexture() + ".png");
	}

}
