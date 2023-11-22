package io.opentelemetry.api.trace;

/* loaded from: classes.dex */
public interface TracerProvider {
    Tracer get(String str);

    Tracer get(String str, String str2);

    TracerBuilder tracerBuilder(String str);

    /* renamed from: io.opentelemetry.api.trace.TracerProvider$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static TracerProvider noop() {
            return DefaultTracerProvider.getInstance();
        }
    }
}
