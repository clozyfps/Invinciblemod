package net.mcreator.invincible.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.invincible.network.InvincibleModVariables;

public class TimeStoppedFreezeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double creeper_explode = 0;
		if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Race).equals("Viltrumite")) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 2, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 10, 2, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 10, 2, false, false));
		} else if (!((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Race).equals("Speedster")) {
			entity.setNoGravity(true);
			entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 20, 9, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 10, 9, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10, 9, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 10, 9, false, false));
			{
				Entity _ent = entity;
				_ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ()));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
			}
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getPersistentData().getDouble("LookX")), (entity.getPersistentData().getDouble("LookY")), (entity.getPersistentData().getDouble("LookZ"))));
			if (!(entity instanceof Player)) {
				if (entity instanceof Mob _mobSetNoAi) {
					_mobSetNoAi.setNoAi(true);
				}
			}
			if (entity instanceof Creeper) {
				creeper_explode = Math.min(1, entity instanceof Creeper _creeper ? _creeper.getSwelling(1) : 0);
				if (1 == (entity instanceof Creeper _creeper ? _creeper.getSwellDir() : 0)) {
					if (entity instanceof Creeper _creeper)
						_creeper.setSwellDir((int) creeper_explode);
				}
			}
		}
		if (entity instanceof Player) {
			{
				double _setval = 5;
				entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DashCooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).MaximumMoves >= 1) {
				{
					double _setval = 5;
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cooldown1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).MaximumMoves >= 2) {
				{
					double _setval = 5;
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cooldown2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).MaximumMoves >= 3) {
				{
					double _setval = 5;
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cooldown3 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).MaximumMoves >= 4) {
				{
					double _setval = 5;
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cooldown4 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).MaximumMoves >= 5) {
				{
					double _setval = 5;
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cooldown5 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).MaximumMoves >= 6) {
				{
					double _setval = 5;
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cooldown6 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).MaximumMoves >= 7) {
				{
					double _setval = 5;
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cooldown7 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).MaximumMoves >= 8) {
				{
					double _setval = 5;
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cooldown8 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).MaximumMoves >= 9) {
				{
					double _setval = 5;
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cooldown9 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).MaximumMoves >= 10) {
				{
					double _setval = 5;
					entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Cooldown10 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
