
package net.mcreator.invincible.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.invincible.entity.FireworkExplosionEntity;

public class FireworkExplosionRenderer extends HumanoidMobRenderer<FireworkExplosionEntity, HumanoidModel<FireworkExplosionEntity>> {
	public FireworkExplosionRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<FireworkExplosionEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(FireworkExplosionEntity entity) {
		return new ResourceLocation("invincible:textures/entities/airmob.png");
	}
}
