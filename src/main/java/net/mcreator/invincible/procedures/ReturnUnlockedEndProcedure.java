package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

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
