package com.iap.ac.android.diagnoselog.api;

import com.iap.ac.android.diagnoselog.core.LogUploadInfo;

/* loaded from: classes3.dex */
public interface OnLogUploadListener {
    void onFinished(boolean z, String str);

    void onProgress(LogUploadInfo logUploadInfo);
}
