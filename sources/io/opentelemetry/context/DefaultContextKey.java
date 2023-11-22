package io.opentelemetry.context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class DefaultContextKey<T> implements ContextKey<T> {
    private final String name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultContextKey(String str) {
        this.name = str;
    }

    public final String toString() {
        return this.name;
    }
}
