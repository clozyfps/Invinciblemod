package net.mcreator.invincible.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.invincible.init.InvincibleModMobEffects;

import java.util.List;
import java.util.Comparator;

public class GrabbingActiveOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entity == entityiterator)) {
					if (entityiterator instanceof LivingEntity) {
						if (entityiterator.isAlive()) {
							if (entityiterator instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(InvincibleModMobEffects.GRABBED.get())) {
								{
									Entity _ent = entityiterator;
									_ent.teleportTo(
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0.5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getX()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0.5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getY()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0.5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getZ()));
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0.5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0.5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0.5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ()),
												_ent.getYRot(), _ent.getXRot());
								}
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.NO_FALL.get(), 20, 0, false, false));
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal(("Grabbing " + entityiterator.getDisplayName().getString())), true);
								if (entity.getPersistentData().getBoolean("flight")) {
									int horizontalRadiusSquare = (int) 3 - 1;
									int verticalRadiusSquare = (int) 3 - 1;
									int yIterationsSquare = verticalRadiusSquare;
									for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
										for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
											for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
												// Execute the desired statements within the square/cube
												if (!((world.getBlockState(BlockPos.containing((entity.getX() + entity.getLookAngle().x * 2) + xi, (entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * 2) + i,
														(entity.getZ() + entity.getLookAngle().z * 2) + zi))).getBlock() == Blocks.AIR)) {
													world.destroyBlock(BlockPos.containing((entity.getX() + entity.getLookAngle().x * 2) + xi, (entity.getY() + entity.getEyeHeight() + entity.getLookAngle().y * 2) + i,
															(entity.getZ() + entity.getLookAngle().z * 2) + zi), false);
													entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.EXPLOSION), entityiterator), 6);
													if (world instanceof ServerLevel _level)
														_level.sendParticles(ParticleTypes.EXPLOSION, (entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), 1, 0.1, 0.1, 0.1, 0);
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
		}
	}
}
