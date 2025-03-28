package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.invincible.entity.DimensionalPortalEntity;

public class DimensionalPortalOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof DimensionalPortalEntity) {
			((DimensionalPortalEntity) entity).setAnimation("portalopen");
		}
	}
}
