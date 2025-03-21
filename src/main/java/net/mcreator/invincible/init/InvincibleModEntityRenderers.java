
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.invincible.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.invincible.client.renderer.ViltrumiteRenderer;
import net.mcreator.invincible.client.renderer.PastImageRenderer;
import net.mcreator.invincible.client.renderer.OmnimanRenderer;
import net.mcreator.invincible.client.renderer.MaulerRenderer;
import net.mcreator.invincible.client.renderer.MarsProximityRenderer;
import net.mcreator.invincible.client.renderer.InvincibleMarkRenderer;
import net.mcreator.invincible.client.renderer.InvincibleBlueMarkRenderer;
import net.mcreator.invincible.client.renderer.AfterImageRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class InvincibleModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(InvincibleModEntities.MARS_PROXIMITY.get(), MarsProximityRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.VILTRUMITE.get(), ViltrumiteRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.AFTER_IMAGE.get(), AfterImageRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.SONIC_CLAP.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.PAST_IMAGE.get(), PastImageRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.WEB_LINE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.INVINCIBLE_MARK.get(), InvincibleMarkRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.INVINCIBLE_BLUE_MARK.get(), InvincibleBlueMarkRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.OMNIMAN.get(), OmnimanRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.MAULER.get(), MaulerRenderer::new);
	}
}
