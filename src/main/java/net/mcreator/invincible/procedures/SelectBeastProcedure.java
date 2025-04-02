package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SelectBeastProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "Beast";
			entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Race = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = "";
			entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MoveSelected = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
