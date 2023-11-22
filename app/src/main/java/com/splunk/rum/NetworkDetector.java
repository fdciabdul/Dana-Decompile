package com.splunk.rum;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.telephony.TelephonyManager;

/* loaded from: classes3.dex */
interface NetworkDetector {
    CurrentNetwork BuiltInFictitiousFunctionClassFactory();

    /* renamed from: com.splunk.rum.NetworkDetector$-CC  reason: invalid class name */
    /* loaded from: classes3.dex */
    public final /* synthetic */ class CC {
        public static NetworkDetector PlaceComponentResult(Context context) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (Build.VERSION.SDK_INT >= 29) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                return new PostApi28NetworkDetector(connectivityManager, telephonyManager, new CarrierFinder(telephonyManager), context);
            }
            return new SimpleNetworkDetector(connectivityManager);
        }
    }
}
