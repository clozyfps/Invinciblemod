
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.invincible.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.invincible.client.renderer.ViltrumiteMaleRenderer;
import net.mcreator.invincible.client.renderer.ViltrumiteFemaleRenderer;
import net.mcreator.invincible.client.renderer.ViltrumPlanetRenderer;
import net.mcreator.invincible.client.renderer.VeilInvincibleRenderer;
import net.mcreator.invincible.client.renderer.SinisterInvincibleRenderer;
import net.mcreator.invincible.client.renderer.RoboBallRenderer;
import net.mcreator.invincible.client.renderer.RexSplodeRenderer;
import net.mcreator.invincible.client.renderer.PastImageRenderer;
import net.mcreator.invincible.client.renderer.OmnimanRenderer;
import net.mcreator.invincible.client.renderer.MultiPaulRenderer;
import net.mcreator.invincible.client.renderer.MohawkInvincibleRenderer;
import net.mcreator.invincible.client.renderer.MaulerRenderer;
import net.mcreator.invincible.client.renderer.MasklessInvincibleRenderer;
import net.mcreator.invincible.client.renderer.MartianSpearmanRenderer;
import net.mcreator.invincible.client.renderer.MartianRenderer;
import net.mcreator.invincible.client.renderer.MarsProximityRenderer;
import net.mcreator.invincible.client.renderer.MarsPlanetRenderer;
import net.mcreator.invincible.client.renderer.InvincibleMarkRenderer;
import net.mcreator.invincible.client.renderer.InvincibleBlueMarkRenderer;
import net.mcreator.invincible.client.renderer.FullMaskInvincibleRenderer;
import net.mcreator.invincible.client.renderer.FlaxanSoldierRenderer;
import net.mcreator.invincible.client.renderer.FlaxanPortalRenderer;
import net.mcreator.invincible.client.renderer.FlaxanGunmanRenderer;
import net.mcreator.invincible.client.renderer.FireworkExplosionRenderer;
import net.mcreator.invincible.client.renderer.EarthRenderer;
import net.mcreator.invincible.client.renderer.DupliKateRenderer;
import net.mcreator.invincible.client.renderer.DinosaurRenderer;
import net.mcreator.invincible.client.renderer.DimensionalPortalRenderer;
import net.mcreator.invincible.client.renderer.CloneRenderer;
import net.mcreator.invincible.client.renderer.ClawMobRenderer;
import net.mcreator.invincible.client.renderer.BattleBeastRenderer;
import net.mcreator.invincible.client.renderer.AtomBarrierRenderer;
import net.mcreator.invincible.client.renderer.AngstromRenderer;
import net.mcreator.invincible.client.renderer.AfterImageRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class InvincibleModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(InvincibleModEntities.MARS_PROXIMITY.get(), MarsProximityRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.AFTER_IMAGE.get(), AfterImageRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.SONIC_CLAP.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.PAST_IMAGE.get(), PastImageRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.WEB_LINE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.INVINCIBLE_MARK.get(), InvincibleMarkRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.INVINCIBLE_BLUE_MARK.get(), InvincibleBlueMarkRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.OMNIMAN.get(), OmnimanRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.FLAXAN_SOLDIER.get(), FlaxanSoldierRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.MAULER.get(), MaulerRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.FLAXAN_PORTAL.get(), FlaxanPortalRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.FLAXAN_GUNMAN.get(), FlaxanGunmanRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.BLASTER_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.KNOCKBACK_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.FIREWORK_EXPLOSION.get(), FireworkExplosionRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.EXPLOSION_SMALL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.EXPLOSION_LARGE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.REX_SPLODE.get(), RexSplodeRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.CLONE.get(), CloneRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.TRANSFER_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.DUPLI_KATE.get(), DupliKateRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.MULTI_PAUL.get(), MultiPaulRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.DIMENSIONAL_PORTAL.get(), DimensionalPortalRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.VILTRUMITE_FEMALE.get(), ViltrumiteFemaleRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.ANGSTROM.get(), AngstromRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.VILTRUMITE_MALE.get(), ViltrumiteMaleRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.CLAW_MOB.get(), ClawMobRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.ROBO_BALL.get(), RoboBallRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.BATTLE_BEAST.get(), BattleBeastRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.ATOM_BARRIER.get(), AtomBarrierRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.MARTIAN.get(), MartianRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.MARTIAN_SPEARMAN.get(), MartianSpearmanRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.SINISTER_INVINCIBLE.get(), SinisterInvincibleRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.MOHAWK_INVINCIBLE.get(), MohawkInvincibleRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.VEIL_INVINCIBLE.get(), VeilInvincibleRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.MASKLESS_INVINCIBLE.get(), MasklessInvincibleRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.FULL_MASK_INVINCIBLE.get(), FullMaskInvincibleRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.DINOSAUR.get(), DinosaurRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.EARTH.get(), EarthRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.MARS_PLANET.get(), MarsPlanetRenderer::new);
		event.registerEntityRenderer(InvincibleModEntities.VILTRUM_PLANET.get(), ViltrumPlanetRenderer::new);
	}
}
