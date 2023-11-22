package io.opentelemetry.context.propagation;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class DefaultContextPropagators implements ContextPropagators {
    private static final ContextPropagators NOOP = new DefaultContextPropagators(NoopTextMapPropagator.getInstance());
    private final TextMapPropagator textMapPropagator;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ContextPropagators noop() {
        return NOOP;
    }

    @Override // io.opentelemetry.context.propagation.ContextPropagators
    public final TextMapPropagator getTextMapPropagator() {
        return this.textMapPropagator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultContextPropagators(TextMapPropagator textMapPropagator) {
        this.textMapPropagator = textMapPropagator;
    }
}
