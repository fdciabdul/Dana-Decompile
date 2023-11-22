package com.alipay.iap.android.aplog.monitor;

import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.monitor.tools.HandlerThreadFactory;
import id.dana.myprofile.SettingMoreProfileActivity;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;

/* loaded from: classes6.dex */
public class LagTimeOuter extends TimeOuter {
    private ANRMonitor c;

    public LagTimeOuter(ANRMonitor aNRMonitor, long j) {
        super(j);
        this.c = aNRMonitor;
    }

    @Override // com.alipay.iap.android.aplog.monitor.TimeOuter
    void a() {
        LoggerFactory.getTraceLogger().info("ANRMonitor", TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT);
        final long j = this.b;
        final long currentTimeMillis = System.currentTimeMillis();
        this.c.b(j, currentTimeMillis);
        if (this.c != null) {
            HandlerThreadFactory.a().postDelayed(new Runnable() { // from class: com.alipay.iap.android.aplog.monitor.LagTimeOuter.1
                @Override // java.lang.Runnable
                public void run() {
                    LagTimeOuter.this.c.c(j, currentTimeMillis);
                }
            }, SettingMoreProfileActivity.TOAST_DURATION);
        }
    }
}
