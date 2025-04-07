package net.mcreator.invincible.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.invincible.entity.MohawkInvincibleEntity;

public class MohawkInvincibleModel extends GeoModel<MohawkInvincibleEntity> {
	@Override
	public ResourceLocation getAnimationResource(MohawkInvincibleEntity entity) {
		return new ResourceLocation("invincible", "animations/invincible.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MohawkInvincibleEntity entity) {
		return new ResourceLocation("invincible", "geo/invincible.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MohawkInvincibleEntity entity) {
		return new ResourceLocation("invincible", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(MohawkInvincibleEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
