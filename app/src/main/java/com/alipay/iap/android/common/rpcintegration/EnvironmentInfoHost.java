package com.alipay.iap.android.common.rpcintegration;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.alipaysecuritysdk.apdid.face.APSecuritySdk;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.google.common.base.Ascii;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes3.dex */
public class EnvironmentInfoHost {
    private static final String TAG = "EnvironmentInfoHost";
    private static String appVersion = "";
    private static String cashierSdkVersion = "";
    private static IEnvironmentInfoCollector collectorRef = null;
    private static String sdkVersion = "";
    public static final byte[] PlaceComponentResult = {14, -73, -90, 103, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int MyBillsEntityDataFactory = 241;

    /* loaded from: classes3.dex */
    public interface IEnvironmentInfoCollector {
        EnvironmentInfo getEnvironmentInfo();
    }

    public static void setEnvironmentInfoCollector(IEnvironmentInfoCollector iEnvironmentInfoCollector) {
        if (iEnvironmentInfoCollector != null) {
            collectorRef = iEnvironmentInfoCollector;
        }
    }

    private static EnvironmentInfo getEnvironmentInfoFromCollector() {
        IEnvironmentInfoCollector iEnvironmentInfoCollector = collectorRef;
        if (iEnvironmentInfoCollector == null) {
            LoggerWrapper.e(TAG, "the environment info collector is null.");
            return null;
        }
        return iEnvironmentInfoCollector.getEnvironmentInfo();
    }

    public static EnvironmentInfo getEnvironmentInfo() {
        EnvironmentInfo environmentInfoFromCollector = getEnvironmentInfoFromCollector();
        return environmentInfoFromCollector == null ? new EnvironmentInfo() : environmentInfoFromCollector;
    }

    public static EnvironmentInfo getEnvironmentInfo(Context context) {
        EnvironmentInfo environmentInfoFromCollector = getEnvironmentInfoFromCollector();
        if (environmentInfoFromCollector == null) {
            if (context == null) {
                throw new IllegalArgumentException("the argument 'context' can not be null");
            }
            return getDefaultEnvironmentInfo(context);
        }
        return environmentInfoFromCollector;
    }

    private static EnvironmentInfo getDefaultEnvironmentInfo(Context context) {
        EnvironmentInfo environmentInfo = new EnvironmentInfo();
        Object securitySdk = getSecuritySdk(context);
        if (securitySdk != null) {
            APSecuritySdk.TokenResult tokenResult = ((APSecuritySdk) securitySdk).getTokenResult();
            environmentInfo.clientKey = tokenResult.clientKey;
            environmentInfo.tokenId = tokenResult.apdidToken;
        } else {
            environmentInfo.clientKey = "";
            environmentInfo.tokenId = "";
        }
        environmentInfo.clientIp = "";
        environmentInfo.terminalType = "APP";
        environmentInfo.osType = "android";
        environmentInfo.osVersion = Build.VERSION.RELEASE;
        environmentInfo.appId = "";
        environmentInfo.longitude = "";
        environmentInfo.latitude = "";
        environmentInfo.LBSType = "";
        environmentInfo.LBSUpdateTime = "";
        environmentInfo.locale = getLocale(context);
        environmentInfo.appVersion = getAppVersion(context);
        environmentInfo.cashierSdkVersion = cashierSdkVersion;
        environmentInfo.sdkVersion = sdkVersion;
        environmentInfo.extendInfo = new HashMap();
        return environmentInfo;
    }

    private static String getLocale(Context context) {
        Locale locale = (Build.VERSION.SDK_INT < 24 || LocaleList.getDefault().isEmpty()) ? Locale.getDefault() : LocaleList.getDefault().get(0);
        StringBuilder sb = new StringBuilder();
        sb.append(locale.getLanguage());
        sb.append("-");
        sb.append(locale.getCountry());
        return sb.toString();
    }

    private static String getAppVersion(Context context) {
        if (!TextUtils.isEmpty(appVersion)) {
            return appVersion;
        }
        try {
            appVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            LoggerWrapper.e(TAG, "", e);
        }
        return appVersion;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0044 A[Catch: Exception -> 0x0050, TRY_LEAVE, TryCatch #0 {Exception -> 0x0050, blocks: (B:2:0x0000, B:6:0x0022, B:8:0x002a, B:10:0x0044), top: B:16:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a A[Catch: Exception -> 0x0050, TryCatch #0 {Exception -> 0x0050, blocks: (B:2:0x0000, B:6:0x0022, B:8:0x002a, B:10:0x0044), top: B:16:0x0000 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0046 -> B:12:0x0049). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object getSecuritySdk(android.content.Context r13) {
        /*
            java.lang.String r0 = "com.alipay.alipaysecuritysdk.apdid.face.APSecuritySdk"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Exception -> L50
            r1 = 1
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L50
            byte[] r3 = com.alipay.iap.android.common.rpcintegration.EnvironmentInfoHost.PlaceComponentResult     // Catch: java.lang.Exception -> L50
            r4 = 97
            r5 = 23
            byte[] r6 = new byte[r5]     // Catch: java.lang.Exception -> L50
            r7 = 3
            r8 = 0
            r4 = r3
            if (r3 != 0) goto L1c
            r9 = 3
            r10 = 0
            r11 = 23
            r3 = r2
            goto L49
        L1c:
            r7 = r6
            r6 = 97
            r9 = 3
            r10 = 0
            r3 = r2
        L22:
            int r9 = r9 + r1
            byte r11 = (byte) r6     // Catch: java.lang.Exception -> L50
            r7[r10] = r11     // Catch: java.lang.Exception -> L50
            int r10 = r10 + 1
            if (r10 != r5) goto L44
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Exception -> L50
            r4.<init>(r7, r8)     // Catch: java.lang.Exception -> L50
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.Exception -> L50
            r2[r8] = r4     // Catch: java.lang.Exception -> L50
            java.lang.String r2 = "getInstance"
            java.lang.reflect.Method r2 = r0.getMethod(r2, r3)     // Catch: java.lang.Exception -> L50
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L50
            r1[r8] = r13     // Catch: java.lang.Exception -> L50
            java.lang.Object r13 = r2.invoke(r0, r1)     // Catch: java.lang.Exception -> L50
            return r13
        L44:
            r11 = r4[r9]     // Catch: java.lang.Exception -> L50
            r12 = r7
            r7 = r6
            r6 = r12
        L49:
            int r7 = r7 + r11
            int r7 = r7 + (-8)
            r12 = r7
            r7 = r6
            r6 = r12
            goto L22
        L50:
            r13 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Take it easy, cannot find class APSecuritySdk."
            r0.append(r1)
            java.lang.String r13 = r13.getMessage()
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            java.lang.String r0 = "EnvironmentInfoHost"
            com.alipay.iap.android.common.log.LoggerWrapper.e(r0, r13)
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.common.rpcintegration.EnvironmentInfoHost.getSecuritySdk(android.content.Context):java.lang.Object");
    }
}
