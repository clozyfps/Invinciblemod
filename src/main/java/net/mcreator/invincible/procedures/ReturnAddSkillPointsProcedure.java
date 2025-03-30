package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.invincible.network.InvincibleModVariables;

public class ReturnAddSkillPointsProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##").format((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).AddPlayerSkillPoints);
	}
}
