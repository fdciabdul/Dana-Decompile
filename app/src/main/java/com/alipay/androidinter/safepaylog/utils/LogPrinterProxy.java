package com.alipay.androidinter.safepaylog.utils;

import com.alipay.androidinter.safepaylog.api.LogFactory;

/* loaded from: classes6.dex */
public class LogPrinterProxy implements LogFactory.ILogPrinter {
    private LogFactory.ILogPrinter mPrinter;

    public LogPrinterProxy(LogFactory.ILogPrinter iLogPrinter) {
        this.mPrinter = iLogPrinter;
    }

    @Override // com.alipay.androidinter.safepaylog.api.LogFactory.ILogPrinter
    public void print(String str, String str2) {
        LogFactory.ILogPrinter iLogPrinter = this.mPrinter;
        if (iLogPrinter == null) {
            return;
        }
        try {
            iLogPrinter.print(str, str2);
        } catch (Throwable th) {
            LogUtils.printExceptionStackTrace(th);
        }
    }

    @Override // com.alipay.androidinter.safepaylog.api.LogFactory.ILogPrinter
    public void print(Throwable th) {
        LogFactory.ILogPrinter iLogPrinter = this.mPrinter;
        if (iLogPrinter == null) {
            return;
        }
        try {
            iLogPrinter.print(th);
        } catch (Throwable th2) {
            LogUtils.printExceptionStackTrace(th2);
        }
    }
}
