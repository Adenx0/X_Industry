
package net.mcreator.xindustry.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.xindustry.item.CircuitboardItem;
import net.mcreator.xindustry.XIndustryModElements;

@XIndustryModElements.ModElement.Tag
public class JiChuWuPinItemGroup extends XIndustryModElements.ModElement {
	public JiChuWuPinItemGroup(XIndustryModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabbase_item") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CircuitboardItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
