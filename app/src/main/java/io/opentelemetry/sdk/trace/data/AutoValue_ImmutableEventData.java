package io.opentelemetry.sdk.trace.data;

import io.opentelemetry.api.common.Attributes;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class AutoValue_ImmutableEventData extends ImmutableEventData {
    private final Attributes attributes;
    private final long epochNanos;
    private final String name;
    private final int totalAttributeCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableEventData(String str, Attributes attributes, long j, int i) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.name = str;
        if (attributes == null) {
            throw new NullPointerException("Null attributes");
        }
        this.attributes = attributes;
        this.epochNanos = j;
        this.totalAttributeCount = i;
    }

    @Override // io.opentelemetry.sdk.trace.data.EventData
    public final String getName() {
        return this.name;
    }

    @Override // io.opentelemetry.sdk.trace.data.EventData
    public final Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.opentelemetry.sdk.trace.data.EventData
    public final long getEpochNanos() {
        return this.epochNanos;
    }

    @Override // io.opentelemetry.sdk.trace.data.EventData
    public final int getTotalAttributeCount() {
        return this.totalAttributeCount;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableEventData{name=");
        sb.append(this.name);
        sb.append(", attributes=");
        sb.append(this.attributes);
        sb.append(", epochNanos=");
        sb.append(this.epochNanos);
        sb.append(", totalAttributeCount=");
        sb.append(this.totalAttributeCount);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEventData) {
            ImmutableEventData immutableEventData = (ImmutableEventData) obj;
            return this.name.equals(immutableEventData.getName()) && this.attributes.equals(immutableEventData.getAttributes()) && this.epochNanos == immutableEventData.getEpochNanos() && this.totalAttributeCount == immutableEventData.getTotalAttributeCount();
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.name.hashCode();
        int hashCode2 = this.attributes.hashCode();
        long j = this.epochNanos;
        return ((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.totalAttributeCount;
    }
}
