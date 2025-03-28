package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.invincible.entity.ViltrumiteFemaleEntity;

public class ViltrumiteFemaleOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ViltrumiteFemaleEntity _datEntSetI)
			_datEntSetI.getEntityData().set(ViltrumiteFemaleEntity.DATA_femalevilapp, Mth.nextInt(RandomSource.create(), 1, 5));
		if ((entity instanceof ViltrumiteFemaleEntity _datEntI ? _datEntI.getEntityData().get(ViltrumiteFemaleEntity.DATA_femalevilapp) : 0) == 1) {
			if (entity instanceof ViltrumiteFemaleEntity animatable)
				animatable.setTexture("viltrumite_female_black");
		} else if ((entity instanceof ViltrumiteFemaleEntity _datEntI ? _datEntI.getEntityData().get(ViltrumiteFemaleEntity.DATA_femalevilapp) : 0) == 2) {
			if (entity instanceof ViltrumiteFemaleEntity animatable)
				animatable.setTexture("viltrumite_female_blonde");
		} else if ((entity instanceof ViltrumiteFemaleEntity _datEntI ? _datEntI.getEntityData().get(ViltrumiteFemaleEntity.DATA_femalevilapp) : 0) == 3) {
			if (entity instanceof ViltrumiteFemaleEntity animatable)
				animatable.setTexture("viltrumite_female_brown");
		} else if ((entity instanceof ViltrumiteFemaleEntity _datEntI ? _datEntI.getEntityData().get(ViltrumiteFemaleEntity.DATA_femalevilapp) : 0) == 4) {
			if (entity instanceof ViltrumiteFemaleEntity animatable)
				animatable.setTexture("viltrumite_female_gray");
		} else if ((entity instanceof ViltrumiteFemaleEntity _datEntI ? _datEntI.getEntityData().get(ViltrumiteFemaleEntity.DATA_femalevilapp) : 0) == 5) {
			if (entity instanceof ViltrumiteFemaleEntity animatable)
				animatable.setTexture("viltrumite_female_white");
		}
		if (entity instanceof LivingEntity _entity)
			_entity.setHealth((float) (100 + Mth.nextInt(RandomSource.create(), 1, 400)));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 999999, (int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / 50), false, false));
	}
}
