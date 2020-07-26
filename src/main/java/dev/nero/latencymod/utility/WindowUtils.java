package dev.nero.latencymod.utility;

import net.minecraft.client.Minecraft;

public class WindowUtils {

    public static int getWidth() {
        return Minecraft.getInstance().getMainWindow().getWidth();
    }

    public static int getHeight() {
        return Minecraft.getInstance().getMainWindow().getHeight();
    }
}
