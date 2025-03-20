package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.invincible.network.InvincibleModVariables;

public class WebSwingProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double WebPower = 0;
		double LocalWeb = 0;
		WebPower = 50;
		{
			double _setval = (x - entity.getX()) / WebPower;
			entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.WebX = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (y - entity.getY()) / WebPower;
			entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.WebY = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (z - entity.getZ()) / WebPower;
			entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.WebZ = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = 5;
			entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.WebN = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
