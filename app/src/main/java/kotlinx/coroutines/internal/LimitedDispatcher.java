package kotlinx.coroutines.internal;

import com.ap.zoloz.hummer.biz.HummerConstants;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004B\u0017\u0012\u0006\u0010 \u001a\u00020\u0001\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b+\u0010,J\u001b\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\rJ,\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\n\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\"R\u001e\u0010$\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030#8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010\"R\u0018\u0010)\u001a\u00060'j\u0002`(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b)\u0010*"}, d2 = {"Lkotlinx/coroutines/internal/LimitedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlinx/coroutines/Delay;", "block", "", "addAndTryDispatching", "(Ljava/lang/Runnable;)Z", "Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "dispatchYield", "", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "", "parallelism", "limitedParallelism", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "run", "()V", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "tryAllocateWorker", "()Z", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "I", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "runningWorkers", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "workerAllocationLock", "Ljava/lang/Object;", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class LimitedDispatcher extends CoroutineDispatcher implements Runnable, Delay {
    private final /* synthetic */ Delay $$delegate_0;
    private final CoroutineDispatcher dispatcher;
    private final int parallelism;
    private final LockFreeTaskQueue<Runnable> queue;
    private volatile int runningWorkers;
    private final Object workerAllocationLock;

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle invokeOnTimeout(long timeMillis, Runnable block, CoroutineContext context) {
        return this.$$delegate_0.invokeOnTimeout(timeMillis, block, context);
    }

    @Override // kotlinx.coroutines.Delay
    /* renamed from: scheduleResumeAfterDelay */
    public final void mo4662scheduleResumeAfterDelay(long timeMillis, CancellableContinuation<? super Unit> continuation) {
        this.$$delegate_0.mo4662scheduleResumeAfterDelay(timeMillis, continuation);
    }

    public LimitedDispatcher(CoroutineDispatcher coroutineDispatcher, int i) {
        this.dispatcher = coroutineDispatcher;
        this.parallelism = i;
        Delay delay = coroutineDispatcher instanceof Delay ? (Delay) coroutineDispatcher : null;
        this.$$delegate_0 = delay == null ? DefaultExecutorKt.getDefaultDelay() : delay;
        this.queue = new LockFreeTaskQueue<>(false);
        this.workerAllocationLock = new Object();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int parallelism) {
        LimitedDispatcherKt.checkParallelism(parallelism);
        return parallelism >= this.parallelism ? this : super.limitedParallelism(parallelism);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        r0 = r3.workerAllocationLock;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        monitor-enter(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        r3.runningWorkers--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
    
        if (r3.queue.getSize() != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
    
        monitor-exit(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        r3.runningWorkers++;
        r1 = kotlin.Unit.INSTANCE;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r3 = this;
        L0:
            r0 = 0
        L1:
            kotlinx.coroutines.internal.LockFreeTaskQueue<java.lang.Runnable> r1 = r3.queue
            java.lang.Object r1 = r1.removeFirstOrNull()
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            if (r1 == 0) goto L31
            r1.run()     // Catch: java.lang.Throwable -> Lf
            goto L17
        Lf:
            r1 = move-exception
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            kotlinx.coroutines.CoroutineExceptionHandlerKt.handleCoroutineException(r2, r1)
        L17:
            int r0 = r0 + 1
            r1 = 16
            if (r0 < r1) goto L1
            kotlinx.coroutines.CoroutineDispatcher r1 = r3.dispatcher
            r2 = r3
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            boolean r1 = r1.isDispatchNeeded(r2)
            if (r1 == 0) goto L1
            kotlinx.coroutines.CoroutineDispatcher r0 = r3.dispatcher
            r1 = r3
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r0.mo4661dispatch(r2, r1)
            return
        L31:
            java.lang.Object r0 = r3.workerAllocationLock
            monitor-enter(r0)
            int r1 = r3.runningWorkers     // Catch: java.lang.Throwable -> L4e
            int r1 = r1 + (-1)
            r3.runningWorkers = r1     // Catch: java.lang.Throwable -> L4e
            kotlinx.coroutines.internal.LockFreeTaskQueue<java.lang.Runnable> r1 = r3.queue     // Catch: java.lang.Throwable -> L4e
            int r1 = r1.getSize()     // Catch: java.lang.Throwable -> L4e
            if (r1 != 0) goto L44
            monitor-exit(r0)
            return
        L44:
            int r1 = r3.runningWorkers     // Catch: java.lang.Throwable -> L4e
            int r1 = r1 + 1
            r3.runningWorkers = r1     // Catch: java.lang.Throwable -> L4e
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L4e
            monitor-exit(r0)
            goto L0
        L4e:
            r1 = move-exception
            monitor-exit(r0)
            goto L52
        L51:
            throw r1
        L52:
            goto L51
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LimitedDispatcher.run():void");
    }

    private final boolean tryAllocateWorker() {
        synchronized (this.workerAllocationLock) {
            if (this.runningWorkers >= this.parallelism) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }

    private final boolean addAndTryDispatching(Runnable block) {
        this.queue.addLast(block);
        return this.runningWorkers >= this.parallelism;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch */
    public final void mo4661dispatch(CoroutineContext context, Runnable block) {
        if (addAndTryDispatching(block) || !tryAllocateWorker()) {
            return;
        }
        this.dispatcher.mo4661dispatch(this, this);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext context, Runnable block) {
        if (addAndTryDispatching(block) || !tryAllocateWorker()) {
            return;
        }
        this.dispatcher.dispatchYield(this, this);
    }
}
