package com.iap.ac.android.mpm.interceptor.provider;

import android.text.TextUtils;
import com.iap.ac.android.common.container.provider.ContainerUaProvider;
import com.iap.ac.android.mpm.base.model.route.ACDecodeConfig;

/* loaded from: classes3.dex */
public class UAProvider implements ContainerUaProvider {
    public static final String AC_SDK_UA = "iapconnectsdk/2.37.0";
    public static final String AC_UA = "AlipayConnect";
    private static String mockUA = null;
    private static String pspUA = "";
    private static String userAgent;

    private static void makeUserAgent() {
        if (TextUtils.isEmpty(userAgent) || !userAgent.contains(pspUA)) {
            String str = pspUA;
            userAgent = str;
            if (!TextUtils.isEmpty(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(userAgent);
                sb.append(" ");
                userAgent = sb.toString();
            }
            if (!pspUA.contains("AlipayConnect")) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(userAgent);
                sb2.append("AlipayConnect");
                userAgent = sb2.toString();
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(userAgent);
            sb3.append(" iapconnectsdk/2.37.0");
            userAgent = sb3.toString();
        }
    }

    public static void setPspUA(String str) {
        if (TextUtils.isEmpty(str)) {
            pspUA = "";
        } else {
            pspUA = str;
        }
        makeUserAgent();
    }

    public static void enableUserAgent(boolean z) {
        if (z) {
            makeUserAgent();
            return;
        }
        userAgent = null;
        mockUA = null;
    }

    public static void mockUserAgent(ACDecodeConfig aCDecodeConfig) {
        if (aCDecodeConfig == null || TextUtils.isEmpty(aCDecodeConfig.userAgent)) {
            mockUA = "";
        } else {
            mockUA = aCDecodeConfig.userAgent;
        }
        makeUserAgent();
    }

    @Override // com.iap.ac.android.common.container.provider.ContainerUaProvider
    public String getUa(String str) {
        if (!TextUtils.isEmpty(mockUA)) {
            return TextUtils.isEmpty(str) ? String.format("%s %s", userAgent, mockUA) : str.contains(pspUA) ? String.format("%s %s %s %s", str, "AlipayConnect", AC_SDK_UA, mockUA) : String.format("%s %s %s", str, userAgent, mockUA);
        } else if (!TextUtils.isEmpty(str)) {
            return (TextUtils.isEmpty(userAgent) || str.contains(userAgent)) ? str : str.contains(pspUA) ? String.format("%s %s %s", str, "AlipayConnect", AC_SDK_UA) : String.format("%s %s", str, userAgent);
        } else {
            String str2 = userAgent;
            return str2 == null ? "" : str2;
        }
    }
}
