package io.opentelemetry.sdk.trace;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.trace.data.EventData;
import io.opentelemetry.sdk.trace.data.LinkData;
import io.opentelemetry.sdk.trace.data.StatusData;
import java.util.List;

/* loaded from: classes6.dex */
final class AutoValue_SpanWrapper extends SpanWrapper {
    private final Attributes attributes;
    private final SdkSpan delegate;
    private final long endEpochNanos;
    private final boolean internalHasEnded;
    private final String name;
    private final List<EventData> resolvedEvents;
    private final List<LinkData> resolvedLinks;
    private final StatusData status;
    private final int totalAttributeCount;
    private final int totalRecordedEvents;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SpanWrapper(SdkSpan sdkSpan, List<LinkData> list, List<EventData> list2, Attributes attributes, int i, int i2, StatusData statusData, String str, long j, boolean z) {
        if (sdkSpan == null) {
            throw new NullPointerException("Null delegate");
        }
        this.delegate = sdkSpan;
        if (list == null) {
            throw new NullPointerException("Null resolvedLinks");
        }
        this.resolvedLinks = list;
        if (list2 == null) {
            throw new NullPointerException("Null resolvedEvents");
        }
        this.resolvedEvents = list2;
        if (attributes == null) {
            throw new NullPointerException("Null attributes");
        }
        this.attributes = attributes;
        this.totalAttributeCount = i;
        this.totalRecordedEvents = i2;
        if (statusData == null) {
            throw new NullPointerException("Null status");
        }
        this.status = statusData;
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.name = str;
        this.endEpochNanos = j;
        this.internalHasEnded = z;
    }

    @Override // io.opentelemetry.sdk.trace.SpanWrapper
    final SdkSpan delegate() {
        return this.delegate;
    }

    @Override // io.opentelemetry.sdk.trace.SpanWrapper
    final List<LinkData> resolvedLinks() {
        return this.resolvedLinks;
    }

    @Override // io.opentelemetry.sdk.trace.SpanWrapper
    final List<EventData> resolvedEvents() {
        return this.resolvedEvents;
    }

    @Override // io.opentelemetry.sdk.trace.SpanWrapper
    final Attributes attributes() {
        return this.attributes;
    }

    @Override // io.opentelemetry.sdk.trace.SpanWrapper
    final int totalAttributeCount() {
        return this.totalAttributeCount;
    }

    @Override // io.opentelemetry.sdk.trace.SpanWrapper
    final int totalRecordedEvents() {
        return this.totalRecordedEvents;
    }

    @Override // io.opentelemetry.sdk.trace.SpanWrapper
    final StatusData status() {
        return this.status;
    }

    @Override // io.opentelemetry.sdk.trace.SpanWrapper
    final String name() {
        return this.name;
    }

    @Override // io.opentelemetry.sdk.trace.SpanWrapper
    final long endEpochNanos() {
        return this.endEpochNanos;
    }

    @Override // io.opentelemetry.sdk.trace.SpanWrapper
    final boolean internalHasEnded() {
        return this.internalHasEnded;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SpanWrapper) {
            SpanWrapper spanWrapper = (SpanWrapper) obj;
            return this.delegate.equals(spanWrapper.delegate()) && this.resolvedLinks.equals(spanWrapper.resolvedLinks()) && this.resolvedEvents.equals(spanWrapper.resolvedEvents()) && this.attributes.equals(spanWrapper.attributes()) && this.totalAttributeCount == spanWrapper.totalAttributeCount() && this.totalRecordedEvents == spanWrapper.totalRecordedEvents() && this.status.equals(spanWrapper.status()) && this.name.equals(spanWrapper.name()) && this.endEpochNanos == spanWrapper.endEpochNanos() && this.internalHasEnded == spanWrapper.internalHasEnded();
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.delegate.hashCode();
        int hashCode2 = this.resolvedLinks.hashCode();
        int hashCode3 = this.resolvedEvents.hashCode();
        int hashCode4 = this.attributes.hashCode();
        int i = this.totalAttributeCount;
        int i2 = this.totalRecordedEvents;
        int hashCode5 = this.status.hashCode();
        int hashCode6 = this.name.hashCode();
        long j = this.endEpochNanos;
        return ((((((((((((((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ hashCode3) * 1000003) ^ hashCode4) * 1000003) ^ i) * 1000003) ^ i2) * 1000003) ^ hashCode5) * 1000003) ^ hashCode6) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ (this.internalHasEnded ? 1231 : 1237);
    }
}
