package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class BlockingAnalyticsEventLogger implements AnalyticsEventReceiver, AnalyticsEventLogger {
    static final String APP_EXCEPTION_EVENT_NAME = "_ae";
    private final CrashlyticsOriginAnalyticsEventLogger baseAnalyticsEventLogger;
    private CountDownLatch eventLatch;
    private final TimeUnit timeUnit;
    private final int timeout;
    private final Object latchLock = new Object();
    private boolean callbackReceived = false;

    public BlockingAnalyticsEventLogger(CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger, int i, TimeUnit timeUnit) {
        this.baseAnalyticsEventLogger = crashlyticsOriginAnalyticsEventLogger;
        this.timeout = i;
        this.timeUnit = timeUnit;
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger
    public void logEvent(String str, Bundle bundle) {
        synchronized (this.latchLock) {
            Logger logger = Logger.getLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("Logging event ");
            sb.append(str);
            sb.append(" to Firebase Analytics with params ");
            sb.append(bundle);
            logger.v(sb.toString());
            this.eventLatch = new CountDownLatch(1);
            this.callbackReceived = false;
            this.baseAnalyticsEventLogger.logEvent(str, bundle);
            Logger.getLogger().v("Awaiting app exception callback from Analytics...");
            try {
                if (this.eventLatch.await(this.timeout, this.timeUnit)) {
                    this.callbackReceived = true;
                    Logger.getLogger().v("App exception callback received from Analytics listener.");
                } else {
                    Logger.getLogger().w("Timeout exceeded while awaiting app exception callback from Analytics listener.");
                }
            } catch (InterruptedException unused) {
                Logger.getLogger().e("Interrupted while awaiting app exception callback from Analytics listener.");
            }
            this.eventLatch = null;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver
    public void onEvent(String str, Bundle bundle) {
        CountDownLatch countDownLatch = this.eventLatch;
        if (countDownLatch != null && APP_EXCEPTION_EVENT_NAME.equals(str)) {
            countDownLatch.countDown();
        }
    }

    boolean isCallbackReceived() {
        return this.callbackReceived;
    }
}
