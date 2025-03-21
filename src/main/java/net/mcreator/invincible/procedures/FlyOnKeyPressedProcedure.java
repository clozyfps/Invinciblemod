package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.invincible.network.InvincibleModVariables;

public class FlyOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Race).equals("Viltrumite")) {
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Flying == false) {
				{
					boolean _setval = true;
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Flying = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Flying == true) {
				{
					boolean _setval = false;
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Flying = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
