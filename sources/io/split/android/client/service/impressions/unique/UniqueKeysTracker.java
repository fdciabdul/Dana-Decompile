package io.split.android.client.service.impressions.unique;

import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public interface UniqueKeysTracker {
    boolean isFull();

    Map<String, Set<String>> popAll();

    boolean track(String str, String str2);
}
