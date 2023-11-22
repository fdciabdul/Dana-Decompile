package com.huawei.hms.framework.common;

import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.PowerManager;

/* loaded from: classes7.dex */
public class PowerUtils {

    /* loaded from: classes7.dex */
    public static final class PowerMode {
        static int POWER_MODE_DEFAULT_RETURN_VALUE = 0;
        static int POWER_SAVER_MODE = 4;
        static String SMART_MODE_STATUS = "SmartModeStatus";
    }

    public static boolean isInteractive(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            if (systemService instanceof PowerManager) {
                PowerManager powerManager = (PowerManager) systemService;
                if (Build.VERSION.SDK_INT >= 20) {
                    try {
                        return powerManager.isInteractive();
                    } catch (RuntimeException e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("getActiveNetworkInfo failed, exception:");
                        sb.append(e.getClass().getSimpleName());
                        sb.append(e.getMessage());
                        Logger.i("PowerUtils", sb.toString());
                    }
                }
            }
        }
        return false;
    }

    public static int readPowerSaverMode(Context context) {
        if (context != null) {
            int systemInt = SettingUtil.getSystemInt(context.getContentResolver(), PowerMode.SMART_MODE_STATUS, PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE);
            if (systemInt == PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE) {
                Object systemService = ContextCompat.getSystemService(context, "power");
                PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
                if (powerManager != null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        try {
                            if (powerManager.isPowerSaveMode()) {
                                systemInt = PowerMode.POWER_SAVER_MODE;
                            } else {
                                systemInt = PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE;
                            }
                            return systemInt;
                        } catch (RuntimeException e) {
                            Logger.e("PowerUtils", "dealType rethrowFromSystemServer:", e);
                            return systemInt;
                        }
                    }
                    Logger.i("PowerUtils", "readPowerSaverMode is control by version!");
                    return systemInt;
                }
                return systemInt;
            }
            return systemInt;
        }
        Logger.i("PowerUtils", "readPowerSaverMode Context is null!");
        return 0;
    }

    public static boolean isAppIdleMode(Context context) {
        if (context != null) {
            String packageName = context.getPackageName();
            UsageStatsManager usageStatsManager = null;
            if (Build.VERSION.SDK_INT >= 21) {
                if (Build.VERSION.SDK_INT >= 22) {
                    Object systemService = context.getSystemService("usagestats");
                    if (!(systemService instanceof UsageStatsManager)) {
                        return false;
                    }
                    usageStatsManager = (UsageStatsManager) systemService;
                }
            } else {
                Logger.i("PowerUtils", "isAppIdleMode statsManager is null!");
            }
            if (usageStatsManager != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    return usageStatsManager.isAppInactive(packageName);
                }
                return false;
            }
            Logger.i("PowerUtils", "isAppIdleMode statsManager is null!");
            return false;
        }
        Logger.i("PowerUtils", "isAppIdleMode Context is null!");
        return false;
    }

    public static int readDataSaverMode(Context context) {
        if (context != null) {
            Object systemService = context.getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            if (connectivityManager != null) {
                if (Build.VERSION.SDK_INT < 16 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    return 0;
                }
                if (connectivityManager.isActiveNetworkMetered()) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        return connectivityManager.getRestrictBackgroundStatus();
                    }
                    return 0;
                }
                Logger.v("PowerUtils", "ConnectType is not Mobile Network!");
                return 0;
            }
            Logger.i("PowerUtils", "readDataSaverMode Context is null!");
            return 0;
        }
        Logger.i("PowerUtils", "readDataSaverMode manager is null!");
        return 0;
    }

    public static boolean isWhilteList(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
            String packageName = context.getPackageName();
            if (powerManager != null && Build.VERSION.SDK_INT >= 23) {
                try {
                    return powerManager.isIgnoringBatteryOptimizations(packageName);
                } catch (RuntimeException e) {
                    Logger.e("PowerUtils", "dealType rethrowFromSystemServer:", e);
                }
            }
        }
        return false;
    }

    public static boolean isDozeIdleMode(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
            if (powerManager != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        return powerManager.isDeviceIdleMode();
                    } catch (RuntimeException e) {
                        Logger.e("PowerUtils", "dealType rethrowFromSystemServer:", e);
                        return false;
                    }
                }
                Logger.i("PowerUtils", "isDozeIdleMode is version control state!");
                return false;
            }
            Logger.i("PowerUtils", "isDozeIdleMode powerManager is null!");
            return false;
        }
        Logger.i("PowerUtils", "isDozeIdleMode Context is null!");
        return false;
    }
}
