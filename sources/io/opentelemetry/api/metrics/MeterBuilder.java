package io.opentelemetry.api.metrics;

/* loaded from: classes2.dex */
public interface MeterBuilder {
    Meter build();

    MeterBuilder setInstrumentationVersion(String str);

    MeterBuilder setSchemaUrl(String str);
}
