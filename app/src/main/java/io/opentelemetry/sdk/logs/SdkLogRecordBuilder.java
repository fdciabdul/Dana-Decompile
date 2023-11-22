package io.opentelemetry.sdk.logs;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.logs.EventBuilder;
import io.opentelemetry.api.logs.LogRecordBuilder;
import io.opentelemetry.api.logs.Severity;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.internal.AttributesMap;
import io.opentelemetry.sdk.logs.data.Body;
import io.opentelemetry.sdk.resources.Resource;
import j$.time.Instant;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
final class SdkLogRecordBuilder implements EventBuilder {
    @Nullable
    private AttributesMap attributes;
    private long epochNanos;
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final LogLimits logLimits;
    private final LoggerSharedState loggerSharedState;
    @Nullable
    private String severityText;
    private SpanContext spanContext = SpanContext.CC.getInvalid();
    private Severity severity = Severity.UNDEFINED_SEVERITY_NUMBER;
    private Body body = Body.CC.empty();

    @Override // io.opentelemetry.api.logs.LogRecordBuilder
    public final /* synthetic */ LogRecordBuilder setAllAttributes(Attributes attributes) {
        return LogRecordBuilder.CC.$default$setAllAttributes(this, attributes);
    }

    @Override // io.opentelemetry.api.logs.LogRecordBuilder
    public final /* bridge */ /* synthetic */ LogRecordBuilder setAttribute(AttributeKey attributeKey, Object obj) {
        return setAttribute((AttributeKey<AttributeKey>) attributeKey, (AttributeKey) obj);
    }

    public SdkLogRecordBuilder(LoggerSharedState loggerSharedState, InstrumentationScopeInfo instrumentationScopeInfo) {
        this.loggerSharedState = loggerSharedState;
        this.logLimits = loggerSharedState.getLogLimits();
        this.instrumentationScopeInfo = instrumentationScopeInfo;
    }

    @Override // io.opentelemetry.api.logs.LogRecordBuilder
    public final SdkLogRecordBuilder setEpoch(long j, TimeUnit timeUnit) {
        this.epochNanos = timeUnit.toNanos(j);
        return this;
    }

    @Override // io.opentelemetry.api.logs.LogRecordBuilder
    public final SdkLogRecordBuilder setEpoch(Instant instant) {
        this.epochNanos = TimeUnit.SECONDS.toNanos(instant.getEpochSecond()) + instant.getNano();
        return this;
    }

    @Override // io.opentelemetry.api.logs.LogRecordBuilder
    public final SdkLogRecordBuilder setContext(Context context) {
        this.spanContext = Span.CC.fromContext(context).getSpanContext();
        return this;
    }

    @Override // io.opentelemetry.api.logs.LogRecordBuilder
    public final SdkLogRecordBuilder setSeverity(Severity severity) {
        this.severity = severity;
        return this;
    }

    @Override // io.opentelemetry.api.logs.LogRecordBuilder
    public final SdkLogRecordBuilder setSeverityText(String str) {
        this.severityText = str;
        return this;
    }

    @Override // io.opentelemetry.api.logs.LogRecordBuilder
    public final SdkLogRecordBuilder setBody(String str) {
        this.body = Body.CC.string(str);
        return this;
    }

    @Override // io.opentelemetry.api.logs.LogRecordBuilder
    public final <T> SdkLogRecordBuilder setAttribute(AttributeKey<T> attributeKey, T t) {
        if (attributeKey != null && !attributeKey.getKey().isEmpty() && t != null) {
            if (this.attributes == null) {
                this.attributes = AttributesMap.create(this.logLimits.getMaxNumberOfAttributes(), this.logLimits.getMaxAttributeValueLength());
            }
            this.attributes.put((AttributeKey<AttributeKey<T>>) attributeKey, (AttributeKey<T>) t);
        }
        return this;
    }

    @Override // io.opentelemetry.api.logs.LogRecordBuilder
    public final void emit() {
        if (this.loggerSharedState.hasBeenShutdown()) {
            return;
        }
        LogRecordProcessor logRecordProcessor = this.loggerSharedState.getLogRecordProcessor();
        LogLimits logLimits = this.loggerSharedState.getLogLimits();
        Resource resource = this.loggerSharedState.getResource();
        InstrumentationScopeInfo instrumentationScopeInfo = this.instrumentationScopeInfo;
        long j = this.epochNanos;
        if (j == 0) {
            j = this.loggerSharedState.getClock().now();
        }
        logRecordProcessor.onEmit(SdkReadWriteLogRecord.create(logLimits, resource, instrumentationScopeInfo, j, this.spanContext, this.severity, this.severityText, this.body, this.attributes));
    }
}
