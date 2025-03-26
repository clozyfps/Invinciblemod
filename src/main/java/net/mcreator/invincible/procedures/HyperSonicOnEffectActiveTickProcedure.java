package net.mcreator.invincible.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.invincible.network.InvincibleModVariables;
import net.mcreator.invincible.init.InvincibleModParticleTypes;
import net.mcreator.invincible.init.InvincibleModMobEffects;

public class HyperSonicOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		magnitude = Math.sqrt(entity.getLookAngle().x * entity.getLookAngle().x + entity.getLookAngle().y * entity.getLookAngle().y + entity.getLookAngle().z * entity.getLookAngle().z);
		vecX = entity.getLookAngle().x / magnitude;
		vecZ = entity.getLookAngle().z / magnitude;
		vecY = entity.getLookAngle().y / magnitude;
		vecX = vecX * (0.5 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50);
		vecY = vecY * (0.5 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50);
		vecZ = vecZ * (0.5 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50);
		entity.push(vecX, vecY, vecZ);
		entity.invulnerableTime = 5;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.NO_FALL.get(), 25, 0, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.HYPER_SONIC_BURST_TICK.get(), 5, 0, false, false));
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FLAME, x, (y + 0.5), z, 20, 1, 1, 1, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.POOF, x, (y + 1), z, 5, 0.1, 0.1, 0.1, 0.2);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, (y + 1), z, 1, 1, 0.1, 1, 0.2);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.SHOCKWAVE_BIG.get()), x, (y + 1), z, 1, 0.1, 0.1, 0.1, 0);
	}
}
