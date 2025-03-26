package net.mcreator.invincible.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.invincible.init.InvincibleModEntities;
import net.mcreator.invincible.InvincibleMod;

public class FlaxxanDimensionPlayerEntersDimensionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 250, false, false));
		InvincibleMod.queueServerWork(20, () -> {
			for (int index0 = 0; index0 < 5; index0++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = InvincibleModEntities.FLAXAN_SOLDIER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = InvincibleModEntities.FLAXAN_GUNMAN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = InvincibleModEntities.FLAXAN_PORTAL.get().spawn(_level, BlockPos.containing(x - 3, y, z - 3), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Flaxan's> Intruder!"), false);
			}
		});
	}
}
