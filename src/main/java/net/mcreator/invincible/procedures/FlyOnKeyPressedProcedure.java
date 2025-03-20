package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.invincible.network.InvincibleModVariables;

public class FlyOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Race).equals("Viltrumite")) {
			if (!entity.getPersistentData().getBoolean("flight")) {
				entity.getPersistentData().putBoolean("flight", true);
			} else if (entity.getPersistentData().getBoolean("flight")) {
				entity.getPersistentData().putBoolean("flight", false);
			}
		}
	}
}
