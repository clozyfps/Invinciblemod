package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ReturnNameNetherProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).DimensionList).contains("Nether" + ", ")) {
			return "The Nether";
		}
		return "Unknown";
	}
}
