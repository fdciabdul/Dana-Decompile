package com.alibaba.griver.base.api;

import android.content.res.Configuration;

/* loaded from: classes6.dex */
public interface H5UCProvider {
    boolean cannotInitUC();

    boolean enableUCCorePreheadInit();

    String getUCCoreDownloadUrl();

    String getUCSdkVersion();

    String getWebViewCoreSoPath();

    boolean isUcUnzipped();

    boolean notifyConfigurationChanged(Configuration configuration);

    void setUCCoreDownloadUrl(String str);
}
