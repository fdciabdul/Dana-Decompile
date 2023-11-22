package io.opentelemetry.sdk.trace.samplers;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.TraceState;
import java.util.Objects;

/* loaded from: classes2.dex */
public interface SamplingResult {
    Attributes getAttributes();

    SamplingDecision getDecision();

    TraceState getUpdatedTraceState(TraceState traceState);

    /* renamed from: io.opentelemetry.sdk.trace.samplers.SamplingResult$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static TraceState $default$getUpdatedTraceState(SamplingResult samplingResult, TraceState traceState) {
            return traceState;
        }

        public static SamplingResult create(SamplingDecision samplingDecision) {
            int i = AnonymousClass1.$SwitchMap$io$opentelemetry$sdk$trace$samplers$SamplingDecision[samplingDecision.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return ImmutableSamplingResult.EMPTY_NOT_SAMPLED_OR_RECORDED_SAMPLING_RESULT;
                    }
                    throw new AssertionError("unrecognised samplingResult");
                }
                return ImmutableSamplingResult.EMPTY_RECORDED_SAMPLING_RESULT;
            }
            return ImmutableSamplingResult.EMPTY_RECORDED_AND_SAMPLED_SAMPLING_RESULT;
        }

        public static SamplingResult create(SamplingDecision samplingDecision, Attributes attributes) {
            Objects.requireNonNull(attributes, "attributes");
            if (attributes.isEmpty()) {
                return create(samplingDecision);
            }
            return ImmutableSamplingResult.createSamplingResult(samplingDecision, attributes);
        }

        public static SamplingResult recordAndSample() {
            return ImmutableSamplingResult.EMPTY_RECORDED_AND_SAMPLED_SAMPLING_RESULT;
        }

        public static SamplingResult recordOnly() {
            return ImmutableSamplingResult.EMPTY_RECORDED_SAMPLING_RESULT;
        }

        public static SamplingResult drop() {
            return ImmutableSamplingResult.EMPTY_NOT_SAMPLED_OR_RECORDED_SAMPLING_RESULT;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.opentelemetry.sdk.trace.samplers.SamplingResult$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$opentelemetry$sdk$trace$samplers$SamplingDecision;

        static {
            int[] iArr = new int[SamplingDecision.values().length];
            $SwitchMap$io$opentelemetry$sdk$trace$samplers$SamplingDecision = iArr;
            try {
                iArr[SamplingDecision.RECORD_AND_SAMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$trace$samplers$SamplingDecision[SamplingDecision.RECORD_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$trace$samplers$SamplingDecision[SamplingDecision.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
