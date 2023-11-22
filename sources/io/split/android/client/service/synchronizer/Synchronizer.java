package io.split.android.client.service.synchronizer;

import io.split.android.client.dtos.Event;
import io.split.android.client.impressions.Impression;
import io.split.android.client.lifecycle.SplitLifecycleAware;

/* loaded from: classes6.dex */
public interface Synchronizer extends SplitLifecycleAware {
    void destroy();

    void flush();

    void forceMySegmentsSync();

    void loadAndSynchronizeSplits();

    void loadAttributesFromCache();

    void loadMySegmentsFromCache();

    void loadSplitsFromCache();

    void pushEvent(Event event);

    void pushImpression(Impression impression);

    void startPeriodicFetching();

    void startPeriodicRecording();

    void stopPeriodicFetching();

    void stopPeriodicRecording();

    void synchronizeMySegments();

    void synchronizeSplits();

    void synchronizeSplits(long j);
}
