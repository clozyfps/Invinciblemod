package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;

public class PunchCatchActiveOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.invulnerableTime = 1;
	}
}
