package com.google.firebase.perf.transport;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.logging.ConsoleUrlGenerator;
import com.google.firebase.perf.metrics.validator.PerfMetricValidator;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.util.Rate;
import com.google.firebase.perf.v1.AndroidApplicationInfo;
import com.google.firebase.perf.v1.ApplicationInfo;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.GaugeMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.perf.v1.PerfMetricOrBuilder;
import com.google.firebase.perf.v1.TraceMetric;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class TransportManager implements AppStateMonitor.AppStateCallback {
    private static final int CORE_POOL_SIZE = 0;
    private static final String KEY_AVAILABLE_GAUGES_FOR_CACHING = "KEY_AVAILABLE_GAUGES_FOR_CACHING";
    private static final String KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING = "KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING";
    private static final String KEY_AVAILABLE_TRACES_FOR_CACHING = "KEY_AVAILABLE_TRACES_FOR_CACHING";
    private static final int MAX_GAUGE_METRICS_CACHE_SIZE = 50;
    private static final int MAX_NETWORK_REQUEST_METRICS_CACHE_SIZE = 50;
    private static final int MAX_POOL_SIZE = 1;
    private static final int MAX_TRACE_METRICS_CACHE_SIZE = 50;
    private Context appContext;
    private AppStateMonitor appStateMonitor;
    private ApplicationInfo.Builder applicationInfoBuilder;
    private final Map<String, Integer> cacheMap;
    private ConfigResolver configResolver;
    private FirebaseApp firebaseApp;
    private FirebaseInstallationsApi firebaseInstallationsApi;
    private FirebasePerformance firebasePerformance;
    private FlgTransport flgTransport;
    private Provider<TransportFactory> flgTransportFactoryProvider;
    private String packageName;
    private String projectId;
    private RateLimiter rateLimiter;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private static final TransportManager instance = new TransportManager();
    private final ConcurrentLinkedQueue<PendingPerfEvent> pendingEventsQueue = new ConcurrentLinkedQueue<>();
    private final AtomicBoolean isTransportInitialized = new AtomicBoolean(false);
    private boolean isForegroundState = false;
    private ExecutorService executorService = new ThreadPoolExecutor(0, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());

    private TransportManager() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.cacheMap = concurrentHashMap;
        concurrentHashMap.put(KEY_AVAILABLE_TRACES_FOR_CACHING, 50);
        concurrentHashMap.put(KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING, 50);
        concurrentHashMap.put(KEY_AVAILABLE_GAUGES_FOR_CACHING, 50);
    }

    public static TransportManager getInstance() {
        return instance;
    }

    void initializeForTest(FirebaseApp firebaseApp, FirebasePerformance firebasePerformance, FirebaseInstallationsApi firebaseInstallationsApi, Provider<TransportFactory> provider, ConfigResolver configResolver, RateLimiter rateLimiter, AppStateMonitor appStateMonitor, FlgTransport flgTransport, ExecutorService executorService) {
        this.firebaseApp = firebaseApp;
        this.projectId = firebaseApp.getOptions().getProjectId();
        this.appContext = firebaseApp.getApplicationContext();
        this.firebasePerformance = firebasePerformance;
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.flgTransportFactoryProvider = provider;
        this.configResolver = configResolver;
        this.rateLimiter = rateLimiter;
        this.appStateMonitor = appStateMonitor;
        this.flgTransport = flgTransport;
        this.executorService = executorService;
        this.cacheMap.put(KEY_AVAILABLE_TRACES_FOR_CACHING, 50);
        this.cacheMap.put(KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING, 50);
        this.cacheMap.put(KEY_AVAILABLE_GAUGES_FOR_CACHING, 50);
        finishInitialization();
    }

    public void initialize(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Provider<TransportFactory> provider) {
        this.firebaseApp = firebaseApp;
        this.projectId = firebaseApp.getOptions().getProjectId();
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.flgTransportFactoryProvider = provider;
        this.executorService.execute(new Runnable() { // from class: com.google.firebase.perf.transport.TransportManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                TransportManager.this.syncInit();
            }
        });
    }

    public void syncInit() {
        Context applicationContext = this.firebaseApp.getApplicationContext();
        this.appContext = applicationContext;
        this.packageName = applicationContext.getPackageName();
        this.configResolver = ConfigResolver.getInstance();
        this.rateLimiter = new RateLimiter(this.appContext, new Rate(100L, 1L, TimeUnit.MINUTES), 500L);
        this.appStateMonitor = AppStateMonitor.getInstance();
        this.flgTransport = new FlgTransport(this.flgTransportFactoryProvider, this.configResolver.getAndCacheLogSourceName());
        finishInitialization();
    }

    private void finishInitialization() {
        this.appStateMonitor.registerForAppState(new WeakReference<>(instance));
        ApplicationInfo.Builder newBuilder = ApplicationInfo.newBuilder();
        this.applicationInfoBuilder = newBuilder;
        newBuilder.setGoogleAppId(this.firebaseApp.getOptions().getApplicationId()).setAndroidAppInfo(AndroidApplicationInfo.newBuilder().setPackageName(this.packageName).setSdkVersion(BuildConfig.FIREPERF_VERSION_NAME).setVersionName(getVersionName(this.appContext)));
        this.isTransportInitialized.set(true);
        while (!this.pendingEventsQueue.isEmpty()) {
            final PendingPerfEvent poll = this.pendingEventsQueue.poll();
            if (poll != null) {
                this.executorService.execute(new Runnable() { // from class: com.google.firebase.perf.transport.TransportManager$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        TransportManager.this.m195xd2410da6(poll);
                    }
                });
            }
        }
    }

    /* renamed from: lambda$finishInitialization$0$com-google-firebase-perf-transport-TransportManager */
    public /* synthetic */ void m195xd2410da6(PendingPerfEvent pendingPerfEvent) {
        syncLog(pendingPerfEvent.perfMetricBuilder, pendingPerfEvent.appState);
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor.AppStateCallback
    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        this.isForegroundState = applicationProcessState == ApplicationProcessState.FOREGROUND;
        if (isInitialized()) {
            this.executorService.execute(new Runnable() { // from class: com.google.firebase.perf.transport.TransportManager$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    TransportManager.this.m199x3928ae6c();
                }
            });
        }
    }

    /* renamed from: lambda$onUpdateAppState$1$com-google-firebase-perf-transport-TransportManager */
    public /* synthetic */ void m199x3928ae6c() {
        this.rateLimiter.changeRate(this.isForegroundState);
    }

    public boolean isInitialized() {
        return this.isTransportInitialized.get();
    }

    public void log(TraceMetric traceMetric) {
        log(traceMetric, ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN);
    }

    public void log(final TraceMetric traceMetric, final ApplicationProcessState applicationProcessState) {
        this.executorService.execute(new Runnable() { // from class: com.google.firebase.perf.transport.TransportManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TransportManager.this.m196lambda$log$2$comgooglefirebaseperftransportTransportManager(traceMetric, applicationProcessState);
            }
        });
    }

    /* renamed from: lambda$log$2$com-google-firebase-perf-transport-TransportManager */
    public /* synthetic */ void m196lambda$log$2$comgooglefirebaseperftransportTransportManager(TraceMetric traceMetric, ApplicationProcessState applicationProcessState) {
        syncLog(PerfMetric.newBuilder().setTraceMetric(traceMetric), applicationProcessState);
    }

    public void log(NetworkRequestMetric networkRequestMetric) {
        log(networkRequestMetric, ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN);
    }

    public void log(final NetworkRequestMetric networkRequestMetric, final ApplicationProcessState applicationProcessState) {
        this.executorService.execute(new Runnable() { // from class: com.google.firebase.perf.transport.TransportManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                TransportManager.this.m197lambda$log$3$comgooglefirebaseperftransportTransportManager(networkRequestMetric, applicationProcessState);
            }
        });
    }

    /* renamed from: lambda$log$3$com-google-firebase-perf-transport-TransportManager */
    public /* synthetic */ void m197lambda$log$3$comgooglefirebaseperftransportTransportManager(NetworkRequestMetric networkRequestMetric, ApplicationProcessState applicationProcessState) {
        syncLog(PerfMetric.newBuilder().setNetworkRequestMetric(networkRequestMetric), applicationProcessState);
    }

    public void log(GaugeMetric gaugeMetric) {
        log(gaugeMetric, ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN);
    }

    public void log(final GaugeMetric gaugeMetric, final ApplicationProcessState applicationProcessState) {
        this.executorService.execute(new Runnable() { // from class: com.google.firebase.perf.transport.TransportManager$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                TransportManager.this.m198lambda$log$4$comgooglefirebaseperftransportTransportManager(gaugeMetric, applicationProcessState);
            }
        });
    }

    /* renamed from: lambda$log$4$com-google-firebase-perf-transport-TransportManager */
    public /* synthetic */ void m198lambda$log$4$comgooglefirebaseperftransportTransportManager(GaugeMetric gaugeMetric, ApplicationProcessState applicationProcessState) {
        syncLog(PerfMetric.newBuilder().setGaugeMetric(gaugeMetric), applicationProcessState);
    }

    private void syncLog(PerfMetric.Builder builder, ApplicationProcessState applicationProcessState) {
        if (!isInitialized()) {
            if (isAllowedToCache(builder)) {
                logger.debug("Transport is not initialized yet, %s will be queued for to be dispatched later", getLogcatMsg(builder));
                this.pendingEventsQueue.add(new PendingPerfEvent(builder, applicationProcessState));
                return;
            }
            return;
        }
        PerfMetric applicationInfoAndBuild = setApplicationInfoAndBuild(builder, applicationProcessState);
        if (isAllowedToDispatch(applicationInfoAndBuild)) {
            dispatchLog(applicationInfoAndBuild);
            SessionManager.getInstance().updatePerfSessionIfExpired();
        }
    }

    private boolean isAllowedToCache(PerfMetricOrBuilder perfMetricOrBuilder) {
        int intValue = this.cacheMap.get(KEY_AVAILABLE_TRACES_FOR_CACHING).intValue();
        int intValue2 = this.cacheMap.get(KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING).intValue();
        int intValue3 = this.cacheMap.get(KEY_AVAILABLE_GAUGES_FOR_CACHING).intValue();
        if (perfMetricOrBuilder.hasTraceMetric() && intValue > 0) {
            this.cacheMap.put(KEY_AVAILABLE_TRACES_FOR_CACHING, Integer.valueOf(intValue - 1));
            return true;
        } else if (perfMetricOrBuilder.hasNetworkRequestMetric() && intValue2 > 0) {
            this.cacheMap.put(KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING, Integer.valueOf(intValue2 - 1));
            return true;
        } else if (perfMetricOrBuilder.hasGaugeMetric() && intValue3 > 0) {
            this.cacheMap.put(KEY_AVAILABLE_GAUGES_FOR_CACHING, Integer.valueOf(intValue3 - 1));
            return true;
        } else {
            logger.debug("%s is not allowed to cache. Cache exhausted the limit (availableTracesForCaching: %d, availableNetworkRequestsForCaching: %d, availableGaugesForCaching: %d).", getLogcatMsg(perfMetricOrBuilder), Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(intValue3));
            return false;
        }
    }

    private boolean isAllowedToDispatch(PerfMetric perfMetric) {
        if (!this.configResolver.isPerformanceMonitoringEnabled()) {
            logger.info("Performance collection is not enabled, dropping %s", getLogcatMsg(perfMetric));
            return false;
        } else if (!perfMetric.getApplicationInfo().hasAppInstanceId()) {
            logger.warn("App Instance ID is null or empty, dropping %s", getLogcatMsg(perfMetric));
            return false;
        } else if (!PerfMetricValidator.isValid(perfMetric, this.appContext)) {
            logger.warn("Unable to process the PerfMetric (%s) due to missing or invalid values. See earlier log statements for additional information on the specific missing/invalid values.", getLogcatMsg(perfMetric));
            return false;
        } else if (!this.rateLimiter.isEventSampled(perfMetric)) {
            incrementDropCount(perfMetric);
            logger.info("Event dropped due to device sampling - %s", getLogcatMsg(perfMetric));
            return false;
        } else if (this.rateLimiter.isEventRateLimited(perfMetric)) {
            incrementDropCount(perfMetric);
            logger.info("Rate limited (per device) - %s", getLogcatMsg(perfMetric));
            return false;
        } else {
            return true;
        }
    }

    private void dispatchLog(PerfMetric perfMetric) {
        if (perfMetric.hasTraceMetric()) {
            logger.info("Logging %s. In a minute, visit the Firebase console to view your data: %s", getLogcatMsg(perfMetric), getConsoleUrl(perfMetric.getTraceMetric()));
        } else {
            logger.info("Logging %s", getLogcatMsg(perfMetric));
        }
        this.flgTransport.log(perfMetric);
    }

    private static String getVersionName(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return packageInfo.versionName == null ? "" : packageInfo.versionName;
    }

    private PerfMetric setApplicationInfoAndBuild(PerfMetric.Builder builder, ApplicationProcessState applicationProcessState) {
        updateFirebaseInstallationIdIfPossibleAndNeeded();
        ApplicationInfo.Builder applicationProcessState2 = this.applicationInfoBuilder.setApplicationProcessState(applicationProcessState);
        if (builder.hasTraceMetric() || builder.hasNetworkRequestMetric()) {
            applicationProcessState2 = applicationProcessState2.mo223clone().putAllCustomAttributes(getGlobalCustomAttributes());
        }
        return builder.setApplicationInfo(applicationProcessState2).build();
    }

    private Map<String, String> getGlobalCustomAttributes() {
        updateFirebasePerformanceIfPossibleAndNeeded();
        FirebasePerformance firebasePerformance = this.firebasePerformance;
        if (firebasePerformance != null) {
            return firebasePerformance.getAttributes();
        }
        return Collections.emptyMap();
    }

    private void updateFirebasePerformanceIfPossibleAndNeeded() {
        if (this.firebasePerformance == null && isInitialized()) {
            this.firebasePerformance = FirebasePerformance.getInstance();
        }
    }

    private void updateFirebaseInstallationIdIfPossibleAndNeeded() {
        if (this.configResolver.isPerformanceMonitoringEnabled()) {
            if (!this.applicationInfoBuilder.hasAppInstanceId() || this.isForegroundState) {
                String str = null;
                try {
                    str = (String) Tasks.await(this.firebaseInstallationsApi.getId(), 60000L, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    logger.error("Task to retrieve Installation Id is interrupted: %s", e.getMessage());
                } catch (ExecutionException e2) {
                    logger.error("Unable to retrieve Installation Id: %s", e2.getMessage());
                } catch (TimeoutException e3) {
                    logger.error("Task to retrieve Installation Id is timed out: %s", e3.getMessage());
                }
                if (!TextUtils.isEmpty(str)) {
                    this.applicationInfoBuilder.setAppInstanceId(str);
                } else {
                    logger.warn("Firebase Installation Id is empty, contact Firebase Support for debugging.");
                }
            }
        }
    }

    private void incrementDropCount(PerfMetric perfMetric) {
        if (perfMetric.hasTraceMetric()) {
            this.appStateMonitor.incrementCount(Constants.CounterNames.TRACE_EVENT_RATE_LIMITED.toString(), 1L);
        } else if (perfMetric.hasNetworkRequestMetric()) {
            this.appStateMonitor.incrementCount(Constants.CounterNames.NETWORK_TRACE_EVENT_RATE_LIMITED.toString(), 1L);
        }
    }

    private static String getLogcatMsg(PerfMetricOrBuilder perfMetricOrBuilder) {
        if (perfMetricOrBuilder.hasTraceMetric()) {
            return getLogcatMsg(perfMetricOrBuilder.getTraceMetric());
        }
        if (perfMetricOrBuilder.hasNetworkRequestMetric()) {
            return getLogcatMsg(perfMetricOrBuilder.getNetworkRequestMetric());
        }
        return perfMetricOrBuilder.hasGaugeMetric() ? getLogcatMsg(perfMetricOrBuilder.getGaugeMetric()) : "log";
    }

    private static String getLogcatMsg(TraceMetric traceMetric) {
        long durationUs = traceMetric.getDurationUs();
        Locale locale = Locale.ENGLISH;
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        double d = durationUs;
        Double.isNaN(d);
        return String.format(locale, "trace metric: %s (duration: %sms)", traceMetric.getName(), decimalFormat.format(d / 1000.0d));
    }

    private static String getLogcatMsg(NetworkRequestMetric networkRequestMetric) {
        long timeToResponseCompletedUs = networkRequestMetric.hasTimeToResponseCompletedUs() ? networkRequestMetric.getTimeToResponseCompletedUs() : 0L;
        String valueOf = networkRequestMetric.hasHttpResponseCode() ? String.valueOf(networkRequestMetric.getHttpResponseCode()) : "UNKNOWN";
        Locale locale = Locale.ENGLISH;
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        double d = timeToResponseCompletedUs;
        Double.isNaN(d);
        return String.format(locale, "network request trace: %s (responseCode: %s, responseTime: %sms)", networkRequestMetric.getUrl(), valueOf, decimalFormat.format(d / 1000.0d));
    }

    private static String getLogcatMsg(GaugeMetric gaugeMetric) {
        return String.format(Locale.ENGLISH, "gauges (hasMetadata: %b, cpuGaugeCount: %d, memoryGaugeCount: %d)", Boolean.valueOf(gaugeMetric.hasGaugeMetadata()), Integer.valueOf(gaugeMetric.getCpuMetricReadingsCount()), Integer.valueOf(gaugeMetric.getAndroidMemoryReadingsCount()));
    }

    private String getConsoleUrl(TraceMetric traceMetric) {
        String name = traceMetric.getName();
        if (name.startsWith(Constants.SCREEN_TRACE_PREFIX)) {
            return ConsoleUrlGenerator.generateScreenTraceUrl(this.projectId, this.packageName, name);
        }
        return ConsoleUrlGenerator.generateCustomTraceUrl(this.projectId, this.packageName, name);
    }

    protected void setInitialized(boolean z) {
        this.isTransportInitialized.set(z);
    }

    protected void clearAppInstanceId() {
        this.applicationInfoBuilder.clearAppInstanceId();
    }

    protected ConcurrentLinkedQueue<PendingPerfEvent> getPendingEventsQueue() {
        return new ConcurrentLinkedQueue<>(this.pendingEventsQueue);
    }
}
