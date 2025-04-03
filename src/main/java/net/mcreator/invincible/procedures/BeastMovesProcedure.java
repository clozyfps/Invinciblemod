package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.invincible.network.InvincibleModVariables;
import net.mcreator.invincible.init.InvincibleModMobEffects;

public class BeastMovesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).MoveSelected).equals("Titan Leap")) {
			if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(InvincibleModMobEffects.TITAN_LEAP_EFFECT.get()))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.TITAN_LEAP_EFFECT.get(), 99999, 0, false, false));
			} else if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(InvincibleModMobEffects.TITAN_LEAP_EFFECT.get())) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(InvincibleModMobEffects.TITAN_LEAP_EFFECT.get());
				if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Cooldown1 == 0) {
					{
						double _setval = 80;
						entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Cooldown1 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
		if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).MoveSelected).equals("Claws")) {
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Cooldown2 == 0) {
				{
					double _setval = 40;
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cooldown2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
