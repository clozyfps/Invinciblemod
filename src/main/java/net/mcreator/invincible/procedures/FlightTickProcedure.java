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
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.Connection;
import net.minecraft.client.Minecraft;

import net.mcreator.invincible.network.InvincibleModVariables;
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
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
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
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Flying == true) {
				entity.fallDistance = 0;
				magnitude = Math.sqrt(entity.getLookAngle().x * entity.getLookAngle().x + entity.getLookAngle().y * entity.getLookAngle().y + entity.getLookAngle().z * entity.getLookAngle().z);
				vecX = entity.getLookAngle().x / magnitude;
				vecY = entity.getLookAngle().y / magnitude;
				vecZ = entity.getLookAngle().z / magnitude;
				if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength >= 25) {
					if (entity.isSprinting()) {
						if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).ToggleSpecial) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.DESTRUCTION_ACTIVE_BURST.get(), 5, 0, false, false));
						}
					}
				}
				if (entity.isShiftKeyDown()) {
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
				if (entity instanceof Player _player) {
					_player.getAbilities().flying = true;
					_player.onUpdateAbilities();
				}
				if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_W)) {
					if ((entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(InvincibleModMobEffects.ACTIVE_FLIGHT_SPEED.get())) == true) {
						vecX = vecX * 0.5;
						vecY = vecY * 1;
						vecZ = vecZ * 0.5;
						entity.push(vecX, vecY, vecZ);
						if ((entity instanceof LivingEntity _livEnt19 && _livEnt19.hasEffect(InvincibleModMobEffects.GRABBING_ACTIVE.get())) == false) {
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
					} else if (entity.isSprinting()) {
						vecX = vecX * 0.1;
						vecY = vecY * 0.5;
						vecZ = vecZ * 0.1;
						entity.push(vecX, vecY, vecZ);
						if ((entity instanceof LivingEntity _livEnt25 && _livEnt25.hasEffect(InvincibleModMobEffects.GRABBING_ACTIVE.get())) == false) {
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
				}
			} else {
				if (entity instanceof Player _player) {
					_player.getAbilities().flying = false;
					_player.onUpdateAbilities();
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt30 && _livEnt30.hasEffect(InvincibleModMobEffects.GRABBING_ACTIVE.get())) == true) {
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
			if (entity.isSprinting()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.DESTRUCTION_ACTIVE_BURST.get(), 5, 0, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 250, false, false));
			}
		}
	}
}
