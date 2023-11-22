package com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool;

import com.alipay.android.phone.mobilesdk.socketcraft.platform.PlatformUtil;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatUtil;

/* loaded from: classes6.dex */
public class SCNetworkAsyncTaskExecutorFactory {

    /* renamed from: a  reason: collision with root package name */
    private static SCNetworkAsyncTaskExecutor f6915a;

    public static final SCNetworkAsyncTaskExecutor getInstance() {
        SCNetworkAsyncTaskExecutor sCNetworkAsyncTaskExecutor = f6915a;
        if (sCNetworkAsyncTaskExecutor != null) {
            return sCNetworkAsyncTaskExecutor;
        }
        synchronized (SCNetworkAsyncTaskExecutorFactory.class) {
            SCNetworkAsyncTaskExecutor sCNetworkAsyncTaskExecutor2 = f6915a;
            if (sCNetworkAsyncTaskExecutor2 != null) {
                return sCNetworkAsyncTaskExecutor2;
            }
            if (PlatformUtil.isAndroidMPaaSPlatform()) {
                try {
                    SCNetworkAsyncTaskExecutor sCNetworkAsyncTaskExecutor3 = (SCNetworkAsyncTaskExecutor) Class.forName("com.alipay.android.phone.mobilesdk.socketcraft.integrated.threadpool.MPaaSNetworkAsyncTaskExecutor").newInstance();
                    f6915a = sCNetworkAsyncTaskExecutor3;
                    return sCNetworkAsyncTaskExecutor3;
                } catch (Throwable th) {
                    SCLogCatUtil.error("SCNetworkAsyncTaskExecutorFactory", String.format("Instance class: %s error", "com.alipay.android.phone.mobilesdk.socketcraft.integrated.threadpool.MPaaSNetworkAsyncTaskExecutor"), th);
                }
            }
            if (f6915a == null) {
                f6915a = new DefaultSCNetworkAsyncTaskExecutor();
            }
            return f6915a;
        }
    }
}
