package com.alipay.plus.push.core;

import android.app.Application;
import com.alipay.plus.push.core.model.PushSource;
import com.alipay.plus.push.core.pushservice.IPushService;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
public class PushServiceInstance {
    private static final String TAG = "PushServiceInstance";
    private static IPushServiceManager iPushServiceManager;

    public static IPushService create(Application application, PushSource pushSource) {
        if (iPushServiceManager == null) {
            InstrumentInjector.log_d(TAG, "PushServiceManager is null");
            iPushServiceManager = new PushServiceManager();
        }
        if (application == null || pushSource == null) {
            return null;
        }
        iPushServiceManager.init(application, pushSource);
        return iPushServiceManager.getPushService();
    }

    public static IPushService getPushService() {
        return iPushServiceManager.getPushService();
    }
}
