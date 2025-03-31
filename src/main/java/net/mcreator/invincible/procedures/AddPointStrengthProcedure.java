package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

public class AddPointStrengthProcedure {
public static void execute(
Entity entity
) {
if(
entity == null
) return ;
double leftover_points = 0;
if (>=&&(entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Strength<100) {if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Strength+>100) {leftover_points = ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Strength+)-100;{
double _setval = (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Strength+-leftover_points;
entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.Strength = _setval;
capability.syncPlayerVariables(entity);
});
}
}else{{
double _setval = (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Strength+;
entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.Strength = _setval;
capability.syncPlayerVariables(entity);
});
}
}}else if (<&&(entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Strength<100) {if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Strength+>100) {leftover_points = ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Strength+)-100;{
double _setval = (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Strength+-leftover_points;
entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.Strength = _setval;
capability.syncPlayerVariables(entity);
});
}
}else{{
double _setval = (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Strength+;
entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.Strength = _setval;
capability.syncPlayerVariables(entity);
});
}
}}
}
}
