package com.alipay.iap.android.aplog.log.crash;

import android.text.TextUtils;
import android.util.Log;
import com.alipay.iap.android.aplog.log.BaseLogInfo;

/* loaded from: classes6.dex */
public class CrashLog extends BaseLogInfo {
    private Throwable ex;
    private String stackTrace;
    private String threadName;
    private String logCategory = "crash";
    private ExceptionID exceptionID = ExceptionID.MONITORPOINT_CRASH;
    private boolean isJavaCrash = true;

    public CrashLog() {
        generateSequenceID();
    }

    public Throwable getEx() {
        return this.ex;
    }

    public CrashLog setEx(Throwable th) {
        this.ex = th;
        String stackTraceString = Log.getStackTraceString(th);
        this.stackTrace = stackTraceString;
        if (!TextUtils.isEmpty(stackTraceString)) {
            this.stackTrace = this.stackTrace.replaceAll("\n", "###");
        }
        return this;
    }

    @Override // com.alipay.iap.android.aplog.log.BaseLogInfo
    public String getLogCategory() {
        return this.logCategory;
    }

    public CrashLog setLogCategory(String str) {
        this.logCategory = str;
        return this;
    }

    public String getThreadName() {
        return this.threadName;
    }

    public CrashLog setThreadName(String str) {
        this.threadName = str;
        return this;
    }

    public boolean isJavaCrash() {
        return this.isJavaCrash;
    }

    public CrashLog setJavaCrash(boolean z) {
        this.isJavaCrash = z;
        return this;
    }

    public ExceptionID getExceptionID() {
        return this.exceptionID;
    }

    public CrashLog setExceptionID(ExceptionID exceptionID) {
        this.exceptionID = exceptionID;
        return this;
    }

    public String getStackTrace() {
        return this.stackTrace;
    }

    public CrashLog setStackTrace(String str) {
        this.stackTrace = str;
        return this;
    }
}
