package net.mcreator.invincible.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.invincible.entity.BattleBeastEntity;

public class BattleBeastModel extends GeoModel<BattleBeastEntity> {
	@Override
	public ResourceLocation getAnimationResource(BattleBeastEntity entity) {
		return new ResourceLocation("invincible", "animations/battle_beast.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BattleBeastEntity entity) {
		return new ResourceLocation("invincible", "geo/battle_beast.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BattleBeastEntity entity) {
		return new ResourceLocation("invincible", "textures/entities/" + entity.getTexture() + ".png");
	}

}
