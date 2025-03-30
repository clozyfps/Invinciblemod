
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.invincible.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.invincible.world.inventory.StatsMenuMenu;
import net.mcreator.invincible.world.inventory.DimensionSelectorMenu;
import net.mcreator.invincible.world.inventory.BookPickerMenu;
import net.mcreator.invincible.InvincibleMod;

public class InvincibleModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, InvincibleMod.MODID);
	public static final RegistryObject<MenuType<BookPickerMenu>> BOOK_PICKER = REGISTRY.register("book_picker", () -> IForgeMenuType.create(BookPickerMenu::new));
	public static final RegistryObject<MenuType<DimensionSelectorMenu>> DIMENSION_SELECTOR = REGISTRY.register("dimension_selector", () -> IForgeMenuType.create(DimensionSelectorMenu::new));
	public static final RegistryObject<MenuType<StatsMenuMenu>> STATS_MENU = REGISTRY.register("stats_menu", () -> IForgeMenuType.create(StatsMenuMenu::new));
}
