package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.metrics.internal.export.RegisteredReader;
import io.opentelemetry.sdk.metrics.internal.state.MetricStorage;
import io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import io.opentelemetry.sdk.resources.Resource;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes6.dex */
public final class DefaultSynchronousMetricStorage<T, U extends ExemplarData> implements SynchronousMetricStorage {
    private final Aggregator<T, U> aggregator;
    private final AttributesProcessor attributesProcessor;
    private final MetricDescriptor metricDescriptor;
    private final RegisteredReader registeredReader;
    private final TemporalMetricStorage<T, U> temporalMetricStorage;
    private static final ThrottlingLogger logger = new ThrottlingLogger(Logger.getLogger(DefaultSynchronousMetricStorage.class.getName()));
    private static final BoundStorageHandle NOOP_STORAGE_HANDLE = new NoopBoundHandle();
    private final ConcurrentHashMap<Attributes, AggregatorHandle<T, U>> activeCollectionStorage = new ConcurrentHashMap<>();
    private final BoundStorageHandle lateBoundStorageHandle = new BoundStorageHandle() { // from class: io.opentelemetry.sdk.metrics.internal.state.DefaultSynchronousMetricStorage.1
        @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
        public void release() {
        }

        @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
        public void recordLong(long j, Attributes attributes, Context context) {
            DefaultSynchronousMetricStorage.this.recordLong(j, attributes, context);
        }

        @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
        public void recordDouble(double d, Attributes attributes, Context context) {
            DefaultSynchronousMetricStorage.this.recordDouble(d, attributes, context);
        }
    };

    @Override // io.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public final /* synthetic */ boolean isEmpty() {
        return MetricStorage.CC.$default$isEmpty(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultSynchronousMetricStorage(RegisteredReader registeredReader, MetricDescriptor metricDescriptor, Aggregator<T, U> aggregator, AttributesProcessor attributesProcessor) {
        this.registeredReader = registeredReader;
        this.metricDescriptor = metricDescriptor;
        AggregationTemporality aggregationTemporality = registeredReader.getReader().getAggregationTemporality(metricDescriptor.getSourceInstrument().getType());
        this.aggregator = aggregator;
        this.temporalMetricStorage = new TemporalMetricStorage<>(aggregator, true, registeredReader, aggregationTemporality, metricDescriptor);
        this.attributesProcessor = attributesProcessor;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public final BoundStorageHandle bind(Attributes attributes) {
        Objects.requireNonNull(attributes, "attributes");
        if (this.attributesProcessor.usesContext()) {
            return this.lateBoundStorageHandle;
        }
        return doBind(this.attributesProcessor.process(attributes, Context.CC.current()));
    }

    private BoundStorageHandle doBind(Attributes attributes) {
        AggregatorHandle<T, U> aggregatorHandle = this.activeCollectionStorage.get(attributes);
        if (aggregatorHandle == null || !aggregatorHandle.acquire()) {
            AggregatorHandle<T, U> createHandle = this.aggregator.createHandle();
            while (this.activeCollectionStorage.size() < 2000) {
                AggregatorHandle<T, U> putIfAbsent = this.activeCollectionStorage.putIfAbsent(attributes, createHandle);
                if (putIfAbsent == null) {
                    return createHandle;
                }
                if (putIfAbsent.acquire()) {
                    return putIfAbsent;
                }
                this.activeCollectionStorage.remove(attributes, putIfAbsent);
            }
            ThrottlingLogger throttlingLogger = logger;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Instrument ");
            sb.append(this.metricDescriptor.getSourceInstrument().getName());
            sb.append(" has exceeded the maximum allowed accumulations (");
            sb.append(2000);
            sb.append(").");
            throttlingLogger.log(level, sb.toString());
            return NOOP_STORAGE_HANDLE;
        }
        return aggregatorHandle;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public final void recordLong(long j, Attributes attributes, Context context) {
        Objects.requireNonNull(attributes, "attributes");
        Attributes process = this.attributesProcessor.process(attributes, context);
        BoundStorageHandle doBind = doBind(process);
        try {
            doBind.recordLong(j, process, context);
        } finally {
            doBind.release();
        }
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public final void recordDouble(double d, Attributes attributes, Context context) {
        Objects.requireNonNull(attributes, "attributes");
        Attributes process = this.attributesProcessor.process(attributes, context);
        BoundStorageHandle doBind = doBind(process);
        try {
            doBind.recordDouble(d, process, context);
        } finally {
            doBind.release();
        }
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public final MetricData collectAndReset(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, long j, long j2) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Attributes, AggregatorHandle<T, U>> entry : this.activeCollectionStorage.entrySet()) {
            if (entry.getValue().tryUnmap()) {
                this.activeCollectionStorage.remove(entry.getKey(), entry.getValue());
            }
            T accumulateThenReset = entry.getValue().accumulateThenReset(entry.getKey());
            if (accumulateThenReset != null) {
                hashMap.put(entry.getKey(), accumulateThenReset);
            }
        }
        return this.temporalMetricStorage.buildMetricFor(resource, instrumentationScopeInfo, hashMap, j, j2);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public final MetricDescriptor getMetricDescriptor() {
        return this.metricDescriptor;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public final RegisteredReader getRegisteredReader() {
        return this.registeredReader;
    }

    /* loaded from: classes6.dex */
    static class NoopBoundHandle implements BoundStorageHandle {
        @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
        public void recordDouble(double d, Attributes attributes, Context context) {
        }

        @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
        public void recordLong(long j, Attributes attributes, Context context) {
        }

        @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
        public void release() {
        }

        private NoopBoundHandle() {
        }
    }
}
