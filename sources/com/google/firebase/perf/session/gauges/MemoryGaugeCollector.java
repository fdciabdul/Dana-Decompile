package com.google.firebase.perf.session.gauges;

import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.StorageUnit;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.AndroidMemoryReading;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class MemoryGaugeCollector {
    public static final long INVALID_MEMORY_COLLECTION_FREQUENCY = -1;
    private static final int UNSET_MEMORY_METRIC_COLLECTION_RATE = -1;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private long memoryMetricCollectionRateMs;
    private final ScheduledExecutorService memoryMetricCollectorExecutor;
    private ScheduledFuture memoryMetricCollectorJob;
    public final ConcurrentLinkedQueue<AndroidMemoryReading> memoryMetricReadings;
    private final Runtime runtime;

    public static boolean isInvalidCollectionFrequency(long j) {
        return j <= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MemoryGaugeCollector() {
        this(Executors.newSingleThreadScheduledExecutor(), Runtime.getRuntime());
    }

    MemoryGaugeCollector(ScheduledExecutorService scheduledExecutorService, Runtime runtime) {
        this.memoryMetricCollectorJob = null;
        this.memoryMetricCollectionRateMs = -1L;
        this.memoryMetricCollectorExecutor = scheduledExecutorService;
        this.memoryMetricReadings = new ConcurrentLinkedQueue<>();
        this.runtime = runtime;
    }

    public void startCollecting(long j, Timer timer) {
        if (isInvalidCollectionFrequency(j)) {
            return;
        }
        if (this.memoryMetricCollectorJob == null) {
            scheduleMemoryMetricCollectionWithRate(j, timer);
        } else if (this.memoryMetricCollectionRateMs != j) {
            stopCollecting();
            scheduleMemoryMetricCollectionWithRate(j, timer);
        }
    }

    public void stopCollecting() {
        ScheduledFuture scheduledFuture = this.memoryMetricCollectorJob;
        if (scheduledFuture == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.memoryMetricCollectorJob = null;
        this.memoryMetricCollectionRateMs = -1L;
    }

    public void collectOnce(Timer timer) {
        scheduleMemoryMetricCollectionOnce(timer);
    }

    private void scheduleMemoryMetricCollectionWithRate(long j, final Timer timer) {
        synchronized (this) {
            this.memoryMetricCollectionRateMs = j;
            try {
                this.memoryMetricCollectorJob = this.memoryMetricCollectorExecutor.scheduleAtFixedRate(new Runnable() { // from class: com.google.firebase.perf.session.gauges.MemoryGaugeCollector$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        MemoryGaugeCollector.this.m193x5ca50e9a(timer);
                    }
                }, 0L, j, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                AndroidLogger androidLogger = logger;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to start collecting Memory Metrics: ");
                sb.append(e.getMessage());
                androidLogger.warn(sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$scheduleMemoryMetricCollectionWithRate$0$com-google-firebase-perf-session-gauges-MemoryGaugeCollector  reason: not valid java name */
    public /* synthetic */ void m193x5ca50e9a(Timer timer) {
        AndroidMemoryReading syncCollectMemoryMetric = syncCollectMemoryMetric(timer);
        if (syncCollectMemoryMetric != null) {
            this.memoryMetricReadings.add(syncCollectMemoryMetric);
        }
    }

    private void scheduleMemoryMetricCollectionOnce(final Timer timer) {
        synchronized (this) {
            try {
                this.memoryMetricCollectorExecutor.schedule(new Runnable() { // from class: com.google.firebase.perf.session.gauges.MemoryGaugeCollector$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        MemoryGaugeCollector.this.m192x5390f99e(timer);
                    }
                }, 0L, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                AndroidLogger androidLogger = logger;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to collect Memory Metric: ");
                sb.append(e.getMessage());
                androidLogger.warn(sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$scheduleMemoryMetricCollectionOnce$1$com-google-firebase-perf-session-gauges-MemoryGaugeCollector  reason: not valid java name */
    public /* synthetic */ void m192x5390f99e(Timer timer) {
        AndroidMemoryReading syncCollectMemoryMetric = syncCollectMemoryMetric(timer);
        if (syncCollectMemoryMetric != null) {
            this.memoryMetricReadings.add(syncCollectMemoryMetric);
        }
    }

    private AndroidMemoryReading syncCollectMemoryMetric(Timer timer) {
        if (timer == null) {
            return null;
        }
        return AndroidMemoryReading.newBuilder().setClientTimeUs(timer.getCurrentTimestampMicros()).setUsedAppJavaHeapMemoryKb(getCurrentUsedAppJavaHeapMemoryKb()).build();
    }

    private int getCurrentUsedAppJavaHeapMemoryKb() {
        return Utils.saturatedIntCast(StorageUnit.BYTES.toKilobytes(this.runtime.totalMemory() - this.runtime.freeMemory()));
    }
}
