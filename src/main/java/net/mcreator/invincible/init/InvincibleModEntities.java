
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.invincible.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.invincible.entity.WebLineEntity;
import net.mcreator.invincible.entity.ViltrumiteFemaleEntity;
import net.mcreator.invincible.entity.ViltrumiteEntity;
import net.mcreator.invincible.entity.TransferProjectileEntity;
import net.mcreator.invincible.entity.SonicClapEntity;
import net.mcreator.invincible.entity.RexSplodeEntity;
import net.mcreator.invincible.entity.PastImageEntity;
import net.mcreator.invincible.entity.OmnimanEntity;
import net.mcreator.invincible.entity.MultiPaulEntity;
import net.mcreator.invincible.entity.MaulerEntity;
import net.mcreator.invincible.entity.MarsProximityEntity;
import net.mcreator.invincible.entity.KnockbackProjectileEntity;
import net.mcreator.invincible.entity.InvincibleMarkEntity;
import net.mcreator.invincible.entity.InvincibleBlueMarkEntity;
import net.mcreator.invincible.entity.FlaxanSoldierEntity;
import net.mcreator.invincible.entity.FlaxanPortalEntity;
import net.mcreator.invincible.entity.FlaxanGunmanEntity;
import net.mcreator.invincible.entity.FireworkExplosionEntity;
import net.mcreator.invincible.entity.ExplosionSmallEntity;
import net.mcreator.invincible.entity.ExplosionLargeEntity;
import net.mcreator.invincible.entity.DupliKateEntity;
import net.mcreator.invincible.entity.DimensionalPortalEntity;
import net.mcreator.invincible.entity.CloneEntity;
import net.mcreator.invincible.entity.BlasterProjectileEntity;
import net.mcreator.invincible.entity.AfterImageEntity;
import net.mcreator.invincible.InvincibleMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class InvincibleModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, InvincibleMod.MODID);
	public static final RegistryObject<EntityType<MarsProximityEntity>> MARS_PROXIMITY = register("mars_proximity", EntityType.Builder.<MarsProximityEntity>of(MarsProximityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MarsProximityEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AfterImageEntity>> AFTER_IMAGE = register("after_image", EntityType.Builder.<AfterImageEntity>of(AfterImageEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(AfterImageEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SonicClapEntity>> SONIC_CLAP = register("sonic_clap",
			EntityType.Builder.<SonicClapEntity>of(SonicClapEntity::new, MobCategory.MISC).setCustomClientFactory(SonicClapEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PastImageEntity>> PAST_IMAGE = register("past_image",
			EntityType.Builder.<PastImageEntity>of(PastImageEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PastImageEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<WebLineEntity>> WEB_LINE = register("web_line",
			EntityType.Builder.<WebLineEntity>of(WebLineEntity::new, MobCategory.MISC).setCustomClientFactory(WebLineEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<InvincibleMarkEntity>> INVINCIBLE_MARK = register("invincible_mark", EntityType.Builder.<InvincibleMarkEntity>of(InvincibleMarkEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(InvincibleMarkEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<InvincibleBlueMarkEntity>> INVINCIBLE_BLUE_MARK = register("invincible_blue_mark", EntityType.Builder.<InvincibleBlueMarkEntity>of(InvincibleBlueMarkEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(InvincibleBlueMarkEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<OmnimanEntity>> OMNIMAN = register("omniman",
			EntityType.Builder.<OmnimanEntity>of(OmnimanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OmnimanEntity::new).fireImmune().sized(0.8f, 2.2f));
	public static final RegistryObject<EntityType<FlaxanSoldierEntity>> FLAXAN_SOLDIER = register("flaxan_soldier",
			EntityType.Builder.<FlaxanSoldierEntity>of(FlaxanSoldierEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FlaxanSoldierEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MaulerEntity>> MAULER = register("mauler",
			EntityType.Builder.<MaulerEntity>of(MaulerEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MaulerEntity::new)

					.sized(1f, 3f));
	public static final RegistryObject<EntityType<FlaxanPortalEntity>> FLAXAN_PORTAL = register("flaxan_portal", EntityType.Builder.<FlaxanPortalEntity>of(FlaxanPortalEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FlaxanPortalEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<FlaxanGunmanEntity>> FLAXAN_GUNMAN = register("flaxan_gunman",
			EntityType.Builder.<FlaxanGunmanEntity>of(FlaxanGunmanEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FlaxanGunmanEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BlasterProjectileEntity>> BLASTER_PROJECTILE = register("blaster_projectile", EntityType.Builder.<BlasterProjectileEntity>of(BlasterProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(BlasterProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<KnockbackProjectileEntity>> KNOCKBACK_PROJECTILE = register("knockback_projectile", EntityType.Builder.<KnockbackProjectileEntity>of(KnockbackProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(KnockbackProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FireworkExplosionEntity>> FIREWORK_EXPLOSION = register("firework_explosion", EntityType.Builder.<FireworkExplosionEntity>of(FireworkExplosionEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FireworkExplosionEntity::new).fireImmune().sized(0.5f, 1f));
	public static final RegistryObject<EntityType<ExplosionSmallEntity>> EXPLOSION_SMALL = register("explosion_small",
			EntityType.Builder.<ExplosionSmallEntity>of(ExplosionSmallEntity::new, MobCategory.MISC).setCustomClientFactory(ExplosionSmallEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ExplosionLargeEntity>> EXPLOSION_LARGE = register("explosion_large",
			EntityType.Builder.<ExplosionLargeEntity>of(ExplosionLargeEntity::new, MobCategory.MISC).setCustomClientFactory(ExplosionLargeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RexSplodeEntity>> REX_SPLODE = register("rex_splode",
			EntityType.Builder.<RexSplodeEntity>of(RexSplodeEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RexSplodeEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<CloneEntity>> CLONE = register("clone",
			EntityType.Builder.<CloneEntity>of(CloneEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CloneEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TransferProjectileEntity>> TRANSFER_PROJECTILE = register("transfer_projectile", EntityType.Builder.<TransferProjectileEntity>of(TransferProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(TransferProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<DupliKateEntity>> DUPLI_KATE = register("dupli_kate",
			EntityType.Builder.<DupliKateEntity>of(DupliKateEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DupliKateEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MultiPaulEntity>> MULTI_PAUL = register("multi_paul",
			EntityType.Builder.<MultiPaulEntity>of(MultiPaulEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MultiPaulEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<DimensionalPortalEntity>> DIMENSIONAL_PORTAL = register("dimensional_portal",
			EntityType.Builder.<DimensionalPortalEntity>of(DimensionalPortalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DimensionalPortalEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ViltrumiteEntity>> VILTRUMITE = register("viltrumite",
			EntityType.Builder.<ViltrumiteEntity>of(ViltrumiteEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ViltrumiteEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ViltrumiteFemaleEntity>> VILTRUMITE_FEMALE = register("viltrumite_female",
			EntityType.Builder.<ViltrumiteFemaleEntity>of(ViltrumiteFemaleEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ViltrumiteFemaleEntity::new)

					.sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			MarsProximityEntity.init();
			AfterImageEntity.init();
			PastImageEntity.init();
			InvincibleMarkEntity.init();
			InvincibleBlueMarkEntity.init();
			OmnimanEntity.init();
			FlaxanSoldierEntity.init();
			MaulerEntity.init();
			FlaxanPortalEntity.init();
			FlaxanGunmanEntity.init();
			FireworkExplosionEntity.init();
			RexSplodeEntity.init();
			CloneEntity.init();
			DupliKateEntity.init();
			MultiPaulEntity.init();
			DimensionalPortalEntity.init();
			ViltrumiteEntity.init();
			ViltrumiteFemaleEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(MARS_PROXIMITY.get(), MarsProximityEntity.createAttributes().build());
		event.put(AFTER_IMAGE.get(), AfterImageEntity.createAttributes().build());
		event.put(PAST_IMAGE.get(), PastImageEntity.createAttributes().build());
		event.put(INVINCIBLE_MARK.get(), InvincibleMarkEntity.createAttributes().build());
		event.put(INVINCIBLE_BLUE_MARK.get(), InvincibleBlueMarkEntity.createAttributes().build());
		event.put(OMNIMAN.get(), OmnimanEntity.createAttributes().build());
		event.put(FLAXAN_SOLDIER.get(), FlaxanSoldierEntity.createAttributes().build());
		event.put(MAULER.get(), MaulerEntity.createAttributes().build());
		event.put(FLAXAN_PORTAL.get(), FlaxanPortalEntity.createAttributes().build());
		event.put(FLAXAN_GUNMAN.get(), FlaxanGunmanEntity.createAttributes().build());
		event.put(FIREWORK_EXPLOSION.get(), FireworkExplosionEntity.createAttributes().build());
		event.put(REX_SPLODE.get(), RexSplodeEntity.createAttributes().build());
		event.put(CLONE.get(), CloneEntity.createAttributes().build());
		event.put(DUPLI_KATE.get(), DupliKateEntity.createAttributes().build());
		event.put(MULTI_PAUL.get(), MultiPaulEntity.createAttributes().build());
		event.put(DIMENSIONAL_PORTAL.get(), DimensionalPortalEntity.createAttributes().build());
		event.put(VILTRUMITE.get(), ViltrumiteEntity.createAttributes().build());
		event.put(VILTRUMITE_FEMALE.get(), ViltrumiteFemaleEntity.createAttributes().build());
	}
}
