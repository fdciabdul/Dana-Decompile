package io.split.android.client.service.synchronizer.mysegments;

/* loaded from: classes6.dex */
public interface MySegmentsSynchronizerRegistry {
    void registerMySegmentsSynchronizer(String str, MySegmentsSynchronizer mySegmentsSynchronizer);

    void unregisterMySegmentsSynchronizer(String str);
}
