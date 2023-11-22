package io.split.android.client.telemetry.storage;

import com.google.common.collect.Maps;
import io.split.android.client.telemetry.model.EventsDataRecordsEnum;
import io.split.android.client.telemetry.model.FactoryCounter;
import io.split.android.client.telemetry.model.HttpErrors;
import io.split.android.client.telemetry.model.HttpLatencies;
import io.split.android.client.telemetry.model.ImpressionsDataType;
import io.split.android.client.telemetry.model.LastSync;
import io.split.android.client.telemetry.model.Method;
import io.split.android.client.telemetry.model.MethodExceptions;
import io.split.android.client.telemetry.model.MethodLatencies;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.model.PushCounterEvent;
import io.split.android.client.telemetry.model.UpdatesFromSSE;
import io.split.android.client.telemetry.model.streaming.StreamingEvent;
import io.split.android.client.telemetry.model.streaming.UpdatesFromSSEEnum;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
public class InMemoryTelemetryStorage implements TelemetryStorage {
    private static final int MAX_STREAMING_EVENTS = 20;
    private static final int MAX_TAGS = 10;
    private final Map<Method, AtomicLong> methodExceptionsCounter = Maps.newConcurrentMap();
    private final ConcurrentMap<Method, ILatencyTracker> methodLatencies = Maps.newConcurrentMap();
    private final Map<FactoryCounter, AtomicLong> factoryCounters = Maps.newConcurrentMap();
    private final Map<ImpressionsDataType, AtomicLong> impressionsData = Maps.newConcurrentMap();
    private final Map<EventsDataRecordsEnum, AtomicLong> eventsData = Maps.newConcurrentMap();
    private final Map<OperationType, AtomicLong> lastSynchronizationData = Maps.newConcurrentMap();
    private final AtomicLong sessionLength = new AtomicLong();
    private final Object httpErrorsLock = new Object();
    private final Map<OperationType, Map<Long, Long>> httpErrors = Maps.newConcurrentMap();
    private final Map<OperationType, ILatencyTracker> httpLatencies = Maps.newConcurrentMap();
    private final Map<PushCounterEvent, AtomicLong> pushCounters = Maps.newConcurrentMap();
    private final Object streamingEventsLock = new Object();
    private List<StreamingEvent> streamingEvents = new ArrayList();
    private Map<UpdatesFromSSEEnum, AtomicLong> updatesFromSSE = Maps.newConcurrentMap();
    private final Object tagsLock = new Object();
    private final Object httpLatenciesLock = new Object();
    private final Object methodLatenciesLock = new Object();
    private final Object updatesFromSSELock = new Object();
    private final Set<String> tags = new HashSet();

    public InMemoryTelemetryStorage() {
        initializeProperties();
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryEvaluationConsumer
    public MethodExceptions popExceptions() {
        MethodExceptions methodExceptions = new MethodExceptions();
        methodExceptions.setTreatment(this.methodExceptionsCounter.get(Method.TREATMENT).getAndSet(0L));
        methodExceptions.setTreatments(this.methodExceptionsCounter.get(Method.TREATMENTS).getAndSet(0L));
        methodExceptions.setTreatmentWithConfig(this.methodExceptionsCounter.get(Method.TREATMENT_WITH_CONFIG).getAndSet(0L));
        methodExceptions.setTreatmentsWithConfig(this.methodExceptionsCounter.get(Method.TREATMENTS_WITH_CONFIG).getAndSet(0L));
        methodExceptions.setTrack(this.methodExceptionsCounter.get(Method.TRACK).getAndSet(0L));
        return methodExceptions;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryEvaluationConsumer
    public MethodLatencies popLatencies() {
        MethodLatencies methodLatencies;
        synchronized (this.methodLatenciesLock) {
            methodLatencies = new MethodLatencies();
            methodLatencies.setTreatment(popLatencies(Method.TREATMENT));
            methodLatencies.setTreatments(popLatencies(Method.TREATMENTS));
            methodLatencies.setTreatmentWithConfig(popLatencies(Method.TREATMENT_WITH_CONFIG));
            methodLatencies.setTreatmentsWithConfig(popLatencies(Method.TREATMENTS_WITH_CONFIG));
            methodLatencies.setTrack(popLatencies(Method.TRACK));
        }
        return methodLatencies;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryEvaluationProducer
    public void recordLatency(Method method, long j) {
        ILatencyTracker iLatencyTracker = this.methodLatencies.get(method);
        if (iLatencyTracker != null) {
            synchronized (this.methodLatencies) {
                iLatencyTracker.addLatencyMillis(j);
            }
        }
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryEvaluationProducer
    public void recordException(Method method) {
        this.methodExceptionsCounter.get(method).incrementAndGet();
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryInitConsumer
    public long getNonReadyUsage() {
        return this.factoryCounters.get(FactoryCounter.NON_READY_USAGES).get();
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryInitConsumer
    public long getActiveFactories() {
        return this.factoryCounters.get(FactoryCounter.ACTIVE_FACTORIES).get();
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryInitConsumer
    public long getRedundantFactories() {
        return this.factoryCounters.get(FactoryCounter.REDUNDANT_FACTORIES).get();
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryInitConsumer
    public long getTimeUntilReady() {
        return this.factoryCounters.get(FactoryCounter.SDK_READY_TIME).get();
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryInitConsumer
    public long getTimeUntilReadyFromCache() {
        return this.factoryCounters.get(FactoryCounter.SDK_READY_FROM_CACHE).get();
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryInitProducer
    public void recordNonReadyUsage() {
        this.factoryCounters.get(FactoryCounter.NON_READY_USAGES).incrementAndGet();
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryInitProducer
    public void recordActiveFactories(int i) {
        this.factoryCounters.get(FactoryCounter.ACTIVE_FACTORIES).set(i);
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryInitProducer
    public void recordRedundantFactories(int i) {
        this.factoryCounters.get(FactoryCounter.REDUNDANT_FACTORIES).set(i);
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryInitProducer
    public void recordTimeUntilReady(long j) {
        this.factoryCounters.get(FactoryCounter.SDK_READY_TIME).set(j);
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryInitProducer
    public void recordTimeUntilReadyFromCache(long j) {
        this.factoryCounters.get(FactoryCounter.SDK_READY_FROM_CACHE).set(j);
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public long getImpressionsStats(ImpressionsDataType impressionsDataType) {
        return this.impressionsData.get(impressionsDataType).get();
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public long getEventsStats(EventsDataRecordsEnum eventsDataRecordsEnum) {
        return this.eventsData.get(eventsDataRecordsEnum).get();
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public LastSync getLastSynchronization() {
        LastSync lastSync = new LastSync();
        lastSync.setLastEventSync(this.lastSynchronizationData.get(OperationType.EVENTS).get());
        lastSync.setLastSplitSync(this.lastSynchronizationData.get(OperationType.SPLITS).get());
        lastSync.setLastMySegmentSync(this.lastSynchronizationData.get(OperationType.MY_SEGMENT).get());
        lastSync.setLastTelemetrySync(this.lastSynchronizationData.get(OperationType.TELEMETRY).get());
        lastSync.setLastImpressionSync(this.lastSynchronizationData.get(OperationType.IMPRESSIONS).get());
        lastSync.setLastImpressionCountSync(this.lastSynchronizationData.get(OperationType.IMPRESSIONS_COUNT).get());
        lastSync.setLastTokenRefresh(this.lastSynchronizationData.get(OperationType.TOKEN).get());
        return lastSync;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public HttpErrors popHttpErrors() {
        HttpErrors httpErrors = new HttpErrors();
        httpErrors.setEventsSyncErrs(this.httpErrors.get(OperationType.EVENTS));
        httpErrors.setImpressionCountSyncErrs(this.httpErrors.get(OperationType.IMPRESSIONS_COUNT));
        httpErrors.setTelemetrySyncErrs(this.httpErrors.get(OperationType.TELEMETRY));
        httpErrors.setImpressionSyncErrs(this.httpErrors.get(OperationType.IMPRESSIONS));
        httpErrors.setSplitSyncErrs(this.httpErrors.get(OperationType.SPLITS));
        httpErrors.setMySegmentSyncErrs(this.httpErrors.get(OperationType.MY_SEGMENT));
        httpErrors.setTokenGetErrs(this.httpErrors.get(OperationType.TOKEN));
        initializeHttpErrors();
        return httpErrors;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public HttpLatencies popHttpLatencies() {
        HttpLatencies httpLatencies;
        synchronized (this.httpLatenciesLock) {
            httpLatencies = new HttpLatencies();
            httpLatencies.setTelemetry(popLatencies(OperationType.TELEMETRY));
            httpLatencies.setEvents(popLatencies(OperationType.EVENTS));
            httpLatencies.setSplits(popLatencies(OperationType.SPLITS));
            httpLatencies.setMySegments(popLatencies(OperationType.MY_SEGMENT));
            httpLatencies.setToken(popLatencies(OperationType.TOKEN));
            httpLatencies.setImpressions(popLatencies(OperationType.IMPRESSIONS));
            httpLatencies.setImpressionsCount(popLatencies(OperationType.IMPRESSIONS_COUNT));
        }
        return httpLatencies;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public long popAuthRejections() {
        return this.pushCounters.get(PushCounterEvent.AUTH_REJECTIONS).getAndSet(0L);
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public long popTokenRefreshes() {
        return this.pushCounters.get(PushCounterEvent.TOKEN_REFRESHES).getAndSet(0L);
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public List<StreamingEvent> popStreamingEvents() {
        List<StreamingEvent> list;
        synchronized (this.streamingEventsLock) {
            list = this.streamingEvents;
            this.streamingEvents = new ArrayList();
        }
        return list;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public List<String> popTags() {
        ArrayList arrayList;
        synchronized (this.tagsLock) {
            arrayList = new ArrayList(this.tags);
            this.tags.clear();
        }
        return arrayList;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public long getSessionLength() {
        return this.sessionLength.get();
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public UpdatesFromSSE popUpdatesFromSSE() {
        UpdatesFromSSE updatesFromSSE;
        synchronized (this.updatesFromSSELock) {
            AtomicLong atomicLong = this.updatesFromSSE.get(UpdatesFromSSEEnum.SPLITS);
            long andSet = atomicLong != null ? atomicLong.getAndSet(0L) : 0L;
            AtomicLong atomicLong2 = this.updatesFromSSE.get(UpdatesFromSSEEnum.MY_SEGMENTS);
            updatesFromSSE = new UpdatesFromSSE(andSet, atomicLong2 != null ? atomicLong2.getAndSet(0L) : 0L);
        }
        return updatesFromSSE;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void addTag(String str) {
        synchronized (this.tagsLock) {
            if (this.tags.size() < 10) {
                this.tags.add(str);
            }
        }
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void recordImpressionStats(ImpressionsDataType impressionsDataType, long j) {
        this.impressionsData.get(impressionsDataType).addAndGet(j);
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void recordEventStats(EventsDataRecordsEnum eventsDataRecordsEnum, long j) {
        this.eventsData.get(eventsDataRecordsEnum).addAndGet(j);
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void recordSuccessfulSync(OperationType operationType, long j) {
        this.lastSynchronizationData.put(operationType, new AtomicLong(j));
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void recordSyncError(OperationType operationType, Integer num) {
        synchronized (this.httpErrorsLock) {
            if (num == null) {
                return;
            }
            Map<Long, Long> map = this.httpErrors.get(operationType);
            if (map == null) {
                return;
            }
            if (!map.containsKey(Long.valueOf(num.intValue()))) {
                map.put(Long.valueOf(num.intValue()), 0L);
            }
            map.put(Long.valueOf(num.intValue()), Long.valueOf(map.get(Long.valueOf(num.intValue())).longValue() + 1));
        }
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void recordSyncLatency(OperationType operationType, long j) {
        ILatencyTracker iLatencyTracker = this.httpLatencies.get(operationType);
        if (iLatencyTracker != null) {
            iLatencyTracker.addLatencyMillis(j);
        }
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void recordAuthRejections() {
        this.pushCounters.get(PushCounterEvent.AUTH_REJECTIONS).incrementAndGet();
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void recordTokenRefreshes() {
        this.pushCounters.get(PushCounterEvent.TOKEN_REFRESHES).incrementAndGet();
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void recordStreamingEvents(StreamingEvent streamingEvent) {
        synchronized (this.streamingEventsLock) {
            if (this.streamingEvents.size() < 20) {
                this.streamingEvents.add(streamingEvent);
            }
        }
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void recordSessionLength(long j) {
        this.sessionLength.set(j);
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void recordUpdatesFromSSE(UpdatesFromSSEEnum updatesFromSSEEnum) {
        this.updatesFromSSE.get(updatesFromSSEEnum).incrementAndGet();
    }

    private void initializeProperties() {
        initializeMethodExceptionsCounter();
        initializeHttpLatenciesCounter();
        initializeFactoryCounters();
        initializeImpressionsData();
        initializeEventsData();
        initializeLastSynchronizationData();
        initializeHttpErrors();
        initializeHttpLatencies();
        initializePushCounters();
        initializeUpdatesFromSSE();
    }

    private void initializeHttpLatenciesCounter() {
        this.methodLatencies.put(Method.TREATMENT, new BinarySearchLatencyTracker());
        this.methodLatencies.put(Method.TREATMENTS, new BinarySearchLatencyTracker());
        this.methodLatencies.put(Method.TREATMENT_WITH_CONFIG, new BinarySearchLatencyTracker());
        this.methodLatencies.put(Method.TREATMENTS_WITH_CONFIG, new BinarySearchLatencyTracker());
        this.methodLatencies.put(Method.TRACK, new BinarySearchLatencyTracker());
    }

    private void initializeMethodExceptionsCounter() {
        this.methodExceptionsCounter.put(Method.TREATMENT, new AtomicLong());
        this.methodExceptionsCounter.put(Method.TREATMENTS, new AtomicLong());
        this.methodExceptionsCounter.put(Method.TREATMENT_WITH_CONFIG, new AtomicLong());
        this.methodExceptionsCounter.put(Method.TREATMENTS_WITH_CONFIG, new AtomicLong());
        this.methodExceptionsCounter.put(Method.TRACK, new AtomicLong());
    }

    private void initializeFactoryCounters() {
        this.factoryCounters.put(FactoryCounter.NON_READY_USAGES, new AtomicLong());
        this.factoryCounters.put(FactoryCounter.SDK_READY_TIME, new AtomicLong());
        this.factoryCounters.put(FactoryCounter.SDK_READY_FROM_CACHE, new AtomicLong());
        this.factoryCounters.put(FactoryCounter.REDUNDANT_FACTORIES, new AtomicLong());
        this.factoryCounters.put(FactoryCounter.ACTIVE_FACTORIES, new AtomicLong());
    }

    private void initializeImpressionsData() {
        this.impressionsData.put(ImpressionsDataType.IMPRESSIONS_QUEUED, new AtomicLong());
        this.impressionsData.put(ImpressionsDataType.IMPRESSIONS_DEDUPED, new AtomicLong());
        this.impressionsData.put(ImpressionsDataType.IMPRESSIONS_DROPPED, new AtomicLong());
    }

    private void initializeEventsData() {
        this.eventsData.put(EventsDataRecordsEnum.EVENTS_DROPPED, new AtomicLong());
        this.eventsData.put(EventsDataRecordsEnum.EVENTS_QUEUED, new AtomicLong());
    }

    private void initializeLastSynchronizationData() {
        this.lastSynchronizationData.put(OperationType.IMPRESSIONS, new AtomicLong());
        this.lastSynchronizationData.put(OperationType.IMPRESSIONS_COUNT, new AtomicLong());
        this.lastSynchronizationData.put(OperationType.TELEMETRY, new AtomicLong());
        this.lastSynchronizationData.put(OperationType.EVENTS, new AtomicLong());
        this.lastSynchronizationData.put(OperationType.MY_SEGMENT, new AtomicLong());
        this.lastSynchronizationData.put(OperationType.SPLITS, new AtomicLong());
        this.lastSynchronizationData.put(OperationType.TOKEN, new AtomicLong());
    }

    private void initializeHttpErrors() {
        this.httpErrors.put(OperationType.EVENTS, Maps.newConcurrentMap());
        this.httpErrors.put(OperationType.SPLITS, Maps.newConcurrentMap());
        this.httpErrors.put(OperationType.TELEMETRY, Maps.newConcurrentMap());
        this.httpErrors.put(OperationType.MY_SEGMENT, Maps.newConcurrentMap());
        this.httpErrors.put(OperationType.IMPRESSIONS_COUNT, Maps.newConcurrentMap());
        this.httpErrors.put(OperationType.IMPRESSIONS, Maps.newConcurrentMap());
        this.httpErrors.put(OperationType.TOKEN, Maps.newConcurrentMap());
    }

    private void initializeHttpLatencies() {
        this.httpLatencies.put(OperationType.EVENTS, new BinarySearchLatencyTracker());
        this.httpLatencies.put(OperationType.IMPRESSIONS, new BinarySearchLatencyTracker());
        this.httpLatencies.put(OperationType.TELEMETRY, new BinarySearchLatencyTracker());
        this.httpLatencies.put(OperationType.IMPRESSIONS_COUNT, new BinarySearchLatencyTracker());
        this.httpLatencies.put(OperationType.MY_SEGMENT, new BinarySearchLatencyTracker());
        this.httpLatencies.put(OperationType.SPLITS, new BinarySearchLatencyTracker());
        this.httpLatencies.put(OperationType.TOKEN, new BinarySearchLatencyTracker());
    }

    private void initializePushCounters() {
        this.pushCounters.put(PushCounterEvent.AUTH_REJECTIONS, new AtomicLong());
        this.pushCounters.put(PushCounterEvent.TOKEN_REFRESHES, new AtomicLong());
    }

    private void initializeUpdatesFromSSE() {
        this.updatesFromSSE.put(UpdatesFromSSEEnum.SPLITS, new AtomicLong());
        this.updatesFromSSE.put(UpdatesFromSSEEnum.MY_SEGMENTS, new AtomicLong());
    }

    private List<Long> popLatencies(OperationType operationType) {
        long[] latencies = this.httpLatencies.get(operationType).getLatencies();
        this.httpLatencies.get(operationType).clear();
        return getLatenciesList(latencies);
    }

    private List<Long> popLatencies(Method method) {
        long[] latencies = this.methodLatencies.get(method).getLatencies();
        this.methodLatencies.get(method).clear();
        return getLatenciesList(latencies);
    }

    private static List<Long> getLatenciesList(long[] jArr) {
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }
}
