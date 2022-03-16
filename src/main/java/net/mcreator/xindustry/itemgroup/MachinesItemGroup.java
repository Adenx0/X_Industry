
package net.mcreator.xindustry.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.xindustry.item.GuidebookItem;
import net.mcreator.xindustry.XIndustryModElements;

@XIndustryModElements.ModElement.Tag
public class MachinesItemGroup extends XIndustryModElements.ModElement {
	public MachinesItemGroup(XIndustryModElements instance) {
		super(instance, 22);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmachines") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(GuidebookItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
