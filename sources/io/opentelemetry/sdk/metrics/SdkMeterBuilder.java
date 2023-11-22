package io.opentelemetry.sdk.metrics;

import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterBuilder;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.common.InstrumentationScopeInfoBuilder;
import io.opentelemetry.sdk.internal.ComponentRegistry;

/* loaded from: classes2.dex */
class SdkMeterBuilder implements MeterBuilder {
    private final ComponentRegistry<SdkMeter> registry;
    private final InstrumentationScopeInfoBuilder scopeBuilder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkMeterBuilder(ComponentRegistry<SdkMeter> componentRegistry, String str) {
        this.registry = componentRegistry;
        this.scopeBuilder = InstrumentationScopeInfo.builder(str);
    }

    @Override // io.opentelemetry.api.metrics.MeterBuilder
    public MeterBuilder setSchemaUrl(String str) {
        this.scopeBuilder.setSchemaUrl(str);
        return this;
    }

    @Override // io.opentelemetry.api.metrics.MeterBuilder
    public MeterBuilder setInstrumentationVersion(String str) {
        this.scopeBuilder.setVersion(str);
        return this;
    }

    @Override // io.opentelemetry.api.metrics.MeterBuilder
    public Meter build() {
        return this.registry.get(this.scopeBuilder.build());
    }
}
