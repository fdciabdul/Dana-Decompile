package io.opentelemetry.instrumentation.api.server;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.LocalRootSpan;
import javax.annotation.Nullable;

@Deprecated
/* loaded from: classes9.dex */
public final class ServerSpan {
    @Nullable
    public static Span fromContextOrNull(Context context) {
        return LocalRootSpan.fromContextOrNull(context);
    }

    private ServerSpan() {
    }
}
