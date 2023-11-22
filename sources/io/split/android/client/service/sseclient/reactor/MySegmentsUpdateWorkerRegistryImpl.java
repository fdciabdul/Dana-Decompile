package io.split.android.client.service.sseclient.reactor;

import io.split.android.client.utils.logger.Logger;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class MySegmentsUpdateWorkerRegistryImpl implements MySegmentsUpdateWorkerRegistry {
    private final AtomicBoolean mStarted = new AtomicBoolean(false);
    private final ConcurrentMap<String, MySegmentsUpdateWorker> mMySegmentUpdateWorkers = new ConcurrentHashMap();

    @Override // io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorkerRegistry
    public void registerMySegmentsUpdateWorker(String str, MySegmentsUpdateWorker mySegmentsUpdateWorker) {
        synchronized (this) {
            this.mMySegmentUpdateWorkers.put(str, mySegmentsUpdateWorker);
            if (this.mStarted.get()) {
                mySegmentsUpdateWorker.start();
            }
        }
    }

    @Override // io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorkerRegistry
    public void unregisterMySegmentsUpdateWorker(String str) {
        synchronized (this) {
            MySegmentsUpdateWorker mySegmentsUpdateWorker = this.mMySegmentUpdateWorkers.get(str);
            if (mySegmentsUpdateWorker != null) {
                mySegmentsUpdateWorker.stop();
            }
            this.mMySegmentUpdateWorkers.remove(str);
        }
    }

    @Override // io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorkerRegistry
    public void start() {
        if (this.mStarted.getAndSet(true)) {
            return;
        }
        if (this.mMySegmentUpdateWorkers.isEmpty()) {
            Logger.d("No MySegmentsUpdateWorkers have been registered");
        }
        Iterator<MySegmentsUpdateWorker> it = this.mMySegmentUpdateWorkers.values().iterator();
        while (it.hasNext()) {
            it.next().start();
        }
    }

    @Override // io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorkerRegistry
    public void stop() {
        if (this.mStarted.getAndSet(false)) {
            Iterator<MySegmentsUpdateWorker> it = this.mMySegmentUpdateWorkers.values().iterator();
            while (it.hasNext()) {
                it.next().stop();
            }
        }
    }
}
