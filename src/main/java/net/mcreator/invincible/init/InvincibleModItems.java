
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
import net.mcreator.invincible.item.CharacterPickerItem;
import net.mcreator.invincible.InvincibleMod;

public class InvincibleModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, InvincibleMod.MODID);
	public static final RegistryObject<Item> TEST = REGISTRY.register("test", () -> new TestItem());
	public static final RegistryObject<Item> SPACE_BLOCK = block(InvincibleModBlocks.SPACE_BLOCK);
	public static final RegistryObject<Item> VILTRUMITE_SPAWN_EGG = REGISTRY.register("viltrumite_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.VILTRUMITE, -1250068, -5460820, new Item.Properties()));
	public static final RegistryObject<Item> CHARACTER_PICKER = REGISTRY.register("character_picker", () -> new CharacterPickerItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
