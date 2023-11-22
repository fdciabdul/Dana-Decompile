package io.opentelemetry.sdk.metrics;

import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory;
import io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import j$.util.function.Predicate;
import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public final class ViewBuilder {
    @Nullable
    private String description;
    @Nullable
    private String name;
    private Aggregation aggregation = Aggregation.CC.defaultAggregation();
    private AttributesProcessor processor = AttributesProcessor.noop();

    public final ViewBuilder setName(String str) {
        this.name = str;
        return this;
    }

    public final ViewBuilder setDescription(String str) {
        this.description = str;
        return this;
    }

    public final ViewBuilder setAggregation(Aggregation aggregation) {
        if (!(aggregation instanceof AggregatorFactory)) {
            throw new IllegalArgumentException("Custom Aggregation implementations are currently not supported. Use one of the standard implementations returned by the static factories in the Aggregation class.");
        }
        this.aggregation = aggregation;
        return this;
    }

    public final ViewBuilder setAttributeFilter(Predicate<String> predicate) {
        Objects.requireNonNull(predicate, "keyFilter");
        return addAttributesProcessor(AttributesProcessor.filterByKeyName(predicate));
    }

    final ViewBuilder addAttributesProcessor(AttributesProcessor attributesProcessor) {
        this.processor = this.processor.then(attributesProcessor);
        return this;
    }

    public final View build() {
        return View.create(this.name, this.description, this.aggregation, this.processor);
    }
}
