
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.invincible.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.invincible.client.particle.WebParticleParticle;
import net.mcreator.invincible.client.particle.SteamSmokeParticle;
import net.mcreator.invincible.client.particle.ShockwaveParticle;
import net.mcreator.invincible.client.particle.ShockwaveBigParticle;
import net.mcreator.invincible.client.particle.SandSmokeParticle;
import net.mcreator.invincible.client.particle.PinkSmokeParticle;
import net.mcreator.invincible.client.particle.PinkShockwaveParticle;
import net.mcreator.invincible.client.particle.LargeExplodeParticle;
import net.mcreator.invincible.client.particle.ExplodeParticle;
import net.mcreator.invincible.client.particle.ElectricityParticleParticle;
import net.mcreator.invincible.client.particle.DirtSmokeParticle;
import net.mcreator.invincible.client.particle.CustomSmokeParticle;
import net.mcreator.invincible.client.particle.CounterParticleParticle;
import net.mcreator.invincible.client.particle.BloodDropParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class InvincibleModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(InvincibleModParticleTypes.SHOCKWAVE.get(), ShockwaveParticle::provider);
		event.registerSpriteSet(InvincibleModParticleTypes.BLOOD_DROP.get(), BloodDropParticle::provider);
		event.registerSpriteSet(InvincibleModParticleTypes.SHOCKWAVE_BIG.get(), ShockwaveBigParticle::provider);
		event.registerSpriteSet(InvincibleModParticleTypes.COUNTER_PARTICLE.get(), CounterParticleParticle::provider);
		event.registerSpriteSet(InvincibleModParticleTypes.ELECTRICITY_PARTICLE.get(), ElectricityParticleParticle::provider);
		event.registerSpriteSet(InvincibleModParticleTypes.WEB_PARTICLE.get(), WebParticleParticle::provider);
		event.registerSpriteSet(InvincibleModParticleTypes.CUSTOM_SMOKE.get(), CustomSmokeParticle::provider);
		event.registerSpriteSet(InvincibleModParticleTypes.EXPLODE.get(), ExplodeParticle::provider);
		event.registerSpriteSet(InvincibleModParticleTypes.LARGE_EXPLODE.get(), LargeExplodeParticle::provider);
		event.registerSpriteSet(InvincibleModParticleTypes.PINK_SHOCKWAVE.get(), PinkShockwaveParticle::provider);
		event.registerSpriteSet(InvincibleModParticleTypes.PINK_SMOKE.get(), PinkSmokeParticle::provider);
		event.registerSpriteSet(InvincibleModParticleTypes.SAND_SMOKE.get(), SandSmokeParticle::provider);
		event.registerSpriteSet(InvincibleModParticleTypes.STEAM_SMOKE.get(), SteamSmokeParticle::provider);
		event.registerSpriteSet(InvincibleModParticleTypes.DIRT_SMOKE.get(), DirtSmokeParticle::provider);
	}
}
