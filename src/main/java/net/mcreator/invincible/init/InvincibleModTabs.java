
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
				tabData.accept(InvincibleModItems.INVINCIBLE_SUIT_HELMET.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_SUIT_BOOTS.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_BLUE_SUIT_HELMET.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_BLUE_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_BLUE_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_BLUE_SUIT_BOOTS.get());
				tabData.accept(InvincibleModItems.OMNI_MAN_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleModItems.OMNI_MAN_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleModItems.OMNI_MAN_SUIT_BOOTS.get());
				tabData.accept(InvincibleModItems.REX_SPLODE_SUIT_HELMET.get());
				tabData.accept(InvincibleModItems.REX_SPLODE_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleModItems.REX_SPLODE_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleModItems.REX_SPLODE_SUIT_BOOTS.get());
				tabData.accept(InvincibleModItems.MAULER_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleModItems.MAULER_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleModItems.FLAXAN_ARMOR_CHESTPLATE.get());
				tabData.accept(InvincibleModItems.FLAXAN_ARMOR_LEGGINGS.get());
				tabData.accept(InvincibleModItems.FLAXAN_ARMOR_BOOTS.get());
				tabData.accept(InvincibleModItems.MULTI_PAUL_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleModItems.MULTI_PAUL_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleModItems.MULTI_PAUL_SUIT_BOOTS.get());
				tabData.accept(InvincibleModItems.DUPLI_KATE_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleModItems.DUPLI_KATE_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleModItems.DUPLI_KATE_SUIT_BOOTS.get());
				tabData.accept(InvincibleModItems.ANGSTROM_SUIT_HELMET.get());
				tabData.accept(InvincibleModItems.ANGSTROM_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleModItems.ANGSTROM_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleModItems.ANGSTROM_SUIT_BOOTS.get());
				tabData.accept(InvincibleModItems.VILTRUMITE_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleModItems.VILTRUMITE_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleModItems.VILTRUMITE_SUIT_BOOTS.get());
				tabData.accept(InvincibleModItems.VEIL_INVINCIBLE_SUIT_HELMET.get());
				tabData.accept(InvincibleModItems.VEIL_INVINCIBLE_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleModItems.VEIL_INVINCIBLE_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleModItems.VEIL_INVINCIBLE_SUIT_BOOTS.get());
				tabData.accept(InvincibleModItems.MASKED_INVINCIBLE_SUIT_HELMET.get());
				tabData.accept(InvincibleModItems.MASKED_INVINCIBLE_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleModItems.MASKED_INVINCIBLE_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleModItems.MASKED_INVINCIBLE_SUIT_BOOTS.get());
				tabData.accept(InvincibleModItems.MOHAWK_INVINCIBLE_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleModItems.MOHAWK_INVINCIBLE_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleModItems.MOHAWK_INVINCIBLE_SUIT_BOOTS.get());
				tabData.accept(InvincibleModItems.SINISTER_INVINCIBLE_SUIT_HELMET.get());
				tabData.accept(InvincibleModItems.SINISTER_INVINCIBLE_SUIT_CHESTPLATE.get());
				tabData.accept(InvincibleModItems.SINISTER_INVINCIBLE_SUIT_LEGGINGS.get());
				tabData.accept(InvincibleModItems.SINISTER_INVINCIBLE_SUIT_BOOTS.get());
			}).build());
	public static final RegistryObject<CreativeModeTab> INVINCIBLE_ITEMS_TAB = REGISTRY.register("invincible_items_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.invincible.invincible_items_tab")).icon(() -> new ItemStack(InvincibleModItems.FLAXAN_GUN.get())).displayItems((parameters, tabData) -> {
				tabData.accept(InvincibleModItems.CHARACTER_PICKER.get());
				tabData.accept(InvincibleModItems.FLAXAN_GUN.get());
			}).withTabsBefore(INVINCIBLE_TAB.getId()).build());
	public static final RegistryObject<CreativeModeTab> INVINCIBLE_MOB_TAB = REGISTRY.register("invincible_mob_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.invincible.invincible_mob_tab")).icon(() -> new ItemStack(InvincibleModItems.INVINCIBLE_MARK_SPAWN_EGG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(InvincibleModItems.INVINCIBLE_MARK_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.INVINCIBLE_BLUE_MARK_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.OMNIMAN_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.FLAXAN_SOLDIER_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.MAULER_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.FLAXAN_GUNMAN_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.REX_SPLODE_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.DUPLI_KATE_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.MULTI_PAUL_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.VILTRUMITE_FEMALE_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.ANGSTROM_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.VILTRUMITE_MALE_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.BATTLE_BEAST_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.MARTIAN_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.MARTIAN_SPEARMAN_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.SINISTER_INVINCIBLE_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.MOHAWK_INVINCIBLE_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.VEIL_INVINCIBLE_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.MASKLESS_INVINCIBLE_SPAWN_EGG.get());
				tabData.accept(InvincibleModItems.FULL_MASK_INVINCIBLE_SPAWN_EGG.get());
			}).withTabsBefore(INVINCIBLE_ITEMS_TAB.getId()).build());
}
