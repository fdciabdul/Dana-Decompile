package io.opentelemetry.instrumentation.api.instrumenter;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import javax.annotation.Nullable;

@FunctionalInterface
/* loaded from: classes2.dex */
public interface SpanStatusExtractor<REQUEST, RESPONSE> {
    void extract(SpanStatusBuilder spanStatusBuilder, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th);

    @SynthesizedClassV2(kind = 7, versionHash = "5e5398f0546d1d7afd62641edb14d82894f11ddc41bce363a0c8d0dac82c9c5a")
    /* renamed from: io.opentelemetry.instrumentation.api.instrumenter.SpanStatusExtractor$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC<REQUEST, RESPONSE> {
        public static <REQUEST, RESPONSE> SpanStatusExtractor<REQUEST, RESPONSE> getDefault() {
            return (SpanStatusExtractor<REQUEST, RESPONSE>) DefaultSpanStatusExtractor.INSTANCE;
        }
    }
}
