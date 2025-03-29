
package net.mcreator.invincible.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.invincible.world.inventory.DimensionSelectorMenu;
import net.mcreator.invincible.procedures.SelectDimensionSnowProcedure;
import net.mcreator.invincible.procedures.SelectDimensionRandomProcedure;
import net.mcreator.invincible.procedures.SelectDimensionOverworldProcedure;
import net.mcreator.invincible.procedures.SelectDimensionNetherProcedure;
import net.mcreator.invincible.procedures.SelectDimensionFlaxanProcedure;
import net.mcreator.invincible.procedures.SelectDimensionEndProcedure;
import net.mcreator.invincible.procedures.SelectDimensionDesertProcedure;
import net.mcreator.invincible.procedures.SelectDimensionApocalypticProcedure;
import net.mcreator.invincible.InvincibleMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DimensionSelectorButtonMessage {
	private final int buttonID, x, y, z;

	public DimensionSelectorButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public DimensionSelectorButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(DimensionSelectorButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(DimensionSelectorButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = DimensionSelectorMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SelectDimensionRandomProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			SelectDimensionOverworldProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			SelectDimensionNetherProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			SelectDimensionEndProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			SelectDimensionApocalypticProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			SelectDimensionDesertProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			SelectDimensionSnowProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			SelectDimensionFlaxanProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		InvincibleMod.addNetworkMessage(DimensionSelectorButtonMessage.class, DimensionSelectorButtonMessage::buffer, DimensionSelectorButtonMessage::new, DimensionSelectorButtonMessage::handler);
	}
}
