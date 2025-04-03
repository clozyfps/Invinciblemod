package net.mcreator.invincible.procedures;

import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
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
		double flightSpeed = 0;
		boolean creativeFlight = false;
		creativeFlight = false;
		if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Race).equals("Viltrumite")) {
			flightSpeed = 1 + ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Agility / (100 / 0.3)) * 2;
		} else {
			flightSpeed = 1 + ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Agility / (100 / 0.3)) * 2;
		}
		if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Flying == true) {
			entity.fallDistance = 0;
			if ((entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(InvincibleModMobEffects.GRABBING_ACTIVE.get())) == true) {
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
					if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength >= 25) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.DESTRUCTION_ACTIVE_BURST.get(), 5, 0, false, false));
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 250, false, false));
				}
			}
			if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_W) && entity.isSprinting()) {
				if (entity instanceof Player _plr && !(_plr.isFallFlying())) {
					_plr.startFallFlying();
				}
				if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_SPACE)) {
					flightSpeed = flightSpeed * 2.25;
				}
				if (entity instanceof Player player) {
					player.getAbilities().flying = (creativeFlight == true);
					player.onUpdateAbilities();
					if (player.isFallFlying()) {
						Vec3 lookVec = player.getLookAngle();
						Vec3 flightVelocity = new Vec3(lookVec.x * flightSpeed, lookVec.y * flightSpeed, lookVec.z * flightSpeed);
						player.setDeltaMovement(flightVelocity);
					}
				}
				if (world.isClientSide()) {
					SetupAnimationsProcedure.setAnimationClientside((Player) entity, "fly_fast", true);
				}
				if (!world.isClientSide()) {
					if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
						List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
						synchronized (connections) {
							Iterator<Connection> iterator = connections.iterator();
							while (iterator.hasNext()) {
								Connection connection = iterator.next();
								if (!connection.isConnecting() && connection.isConnected())
									InvincibleMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.InvincibleModAnimationMessage(Component.literal("fly_fast"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
							}
						}
					}
				}
				creativeFlight = false;
			} else {
				creativeFlight = true;
				if (entity.isShiftKeyDown()) {
					if (world.isClientSide()) {
						SetupAnimationsProcedure.setAnimationClientside((Player) entity, "fly_down", true);
					}
					if (!world.isClientSide()) {
						if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
							List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
							synchronized (connections) {
								Iterator<Connection> iterator = connections.iterator();
								while (iterator.hasNext()) {
									Connection connection = iterator.next();
									if (!connection.isConnecting() && connection.isConnected())
										InvincibleMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.InvincibleModAnimationMessage(Component.literal("fly_down"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
								}
							}
						}
					}
				} else if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_W)) {
					if (world.isClientSide()) {
						SetupAnimationsProcedure.setAnimationClientside((Player) entity, "fly_forward", true);
					}
					if (!world.isClientSide()) {
						if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
							List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
							synchronized (connections) {
								Iterator<Connection> iterator = connections.iterator();
								while (iterator.hasNext()) {
									Connection connection = iterator.next();
									if (!connection.isConnecting() && connection.isConnected())
										InvincibleMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.InvincibleModAnimationMessage(Component.literal("fly_forward"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
								}
							}
						}
					}
				} else if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_S)) {
					if (world.isClientSide()) {
						SetupAnimationsProcedure.setAnimationClientside((Player) entity, "fly_back", true);
					}
					if (!world.isClientSide()) {
						if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
							List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
							synchronized (connections) {
								Iterator<Connection> iterator = connections.iterator();
								while (iterator.hasNext()) {
									Connection connection = iterator.next();
									if (!connection.isConnecting() && connection.isConnected())
										InvincibleMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.InvincibleModAnimationMessage(Component.literal("fly_back"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
								}
							}
						}
					}
				} else if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_A)) {
					if (world.isClientSide()) {
						SetupAnimationsProcedure.setAnimationClientside((Player) entity, "fly_left", true);
					}
					if (!world.isClientSide()) {
						if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
							List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
							synchronized (connections) {
								Iterator<Connection> iterator = connections.iterator();
								while (iterator.hasNext()) {
									Connection connection = iterator.next();
									if (!connection.isConnecting() && connection.isConnected())
										InvincibleMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.InvincibleModAnimationMessage(Component.literal("fly_left"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
								}
							}
						}
					}
				} else if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_D)) {
					if (world.isClientSide()) {
						SetupAnimationsProcedure.setAnimationClientside((Player) entity, "fly_right", true);
					}
					if (!world.isClientSide()) {
						if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
							List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
							synchronized (connections) {
								Iterator<Connection> iterator = connections.iterator();
								while (iterator.hasNext()) {
									Connection connection = iterator.next();
									if (!connection.isConnecting() && connection.isConnected())
										InvincibleMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.InvincibleModAnimationMessage(Component.literal("fly_right"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
								}
							}
						}
					}
				} else {
					if (world.isClientSide()) {
						SetupAnimationsProcedure.setAnimationClientside((Player) entity, "reset", true);
					}
					if (!world.isClientSide()) {
						if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
							List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
							synchronized (connections) {
								Iterator<Connection> iterator = connections.iterator();
								while (iterator.hasNext()) {
									Connection connection = iterator.next();
									if (!connection.isConnecting() && connection.isConnected())
										InvincibleMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.InvincibleModAnimationMessage(Component.literal("reset"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
								}
							}
						}
					}
				}
			}
		}
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
			if (entity instanceof Player _player) {
				_player.getAbilities().flying = (creativeFlight == true);
				_player.onUpdateAbilities();
			}
		}
	}
}
