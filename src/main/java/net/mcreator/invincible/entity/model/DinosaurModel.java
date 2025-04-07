package net.mcreator.invincible.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.invincible.entity.DinosaurEntity;

public class DinosaurModel extends GeoModel<DinosaurEntity> {
	@Override
	public ResourceLocation getAnimationResource(DinosaurEntity entity) {
		return new ResourceLocation("invincible", "animations/dinosaur.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DinosaurEntity entity) {
		return new ResourceLocation("invincible", "geo/dinosaur.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DinosaurEntity entity) {
		return new ResourceLocation("invincible", "textures/entities/" + entity.getTexture() + ".png");
	}

}
