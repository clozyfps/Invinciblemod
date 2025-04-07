
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
import net.mcreator.invincible.entity.ViltrumiteMaleEntity;
import net.mcreator.invincible.entity.ViltrumiteFemaleEntity;
import net.mcreator.invincible.entity.ViltrumPlanetEntity;
import net.mcreator.invincible.entity.VeilInvincibleEntity;
import net.mcreator.invincible.entity.TransferProjectileEntity;
import net.mcreator.invincible.entity.SonicClapEntity;
import net.mcreator.invincible.entity.SinisterInvincibleEntity;
import net.mcreator.invincible.entity.RoboBallEntity;
import net.mcreator.invincible.entity.RexSplodeEntity;
import net.mcreator.invincible.entity.PastImageEntity;
import net.mcreator.invincible.entity.OmnimanEntity;
import net.mcreator.invincible.entity.MultiPaulEntity;
import net.mcreator.invincible.entity.MohawkInvincibleEntity;
import net.mcreator.invincible.entity.MaulerEntity;
import net.mcreator.invincible.entity.MasklessInvincibleEntity;
import net.mcreator.invincible.entity.MartianSpearmanEntity;
import net.mcreator.invincible.entity.MartianEntity;
import net.mcreator.invincible.entity.MarsProximityEntity;
import net.mcreator.invincible.entity.MarsPlanetEntity;
import net.mcreator.invincible.entity.KnockbackProjectileEntity;
import net.mcreator.invincible.entity.InvincibleMarkEntity;
import net.mcreator.invincible.entity.InvincibleBlueMarkEntity;
import net.mcreator.invincible.entity.FullMaskInvincibleEntity;
import net.mcreator.invincible.entity.FlaxanSoldierEntity;
import net.mcreator.invincible.entity.FlaxanPortalEntity;
import net.mcreator.invincible.entity.FlaxanGunmanEntity;
import net.mcreator.invincible.entity.FireworkExplosionEntity;
import net.mcreator.invincible.entity.ExplosionSmallEntity;
import net.mcreator.invincible.entity.ExplosionLargeEntity;
import net.mcreator.invincible.entity.EarthEntity;
import net.mcreator.invincible.entity.DupliKateEntity;
import net.mcreator.invincible.entity.DinosaurEntity;
import net.mcreator.invincible.entity.DimensionalPortalEntity;
import net.mcreator.invincible.entity.CloneEntity;
import net.mcreator.invincible.entity.ClawMobEntity;
import net.mcreator.invincible.entity.BlasterProjectileEntity;
import net.mcreator.invincible.entity.BattleBeastEntity;
import net.mcreator.invincible.entity.AtomBarrierEntity;
import net.mcreator.invincible.entity.AngstromEntity;
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
			EntityType.Builder.<FlaxanSoldierEntity>of(FlaxanSoldierEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FlaxanSoldierEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MaulerEntity>> MAULER = register("mauler",
			EntityType.Builder.<MaulerEntity>of(MaulerEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MaulerEntity::new)

					.sized(1f, 3f));
	public static final RegistryObject<EntityType<FlaxanPortalEntity>> FLAXAN_PORTAL = register("flaxan_portal", EntityType.Builder.<FlaxanPortalEntity>of(FlaxanPortalEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FlaxanPortalEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<FlaxanGunmanEntity>> FLAXAN_GUNMAN = register("flaxan_gunman",
			EntityType.Builder.<FlaxanGunmanEntity>of(FlaxanGunmanEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FlaxanGunmanEntity::new)

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
	public static final RegistryObject<EntityType<DimensionalPortalEntity>> DIMENSIONAL_PORTAL = register("dimensional_portal", EntityType.Builder.<DimensionalPortalEntity>of(DimensionalPortalEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DimensionalPortalEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ViltrumiteFemaleEntity>> VILTRUMITE_FEMALE = register("viltrumite_female",
			EntityType.Builder.<ViltrumiteFemaleEntity>of(ViltrumiteFemaleEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ViltrumiteFemaleEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AngstromEntity>> ANGSTROM = register("angstrom",
			EntityType.Builder.<AngstromEntity>of(AngstromEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AngstromEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ViltrumiteMaleEntity>> VILTRUMITE_MALE = register("viltrumite_male",
			EntityType.Builder.<ViltrumiteMaleEntity>of(ViltrumiteMaleEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ViltrumiteMaleEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ClawMobEntity>> CLAW_MOB = register("claw_mob",
			EntityType.Builder.<ClawMobEntity>of(ClawMobEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ClawMobEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<RoboBallEntity>> ROBO_BALL = register("robo_ball",
			EntityType.Builder.<RoboBallEntity>of(RoboBallEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RoboBallEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BattleBeastEntity>> BATTLE_BEAST = register("battle_beast",
			EntityType.Builder.<BattleBeastEntity>of(BattleBeastEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BattleBeastEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AtomBarrierEntity>> ATOM_BARRIER = register("atom_barrier", EntityType.Builder.<AtomBarrierEntity>of(AtomBarrierEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AtomBarrierEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MartianEntity>> MARTIAN = register("martian",
			EntityType.Builder.<MartianEntity>of(MartianEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MartianEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MartianSpearmanEntity>> MARTIAN_SPEARMAN = register("martian_spearman",
			EntityType.Builder.<MartianSpearmanEntity>of(MartianSpearmanEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MartianSpearmanEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SinisterInvincibleEntity>> SINISTER_INVINCIBLE = register("sinister_invincible", EntityType.Builder.<SinisterInvincibleEntity>of(SinisterInvincibleEntity::new, MobCategory.AMBIENT)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SinisterInvincibleEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MohawkInvincibleEntity>> MOHAWK_INVINCIBLE = register("mohawk_invincible", EntityType.Builder.<MohawkInvincibleEntity>of(MohawkInvincibleEntity::new, MobCategory.AMBIENT)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MohawkInvincibleEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<VeilInvincibleEntity>> VEIL_INVINCIBLE = register("veil_invincible", EntityType.Builder.<VeilInvincibleEntity>of(VeilInvincibleEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VeilInvincibleEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MasklessInvincibleEntity>> MASKLESS_INVINCIBLE = register("maskless_invincible", EntityType.Builder.<MasklessInvincibleEntity>of(MasklessInvincibleEntity::new, MobCategory.AMBIENT)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MasklessInvincibleEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<FullMaskInvincibleEntity>> FULL_MASK_INVINCIBLE = register("full_mask_invincible", EntityType.Builder.<FullMaskInvincibleEntity>of(FullMaskInvincibleEntity::new, MobCategory.AMBIENT)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FullMaskInvincibleEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<DinosaurEntity>> DINOSAUR = register("dinosaur",
			EntityType.Builder.<DinosaurEntity>of(DinosaurEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DinosaurEntity::new)

					.sized(1.3f, 2.5f));
	public static final RegistryObject<EntityType<EarthEntity>> EARTH = register("earth",
			EntityType.Builder.<EarthEntity>of(EarthEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EarthEntity::new).fireImmune().sized(5f, 5f));
	public static final RegistryObject<EntityType<MarsPlanetEntity>> MARS_PLANET = register("mars_planet",
			EntityType.Builder.<MarsPlanetEntity>of(MarsPlanetEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MarsPlanetEntity::new).fireImmune().sized(5f, 5f));
	public static final RegistryObject<EntityType<ViltrumPlanetEntity>> VILTRUM_PLANET = register("viltrum_planet", EntityType.Builder.<ViltrumPlanetEntity>of(ViltrumPlanetEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ViltrumPlanetEntity::new).fireImmune().sized(5f, 5f));

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
			ViltrumiteFemaleEntity.init();
			AngstromEntity.init();
			ViltrumiteMaleEntity.init();
			ClawMobEntity.init();
			RoboBallEntity.init();
			BattleBeastEntity.init();
			AtomBarrierEntity.init();
			MartianEntity.init();
			MartianSpearmanEntity.init();
			SinisterInvincibleEntity.init();
			MohawkInvincibleEntity.init();
			VeilInvincibleEntity.init();
			MasklessInvincibleEntity.init();
			FullMaskInvincibleEntity.init();
			DinosaurEntity.init();
			EarthEntity.init();
			MarsPlanetEntity.init();
			ViltrumPlanetEntity.init();
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
		event.put(VILTRUMITE_FEMALE.get(), ViltrumiteFemaleEntity.createAttributes().build());
		event.put(ANGSTROM.get(), AngstromEntity.createAttributes().build());
		event.put(VILTRUMITE_MALE.get(), ViltrumiteMaleEntity.createAttributes().build());
		event.put(CLAW_MOB.get(), ClawMobEntity.createAttributes().build());
		event.put(ROBO_BALL.get(), RoboBallEntity.createAttributes().build());
		event.put(BATTLE_BEAST.get(), BattleBeastEntity.createAttributes().build());
		event.put(ATOM_BARRIER.get(), AtomBarrierEntity.createAttributes().build());
		event.put(MARTIAN.get(), MartianEntity.createAttributes().build());
		event.put(MARTIAN_SPEARMAN.get(), MartianSpearmanEntity.createAttributes().build());
		event.put(SINISTER_INVINCIBLE.get(), SinisterInvincibleEntity.createAttributes().build());
		event.put(MOHAWK_INVINCIBLE.get(), MohawkInvincibleEntity.createAttributes().build());
		event.put(VEIL_INVINCIBLE.get(), VeilInvincibleEntity.createAttributes().build());
		event.put(MASKLESS_INVINCIBLE.get(), MasklessInvincibleEntity.createAttributes().build());
		event.put(FULL_MASK_INVINCIBLE.get(), FullMaskInvincibleEntity.createAttributes().build());
		event.put(DINOSAUR.get(), DinosaurEntity.createAttributes().build());
		event.put(EARTH.get(), EarthEntity.createAttributes().build());
		event.put(MARS_PLANET.get(), MarsPlanetEntity.createAttributes().build());
		event.put(VILTRUM_PLANET.get(), ViltrumPlanetEntity.createAttributes().build());
	}
}
