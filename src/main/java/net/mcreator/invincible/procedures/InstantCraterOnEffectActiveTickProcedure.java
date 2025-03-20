package net.mcreator.invincible.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.invincible.network.InvincibleModVariables;
import net.mcreator.invincible.init.InvincibleModMobEffects;

public class InstantCraterOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength >= 20) {
			entity.getPersistentData().putDouble("shatterexpand", (entity.getPersistentData().getDouble("shatterexpand") + 1));
			int horizontalRadiusHemiTop = (int) (entity.getPersistentData().getDouble("shatterexpand")) - 1;
			int verticalRadiusHemiTop = (int) (entity.getPersistentData().getDouble("shatterexpand"));
			int yIterationsHemiTop = verticalRadiusHemiTop;
			for (int i = 0; i < yIterationsHemiTop; i++) {
				if (i == verticalRadiusHemiTop) {
					continue;
				}
				for (int xi = -horizontalRadiusHemiTop; xi <= horizontalRadiusHemiTop; xi++) {
					for (int zi = -horizontalRadiusHemiTop; zi <= horizontalRadiusHemiTop; zi++) {
						double distanceSq = (xi * xi) / (double) (horizontalRadiusHemiTop * horizontalRadiusHemiTop) + (i * i) / (double) (verticalRadiusHemiTop * verticalRadiusHemiTop)
								+ (zi * zi) / (double) (horizontalRadiusHemiTop * horizontalRadiusHemiTop);
						if (distanceSq <= 1.0) {
							if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(new ResourceLocation("invincible:modglass")))) {
								world.destroyBlock(BlockPos.containing(x + xi, y + i, z + zi), false);
							}
						}
					}
				}
			}
			if (entity.getPersistentData().getDouble("shatterexpand") >= 20) {
				entity.getPersistentData().putDouble("shatterexpand", 0);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(InvincibleModMobEffects.INSTANT_CRATER.get());
			}
		}
	}
}
