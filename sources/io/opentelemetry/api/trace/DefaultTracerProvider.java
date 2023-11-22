package io.opentelemetry.api.trace;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class DefaultTracerProvider implements TracerProvider {
    private static final TracerProvider INSTANCE = new DefaultTracerProvider();

    @Override // io.opentelemetry.api.trace.TracerProvider
    public /* synthetic */ TracerBuilder tracerBuilder(String str) {
        TracerBuilder defaultTracerBuilder;
        defaultTracerBuilder = DefaultTracerBuilder.getInstance();
        return defaultTracerBuilder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TracerProvider getInstance() {
        return INSTANCE;
    }

    @Override // io.opentelemetry.api.trace.TracerProvider
    public Tracer get(String str) {
        return DefaultTracer.getInstance();
    }

    @Override // io.opentelemetry.api.trace.TracerProvider
    public Tracer get(String str, String str2) {
        return DefaultTracer.getInstance();
    }

    private DefaultTracerProvider() {
    }
}
