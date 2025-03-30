package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

public class AddPointDefenceProcedure {
public static void execute(
Entity entity
) {
if(
entity == null
) return ;
double leftover_points = 0;
if (>=&&(entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Defense<100) {if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Defense+>100) {leftover_points = ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Defense+)-100;{
double _setval = (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Defense+-leftover_points;
entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.Defense = _setval;
capability.syncPlayerVariables(entity);
});
}
}else{{
double _setval = (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Defense+;
entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.Defense = _setval;
capability.syncPlayerVariables(entity);
});
}
}}else if (<&&(entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Defense<100) {if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Defense+>100) {leftover_points = ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Defense+)-100;{
double _setval = (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Defense+-leftover_points;
entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.Defense = _setval;
capability.syncPlayerVariables(entity);
});
}
}else{{
double _setval = (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Defense+;
entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.Defense = _setval;
capability.syncPlayerVariables(entity);
});
}
}}
}
}
