package com.alipay.iap.android.aplog.util;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import java.util.TimerTask;

/* loaded from: classes3.dex */
public abstract class APMTimerJob extends TimerTask {
    private String mName = getClass().getSimpleName();

    protected abstract void doJob();

    public void setName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mName = str;
    }

    public String getName() {
        return this.mName;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            doJob();
        } finally {
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            if (uptimeMillis2 > RangedBeacon.DEFAULT_MAX_TRACKING_AGE) {
                TraceLogger traceLogger = LoggerFactory.getTraceLogger();
                String name = getName();
                StringBuilder sb = new StringBuilder();
                sb.append("doJob: spend ");
                sb.append(uptimeMillis2);
                traceLogger.error(name, sb.toString());
            }
        }
    }
}
