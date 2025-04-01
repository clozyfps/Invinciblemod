package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;

public class ReturnNameProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getDisplayName().getString();
	}
}
