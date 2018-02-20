package io.github.vanillaextract.core.platforming.platforms;

import io.github.vanillaextract.core.VanillaCore;

public class PlatformConfig {

    public final String generalStaffPermission = VanillaCore.getMainClass().getConfig().getString("platform.config.staff-permission");
    public final String staffLoginMessage = VanillaCore.getMainClass().getConfig().getString("platform.config.staff-login-message").replace("&", "§");
}
