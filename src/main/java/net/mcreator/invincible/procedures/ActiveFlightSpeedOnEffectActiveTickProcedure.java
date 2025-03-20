package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;

public class ActiveFlightSpeedOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		magnitude = Math.sqrt(entity.getLookAngle().x * entity.getLookAngle().x + entity.getLookAngle().y * entity.getLookAngle().y + entity.getLookAngle().z * entity.getLookAngle().z);
		vecX = entity.getLookAngle().x / magnitude;
		vecY = entity.getLookAngle().y / magnitude;
		vecZ = entity.getLookAngle().z / magnitude;
		vecX = vecX * 0.2;
		vecY = vecY * 0.2;
		vecZ = vecZ * 0.2;
		entity.push(vecX, vecY, vecZ);
	}
}
