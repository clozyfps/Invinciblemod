package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

@Mod.EventBusSubscriber
public class EntityNoDamageProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("invincible:nodamage")))) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}
