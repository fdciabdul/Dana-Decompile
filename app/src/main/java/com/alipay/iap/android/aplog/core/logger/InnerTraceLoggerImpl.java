package com.alipay.iap.android.aplog.core.logger;

import android.text.TextUtils;
import com.alipay.iap.android.aplog.util.LoggingUtil;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes.dex */
public class InnerTraceLoggerImpl implements TraceLogger {
    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public boolean isDebuggable() {
        return LoggingUtil.isDebuggable();
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void verbose(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !isDebuggable()) {
            return;
        }
        InstrumentInjector.log_v(str, str2);
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void verbose(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !isDebuggable()) {
            return;
        }
        InstrumentInjector.log_v(str, str2, th);
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void debug(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !isDebuggable()) {
            return;
        }
        InstrumentInjector.log_d(str, str2);
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void debug(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !isDebuggable()) {
            return;
        }
        InstrumentInjector.log_d(str, str2, th);
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void info(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !isDebuggable()) {
            return;
        }
        InstrumentInjector.log_i(str, str2);
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void info(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !isDebuggable()) {
            return;
        }
        InstrumentInjector.log_i(str, str2, th);
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void warn(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !isDebuggable()) {
            return;
        }
        InstrumentInjector.log_w(str, str2);
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void warn(String str, Throwable th) {
        if (!TextUtils.isEmpty(str) && isDebuggable()) {
            InstrumentInjector.log_w(str, th);
        }
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void warn(String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str) && isDebuggable()) {
            InstrumentInjector.log_w(str, str2, th);
        }
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void error(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !isDebuggable()) {
            return;
        }
        InstrumentInjector.log_e(str, str2);
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void error(String str, Throwable th) {
        if (!TextUtils.isEmpty(str) && isDebuggable()) {
            InstrumentInjector.log_e(str, th.getMessage(), th);
        }
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void error(String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str) && isDebuggable()) {
            InstrumentInjector.log_e(str, str2, th);
        }
    }
}
