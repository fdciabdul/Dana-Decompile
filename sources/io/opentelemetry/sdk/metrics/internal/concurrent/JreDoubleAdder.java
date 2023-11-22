package io.opentelemetry.sdk.metrics.internal.concurrent;

import io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder;

/* loaded from: classes6.dex */
final class JreDoubleAdder implements DoubleAdder {
    private final java.util.concurrent.atomic.DoubleAdder delegate = new java.util.concurrent.atomic.DoubleAdder();

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
        this.delegate.add(d);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public final double sum() {
        return this.delegate.sum();
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public final void reset() {
        this.delegate.reset();
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public final double sumThenReset() {
        return this.delegate.sumThenReset();
    }

    public final String toString() {
        return this.delegate.toString();
    }
}
