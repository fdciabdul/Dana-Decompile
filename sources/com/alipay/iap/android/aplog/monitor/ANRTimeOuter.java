package com.alipay.iap.android.aplog.monitor;

import com.alipay.iap.android.aplog.core.LoggerFactory;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;

/* loaded from: classes6.dex */
public class ANRTimeOuter extends TimeOuter {
    private ANRMonitor c;

    public ANRTimeOuter(ANRMonitor aNRMonitor, long j) {
        super(j);
        this.c = aNRMonitor;
    }

    @Override // com.alipay.iap.android.aplog.monitor.TimeOuter
    void a() {
        LoggerFactory.getTraceLogger().info("ANRMonitor", TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT);
        ANRMonitor aNRMonitor = this.c;
        if (aNRMonitor != null) {
            aNRMonitor.c(this.b, System.currentTimeMillis());
        }
    }
}
