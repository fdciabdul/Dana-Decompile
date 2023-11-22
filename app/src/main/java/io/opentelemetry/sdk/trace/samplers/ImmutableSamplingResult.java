package io.opentelemetry.sdk.trace.samplers;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.TraceState;
import io.opentelemetry.sdk.trace.samplers.SamplingResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class ImmutableSamplingResult implements SamplingResult {
    static final SamplingResult EMPTY_RECORDED_AND_SAMPLED_SAMPLING_RESULT = createWithoutAttributes(SamplingDecision.RECORD_AND_SAMPLE);
    static final SamplingResult EMPTY_NOT_SAMPLED_OR_RECORDED_SAMPLING_RESULT = createWithoutAttributes(SamplingDecision.DROP);
    static final SamplingResult EMPTY_RECORDED_SAMPLING_RESULT = createWithoutAttributes(SamplingDecision.RECORD_ONLY);

    @Override // io.opentelemetry.sdk.trace.samplers.SamplingResult
    public abstract Attributes getAttributes();

    @Override // io.opentelemetry.sdk.trace.samplers.SamplingResult
    public abstract SamplingDecision getDecision();

    @Override // io.opentelemetry.sdk.trace.samplers.SamplingResult
    public /* synthetic */ TraceState getUpdatedTraceState(TraceState traceState) {
        return SamplingResult.CC.$default$getUpdatedTraceState(this, traceState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SamplingResult createSamplingResult(SamplingDecision samplingDecision, Attributes attributes) {
        return new AutoValue_ImmutableSamplingResult(samplingDecision, attributes);
    }

    private static SamplingResult createWithoutAttributes(SamplingDecision samplingDecision) {
        return new AutoValue_ImmutableSamplingResult(samplingDecision, Attributes.CC.empty());
    }
}
