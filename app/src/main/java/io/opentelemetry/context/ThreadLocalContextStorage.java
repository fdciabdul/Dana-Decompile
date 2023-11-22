package io.opentelemetry.context;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public enum ThreadLocalContextStorage implements ContextStorage {
    INSTANCE;

    private static final Logger logger = Logger.getLogger(ThreadLocalContextStorage.class.getName());
    private static final ThreadLocal<Context> THREAD_LOCAL_STORAGE = new ThreadLocal<>();

    /* loaded from: classes6.dex */
    enum NoopScope implements Scope {
        INSTANCE;

        @Override // io.opentelemetry.context.Scope, java.lang.AutoCloseable
        public final void close() {
        }
    }

    @Override // io.opentelemetry.context.ContextStorage
    public final /* synthetic */ Context root() {
        Context root;
        root = ArrayBasedContext.root();
        return root;
    }

    @Override // io.opentelemetry.context.ContextStorage
    public final Scope attach(final Context context) {
        if (context == null) {
            return NoopScope.INSTANCE;
        }
        final Context current = current();
        if (context == current) {
            return NoopScope.INSTANCE;
        }
        THREAD_LOCAL_STORAGE.set(context);
        return new Scope() { // from class: io.opentelemetry.context.ThreadLocalContextStorage$$ExternalSyntheticLambda0
            @Override // io.opentelemetry.context.Scope, java.lang.AutoCloseable
            public final void close() {
                ThreadLocalContextStorage.this.m3150x499db40(context, current);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$attach$0$io-opentelemetry-context-ThreadLocalContextStorage  reason: not valid java name */
    public final /* synthetic */ void m3150x499db40(Context context, Context context2) {
        if (current() != context) {
            logger.log(Level.FINE, "Context in storage not the expected context, Scope.close was not called correctly");
        }
        THREAD_LOCAL_STORAGE.set(context2);
    }

    @Override // io.opentelemetry.context.ContextStorage
    @Nullable
    public final Context current() {
        return THREAD_LOCAL_STORAGE.get();
    }
}
