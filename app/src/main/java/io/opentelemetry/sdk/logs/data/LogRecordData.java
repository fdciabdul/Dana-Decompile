package io.opentelemetry.sdk.logs.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.logs.Severity;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.resources.Resource;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public interface LogRecordData {
    Attributes getAttributes();

    Body getBody();

    long getEpochNanos();

    InstrumentationScopeInfo getInstrumentationScopeInfo();

    Resource getResource();

    Severity getSeverity();

    @Nullable
    String getSeverityText();

    SpanContext getSpanContext();

    int getTotalAttributeCount();
}
