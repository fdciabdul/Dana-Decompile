package com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat;

import com.alipay.android.phone.mobilesdk.socketcraft.platform.PlatformUtil;

/* loaded from: classes6.dex */
public class SCLogCatFactory {

    /* renamed from: a  reason: collision with root package name */
    private static SCLogCatInterface f6911a;

    public static void setLogImpl(SCLogCatInterface sCLogCatInterface) {
        f6911a = sCLogCatInterface;
    }

    public static SCLogCatInterface getSCLog() {
        SCLogCatInterface sCLogCatInterface = f6911a;
        if (sCLogCatInterface != null) {
            return sCLogCatInterface;
        }
        synchronized (SCLogCatFactory.class) {
            SCLogCatInterface sCLogCatInterface2 = f6911a;
            if (sCLogCatInterface2 != null) {
                return sCLogCatInterface2;
            }
            if (!PlatformUtil.isAndroidPlatform()) {
                f6911a = PlatformUtil.createJavaLogImpl();
            } else if (PlatformUtil.isAndroidMPaaSPlatform()) {
                f6911a = PlatformUtil.createAndroidMPaaSLogImpl();
            } else {
                f6911a = PlatformUtil.createAndroidLogImpl();
            }
            return f6911a;
        }
    }
}
