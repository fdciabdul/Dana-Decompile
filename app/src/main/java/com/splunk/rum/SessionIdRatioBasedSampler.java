package com.splunk.rum;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.trace.data.LinkData;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import io.opentelemetry.sdk.trace.samplers.SamplingResult;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SessionIdRatioBasedSampler implements Sampler {
    private final SessionId KClassImpl$Data$declaredNonStaticMembers$2;
    private final Sampler getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionIdRatioBasedSampler(double d, SessionId sessionId) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = sessionId;
        this.getAuthRequestContext = Sampler.CC.traceIdRatioBased(d);
    }

    @Override // io.opentelemetry.sdk.trace.samplers.Sampler
    public SamplingResult shouldSample(Context context, String str, String str2, SpanKind spanKind, Attributes attributes, List<LinkData> list) {
        return this.getAuthRequestContext.shouldSample(context, this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(), str2, spanKind, attributes, list);
    }

    @Override // io.opentelemetry.sdk.trace.samplers.Sampler
    public String getDescription() {
        return String.format("SessionIdRatioBased{traceIdRatioBased:%s}", this.getAuthRequestContext.getDescription());
    }
}
