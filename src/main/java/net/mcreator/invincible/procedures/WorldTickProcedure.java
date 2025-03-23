package net.mcreator.invincible.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.invincible.network.InvincibleModVariables;
import net.mcreator.invincible.init.InvincibleModEntities;

import javax.annotation.Nullable;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class WorldTickProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		InvincibleModVariables.WorldVariables.get(world).EventTimer = InvincibleModVariables.WorldVariables.get(world).EventTimer + 1;
		InvincibleModVariables.WorldVariables.get(world).syncData(world);
		if (InvincibleModVariables.WorldVariables.get(world).EventTimer >= 18000) {
			InvincibleModVariables.WorldVariables.get(world).EventTimer = 0;
			InvincibleModVariables.WorldVariables.get(world).syncData(world);
			if (Mth.nextInt(RandomSource.create(), 1, 1) == 1) {
				InvincibleModVariables.WorldVariables.get(world).EventX = world.getLevelData().getXSpawn() + Mth.nextInt(RandomSource.create(), -100, 100);
				InvincibleModVariables.WorldVariables.get(world).syncData(world);
				InvincibleModVariables.WorldVariables.get(world).EventZ = world.getLevelData().getZSpawn() + Mth.nextInt(RandomSource.create(), -100, 100);
				InvincibleModVariables.WorldVariables.get(world).syncData(world);
				InvincibleModVariables.WorldVariables.get(world).EventY = world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) InvincibleModVariables.WorldVariables.get(world).EventX,
						(int) InvincibleModVariables.WorldVariables.get(world).EventZ);
				InvincibleModVariables.WorldVariables.get(world).syncData(world);
				InvincibleModVariables.WorldVariables.get(world).Event = "The Flaxans Are Invading";
				InvincibleModVariables.WorldVariables.get(world).syncData(world);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = InvincibleModEntities.FLAXAN_PORTAL.get().spawn(_level,
							BlockPos.containing(InvincibleModVariables.WorldVariables.get(world).EventX, InvincibleModVariables.WorldVariables.get(world).EventY, InvincibleModVariables.WorldVariables.get(world).EventZ), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
			}
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList()
						.broadcastSystemMessage(
								Component.literal(("\u00A7c\u00A7l" + InvincibleModVariables.WorldVariables.get(world).Event + " At:" + " X: " + new java.text.DecimalFormat("#").format(InvincibleModVariables.WorldVariables.get(world).EventX) + " Y: "
										+ new java.text.DecimalFormat("#").format(InvincibleModVariables.WorldVariables.get(world).EventY) + " Z: " + new java.text.DecimalFormat("#").format(InvincibleModVariables.WorldVariables.get(world).EventZ))),
								false);
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.spawn")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.spawn")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		}
	}
}
