package net.mcreator.invincible.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class FlyOnKeyReleasedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		if (entity.getPersistentData().getBoolean("jumpcharge")) {
			entity.getPersistentData().putBoolean("jumpcharge", false);
			entity.push((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() + entity.getPersistentData().getDouble("jumpchargetick") * 3), (entity.getDeltaMovement().z()));
			magnitude = Math.sqrt(entity.getLookAngle().x * entity.getLookAngle().x + entity.getLookAngle().y * entity.getLookAngle().y + entity.getLookAngle().z * entity.getLookAngle().z);
			vecX = entity.getLookAngle().x / magnitude;
			vecY = entity.getLookAngle().y / magnitude;
			vecZ = entity.getLookAngle().z / magnitude;
			vecX = vecX * 0;
			vecY = vecY * entity.getPersistentData().getDouble("jumpchargetick") * 3;
			vecZ = vecZ * 0;
			entity.push(vecX, vecY, vecZ);
			entity.getPersistentData().putDouble("jumpchargetick", 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("invincible:takeoff")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("invincible:takeoff")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}
