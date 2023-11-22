package io.opentelemetry.exporter.internal;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;

/* loaded from: classes6.dex */
public class ExporterMetrics {
    private final LongCounter exported;
    private final Attributes failedAttrs;
    private final LongCounter seen;
    private final Attributes seenAttrs;
    private final Attributes successAttrs;
    private static final AttributeKey<String> ATTRIBUTE_KEY_TYPE = AttributeKey.CC.stringKey("type");
    private static final AttributeKey<Boolean> ATTRIBUTE_KEY_SUCCESS = AttributeKey.CC.booleanKey("success");

    private ExporterMetrics(MeterProvider meterProvider, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("io.opentelemetry.exporters.");
        sb.append(str);
        sb.append("-");
        sb.append(str3);
        Meter meter = meterProvider.get(sb.toString());
        Attributes build = Attributes.CC.builder().put((AttributeKey<AttributeKey<String>>) ATTRIBUTE_KEY_TYPE, (AttributeKey<String>) str2).build();
        this.seenAttrs = build;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(".exporter.seen");
        this.seen = meter.counterBuilder(sb2.toString()).build();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(".exporter.exported");
        this.exported = meter.counterBuilder(sb3.toString()).build();
        AttributesBuilder builder = build.toBuilder();
        AttributeKey<Boolean> attributeKey = ATTRIBUTE_KEY_SUCCESS;
        this.successAttrs = builder.put((AttributeKey<AttributeKey<Boolean>>) attributeKey, (AttributeKey<Boolean>) Boolean.TRUE).build();
        this.failedAttrs = build.toBuilder().put((AttributeKey<AttributeKey<Boolean>>) attributeKey, (AttributeKey<Boolean>) Boolean.FALSE).build();
    }

    public void addSeen(long j) {
        this.seen.add(j, this.seenAttrs);
    }

    public void addSuccess(long j) {
        this.exported.add(j, this.successAttrs);
    }

    public void addFailed(long j) {
        this.exported.add(j, this.failedAttrs);
    }

    public static ExporterMetrics createGrpc(String str, String str2, MeterProvider meterProvider) {
        return new ExporterMetrics(meterProvider, str, str2, SemanticAttributes.RpcSystemValues.GRPC);
    }

    public static ExporterMetrics createGrpcOkHttp(String str, String str2, MeterProvider meterProvider) {
        return new ExporterMetrics(meterProvider, str, str2, "grpc-okhttp");
    }

    public static ExporterMetrics createHttpProtobuf(String str, String str2, MeterProvider meterProvider) {
        return new ExporterMetrics(meterProvider, str, str2, SemanticAttributes.FaasTriggerValues.HTTP);
    }

    public static ExporterMetrics createHttpJson(String str, String str2, MeterProvider meterProvider) {
        return new ExporterMetrics(meterProvider, str, str2, "http-json");
    }
}
