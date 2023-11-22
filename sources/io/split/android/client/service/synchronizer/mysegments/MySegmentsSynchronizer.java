package io.split.android.client.service.synchronizer.mysegments;

/* loaded from: classes6.dex */
public interface MySegmentsSynchronizer {
    void destroy();

    void forceMySegmentsSync();

    void loadMySegmentsFromCache();

    void scheduleSegmentsSyncTask();

    void stopPeriodicFetching();

    void submitMySegmentsLoadingTask();

    void synchronizeMySegments();
}
