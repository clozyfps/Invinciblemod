package net.mcreator.invincible.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.invincible.network.InvincibleModVariables;
import net.mcreator.invincible.init.InvincibleModEntities;

public class SpacePlayerEntersDimensionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).LastPlanet).equals("Earth")) {
			{
				Entity _ent = entity;
				_ent.teleportTo(100, 40, 100);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(100, 40, 100, _ent.getYRot(), _ent.getXRot());
			}
		} else if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).LastPlanet).equals("Mars")) {
			{
				Entity _ent = entity;
				_ent.teleportTo(300, 65, 300);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(300, 65, 300, _ent.getYRot(), _ent.getXRot());
			}
		} else if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).LastPlanet).equals("Viltrum")) {
			{
				Entity _ent = entity;
				_ent.teleportTo(700, 65, 700);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(700, 65, 700, _ent.getYRot(), _ent.getXRot());
			}
		}
		if (InvincibleModVariables.MapVariables.get(world).GeneratedPlanets == false) {
			InvincibleModVariables.MapVariables.get(world).GeneratedPlanets = true;
			InvincibleModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = InvincibleModEntities.EARTH.get().spawn(_level, new BlockPos(100, 0, 100), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = InvincibleModEntities.VILTRUM_PLANET.get().spawn(_level, new BlockPos(700, 25, 700), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = InvincibleModEntities.MARS_PLANET.get().spawn(_level, new BlockPos(300, 25, 300), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Generated Space"), false);
		}
	}
}
