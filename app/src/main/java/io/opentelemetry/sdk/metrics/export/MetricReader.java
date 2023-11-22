package io.opentelemetry.sdk.metrics.export;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentType;

/* loaded from: classes.dex */
public interface MetricReader extends AggregationTemporalitySelector, DefaultAggregationSelector {
    CompletableResultCode forceFlush();

    @Override // io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector
    Aggregation getDefaultAggregation(InstrumentType instrumentType);

    void register(CollectionRegistration collectionRegistration);

    CompletableResultCode shutdown();

    /* renamed from: io.opentelemetry.sdk.metrics.export.MetricReader$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
    }
}
