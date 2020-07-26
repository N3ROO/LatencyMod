package dev.nero.latencymod.utility;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.play.NetworkPlayerInfo;

public class NetworkUtils {

    /**
     * Uses NetworkPlayerInfo
     *
     * @return the latency of the current player
     */
    public static int getClientLatency() {
        NetworkPlayerInfo playerInfo = NetworkUtils.getPlayerInfo();

        if (playerInfo == null) {
            return -1;
        } else {
            return playerInfo.getResponseTime();
        }
    }

    /**
     * @return true whether or not the client is online.
     */
    public static boolean isClientOnline() {
        //Minecraft.getInstance().getIntegratedServer()
        return getPlayerInfo() != null;
    }

    /**
     * @return NetworkPlayerInfo of the client
     */
    private static NetworkPlayerInfo getPlayerInfo() {
        if (Minecraft.getInstance().player == null)
            return null;
        else
            return Minecraft.getInstance().getConnection().getPlayerInfo(Minecraft.getInstance().player.getUniqueID());
    }
}
