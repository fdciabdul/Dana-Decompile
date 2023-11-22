package io.opentelemetry.sdk.metrics.internal.concurrent;

import io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
final class AtomicLongDoubleAdder implements DoubleAdder {
    private final AtomicLong atomicLong = new AtomicLong();

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public final /* synthetic */ double doubleValue() {
        double sum;
        sum = sum();
        return sum;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public final /* synthetic */ float floatValue() {
        return DoubleAdder.CC.$default$floatValue(this);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public final /* synthetic */ int intValue() {
        return DoubleAdder.CC.$default$intValue(this);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public final /* synthetic */ long longValue() {
        return DoubleAdder.CC.$default$longValue(this);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public final void add(double d) {
        long j;
        do {
            j = this.atomicLong.get();
        } while (!this.atomicLong.compareAndSet(j, Double.doubleToLongBits(Double.longBitsToDouble(j) + d)));
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public final double sum() {
        return Double.longBitsToDouble(this.atomicLong.get());
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public final void reset() {
        this.atomicLong.set(0L);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public final double sumThenReset() {
        long j;
        do {
            j = this.atomicLong.get();
        } while (!this.atomicLong.compareAndSet(j, 0L));
        return Double.longBitsToDouble(j);
    }

    public final String toString() {
        return Double.toString(sum());
    }
}
