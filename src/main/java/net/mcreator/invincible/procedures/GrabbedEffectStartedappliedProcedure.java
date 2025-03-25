package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;

public class GrabbedEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("grabbed", true);
	}
}
