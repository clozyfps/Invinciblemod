package net.mcreator.invincible.procedures;

import net.minecraftforge.network.NetworkDirection;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.Connection;
import net.minecraft.core.BlockPos;

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
		if (entity.getPersistentData().getDouble("titanleap") >= 200) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(InvincibleModMobEffects.TITAN_LEAP_EFFECT.get());
			entity.getPersistentData().putDouble("titanleap", 0);
		}
		if (entity.getPersistentData().getDouble("titanleapfx") >= 10) {
			entity.getPersistentData().putDouble("titanleapfx", 0);
		}
		int horizontalRadiusHemiBot = (int) (entity.getPersistentData().getDouble("titanleapfx")) - 1;
		int verticalRadiusHemiBot = (int) 1;
		int yIterationsHemiBot = verticalRadiusHemiBot;
		for (int i = -yIterationsHemiBot; i <= 0; i++) {
			if (i == -verticalRadiusHemiBot) {
				continue;
			}
			for (int xi = -horizontalRadiusHemiBot; xi <= horizontalRadiusHemiBot; xi++) {
				for (int zi = -horizontalRadiusHemiBot; zi <= horizontalRadiusHemiBot; zi++) {
					double distanceSq = (xi * xi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot) + (i * i) / (double) (verticalRadiusHemiBot * verticalRadiusHemiBot)
							+ (zi * zi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot);
					if (distanceSq <= 1.0) {
						if (!((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == Blocks.AIR)) {
							world.levelEvent(2001, BlockPos.containing(x + xi, y + i, z + zi), Block.getId((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi)))));
							if (!world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi)).canOcclude()) {
								world.setBlock(BlockPos.containing(x + xi, y + i, z + zi), Blocks.AIR.defaultBlockState(), 3);
							}
						}
					}
				}
			}
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Charging"), true);
	}
}
