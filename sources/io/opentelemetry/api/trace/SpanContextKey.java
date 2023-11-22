package io.opentelemetry.api.trace;

import io.opentelemetry.context.ContextKey;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class SpanContextKey {
    static final ContextKey<Span> KEY = ContextKey.CC.named("opentelemetry-trace-span-key");

    private SpanContextKey() {
    }
}
