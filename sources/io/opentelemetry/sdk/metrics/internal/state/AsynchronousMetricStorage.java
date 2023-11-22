package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import io.opentelemetry.sdk.metrics.View;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import io.opentelemetry.sdk.metrics.internal.export.RegisteredReader;
import io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import io.opentelemetry.sdk.metrics.internal.view.RegisteredView;
import io.opentelemetry.sdk.resources.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes6.dex */
public final class AsynchronousMetricStorage<T, U extends ExemplarData> implements MetricStorage {
    private static final Logger logger = Logger.getLogger(AsynchronousMetricStorage.class.getName());
    private final Aggregator<T, U> aggregator;
    private final AttributesProcessor attributesProcessor;
    private final MetricDescriptor metricDescriptor;
    private final TemporalMetricStorage<T, U> metricStorage;
    private final RegisteredReader registeredReader;
    private final ThrottlingLogger throttlingLogger = new ThrottlingLogger(logger);
    private Map<Attributes, T> accumulations = new HashMap();

    private AsynchronousMetricStorage(RegisteredReader registeredReader, MetricDescriptor metricDescriptor, Aggregator<T, U> aggregator, AttributesProcessor attributesProcessor) {
        this.registeredReader = registeredReader;
        this.metricDescriptor = metricDescriptor;
        this.metricStorage = new TemporalMetricStorage<>(aggregator, false, registeredReader, registeredReader.getReader().getAggregationTemporality(metricDescriptor.getSourceInstrument().getType()), metricDescriptor);
        this.aggregator = aggregator;
        this.attributesProcessor = attributesProcessor;
    }

    public static <T, U extends ExemplarData> AsynchronousMetricStorage<T, U> create(RegisteredReader registeredReader, RegisteredView registeredView, InstrumentDescriptor instrumentDescriptor) {
        View view = registeredView.getView();
        return new AsynchronousMetricStorage<>(registeredReader, MetricDescriptor.create(view, registeredView.getViewSourceInfo(), instrumentDescriptor), ((AggregatorFactory) view.getAggregation()).createAggregator(instrumentDescriptor, ExemplarFilter.CC.neverSample()), registeredView.getViewAttributesProcessor());
    }

    public final void recordLong(long j, Attributes attributes) {
        T accumulateLongMeasurement = this.aggregator.accumulateLongMeasurement(j, attributes, Context.CC.current());
        if (accumulateLongMeasurement != null) {
            recordAccumulation(accumulateLongMeasurement, attributes);
        }
    }

    public final void recordDouble(double d, Attributes attributes) {
        T accumulateDoubleMeasurement = this.aggregator.accumulateDoubleMeasurement(d, attributes, Context.CC.current());
        if (accumulateDoubleMeasurement != null) {
            recordAccumulation(accumulateDoubleMeasurement, attributes);
        }
    }

    private void recordAccumulation(T t, Attributes attributes) {
        Attributes process = this.attributesProcessor.process(attributes, Context.CC.current());
        if (this.accumulations.size() >= 2000) {
            ThrottlingLogger throttlingLogger = this.throttlingLogger;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Instrument ");
            sb.append(this.metricDescriptor.getSourceInstrument().getName());
            sb.append(" has exceeded the maximum allowed accumulations (");
            sb.append(2000);
            sb.append(").");
            throttlingLogger.log(level, sb.toString());
        } else if (this.accumulations.containsKey(attributes)) {
            ThrottlingLogger throttlingLogger2 = this.throttlingLogger;
            Level level2 = Level.WARNING;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Instrument ");
            sb2.append(this.metricDescriptor.getSourceInstrument().getName());
            sb2.append(" has recorded multiple values for the same attributes.");
            throttlingLogger2.log(level2, sb2.toString());
        } else {
            this.accumulations.put(process, t);
        }
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public final MetricDescriptor getMetricDescriptor() {
        return this.metricDescriptor;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public final RegisteredReader getRegisteredReader() {
        return this.registeredReader;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public final MetricData collectAndReset(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, long j, long j2) {
        Map<Attributes, T> map = this.accumulations;
        this.accumulations = new HashMap();
        return this.metricStorage.buildMetricFor(resource, instrumentationScopeInfo, map, j, j2);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public final boolean isEmpty() {
        return this.aggregator == Aggregator.CC.drop();
    }
}
