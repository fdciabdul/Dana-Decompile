package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.ContextKey;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public final class LocalRootSpan {
    private static final ContextKey<Span> KEY = ContextKey.CC.named("opentelemetry-traces-local-root-span");

    public static Span current() {
        return fromContext(Context.CC.current());
    }

    public static Span fromContext(Context context) {
        Span fromContextOrNull = fromContextOrNull(context);
        return fromContextOrNull == null ? Span.CC.getInvalid() : fromContextOrNull;
    }

    @Nullable
    public static Span fromContextOrNull(Context context) {
        return (Span) context.get(KEY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isLocalRoot(Context context) {
        SpanContext spanContext = Span.CC.fromContext(context).getSpanContext();
        return !spanContext.isValid() || spanContext.isRemote();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context store(Context context, Span span) {
        return context.with(KEY, span);
    }

    private LocalRootSpan() {
    }
}
