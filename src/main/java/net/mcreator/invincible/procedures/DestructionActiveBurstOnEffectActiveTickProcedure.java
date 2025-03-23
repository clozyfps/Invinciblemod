package net.mcreator.invincible.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.invincible.network.InvincibleModVariables;
import net.mcreator.invincible.init.InvincibleModParticleTypes;
import net.mcreator.invincible.init.InvincibleModMobEffects;

public class DestructionActiveBurstOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isSprinting()) {
			int horizontalRadiusSquare = (int) 1.5 - 1;
			int verticalRadiusSquare = (int) 1.5 - 1;
			int yIterationsSquare = verticalRadiusSquare;
			for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
				for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
					for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
						// Execute the desired statements within the square/cube
						if (!(world.getBlockState(BlockPos.containing((entity.getX() + entity.getLookAngle().x * 3) + xi, (entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * 2) + i, (entity.getZ() + entity.getLookAngle().z * 3) + zi)))
								.is(BlockTags.create(new ResourceLocation("invincible:indestructible")))) {
							world.levelEvent(2001, BlockPos.containing((entity.getX() + entity.getLookAngle().x * 3) + xi, (entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * 2) + i, (entity.getZ() + entity.getLookAngle().z * 3) + zi),
									Block.getId((world.getBlockState(
											BlockPos.containing((entity.getX() + entity.getLookAngle().x * 3) + xi, (entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * 2) + i, (entity.getZ() + entity.getLookAngle().z * 3) + zi)))));
							world.setBlock(BlockPos.containing((entity.getX() + entity.getLookAngle().x * 3) + xi, (entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * 2) + i, (entity.getZ() + entity.getLookAngle().z * 3) + zi),
									Blocks.AIR.defaultBlockState(), 3);
						}
					}
				}
			}
			int horizontalRadiusSphere = (int) (3 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 80) - 1;
			int verticalRadiusSphere = (int) (3 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 80) - 1;
			int yIterationsSphere = verticalRadiusSphere;
			for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
				for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
					for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
						double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
								+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
						if (distanceSq <= 1.0) {
							if (!(world.getBlockState(
									BlockPos.containing((entity.getX() + entity.getLookAngle().x * 2) + xi, (entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * 2) + i, (entity.getZ() + entity.getLookAngle().z * 2) + zi)))
									.is(BlockTags.create(new ResourceLocation("invincible:indestructible")))) {
								world.setBlock(BlockPos.containing((entity.getX() + entity.getLookAngle().x * 2) + xi, (entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * 2) + i, (entity.getZ() + entity.getLookAngle().z * 2) + zi),
										Blocks.AIR.defaultBlockState(), 3);
								if (entity instanceof LivingEntity _livEnt28 && _livEnt28.hasEffect(InvincibleModMobEffects.HYPER_SONIC.get())) {
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.CUSTOM_SMOKE.get()), x, (y + 1), z, 1, 0.01, 0.01, 0.01, 0.1);
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.EXPLOSION, (entity.getX() + entity.getLookAngle().x * 2) + xi, (entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * 2) + i,
												(entity.getZ() + entity.getLookAngle().z * 2) + zi, 1, 0.01, 0.01, 0.01, 0);
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.FLAME, (entity.getX() + entity.getLookAngle().x * 2) + xi, (entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * 2) + i,
												(entity.getZ() + entity.getLookAngle().z * 2) + zi, 2, 0.01, 0.01, 0.01, 0);
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.PLAYERS, (float) 0.06, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.PLAYERS, (float) 0.06, 1, false);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
