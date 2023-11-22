package com.alibaba.griver.api.file;

import android.app.Activity;
import com.alibaba.griver.api.common.GriverExtension;
import com.alibaba.griver.api.common.network.DownloadCallback;

/* loaded from: classes6.dex */
public interface GriverFileExtension extends GriverExtension {
    void downloadFile(String str, String str2, String str3, String str4, long j, DownloadCallback downloadCallback);

    String downloadPath();

    void openDocument(Activity activity, String str);
}
