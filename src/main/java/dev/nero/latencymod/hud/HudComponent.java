package dev.nero.latencymod.hud;

import com.mojang.blaze3d.matrix.MatrixStack;
import dev.nero.latencymod.utility.WindowUtils;
import net.minecraft.client.Minecraft;

public class HudComponent {

    private float x;
    private float y;
    protected String text;

    /**
     * Creates an HudComponent which is basically a block of text at a given position.
     * @param x horizontal position starting from left
     * @param y vertical position starting from right
     * @param text the text to write
     */
    public HudComponent(float x, float y, String text) {
        this.x = x;
        this.y = y;
        this.text = text;
    }

    /**
     * Renders the component (writes the text at the given position)
     */
    public void render() {
        Minecraft.getInstance().fontRenderer.func_238405_a_(new MatrixStack(), text, x, y, 0);
    }

    /**
     * @return the text width by taking into account the font size
     */
    private int getTextWidth() {
        return Minecraft.getInstance().fontRenderer.getStringWidth(this.text);
    }

    /**
     * @return the text height by taking into account the font size
     */
    private int getTextHeight() {
        return Minecraft.getInstance().fontRenderer.FONT_HEIGHT;
    }

    /**
     * Sets x position of the HUD component (prevents going out of screen)
     * @param x horizontal position starting from the left
     */
    public void setX(float x) {
        if (x < 0) x = 0;
        else if (x > WindowUtils.getWidth()) x = WindowUtils.getWidth() - getTextWidth();

        this.x = x;
    }

    /**
     * Sets y position of the HUD component (prevents going out of screen)
     * @param y vertical position starting from the top
     */
    public void setY(float y) {
        if (y < 0) y = 0;
        else if (y > WindowUtils.getHeight()) y = WindowUtils.getHeight() - getTextHeight();

        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return this.y;
    }
}
