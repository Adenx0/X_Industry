package net.mcreator.xindustry.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;

import net.mcreator.xindustry.item.ParticleItem;
import net.mcreator.xindustry.XIndustryMod;

import java.util.Map;

public class ParticleCollectorDangWuPinZaiShouShangMeiKeFaShengProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				XIndustryMod.LOGGER.warn("Failed to load dependency world for procedure ParticleCollectorDangWuPinZaiShouShangMeiKeFaSheng!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				XIndustryMod.LOGGER.warn("Failed to load dependency x for procedure ParticleCollectorDangWuPinZaiShouShangMeiKeFaSheng!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				XIndustryMod.LOGGER.warn("Failed to load dependency y for procedure ParticleCollectorDangWuPinZaiShouShangMeiKeFaSheng!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				XIndustryMod.LOGGER.warn("Failed to load dependency z for procedure ParticleCollectorDangWuPinZaiShouShangMeiKeFaSheng!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world instanceof World && !world.isRemote()) {
			ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ParticleItem.block));
			entityToSpawn.setPickupDelay((int) 10);
			world.addEntity(entityToSpawn);
		}
	}
}
