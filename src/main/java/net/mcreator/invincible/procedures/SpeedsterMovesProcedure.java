package net.mcreator.invincible.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.invincible.network.InvincibleModVariables;
import net.mcreator.invincible.init.InvincibleModMobEffects;
import net.mcreator.invincible.InvincibleMod;

public class SpeedsterMovesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).MoveSelected).equals("Flash Time")) {
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).KeyHeld == false) {
				if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Cooldown1 == 0) {
					if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(InvincibleModMobEffects.FLASH_TIME.get()))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.FLASH_TIME.get(), 99999, 0, false, false));
					} else if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(InvincibleModMobEffects.FLASH_TIME.get())) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(InvincibleModMobEffects.FLASH_TIME.get());
						{
							double _setval = 100;
							entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Cooldown1 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
		}
		if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).MoveSelected).equals("Multi Hit Strike")) {
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).KeyHeld == false) {
				if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Cooldown2 == 0) {
					{
						double _setval = 80;
						entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Cooldown2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					MultiHitProcedure.execute(world, x, y, z, entity);
					InvincibleMod.queueServerWork(5, () -> {
						MultiHitProcedure.execute(world, x, y, z, entity);
						InvincibleMod.queueServerWork(5, () -> {
							MultiHitProcedure.execute(world, x, y, z, entity);
							InvincibleMod.queueServerWork(10, () -> {
								PushMultiHitProcedure.execute(world, x, y, z, entity);
							});
						});
					});
				}
			}
		}
		if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).MoveSelected).equals("Time Stop")) {
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).KeyHeld == false) {
				if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Cooldown3 == 0) {
					TimeStopProcedure.execute(world, x, y, z, entity);
				}
			}
		}
	}
}
