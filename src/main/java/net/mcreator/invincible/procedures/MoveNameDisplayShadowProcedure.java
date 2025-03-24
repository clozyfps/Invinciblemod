package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.invincible.network.InvincibleModVariables;

public class MoveNameDisplayShadowProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String textmove = "";
		textmove = "\u00A7l" + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).MoveSelected;
		return textmove;
	}
}
