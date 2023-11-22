package io.opentelemetry.sdk.trace;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.sdk.common.InstrumentationLibraryInfo;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.internal.InstrumentationScopeUtil;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.data.EventData;
import io.opentelemetry.sdk.trace.data.LinkData;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.data.StatusData;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class SpanWrapper implements SpanData {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Attributes attributes();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract SdkSpan delegate();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long endEpochNanos();

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

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean internalHasEnded();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String name();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract List<EventData> resolvedEvents();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract List<LinkData> resolvedLinks();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract StatusData status();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int totalAttributeCount();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int totalRecordedEvents();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpanWrapper create(SdkSpan sdkSpan, List<LinkData> list, List<EventData> list2, Attributes attributes, int i, int i2, StatusData statusData, String str, long j, boolean z) {
        return new AutoValue_SpanWrapper(sdkSpan, list, list2, attributes, i, i2, statusData, str, j, z);
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public SpanContext getSpanContext() {
        return delegate().getSpanContext();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public SpanContext getParentSpanContext() {
        return delegate().getParentSpanContext();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public Resource getResource() {
        return delegate().getResource();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    @Deprecated
    public InstrumentationLibraryInfo getInstrumentationLibraryInfo() {
        return InstrumentationScopeUtil.toInstrumentationLibraryInfo(delegate().getInstrumentationScopeInfo());
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public InstrumentationScopeInfo getInstrumentationScopeInfo() {
        return delegate().getInstrumentationScopeInfo();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public String getName() {
        return name();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public SpanKind getKind() {
        return delegate().getKind();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public long getStartEpochNanos() {
        return delegate().getStartEpochNanos();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public Attributes getAttributes() {
        return attributes();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public List<EventData> getEvents() {
        return resolvedEvents();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public List<LinkData> getLinks() {
        return resolvedLinks();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public StatusData getStatus() {
        return status();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public long getEndEpochNanos() {
        return endEpochNanos();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public boolean hasEnded() {
        return internalHasEnded();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public int getTotalRecordedEvents() {
        return totalRecordedEvents();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public int getTotalRecordedLinks() {
        return delegate().getTotalRecordedLinks();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public int getTotalAttributeCount() {
        return totalAttributeCount();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SpanData{spanContext=");
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
        sb.append(", endEpochNanos=");
        sb.append(getEndEpochNanos());
        sb.append(", attributes=");
        sb.append(getAttributes());
        sb.append(", totalAttributeCount=");
        sb.append(getTotalAttributeCount());
        sb.append(", events=");
        sb.append(getEvents());
        sb.append(", totalRecordedEvents=");
        sb.append(getTotalRecordedEvents());
        sb.append(", links=");
        sb.append(getLinks());
        sb.append(", totalRecordedLinks=");
        sb.append(getTotalRecordedLinks());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", hasEnded=");
        sb.append(hasEnded());
        sb.append("}");
        return sb.toString();
    }
}
