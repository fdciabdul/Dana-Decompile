package io.opentelemetry.exporter.logging;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes9.dex */
public final class LoggingMetricExporter implements MetricExporter {
    private static final Logger logger = Logger.getLogger(LoggingMetricExporter.class.getName());
    private final AggregationTemporality aggregationTemporality;

    @Override // io.opentelemetry.sdk.metrics.export.MetricExporter, java.io.Closeable, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    @Override // io.opentelemetry.sdk.metrics.export.MetricExporter, io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector
    public final /* synthetic */ Aggregation getDefaultAggregation(InstrumentType instrumentType) {
        Aggregation defaultAggregation;
        defaultAggregation = Aggregation.CC.defaultAggregation();
        return defaultAggregation;
    }

    @Override // io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector
    public final /* synthetic */ DefaultAggregationSelector with(InstrumentType instrumentType, Aggregation aggregation) {
        return DefaultAggregationSelector.CC.$default$with(this, instrumentType, aggregation);
    }

    public static LoggingMetricExporter create() {
        return create(AggregationTemporality.CUMULATIVE);
    }

    public static LoggingMetricExporter create(AggregationTemporality aggregationTemporality) {
        return new LoggingMetricExporter(aggregationTemporality);
    }

    @Deprecated
    public LoggingMetricExporter() {
        this(AggregationTemporality.CUMULATIVE);
    }

    private LoggingMetricExporter(AggregationTemporality aggregationTemporality) {
        this.aggregationTemporality = aggregationTemporality;
    }

    @Deprecated
    public final AggregationTemporality getPreferredTemporality() {
        return this.aggregationTemporality;
    }

    @Override // io.opentelemetry.sdk.metrics.export.AggregationTemporalitySelector
    public final AggregationTemporality getAggregationTemporality(InstrumentType instrumentType) {
        return this.aggregationTemporality;
    }

    @Override // io.opentelemetry.sdk.metrics.export.MetricExporter
    public final CompletableResultCode export(Collection<MetricData> collection) {
        Logger logger2 = logger;
        StringBuilder sb = new StringBuilder();
        sb.append("Received a collection of ");
        sb.append(collection.size());
        sb.append(" metrics for export.");
        logger2.info(sb.toString());
        Iterator<MetricData> it = collection.iterator();
        while (it.hasNext()) {
            logger.log(Level.INFO, "metric: {0}", it.next());
        }
        return CompletableResultCode.ofSuccess();
    }

    @Override // io.opentelemetry.sdk.metrics.export.MetricExporter
    public final CompletableResultCode flush() {
        CompletableResultCode completableResultCode = new CompletableResultCode();
        for (Handler handler : logger.getHandlers()) {
            try {
                handler.flush();
            } catch (Throwable unused) {
                return completableResultCode.fail();
            }
        }
        return completableResultCode.succeed();
    }

    @Override // io.opentelemetry.sdk.metrics.export.MetricExporter
    public final CompletableResultCode shutdown() {
        flush();
        return CompletableResultCode.ofSuccess();
    }
}
