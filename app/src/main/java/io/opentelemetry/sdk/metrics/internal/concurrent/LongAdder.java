package io.opentelemetry.sdk.metrics.internal.concurrent;

/* loaded from: classes6.dex */
public interface LongAdder {
    void add(long j);

    void decrement();

    double doubleValue();

    float floatValue();

    void increment();

    int intValue();

    long longValue();

    void reset();

    long sum();

    long sumThenReset();

    /* renamed from: io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static int $default$intValue(LongAdder longAdder) {
            return (int) longAdder.sum();
        }

        public static float $default$floatValue(LongAdder longAdder) {
            return (float) longAdder.sum();
        }
    }
}
