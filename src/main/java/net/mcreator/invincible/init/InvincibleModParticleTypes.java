
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.invincible.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.invincible.InvincibleMod;

public class InvincibleModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, InvincibleMod.MODID);
	public static final RegistryObject<SimpleParticleType> SHOCKWAVE = REGISTRY.register("shockwave", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> BLOOD_DROP = REGISTRY.register("blood_drop", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SHOCKWAVE_BIG = REGISTRY.register("shockwave_big", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> COUNTER_PARTICLE = REGISTRY.register("counter_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> ELECTRICITY_PARTICLE = REGISTRY.register("electricity_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> WEB_PARTICLE = REGISTRY.register("web_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> CUSTOM_SMOKE = REGISTRY.register("custom_smoke", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> EXPLODE = REGISTRY.register("explode", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> LARGE_EXPLODE = REGISTRY.register("large_explode", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> PINK_SHOCKWAVE = REGISTRY.register("pink_shockwave", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> PINK_SMOKE = REGISTRY.register("pink_smoke", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SAND_SMOKE = REGISTRY.register("sand_smoke", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> STEAM_SMOKE = REGISTRY.register("steam_smoke", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> DIRT_SMOKE = REGISTRY.register("dirt_smoke", () -> new SimpleParticleType(false));
}
