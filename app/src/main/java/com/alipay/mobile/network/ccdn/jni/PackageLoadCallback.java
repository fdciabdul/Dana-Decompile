package com.alipay.mobile.network.ccdn.jni;

import com.alipay.mobile.network.ccdn.storage.SizeMeasurable;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public abstract class PackageLoadCallback implements SizeMeasurable {
    public Set<String> getMonitorEntries() {
        return null;
    }

    @Override // com.alipay.mobile.network.ccdn.storage.SizeMeasurable
    public int getSize() {
        return 32;
    }

    public void onComplete(int i, Map<String, String> map) {
    }

    public void onEntryReady(String str) {
    }

    public void onStartDownload() {
    }
}
