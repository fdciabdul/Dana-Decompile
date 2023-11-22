package io.opentelemetry.context.propagation;

import java.util.Objects;

/* loaded from: classes2.dex */
public interface ContextPropagators {
    TextMapPropagator getTextMapPropagator();

    /* renamed from: io.opentelemetry.context.propagation.ContextPropagators$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static ContextPropagators create(TextMapPropagator textMapPropagator) {
            Objects.requireNonNull(textMapPropagator, "textPropagator");
            return new DefaultContextPropagators(textMapPropagator);
        }

        public static ContextPropagators noop() {
            return DefaultContextPropagators.noop();
        }
    }
}
