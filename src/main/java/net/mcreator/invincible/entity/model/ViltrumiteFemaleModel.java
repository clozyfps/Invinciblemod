package net.mcreator.invincible.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.invincible.entity.ViltrumiteFemaleEntity;

public class ViltrumiteFemaleModel extends GeoModel<ViltrumiteFemaleEntity> {
	@Override
	public ResourceLocation getAnimationResource(ViltrumiteFemaleEntity entity) {
		return new ResourceLocation("invincible", "animations/viltrumite_female.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ViltrumiteFemaleEntity entity) {
		return new ResourceLocation("invincible", "geo/viltrumite_female.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ViltrumiteFemaleEntity entity) {
		return new ResourceLocation("invincible", "textures/entities/" + entity.getTexture() + ".png");
	}

}
