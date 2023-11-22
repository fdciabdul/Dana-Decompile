package io.opentelemetry.api.metrics;

/* loaded from: classes.dex */
public interface MeterProvider {
    Meter get(String str);

    MeterBuilder meterBuilder(String str);

    /* renamed from: io.opentelemetry.api.metrics.MeterProvider$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC {
        public static MeterProvider noop() {
            return DefaultMeterProvider.getInstance();
        }
    }
}
