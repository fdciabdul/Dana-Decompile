package io.opentelemetry.sdk.logs;

import io.opentelemetry.api.logs.LoggerBuilder;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.common.InstrumentationScopeInfoBuilder;
import io.opentelemetry.sdk.internal.ComponentRegistry;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
final class SdkLoggerBuilder implements LoggerBuilder {
    @Nullable
    private String eventDomain;
    private final ComponentRegistry<SdkLogger> registry;
    private final InstrumentationScopeInfoBuilder scopeBuilder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkLoggerBuilder(ComponentRegistry<SdkLogger> componentRegistry, String str) {
        this.registry = componentRegistry;
        this.scopeBuilder = InstrumentationScopeInfo.builder(str);
    }

    @Override // io.opentelemetry.api.logs.LoggerBuilder
    public final LoggerBuilder setEventDomain(String str) {
        this.eventDomain = str;
        return this;
    }

    @Override // io.opentelemetry.api.logs.LoggerBuilder
    public final SdkLoggerBuilder setSchemaUrl(String str) {
        this.scopeBuilder.setSchemaUrl(str);
        return this;
    }

    @Override // io.opentelemetry.api.logs.LoggerBuilder
    public final SdkLoggerBuilder setInstrumentationVersion(String str) {
        this.scopeBuilder.setVersion(str);
        return this;
    }

    @Override // io.opentelemetry.api.logs.LoggerBuilder
    public final SdkLogger build() {
        SdkLogger sdkLogger = this.registry.get(this.scopeBuilder.build());
        String str = this.eventDomain;
        return str != null ? sdkLogger.withEventDomain(str) : sdkLogger;
    }
}
