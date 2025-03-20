package net.mcreator.invincible.procedures;

import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.Connection;
import net.minecraft.client.Minecraft;

import net.mcreator.invincible.init.InvincibleModMobEffects;
import net.mcreator.invincible.InvincibleMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Iterator;

import com.mojang.blaze3d.platform.InputConstants;

@Mod.EventBusSubscriber
public class FlightTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity)) {
			if (entity.getPersistentData().getBoolean("flight")) {
				if (entity instanceof Player _player) {
					_player.getAbilities().flying = true;
					_player.onUpdateAbilities();
				}
				if (Minecraft.getInstance().options.keyShift.getKey().getValue() == InputConstants.KEY_LSHIFT) {
					if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_LSHIFT)) {
						if (world.isClientSide()) {
							SetupAnimationsProcedure.setAnimationClientside((Player) entity, "descending", true);
						}
						if (!world.isClientSide()) {
							if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
								List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
								synchronized (connections) {
									Iterator<Connection> iterator = connections.iterator();
									while (iterator.hasNext()) {
										Connection connection = iterator.next();
										if (!connection.isConnecting() && connection.isConnected())
											InvincibleMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.InvincibleModAnimationMessage(Component.literal("descending"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
									}
								}
							}
						}
					}
				} else if (Minecraft.getInstance().options.keyShift.getKey().getValue() == InputConstants.KEY_LCONTROL) {
					if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_LCONTROL)) {
						if (world.isClientSide()) {
							SetupAnimationsProcedure.setAnimationClientside((Player) entity, "descending", true);
						}
						if (!world.isClientSide()) {
							if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
								List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
								synchronized (connections) {
									Iterator<Connection> iterator = connections.iterator();
									while (iterator.hasNext()) {
										Connection connection = iterator.next();
										if (!connection.isConnecting() && connection.isConnected())
											InvincibleMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.InvincibleModAnimationMessage(Component.literal("descending"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
									}
								}
							}
						}
					}
				}
				if (entity.isSprinting()) {
					if (!(entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(InvincibleModMobEffects.GRABBING_ACTIVE.get()))) {
						if (!(entity.getXRot() == 90 && entity.getXRot() == -90)) {
							if (world.isClientSide()) {
								SetupAnimationsProcedure.setAnimationClientside((Player) entity, "flight", true);
							}
							if (!world.isClientSide()) {
								if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
									List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
									synchronized (connections) {
										Iterator<Connection> iterator = connections.iterator();
										while (iterator.hasNext()) {
											Connection connection = iterator.next();
											if (!connection.isConnecting() && connection.isConnected())
												InvincibleMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.InvincibleModAnimationMessage(Component.literal("flight"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
										}
									}
								}
							}
						}
					}
				}
			} else {
				if (entity instanceof Player _player) {
					_player.getAbilities().flying = false;
					_player.onUpdateAbilities();
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(InvincibleModMobEffects.GRABBING_ACTIVE.get())) {
			if (world.isClientSide()) {
				SetupAnimationsProcedure.setAnimationClientside((Player) entity, "grab", true);
			}
			if (!world.isClientSide()) {
				if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
					List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
					synchronized (connections) {
						Iterator<Connection> iterator = connections.iterator();
						while (iterator.hasNext()) {
							Connection connection = iterator.next();
							if (!connection.isConnecting() && connection.isConnected())
								InvincibleMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.InvincibleModAnimationMessage(Component.literal("grab"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
						}
					}
				}
			}
		}
	}
}
