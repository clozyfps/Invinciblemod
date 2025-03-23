package net.mcreator.invincible.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.invincible.network.InvincibleModVariables;

public class UseAbilityKey5Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).KeyHeld == false) {
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).InputDelay == 0) {
				{
					boolean _setval = true;
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.KeyHeld = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).KeyHeld == true) {
			{
				boolean _setval = false;
				entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.KeyHeld = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Race).equals("Viltrumite")) {
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).AbilityBar == 1) {
				{
					String _setval = "Hyper Sonic Dash";
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MoveSelected = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).AbilityBar == 2) {
				{
					String _setval = "";
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MoveSelected = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			ViltrumiteMovesProcedure.execute(world, x, y, z, entity);
		}
		if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Race).equals("Speedster")) {
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).AbilityBar == 1) {
				{
					String _setval = "";
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MoveSelected = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).AbilityBar == 2) {
				{
					String _setval = "";
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MoveSelected = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			SelectSpeedsterProcedure.execute(entity);
		}
		if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Race).equals("Spider")) {
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).AbilityBar == 1) {
				{
					String _setval = "";
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MoveSelected = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).AbilityBar == 2) {
				{
					String _setval = "";
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MoveSelected = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			SpiderMovesProcedure.execute(world, x, y, z, entity);
		}
		if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Race).equals("Explode")) {
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).AbilityBar == 1) {
				{
					String _setval = "";
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MoveSelected = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).AbilityBar == 2) {
				{
					String _setval = "";
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MoveSelected = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			ExplodeMovesProcedure.execute(entity);
		}
	}
}
