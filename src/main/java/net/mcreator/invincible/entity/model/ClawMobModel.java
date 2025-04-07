package net.mcreator.invincible.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.invincible.entity.ClawMobEntity;

public class ClawMobModel extends GeoModel<ClawMobEntity> {
	@Override
	public ResourceLocation getAnimationResource(ClawMobEntity entity) {
		return new ResourceLocation("invincible", "animations/claw.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ClawMobEntity entity) {
		return new ResourceLocation("invincible", "geo/claw.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ClawMobEntity entity) {
		return new ResourceLocation("invincible", "textures/entities/" + entity.getTexture() + ".png");
	}

}
