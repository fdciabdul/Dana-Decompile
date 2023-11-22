package com.alipay.mobile.common.logging.impl;

import android.text.TextUtils;
import com.alipay.mobile.common.logging.SyncLogUtil;
import com.alipay.mobile.common.logging.api.trace.TraceLogger;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
public class TraceLoggerImpl implements TraceLogger {
    @Override // com.alipay.mobile.common.logging.api.trace.TraceLogger
    public void verbose(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !SyncLogUtil.isDebuggable()) {
            return;
        }
        InstrumentInjector.log_v(str, str2);
    }

    @Override // com.alipay.mobile.common.logging.api.trace.TraceLogger
    public void debug(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !SyncLogUtil.isDebuggable()) {
            return;
        }
        InstrumentInjector.log_d(str, str2);
    }

    @Override // com.alipay.mobile.common.logging.api.trace.TraceLogger
    public void info(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !SyncLogUtil.isDebuggable()) {
            return;
        }
        InstrumentInjector.log_i(str, str2);
    }

    @Override // com.alipay.mobile.common.logging.api.trace.TraceLogger
    public void warn(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !SyncLogUtil.isDebuggable()) {
            return;
        }
        InstrumentInjector.log_w(str, str2);
    }

    @Override // com.alipay.mobile.common.logging.api.trace.TraceLogger
    public void warn(String str, Throwable th) {
        if (TextUtils.isEmpty(str) || th == null || !SyncLogUtil.isDebuggable()) {
            return;
        }
        InstrumentInjector.log_w(str, th.getMessage());
    }

    @Override // com.alipay.mobile.common.logging.api.trace.TraceLogger
    public void warn(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !SyncLogUtil.isDebuggable()) {
            return;
        }
        InstrumentInjector.log_w(str, str2);
    }

    @Override // com.alipay.mobile.common.logging.api.trace.TraceLogger
    public void error(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !SyncLogUtil.isDebuggable()) {
            return;
        }
        InstrumentInjector.log_e(str, str2);
    }

    @Override // com.alipay.mobile.common.logging.api.trace.TraceLogger
    public void error(String str, Throwable th) {
        if (!TextUtils.isEmpty(str) && SyncLogUtil.isDebuggable()) {
            InstrumentInjector.log_e(str, th.getMessage());
        }
    }

    @Override // com.alipay.mobile.common.logging.api.trace.TraceLogger
    public void error(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !SyncLogUtil.isDebuggable()) {
            return;
        }
        InstrumentInjector.log_e(str, str2);
    }

    @Override // com.alipay.mobile.common.logging.api.trace.TraceLogger
    public void print(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null || !SyncLogUtil.isDebuggable()) {
            return;
        }
        InstrumentInjector.log_v(str, str2);
    }

    @Override // com.alipay.mobile.common.logging.api.trace.TraceLogger
    public void print(String str, Throwable th) {
        if (TextUtils.isEmpty(str) || th == null || !SyncLogUtil.isDebuggable()) {
            return;
        }
        InstrumentInjector.log_v(str, th.getMessage());
    }
}
