package io.opentelemetry.api.trace;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import j$.time.Instant;
import j$.util.function.BiConsumer;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public interface SpanBuilder {
    SpanBuilder addLink(SpanContext spanContext);

    SpanBuilder addLink(SpanContext spanContext, Attributes attributes);

    SpanBuilder setAllAttributes(Attributes attributes);

    <T> SpanBuilder setAttribute(AttributeKey<T> attributeKey, T t);

    SpanBuilder setAttribute(String str, double d);

    SpanBuilder setAttribute(String str, long j);

    SpanBuilder setAttribute(String str, String str2);

    SpanBuilder setAttribute(String str, boolean z);

    SpanBuilder setNoParent();

    SpanBuilder setParent(Context context);

    SpanBuilder setSpanKind(SpanKind spanKind);

    SpanBuilder setStartTimestamp(long j, TimeUnit timeUnit);

    SpanBuilder setStartTimestamp(Instant instant);

    Span startSpan();

    /* renamed from: io.opentelemetry.api.trace.SpanBuilder$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static SpanBuilder $default$setAllAttributes(final SpanBuilder spanBuilder, Attributes attributes) {
            if (attributes != null && !attributes.isEmpty()) {
                attributes.forEach(new BiConsumer() { // from class: io.opentelemetry.api.trace.SpanBuilder$$ExternalSyntheticLambda0
                    @Override // j$.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        SpanBuilder.this.setAttribute((AttributeKey<AttributeKey>) obj, (AttributeKey) obj2);
                    }

                    @Override // j$.util.function.BiConsumer
                    public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                        return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
                    }
                });
            }
            return spanBuilder;
        }

        public static SpanBuilder $default$setStartTimestamp(SpanBuilder spanBuilder, Instant instant) {
            if (instant == null) {
                return spanBuilder;
            }
            return spanBuilder.setStartTimestamp(TimeUnit.SECONDS.toNanos(instant.getEpochSecond()) + instant.getNano(), TimeUnit.NANOSECONDS);
        }
    }
}
