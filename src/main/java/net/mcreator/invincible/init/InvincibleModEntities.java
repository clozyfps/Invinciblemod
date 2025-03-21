
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
import net.mcreator.invincible.entity.ViltrumiteEntity;
import net.mcreator.invincible.entity.SonicClapEntity;
import net.mcreator.invincible.entity.PastImageEntity;
import net.mcreator.invincible.entity.OmnimanEntity;
import net.mcreator.invincible.entity.MaulerEntity;
import net.mcreator.invincible.entity.MarsProximityEntity;
import net.mcreator.invincible.entity.InvincibleMarkEntity;
import net.mcreator.invincible.entity.InvincibleBlueMarkEntity;
import net.mcreator.invincible.entity.AfterImageEntity;
import net.mcreator.invincible.InvincibleMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class InvincibleModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, InvincibleMod.MODID);
	public static final RegistryObject<EntityType<MarsProximityEntity>> MARS_PROXIMITY = register("mars_proximity", EntityType.Builder.<MarsProximityEntity>of(MarsProximityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MarsProximityEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ViltrumiteEntity>> VILTRUMITE = register("viltrumite",
			EntityType.Builder.<ViltrumiteEntity>of(ViltrumiteEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ViltrumiteEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AfterImageEntity>> AFTER_IMAGE = register("after_image", EntityType.Builder.<AfterImageEntity>of(AfterImageEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(AfterImageEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SonicClapEntity>> SONIC_CLAP = register("sonic_clap",
			EntityType.Builder.<SonicClapEntity>of(SonicClapEntity::new, MobCategory.MISC).setCustomClientFactory(SonicClapEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PastImageEntity>> PAST_IMAGE = register("past_image",
			EntityType.Builder.<PastImageEntity>of(PastImageEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PastImageEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<WebLineEntity>> WEB_LINE = register("web_line",
			EntityType.Builder.<WebLineEntity>of(WebLineEntity::new, MobCategory.MISC).setCustomClientFactory(WebLineEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<InvincibleMarkEntity>> INVINCIBLE_MARK = register("invincible_mark", EntityType.Builder.<InvincibleMarkEntity>of(InvincibleMarkEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(InvincibleMarkEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<InvincibleBlueMarkEntity>> INVINCIBLE_BLUE_MARK = register("invincible_blue_mark", EntityType.Builder.<InvincibleBlueMarkEntity>of(InvincibleBlueMarkEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(InvincibleBlueMarkEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<OmnimanEntity>> OMNIMAN = register("omniman",
			EntityType.Builder.<OmnimanEntity>of(OmnimanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OmnimanEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MaulerEntity>> MAULER = register("mauler",
			EntityType.Builder.<MaulerEntity>of(MaulerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MaulerEntity::new)

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
			ViltrumiteEntity.init();
			AfterImageEntity.init();
			PastImageEntity.init();
			InvincibleMarkEntity.init();
			InvincibleBlueMarkEntity.init();
			OmnimanEntity.init();
			MaulerEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(MARS_PROXIMITY.get(), MarsProximityEntity.createAttributes().build());
		event.put(VILTRUMITE.get(), ViltrumiteEntity.createAttributes().build());
		event.put(AFTER_IMAGE.get(), AfterImageEntity.createAttributes().build());
		event.put(PAST_IMAGE.get(), PastImageEntity.createAttributes().build());
		event.put(INVINCIBLE_MARK.get(), InvincibleMarkEntity.createAttributes().build());
		event.put(INVINCIBLE_BLUE_MARK.get(), InvincibleBlueMarkEntity.createAttributes().build());
		event.put(OMNIMAN.get(), OmnimanEntity.createAttributes().build());
		event.put(MAULER.get(), MaulerEntity.createAttributes().build());
	}
}
