package io.opentelemetry.sdk.metrics.internal.concurrent;

/* loaded from: classes6.dex */
public interface DoubleAdder {
    void add(double d);

    double doubleValue();

    float floatValue();

    int intValue();

    long longValue();

    void reset();

    double sum();

    double sumThenReset();

    /* renamed from: io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
        public static long $default$longValue(DoubleAdder doubleAdder) {
            return (long) doubleAdder.sum();
        }

        public static int $default$intValue(DoubleAdder doubleAdder) {
            return (int) doubleAdder.sum();
        }

        public static float $default$floatValue(DoubleAdder doubleAdder) {
            return (float) doubleAdder.sum();
        }
    }
}
