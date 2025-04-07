package net.mcreator.invincible.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.invincible.init.InvincibleModParticleTypes;
import net.mcreator.invincible.init.InvincibleModMobEffects;
import net.mcreator.invincible.entity.BattleBeastEntity;
import net.mcreator.invincible.InvincibleMod;

import java.util.List;
import java.util.Comparator;

public class BattleBeastOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).isAlive()) {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					if (Math.random() < 0.01) {
						if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(InvincibleModMobEffects.BEAST_SLICE_INTERVALS.get())
								|| entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(InvincibleModMobEffects.BEAST_MOB_TIMERS.get()))) {
							entity.push(0, 2, 0);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 25, 1, 1, 1, 0);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.POOF, x, y, z, 5, 1, 1, 1, 0.2);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							InvincibleMod.queueServerWork(5, () -> {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.ACTIVE_AIR_SLAM_CLAW.get(), 25, 0, false, false));
							});
							InvincibleMod.queueServerWork(15, () -> {
								entity.push(0, (-3), 0);
							});
						}
					}
					if (Math.random() < 0.01) {
						if (!(entity instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(InvincibleModMobEffects.BEAST_MOB_TIMERS.get()))) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.BEAST_SLICE_INTERVALS.get(), 40, 0, false, false));
						}
					}
					if (Math.random() < 0.01) {
						if (!(entity instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(InvincibleModMobEffects.BEAST_SLICE_INTERVALS.get()))) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.BEAST_MOB_TIMERS.get(), 50, 0, false, false));
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.SHOCKWAVE_BIG.get()), x, (y + 1), z, 15, 0.1, 0.1, 0.1, 0);
							if (entity instanceof BattleBeastEntity) {
								((BattleBeastEntity) entity).setAnimation("attack");
							}
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entity == entityiterator)) {
										entityiterator.push(0, 2, 0);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("invincible:powerfulpunch2")),
														SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("invincible:powerfulpunch2")),
														SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 10);
										entityiterator.getPersistentData().putBoolean("beasttarget", true);
									}
								}
							}
						}
					}
					if (Math.random() < 0.01) {
						if (!(entity instanceof LivingEntity _livEnt34 && _livEnt34.hasEffect(InvincibleModMobEffects.BEAST_MOB_TIMERS.get()))
								|| !(entity instanceof LivingEntity _livEnt35 && _livEnt35.hasEffect(InvincibleModMobEffects.BEAST_SLICE_INTERVALS.get()))) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.DRAG.get(), 50, 0, false, false));
						}
					}
				}
			}
		}
	}
}
