
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.invincible.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.invincible.InvincibleMod;

public class InvincibleModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, InvincibleMod.MODID);
	public static final RegistryObject<SoundEvent> POWERFULPUNCH = REGISTRY.register("powerfulpunch", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("invincible", "powerfulpunch")));
	public static final RegistryObject<SoundEvent> TAKEOFF = REGISTRY.register("takeoff", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("invincible", "takeoff")));
	public static final RegistryObject<SoundEvent> POWERFULPUNCH2 = REGISTRY.register("powerfulpunch2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("invincible", "powerfulpunch2")));
	public static final RegistryObject<SoundEvent> BLOODEXPLODE = REGISTRY.register("bloodexplode", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("invincible", "bloodexplode")));
	public static final RegistryObject<SoundEvent> EXPLOSION = REGISTRY.register("explosion", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("invincible", "explosion")));
	public static final RegistryObject<SoundEvent> DISTANTEXPLOSION = REGISTRY.register("distantexplosion", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("invincible", "distantexplosion")));
	public static final RegistryObject<SoundEvent> GRIP = REGISTRY.register("grip", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("invincible", "grip")));
	public static final RegistryObject<SoundEvent> SPEEDFOLLOWUP = REGISTRY.register("speedfollowup", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("invincible", "speedfollowup")));
	public static final RegistryObject<SoundEvent> WEB = REGISTRY.register("web", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("invincible", "web")));
}
