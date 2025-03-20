package net.mcreator.invincible.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class TakeoffEffectsOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xRadius = 0;
		double zRadius = 0;
		double degree = 0;
		double x_pos = 0;
		double y_pos = 0;
		double z_pos = 0;
		degree = Math.toRadians(entity.getYRot());
		xRadius = entity.getPersistentData().getDouble("xincrease");
		zRadius = entity.getPersistentData().getDouble("zincrease");
		for (int index0 = 0; index0 < 36; index0++) {
			x_pos = x + Math.cos(degree) * xRadius;
			y_pos = y + 0.1;
			z_pos = z + Math.sin(degree) * zRadius;
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.2);
			degree = degree + Math.toRadians(5);
		}
		degree = Math.toRadians(entity.getYRot());
		xRadius = entity.getPersistentData().getDouble("xdecrease");
		zRadius = entity.getPersistentData().getDouble("zdecrease");
		for (int index1 = 0; index1 < 36; index1++) {
			x_pos = x + Math.cos(degree) * xRadius;
			y_pos = y + 0.1;
			z_pos = z + Math.sin(degree) * zRadius;
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.2);
			degree = degree + Math.toRadians(5);
		}
		entity.getPersistentData().putDouble("xincrease", (entity.getPersistentData().getDouble("xincrease") + 0.6));
		entity.getPersistentData().putDouble("zincrease", (entity.getPersistentData().getDouble("zincrease") + 0.6));
		entity.getPersistentData().putDouble("zdecrease", (entity.getPersistentData().getDouble("zdecrease") - 0.6));
		entity.getPersistentData().putDouble("xdecrease", (entity.getPersistentData().getDouble("xdecrease") - 0.6));
	}
}
