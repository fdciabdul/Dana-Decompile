package io.opentelemetry.context.propagation;

import io.opentelemetry.context.Context;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
final class NoopTextMapPropagator implements TextMapPropagator {
    private static final NoopTextMapPropagator INSTANCE = new NoopTextMapPropagator();

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public final <C> void inject(Context context, @Nullable C c, TextMapSetter<C> textMapSetter) {
    }

    NoopTextMapPropagator() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TextMapPropagator getInstance() {
        return INSTANCE;
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public final Collection<String> fields() {
        return Collections.emptyList();
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public final <C> Context extract(Context context, @Nullable C c, TextMapGetter<C> textMapGetter) {
        return context == null ? Context.CC.root() : context;
    }
}
