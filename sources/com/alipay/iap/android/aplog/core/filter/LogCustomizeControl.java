package com.alipay.iap.android.aplog.core.filter;

/* loaded from: classes3.dex */
public interface LogCustomizeControl {
    UploadResultInfo isLogUpload(LogUploadInfo logUploadInfo);

    boolean isLogWrite(LogWriteInfo logWriteInfo);

    boolean shouldQueryStrategy();
}
