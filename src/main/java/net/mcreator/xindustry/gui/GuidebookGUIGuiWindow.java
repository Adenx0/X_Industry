
package net.mcreator.xindustry.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.xindustry.XIndustryMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class GuidebookGUIGuiWindow extends ContainerScreen<GuidebookGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = GuidebookGUIGui.guistate;

	public GuidebookGUIGuiWindow(GuidebookGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = new ResourceLocation("x_industry:textures/guidebook_gui.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "\uFFFD\uFFFD\uFFFD\uFFFD\u05AE\uFFFD\uFFFD", 72, 14, -12829636);
		this.font.drawString(ms, "\uFFFD\uFFFD\uFFFDmod\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD", 9, 32, -12829636);
		this.font.drawString(ms, "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD", 8, 42, -12829636);
		this.font.drawString(ms, "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u00B5\u013F\uFFFD\uFFFD\uFFFD", 8, 53, -12829636);
		this.font.drawString(ms,
				"\u01F0\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u04AA\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u06BF\uDB4E\uDF3C\uFFFD\uFFFD\u0363\uFFFD\u0267\uFFFD\uFFFD",
				8, 64, -12829636);
		this.font.drawString(ms,
				"\uFFFD\uFFFD\uFFFD\u0130\u0263\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFDGUI\uFFFD\uFFFD\u02B1\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0363\uFFFD\uFFFD\u03F7",
				8, 77, -12829636);
		this.font.drawString(ms,
				"\uFFFD\uFFFD\u023B\uFFFD\u04BA\u0735\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u3FF4GUI\uFFFD\uFFFD\u02B1\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02F0\uFFFD\uFFFD\uFFFD",
				8, 88, -12829636);
		this.font.drawString(ms,
				"\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\uFFFD\uFFFD\u06B5\uFFFDGUI\uFFFD\uFFFD\uFFFD\u077A\uFFFD\uFFFD\u0663\uFFFD\uFFFD\uFFFD\u04AA\uFFFD\u017C\uFFFD",
				8, 101, -12829636);
		this.font.drawString(ms, "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u06BC\u04FC\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD", 8, 115,
				-12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 4, this.guiTop + 140, 40, 20, new StringTextComponent("��һ��"), e -> {
			if (true) {
				XIndustryMod.PACKET_HANDLER.sendToServer(new GuidebookGUIGui.ButtonPressedMessage(0, x, y, z));
				GuidebookGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 62, this.guiTop + 140, 40, 20, new StringTextComponent("�ڶ���"), e -> {
			if (true) {
				XIndustryMod.PACKET_HANDLER.sendToServer(new GuidebookGUIGui.ButtonPressedMessage(1, x, y, z));
				GuidebookGUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 121, this.guiTop + 139, 40, 20, new StringTextComponent("������"), e -> {
			if (true) {
				XIndustryMod.PACKET_HANDLER.sendToServer(new GuidebookGUIGui.ButtonPressedMessage(2, x, y, z));
				GuidebookGUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
