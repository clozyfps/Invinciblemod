package net.mcreator.invincible.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.invincible.network.InvincibleModVariables;
import net.mcreator.invincible.init.InvincibleModParticleTypes;
import net.mcreator.invincible.init.InvincibleModMobEffects;
import net.mcreator.invincible.InvincibleMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ViltrumitePunchesProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		if (((sourceentity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Race).equals("Viltrumite")) {
			if ((sourceentity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).ToggleSpecial) {
				if ((sourceentity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength >= 10) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(InvincibleModMobEffects.COMBO_STILL.get());
					if (sourceentity instanceof LivingEntity _entity)
						_entity.removeEffect(InvincibleModMobEffects.COMBO_STILL.get());
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.SHOCKWAVE.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 1, 0.1, 1, 0.1, 0);
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.BLOOD_DROP.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 10, 0.1, 0.1, 0.1, 0.01);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.POOF, (entity.getX()), (entity.getY()), (entity.getZ()), 5, 0.01, 0.01, 0.01, 0);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.POINT_DESTRUCTION.get(), 50, 0, false, false));
					world.levelEvent(2001, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), Block.getId(Blocks.REDSTONE_BLOCK.defaultBlockState()));
					if ((sourceentity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength >= 25) {
						if (Math.random() < 0.8) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.SHOCKWAVE_BIG.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 1, 0.1, 1, 0.1, 0);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.EXPLOSION, (entity.getX()), (entity.getY()), (entity.getZ()), 1, 0.1, 1, 0.1, 0);
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.IMPACT_FRAME_POTION.get(), 3, 0, false, false));
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.GLASS_BREAK.get(), 1, 0, false, false));
						}
					}
					if ((sourceentity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength
							- (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Defense >= 50) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.DESTRUCTION_ACTIVE.get(), 30, 0, false, false));
					}
					if (entity instanceof Player) {
						if (entity.getPersistentData().getBoolean("flight")) {
							entity.getPersistentData().putBoolean("flight", false);
							InvincibleMod.queueServerWork(10, () -> {
								entity.getPersistentData().putBoolean("flight", true);
							});
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.BLOOD_DROP.get()), (entity.getX()), (entity.getY()), (entity.getZ()),
									(int) ((sourceentity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength
											- (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Defense),
									0.1, 1, 0.1, 0);
						entity.getPersistentData().putString("enemytype", "player");
						CallPunchProcedure.execute(entity, sourceentity);
					} else if (!(entity instanceof Player)) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.BLOOD_DROP.get()), (entity.getX()), (entity.getY()), (entity.getZ()),
									(int) ((sourceentity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength
											- (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 5),
									0.1, 0.1, 0.1, 0);
						entity.getPersistentData().putString("enemytype", "mob");
						CallPunchMobProcedure.execute(entity, sourceentity);
					}
					if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("invincible:powerfulpunch")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("invincible:powerfulpunch")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("invincible:powerfulpunch2")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("invincible:powerfulpunch2")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					}
					entity.getPersistentData().putString("target", (sourceentity.getDisplayName().getString()));
					{
						double _setval = amount;
						sourceentity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.AverageDamage = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				}
			} else {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.BLOOD_DROP.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 10, 0.1, 0.1, 0.1, 0);
			}
		}
	}
}
