
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

import net.mcreator.invincible.item.ViltrumiteSuitItem;
import net.mcreator.invincible.item.VeilInvincibleSuitItem;
import net.mcreator.invincible.item.TutorialItem;
import net.mcreator.invincible.item.TestItem;
import net.mcreator.invincible.item.SinisterInvincibleSuitItem;
import net.mcreator.invincible.item.RexSplodeSuitItem;
import net.mcreator.invincible.item.OmniManSuitItem;
import net.mcreator.invincible.item.MultiPaulSuitItem;
import net.mcreator.invincible.item.MohawkInvincibleSuitItem;
import net.mcreator.invincible.item.MaulerSuitItem;
import net.mcreator.invincible.item.MaskedInvincibleSuitItem;
import net.mcreator.invincible.item.InvincibleSuitItem;
import net.mcreator.invincible.item.InvincibleBlueSuitItem;
import net.mcreator.invincible.item.FlaxanGunItem;
import net.mcreator.invincible.item.FlaxanArmorItem;
import net.mcreator.invincible.item.DupliKateSuitItem;
import net.mcreator.invincible.item.CharacterPickerItem;
import net.mcreator.invincible.item.AngstromSuitItem;
import net.mcreator.invincible.InvincibleMod;

public class InvincibleModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, InvincibleMod.MODID);
	public static final RegistryObject<Item> TEST = REGISTRY.register("test", () -> new TestItem());
	public static final RegistryObject<Item> SPACE_BLOCK = block(InvincibleModBlocks.SPACE_BLOCK);
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
	public static final RegistryObject<Item> FLAXAN_SOLDIER_SPAWN_EGG = REGISTRY.register("flaxan_soldier_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.FLAXAN_SOLDIER, -1574407, -9849256, new Item.Properties()));
	public static final RegistryObject<Item> MAULER_SUIT_CHESTPLATE = REGISTRY.register("mauler_suit_chestplate", () -> new MaulerSuitItem.Chestplate());
	public static final RegistryObject<Item> MAULER_SUIT_LEGGINGS = REGISTRY.register("mauler_suit_leggings", () -> new MaulerSuitItem.Leggings());
	public static final RegistryObject<Item> MAULER_SPAWN_EGG = REGISTRY.register("mauler_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.MAULER, -1574407, -14670812, new Item.Properties()));
	public static final RegistryObject<Item> FLAXAN_ARMOR_CHESTPLATE = REGISTRY.register("flaxan_armor_chestplate", () -> new FlaxanArmorItem.Chestplate());
	public static final RegistryObject<Item> FLAXAN_ARMOR_LEGGINGS = REGISTRY.register("flaxan_armor_leggings", () -> new FlaxanArmorItem.Leggings());
	public static final RegistryObject<Item> FLAXAN_ARMOR_BOOTS = REGISTRY.register("flaxan_armor_boots", () -> new FlaxanArmorItem.Boots());
	public static final RegistryObject<Item> TUTORIAL = REGISTRY.register("tutorial", () -> new TutorialItem());
	public static final RegistryObject<Item> FLAXAN_GUNMAN_SPAWN_EGG = REGISTRY.register("flaxan_gunman_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.FLAXAN_GUNMAN, -1574407, -9849256, new Item.Properties()));
	public static final RegistryObject<Item> FLAXAN_GUN = REGISTRY.register("flaxan_gun", () -> new FlaxanGunItem());
	public static final RegistryObject<Item> REX_SPLODE_SUIT_HELMET = REGISTRY.register("rex_splode_suit_helmet", () -> new RexSplodeSuitItem.Helmet());
	public static final RegistryObject<Item> REX_SPLODE_SUIT_CHESTPLATE = REGISTRY.register("rex_splode_suit_chestplate", () -> new RexSplodeSuitItem.Chestplate());
	public static final RegistryObject<Item> REX_SPLODE_SUIT_LEGGINGS = REGISTRY.register("rex_splode_suit_leggings", () -> new RexSplodeSuitItem.Leggings());
	public static final RegistryObject<Item> REX_SPLODE_SUIT_BOOTS = REGISTRY.register("rex_splode_suit_boots", () -> new RexSplodeSuitItem.Boots());
	public static final RegistryObject<Item> REX_SPLODE_SPAWN_EGG = REGISTRY.register("rex_splode_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.REX_SPLODE, -2103165, -6602959, new Item.Properties()));
	public static final RegistryObject<Item> DUPLI_KATE_SPAWN_EGG = REGISTRY.register("dupli_kate_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.DUPLI_KATE, -4081449, -13028264, new Item.Properties()));
	public static final RegistryObject<Item> MULTI_PAUL_SUIT_CHESTPLATE = REGISTRY.register("multi_paul_suit_chestplate", () -> new MultiPaulSuitItem.Chestplate());
	public static final RegistryObject<Item> MULTI_PAUL_SUIT_LEGGINGS = REGISTRY.register("multi_paul_suit_leggings", () -> new MultiPaulSuitItem.Leggings());
	public static final RegistryObject<Item> MULTI_PAUL_SUIT_BOOTS = REGISTRY.register("multi_paul_suit_boots", () -> new MultiPaulSuitItem.Boots());
	public static final RegistryObject<Item> DUPLI_KATE_SUIT_CHESTPLATE = REGISTRY.register("dupli_kate_suit_chestplate", () -> new DupliKateSuitItem.Chestplate());
	public static final RegistryObject<Item> DUPLI_KATE_SUIT_LEGGINGS = REGISTRY.register("dupli_kate_suit_leggings", () -> new DupliKateSuitItem.Leggings());
	public static final RegistryObject<Item> DUPLI_KATE_SUIT_BOOTS = REGISTRY.register("dupli_kate_suit_boots", () -> new DupliKateSuitItem.Boots());
	public static final RegistryObject<Item> MULTI_PAUL_SPAWN_EGG = REGISTRY.register("multi_paul_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.MULTI_PAUL, -13028264, -4081449, new Item.Properties()));
	public static final RegistryObject<Item> VILTRUMITE_FEMALE_SPAWN_EGG = REGISTRY.register("viltrumite_female_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.VILTRUMITE_FEMALE, -1250068, -5460820, new Item.Properties()));
	public static final RegistryObject<Item> ANGSTROM_SUIT_HELMET = REGISTRY.register("angstrom_suit_helmet", () -> new AngstromSuitItem.Helmet());
	public static final RegistryObject<Item> ANGSTROM_SUIT_CHESTPLATE = REGISTRY.register("angstrom_suit_chestplate", () -> new AngstromSuitItem.Chestplate());
	public static final RegistryObject<Item> ANGSTROM_SUIT_LEGGINGS = REGISTRY.register("angstrom_suit_leggings", () -> new AngstromSuitItem.Leggings());
	public static final RegistryObject<Item> ANGSTROM_SUIT_BOOTS = REGISTRY.register("angstrom_suit_boots", () -> new AngstromSuitItem.Boots());
	public static final RegistryObject<Item> ANGSTROM_SPAWN_EGG = REGISTRY.register("angstrom_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.ANGSTROM, -13421773, -10092544, new Item.Properties()));
	public static final RegistryObject<Item> VILTRUMITE_MALE_SPAWN_EGG = REGISTRY.register("viltrumite_male_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.VILTRUMITE_MALE, -1250068, -5460820, new Item.Properties()));
	public static final RegistryObject<Item> VILTRUMITE_SUIT_CHESTPLATE = REGISTRY.register("viltrumite_suit_chestplate", () -> new ViltrumiteSuitItem.Chestplate());
	public static final RegistryObject<Item> VILTRUMITE_SUIT_LEGGINGS = REGISTRY.register("viltrumite_suit_leggings", () -> new ViltrumiteSuitItem.Leggings());
	public static final RegistryObject<Item> VILTRUMITE_SUIT_BOOTS = REGISTRY.register("viltrumite_suit_boots", () -> new ViltrumiteSuitItem.Boots());
	public static final RegistryObject<Item> BATTLE_BEAST_SPAWN_EGG = REGISTRY.register("battle_beast_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.BATTLE_BEAST, -6750208, -3368704, new Item.Properties()));
	public static final RegistryObject<Item> MARTIAN_SPAWN_EGG = REGISTRY.register("martian_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.MARTIAN, -7882139, -1, new Item.Properties()));
	public static final RegistryObject<Item> MARTIAN_SPEARMAN_SPAWN_EGG = REGISTRY.register("martian_spearman_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.MARTIAN_SPEARMAN, -7882139, -1, new Item.Properties()));
	public static final RegistryObject<Item> VEIL_INVINCIBLE_SUIT_HELMET = REGISTRY.register("veil_invincible_suit_helmet", () -> new VeilInvincibleSuitItem.Helmet());
	public static final RegistryObject<Item> VEIL_INVINCIBLE_SUIT_CHESTPLATE = REGISTRY.register("veil_invincible_suit_chestplate", () -> new VeilInvincibleSuitItem.Chestplate());
	public static final RegistryObject<Item> VEIL_INVINCIBLE_SUIT_LEGGINGS = REGISTRY.register("veil_invincible_suit_leggings", () -> new VeilInvincibleSuitItem.Leggings());
	public static final RegistryObject<Item> VEIL_INVINCIBLE_SUIT_BOOTS = REGISTRY.register("veil_invincible_suit_boots", () -> new VeilInvincibleSuitItem.Boots());
	public static final RegistryObject<Item> MASKED_INVINCIBLE_SUIT_HELMET = REGISTRY.register("masked_invincible_suit_helmet", () -> new MaskedInvincibleSuitItem.Helmet());
	public static final RegistryObject<Item> MASKED_INVINCIBLE_SUIT_CHESTPLATE = REGISTRY.register("masked_invincible_suit_chestplate", () -> new MaskedInvincibleSuitItem.Chestplate());
	public static final RegistryObject<Item> MASKED_INVINCIBLE_SUIT_LEGGINGS = REGISTRY.register("masked_invincible_suit_leggings", () -> new MaskedInvincibleSuitItem.Leggings());
	public static final RegistryObject<Item> MASKED_INVINCIBLE_SUIT_BOOTS = REGISTRY.register("masked_invincible_suit_boots", () -> new MaskedInvincibleSuitItem.Boots());
	public static final RegistryObject<Item> MOHAWK_INVINCIBLE_SUIT_CHESTPLATE = REGISTRY.register("mohawk_invincible_suit_chestplate", () -> new MohawkInvincibleSuitItem.Chestplate());
	public static final RegistryObject<Item> MOHAWK_INVINCIBLE_SUIT_LEGGINGS = REGISTRY.register("mohawk_invincible_suit_leggings", () -> new MohawkInvincibleSuitItem.Leggings());
	public static final RegistryObject<Item> MOHAWK_INVINCIBLE_SUIT_BOOTS = REGISTRY.register("mohawk_invincible_suit_boots", () -> new MohawkInvincibleSuitItem.Boots());
	public static final RegistryObject<Item> SINISTER_INVINCIBLE_SUIT_HELMET = REGISTRY.register("sinister_invincible_suit_helmet", () -> new SinisterInvincibleSuitItem.Helmet());
	public static final RegistryObject<Item> SINISTER_INVINCIBLE_SUIT_CHESTPLATE = REGISTRY.register("sinister_invincible_suit_chestplate", () -> new SinisterInvincibleSuitItem.Chestplate());
	public static final RegistryObject<Item> SINISTER_INVINCIBLE_SUIT_LEGGINGS = REGISTRY.register("sinister_invincible_suit_leggings", () -> new SinisterInvincibleSuitItem.Leggings());
	public static final RegistryObject<Item> SINISTER_INVINCIBLE_SUIT_BOOTS = REGISTRY.register("sinister_invincible_suit_boots", () -> new SinisterInvincibleSuitItem.Boots());
	public static final RegistryObject<Item> SINISTER_INVINCIBLE_SPAWN_EGG = REGISTRY.register("sinister_invincible_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.SINISTER_INVINCIBLE, -16777216, -1513415, new Item.Properties()));
	public static final RegistryObject<Item> MOHAWK_INVINCIBLE_SPAWN_EGG = REGISTRY.register("mohawk_invincible_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.MOHAWK_INVINCIBLE, -16777216, -13472318, new Item.Properties()));
	public static final RegistryObject<Item> VEIL_INVINCIBLE_SPAWN_EGG = REGISTRY.register("veil_invincible_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.VEIL_INVINCIBLE, -1511836, -16086563, new Item.Properties()));
	public static final RegistryObject<Item> MASKLESS_INVINCIBLE_SPAWN_EGG = REGISTRY.register("maskless_invincible_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.MASKLESS_INVINCIBLE, -1513415, -16086563, new Item.Properties()));
	public static final RegistryObject<Item> FULL_MASK_INVINCIBLE_SPAWN_EGG = REGISTRY.register("full_mask_invincible_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.FULL_MASK_INVINCIBLE, -16777216, -13472318, new Item.Properties()));
	public static final RegistryObject<Item> DINOSAUR_SPAWN_EGG = REGISTRY.register("dinosaur_spawn_egg", () -> new ForgeSpawnEggItem(InvincibleModEntities.DINOSAUR, -8827621, -8827621, new Item.Properties()));

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
