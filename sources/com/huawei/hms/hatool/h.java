package com.huawei.hms.hatool;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: classes8.dex */
public class h {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String getAuthRequestContext(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
            y.moveToNextValue("hmsSdk", "not have network state phone permission!");
            return "";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return "";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        if (activeNetworkInfo.getType() == 0) {
            String subtypeName = activeNetworkInfo.getSubtypeName();
            StringBuilder sb = new StringBuilder();
            sb.append("Network getSubtypeName : ");
            sb.append(subtypeName);
            y.BuiltInFictitiousFunctionClassFactory("hmsSdk", sb.toString());
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    break;
                case 13:
                    return "4G";
                default:
                    if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                        return subtypeName;
                    }
                    break;
            }
            return "3G";
        } else if (activeNetworkInfo.getType() == 16) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("type name = ");
            sb2.append("COMPANION_PROXY");
            y.moveToNextValue("hmsSdk", sb2.toString());
            return "COMPANION_PROXY";
        } else if (activeNetworkInfo.getType() == 9) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("type name = ");
            sb3.append("ETHERNET");
            y.BuiltInFictitiousFunctionClassFactory("hmsSdk", sb3.toString());
            return "ETHERNET";
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("type name = ");
            sb4.append(activeNetworkInfo.getType());
            y.BuiltInFictitiousFunctionClassFactory("hmsSdk", sb4.toString());
            return "OTHER_NETWORK_TYPE";
        }
    }
}
