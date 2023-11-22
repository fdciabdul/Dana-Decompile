package com.alipay.plus.android.config.sdk.trigger;

import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.plus.android.config.sdk.ConfigCenter;
import com.alipay.plus.android.config.sdk.ConfigCenterContext;
import com.alipay.plus.android.config.sdk.a.e;

/* loaded from: classes7.dex */
public abstract class ConfigUpdateTrigger {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7390a = e.a("ConfigUpdateTrigger");

    public abstract void startTrigger(ConfigCenterContext configCenterContext);

    public void updateConfig() {
        String str = f7390a;
        LoggerWrapper.d(str, "updateConfig with trigger.");
        ConfigCenter configCenter = ConfigCenter.getInstance();
        if (configCenter.isShutdown()) {
            LoggerWrapper.e(str, "ConfigCenter already shutdown. will not trigger update.");
        } else {
            configCenter.refreshConfig();
        }
    }
}
