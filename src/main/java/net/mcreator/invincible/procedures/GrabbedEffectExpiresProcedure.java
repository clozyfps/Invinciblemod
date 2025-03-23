package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;

public class GrabbedEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("grabbed", false);
	}
}
