package io.opentelemetry.context;

import io.opentelemetry.context.ThreadLocalContextStorage;

/* loaded from: classes2.dex */
public interface Scope extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();

    /* renamed from: io.opentelemetry.context.Scope$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
        public static Scope noop() {
            return ThreadLocalContextStorage.NoopScope.INSTANCE;
        }
    }
}
