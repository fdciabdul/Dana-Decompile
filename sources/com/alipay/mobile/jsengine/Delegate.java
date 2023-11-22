package com.alipay.mobile.jsengine;

import android.content.Context;
import android.text.TextUtils;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public abstract class Delegate {
    public abstract String getConfig(String str, String str2);

    public abstract Context getContext();

    public String getDiskInfo() {
        return "-";
    }

    public abstract String getWebViewCoreSoPath();

    public boolean isDebug() {
        return false;
    }

    public abstract void log(LogData logData);

    public abstract void releaseProcessLock(Object obj);

    public abstract Object takeProcessLock(String str);

    public abstract void unzipWebViewCoreSo();

    public void d(String str, String str2) {
        InstrumentInjector.log_d(str, str2);
    }

    public void w(String str, String str2) {
        InstrumentInjector.log_w(str, str2);
    }

    public void e(String str, String str2) {
        InstrumentInjector.log_e(str, str2);
    }

    public void e(String str, String str2, Throwable th) {
        InstrumentInjector.log_e(str, str2, th);
    }

    public int getConfig(String str, int i) {
        try {
            String config = getConfig(str, "");
            if (!TextUtils.isEmpty(config)) {
                return Integer.valueOf(config.trim()).intValue();
            }
        } catch (Throwable unused) {
        }
        return i;
    }
}
