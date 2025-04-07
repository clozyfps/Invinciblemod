package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;

public class LeapProcedureProcedure {
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
		vecX = vecX * (2 + entity.getPersistentData().getDouble("titanleap") / 25);
		vecY = vecY * (2 + entity.getPersistentData().getDouble("titanleap") / 30);
		vecZ = vecZ * (2 + entity.getPersistentData().getDouble("titanleap") / 25);
		entity.push(vecX, vecY, vecZ);
	}
}
