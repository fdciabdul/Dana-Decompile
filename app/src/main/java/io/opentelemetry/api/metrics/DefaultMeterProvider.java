package io.opentelemetry.api.metrics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class DefaultMeterProvider implements MeterProvider {
    private static final DefaultMeterProvider INSTANCE = new DefaultMeterProvider();
    private static final MeterBuilder BUILDER_INSTANCE = new NoopMeterBuilder();

    @Override // io.opentelemetry.api.metrics.MeterProvider
    public /* synthetic */ Meter get(String str) {
        Meter build;
        build = meterBuilder(str).build();
        return build;
    }

    @Override // io.opentelemetry.api.metrics.MeterProvider
    public MeterBuilder meterBuilder(String str) {
        return BUILDER_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MeterProvider getInstance() {
        return INSTANCE;
    }

    private DefaultMeterProvider() {
    }

    /* loaded from: classes6.dex */
    static class NoopMeterBuilder implements MeterBuilder {
        @Override // io.opentelemetry.api.metrics.MeterBuilder
        public MeterBuilder setInstrumentationVersion(String str) {
            return this;
        }

        @Override // io.opentelemetry.api.metrics.MeterBuilder
        public MeterBuilder setSchemaUrl(String str) {
            return this;
        }

        private NoopMeterBuilder() {
        }

        @Override // io.opentelemetry.api.metrics.MeterBuilder
        public Meter build() {
            return DefaultMeter.getInstance();
        }
    }
}
