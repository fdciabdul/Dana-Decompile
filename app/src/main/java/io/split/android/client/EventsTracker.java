package io.split.android.client;

import java.util.Map;

/* loaded from: classes6.dex */
public interface EventsTracker {
    void enableTracking(boolean z);

    boolean track(String str, String str2, String str3, double d, Map<String, Object> map, boolean z);
}
