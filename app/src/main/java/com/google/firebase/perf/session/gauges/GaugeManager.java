package com.google.firebase.perf.session.gauges;

import android.content.Context;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.GaugeMetadata;
import com.google.firebase.perf.v1.GaugeMetric;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class GaugeManager {
    private static final long APPROX_NUMBER_OF_DATA_POINTS_PER_GAUGE_METRIC = 20;
    private static final long INVALID_GAUGE_COLLECTION_FREQUENCY = -1;
    private static final long TIME_TO_WAIT_BEFORE_FLUSHING_GAUGES_QUEUE_MS = 20;
    private ApplicationProcessState applicationProcessState;
    private final ConfigResolver configResolver;
    private final Lazy<CpuGaugeCollector> cpuGaugeCollector;
    private ScheduledFuture gaugeManagerDataCollectionJob;
    private final Lazy<ScheduledExecutorService> gaugeManagerExecutor;
    private GaugeMetadataManager gaugeMetadataManager;
    private final Lazy<MemoryGaugeCollector> memoryGaugeCollector;
    private String sessionId;
    private final TransportManager transportManager;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private static final GaugeManager instance = new GaugeManager();

    private GaugeManager() {
        this(new Lazy(new Provider() { // from class: com.google.firebase.perf.session.gauges.GaugeManager$$ExternalSyntheticLambda2
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                ScheduledExecutorService newSingleThreadScheduledExecutor;
                newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
                return newSingleThreadScheduledExecutor;
            }
        }), TransportManager.getInstance(), ConfigResolver.getInstance(), null, new Lazy(new Provider() { // from class: com.google.firebase.perf.session.gauges.GaugeManager$$ExternalSyntheticLambda3
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return GaugeManager.lambda$new$1();
            }
        }), new Lazy(new Provider() { // from class: com.google.firebase.perf.session.gauges.GaugeManager$$ExternalSyntheticLambda4
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return GaugeManager.lambda$new$2();
            }
        }));
    }

    public static /* synthetic */ CpuGaugeCollector lambda$new$1() {
        return new CpuGaugeCollector();
    }

    public static /* synthetic */ MemoryGaugeCollector lambda$new$2() {
        return new MemoryGaugeCollector();
    }

    GaugeManager(Lazy<ScheduledExecutorService> lazy, TransportManager transportManager, ConfigResolver configResolver, GaugeMetadataManager gaugeMetadataManager, Lazy<CpuGaugeCollector> lazy2, Lazy<MemoryGaugeCollector> lazy3) {
        this.gaugeManagerDataCollectionJob = null;
        this.sessionId = null;
        this.applicationProcessState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.gaugeManagerExecutor = lazy;
        this.transportManager = transportManager;
        this.configResolver = configResolver;
        this.gaugeMetadataManager = gaugeMetadataManager;
        this.cpuGaugeCollector = lazy2;
        this.memoryGaugeCollector = lazy3;
    }

    public void initializeGaugeMetadataManager(Context context) {
        this.gaugeMetadataManager = new GaugeMetadataManager(context);
    }

    public static GaugeManager getInstance() {
        GaugeManager gaugeManager;
        synchronized (GaugeManager.class) {
            gaugeManager = instance;
        }
        return gaugeManager;
    }

    public void startCollectingGauges(PerfSession perfSession, final ApplicationProcessState applicationProcessState) {
        if (this.sessionId != null) {
            stopCollectingGauges();
        }
        long startCollectingGauges = startCollectingGauges(applicationProcessState, perfSession.getTimer());
        if (startCollectingGauges == -1) {
            logger.warn("Invalid gauge collection frequency. Unable to start collecting Gauges.");
            return;
        }
        final String sessionId = perfSession.sessionId();
        this.sessionId = sessionId;
        this.applicationProcessState = applicationProcessState;
        try {
            long j = startCollectingGauges * 20;
            this.gaugeManagerDataCollectionJob = this.gaugeManagerExecutor.get().scheduleAtFixedRate(new Runnable() { // from class: com.google.firebase.perf.session.gauges.GaugeManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    GaugeManager.this.m190xfe5b9608(sessionId, applicationProcessState);
                }
            }, j, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            AndroidLogger androidLogger = logger;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to start collecting Gauges: ");
            sb.append(e.getMessage());
            androidLogger.warn(sb.toString());
        }
    }

    private long startCollectingGauges(ApplicationProcessState applicationProcessState, Timer timer) {
        long cpuGaugeCollectionFrequencyMs = getCpuGaugeCollectionFrequencyMs(applicationProcessState);
        if (!startCollectingCpuMetrics(cpuGaugeCollectionFrequencyMs, timer)) {
            cpuGaugeCollectionFrequencyMs = -1;
        }
        long memoryGaugeCollectionFrequencyMs = getMemoryGaugeCollectionFrequencyMs(applicationProcessState);
        return startCollectingMemoryMetrics(memoryGaugeCollectionFrequencyMs, timer) ? cpuGaugeCollectionFrequencyMs == -1 ? memoryGaugeCollectionFrequencyMs : Math.min(cpuGaugeCollectionFrequencyMs, memoryGaugeCollectionFrequencyMs) : cpuGaugeCollectionFrequencyMs;
    }

    public void stopCollectingGauges() {
        final String str = this.sessionId;
        if (str == null) {
            return;
        }
        final ApplicationProcessState applicationProcessState = this.applicationProcessState;
        this.cpuGaugeCollector.get().stopCollecting();
        this.memoryGaugeCollector.get().stopCollecting();
        ScheduledFuture scheduledFuture = this.gaugeManagerDataCollectionJob;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.gaugeManagerExecutor.get().schedule(new Runnable() { // from class: com.google.firebase.perf.session.gauges.GaugeManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                GaugeManager.this.m191xe2c13ded(str, applicationProcessState);
            }
        }, 20L, TimeUnit.MILLISECONDS);
        this.sessionId = null;
        this.applicationProcessState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
    }

    /* renamed from: syncFlush */
    public void m191xe2c13ded(String str, ApplicationProcessState applicationProcessState) {
        GaugeMetric.Builder newBuilder = GaugeMetric.newBuilder();
        while (!this.cpuGaugeCollector.get().cpuMetricReadings.isEmpty()) {
            newBuilder.addCpuMetricReadings(this.cpuGaugeCollector.get().cpuMetricReadings.poll());
        }
        while (!this.memoryGaugeCollector.get().memoryMetricReadings.isEmpty()) {
            newBuilder.addAndroidMemoryReadings(this.memoryGaugeCollector.get().memoryMetricReadings.poll());
        }
        newBuilder.setSessionId(str);
        this.transportManager.log(newBuilder.build(), applicationProcessState);
    }

    public boolean logGaugeMetadata(String str, ApplicationProcessState applicationProcessState) {
        if (this.gaugeMetadataManager != null) {
            this.transportManager.log(GaugeMetric.newBuilder().setSessionId(str).setGaugeMetadata(getGaugeMetadata()).build(), applicationProcessState);
            return true;
        }
        return false;
    }

    private GaugeMetadata getGaugeMetadata() {
        return GaugeMetadata.newBuilder().setProcessName(this.gaugeMetadataManager.getProcessName()).setDeviceRamSizeKb(this.gaugeMetadataManager.getDeviceRamSizeKb()).setMaxAppJavaHeapMemoryKb(this.gaugeMetadataManager.getMaxAppJavaHeapMemoryKb()).setMaxEncouragedAppJavaHeapMemoryKb(this.gaugeMetadataManager.getMaxEncouragedAppJavaHeapMemoryKb()).build();
    }

    private boolean startCollectingCpuMetrics(long j, Timer timer) {
        if (j == -1) {
            logger.debug("Invalid Cpu Metrics collection frequency. Did not collect Cpu Metrics.");
            return false;
        }
        this.cpuGaugeCollector.get().startCollecting(j, timer);
        return true;
    }

    private boolean startCollectingMemoryMetrics(long j, Timer timer) {
        if (j == -1) {
            logger.debug("Invalid Memory Metrics collection frequency. Did not collect Memory Metrics.");
            return false;
        }
        this.memoryGaugeCollector.get().startCollecting(j, timer);
        return true;
    }

    public void collectGaugeMetricOnce(Timer timer) {
        collectGaugeMetricOnce(this.cpuGaugeCollector.get(), this.memoryGaugeCollector.get(), timer);
    }

    private static void collectGaugeMetricOnce(CpuGaugeCollector cpuGaugeCollector, MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        cpuGaugeCollector.collectOnce(timer);
        memoryGaugeCollector.collectOnce(timer);
    }

    /* renamed from: com.google.firebase.perf.session.gauges.GaugeManager$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$perf$v1$ApplicationProcessState;

        static {
            int[] iArr = new int[ApplicationProcessState.values().length];
            $SwitchMap$com$google$firebase$perf$v1$ApplicationProcessState = iArr;
            try {
                iArr[ApplicationProcessState.BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$perf$v1$ApplicationProcessState[ApplicationProcessState.FOREGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private long getCpuGaugeCollectionFrequencyMs(ApplicationProcessState applicationProcessState) {
        long sessionsCpuCaptureFrequencyBackgroundMs;
        int i = AnonymousClass1.$SwitchMap$com$google$firebase$perf$v1$ApplicationProcessState[applicationProcessState.ordinal()];
        if (i == 1) {
            sessionsCpuCaptureFrequencyBackgroundMs = this.configResolver.getSessionsCpuCaptureFrequencyBackgroundMs();
        } else {
            sessionsCpuCaptureFrequencyBackgroundMs = i != 2 ? -1L : this.configResolver.getSessionsCpuCaptureFrequencyForegroundMs();
        }
        if (CpuGaugeCollector.isInvalidCollectionFrequency(sessionsCpuCaptureFrequencyBackgroundMs)) {
            return -1L;
        }
        return sessionsCpuCaptureFrequencyBackgroundMs;
    }

    private long getMemoryGaugeCollectionFrequencyMs(ApplicationProcessState applicationProcessState) {
        long sessionsMemoryCaptureFrequencyBackgroundMs;
        int i = AnonymousClass1.$SwitchMap$com$google$firebase$perf$v1$ApplicationProcessState[applicationProcessState.ordinal()];
        if (i == 1) {
            sessionsMemoryCaptureFrequencyBackgroundMs = this.configResolver.getSessionsMemoryCaptureFrequencyBackgroundMs();
        } else {
            sessionsMemoryCaptureFrequencyBackgroundMs = i != 2 ? -1L : this.configResolver.getSessionsMemoryCaptureFrequencyForegroundMs();
        }
        if (MemoryGaugeCollector.isInvalidCollectionFrequency(sessionsMemoryCaptureFrequencyBackgroundMs)) {
            return -1L;
        }
        return sessionsMemoryCaptureFrequencyBackgroundMs;
    }
}
