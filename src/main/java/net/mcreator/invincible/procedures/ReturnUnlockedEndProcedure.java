package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.invincible.network.InvincibleModVariables;

public class ReturnUnlockedEndProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).DimensionList).contains("End" + ", ")) {
			return true;
		}
		return false;
	}
}
