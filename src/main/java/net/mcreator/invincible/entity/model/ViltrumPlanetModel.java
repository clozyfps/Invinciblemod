package net.mcreator.invincible.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.invincible.entity.ViltrumPlanetEntity;

public class ViltrumPlanetModel extends GeoModel<ViltrumPlanetEntity> {
	@Override
	public ResourceLocation getAnimationResource(ViltrumPlanetEntity entity) {
		return new ResourceLocation("invincible", "animations/earth.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ViltrumPlanetEntity entity) {
		return new ResourceLocation("invincible", "geo/earth.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ViltrumPlanetEntity entity) {
		return new ResourceLocation("invincible", "textures/entities/" + entity.getTexture() + ".png");
	}

}
