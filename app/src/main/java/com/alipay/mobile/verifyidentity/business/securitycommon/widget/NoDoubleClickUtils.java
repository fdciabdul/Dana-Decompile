package com.alipay.mobile.verifyidentity.business.securitycommon.widget;

/* loaded from: classes7.dex */
public class NoDoubleClickUtils {
    private static final int SPACE_TIME = 1500;
    private static long lastClickTime;

    public static void initLastClickTime() {
        lastClickTime = 0L;
    }

    public static boolean isDoubleClick() {
        boolean z;
        synchronized (NoDoubleClickUtils.class) {
            long currentTimeMillis = System.currentTimeMillis();
            z = currentTimeMillis - lastClickTime <= 1500;
            lastClickTime = currentTimeMillis;
        }
        return z;
    }
}
