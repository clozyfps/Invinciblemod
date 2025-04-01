package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;

public class ReturnPlayerEntityProcedure {
	public static Entity execute(Entity entity) {
		if (entity == null)
			return null;
		return entity;
	}
}
