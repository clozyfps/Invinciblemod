package net.mcreator.invincible.procedures;

import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.Connection;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.invincible.network.InvincibleModVariables;
import net.mcreator.invincible.init.InvincibleModParticleTypes;
import net.mcreator.invincible.init.InvincibleModMobEffects;
import net.mcreator.invincible.InvincibleMod;

import javax.annotation.Nullable;

import java.util.Map;
import java.util.List;
import java.util.Iterator;

import com.mojang.blaze3d.platform.InputConstants;

@Mod.EventBusSubscriber
public class FlightTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
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
			if (entity.isSprinting()) {
				int horizontalRadiusSphere = (int) (4 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50) - 1;
				int verticalRadiusSphere = (int) (4 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50) - 1;
				int yIterationsSphere = verticalRadiusSphere;
				for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
					for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
						for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
							double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
									+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
							if (distanceSq <= 1.0) {
								if ((world.getBlockState(BlockPos.containing(
										(entity.getX() + entity.getLookAngle().x * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50)) + xi,
										(entity.getY() + entity.getEyeHeight()
												+ entity.getLookAngle().y * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50)) + i,
										(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50)) + zi)))
										.getBlock() == Blocks.SAND) {
									if (Math.random() < 0.5) {
										world.addParticle((SimpleParticleType) (InvincibleModParticleTypes.SAND_SMOKE.get()),
												(entity.getX() + entity.getLookAngle().x * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50))
														+ xi,
												(entity.getY() + entity.getEyeHeight()
														+ entity.getLookAngle().y * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50)) + i,
												(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50))
														+ zi,
												0, 0.05, 0);
									}
								} else if ((world.getBlockState(BlockPos.containing(
										(entity.getX() + entity.getLookAngle().x * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50)) + xi,
										(entity.getY() + entity.getEyeHeight()
												+ entity.getLookAngle().y * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50)) + i,
										(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50)) + zi)))
										.is(BlockTags.create(new ResourceLocation("minecraft:dirt")))) {
									if (Math.random() < 0.5) {
										world.addParticle((SimpleParticleType) (InvincibleModParticleTypes.DIRT_SMOKE.get()),
												(entity.getX() + entity.getLookAngle().x * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50))
														+ xi,
												(entity.getY() + entity.getEyeHeight()
														+ entity.getLookAngle().y * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50)) + i,
												(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50))
														+ zi,
												0, 0.05, 0);
									}
								} else if ((world.getBlockState(BlockPos.containing(
										(entity.getX() + entity.getLookAngle().x * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50)) + xi,
										(entity.getY() + entity.getEyeHeight()
												+ entity.getLookAngle().y * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50)) + i,
										(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50)) + zi)))
										.getBlock() == Blocks.WATER) {
									if (Math.random() < 0.5) {
										world.addParticle((SimpleParticleType) (InvincibleModParticleTypes.STEAM_SMOKE.get()),
												(entity.getX() + entity.getLookAngle().x * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50))
														+ xi,
												(entity.getY() + entity.getEyeHeight()
														+ entity.getLookAngle().y * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50)) + i,
												(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50))
														+ zi,
												0, 0.05, 0);
									}
								}
								{
									BlockPos _bp = BlockPos.containing(
											(entity.getX() + entity.getLookAngle().x * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50)) + xi,
											(entity.getY() + entity.getEyeHeight()
													+ entity.getLookAngle().y * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50)) + i,
											(entity.getZ() + entity.getLookAngle().z * (1 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50)) + zi);
									BlockState _bs = Blocks.AIR.defaultBlockState();
									BlockState _bso = world.getBlockState(_bp);
									for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
										Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
										if (_property != null && _bs.getValue(_property) != null)
											try {
												_bs = _bs.setValue(_property, (Comparable) entry.getValue());
											} catch (Exception e) {
											}
									}
									world.setBlock(_bp, _bs, 3);
								}
							}
						}
					}
				}
				if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength >= 10) {
					if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).ToggleSpecial == true) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.DESTRUCTION_ACTIVE_BURST.get(), 5, 0, false, false));
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 250, false, false));
				}
			}
			if ((entity instanceof LivingEntity _livEnt36 && _livEnt36.hasEffect(InvincibleModMobEffects.GRABBING_ACTIVE.get())) == true) {
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
