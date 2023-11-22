package io.opentelemetry.sdk.metrics.export;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.data.MetricData;
import java.io.Closeable;
import java.util.Collection;

/* loaded from: classes9.dex */
public interface MetricExporter extends AggregationTemporalitySelector, DefaultAggregationSelector, Closeable {
    void close();

    CompletableResultCode export(Collection<MetricData> collection);

    CompletableResultCode flush();

    Aggregation getDefaultAggregation(InstrumentType instrumentType);

    CompletableResultCode shutdown();

    /* renamed from: io.opentelemetry.sdk.metrics.export.MetricExporter$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
    }
}
