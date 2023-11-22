package io.opentelemetry.sdk.metrics.internal.descriptor;

import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.InstrumentValueType;
import io.opentelemetry.sdk.metrics.View;
import io.opentelemetry.sdk.metrics.internal.aggregator.AggregationUtil;
import io.opentelemetry.sdk.metrics.internal.debug.SourceInfo;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public abstract class MetricDescriptor {
    private final AtomicReference<SourceInfo> viewSourceInfo = new AtomicReference<>();

    public abstract String getDescription();

    public abstract String getName();

    public abstract InstrumentDescriptor getSourceInstrument();

    public abstract View getView();

    public abstract int hashCode();

    public static MetricDescriptor create(String str, String str2, String str3) {
        return create(View.builder().build(), SourceInfo.CC.fromCurrentStack(), InstrumentDescriptor.create(str, str2, str3, InstrumentType.OBSERVABLE_GAUGE, InstrumentValueType.DOUBLE));
    }

    public static MetricDescriptor create(View view, SourceInfo sourceInfo, InstrumentDescriptor instrumentDescriptor) {
        AutoValue_MetricDescriptor autoValue_MetricDescriptor = new AutoValue_MetricDescriptor(view.getName() == null ? instrumentDescriptor.getName() : view.getName(), view.getDescription() == null ? instrumentDescriptor.getDescription() : view.getDescription(), view, instrumentDescriptor);
        ((MetricDescriptor) autoValue_MetricDescriptor).viewSourceInfo.set(sourceInfo);
        return autoValue_MetricDescriptor;
    }

    public final SourceInfo getViewSourceInfo() {
        SourceInfo sourceInfo = this.viewSourceInfo.get();
        return sourceInfo == null ? SourceInfo.CC.noSourceInfo() : sourceInfo;
    }

    public String getAggregationName() {
        return AggregationUtil.aggregationName(getView().getAggregation());
    }

    public boolean isCompatibleWith(MetricDescriptor metricDescriptor) {
        return getName().equals(metricDescriptor.getName()) && getDescription().equals(metricDescriptor.getDescription()) && getAggregationName().equals(metricDescriptor.getAggregationName()) && getSourceInstrument().getName().equals(metricDescriptor.getSourceInstrument().getName()) && getSourceInstrument().getDescription().equals(metricDescriptor.getSourceInstrument().getDescription()) && getSourceInstrument().getUnit().equals(metricDescriptor.getSourceInstrument().getUnit()) && getSourceInstrument().getType().equals(metricDescriptor.getSourceInstrument().getType()) && getSourceInstrument().getValueType().equals(metricDescriptor.getSourceInstrument().getValueType());
    }
}
