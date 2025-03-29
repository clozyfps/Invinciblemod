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
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof OmnimanEntity) {
			{
				double _setval = (sourceentity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).PowerExp + 250;
				sourceentity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PowerExp = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		}
		if (entity instanceof InvincibleMarkEntity || entity instanceof InvincibleBlueMarkEntity) {
			{
				double _setval = (sourceentity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).PowerExp + 150;
				sourceentity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PowerExp = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		}
		if (entity instanceof RexSplodeEntity || entity instanceof DupliKateEntity) {
			{
				double _setval = (sourceentity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).PowerExp + 30;
				sourceentity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PowerExp = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		}
		if (entity instanceof MaulerEntity || entity instanceof FlaxanSoldierEntity || entity instanceof FlaxanGunmanEntity) {
			{
				double _setval = (sourceentity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).PowerExp + 20;
				sourceentity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PowerExp = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		}
	}
}
