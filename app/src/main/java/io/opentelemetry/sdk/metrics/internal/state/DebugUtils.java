package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;

/* loaded from: classes6.dex */
public final class DebugUtils {
    private DebugUtils() {
    }

    public static String duplicateMetricErrorMessage(MetricDescriptor metricDescriptor, MetricDescriptor metricDescriptor2) {
        StringBuilder sb = new StringBuilder("Found duplicate metric definition: ");
        sb.append(metricDescriptor.getName());
        sb.append("\n");
        if (!metricDescriptor2.getName().equals(metricDescriptor2.getSourceInstrument().getName())) {
            sb.append("\tVIEW defined\n");
            sb.append(metricDescriptor2.getViewSourceInfo().multiLineDebugString());
            sb.append("\tFROM instrument ");
            sb.append(metricDescriptor2.getSourceInstrument().getName());
            sb.append("\n");
            sb.append(metricDescriptor2.getSourceInstrument().getSourceInfo().multiLineDebugString());
        } else {
            sb.append(metricDescriptor2.getSourceInstrument().getSourceInfo().multiLineDebugString());
            sb.append("\n");
        }
        sb.append("Causes\n");
        if (!metricDescriptor.getName().equals(metricDescriptor2.getName())) {
            sb.append("- Name [");
            sb.append(metricDescriptor2.getName());
            sb.append("] does not match [");
            sb.append(metricDescriptor.getName());
            sb.append("]\n");
        }
        if (!metricDescriptor.getDescription().equals(metricDescriptor2.getDescription())) {
            sb.append("- Description [");
            sb.append(metricDescriptor2.getDescription());
            sb.append("] does not match [");
            sb.append(metricDescriptor.getDescription());
            sb.append("]\n");
        }
        if (!metricDescriptor.getAggregationName().equals(metricDescriptor2.getAggregationName())) {
            sb.append("- Aggregation [");
            sb.append(metricDescriptor2.getAggregationName());
            sb.append("] does not match [");
            sb.append(metricDescriptor.getAggregationName());
            sb.append("]\n");
        }
        if (!metricDescriptor.getSourceInstrument().getName().equals(metricDescriptor2.getSourceInstrument().getName())) {
            sb.append("- InstrumentName [");
            sb.append(metricDescriptor2.getSourceInstrument().getName());
            sb.append("] does not match [");
            sb.append(metricDescriptor.getSourceInstrument().getName());
            sb.append("]\n");
        }
        if (!metricDescriptor.getSourceInstrument().getDescription().equals(metricDescriptor2.getSourceInstrument().getDescription())) {
            sb.append("- InstrumentDescription [");
            sb.append(metricDescriptor2.getSourceInstrument().getDescription());
            sb.append("] does not match [");
            sb.append(metricDescriptor.getSourceInstrument().getDescription());
            sb.append("]\n");
        }
        if (!metricDescriptor.getSourceInstrument().getUnit().equals(metricDescriptor2.getSourceInstrument().getUnit())) {
            sb.append("- InstrumentUnit [");
            sb.append(metricDescriptor2.getSourceInstrument().getUnit());
            sb.append("] does not match [");
            sb.append(metricDescriptor.getSourceInstrument().getUnit());
            sb.append("]\n");
        }
        if (!metricDescriptor.getSourceInstrument().getType().equals(metricDescriptor2.getSourceInstrument().getType())) {
            sb.append("- InstrumentType [");
            sb.append(metricDescriptor2.getSourceInstrument().getType());
            sb.append("] does not match [");
            sb.append(metricDescriptor.getSourceInstrument().getType());
            sb.append("]\n");
        }
        if (!metricDescriptor.getSourceInstrument().getValueType().equals(metricDescriptor2.getSourceInstrument().getValueType())) {
            sb.append("- InstrumentValueType [");
            sb.append(metricDescriptor2.getSourceInstrument().getValueType());
            sb.append("] does not match [");
            sb.append(metricDescriptor.getSourceInstrument().getValueType());
            sb.append("]\n");
        }
        if (metricDescriptor.getName().equals(metricDescriptor.getSourceInstrument().getName())) {
            sb.append("Original instrument registered with same name but is incompatible.\n");
            sb.append(metricDescriptor.getSourceInstrument().getSourceInfo().multiLineDebugString());
            sb.append("\n");
        } else {
            sb.append("Conflicting view registered.\n");
            sb.append(metricDescriptor.getViewSourceInfo().multiLineDebugString());
            sb.append("FROM instrument ");
            sb.append(metricDescriptor.getSourceInstrument().getName());
            sb.append("\n");
            sb.append(metricDescriptor.getSourceInstrument().getSourceInfo().multiLineDebugString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
