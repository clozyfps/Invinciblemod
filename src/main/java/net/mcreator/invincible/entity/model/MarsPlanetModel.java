package net.mcreator.invincible.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.invincible.entity.MarsPlanetEntity;

public class MarsPlanetModel extends GeoModel<MarsPlanetEntity> {
	@Override
	public ResourceLocation getAnimationResource(MarsPlanetEntity entity) {
		return new ResourceLocation("invincible", "animations/earth.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MarsPlanetEntity entity) {
		return new ResourceLocation("invincible", "geo/earth.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MarsPlanetEntity entity) {
		return new ResourceLocation("invincible", "textures/entities/" + entity.getTexture() + ".png");
	}

}
