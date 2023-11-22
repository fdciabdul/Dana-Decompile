package io.opentelemetry.sdk.metrics.internal.state;

/* loaded from: classes3.dex */
public interface ExponentialCounterFactory {
    ExponentialCounter copy(ExponentialCounter exponentialCounter);

    ExponentialCounter newCounter(int i);

    /* renamed from: io.opentelemetry.sdk.metrics.internal.state.ExponentialCounterFactory$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static ExponentialCounterFactory mapCounter() {
            return new ExponentialCounterFactory() { // from class: io.opentelemetry.sdk.metrics.internal.state.ExponentialCounterFactory.1
                public String toString() {
                    return "mapCounter";
                }

                @Override // io.opentelemetry.sdk.metrics.internal.state.ExponentialCounterFactory
                public ExponentialCounter newCounter(int i) {
                    return new MapCounter(i);
                }

                @Override // io.opentelemetry.sdk.metrics.internal.state.ExponentialCounterFactory
                public ExponentialCounter copy(ExponentialCounter exponentialCounter) {
                    return new MapCounter(exponentialCounter);
                }
            };
        }

        public static ExponentialCounterFactory circularBufferCounter() {
            return new ExponentialCounterFactory() { // from class: io.opentelemetry.sdk.metrics.internal.state.ExponentialCounterFactory.2
                public String toString() {
                    return "circularBufferCounter";
                }

                @Override // io.opentelemetry.sdk.metrics.internal.state.ExponentialCounterFactory
                public ExponentialCounter newCounter(int i) {
                    return new AdaptingCircularBufferCounter(i);
                }

                @Override // io.opentelemetry.sdk.metrics.internal.state.ExponentialCounterFactory
                public ExponentialCounter copy(ExponentialCounter exponentialCounter) {
                    return new AdaptingCircularBufferCounter(exponentialCounter);
                }
            };
        }
    }
}
