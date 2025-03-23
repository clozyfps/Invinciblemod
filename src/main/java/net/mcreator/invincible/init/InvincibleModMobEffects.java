
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.invincible.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.invincible.potion.ViltrumiteNPCFollowUpTriggerMobEffect;
import net.mcreator.invincible.potion.TakeoffEffectsMobEffect;
import net.mcreator.invincible.potion.SmokingMobEffect;
import net.mcreator.invincible.potion.SmokeCircleExpandingMobEffect;
import net.mcreator.invincible.potion.SlowedMobEffect;
import net.mcreator.invincible.potion.SlamTimerMobEffect;
import net.mcreator.invincible.potion.PunchCatchCDMobEffect;
import net.mcreator.invincible.potion.PunchCatchActiveMobEffect;
import net.mcreator.invincible.potion.PointDestructionUniversalMobEffect;
import net.mcreator.invincible.potion.PointDestructionMobEffect;
import net.mcreator.invincible.potion.NoFallMobEffect;
import net.mcreator.invincible.potion.MarsShaderMobEffect;
import net.mcreator.invincible.potion.InstantCraterMobEffect;
import net.mcreator.invincible.potion.ImpactFramePotionMobEffect;
import net.mcreator.invincible.potion.HyperSonicMobEffect;
import net.mcreator.invincible.potion.HeavyStunMobEffect;
import net.mcreator.invincible.potion.GrabbingActiveMobEffect;
import net.mcreator.invincible.potion.GrabbedMobEffect;
import net.mcreator.invincible.potion.GrabCooldownMobEffect;
import net.mcreator.invincible.potion.GlassBreakMobEffect;
import net.mcreator.invincible.potion.FlashTimeMobEffect;
import net.mcreator.invincible.potion.FallingBlocksManipMobEffect;
import net.mcreator.invincible.potion.DestructionActiveMobEffect;
import net.mcreator.invincible.potion.DestructionActiveBurstMobEffect;
import net.mcreator.invincible.potion.CooldownMobEffect;
import net.mcreator.invincible.potion.ComboStillMobEffect;
import net.mcreator.invincible.potion.CircleExpandingBurstMobEffect;
import net.mcreator.invincible.potion.BulletSlamMobEffect;
import net.mcreator.invincible.potion.BackwardsTumbleMobEffect;
import net.mcreator.invincible.potion.AfterImagesMobEffect;
import net.mcreator.invincible.potion.ActiveFlightSpeedMobEffect;
import net.mcreator.invincible.potion.ActiveBurstMobEffect;
import net.mcreator.invincible.InvincibleMod;

public class InvincibleModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, InvincibleMod.MODID);
	public static final RegistryObject<MobEffect> MARS_SHADER = REGISTRY.register("mars_shader", () -> new MarsShaderMobEffect());
	public static final RegistryObject<MobEffect> SLAM_TIMER = REGISTRY.register("slam_timer", () -> new SlamTimerMobEffect());
	public static final RegistryObject<MobEffect> TAKEOFF_EFFECTS = REGISTRY.register("takeoff_effects", () -> new TakeoffEffectsMobEffect());
	public static final RegistryObject<MobEffect> POINT_DESTRUCTION = REGISTRY.register("point_destruction", () -> new PointDestructionMobEffect());
	public static final RegistryObject<MobEffect> DESTRUCTION_ACTIVE = REGISTRY.register("destruction_active", () -> new DestructionActiveMobEffect());
	public static final RegistryObject<MobEffect> COMBO_STILL = REGISTRY.register("combo_still", () -> new ComboStillMobEffect());
	public static final RegistryObject<MobEffect> GRABBING_ACTIVE = REGISTRY.register("grabbing_active", () -> new GrabbingActiveMobEffect());
	public static final RegistryObject<MobEffect> GRABBED = REGISTRY.register("grabbed", () -> new GrabbedMobEffect());
	public static final RegistryObject<MobEffect> COOLDOWN = REGISTRY.register("cooldown", () -> new CooldownMobEffect());
	public static final RegistryObject<MobEffect> AFTER_IMAGES = REGISTRY.register("after_images", () -> new AfterImagesMobEffect());
	public static final RegistryObject<MobEffect> ACTIVE_BURST = REGISTRY.register("active_burst", () -> new ActiveBurstMobEffect());
	public static final RegistryObject<MobEffect> IMPACT_FRAME_POTION = REGISTRY.register("impact_frame_potion", () -> new ImpactFramePotionMobEffect());
	public static final RegistryObject<MobEffect> POINT_DESTRUCTION_UNIVERSAL = REGISTRY.register("point_destruction_universal", () -> new PointDestructionUniversalMobEffect());
	public static final RegistryObject<MobEffect> DESTRUCTION_ACTIVE_BURST = REGISTRY.register("destruction_active_burst", () -> new DestructionActiveBurstMobEffect());
	public static final RegistryObject<MobEffect> PUNCH_CATCH_CD = REGISTRY.register("punch_catch_cd", () -> new PunchCatchCDMobEffect());
	public static final RegistryObject<MobEffect> PUNCH_CATCH_ACTIVE = REGISTRY.register("punch_catch_active", () -> new PunchCatchActiveMobEffect());
	public static final RegistryObject<MobEffect> HEAVY_STUN = REGISTRY.register("heavy_stun", () -> new HeavyStunMobEffect());
	public static final RegistryObject<MobEffect> FALLING_BLOCKS_MANIP = REGISTRY.register("falling_blocks_manip", () -> new FallingBlocksManipMobEffect());
	public static final RegistryObject<MobEffect> FLASH_TIME = REGISTRY.register("flash_time", () -> new FlashTimeMobEffect());
	public static final RegistryObject<MobEffect> SLOWED = REGISTRY.register("slowed", () -> new SlowedMobEffect());
	public static final RegistryObject<MobEffect> VILTRUMITE_NPC_FOLLOW_UP_TRIGGER = REGISTRY.register("viltrumite_npc_follow_up_trigger", () -> new ViltrumiteNPCFollowUpTriggerMobEffect());
	public static final RegistryObject<MobEffect> BACKWARDS_TUMBLE = REGISTRY.register("backwards_tumble", () -> new BackwardsTumbleMobEffect());
	public static final RegistryObject<MobEffect> SMOKING = REGISTRY.register("smoking", () -> new SmokingMobEffect());
	public static final RegistryObject<MobEffect> CIRCLE_EXPANDING_BURST = REGISTRY.register("circle_expanding_burst", () -> new CircleExpandingBurstMobEffect());
	public static final RegistryObject<MobEffect> GLASS_BREAK = REGISTRY.register("glass_break", () -> new GlassBreakMobEffect());
	public static final RegistryObject<MobEffect> BULLET_SLAM = REGISTRY.register("bullet_slam", () -> new BulletSlamMobEffect());
	public static final RegistryObject<MobEffect> SMOKE_CIRCLE_EXPANDING = REGISTRY.register("smoke_circle_expanding", () -> new SmokeCircleExpandingMobEffect());
	public static final RegistryObject<MobEffect> INSTANT_CRATER = REGISTRY.register("instant_crater", () -> new InstantCraterMobEffect());
	public static final RegistryObject<MobEffect> ACTIVE_FLIGHT_SPEED = REGISTRY.register("active_flight_speed", () -> new ActiveFlightSpeedMobEffect());
	public static final RegistryObject<MobEffect> NO_FALL = REGISTRY.register("no_fall", () -> new NoFallMobEffect());
	public static final RegistryObject<MobEffect> GRAB_COOLDOWN = REGISTRY.register("grab_cooldown", () -> new GrabCooldownMobEffect());
	public static final RegistryObject<MobEffect> HYPER_SONIC = REGISTRY.register("hyper_sonic", () -> new HyperSonicMobEffect());
}
