package io.opentelemetry.sdk.trace.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.sdk.common.InstrumentationLibraryInfo;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.resources.Resource;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public abstract class DelegatingSpanData implements SpanData {
    private final SpanData delegate;

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public /* synthetic */ String getParentSpanId() {
        String spanId;
        spanId = getParentSpanContext().getSpanId();
        return spanId;
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public /* synthetic */ String getSpanId() {
        String spanId;
        spanId = getSpanContext().getSpanId();
        return spanId;
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public /* synthetic */ String getTraceId() {
        String traceId;
        traceId = getSpanContext().getTraceId();
        return traceId;
    }

    public DelegatingSpanData(SpanData spanData) {
        this.delegate = (SpanData) Objects.requireNonNull(spanData, "delegate");
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public SpanContext getSpanContext() {
        return this.delegate.getSpanContext();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public SpanContext getParentSpanContext() {
        return this.delegate.getParentSpanContext();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public Resource getResource() {
        return this.delegate.getResource();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    @Deprecated
    public InstrumentationLibraryInfo getInstrumentationLibraryInfo() {
        return this.delegate.getInstrumentationLibraryInfo();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public InstrumentationScopeInfo getInstrumentationScopeInfo() {
        return this.delegate.getInstrumentationScopeInfo();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public String getName() {
        return this.delegate.getName();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public SpanKind getKind() {
        return this.delegate.getKind();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public long getStartEpochNanos() {
        return this.delegate.getStartEpochNanos();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public Attributes getAttributes() {
        return this.delegate.getAttributes();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public List<EventData> getEvents() {
        return this.delegate.getEvents();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public List<LinkData> getLinks() {
        return this.delegate.getLinks();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public StatusData getStatus() {
        return this.delegate.getStatus();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public long getEndEpochNanos() {
        return this.delegate.getEndEpochNanos();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public boolean hasEnded() {
        return this.delegate.hasEnded();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public int getTotalRecordedEvents() {
        return this.delegate.getTotalRecordedEvents();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public int getTotalRecordedLinks() {
        return this.delegate.getTotalRecordedLinks();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public int getTotalAttributeCount() {
        return this.delegate.getTotalAttributeCount();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SpanData) {
            SpanData spanData = (SpanData) obj;
            return getSpanContext().equals(spanData.getSpanContext()) && getParentSpanContext().equals(spanData.getParentSpanContext()) && getResource().equals(spanData.getResource()) && getInstrumentationScopeInfo().equals(spanData.getInstrumentationScopeInfo()) && getName().equals(spanData.getName()) && getKind().equals(spanData.getKind()) && getStartEpochNanos() == spanData.getStartEpochNanos() && getAttributes().equals(spanData.getAttributes()) && getEvents().equals(spanData.getEvents()) && getLinks().equals(spanData.getLinks()) && getStatus().equals(spanData.getStatus()) && getEndEpochNanos() == spanData.getEndEpochNanos() && hasEnded() == spanData.hasEnded() && getTotalRecordedEvents() == spanData.getTotalRecordedEvents() && getTotalRecordedLinks() == spanData.getTotalRecordedLinks() && getTotalAttributeCount() == spanData.getTotalAttributeCount();
        }
        return false;
    }

    public int hashCode() {
        int hashCode = getSpanContext().hashCode();
        int hashCode2 = getParentSpanContext().hashCode();
        int hashCode3 = getResource().hashCode();
        int hashCode4 = getInstrumentationScopeInfo().hashCode();
        int hashCode5 = getName().hashCode();
        int hashCode6 = getKind().hashCode();
        int startEpochNanos = (int) ((getStartEpochNanos() >>> 32) ^ getStartEpochNanos());
        int hashCode7 = getAttributes().hashCode();
        int hashCode8 = getEvents().hashCode();
        int hashCode9 = getLinks().hashCode();
        int hashCode10 = getStatus().hashCode();
        int endEpochNanos = (int) ((getEndEpochNanos() >>> 32) ^ getEndEpochNanos());
        return ((((((((((((((((((((((((((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ hashCode3) * 1000003) ^ hashCode4) * 1000003) ^ hashCode5) * 1000003) ^ hashCode6) * 1000003) ^ startEpochNanos) * 1000003) ^ hashCode7) * 1000003) ^ hashCode8) * 1000003) ^ hashCode9) * 1000003) ^ hashCode10) * 1000003) ^ endEpochNanos) * 1000003) ^ (hasEnded() ? 1231 : 1237)) * 1000003) ^ getTotalRecordedEvents()) * 1000003) ^ getTotalRecordedLinks()) * 1000003) ^ getTotalAttributeCount();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DelegatingSpanData{spanContext=");
        sb.append(getSpanContext());
        sb.append(", parentSpanContext=");
        sb.append(getParentSpanContext());
        sb.append(", resource=");
        sb.append(getResource());
        sb.append(", instrumentationScopeInfo=");
        sb.append(getInstrumentationScopeInfo());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", kind=");
        sb.append(getKind());
        sb.append(", startEpochNanos=");
        sb.append(getStartEpochNanos());
        sb.append(", attributes=");
        sb.append(getAttributes());
        sb.append(", events=");
        sb.append(getEvents());
        sb.append(", links=");
        sb.append(getLinks());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", endEpochNanos=");
        sb.append(getEndEpochNanos());
        sb.append(", hasEnded=");
        sb.append(hasEnded());
        sb.append(", totalRecordedEvents=");
        sb.append(getTotalRecordedEvents());
        sb.append(", totalRecordedLinks=");
        sb.append(getTotalRecordedLinks());
        sb.append(", totalAttributeCount=");
        sb.append(getTotalAttributeCount());
        sb.append("}");
        return sb.toString();
    }
}
