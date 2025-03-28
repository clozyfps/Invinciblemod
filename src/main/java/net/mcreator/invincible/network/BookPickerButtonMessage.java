
package net.mcreator.invincible.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.invincible.world.inventory.BookPickerMenu;
import net.mcreator.invincible.procedures.SelectViltrumiteProcedure;
import net.mcreator.invincible.procedures.SelectSpiderProcedure;
import net.mcreator.invincible.procedures.SelectSpeedsterProcedure;
import net.mcreator.invincible.procedures.SelectPortalProcedure;
import net.mcreator.invincible.procedures.SelectHumanProcedure;
import net.mcreator.invincible.procedures.SelectExplodeProcedure;
import net.mcreator.invincible.procedures.SelectCloneProcedure;
import net.mcreator.invincible.InvincibleMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BookPickerButtonMessage {
	private final int buttonID, x, y, z;

	public BookPickerButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public BookPickerButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(BookPickerButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(BookPickerButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = BookPickerMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SelectViltrumiteProcedure.execute(entity);
		}
		if (buttonID == 1) {

			SelectHumanProcedure.execute(entity);
		}
		if (buttonID == 2) {

			SelectSpeedsterProcedure.execute(entity);
		}
		if (buttonID == 3) {

			SelectSpiderProcedure.execute(entity);
		}
		if (buttonID == 4) {

			SelectExplodeProcedure.execute(entity);
		}
		if (buttonID == 5) {

			SelectCloneProcedure.execute(entity);
		}
		if (buttonID == 6) {

			SelectPortalProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		InvincibleMod.addNetworkMessage(BookPickerButtonMessage.class, BookPickerButtonMessage::buffer, BookPickerButtonMessage::new, BookPickerButtonMessage::handler);
	}
}
