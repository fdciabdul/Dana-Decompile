package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.internal.SpanKey;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
final class SpanSuppressors {

    /* loaded from: classes6.dex */
    enum Noop implements SpanSuppressor {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanSuppressor
        public final boolean shouldSuppress(Context context, SpanKind spanKind) {
            return false;
        }

        @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanSuppressor
        public final Context storeInContext(Context context, SpanKind spanKind, Span span) {
            return context;
        }
    }

    private SpanSuppressors() {
    }

    /* loaded from: classes6.dex */
    static final class DelegateBySpanKind implements SpanSuppressor {
        private final Map<SpanKind, SpanSuppressor> delegates;

        /* JADX INFO: Access modifiers changed from: package-private */
        public DelegateBySpanKind(Map<SpanKind, SpanSuppressor> map) {
            this.delegates = map;
        }

        @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanSuppressor
        public final Context storeInContext(Context context, SpanKind spanKind, Span span) {
            SpanSuppressor spanSuppressor = this.delegates.get(spanKind);
            return spanSuppressor == null ? context : spanSuppressor.storeInContext(context, spanKind, span);
        }

        @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanSuppressor
        public final boolean shouldSuppress(Context context, SpanKind spanKind) {
            SpanSuppressor spanSuppressor = this.delegates.get(spanKind);
            if (spanSuppressor == null) {
                return false;
            }
            return spanSuppressor.shouldSuppress(context, spanKind);
        }
    }

    /* loaded from: classes6.dex */
    static final class BySpanKey implements SpanSuppressor {
        private final Set<SpanKey> spanKeys;

        /* JADX INFO: Access modifiers changed from: package-private */
        public BySpanKey(Set<SpanKey> set) {
            this.spanKeys = set;
        }

        @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanSuppressor
        public final Context storeInContext(Context context, SpanKind spanKind, Span span) {
            Iterator<SpanKey> it = this.spanKeys.iterator();
            while (it.hasNext()) {
                context = it.next().storeInContext(context, span);
            }
            return context;
        }

        @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanSuppressor
        public final boolean shouldSuppress(Context context, SpanKind spanKind) {
            Iterator<SpanKey> it = this.spanKeys.iterator();
            while (it.hasNext()) {
                if (it.next().fromContextOrNull(context) == null) {
                    return false;
                }
            }
            return true;
        }
    }
}
