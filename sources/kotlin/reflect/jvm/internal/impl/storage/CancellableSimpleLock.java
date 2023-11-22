package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class CancellableSimpleLock extends DefaultSimpleLock {
    private final Runnable checkCancelled;
    private final Function1<InterruptedException, Unit> interruptedExceptionHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CancellableSimpleLock(Lock lock, Runnable runnable, Function1<? super InterruptedException, Unit> function1) {
        super(lock);
        Intrinsics.checkNotNullParameter(lock, "");
        Intrinsics.checkNotNullParameter(runnable, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.checkCancelled = runnable;
        this.interruptedExceptionHandler = function1;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CancellableSimpleLock(Runnable runnable, Function1<? super InterruptedException, Unit> function1) {
        this(new ReentrantLock(), runnable, function1);
        Intrinsics.checkNotNullParameter(runnable, "");
        Intrinsics.checkNotNullParameter(function1, "");
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.DefaultSimpleLock, kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public final void lock() {
        while (!getLock().tryLock(50L, TimeUnit.MILLISECONDS)) {
            try {
                this.checkCancelled.run();
            } catch (InterruptedException e) {
                this.interruptedExceptionHandler.invoke(e);
                return;
            }
        }
    }
}
