package io.opentelemetry.instrumentation.api.internal;

import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public interface SpanKeyProvider {
    @Nullable
    SpanKey internalGetSpanKey();
}
