package com.alibaba.griver.base.common.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes6.dex */
public class NetworkUtils {
    public static final int CODE_LACK_PERMISSION = 0;
    public static final String NETWORK_TYPE_2G = "2G";
    public static final String NETWORK_TYPE_3G = "3G";
    public static final String NETWORK_TYPE_4G = "4G";
    public static final String NETWORK_TYPE_5G = "5G";
    public static final String NETWORK_TYPE_NONE = "NONE";
    public static final String NETWORK_TYPE_UNKNOWN = "UNKNOWN";

    /* loaded from: classes6.dex */
    public interface NetworkDetailCallback {
        void getNetworkError(int i, String str);

        void getNetworkType(String str);
    }

    public static void getDetailNetwork(Context context, NetworkDetailCallback networkDetailCallback) {
        String str;
        try {
            str = NetworkUtil.getDetailNetworkType(context);
        } catch (Exception e) {
            GriverLogger.e(com.iap.ac.android.common.utils.NetworkUtils.TAG, "get detail network exception", e);
            str = "NONE";
        }
        if (AndroidVersionUtils.isQAndAbove()) {
            String str2 = "UNKNOWN";
            if (TextUtils.equals("UNKNOWN", str) || TextUtils.equals("NONE", str)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (ActivityCompat.KClassImpl$Data$declaredNonStaticMembers$2(context, "android.permission.READ_PHONE_STATE") != 0) {
                    networkDetailCallback.getNetworkError(0, "Lack Permission");
                    return;
                }
                int dataNetworkType = telephonyManager.getDataNetworkType();
                if (dataNetworkType != 18) {
                    if (dataNetworkType != 20) {
                        switch (dataNetworkType) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                str2 = "2G";
                                break;
                            case 13:
                                str2 = "4G";
                                break;
                        }
                    } else {
                        str2 = NETWORK_TYPE_5G;
                    }
                    networkDetailCallback.getNetworkType(str2);
                    return;
                }
                str2 = "3G";
                networkDetailCallback.getNetworkType(str2);
                return;
            }
        }
        networkDetailCallback.getNetworkType(str);
    }
}
