
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.invincible.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.invincible.InvincibleMod;

public class InvincibleModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, InvincibleMod.MODID);
	public static final RegistryObject<CreativeModeTab> INVINCIBLE_TAB = REGISTRY.register("invincible_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.invincible.invincible_tab")).icon(() -> new ItemStack(InvincibleModItems.INVINCIBLE_SUIT_CHESTPLATE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(InvincibleModItems.INVINCIBLE_MARK_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_SUIT_HELMET.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_SUIT_BOOTS.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_BLUE_MARK_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_BLUE_SUIT_HELMET.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_BLUE_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_BLUE_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_BLUE_SUIT_BOOTS.get());
				tabData.accept(InvincibleModItems.OMNIMAN_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.OMNI_MAN_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleModItems.OMNI_MAN_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleModItems.OMNI_MAN_SUIT_BOOTS.get());
				tabData.accept(InvincibleModItems.VILTRUMITE_SPAWN_EGG.get());
			}).build());
}
