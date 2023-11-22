package io.opentelemetry.api.trace;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import j$.time.Instant;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class PropagatedSpan implements Span {
    static final PropagatedSpan INVALID = new PropagatedSpan(SpanContext.CC.getInvalid());
    private final SpanContext spanContext;

    @Override // io.opentelemetry.api.trace.Span
    public final Span addEvent(String str) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final Span addEvent(String str, long j, TimeUnit timeUnit) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final Span addEvent(String str, Attributes attributes) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final Span addEvent(String str, Attributes attributes, long j, TimeUnit timeUnit) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final /* synthetic */ Span addEvent(String str, Attributes attributes, Instant instant) {
        return Span.CC.$default$addEvent(this, str, attributes, instant);
    }

    @Override // io.opentelemetry.api.trace.Span
    public final /* synthetic */ Span addEvent(String str, Instant instant) {
        return Span.CC.$default$addEvent(this, str, instant);
    }

    @Override // io.opentelemetry.api.trace.Span
    public final void end() {
    }

    @Override // io.opentelemetry.api.trace.Span
    public final void end(long j, TimeUnit timeUnit) {
    }

    @Override // io.opentelemetry.api.trace.Span
    public final /* synthetic */ void end(Instant instant) {
        Span.CC.$default$end(this, instant);
    }

    @Override // io.opentelemetry.api.trace.Span
    public final boolean isRecording() {
        return false;
    }

    @Override // io.opentelemetry.context.ImplicitContextKeyed
    public final /* synthetic */ Scope makeCurrent() {
        Scope makeCurrent;
        makeCurrent = Context.CC.current().with(this).makeCurrent();
        return makeCurrent;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final Span recordException(Throwable th) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final Span recordException(Throwable th, Attributes attributes) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final Span setAllAttributes(Attributes attributes) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final /* synthetic */ Span setAttribute(AttributeKey attributeKey, int i) {
        Span attribute;
        attribute = setAttribute((AttributeKey<AttributeKey>) attributeKey, (AttributeKey) Long.valueOf(i));
        return attribute;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final <T> Span setAttribute(AttributeKey<T> attributeKey, T t) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final Span setAttribute(String str, double d) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final Span setAttribute(String str, long j) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final Span setAttribute(String str, String str2) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final Span setAttribute(String str, boolean z) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final Span setStatus(StatusCode statusCode) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final Span setStatus(StatusCode statusCode, String str) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span, io.opentelemetry.context.ImplicitContextKeyed
    public final /* synthetic */ Context storeInContext(Context context) {
        Context with;
        with = context.with(SpanContextKey.KEY, this);
        return with;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final Span updateName(String str) {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Span create(SpanContext spanContext) {
        return new PropagatedSpan(spanContext);
    }

    private PropagatedSpan(SpanContext spanContext) {
        this.spanContext = spanContext;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final SpanContext getSpanContext() {
        return this.spanContext;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PropagatedSpan{");
        sb.append(this.spanContext);
        sb.append('}');
        return sb.toString();
    }
}
