package io.opentelemetry.sdk.metrics;

import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.metrics.export.MetricReader;
import io.opentelemetry.sdk.metrics.internal.debug.SourceInfo;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import io.opentelemetry.sdk.metrics.internal.view.RegisteredView;
import io.opentelemetry.sdk.resources.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class SdkMeterProviderBuilder {
    private static final ExemplarFilter DEFAULT_EXEMPLAR_FILTER = ExemplarFilter.CC.sampleWithTraces();
    private Clock clock = Clock.CC.getDefault();
    private Resource resource = Resource.getDefault();
    private final List<MetricReader> metricReaders = new ArrayList();
    private final List<RegisteredView> registeredViews = new ArrayList();
    private ExemplarFilter exemplarFilter = DEFAULT_EXEMPLAR_FILTER;

    public final SdkMeterProviderBuilder setClock(Clock clock) {
        Objects.requireNonNull(clock, "clock");
        this.clock = clock;
        return this;
    }

    public final SdkMeterProviderBuilder setResource(Resource resource) {
        Objects.requireNonNull(resource, "resource");
        this.resource = resource;
        return this;
    }

    final SdkMeterProviderBuilder setExemplarFilter(ExemplarFilter exemplarFilter) {
        this.exemplarFilter = exemplarFilter;
        return this;
    }

    public final SdkMeterProviderBuilder registerView(InstrumentSelector instrumentSelector, View view) {
        Objects.requireNonNull(instrumentSelector, "selector");
        Objects.requireNonNull(view, "view");
        this.registeredViews.add(RegisteredView.create(instrumentSelector, view, view.getAttributesProcessor(), SourceInfo.CC.fromCurrentStack()));
        return this;
    }

    public final SdkMeterProviderBuilder registerMetricReader(MetricReader metricReader) {
        this.metricReaders.add(metricReader);
        return this;
    }

    public final SdkMeterProvider build() {
        return new SdkMeterProvider(this.registeredViews, this.metricReaders, this.clock, this.resource, this.exemplarFilter);
    }
}
