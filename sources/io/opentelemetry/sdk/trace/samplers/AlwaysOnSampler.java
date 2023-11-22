package io.opentelemetry.sdk.trace.samplers;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.trace.data.LinkData;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public enum AlwaysOnSampler implements Sampler {
    INSTANCE;

    @Override // io.opentelemetry.sdk.trace.samplers.Sampler
    public final String getDescription() {
        return "AlwaysOnSampler";
    }

    @Override // io.opentelemetry.sdk.trace.samplers.Sampler
    public final SamplingResult shouldSample(Context context, String str, String str2, SpanKind spanKind, Attributes attributes, List<LinkData> list) {
        return ImmutableSamplingResult.EMPTY_RECORDED_AND_SAMPLED_SAMPLING_RESULT;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return getDescription();
    }
}
