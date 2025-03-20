
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.invincible.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.invincible.client.model.Modelinvincible_suit;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class InvincibleModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelinvincible_suit.LAYER_LOCATION, Modelinvincible_suit::createBodyLayer);
	}
}
