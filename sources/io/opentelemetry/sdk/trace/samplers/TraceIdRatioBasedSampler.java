package io.opentelemetry.sdk.trace.samplers;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.internal.OtelEncodingUtils;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.trace.data.LinkData;
import io.opentelemetry.sdk.trace.samplers.SamplingResult;
import java.util.List;
import javax.annotation.Nullable;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class TraceIdRatioBasedSampler implements Sampler {
    private final String description;
    private final long idUpperBound;
    private static final SamplingResult POSITIVE_SAMPLING_RESULT = SamplingResult.CC.recordAndSample();
    private static final SamplingResult NEGATIVE_SAMPLING_RESULT = SamplingResult.CC.drop();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TraceIdRatioBasedSampler create(double d) {
        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d > 1.0d) {
            throw new IllegalArgumentException("ratio must be in range [0.0, 1.0]");
        }
        return new TraceIdRatioBasedSampler(d, d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? Long.MIN_VALUE : d == 1.0d ? LongCompanionObject.MAX_VALUE : (long) (9.223372036854776E18d * d));
    }

    TraceIdRatioBasedSampler(double d, long j) {
        this.idUpperBound = j;
        this.description = String.format("TraceIdRatioBased{%.6f}", Double.valueOf(d));
    }

    @Override // io.opentelemetry.sdk.trace.samplers.Sampler
    public final SamplingResult shouldSample(Context context, String str, String str2, SpanKind spanKind, Attributes attributes, List<LinkData> list) {
        if (Math.abs(getTraceIdRandomPart(str)) < this.idUpperBound) {
            return POSITIVE_SAMPLING_RESULT;
        }
        return NEGATIVE_SAMPLING_RESULT;
    }

    @Override // io.opentelemetry.sdk.trace.samplers.Sampler
    public final String getDescription() {
        return this.description;
    }

    public final boolean equals(@Nullable Object obj) {
        return (obj instanceof TraceIdRatioBasedSampler) && this.idUpperBound == ((TraceIdRatioBasedSampler) obj).idUpperBound;
    }

    public final int hashCode() {
        return Cbor$Arg$$ExternalSyntheticBackport0.m(this.idUpperBound);
    }

    public final String toString() {
        return getDescription();
    }

    final long getIdUpperBound() {
        return this.idUpperBound;
    }

    private static long getTraceIdRandomPart(String str) {
        return OtelEncodingUtils.longFromBase16String(str, 16);
    }
}
