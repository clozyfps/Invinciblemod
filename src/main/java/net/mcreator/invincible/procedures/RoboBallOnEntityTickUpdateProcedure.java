package net.mcreator.invincible.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.invincible.entity.RoboBallEntity;
import net.mcreator.invincible.entity.DimensionalPortalEntity;

import java.util.List;
import java.util.Comparator;

public class RoboBallOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
			entity.setDeltaMovement(
					new Vec3(
							(((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).level()
									.clip(new ClipContext((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getEyePosition(1f),
											(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getEyePosition(1f)
													.add((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getViewVector(1f).scale(50)),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)))
									.getBlockPos().getX() - entity.getX()) / 3),
							(((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).level()
									.clip(new ClipContext((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getEyePosition(1f),
											(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getEyePosition(1f)
													.add((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getViewVector(1f).scale(50)),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)))
									.getBlockPos().getY() - entity.getY()) / 3),
							(((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).level()
									.clip(new ClipContext((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getEyePosition(1f),
											(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getEyePosition(1f)
													.add((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getViewVector(1f).scale(50)),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)))
									.getBlockPos().getZ() - entity.getZ()) / 3)));
			if (!(!world.getEntitiesOfClass(DimensionalPortalEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty())) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator)) {
						if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == entityiterator)) {
							if (!(entityiterator instanceof RoboBallEntity)) {
								if (!(entityiterator instanceof DimensionalPortalEntity)) {
									entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity), 5);
									if (!entity.level().isClientSide())
										entity.discard();
									world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.STONE.defaultBlockState()));
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.POOF, x, (y + 1), z, 3, 0.01, 0.01, 0.01, 0.2);
								}
							}
						}
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"particle dust 0.42 0.42 0.42 1 ~ ~ ~ 0 0 0 0 5");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"particle dust 0.21 0.87 0.47 0.7 ~ ~ ~ 0 0 0 0 5");
		}
	}
}
