package io.opentelemetry.sdk.trace.samplers;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.trace.data.LinkData;
import java.util.List;

/* loaded from: classes.dex */
public interface Sampler {
    String getDescription();

    SamplingResult shouldSample(Context context, String str, String str2, SpanKind spanKind, Attributes attributes, List<LinkData> list);

    /* renamed from: io.opentelemetry.sdk.trace.samplers.Sampler$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static Sampler alwaysOn() {
            return AlwaysOnSampler.INSTANCE;
        }

        public static Sampler alwaysOff() {
            return AlwaysOffSampler.INSTANCE;
        }

        public static Sampler parentBased(Sampler sampler) {
            return parentBasedBuilder(sampler).build();
        }

        public static ParentBasedSamplerBuilder parentBasedBuilder(Sampler sampler) {
            return new ParentBasedSamplerBuilder(sampler);
        }

        public static Sampler traceIdRatioBased(double d) {
            return TraceIdRatioBasedSampler.create(d);
        }
    }
}
