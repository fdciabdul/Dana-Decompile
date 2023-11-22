package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.Data;
import io.opentelemetry.sdk.metrics.data.MetricDataType;
import io.opentelemetry.sdk.resources.Resource;

/* loaded from: classes9.dex */
final class AutoValue_ImmutableMetricData extends ImmutableMetricData {
    private final Data<?> data;
    private final String description;
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final String name;
    private final Resource resource;
    private final MetricDataType type;
    private final String unit;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, String str, String str2, String str3, MetricDataType metricDataType, Data<?> data) {
        if (resource == null) {
            throw new NullPointerException("Null resource");
        }
        this.resource = resource;
        if (instrumentationScopeInfo == null) {
            throw new NullPointerException("Null instrumentationScopeInfo");
        }
        this.instrumentationScopeInfo = instrumentationScopeInfo;
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.name = str;
        if (str2 == null) {
            throw new NullPointerException("Null description");
        }
        this.description = str2;
        if (str3 == null) {
            throw new NullPointerException("Null unit");
        }
        this.unit = str3;
        if (metricDataType == null) {
            throw new NullPointerException("Null type");
        }
        this.type = metricDataType;
        if (data == null) {
            throw new NullPointerException("Null data");
        }
        this.data = data;
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final Resource getResource() {
        return this.resource;
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final InstrumentationScopeInfo getInstrumentationScopeInfo() {
        return this.instrumentationScopeInfo;
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final String getName() {
        return this.name;
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final String getDescription() {
        return this.description;
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final String getUnit() {
        return this.unit;
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final MetricDataType getType() {
        return this.type;
    }

    @Override // io.opentelemetry.sdk.metrics.data.MetricData
    public final Data<?> getData() {
        return this.data;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableMetricData{resource=");
        sb.append(this.resource);
        sb.append(", instrumentationScopeInfo=");
        sb.append(this.instrumentationScopeInfo);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", unit=");
        sb.append(this.unit);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", data=");
        sb.append(this.data);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableMetricData) {
            ImmutableMetricData immutableMetricData = (ImmutableMetricData) obj;
            return this.resource.equals(immutableMetricData.getResource()) && this.instrumentationScopeInfo.equals(immutableMetricData.getInstrumentationScopeInfo()) && this.name.equals(immutableMetricData.getName()) && this.description.equals(immutableMetricData.getDescription()) && this.unit.equals(immutableMetricData.getUnit()) && this.type.equals(immutableMetricData.getType()) && this.data.equals(immutableMetricData.getData());
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.resource.hashCode();
        int hashCode2 = this.instrumentationScopeInfo.hashCode();
        int hashCode3 = this.name.hashCode();
        int hashCode4 = this.description.hashCode();
        return ((((((((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ hashCode3) * 1000003) ^ hashCode4) * 1000003) ^ this.unit.hashCode()) * 1000003) ^ this.type.hashCode()) * 1000003) ^ this.data.hashCode();
    }
}
