package com.alipay.iap.android.aplog.core.logger;

import android.text.TextUtils;
import com.alipay.iap.android.aplog.api.Level;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.log.TraceLog;
import com.alipay.iap.android.aplog.util.LoggingUtil;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes.dex */
public class TraceLoggerImpl implements TraceLogger {
    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public boolean isDebuggable() {
        return LoggingUtil.isDebuggable();
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void verbose(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (isDebuggable()) {
            InstrumentInjector.log_v(str, str2);
        }
        if (LoggerFactory.getLogContext() == null) {
            return;
        }
        LoggerFactory.getLogContext().appendLog(new TraceLog(str, Level.VERBOSE, str2, null));
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void verbose(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (isDebuggable()) {
            InstrumentInjector.log_v(str, str2, th);
        }
        if (LoggerFactory.getLogContext() == null) {
            return;
        }
        LoggerFactory.getLogContext().appendLog(new TraceLog(str, Level.VERBOSE, str2, th));
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void debug(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (isDebuggable()) {
            InstrumentInjector.log_d(str, str2);
        }
        if (LoggerFactory.getLogContext() == null) {
            return;
        }
        LoggerFactory.getLogContext().appendLog(new TraceLog(str, Level.DEBUG, str2, null));
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void debug(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (isDebuggable()) {
            InstrumentInjector.log_d(str, str2, th);
        }
        if (LoggerFactory.getLogContext() == null) {
            return;
        }
        LoggerFactory.getLogContext().appendLog(new TraceLog(str, Level.DEBUG, str2, th));
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void info(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (isDebuggable()) {
            InstrumentInjector.log_i(str, str2);
        }
        if (LoggerFactory.getLogContext() == null) {
            return;
        }
        LoggerFactory.getLogContext().appendLog(new TraceLog(str, Level.INFO, str2, null));
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void info(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (isDebuggable()) {
            InstrumentInjector.log_i(str, str2, th);
        }
        if (LoggerFactory.getLogContext() == null) {
            return;
        }
        LoggerFactory.getLogContext().appendLog(new TraceLog(str, Level.INFO, str2, th));
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void warn(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (isDebuggable()) {
            InstrumentInjector.log_w(str, str2);
        }
        if (LoggerFactory.getLogContext() == null) {
            return;
        }
        LoggerFactory.getLogContext().appendLog(new TraceLog(str, Level.WARN, str2, null));
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void warn(String str, Throwable th) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (isDebuggable()) {
            InstrumentInjector.log_w(str, th);
        }
        if (LoggerFactory.getLogContext() == null) {
            return;
        }
        LoggerFactory.getLogContext().appendLog(new TraceLog(str, Level.WARN, LoggingUtil.throwableToString(th), th));
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void warn(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (isDebuggable()) {
            InstrumentInjector.log_w(str, str2, th);
        }
        if (LoggerFactory.getLogContext() == null) {
            return;
        }
        LoggerFactory.getLogContext().appendLog(new TraceLog(str, Level.WARN, str2, th));
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void error(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (isDebuggable()) {
            InstrumentInjector.log_e(str, str2);
        }
        if (LoggerFactory.getLogContext() == null) {
            return;
        }
        LoggerFactory.getLogContext().appendLog(new TraceLog(str, Level.ERROR, str2, null));
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void error(String str, Throwable th) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (isDebuggable()) {
            InstrumentInjector.log_e(str, th.getMessage(), th);
        }
        if (LoggerFactory.getLogContext() == null) {
            return;
        }
        LoggerFactory.getLogContext().appendLog(new TraceLog(str, Level.ERROR, LoggingUtil.throwableToString(th), th));
    }

    @Override // com.alipay.iap.android.aplog.core.logger.TraceLogger
    public void error(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (isDebuggable()) {
            InstrumentInjector.log_e(str, str2, th);
        }
        if (LoggerFactory.getLogContext() == null) {
            return;
        }
        LoggerFactory.getLogContext().appendLog(new TraceLog(str, Level.ERROR, str2, th));
    }
}
