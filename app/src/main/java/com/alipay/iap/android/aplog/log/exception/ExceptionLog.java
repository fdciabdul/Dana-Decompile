package com.alipay.iap.android.aplog.log.exception;

import android.text.TextUtils;
import android.util.Log;
import com.alipay.iap.android.aplog.log.BaseLogInfo;

/* loaded from: classes3.dex */
public class ExceptionLog extends BaseLogInfo {
    private Throwable ex;
    private String exceptionType;
    private String logCategory = "exception";
    private String stackTrace;
    private String threadName;

    public ExceptionLog() {
        generateSequenceID();
    }

    public Throwable getEx() {
        return this.ex;
    }

    public void setEx(Throwable th) {
        this.ex = th;
        String stackTraceString = Log.getStackTraceString(th);
        this.stackTrace = stackTraceString;
        if (TextUtils.isEmpty(stackTraceString)) {
            return;
        }
        this.stackTrace = this.stackTrace.replaceAll("\n", "###");
    }

    public String getStackTrace() {
        return this.stackTrace;
    }

    public void setStackTrace(String str) {
        this.stackTrace = str;
    }

    public String getThreadName() {
        return this.threadName;
    }

    public void setThreadName(String str) {
        this.threadName = str;
    }

    public void setExceptionType(String str) {
        this.exceptionType = str;
    }

    public String getExceptionType() {
        return this.exceptionType;
    }

    @Override // com.alipay.iap.android.aplog.log.BaseLogInfo
    public String getLogCategory() {
        return this.logCategory;
    }

    public void setLogCategory(String str) {
        this.logCategory = str;
    }
}
