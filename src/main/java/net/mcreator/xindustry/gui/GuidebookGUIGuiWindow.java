
package net.mcreator.xindustry.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

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
		this.font.drawString(ms, "\u673A\u5668\u4E4B\u4E66", 72, 14, -12829636);
		this.font.drawString(ms, "\u8FD9\u4E2Amod\u8D85\u7EA7\u597D\u73A9", 9, 32, -12829636);
		this.font.drawString(ms, "\u76F8\u4FE1\u6211", 8, 42, -12829636);
		this.font.drawString(ms, "\u6211\u6DFB\u52A0\u4E86\u65B0\u7684\u77FF\u7269", 8, 53, -12829636);
		this.font.drawString(ms, "\u524D\u671F\u6700\u91CD\u8981\u7684\u4E8B\u60C5\u5C31\u662F\u6316\u77FF\uFF0C\u52A0\u6CB9\uFF0C\u9A9A\u5E74", 8,
				64, -12829636);
		this.font.drawString(ms, "\u653E\u5FC3\u5427\uFF0C\u4F60\u6253\u5F00\u8FD9\u4E2AGUI\u7684\u65F6\u5019\u4F1A\u6682\u505C\u6E38\u620F", 8, 77,
				-12829636);
		this.font.drawString(ms, "\u4E0D\u7136\u6211\u5F88\u62C5\u5FC3\u5728\u4F60\u770BGUI\u7684\u65F6\u5019\u9519\u8FC7\u4E86\u767D\u5929", 8, 88,
				-12829636);
		this.font.drawString(ms, "\u4F60\u6216\u8BB8\u8BA4\u4E3A\u73B0\u5728\u7684GUI\u5185\u5BB9\u5F88\u5C11\uFF0C\u4E0D\u8981\u7740\u6025", 8, 101,
				-12829636);
		this.font.drawString(ms, "\u4F5C\u8005\u6B63\u5728\u52A0\u6025\u66F4\u65B0\u4E2D", 8, 115, -12829636);
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
	}
}
