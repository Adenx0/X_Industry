
package net.mcreator.xindustry.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.xindustry.XIndustryModElements;

@XIndustryModElements.ModElement.Tag
public class CopperaxeItem extends XIndustryModElements.ModElement {
	@ObjectHolder("x_industry:copperaxe")
	public static final Item block = null;

	public CopperaxeItem(XIndustryModElements instance) {
		super(instance, 24);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 150;
			}

			public float getEfficiency() {
				return 5f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 6;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3.5f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("copperaxe"));
	}
}
