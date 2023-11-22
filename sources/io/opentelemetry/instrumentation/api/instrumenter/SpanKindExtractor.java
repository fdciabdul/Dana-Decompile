package io.opentelemetry.instrumentation.api.instrumenter;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import io.opentelemetry.api.trace.SpanKind;

@FunctionalInterface
/* loaded from: classes6.dex */
public interface SpanKindExtractor<REQUEST> {
    SpanKind extract(REQUEST request);

    @SynthesizedClassV2(kind = 7, versionHash = "5e5398f0546d1d7afd62641edb14d82894f11ddc41bce363a0c8d0dac82c9c5a")
    /* renamed from: io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC<REQUEST> {
        public static <REQUEST> SpanKindExtractor<REQUEST> alwaysInternal() {
            return new SpanKindExtractor() { // from class: io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor$$ExternalSyntheticLambda2
                @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor
                public final SpanKind extract(Object obj) {
                    SpanKind spanKind;
                    spanKind = SpanKind.INTERNAL;
                    return spanKind;
                }
            };
        }

        public static <REQUEST> SpanKindExtractor<REQUEST> alwaysClient() {
            return new SpanKindExtractor() { // from class: io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor$$ExternalSyntheticLambda1
                @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor
                public final SpanKind extract(Object obj) {
                    SpanKind spanKind;
                    spanKind = SpanKind.CLIENT;
                    return spanKind;
                }
            };
        }

        public static <REQUEST> SpanKindExtractor<REQUEST> alwaysServer() {
            return new SpanKindExtractor() { // from class: io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor$$ExternalSyntheticLambda3
                @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor
                public final SpanKind extract(Object obj) {
                    SpanKind spanKind;
                    spanKind = SpanKind.SERVER;
                    return spanKind;
                }
            };
        }

        public static <REQUEST> SpanKindExtractor<REQUEST> alwaysProducer() {
            return new SpanKindExtractor() { // from class: io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor$$ExternalSyntheticLambda4
                @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor
                public final SpanKind extract(Object obj) {
                    SpanKind spanKind;
                    spanKind = SpanKind.PRODUCER;
                    return spanKind;
                }
            };
        }

        public static <REQUEST> SpanKindExtractor<REQUEST> alwaysConsumer() {
            return new SpanKindExtractor() { // from class: io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor$$ExternalSyntheticLambda0
                @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor
                public final SpanKind extract(Object obj) {
                    SpanKind spanKind;
                    spanKind = SpanKind.CONSUMER;
                    return spanKind;
                }
            };
        }
    }
}
