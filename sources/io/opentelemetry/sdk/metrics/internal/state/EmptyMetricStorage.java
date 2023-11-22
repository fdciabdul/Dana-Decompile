package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.export.CollectionRegistration;
import io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector;
import io.opentelemetry.sdk.metrics.export.MetricReader;
import io.opentelemetry.sdk.metrics.internal.aggregator.EmptyMetricData;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.metrics.internal.export.RegisteredReader;
import io.opentelemetry.sdk.metrics.internal.state.MetricStorage;
import io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import io.opentelemetry.sdk.metrics.internal.view.ViewRegistry;
import io.opentelemetry.sdk.resources.Resource;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class EmptyMetricStorage implements SynchronousMetricStorage {
    static final EmptyMetricStorage INSTANCE = new EmptyMetricStorage();
    private final MetricDescriptor descriptor = MetricDescriptor.create("", "", "");
    private final BoundStorageHandle emptyHandle = new BoundStorageHandle() { // from class: io.opentelemetry.sdk.metrics.internal.state.EmptyMetricStorage.1
        @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
        public void recordDouble(double d, Attributes attributes, Context context) {
        }

        @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
        public void recordLong(long j, Attributes attributes, Context context) {
        }

        @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
        public void release() {
        }
    };
    private final MetricReader emptyReader;
    private final RegisteredReader registeredReader;

    @Override // io.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public final /* synthetic */ boolean isEmpty() {
        return MetricStorage.CC.$default$isEmpty(this);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public final /* synthetic */ void recordDouble(double d, Attributes attributes, Context context) {
        WriteableMetricStorage.CC.$default$recordDouble(this, d, attributes, context);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public final /* synthetic */ void recordLong(long j, Attributes attributes, Context context) {
        WriteableMetricStorage.CC.$default$recordLong(this, j, attributes, context);
    }

    private EmptyMetricStorage() {
        MetricReader metricReader = new MetricReader() { // from class: io.opentelemetry.sdk.metrics.internal.state.EmptyMetricStorage.2
            @Override // io.opentelemetry.sdk.metrics.export.MetricReader
            public void register(CollectionRegistration collectionRegistration) {
            }

            @Override // io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector
            public /* synthetic */ DefaultAggregationSelector with(InstrumentType instrumentType, Aggregation aggregation) {
                return DefaultAggregationSelector.CC.$default$with(this, instrumentType, aggregation);
            }

            @Override // io.opentelemetry.sdk.metrics.export.MetricReader, io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector
            public Aggregation getDefaultAggregation(InstrumentType instrumentType) {
                return Aggregation.CC.drop();
            }

            @Override // io.opentelemetry.sdk.metrics.export.AggregationTemporalitySelector
            public AggregationTemporality getAggregationTemporality(InstrumentType instrumentType) {
                return AggregationTemporality.CUMULATIVE;
            }

            @Override // io.opentelemetry.sdk.metrics.export.MetricReader
            public CompletableResultCode forceFlush() {
                return CompletableResultCode.ofSuccess();
            }

            @Override // io.opentelemetry.sdk.metrics.export.MetricReader
            public CompletableResultCode shutdown() {
                return CompletableResultCode.ofFailure();
            }
        };
        this.emptyReader = metricReader;
        this.registeredReader = RegisteredReader.create(metricReader, ViewRegistry.create(metricReader, Collections.emptyList()));
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public final MetricDescriptor getMetricDescriptor() {
        return this.descriptor;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public final RegisteredReader getRegisteredReader() {
        return this.registeredReader;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public final BoundStorageHandle bind(Attributes attributes) {
        return this.emptyHandle;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public final MetricData collectAndReset(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, long j, long j2) {
        return EmptyMetricData.getInstance();
    }
}
