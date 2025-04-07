package net.mcreator.invincible.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.invincible.entity.FullMaskInvincibleEntity;

public class FullMaskInvincibleModel extends GeoModel<FullMaskInvincibleEntity> {
	@Override
	public ResourceLocation getAnimationResource(FullMaskInvincibleEntity entity) {
		return new ResourceLocation("invincible", "animations/invincible.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FullMaskInvincibleEntity entity) {
		return new ResourceLocation("invincible", "geo/invincible.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FullMaskInvincibleEntity entity) {
		return new ResourceLocation("invincible", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(FullMaskInvincibleEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
