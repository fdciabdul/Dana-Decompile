package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.data.LongExemplarData;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class AutoValue_ImmutableLongPointData extends ImmutableLongPointData {
    private final Attributes attributes;
    private final long epochNanos;
    private final List<LongExemplarData> exemplars;
    private final long startEpochNanos;
    private final long value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableLongPointData(long j, long j2, Attributes attributes, long j3, List<LongExemplarData> list) {
        this.startEpochNanos = j;
        this.epochNanos = j2;
        if (attributes == null) {
            throw new NullPointerException("Null attributes");
        }
        this.attributes = attributes;
        this.value = j3;
        if (list == null) {
            throw new NullPointerException("Null exemplars");
        }
        this.exemplars = list;
    }

    @Override // io.opentelemetry.sdk.metrics.data.PointData
    public final long getStartEpochNanos() {
        return this.startEpochNanos;
    }

    @Override // io.opentelemetry.sdk.metrics.data.PointData
    public final long getEpochNanos() {
        return this.epochNanos;
    }

    @Override // io.opentelemetry.sdk.metrics.data.PointData
    public final Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.opentelemetry.sdk.metrics.data.LongPointData
    public final long getValue() {
        return this.value;
    }

    @Override // io.opentelemetry.sdk.metrics.data.LongPointData, io.opentelemetry.sdk.metrics.data.PointData
    public final List<LongExemplarData> getExemplars() {
        return this.exemplars;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableLongPointData{startEpochNanos=");
        sb.append(this.startEpochNanos);
        sb.append(", epochNanos=");
        sb.append(this.epochNanos);
        sb.append(", attributes=");
        sb.append(this.attributes);
        sb.append(", value=");
        sb.append(this.value);
        sb.append(", exemplars=");
        sb.append(this.exemplars);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableLongPointData) {
            ImmutableLongPointData immutableLongPointData = (ImmutableLongPointData) obj;
            return this.startEpochNanos == immutableLongPointData.getStartEpochNanos() && this.epochNanos == immutableLongPointData.getEpochNanos() && this.attributes.equals(immutableLongPointData.getAttributes()) && this.value == immutableLongPointData.getValue() && this.exemplars.equals(immutableLongPointData.getExemplars());
        }
        return false;
    }

    public final int hashCode() {
        long j = this.startEpochNanos;
        int i = (int) (j ^ (j >>> 32));
        long j2 = this.epochNanos;
        int i2 = (int) (j2 ^ (j2 >>> 32));
        int hashCode = this.attributes.hashCode();
        long j3 = this.value;
        return ((((((i2 ^ ((i ^ 1000003) * 1000003)) * 1000003) ^ hashCode) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.exemplars.hashCode();
    }
}
