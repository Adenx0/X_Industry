
package net.mcreator.xindustry.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.xindustry.itemgroup.KuangwuItemGroup;
import net.mcreator.xindustry.XIndustryModElements;

@XIndustryModElements.ModElement.Tag
public class SilverItem extends XIndustryModElements.ModElement {
	@ObjectHolder("x_industry:silver")
	public static final Item block = null;

	public SilverItem(XIndustryModElements instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(KuangwuItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("silver");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
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
