package io.opentelemetry.sdk.trace.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.sdk.common.InstrumentationLibraryInfo;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.resources.Resource;
import java.util.List;

/* loaded from: classes6.dex */
public interface SpanData {
    Attributes getAttributes();

    long getEndEpochNanos();

    List<EventData> getEvents();

    @Deprecated
    InstrumentationLibraryInfo getInstrumentationLibraryInfo();

    InstrumentationScopeInfo getInstrumentationScopeInfo();

    SpanKind getKind();

    List<LinkData> getLinks();

    String getName();

    SpanContext getParentSpanContext();

    String getParentSpanId();

    Resource getResource();

    SpanContext getSpanContext();

    String getSpanId();

    long getStartEpochNanos();

    StatusData getStatus();

    int getTotalAttributeCount();

    int getTotalRecordedEvents();

    int getTotalRecordedLinks();

    String getTraceId();

    boolean hasEnded();

    /* renamed from: io.opentelemetry.sdk.trace.data.SpanData$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
    }
}
