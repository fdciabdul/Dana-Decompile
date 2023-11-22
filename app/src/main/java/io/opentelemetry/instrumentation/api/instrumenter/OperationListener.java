package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;

/* loaded from: classes2.dex */
public interface OperationListener {
    void onEnd(Context context, Attributes attributes, long j);

    Context onStart(Context context, Attributes attributes, long j);
}
