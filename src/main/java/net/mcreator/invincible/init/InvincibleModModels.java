
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.invincible.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.invincible.client.model.Modelviltrumite_armor;
import net.mcreator.invincible.client.model.Modelrex_splode_suit;
import net.mcreator.invincible.client.model.Modelomniman_suit;
import net.mcreator.invincible.client.model.Modelmauler_suit;
import net.mcreator.invincible.client.model.Modelinvincible_suit;
import net.mcreator.invincible.client.model.Modelflaxan_armor;
import net.mcreator.invincible.client.model.Modelclone_twin_suit;
import net.mcreator.invincible.client.model.Modelangstrom_clothes;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class InvincibleModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelclone_twin_suit.LAYER_LOCATION, Modelclone_twin_suit::createBodyLayer);
		event.registerLayerDefinition(Modelmauler_suit.LAYER_LOCATION, Modelmauler_suit::createBodyLayer);
		event.registerLayerDefinition(Modelangstrom_clothes.LAYER_LOCATION, Modelangstrom_clothes::createBodyLayer);
		event.registerLayerDefinition(Modelrex_splode_suit.LAYER_LOCATION, Modelrex_splode_suit::createBodyLayer);
		event.registerLayerDefinition(Modelviltrumite_armor.LAYER_LOCATION, Modelviltrumite_armor::createBodyLayer);
		event.registerLayerDefinition(Modelinvincible_suit.LAYER_LOCATION, Modelinvincible_suit::createBodyLayer);
		event.registerLayerDefinition(Modelomniman_suit.LAYER_LOCATION, Modelomniman_suit::createBodyLayer);
		event.registerLayerDefinition(Modelflaxan_armor.LAYER_LOCATION, Modelflaxan_armor::createBodyLayer);
	}
}
