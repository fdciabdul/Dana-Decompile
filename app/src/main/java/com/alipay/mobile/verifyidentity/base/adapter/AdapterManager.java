package com.alipay.mobile.verifyidentity.base.adapter;

import com.alipay.mobile.verifyidentity.adapterapi.IConfig;
import com.alipay.mobile.verifyidentity.base.log.VILog;

/* loaded from: classes3.dex */
public class AdapterManager {
    public static final String TAG = "AdapterManager";
    private static IConfig config;

    public static IConfig getConfig() {
        if (config == null) {
            try {
                Class<?> cls = Class.forName("com.alipay.mobile.verifyidentity.adapter.Config");
                if (cls != null) {
                    config = (IConfig) cls.newInstance();
                }
            } catch (Throwable th) {
                VILog.e(TAG, th);
            }
        }
        return config;
    }
}
