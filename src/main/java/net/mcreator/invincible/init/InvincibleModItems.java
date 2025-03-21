
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.invincible.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.invincible.item.TestItem;
import net.mcreator.invincible.item.OmniManSuitItem;
import net.mcreator.invincible.item.MaulerSuitItem;
import net.mcreator.invincible.item.InvincibleSuitItem;
import net.mcreator.invincible.item.InvincibleBlueSuitItem;
import net.mcreator.invincible.item.CharacterPickerItem;
import net.mcreator.invincible.InvincibleMod;

public class InvincibleModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, InvincibleMod.MODID);
	public static final RegistryObject<Item> TEST = REGISTRY.register("test", () -> new TestItem());
	public static final RegistryObject<Item> SPACE_BLOCK = block(InvincibleModBlocks.SPACE_BLOCK);
	public static final RegistryObject<Item> VILTRUMITE_SPAWN_EGG = REGISTRY.register("viltrumite_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.VILTRUMITE, -1250068, -5460820, new Item.Properties()));
	public static final RegistryObject<Item> CHARACTER_PICKER = REGISTRY.register("character_picker", () -> new CharacterPickerItem());
	public static final RegistryObject<Item> INVINCIBLE_SUIT_HELMET = REGISTRY.register("invincible_suit_helmet", () -> new InvincibleSuitItem.Helmet());
	public static final RegistryObject<Item> INVINCIBLE_SUIT_CHESTPLATE = REGISTRY.register("invincible_suit_chestplate", () -> new InvincibleSuitItem.Chestplate());
	public static final RegistryObject<Item> INVINCIBLE_SUIT_LEGGINGS = REGISTRY.register("invincible_suit_leggings", () -> new InvincibleSuitItem.Leggings());
	public static final RegistryObject<Item> INVINCIBLE_SUIT_BOOTS = REGISTRY.register("invincible_suit_boots", () -> new InvincibleSuitItem.Boots());
	public static final RegistryObject<Item> INVINCIBLE_MARK_SPAWN_EGG = REGISTRY.register("invincible_mark_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.INVINCIBLE_MARK, -1513415, -16086563, new Item.Properties()));
	public static final RegistryObject<Item> INVINCIBLE_BLUE_SUIT_HELMET = REGISTRY.register("invincible_blue_suit_helmet", () -> new InvincibleBlueSuitItem.Helmet());
	public static final RegistryObject<Item> INVINCIBLE_BLUE_SUIT_CHESTPLATE = REGISTRY.register("invincible_blue_suit_chestplate", () -> new InvincibleBlueSuitItem.Chestplate());
	public static final RegistryObject<Item> INVINCIBLE_BLUE_SUIT_LEGGINGS = REGISTRY.register("invincible_blue_suit_leggings", () -> new InvincibleBlueSuitItem.Leggings());
	public static final RegistryObject<Item> INVINCIBLE_BLUE_SUIT_BOOTS = REGISTRY.register("invincible_blue_suit_boots", () -> new InvincibleBlueSuitItem.Boots());
	public static final RegistryObject<Item> INVINCIBLE_BLUE_MARK_SPAWN_EGG = REGISTRY.register("invincible_blue_mark_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.INVINCIBLE_BLUE_MARK, -13472318, -14605275, new Item.Properties()));
	public static final RegistryObject<Item> OMNIMAN_SPAWN_EGG = REGISTRY.register("omniman_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.OMNIMAN, -1, -2344904, new Item.Properties()));
	public static final RegistryObject<Item> OMNI_MAN_SUIT_CHESTPLATE = REGISTRY.register("omni_man_suit_chestplate", () -> new OmniManSuitItem.Chestplate());
	public static final RegistryObject<Item> OMNI_MAN_SUIT_LEGGINGS = REGISTRY.register("omni_man_suit_leggings", () -> new OmniManSuitItem.Leggings());
	public static final RegistryObject<Item> OMNI_MAN_SUIT_BOOTS = REGISTRY.register("omni_man_suit_boots", () -> new OmniManSuitItem.Boots());
	public static final RegistryObject<Item> MAULER_SUIT_CHESTPLATE = REGISTRY.register("mauler_suit_chestplate", () -> new MaulerSuitItem.Chestplate());
	public static final RegistryObject<Item> MAULER_SUIT_LEGGINGS = REGISTRY.register("mauler_suit_leggings", () -> new MaulerSuitItem.Leggings());
	public static final RegistryObject<Item> MAULER_SPAWN_EGG = REGISTRY.register("mauler_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.MAULER, -1574407, -14670812, new Item.Properties()));

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
