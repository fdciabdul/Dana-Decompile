package com.alipay.android.phone.mobilesdk.socketcraft.platform.ssl;

import com.alipay.android.phone.mobilesdk.socketcraft.platform.PlatformUtil;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatUtil;

/* loaded from: classes6.dex */
public class SSLExtensionsFactory {

    /* renamed from: a  reason: collision with root package name */
    private static SSLExtensions f6913a;

    public static final SSLExtensions getInstance() {
        SSLExtensions sSLExtensions = f6913a;
        if (sSLExtensions != null) {
            return sSLExtensions;
        }
        synchronized (SSLExtensions.class) {
            if (PlatformUtil.isAndroidMPaaSPlatform()) {
                try {
                    f6913a = (SSLExtensions) Class.forName("com.alipay.android.phone.mobilesdk.socketcraft.integrated.ssl.MPaaSSSLExtensions").newInstance();
                    SCLogCatUtil.info("SSLExtensionsFactory", String.format("New instance ok, class: %s", "com.alipay.android.phone.mobilesdk.socketcraft.integrated.ssl.MPaaSSSLExtensions"));
                } catch (Throwable th) {
                    SCLogCatUtil.warn("SSLExtensionsFactory", String.format("New instance error, class: %s", "com.alipay.android.phone.mobilesdk.socketcraft.integrated.ssl.MPaaSSSLExtensions"), th);
                }
            }
            if (f6913a == null) {
                f6913a = new DefaultSSLExtensions();
            }
        }
        return f6913a;
    }
}
