package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;

public class WebLineProjectileHitsBlockProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		WebSwingProcedure.execute(x, y, z, entity);
	}
}
