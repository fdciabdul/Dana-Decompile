package io.opentelemetry.sdk.logs;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.logs.Severity;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.logs.data.Body;
import io.opentelemetry.sdk.logs.data.LogRecordData;
import io.opentelemetry.sdk.resources.Resource;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public abstract class SdkLogRecordData implements LogRecordData {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static SdkLogRecordData create(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, long j, SpanContext spanContext, Severity severity, @Nullable String str, Body body, Attributes attributes, int i) {
        return new AutoValue_SdkLogRecordData(resource, instrumentationScopeInfo, j, spanContext, severity, str, body, attributes, i);
    }
}
