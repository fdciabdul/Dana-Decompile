package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;

@FunctionalInterface
/* loaded from: classes6.dex */
public interface ContextCustomizer<REQUEST> {
    Context onStart(Context context, REQUEST request, Attributes attributes);
}
