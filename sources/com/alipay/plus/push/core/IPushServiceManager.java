package com.alipay.plus.push.core;

import android.app.Application;
import com.alipay.plus.push.core.model.PushSource;
import com.alipay.plus.push.core.pushservice.IPushService;

/* loaded from: classes3.dex */
public interface IPushServiceManager {
    IPushService getPushService();

    void init(Application application, PushSource pushSource);
}
