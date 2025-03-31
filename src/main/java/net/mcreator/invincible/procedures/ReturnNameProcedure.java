package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ReturnNameProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getDisplayName().getString();
	}
}
