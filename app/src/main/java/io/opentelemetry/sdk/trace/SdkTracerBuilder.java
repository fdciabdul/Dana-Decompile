package io.opentelemetry.sdk.trace;

import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.TracerBuilder;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.common.InstrumentationScopeInfoBuilder;
import io.opentelemetry.sdk.internal.ComponentRegistry;

/* loaded from: classes2.dex */
class SdkTracerBuilder implements TracerBuilder {
    private final ComponentRegistry<SdkTracer> registry;
    private final InstrumentationScopeInfoBuilder scopeBuilder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkTracerBuilder(ComponentRegistry<SdkTracer> componentRegistry, String str) {
        this.registry = componentRegistry;
        this.scopeBuilder = InstrumentationScopeInfo.builder(str);
    }

    @Override // io.opentelemetry.api.trace.TracerBuilder
    public TracerBuilder setSchemaUrl(String str) {
        this.scopeBuilder.setSchemaUrl(str);
        return this;
    }

    @Override // io.opentelemetry.api.trace.TracerBuilder
    public TracerBuilder setInstrumentationVersion(String str) {
        this.scopeBuilder.setVersion(str);
        return this;
    }

    @Override // io.opentelemetry.api.trace.TracerBuilder
    public Tracer build() {
        return this.registry.get(this.scopeBuilder.build());
    }
}
