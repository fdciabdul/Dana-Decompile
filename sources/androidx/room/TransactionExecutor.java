package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
class TransactionExecutor implements Executor {
    private final ArrayDeque<Runnable> BuiltInFictitiousFunctionClassFactory = new ArrayDeque<>();
    private final Executor PlaceComponentResult;
    private Runnable getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransactionExecutor(Executor executor) {
        this.PlaceComponentResult = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        synchronized (this) {
            this.BuiltInFictitiousFunctionClassFactory.offer(new Runnable() { // from class: androidx.room.TransactionExecutor.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        TransactionExecutor.this.BuiltInFictitiousFunctionClassFactory();
                    }
                }
            });
            if (this.getAuthRequestContext == null) {
                BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    final void BuiltInFictitiousFunctionClassFactory() {
        synchronized (this) {
            Runnable poll = this.BuiltInFictitiousFunctionClassFactory.poll();
            this.getAuthRequestContext = poll;
            if (poll != null) {
                this.PlaceComponentResult.execute(poll);
            }
        }
    }
}
