package net.mcreator.invincible.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.invincible.init.InvincibleModMobEffects;

import java.util.List;
import java.util.Comparator;

public class GrabOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(InvincibleModMobEffects.GRAB_COOLDOWN.get()))) {
			if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(InvincibleModMobEffects.GRABBING_ACTIVE.get()))) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entity == entityiterator)) {
							if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("invincible:untargetable")))) {
								if (entityiterator instanceof LivingEntity) {
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.GRABBING_ACTIVE.get(), 99999, 0, false, false));
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.GRABBED.get(), 99999, 0, false, false));
								} else {
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.GRAB_COOLDOWN.get(), 30, 0));
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Nothing to grab"), true);
								}
							}
						}
					}
				}
			} else if (entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(InvincibleModMobEffects.GRABBING_ACTIVE.get())) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(InvincibleModMobEffects.GRABBING_ACTIVE.get());
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.GRAB_COOLDOWN.get(), 30, 0));
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entity == entityiterator)) {
							if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("invincible:untargetable")))) {
								if (entityiterator instanceof LivingEntity) {
									if (entityiterator instanceof LivingEntity _entity)
										_entity.removeEffect(InvincibleModMobEffects.GRABBED.get());
								}
							}
						}
					}
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Grab On Cooldown."), true);
		}
	}
}
