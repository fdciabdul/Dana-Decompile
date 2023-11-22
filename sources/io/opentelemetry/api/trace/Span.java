package io.opentelemetry.api.trace;

import com.ap.zoloz.hummer.biz.HummerZCodeConstant;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.internal.ValidationUtil;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.ImplicitContextKeyed;
import j$.time.Instant;
import j$.util.function.BiConsumer;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public interface Span extends ImplicitContextKeyed {
    Span addEvent(String str);

    Span addEvent(String str, long j, TimeUnit timeUnit);

    Span addEvent(String str, Attributes attributes);

    Span addEvent(String str, Attributes attributes, long j, TimeUnit timeUnit);

    Span addEvent(String str, Attributes attributes, Instant instant);

    Span addEvent(String str, Instant instant);

    void end();

    void end(long j, TimeUnit timeUnit);

    void end(Instant instant);

    SpanContext getSpanContext();

    boolean isRecording();

    Span recordException(Throwable th);

    Span recordException(Throwable th, Attributes attributes);

    Span setAllAttributes(Attributes attributes);

    Span setAttribute(AttributeKey<Long> attributeKey, int i);

    <T> Span setAttribute(AttributeKey<T> attributeKey, T t);

    Span setAttribute(String str, double d);

    Span setAttribute(String str, long j);

    Span setAttribute(String str, String str2);

    Span setAttribute(String str, boolean z);

    Span setStatus(StatusCode statusCode);

    Span setStatus(StatusCode statusCode, String str);

    @Override // io.opentelemetry.context.ImplicitContextKeyed
    Context storeInContext(Context context);

    Span updateName(String str);

    /* renamed from: io.opentelemetry.api.trace.Span$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static Span current() {
            Span span = (Span) Context.CC.current().get(SpanContextKey.KEY);
            return span == null ? getInvalid() : span;
        }

        public static Span fromContext(Context context) {
            if (context == null) {
                ValidationUtil.log(HummerZCodeConstant.CONTEXT_ERROR_MSG);
                return getInvalid();
            }
            Span span = (Span) context.get(SpanContextKey.KEY);
            return span == null ? getInvalid() : span;
        }

        @Nullable
        public static Span fromContextOrNull(Context context) {
            if (context == null) {
                ValidationUtil.log(HummerZCodeConstant.CONTEXT_ERROR_MSG);
                return null;
            }
            return (Span) context.get(SpanContextKey.KEY);
        }

        public static Span getInvalid() {
            return PropagatedSpan.INVALID;
        }

        public static Span wrap(SpanContext spanContext) {
            if (spanContext == null) {
                ValidationUtil.log(HummerZCodeConstant.CONTEXT_ERROR_MSG);
                return getInvalid();
            } else if (!spanContext.isValid()) {
                return getInvalid();
            } else {
                return PropagatedSpan.create(spanContext);
            }
        }

        public static Span $default$setAllAttributes(final Span span, Attributes attributes) {
            if (attributes != null && !attributes.isEmpty()) {
                attributes.forEach(new BiConsumer() { // from class: io.opentelemetry.api.trace.Span$$ExternalSyntheticLambda0
                    @Override // j$.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        Span.this.setAttribute((AttributeKey<AttributeKey>) obj, (AttributeKey) obj2);
                    }

                    @Override // j$.util.function.BiConsumer
                    public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                        return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
                    }
                });
            }
            return span;
        }

        public static Span $default$addEvent(Span span, String str, Instant instant) {
            if (instant == null) {
                return span.addEvent(str);
            }
            return span.addEvent(str, TimeUnit.SECONDS.toNanos(instant.getEpochSecond()) + instant.getNano(), TimeUnit.NANOSECONDS);
        }

        public static Span $default$addEvent(Span span, String str, Attributes attributes, Instant instant) {
            if (instant == null) {
                return span.addEvent(str, attributes);
            }
            return span.addEvent(str, attributes, TimeUnit.SECONDS.toNanos(instant.getEpochSecond()) + instant.getNano(), TimeUnit.NANOSECONDS);
        }

        public static void $default$end(Span span, Instant instant) {
            if (instant == null) {
                span.end();
            } else {
                span.end(TimeUnit.SECONDS.toNanos(instant.getEpochSecond()) + instant.getNano(), TimeUnit.NANOSECONDS);
            }
        }
    }
}
