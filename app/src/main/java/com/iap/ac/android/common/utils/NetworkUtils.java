package com.iap.ac.android.common.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.iap.ac.android.common.log.ACLog;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class NetworkUtils {
    public static final int NETWORK_TYPE_2G = 1;
    public static final String NETWORK_TYPE_2G_STR = "2g";
    public static final int NETWORK_TYPE_3G = 2;
    public static final String NETWORK_TYPE_3G_STR = "3g";
    public static final int NETWORK_TYPE_4G = 4;
    public static final String NETWORK_TYPE_4G_STR = "4g";
    public static final int NETWORK_TYPE_EHRPD = 14;
    public static final int NETWORK_TYPE_HSPAP = 15;
    public static final int NETWORK_TYPE_INVALID = 0;
    public static final int NETWORK_TYPE_LTE = 13;
    public static final int NETWORK_TYPE_OFFLINE = 0;
    public static final String NETWORK_TYPE_OFFLINE_STR = "offline";
    public static final int NETWORK_TYPE_UNKOWN = -1;
    public static final String NETWORK_TYPE_UNKOWN_PREFIX_STR = "android-";
    public static final String NETWORK_TYPE_UNKOWN_STR = "unknown";
    public static final int NETWORK_TYPE_WIFI = 3;
    public static final String NETWORK_TYPE_WIFI_STR = "wifi";
    public static final String TAG = "NetworkUtils";
    public static final Set<NetworkStateListener> mNetworkStateListeners = new LinkedHashSet();
    public static int mCurrentNetworkType = 0;
    public static final BroadcastReceiver mNetworkBroadcastReceiver = new BroadcastReceiver() { // from class: com.iap.ac.android.common.utils.NetworkUtils.1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            int i = NetworkUtils.mCurrentNetworkType;
            int unused = NetworkUtils.mCurrentNetworkType = NetworkUtils.getNetworkType(context);
            ACLog.i(NetworkUtils.TAG, String.format("NetworkUtils onReceive! network changed: %s -> %s.", NetworkUtils.getNetworkTypeDesc(i), NetworkUtils.getNetworkTypeDesc(NetworkUtils.mCurrentNetworkType)));
            if (i != NetworkUtils.mCurrentNetworkType) {
                synchronized (NetworkUtils.mNetworkStateListeners) {
                    for (NetworkStateListener networkStateListener : new LinkedHashSet(NetworkUtils.mNetworkStateListeners)) {
                        if (networkStateListener != null) {
                            networkStateListener.onNetworkChanged(i, NetworkUtils.mCurrentNetworkType);
                        }
                    }
                }
                return;
            }
            ACLog.i(NetworkUtils.TAG, "Network type not changed, will not notify listeners");
        }
    };

    /* loaded from: classes3.dex */
    public interface NetworkStateListener {
        void onNetworkChanged(int i, int i2);
    }

    /* loaded from: classes8.dex */
    public static abstract class NetworkSwitchListener implements NetworkStateListener {
        public abstract void onInvalid2Mobile();

        public abstract void onInvalid2Wifi();

        public abstract void onMobile2Invalid();

        public abstract void onMobile2Wifi();

        @Override // com.iap.ac.android.common.utils.NetworkUtils.NetworkStateListener
        public final void onNetworkChanged(int i, int i2) {
            if (i == 0) {
                if (NetworkUtils.isMobileNetwork(i2)) {
                    onInvalid2Mobile();
                } else if (NetworkUtils.isWiFiMobileNetwork(i2)) {
                    onInvalid2Wifi();
                }
            } else if (NetworkUtils.isMobileNetwork(i)) {
                if (i2 == 0) {
                    onMobile2Invalid();
                } else if (NetworkUtils.isWiFiMobileNetwork(i2)) {
                    onMobile2Wifi();
                }
            } else if (NetworkUtils.isWiFiMobileNetwork(i)) {
                if (i2 == 0) {
                    onWifi2Invalid();
                } else if (NetworkUtils.isMobileNetwork(i2)) {
                    onWifi2Mobile();
                }
            }
        }

        public abstract void onWifi2Invalid();

        public abstract void onWifi2Mobile();
    }

    public static void addNetworkStateListener(Context context, NetworkStateListener networkStateListener) {
        Set<NetworkStateListener> set = mNetworkStateListeners;
        synchronized (set) {
            if (set.isEmpty()) {
                initializeNetworkStateListener(context);
            }
            set.add(networkStateListener);
        }
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static int getMobileNetworkClass(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 2;
            case 13:
                return 4;
            default:
                return 0;
        }
    }

    public static int getMobileNetworkClass(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return 0;
        }
        return getMobileNetworkClass(networkInfo.getSubtype());
    }

    public static int getMobileNetworkClassWithUnknown(int i) {
        int mobileNetworkClass = getMobileNetworkClass(i);
        return mobileNetworkClass != 0 ? mobileNetworkClass : i;
    }

    public static int getNetType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    public static int getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return 0;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return 3;
        }
        if (type == 0) {
            return getMobileNetworkClass(activeNetworkInfo);
        }
        return 0;
    }

    public static String getNetworkTypeDesc(int i) {
        return isMobileNetwork(i) ? "Mobile (2G/3G/4G/...)" : isWiFiMobileNetwork(i) ? "WiFi" : "Invalid";
    }

    public static int getNetworkTypeInt(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    return 3;
                }
                if (type == 0) {
                    return getMobileNetworkClassWithUnknown(activeNetworkInfo.getSubtype());
                }
                return -1;
            }
            return 0;
        }
        return -1;
    }

    public static String getNetworkTypeString(Context context) {
        int networkTypeInt = getNetworkTypeInt(context);
        if (networkTypeInt != -1) {
            if (networkTypeInt != 0) {
                if (networkTypeInt != 1) {
                    if (networkTypeInt != 2) {
                        if (networkTypeInt != 3) {
                            if (networkTypeInt != 4) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("android-");
                                sb.append(networkTypeInt);
                                return sb.toString();
                            }
                            return "4g";
                        }
                        return "wifi";
                    }
                    return "3g";
                }
                return "2g";
            }
            return "offline";
        }
        return "unknown";
    }

    public static void initializeNetworkStateListener(Context context) {
        mCurrentNetworkType = getNetworkType(context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(mNetworkBroadcastReceiver, intentFilter);
    }

    public static boolean is2GMobileNetwork(Context context) {
        return context != null && getNetworkType(context) == 1;
    }

    public static boolean is3GMobileNetwork(Context context) {
        return context != null && getNetworkType(context) == 2;
    }

    public static boolean is4GMobileNetwork(NetworkInfo networkInfo) {
        return networkInfo != null && getMobileNetworkClass(networkInfo) == 4;
    }

    public static boolean isMobileNetwork(int i) {
        return i == 1 || i == 2 || i == 4;
    }

    public static boolean isNetworkAvailable(Context context) {
        try {
            NetworkInfo[] allNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo();
            if (allNetworkInfo == null) {
                ACLog.d(TAG, "can not get network info");
                return false;
            }
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnectedOrConnecting()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            ACLog.e(TAG, "", e);
            return false;
        }
    }

    public static boolean isWiFiMobileNetwork(int i) {
        return i == 3;
    }

    public static boolean isWiFiMobileNetwork(Context context) {
        return context != null && getNetworkType(context) == 3;
    }

    public static void removeNetworkStateListener(Context context, NetworkStateListener networkStateListener) {
        Set<NetworkStateListener> set = mNetworkStateListeners;
        synchronized (set) {
            if (set.isEmpty()) {
                return;
            }
            set.remove(networkStateListener);
            if (set.isEmpty()) {
                ACLog.d(TAG, "Network listeners is empty. will unregister receiver!");
                try {
                    context.unregisterReceiver(mNetworkBroadcastReceiver);
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("removeNetworkStateListener error: ");
                    sb.append(th.getMessage());
                    ACLog.e(TAG, sb.toString());
                }
            }
        }
    }

    public static boolean is3GMobileNetwork(NetworkInfo networkInfo) {
        return networkInfo != null && getMobileNetworkClass(networkInfo) == 2;
    }

    public static boolean is4GMobileNetwork(Context context) {
        return context != null && getNetworkType(context) == 4;
    }
}
