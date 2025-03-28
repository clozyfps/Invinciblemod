package net.mcreator.invincible.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.invincible.entity.ViltrumiteEntity;

public class ViltrumiteModel extends GeoModel<ViltrumiteEntity> {
	@Override
	public ResourceLocation getAnimationResource(ViltrumiteEntity entity) {
		return new ResourceLocation("invincible", "animations/viltrumite_male.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ViltrumiteEntity entity) {
		return new ResourceLocation("invincible", "geo/viltrumite_male.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ViltrumiteEntity entity) {
		return new ResourceLocation("invincible", "textures/entities/" + entity.getTexture() + ".png");
	}

}
