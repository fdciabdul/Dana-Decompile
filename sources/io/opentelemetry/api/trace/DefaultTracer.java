package io.opentelemetry.api.trace;

import com.ap.zoloz.hummer.biz.HummerZCodeConstant;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.internal.ValidationUtil;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.context.Context;
import j$.time.Instant;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
final class DefaultTracer implements Tracer {
    private static final Tracer INSTANCE = new DefaultTracer();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Tracer getInstance() {
        return INSTANCE;
    }

    @Override // io.opentelemetry.api.trace.Tracer
    public final SpanBuilder spanBuilder(String str) {
        return NoopSpanBuilder.create();
    }

    private DefaultTracer() {
    }

    /* loaded from: classes6.dex */
    static final class NoopSpanBuilder implements SpanBuilder {
        @Nullable
        private SpanContext spanContext;

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public final NoopSpanBuilder addLink(SpanContext spanContext) {
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public final NoopSpanBuilder addLink(SpanContext spanContext, Attributes attributes) {
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public final NoopSpanBuilder setAllAttributes(Attributes attributes) {
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public final <T> NoopSpanBuilder setAttribute(AttributeKey<T> attributeKey, T t) {
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public final NoopSpanBuilder setAttribute(String str, double d) {
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public final NoopSpanBuilder setAttribute(String str, long j) {
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public final NoopSpanBuilder setAttribute(String str, String str2) {
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public final NoopSpanBuilder setAttribute(String str, boolean z) {
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public final NoopSpanBuilder setSpanKind(SpanKind spanKind) {
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public final NoopSpanBuilder setStartTimestamp(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public final /* synthetic */ SpanBuilder setStartTimestamp(Instant instant) {
            return SpanBuilder.CC.$default$setStartTimestamp(this, instant);
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public final /* bridge */ /* synthetic */ SpanBuilder setAttribute(AttributeKey attributeKey, Object obj) {
            return setAttribute((AttributeKey<AttributeKey>) attributeKey, (AttributeKey) obj);
        }

        static NoopSpanBuilder create() {
            return new NoopSpanBuilder();
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public final Span startSpan() {
            if (this.spanContext == null) {
                this.spanContext = Span.CC.current().getSpanContext();
            }
            return Span.CC.wrap(this.spanContext);
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public final NoopSpanBuilder setParent(Context context) {
            if (context == null) {
                ValidationUtil.log(HummerZCodeConstant.CONTEXT_ERROR_MSG);
                return this;
            }
            this.spanContext = Span.CC.fromContext(context).getSpanContext();
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public final NoopSpanBuilder setNoParent() {
            this.spanContext = SpanContext.CC.getInvalid();
            return this;
        }

        private NoopSpanBuilder() {
        }
    }
}
