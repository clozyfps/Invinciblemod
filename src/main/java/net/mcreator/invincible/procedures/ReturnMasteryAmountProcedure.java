package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ReturnMasteryAmountProcedure {
	public static String execute() {
		return new java.text.DecimalFormat("##").format() + "/" + "100" + " Mastery";
	}
}
