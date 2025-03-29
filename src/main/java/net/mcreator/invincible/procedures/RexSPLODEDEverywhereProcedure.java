package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

@Mod.EventBusSubscriber
public class RexSPLODEDEverywhereProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

private static void execute(
@Nullable Event event,
LevelAccessor world,
double x,
double y,
double z,
Entity entity
) {
if(
entity == null
) return ;
if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new InvincibleModVariables.PlayerVariables())).Race).equals("Explode")) {if (entity.getPersistentData().getDouble("rexSPLODE")>1) {entity.getPersistentData().putDouble("rexSPLODE", (entity.getPersistentData().getDouble("rexSPLODE")-1));}if (>1) {}else if (==1) {
ExplodeSelfProcedure.execute(world,x,y,z,entity)
;
}}
}
}
