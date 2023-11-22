package io.opentelemetry.sdk.logs;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.logs.Severity;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.logs.data.Body;
import io.opentelemetry.sdk.resources.Resource;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
final class AutoValue_SdkLogRecordData extends SdkLogRecordData {
    private final Attributes attributes;
    private final Body body;
    private final long epochNanos;
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final Resource resource;
    private final Severity severity;
    private final String severityText;
    private final SpanContext spanContext;
    private final int totalAttributeCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SdkLogRecordData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, long j, SpanContext spanContext, Severity severity, @Nullable String str, Body body, Attributes attributes, int i) {
        if (resource == null) {
            throw new NullPointerException("Null resource");
        }
        this.resource = resource;
        if (instrumentationScopeInfo == null) {
            throw new NullPointerException("Null instrumentationScopeInfo");
        }
        this.instrumentationScopeInfo = instrumentationScopeInfo;
        this.epochNanos = j;
        if (spanContext == null) {
            throw new NullPointerException("Null spanContext");
        }
        this.spanContext = spanContext;
        if (severity == null) {
            throw new NullPointerException("Null severity");
        }
        this.severity = severity;
        this.severityText = str;
        if (body == null) {
            throw new NullPointerException("Null body");
        }
        this.body = body;
        if (attributes == null) {
            throw new NullPointerException("Null attributes");
        }
        this.attributes = attributes;
        this.totalAttributeCount = i;
    }

    @Override // io.opentelemetry.sdk.logs.data.LogRecordData
    public final Resource getResource() {
        return this.resource;
    }

    @Override // io.opentelemetry.sdk.logs.data.LogRecordData
    public final InstrumentationScopeInfo getInstrumentationScopeInfo() {
        return this.instrumentationScopeInfo;
    }

    @Override // io.opentelemetry.sdk.logs.data.LogRecordData
    public final long getEpochNanos() {
        return this.epochNanos;
    }

    @Override // io.opentelemetry.sdk.logs.data.LogRecordData
    public final SpanContext getSpanContext() {
        return this.spanContext;
    }

    @Override // io.opentelemetry.sdk.logs.data.LogRecordData
    public final Severity getSeverity() {
        return this.severity;
    }

    @Override // io.opentelemetry.sdk.logs.data.LogRecordData
    @Nullable
    public final String getSeverityText() {
        return this.severityText;
    }

    @Override // io.opentelemetry.sdk.logs.data.LogRecordData
    public final Body getBody() {
        return this.body;
    }

    @Override // io.opentelemetry.sdk.logs.data.LogRecordData
    public final Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.opentelemetry.sdk.logs.data.LogRecordData
    public final int getTotalAttributeCount() {
        return this.totalAttributeCount;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SdkLogRecordData{resource=");
        sb.append(this.resource);
        sb.append(", instrumentationScopeInfo=");
        sb.append(this.instrumentationScopeInfo);
        sb.append(", epochNanos=");
        sb.append(this.epochNanos);
        sb.append(", spanContext=");
        sb.append(this.spanContext);
        sb.append(", severity=");
        sb.append(this.severity);
        sb.append(", severityText=");
        sb.append(this.severityText);
        sb.append(", body=");
        sb.append(this.body);
        sb.append(", attributes=");
        sb.append(this.attributes);
        sb.append(", totalAttributeCount=");
        sb.append(this.totalAttributeCount);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof SdkLogRecordData) {
            SdkLogRecordData sdkLogRecordData = (SdkLogRecordData) obj;
            return this.resource.equals(sdkLogRecordData.getResource()) && this.instrumentationScopeInfo.equals(sdkLogRecordData.getInstrumentationScopeInfo()) && this.epochNanos == sdkLogRecordData.getEpochNanos() && this.spanContext.equals(sdkLogRecordData.getSpanContext()) && this.severity.equals(sdkLogRecordData.getSeverity()) && ((str = this.severityText) != null ? str.equals(sdkLogRecordData.getSeverityText()) : sdkLogRecordData.getSeverityText() == null) && this.body.equals(sdkLogRecordData.getBody()) && this.attributes.equals(sdkLogRecordData.getAttributes()) && this.totalAttributeCount == sdkLogRecordData.getTotalAttributeCount();
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.resource.hashCode();
        int hashCode2 = this.instrumentationScopeInfo.hashCode();
        long j = this.epochNanos;
        int i = (int) (j ^ (j >>> 32));
        int hashCode3 = this.spanContext.hashCode();
        int hashCode4 = this.severity.hashCode();
        String str = this.severityText;
        return ((((((((((((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ i) * 1000003) ^ hashCode3) * 1000003) ^ hashCode4) * 1000003) ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.body.hashCode()) * 1000003) ^ this.attributes.hashCode()) * 1000003) ^ this.totalAttributeCount;
    }
}
