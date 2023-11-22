package io.opentelemetry.api.trace;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class DefaultTracerBuilder implements TracerBuilder {
    private static final DefaultTracerBuilder INSTANCE = new DefaultTracerBuilder();

    @Override // io.opentelemetry.api.trace.TracerBuilder
    public TracerBuilder setInstrumentationVersion(String str) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.TracerBuilder
    public TracerBuilder setSchemaUrl(String str) {
        return this;
    }

    DefaultTracerBuilder() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TracerBuilder getInstance() {
        return INSTANCE;
    }

    @Override // io.opentelemetry.api.trace.TracerBuilder
    public Tracer build() {
        return DefaultTracer.getInstance();
    }
}
