package io.opentelemetry.sdk.trace;

import io.opentelemetry.sdk.trace.SpanLimits;

/* loaded from: classes.dex */
final class AutoValue_SpanLimits_SpanLimitsValue extends SpanLimits.SpanLimitsValue {
    private final int maxAttributeValueLength;
    private final int maxNumberOfAttributes;
    private final int maxNumberOfAttributesPerEvent;
    private final int maxNumberOfAttributesPerLink;
    private final int maxNumberOfEvents;
    private final int maxNumberOfLinks;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SpanLimits_SpanLimitsValue(int i, int i2, int i3, int i4, int i5, int i6) {
        this.maxNumberOfAttributes = i;
        this.maxNumberOfEvents = i2;
        this.maxNumberOfLinks = i3;
        this.maxNumberOfAttributesPerEvent = i4;
        this.maxNumberOfAttributesPerLink = i5;
        this.maxAttributeValueLength = i6;
    }

    @Override // io.opentelemetry.sdk.trace.SpanLimits
    public final int getMaxNumberOfAttributes() {
        return this.maxNumberOfAttributes;
    }

    @Override // io.opentelemetry.sdk.trace.SpanLimits
    public final int getMaxNumberOfEvents() {
        return this.maxNumberOfEvents;
    }

    @Override // io.opentelemetry.sdk.trace.SpanLimits
    public final int getMaxNumberOfLinks() {
        return this.maxNumberOfLinks;
    }

    @Override // io.opentelemetry.sdk.trace.SpanLimits
    public final int getMaxNumberOfAttributesPerEvent() {
        return this.maxNumberOfAttributesPerEvent;
    }

    @Override // io.opentelemetry.sdk.trace.SpanLimits
    public final int getMaxNumberOfAttributesPerLink() {
        return this.maxNumberOfAttributesPerLink;
    }

    @Override // io.opentelemetry.sdk.trace.SpanLimits.SpanLimitsValue, io.opentelemetry.sdk.trace.SpanLimits
    public final int getMaxAttributeValueLength() {
        return this.maxAttributeValueLength;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SpanLimitsValue{maxNumberOfAttributes=");
        sb.append(this.maxNumberOfAttributes);
        sb.append(", maxNumberOfEvents=");
        sb.append(this.maxNumberOfEvents);
        sb.append(", maxNumberOfLinks=");
        sb.append(this.maxNumberOfLinks);
        sb.append(", maxNumberOfAttributesPerEvent=");
        sb.append(this.maxNumberOfAttributesPerEvent);
        sb.append(", maxNumberOfAttributesPerLink=");
        sb.append(this.maxNumberOfAttributesPerLink);
        sb.append(", maxAttributeValueLength=");
        sb.append(this.maxAttributeValueLength);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SpanLimits.SpanLimitsValue) {
            SpanLimits.SpanLimitsValue spanLimitsValue = (SpanLimits.SpanLimitsValue) obj;
            return this.maxNumberOfAttributes == spanLimitsValue.getMaxNumberOfAttributes() && this.maxNumberOfEvents == spanLimitsValue.getMaxNumberOfEvents() && this.maxNumberOfLinks == spanLimitsValue.getMaxNumberOfLinks() && this.maxNumberOfAttributesPerEvent == spanLimitsValue.getMaxNumberOfAttributesPerEvent() && this.maxNumberOfAttributesPerLink == spanLimitsValue.getMaxNumberOfAttributesPerLink() && this.maxAttributeValueLength == spanLimitsValue.getMaxAttributeValueLength();
        }
        return false;
    }

    public final int hashCode() {
        int i = this.maxNumberOfAttributes;
        int i2 = this.maxNumberOfEvents;
        int i3 = this.maxNumberOfLinks;
        return ((((((((((i ^ 1000003) * 1000003) ^ i2) * 1000003) ^ i3) * 1000003) ^ this.maxNumberOfAttributesPerEvent) * 1000003) ^ this.maxNumberOfAttributesPerLink) * 1000003) ^ this.maxAttributeValueLength;
    }
}
