package io.opentelemetry.sdk.logs;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.logs.Severity;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.internal.AttributesMap;
import io.opentelemetry.sdk.logs.data.Body;
import io.opentelemetry.sdk.logs.data.LogRecordData;
import io.opentelemetry.sdk.resources.Resource;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
class SdkReadWriteLogRecord implements ReadWriteLogRecord {
    @Nullable
    private AttributesMap attributes;
    private final Body body;
    private final long epochNanos;
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final Object lock = new Object();
    private final LogLimits logLimits;
    private final Resource resource;
    private final Severity severity;
    @Nullable
    private final String severityText;
    private final SpanContext spanContext;

    private SdkReadWriteLogRecord(LogLimits logLimits, Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, long j, SpanContext spanContext, Severity severity, @Nullable String str, Body body, @Nullable AttributesMap attributesMap) {
        this.logLimits = logLimits;
        this.resource = resource;
        this.instrumentationScopeInfo = instrumentationScopeInfo;
        this.epochNanos = j;
        this.spanContext = spanContext;
        this.severity = severity;
        this.severityText = str;
        this.body = body;
        this.attributes = attributesMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SdkReadWriteLogRecord create(LogLimits logLimits, Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, long j, SpanContext spanContext, Severity severity, @Nullable String str, Body body, @Nullable AttributesMap attributesMap) {
        return new SdkReadWriteLogRecord(logLimits, resource, instrumentationScopeInfo, j, spanContext, severity, str, body, attributesMap);
    }

    @Override // io.opentelemetry.sdk.logs.ReadWriteLogRecord
    public <T> ReadWriteLogRecord setAttribute(AttributeKey<T> attributeKey, T t) {
        if (attributeKey == null || attributeKey.getKey().isEmpty() || t == null) {
            return this;
        }
        synchronized (this.lock) {
            if (this.attributes == null) {
                this.attributes = AttributesMap.create(this.logLimits.getMaxNumberOfAttributes(), this.logLimits.getMaxAttributeValueLength());
            }
            this.attributes.put((AttributeKey<AttributeKey<T>>) attributeKey, (AttributeKey<T>) t);
        }
        return this;
    }

    private Attributes getImmutableAttributes() {
        synchronized (this.lock) {
            AttributesMap attributesMap = this.attributes;
            if (attributesMap != null && !attributesMap.isEmpty()) {
                return this.attributes.immutableCopy();
            }
            return Attributes.CC.empty();
        }
    }

    @Override // io.opentelemetry.sdk.logs.ReadWriteLogRecord
    public LogRecordData toLogRecordData() {
        SdkLogRecordData create;
        synchronized (this.lock) {
            Resource resource = this.resource;
            InstrumentationScopeInfo instrumentationScopeInfo = this.instrumentationScopeInfo;
            long j = this.epochNanos;
            SpanContext spanContext = this.spanContext;
            Severity severity = this.severity;
            String str = this.severityText;
            Body body = this.body;
            Attributes immutableAttributes = getImmutableAttributes();
            AttributesMap attributesMap = this.attributes;
            create = SdkLogRecordData.create(resource, instrumentationScopeInfo, j, spanContext, severity, str, body, immutableAttributes, attributesMap == null ? 0 : attributesMap.getTotalAddedValues());
        }
        return create;
    }
}
