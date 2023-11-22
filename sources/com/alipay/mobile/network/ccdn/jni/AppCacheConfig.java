package com.alipay.mobile.network.ccdn.jni;

import id.dana.domain.featureconfig.model.UgcConfig;

/* loaded from: classes6.dex */
public class AppCacheConfig {
    public String apps;
    public String cacheDir;
    public String ipcSockId;
    public String xapps;
    public int volume = 134217728;
    public int maxEntries = 256;
    public int maxMemEntries = 64;
    public int maxMemSize = 33554432;
    public int cleanupInterval = UgcConfig.DEFAULT_UGC_INTERVAL;
    public int indexPersistDelay = 5000;
    public int indexStaledDays = 60;
    public int memPkgResizeDelay = 30000;
    public int memPkgPersistDelay = 3000;
    public int fallbackThreshold = 3;
    public int fallbackWindow = 259200;
    public boolean fallbackEnable = false;
    public boolean enableSubProcess = false;
    public boolean preferChunkPackage = false;
    public boolean enableAntKV = false;
    public boolean checkSwitchOnLoad = true;
    public boolean enableAllTinyApp = false;
    public boolean enableAllPlugin = false;
    public boolean enableAllH5App = false;
    public int indexVersion = 0;
    public boolean indexClearOnBroken = false;
    public boolean mdbUseSpecDir = false;
    public int metaVersion = 0;
    public boolean checkCrcOnWrite = true;
}
