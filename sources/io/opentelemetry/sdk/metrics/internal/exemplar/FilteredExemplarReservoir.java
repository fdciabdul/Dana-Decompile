package io.opentelemetry.sdk.metrics.internal.exemplar;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class FilteredExemplarReservoir<T extends ExemplarData> implements ExemplarReservoir<T> {
    private final ExemplarFilter filter;
    private final ExemplarReservoir<T> reservoir;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilteredExemplarReservoir(ExemplarFilter exemplarFilter, ExemplarReservoir<T> exemplarReservoir) {
        this.filter = exemplarFilter;
        this.reservoir = exemplarReservoir;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir
    public void offerDoubleMeasurement(double d, Attributes attributes, Context context) {
        if (this.filter.shouldSampleMeasurement(d, attributes, context)) {
            this.reservoir.offerDoubleMeasurement(d, attributes, context);
        }
    }

    @Override // io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir
    public void offerLongMeasurement(long j, Attributes attributes, Context context) {
        if (this.filter.shouldSampleMeasurement(j, attributes, context)) {
            this.reservoir.offerLongMeasurement(j, attributes, context);
        }
    }

    @Override // io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir
    public List<T> collectAndReset(Attributes attributes) {
        return this.reservoir.collectAndReset(attributes);
    }
}
