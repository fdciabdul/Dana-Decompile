package io.opentelemetry.sdk.trace;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.internal.ImmutableSpanContext;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.TraceFlags;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.internal.AttributeUtil;
import io.opentelemetry.sdk.internal.AttributesMap;
import io.opentelemetry.sdk.trace.data.LinkData;
import io.opentelemetry.sdk.trace.samplers.SamplingDecision;
import io.opentelemetry.sdk.trace.samplers.SamplingResult;
import j$.time.Instant;
import j$.util.function.BiConsumer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public final class SdkSpanBuilder implements SpanBuilder {
    @Nullable
    private AttributesMap attributes;
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    @Nullable
    private List<LinkData> links;
    @Nullable
    private Context parent;
    private final SpanLimits spanLimits;
    private final String spanName;
    private final TracerSharedState tracerSharedState;
    private SpanKind spanKind = SpanKind.INTERNAL;
    private int totalNumberOfLinksAdded = 0;
    private long startEpochNanos = 0;

    @Override // io.opentelemetry.api.trace.SpanBuilder
    public final /* synthetic */ SpanBuilder setAllAttributes(Attributes attributes) {
        return SpanBuilder.CC.$default$setAllAttributes(this, attributes);
    }

    @Override // io.opentelemetry.api.trace.SpanBuilder
    public final /* synthetic */ SpanBuilder setStartTimestamp(Instant instant) {
        return SpanBuilder.CC.$default$setStartTimestamp(this, instant);
    }

    public SdkSpanBuilder(String str, InstrumentationScopeInfo instrumentationScopeInfo, TracerSharedState tracerSharedState, SpanLimits spanLimits) {
        this.spanName = str;
        this.instrumentationScopeInfo = instrumentationScopeInfo;
        this.tracerSharedState = tracerSharedState;
        this.spanLimits = spanLimits;
    }

    @Override // io.opentelemetry.api.trace.SpanBuilder
    public final SpanBuilder setParent(Context context) {
        if (context == null) {
            return this;
        }
        this.parent = context;
        return this;
    }

    @Override // io.opentelemetry.api.trace.SpanBuilder
    public final SpanBuilder setNoParent() {
        this.parent = Context.CC.root();
        return this;
    }

    @Override // io.opentelemetry.api.trace.SpanBuilder
    public final SpanBuilder setSpanKind(SpanKind spanKind) {
        if (spanKind == null) {
            return this;
        }
        this.spanKind = spanKind;
        return this;
    }

    @Override // io.opentelemetry.api.trace.SpanBuilder
    public final SpanBuilder addLink(SpanContext spanContext) {
        if (spanContext != null && spanContext.isValid()) {
            addLink(LinkData.CC.create(spanContext));
        }
        return this;
    }

    @Override // io.opentelemetry.api.trace.SpanBuilder
    public final SpanBuilder addLink(SpanContext spanContext, Attributes attributes) {
        if (spanContext != null && spanContext.isValid()) {
            if (attributes == null) {
                attributes = Attributes.CC.empty();
            }
            addLink(LinkData.CC.create(spanContext, AttributeUtil.applyAttributesLimit(attributes, this.spanLimits.getMaxNumberOfAttributesPerLink(), this.spanLimits.getMaxAttributeValueLength()), attributes.size()));
        }
        return this;
    }

    private void addLink(LinkData linkData) {
        this.totalNumberOfLinksAdded++;
        if (this.links == null) {
            this.links = new ArrayList(this.spanLimits.getMaxNumberOfLinks());
        }
        if (this.links.size() == this.spanLimits.getMaxNumberOfLinks()) {
            return;
        }
        this.links.add(linkData);
    }

    @Override // io.opentelemetry.api.trace.SpanBuilder
    public final SpanBuilder setAttribute(String str, String str2) {
        return setAttribute((AttributeKey<AttributeKey<String>>) AttributeKey.CC.stringKey(str), (AttributeKey<String>) str2);
    }

    @Override // io.opentelemetry.api.trace.SpanBuilder
    public final SpanBuilder setAttribute(String str, long j) {
        return setAttribute((AttributeKey<AttributeKey<Long>>) AttributeKey.CC.longKey(str), (AttributeKey<Long>) Long.valueOf(j));
    }

    @Override // io.opentelemetry.api.trace.SpanBuilder
    public final SpanBuilder setAttribute(String str, double d) {
        return setAttribute((AttributeKey<AttributeKey<Double>>) AttributeKey.CC.doubleKey(str), (AttributeKey<Double>) Double.valueOf(d));
    }

    @Override // io.opentelemetry.api.trace.SpanBuilder
    public final SpanBuilder setAttribute(String str, boolean z) {
        return setAttribute((AttributeKey<AttributeKey<Boolean>>) AttributeKey.CC.booleanKey(str), (AttributeKey<Boolean>) Boolean.valueOf(z));
    }

    @Override // io.opentelemetry.api.trace.SpanBuilder
    public final <T> SpanBuilder setAttribute(AttributeKey<T> attributeKey, T t) {
        if (attributeKey != null && !attributeKey.getKey().isEmpty() && t != null) {
            attributes().put((AttributeKey<AttributeKey<T>>) attributeKey, (AttributeKey<T>) t);
        }
        return this;
    }

    @Override // io.opentelemetry.api.trace.SpanBuilder
    public final SpanBuilder setStartTimestamp(long j, TimeUnit timeUnit) {
        if (j >= 0 && timeUnit != null) {
            this.startEpochNanos = timeUnit.toNanos(j);
        }
        return this;
    }

    @Override // io.opentelemetry.api.trace.SpanBuilder
    public final Span startSpan() {
        String traceId;
        Context context = this.parent;
        if (context == null) {
            context = Context.CC.current();
        }
        Span fromContext = Span.CC.fromContext(context);
        SpanContext spanContext = fromContext.getSpanContext();
        IdGenerator idGenerator = this.tracerSharedState.getIdGenerator();
        String generateSpanId = idGenerator.generateSpanId();
        if (!spanContext.isValid()) {
            traceId = idGenerator.generateTraceId();
        } else {
            traceId = spanContext.getTraceId();
        }
        String str = traceId;
        List<LinkData> list = this.links;
        List<LinkData> emptyList = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.links = null;
        Attributes attributes = this.attributes;
        if (attributes == null) {
            attributes = Attributes.CC.empty();
        }
        SamplingResult shouldSample = this.tracerSharedState.getSampler().shouldSample(context, str, this.spanName, this.spanKind, attributes, emptyList);
        SamplingDecision decision = shouldSample.getDecision();
        SpanContext create = ImmutableSpanContext.create(str, generateSpanId, isSampled(decision) ? TraceFlags.CC.getSampled() : TraceFlags.CC.getDefault(), shouldSample.getUpdatedTraceState(spanContext.getTraceState()), false, this.tracerSharedState.isIdGeneratorSafeToSkipIdValidation());
        if (!isRecording(decision)) {
            return Span.CC.wrap(create);
        }
        Attributes attributes2 = shouldSample.getAttributes();
        if (!attributes2.isEmpty()) {
            attributes2.forEach(new BiConsumer() { // from class: io.opentelemetry.sdk.trace.SdkSpanBuilder$$ExternalSyntheticLambda0
                @Override // j$.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    SdkSpanBuilder.this.m3161lambda$startSpan$0$ioopentelemetrysdktraceSdkSpanBuilder((AttributeKey) obj, obj2);
                }

                @Override // j$.util.function.BiConsumer
                public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                    return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
                }
            });
        }
        AttributesMap attributesMap = this.attributes;
        this.attributes = null;
        return SdkSpan.startSpan(create, this.spanName, this.instrumentationScopeInfo, this.spanKind, fromContext, context, this.spanLimits, this.tracerSharedState.getActiveSpanProcessor(), this.tracerSharedState.getClock(), this.tracerSharedState.getResource(), attributesMap, emptyList, this.totalNumberOfLinksAdded, this.startEpochNanos);
    }

    /* renamed from: lambda$startSpan$0$io-opentelemetry-sdk-trace-SdkSpanBuilder */
    public final /* synthetic */ void m3161lambda$startSpan$0$ioopentelemetrysdktraceSdkSpanBuilder(AttributeKey attributeKey, Object obj) {
        attributes().put((AttributeKey<AttributeKey>) attributeKey, (AttributeKey) obj);
    }

    private AttributesMap attributes() {
        AttributesMap attributesMap = this.attributes;
        if (attributesMap == null) {
            AttributesMap create = AttributesMap.create(this.spanLimits.getMaxNumberOfAttributes(), this.spanLimits.getMaxAttributeValueLength());
            this.attributes = create;
            return create;
        }
        return attributesMap;
    }

    static boolean isRecording(SamplingDecision samplingDecision) {
        return SamplingDecision.RECORD_ONLY.equals(samplingDecision) || SamplingDecision.RECORD_AND_SAMPLE.equals(samplingDecision);
    }

    static boolean isSampled(SamplingDecision samplingDecision) {
        return SamplingDecision.RECORD_AND_SAMPLE.equals(samplingDecision);
    }
}
