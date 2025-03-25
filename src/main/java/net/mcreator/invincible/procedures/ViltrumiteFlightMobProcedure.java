package net.mcreator.invincible.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.invincible.init.InvincibleModParticleTypes;
import net.mcreator.invincible.init.InvincibleModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ViltrumiteFlightMobProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("invincible:spacemob")))) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity instanceof Player _player) {
					_player.getAbilities().flying = true;
					_player.onUpdateAbilities();
				}
				if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(InvincibleModMobEffects.GRAB_COOLDOWN.get()))) {
					if (Math.random() < 0.01) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.GRAB_COOLDOWN.get(), 40, 0, false, false));
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.SHOCKWAVE_BIG.get()), x, (y + 1), z, 1, 0.1, 0.1, 0.1, 0);
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.CUSTOM_SMOKE.get()), x, (y + 1), z, 1, 0.1, 0.1, 0.1, 0.1);
						magnitude = Math.sqrt(entity.getLookAngle().x * entity.getLookAngle().x + entity.getLookAngle().y * entity.getLookAngle().y + entity.getLookAngle().z * entity.getLookAngle().z);
						vecX = entity.getLookAngle().x / magnitude;
						vecY = entity.getLookAngle().y / magnitude;
						vecZ = entity.getLookAngle().z / magnitude;
						vecX = vecX * 2;
						vecY = vecY * 2;
						vecZ = vecZ * 2;
						entity.push(vecX, vecY, vecZ);
					}
				}
			}
		}
	}
}
