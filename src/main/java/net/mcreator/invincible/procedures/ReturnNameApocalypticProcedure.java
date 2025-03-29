package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ReturnNameApocalypticProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).DimensionList).contains("Apocalyptic" + ", ")) {
			return "Apocalyptic Dimension";
		}
		return "Unknown";
	}
}
