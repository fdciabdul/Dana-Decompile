package io.split.android.client.service.synchronizer.mysegments;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class MySegmentsSynchronizerRegistryImpl implements MySegmentsSynchronizerRegistry, MySegmentsSynchronizer {
    private final AtomicBoolean mLoadedFromCache = new AtomicBoolean(false);
    private final AtomicBoolean mSynchronizedSegments = new AtomicBoolean(false);
    private final AtomicBoolean mScheduledSegmentsSyncTask = new AtomicBoolean(false);
    private final AtomicBoolean mStoppedPeriodicFetching = new AtomicBoolean(false);
    private final ConcurrentMap<String, MySegmentsSynchronizer> mMySegmentsSynchronizers = new ConcurrentHashMap();

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistry
    public void registerMySegmentsSynchronizer(String str, MySegmentsSynchronizer mySegmentsSynchronizer) {
        synchronized (this) {
            this.mMySegmentsSynchronizers.put(str, mySegmentsSynchronizer);
            if (this.mLoadedFromCache.get()) {
                mySegmentsSynchronizer.loadMySegmentsFromCache();
            }
            if (this.mSynchronizedSegments.get()) {
                mySegmentsSynchronizer.synchronizeMySegments();
            }
            if (this.mScheduledSegmentsSyncTask.get()) {
                mySegmentsSynchronizer.scheduleSegmentsSyncTask();
            }
        }
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistry
    public void unregisterMySegmentsSynchronizer(String str) {
        synchronized (this) {
            MySegmentsSynchronizer mySegmentsSynchronizer = this.mMySegmentsSynchronizers.get(str);
            if (mySegmentsSynchronizer != null) {
                mySegmentsSynchronizer.stopPeriodicFetching();
                mySegmentsSynchronizer.destroy();
            }
            this.mMySegmentsSynchronizers.remove(str);
        }
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void loadMySegmentsFromCache() {
        synchronized (this) {
            Iterator<MySegmentsSynchronizer> it = this.mMySegmentsSynchronizers.values().iterator();
            while (it.hasNext()) {
                it.next().loadMySegmentsFromCache();
            }
            this.mLoadedFromCache.set(true);
        }
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void synchronizeMySegments() {
        Iterator<MySegmentsSynchronizer> it = this.mMySegmentsSynchronizers.values().iterator();
        while (it.hasNext()) {
            it.next().synchronizeMySegments();
        }
        this.mSynchronizedSegments.set(true);
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void forceMySegmentsSync() {
        Iterator<MySegmentsSynchronizer> it = this.mMySegmentsSynchronizers.values().iterator();
        while (it.hasNext()) {
            it.next().forceMySegmentsSync();
        }
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void destroy() {
        synchronized (this) {
            Iterator<MySegmentsSynchronizer> it = this.mMySegmentsSynchronizers.values().iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
        }
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void scheduleSegmentsSyncTask() {
        synchronized (this) {
            Iterator<MySegmentsSynchronizer> it = this.mMySegmentsSynchronizers.values().iterator();
            while (it.hasNext()) {
                it.next().scheduleSegmentsSyncTask();
            }
            this.mScheduledSegmentsSyncTask.set(true);
        }
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void submitMySegmentsLoadingTask() {
        Iterator<MySegmentsSynchronizer> it = this.mMySegmentsSynchronizers.values().iterator();
        while (it.hasNext()) {
            it.next().submitMySegmentsLoadingTask();
        }
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void stopPeriodicFetching() {
        synchronized (this) {
            Iterator<MySegmentsSynchronizer> it = this.mMySegmentsSynchronizers.values().iterator();
            while (it.hasNext()) {
                it.next().stopPeriodicFetching();
            }
            this.mScheduledSegmentsSyncTask.set(false);
            this.mStoppedPeriodicFetching.set(true);
        }
    }
}
