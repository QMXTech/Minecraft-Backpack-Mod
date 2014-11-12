package de.eydamos.guiadvanced.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import de.eydamos.backpack.misc.Constants;
import de.eydamos.guiadvanced.util.RenderHelper.BackgroundRepeat;

public class Rectangle {
    protected int width;
    protected int height;
    protected int u = 0;
    protected int v = 0;
    protected int z = 0;
    protected int uMax = 1;
    protected int vMax = 1;
    protected ResourceLocation graphic = Constants.guiCombined;
    protected BackgroundRepeat repeat = BackgroundRepeat.NONE;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    protected Minecraft getMinecraft() {
        return FMLClientHandler.instance().getClient();
    }

    public void setWidth(int value) {
        width = value;
    }

    public void setHeight(int value) {
        height = value;
    }

    public void setBackgroundPosition(int xOffset, int yOffset) {
        u = xOffset;
        v = yOffset;
    }

    public void setBackgroundSize(int sizeX, int sizeY) {
        uMax = sizeX;
        vMax = sizeY;
    }

    public void setBackgroundRepeat(BackgroundRepeat backgroundRepeat) {
        repeat = backgroundRepeat;
    }

    public void setBackground(ResourceLocation resourceLocation) {
        graphic = resourceLocation;
    }

    public void draw(int x, int y) {
        int drawWidth = 0;
        int drawHeight = 0;
        Tessellator tessellator = Tessellator.instance;

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        getMinecraft().getTextureManager().bindTexture(graphic);

        if(repeat == BackgroundRepeat.NONE) {
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(x, (y + height), z, (u / 256.0F), ((v + height) / 256.0F));
            tessellator.addVertexWithUV((x + width), (y + height), z, ((u + width) / 256.0F), ((v + height) / 256.0F));
            tessellator.addVertexWithUV((x + width), y, z, ((u + width) / 256.0F), (v / 256.0F));
            tessellator.addVertexWithUV(x, y, z, (u / 256.0F), (v / 256.0F));
            tessellator.draw();
        } else if(repeat == BackgroundRepeat.REPEAT) {
            drawWidth = Math.min(width, uMax);
            uMax = drawWidth;
            drawHeight = Math.min(height, vMax);
            vMax = drawHeight;

            for(int i = 0; i <= width; i += uMax) {
                for(int j = 0; j <= height; j += vMax) {
                    drawWidth = ((i + uMax) > width) ? width : (i + uMax);
                    drawHeight = ((j + vMax) > height) ? height : (j + vMax);
                    tessellator.startDrawingQuads();
                    tessellator.addVertexWithUV((x + i), (y + drawHeight), z, (u / 256.0F), ((v + vMax) / 256.0F));
                    tessellator.addVertexWithUV((x + drawWidth), (y + drawHeight), z, ((u + uMax) / 256.0F), ((v + vMax) / 256.0F));
                    tessellator.addVertexWithUV((x + drawWidth), y, z, ((u + uMax) / 256.0F), (v / 256.0F));
                    tessellator.addVertexWithUV((x + i), y, z, (u / 256.0F), (v / 256.0F));
                    tessellator.draw();
                }
            }
        } else if(repeat == BackgroundRepeat.REPEAT_X) {
            drawHeight = Math.min(height, vMax);
            vMax = drawHeight;

            for(int i = 0; i <= width; i += uMax) {
                drawWidth = ((i + uMax) > width) ? width : (i + uMax);
                tessellator.startDrawingQuads();
                tessellator.addVertexWithUV((x + i), (y + drawHeight), z, (u / 256.0F), ((v + drawHeight) / 256.0F));
                tessellator.addVertexWithUV((x + drawWidth), (y + drawHeight), z, ((u + uMax) / 256.0F), ((v + drawHeight) / 256.0F));
                tessellator.addVertexWithUV((x + drawWidth), y, z, ((u + uMax) / 256.0F), (v / 256.0F));
                tessellator.addVertexWithUV((x + i), y, z, (u / 256.0F), (v / 256.0F));
                tessellator.draw();
            }
        } else if(repeat == BackgroundRepeat.REPEAT_Y) {
            drawWidth = Math.min(width, uMax);
            uMax = drawWidth;

            for(int i = 0; i <= height; i += vMax) {
                drawHeight = ((i + vMax) > height) ? height : (i + vMax);
                tessellator.startDrawingQuads();
                tessellator.addVertexWithUV(x, (y + drawHeight), z, (u / 256.0F), ((v + vMax) / 256.0F));
                tessellator.addVertexWithUV((x + drawWidth), (y + drawHeight), z, ((u + drawWidth) / 256.0F), ((v + vMax) / 256.0F));
                tessellator.addVertexWithUV((x + drawWidth), (y + i), z, ((u + drawWidth) / 256.0F), (v / 256.0F));
                tessellator.addVertexWithUV(x, (y + i), z, (u / 256.0F), (v / 256.0F));
                tessellator.draw();
            }
        } else {
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(x, (y + height), z, (u / 256.0F), ((v + vMax) / 256.0F));
            tessellator.addVertexWithUV((x + width), (y + height), z, ((u + uMax) / 256.0F), ((v + vMax) / 256.0F));
            tessellator.addVertexWithUV((x + width), y, z, ((u + uMax) / 256.0F), (v / 256.0F));
            tessellator.addVertexWithUV(x, y, z, (u / 256.0F), (v / 256.0F));
            tessellator.draw();
        }
    }
}

