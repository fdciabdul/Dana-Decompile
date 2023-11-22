package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir;
import io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public abstract class AggregatorHandle<T, U extends ExemplarData> implements BoundStorageHandle {
    private final ExemplarReservoir<U> exemplarReservoir;
    private volatile boolean hasRecordings = false;
    private final AtomicLong refCountMapped = new AtomicLong(2);

    protected abstract T doAccumulateThenReset(List<U> list);

    /* JADX INFO: Access modifiers changed from: protected */
    public AggregatorHandle(ExemplarReservoir<U> exemplarReservoir) {
        this.exemplarReservoir = exemplarReservoir;
    }

    public final boolean acquire() {
        return (this.refCountMapped.addAndGet(2L) & 1) == 0;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
    public final void release() {
        this.refCountMapped.getAndAdd(-2L);
    }

    public final boolean tryUnmap() {
        if (this.refCountMapped.get() != 0) {
            return false;
        }
        return this.refCountMapped.compareAndSet(0L, 1L);
    }

    @Nullable
    public final T accumulateThenReset(Attributes attributes) {
        if (this.hasRecordings) {
            this.hasRecordings = false;
            return doAccumulateThenReset(this.exemplarReservoir.collectAndReset(attributes));
        }
        return null;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
    public final void recordLong(long j, Attributes attributes, Context context) {
        this.exemplarReservoir.offerLongMeasurement(j, attributes, context);
        recordLong(j);
    }

    public final void recordLong(long j) {
        doRecordLong(j);
        this.hasRecordings = true;
    }

    protected void doRecordLong(long j) {
        throw new UnsupportedOperationException("This aggregator does not support recording long values.");
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
    public final void recordDouble(double d, Attributes attributes, Context context) {
        this.exemplarReservoir.offerDoubleMeasurement(d, attributes, context);
        recordDouble(d);
    }

    public final void recordDouble(double d) {
        doRecordDouble(d);
        this.hasRecordings = true;
    }

    protected void doRecordDouble(double d) {
        throw new UnsupportedOperationException("This aggregator does not support recording double values.");
    }
}
