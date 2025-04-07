package net.mcreator.invincible.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.invincible.entity.VeilInvincibleEntity;

public class VeilInvincibleModel extends GeoModel<VeilInvincibleEntity> {
	@Override
	public ResourceLocation getAnimationResource(VeilInvincibleEntity entity) {
		return new ResourceLocation("invincible", "animations/veil_invincible.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(VeilInvincibleEntity entity) {
		return new ResourceLocation("invincible", "geo/veil_invincible.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(VeilInvincibleEntity entity) {
		return new ResourceLocation("invincible", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(VeilInvincibleEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
