package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.invincible.network.InvincibleModVariables;
import net.mcreator.invincible.init.InvincibleModMobEffects;

public class MoveNameDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String textmove = "";
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(InvincibleModMobEffects.COOLDOWN.get()))) {
			textmove = "\u00A7l" + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).MoveSelected;
		} else if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(InvincibleModMobEffects.COOLDOWN.get())) {
			textmove = "\u00A7c\u00A7l" + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).MoveSelected;
		}
		return textmove;
	}
}
