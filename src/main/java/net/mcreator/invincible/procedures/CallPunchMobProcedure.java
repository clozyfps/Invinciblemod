package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.invincible.network.InvincibleModVariables;

public class CallPunchMobProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		magnitude = Math.sqrt(sourceentity.getLookAngle().x * sourceentity.getLookAngle().x + sourceentity.getLookAngle().y * sourceentity.getLookAngle().y + sourceentity.getLookAngle().z * sourceentity.getLookAngle().z);
		vecX = sourceentity.getLookAngle().x / magnitude;
		vecY = sourceentity.getLookAngle().y / magnitude;
		vecZ = sourceentity.getLookAngle().z / magnitude;
		vecX = vecX * ((sourceentity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 10);
		vecY = vecY * ((sourceentity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 10);
		vecZ = vecZ * ((sourceentity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 10);
		entity.push(vecX, vecY, vecZ);
	}
}
