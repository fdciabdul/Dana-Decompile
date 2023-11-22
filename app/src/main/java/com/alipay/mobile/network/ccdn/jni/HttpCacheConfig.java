package com.alipay.mobile.network.ccdn.jni;

import id.dana.domain.featureconfig.model.UgcConfig;

/* loaded from: classes6.dex */
public class HttpCacheConfig {
    public String cacheDir;
    public String ipcSockId;
    public int volume = 134217728;
    public int maxEntries = 8192;
    public int maxMemEntries = 512;
    public int maxMemSize = 33554432;
    public int maxMemAge = 120000;
    public int cleanupInterval = UgcConfig.DEFAULT_UGC_INTERVAL;
    public int indexPersistDelay = 5000;
    public int indexStaledDays = 60;
    public boolean enableSubProcess = false;
    public boolean enableAntKV = false;
    public int indexVersion = 0;
    public boolean indexClearOnBroken = false;
    public boolean mdbUseSpecDir = false;
    public boolean checkCrcOnWrite = true;
}
