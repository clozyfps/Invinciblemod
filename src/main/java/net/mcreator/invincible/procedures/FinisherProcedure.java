package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

@Mod.EventBusSubscriber
public class FinisherProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event);
		}
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
	}
}
