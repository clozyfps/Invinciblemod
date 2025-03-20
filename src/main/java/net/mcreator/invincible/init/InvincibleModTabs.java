
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.invincible.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.invincible.InvincibleMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class InvincibleModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, InvincibleMod.MODID);
	public static final RegistryObject<CreativeModeTab> INVINCIBLE_TAB = REGISTRY.register("invincible_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.invincible.invincible_tab")).icon(() -> new ItemStack(InvincibleModItems.INVINCIBLE_SUIT_CHESTPLATE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(InvincibleModItems.INVINCIBLE_SUIT_HELMET.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_SUIT_BOOTS.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_MARK_SPAWN_EGG.get());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(InvincibleModItems.VILTRUMITE_SPAWN_EGG.get());
		}
	}
}
