package net.mcreator.invincible.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.invincible.entity.EarthEntity;

public class EarthModel extends GeoModel<EarthEntity> {
	@Override
	public ResourceLocation getAnimationResource(EarthEntity entity) {
		return new ResourceLocation("invincible", "animations/earth.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EarthEntity entity) {
		return new ResourceLocation("invincible", "geo/earth.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EarthEntity entity) {
		return new ResourceLocation("invincible", "textures/entities/" + entity.getTexture() + ".png");
	}

}
