package dev.nero.latencymod.hud;

import dev.nero.latencymod.utility.NetworkUtils;

public class LatencyHud extends HudComponent {
    /**
     * Creates an HudComponent which is basically a block of text at a given position.
     *
     * @param x    horizontal position starting from left
     * @param y    vertical position starting from right
     */
    public LatencyHud(float x, float y) {
        super(x, y, "");
    }

    public void update() {
        this.text = NetworkUtils.getClientLatency() + " ms";
    }
}
