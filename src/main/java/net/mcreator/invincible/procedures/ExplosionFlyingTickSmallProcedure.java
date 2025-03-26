package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ExplosionFlyingTickSmallProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.EXPLODE.get()), x, y, z, 1, 0.1, 0.1, 0.1, 0);
		if (immediatesourceentity.getPersistentData().getDouble("explosionTimer") == 0) {
			immediatesourceentity.getPersistentData().putDouble("explosionTimer", (Mth.nextInt(RandomSource.create(), 5, 10)));
		}
		if (immediatesourceentity.getPersistentData().getDouble("explosionTimer") > 1) {
			immediatesourceentity.getPersistentData().putDouble("explosionTimer", (immediatesourceentity.getPersistentData().getDouble("explosionTimer") - 1));
		}
		if (immediatesourceentity.getPersistentData().getDouble("explosionTimer") == 1) {
			SmallExplosionHitProcedure.execute(world, x, y, z, entity, immediatesourceentity);
		}
	}
}
