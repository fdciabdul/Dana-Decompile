package androidx.concurrent.futures;

import java.util.concurrent.Executor;

/* loaded from: classes6.dex */
enum DirectExecutor implements Executor {
    INSTANCE;

    @Override // java.lang.Enum
    public final String toString() {
        return "DirectExecutor";
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
