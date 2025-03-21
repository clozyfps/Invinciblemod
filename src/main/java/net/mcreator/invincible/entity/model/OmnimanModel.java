package net.mcreator.invincible.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.invincible.entity.OmnimanEntity;

public class OmnimanModel extends GeoModel<OmnimanEntity> {
	@Override
	public ResourceLocation getAnimationResource(OmnimanEntity entity) {
		return new ResourceLocation("invincible", "animations/omniman.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OmnimanEntity entity) {
		return new ResourceLocation("invincible", "geo/omniman.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OmnimanEntity entity) {
		return new ResourceLocation("invincible", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(OmnimanEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
