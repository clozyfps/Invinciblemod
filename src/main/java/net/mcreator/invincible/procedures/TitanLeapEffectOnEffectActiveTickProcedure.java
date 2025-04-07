package net.mcreator.invincible.procedures;

import net.minecraftforge.network.NetworkDirection;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.Connection;

import net.mcreator.invincible.init.InvincibleModMobEffects;
import net.mcreator.invincible.InvincibleMod;

import java.util.List;
import java.util.Iterator;

public class TitanLeapEffectOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.isClientSide()) {
			SetupAnimationsProcedure.setAnimationClientside((Player) entity, "chargejump", true);
		}
		if (!world.isClientSide()) {
			if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
				List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
				synchronized (connections) {
					Iterator<Connection> iterator = connections.iterator();
					while (iterator.hasNext()) {
						Connection connection = iterator.next();
						if (!connection.isConnecting() && connection.isConnected())
							InvincibleMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.InvincibleModAnimationMessage(Component.literal("chargejump"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
					}
				}
			}
		}
		entity.getPersistentData().putDouble("titanleap", (entity.getPersistentData().getDouble("titanleap") + 1));
		entity.getPersistentData().putDouble("titanleapfx", (entity.getPersistentData().getDouble("titanleapfx") + 1));
		entity.getPersistentData().putDouble("titanleapfx", (entity.getPersistentData().getDouble("titanleapfx") + 1));
		if (entity.getPersistentData().getDouble("titanleap") >= 200) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(InvincibleModMobEffects.TITAN_LEAP_EFFECT.get());
			TitanLeapEffectEffectExpiresProcedure.execute(world, x, y, z, entity);
			LeapProcedureProcedure.execute(entity);
			entity.getPersistentData().putDouble("titanleap", 0);
		}
		if (entity.getPersistentData().getDouble("titanleapfx") >= 10) {
			entity.getPersistentData().putDouble("titanleapfx", 0);
		}
		if (!(entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(InvincibleModMobEffects.POOF_EXPAND.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.POOF_EXPAND.get(), 15, 0, false, false));
		}
	}
}
