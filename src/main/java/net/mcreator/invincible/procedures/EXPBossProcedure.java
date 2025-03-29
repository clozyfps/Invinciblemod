package net.mcreator.invincible.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.invincible.network.InvincibleModVariables;
import net.mcreator.invincible.entity.RexSplodeEntity;
import net.mcreator.invincible.entity.OmnimanEntity;
import net.mcreator.invincible.entity.MaulerEntity;
import net.mcreator.invincible.entity.InvincibleMarkEntity;
import net.mcreator.invincible.entity.InvincibleBlueMarkEntity;
import net.mcreator.invincible.entity.FlaxanSoldierEntity;
import net.mcreator.invincible.entity.FlaxanGunmanEntity;
import net.mcreator.invincible.entity.DupliKateEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EXPBossProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof OmnimanEntity) {
			{
				double _setval = 250;
				entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PowerExp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (entity instanceof InvincibleMarkEntity || entity instanceof InvincibleBlueMarkEntity) {
			{
				double _setval = 150;
				entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PowerExp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (entity instanceof RexSplodeEntity || entity instanceof DupliKateEntity) {
			{
				double _setval = 30;
				entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PowerExp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (entity instanceof MaulerEntity || entity instanceof FlaxanSoldierEntity || entity instanceof FlaxanGunmanEntity) {
			{
				double _setval = 20;
				entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PowerExp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
