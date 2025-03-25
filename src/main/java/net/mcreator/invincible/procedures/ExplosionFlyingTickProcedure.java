package net.mcreator.invincible.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.invincible.init.InvincibleModParticleTypes;

public class ExplosionFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.EXPLODE.get()), x, y, z, 2, 0.1, 0.1, 0.1, 0);
		if (immediatesourceentity.getPersistentData().getDouble("explosionTimer") == 0) {
			immediatesourceentity.getPersistentData().putDouble("explosionTimer", (Mth.nextInt(RandomSource.create(), 4, 7)));
		}
		if (immediatesourceentity.getPersistentData().getDouble("explosionTimer") > 1) {
			immediatesourceentity.getPersistentData().putDouble("explosionTimer", (immediatesourceentity.getPersistentData().getDouble("explosionTimer") - 1));
		}
		if (immediatesourceentity.getPersistentData().getDouble("explosionTimer") == 1) {
			LargeExplosionHitProcedure.execute(world, x, y, z, entity, immediatesourceentity);
		}
	}
}
