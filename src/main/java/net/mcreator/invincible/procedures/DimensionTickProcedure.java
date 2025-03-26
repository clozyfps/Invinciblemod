package net.mcreator.invincible.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.invincible.entity.FlaxanSoldierEntity;
import net.mcreator.invincible.entity.FlaxanGunmanEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DimensionTickProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("invincible:flaxxan_dimension"))) {
			if (!(entity instanceof Player || entity instanceof FlaxanSoldierEntity || entity instanceof FlaxanGunmanEntity)) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}
}
