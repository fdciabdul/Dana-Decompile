package io.opentelemetry.sdk.trace.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class AutoValue_ImmutableLinkData extends ImmutableLinkData {
    private final Attributes attributes;
    private final SpanContext spanContext;
    private final int totalAttributeCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableLinkData(SpanContext spanContext, Attributes attributes, int i) {
        if (spanContext == null) {
            throw new NullPointerException("Null spanContext");
        }
        this.spanContext = spanContext;
        if (attributes == null) {
            throw new NullPointerException("Null attributes");
        }
        this.attributes = attributes;
        this.totalAttributeCount = i;
    }

    @Override // io.opentelemetry.sdk.trace.data.LinkData
    public final SpanContext getSpanContext() {
        return this.spanContext;
    }

    @Override // io.opentelemetry.sdk.trace.data.LinkData
    public final Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.opentelemetry.sdk.trace.data.LinkData
    public final int getTotalAttributeCount() {
        return this.totalAttributeCount;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableLinkData{spanContext=");
        sb.append(this.spanContext);
        sb.append(", attributes=");
        sb.append(this.attributes);
        sb.append(", totalAttributeCount=");
        sb.append(this.totalAttributeCount);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableLinkData) {
            ImmutableLinkData immutableLinkData = (ImmutableLinkData) obj;
            return this.spanContext.equals(immutableLinkData.getSpanContext()) && this.attributes.equals(immutableLinkData.getAttributes()) && this.totalAttributeCount == immutableLinkData.getTotalAttributeCount();
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.spanContext.hashCode() ^ 1000003) * 1000003) ^ this.attributes.hashCode()) * 1000003) ^ this.totalAttributeCount;
    }
}
