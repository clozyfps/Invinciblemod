
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.invincible.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.invincible.client.gui.StatsMenuScreen;
import net.mcreator.invincible.client.gui.DimensionSelectorScreen;
import net.mcreator.invincible.client.gui.BookPickerScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class InvincibleModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(InvincibleModMenus.BOOK_PICKER.get(), BookPickerScreen::new);
			MenuScreens.register(InvincibleModMenus.DIMENSION_SELECTOR.get(), DimensionSelectorScreen::new);
			MenuScreens.register(InvincibleModMenus.STATS_MENU.get(), StatsMenuScreen::new);
		});
	}
}
