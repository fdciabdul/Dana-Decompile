package com.alibaba.ariver.resource.api.prepare;

import com.alibaba.ariver.kernel.RVParams;

/* loaded from: classes3.dex */
public enum OfflineMode {
    SYNC_FORCE(2),
    SYNC_TRY(1),
    ASYNC(0);

    public int value;

    OfflineMode(int i) {
        this.value = i;
    }

    public static OfflineMode fromString(String str, String str2) {
        if ("sync".equals(str)) {
            if (RVParams.DEFAULT_LONG_UP_STRATEGY.equals(str2)) {
                return SYNC_TRY;
            }
            return SYNC_FORCE;
        }
        return ASYNC;
    }

    public final boolean isSync() {
        return this.value > 0;
    }
}
