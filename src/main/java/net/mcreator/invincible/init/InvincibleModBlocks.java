
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.invincible.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.invincible.block.SpaceBlockBlock;
import net.mcreator.invincible.InvincibleMod;

public class InvincibleModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, InvincibleMod.MODID);
	public static final RegistryObject<Block> SPACE_BLOCK = REGISTRY.register("space_block", () -> new SpaceBlockBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
