
package net.mcreator.invincible.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.invincible.entity.ViltrumiteEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class ViltrumiteRenderer extends HumanoidMobRenderer<ViltrumiteEntity, HumanoidModel<ViltrumiteEntity>> {
	public ViltrumiteRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<ViltrumiteEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	protected void scale(ViltrumiteEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.1f, 1.1f, 1.1f);
	}

	@Override
	public ResourceLocation getTextureLocation(ViltrumiteEntity entity) {
		return new ResourceLocation("invincible:textures/entities/7a8ffe6e45da09146c59142e9b00140aa0da5c64e086f32669c765a3c6f1ee85.png");
	}
}
