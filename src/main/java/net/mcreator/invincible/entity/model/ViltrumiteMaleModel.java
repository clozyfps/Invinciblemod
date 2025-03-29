package net.mcreator.invincible.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.invincible.entity.ViltrumiteMaleEntity;

public class ViltrumiteMaleModel extends GeoModel<ViltrumiteMaleEntity> {
	@Override
	public ResourceLocation getAnimationResource(ViltrumiteMaleEntity entity) {
		return new ResourceLocation("invincible", "animations/viltrumite_male.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ViltrumiteMaleEntity entity) {
		return new ResourceLocation("invincible", "geo/viltrumite_male.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ViltrumiteMaleEntity entity) {
		return new ResourceLocation("invincible", "textures/entities/" + entity.getTexture() + ".png");
	}

}
