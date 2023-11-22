package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.instrumentation.api.instrumenter.SpanSuppressors;
import io.opentelemetry.instrumentation.api.internal.SpanKey;
import java.util.Locale;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
enum SpanSuppressionStrategy {
    NONE { // from class: io.opentelemetry.instrumentation.api.instrumenter.SpanSuppressionStrategy.1
        @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanSuppressionStrategy
        final SpanSuppressor create(Set<SpanKey> set) {
            return SpanSuppressors.Noop.INSTANCE;
        }
    },
    SPAN_KIND { // from class: io.opentelemetry.instrumentation.api.instrumenter.SpanSuppressionStrategy.2
        private final SpanSuppressor strategy;

        @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanSuppressionStrategy
        final SpanSuppressor create(Set<SpanKey> set) {
            return this.strategy;
        }
    },
    SEMCONV { // from class: io.opentelemetry.instrumentation.api.instrumenter.SpanSuppressionStrategy.3
        @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanSuppressionStrategy
        final SpanSuppressor create(Set<SpanKey> set) {
            if (set.isEmpty()) {
                return SpanSuppressors.Noop.INSTANCE;
            }
            return new SpanSuppressors.BySpanKey(set);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract SpanSuppressor create(Set<SpanKey> set);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpanSuppressionStrategy fromConfig(@Nullable String str) {
        if (str == null) {
            str = "semconv";
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        lowerCase.hashCode();
        if (lowerCase.equals("span-kind")) {
            return SPAN_KIND;
        }
        if (lowerCase.equals("none")) {
            return NONE;
        }
        return SEMCONV;
    }
}
