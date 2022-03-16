
package net.mcreator.xindustry.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.xindustry.itemgroup.JiChuWuPinItemGroup;
import net.mcreator.xindustry.XIndustryModElements;

@XIndustryModElements.ModElement.Tag
public class ParticleItem extends XIndustryModElements.ModElement {
	@ObjectHolder("x_industry:particle")
	public static final Item block = null;

	public ParticleItem(XIndustryModElements instance) {
		super(instance, 34);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(JiChuWuPinItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("particle");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}