package net.mcreator.invincible.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.invincible.network.InvincibleModVariables;
import net.mcreator.invincible.init.InvincibleModMobEffects;

public class DestructionActiveOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		int horizontalRadiusSphere = (int) (2 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50) - 1;
		int verticalRadiusSphere = (int) (2 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 50) - 1;
		int yIterationsSphere = verticalRadiusSphere;
		for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
			for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
				for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
					double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
							+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
					if (distanceSq <= 1.0) {
						if (!(world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(new ResourceLocation("invincible:indestructible")))) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.EXPLOSION, x + xi, y + i, z + zi, 1, 0.01, 0.01, 0.01, 0);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x + xi, y + i, z + zi, 1, 0.1, 0.1, 0.1, 0.2);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.PLAYERS, (float) 0.06, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.PLAYERS, (float) 0.06, 1, false);
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")), SoundSource.PLAYERS, (float) 0.06, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode")), SoundSource.PLAYERS, (float) 0.06, 1, false);
								}
							}
							world.destroyBlock(BlockPos.containing(x + xi, y + i, z + zi), false);
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.FALLING_BLOCKS_MANIP.get(), 5, 0, false, false));
						}
					}
				}
			}
		}
	}
}
