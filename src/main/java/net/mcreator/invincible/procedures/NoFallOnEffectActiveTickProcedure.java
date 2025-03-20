package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;

public class NoFallOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.fallDistance = 0;
	}
}
