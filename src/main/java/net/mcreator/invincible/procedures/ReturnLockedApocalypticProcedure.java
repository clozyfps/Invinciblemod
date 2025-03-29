package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ReturnLockedApocalypticProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).DimensionList).contains("Apocalyptic" + ", ")) {
			return false;
		}
		return true;
	}
}
