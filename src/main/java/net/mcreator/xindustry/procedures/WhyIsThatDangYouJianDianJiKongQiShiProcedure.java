package net.mcreator.xindustry.procedures;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.util.FoodStats;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.xindustry.item.WhyIsThatItem;
import net.mcreator.xindustry.XIndustryMod;

import java.util.Map;

public class WhyIsThatDangYouJianDianJiKongQiShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				XIndustryMod.LOGGER.warn("Failed to load dependency entity for procedure WhyIsThatDangYouJianDianJiKongQiShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			ObfuscationReflectionHelper.setPrivateValue(FoodStats.class, ((PlayerEntity) entity).getFoodStats(), (float) 0, "field_75125_b");
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).addExperienceLevel(-((int) 30));
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(WhyIsThatItem.block);
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) entity).container.func_234641_j_());
		}
	}
}
