package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.internal.ArrayQueue;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00042\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0006J\u0015\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00028UX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u001c\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001e\u001a\u00020\u00078UX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014R\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0018\u00010!8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b$\u0010%"}, d2 = {"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "", "unconfined", "", "decrementUseCount", "(Z)V", "", "delta", "(Z)J", "Lkotlinx/coroutines/DispatchedTask;", "task", "dispatchUnconfined", "(Lkotlinx/coroutines/DispatchedTask;)V", "incrementUseCount", "", "parallelism", "limitedParallelism", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "processNextEvent", "()J", "processUnconfinedEvent", "()Z", "shouldBeProcessedFromContext", "shutdown", "()V", "isEmpty", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "getNextTime", "nextTime", "shared", "Z", "Lkotlinx/coroutines/internal/ArrayQueue;", "unconfinedQueue", "Lkotlinx/coroutines/internal/ArrayQueue;", "useCount", "J", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class EventLoop extends CoroutineDispatcher {
    private boolean shared;
    private ArrayQueue<DispatchedTask<?>> unconfinedQueue;
    private long useCount;

    private final long delta(boolean unconfined) {
        return unconfined ? 4294967296L : 1L;
    }

    public boolean shouldBeProcessedFromContext() {
        return false;
    }

    public void shutdown() {
    }

    public long processNextEvent() {
        if (processUnconfinedEvent()) {
            return 0L;
        }
        return LongCompanionObject.MAX_VALUE;
    }

    @JvmName(name = "isEmpty")
    protected boolean isEmpty() {
        return isUnconfinedQueueEmpty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getNextTime")
    public long getNextTime() {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.unconfinedQueue;
        if (arrayQueue == null || arrayQueue.isEmpty()) {
            return LongCompanionObject.MAX_VALUE;
        }
        return 0L;
    }

    public final boolean processUnconfinedEvent() {
        DispatchedTask<?> removeFirstOrNull;
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.unconfinedQueue;
        if (arrayQueue == null || (removeFirstOrNull = arrayQueue.removeFirstOrNull()) == null) {
            return false;
        }
        removeFirstOrNull.run();
        return true;
    }

    public final void dispatchUnconfined(DispatchedTask<?> task) {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.unconfinedQueue;
        if (arrayQueue == null) {
            arrayQueue = new ArrayQueue<>();
            this.unconfinedQueue = arrayQueue;
        }
        arrayQueue.addLast(task);
    }

    @JvmName(name = "isUnconfinedLoopActive")
    public final boolean isUnconfinedLoopActive() {
        return this.useCount >= delta(true);
    }

    @JvmName(name = "isUnconfinedQueueEmpty")
    public final boolean isUnconfinedQueueEmpty() {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.unconfinedQueue;
        if (arrayQueue != null) {
            return arrayQueue.isEmpty();
        }
        return true;
    }

    public static /* synthetic */ void incrementUseCount$default(EventLoop eventLoop, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        eventLoop.incrementUseCount(z);
    }

    public final void incrementUseCount(boolean unconfined) {
        this.useCount += delta(unconfined);
        if (unconfined) {
            return;
        }
        this.shared = true;
    }

    public static /* synthetic */ void decrementUseCount$default(EventLoop eventLoop, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        eventLoop.decrementUseCount(z);
    }

    public final void decrementUseCount(boolean unconfined) {
        long delta = this.useCount - delta(unconfined);
        this.useCount = delta;
        if (delta > 0) {
            return;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(this.useCount == 0)) {
                throw new AssertionError();
            }
        }
        if (this.shared) {
            shutdown();
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int parallelism) {
        LimitedDispatcherKt.checkParallelism(parallelism);
        return this;
    }
}
