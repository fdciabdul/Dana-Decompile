package io.opentelemetry.sdk.trace;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.sdk.common.InstrumentationLibraryInfo;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.trace.data.SpanData;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public interface ReadableSpan {
    @Nullable
    <T> T getAttribute(AttributeKey<T> attributeKey);

    @Deprecated
    InstrumentationLibraryInfo getInstrumentationLibraryInfo();

    InstrumentationScopeInfo getInstrumentationScopeInfo();

    SpanKind getKind();

    long getLatencyNanos();

    String getName();

    SpanContext getParentSpanContext();

    SpanContext getSpanContext();

    boolean hasEnded();

    SpanData toSpanData();

    /* renamed from: io.opentelemetry.sdk.trace.ReadableSpan$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
    }
}
