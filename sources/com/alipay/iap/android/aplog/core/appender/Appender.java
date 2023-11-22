package com.alipay.iap.android.aplog.core.appender;

import android.content.Context;
import com.alipay.iap.android.aplog.api.LogContext;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import java.io.File;

/* loaded from: classes3.dex */
public abstract class Appender {
    protected static final String TAG = "Appender";
    protected Context appContext;
    protected boolean isAppendBytesError;
    protected boolean isAppendStringError;
    protected boolean isGzipBytesError;
    protected String logCategory;
    protected LogContext logContext;
    protected String processTag = LoggerFactory.getProcessInfo().getProcessTag();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void flush();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract File getFile();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onAppend(String str);

    protected abstract boolean onAppend(String str, boolean z);

    protected abstract boolean onAppend(byte[] bArr, int i, int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean writeFile(String str);

    public Appender(LogContext logContext, String str) {
        this.logContext = logContext;
        this.appContext = logContext.getApplicationContext();
        this.logCategory = str;
        this.appContext = logContext.getApplicationContext();
    }

    public String getLogCategory() {
        return this.logCategory;
    }
}
