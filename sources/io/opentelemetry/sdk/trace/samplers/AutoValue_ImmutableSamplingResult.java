package io.opentelemetry.sdk.trace.samplers;

import io.opentelemetry.api.common.Attributes;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class AutoValue_ImmutableSamplingResult extends ImmutableSamplingResult {
    private final Attributes attributes;
    private final SamplingDecision decision;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableSamplingResult(SamplingDecision samplingDecision, Attributes attributes) {
        if (samplingDecision == null) {
            throw new NullPointerException("Null decision");
        }
        this.decision = samplingDecision;
        if (attributes == null) {
            throw new NullPointerException("Null attributes");
        }
        this.attributes = attributes;
    }

    @Override // io.opentelemetry.sdk.trace.samplers.ImmutableSamplingResult, io.opentelemetry.sdk.trace.samplers.SamplingResult
    public final SamplingDecision getDecision() {
        return this.decision;
    }

    @Override // io.opentelemetry.sdk.trace.samplers.ImmutableSamplingResult, io.opentelemetry.sdk.trace.samplers.SamplingResult
    public final Attributes getAttributes() {
        return this.attributes;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableSamplingResult{decision=");
        sb.append(this.decision);
        sb.append(", attributes=");
        sb.append(this.attributes);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableSamplingResult) {
            ImmutableSamplingResult immutableSamplingResult = (ImmutableSamplingResult) obj;
            return this.decision.equals(immutableSamplingResult.getDecision()) && this.attributes.equals(immutableSamplingResult.getAttributes());
        }
        return false;
    }

    public final int hashCode() {
        return ((this.decision.hashCode() ^ 1000003) * 1000003) ^ this.attributes.hashCode();
    }
}
