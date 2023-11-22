package com.google.common.util.concurrent;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class ExecutionSequencer {
    private final AtomicReference<ListenableFuture<Void>> ref = new AtomicReference<>(Futures.immediateVoidFuture());
    private ThreadConfinedTaskQueue latestTaskQueue = new ThreadConfinedTaskQueue();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    private ExecutionSequencer() {
    }

    public static ExecutionSequencer create() {
        return new ExecutionSequencer();
    }

    /* loaded from: classes7.dex */
    static final class ThreadConfinedTaskQueue {
        @CheckForNull
        Executor nextExecutor;
        @CheckForNull
        Runnable nextTask;
        @CheckForNull
        Thread thread;

        private ThreadConfinedTaskQueue() {
        }
    }

    public final <T> ListenableFuture<T> submit(final Callable<T> callable, Executor executor) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(executor);
        return submitAsync(new AsyncCallable<T>(this) { // from class: com.google.common.util.concurrent.ExecutionSequencer.1
            @Override // com.google.common.util.concurrent.AsyncCallable
            public ListenableFuture<T> call() throws Exception {
                return Futures.immediateFuture(callable.call());
            }

            public String toString() {
                return callable.toString();
            }
        }, executor);
    }

    public final <T> ListenableFuture<T> submitAsync(final AsyncCallable<T> asyncCallable, Executor executor) {
        Preconditions.checkNotNull(asyncCallable);
        Preconditions.checkNotNull(executor);
        final TaskNonReentrantExecutor taskNonReentrantExecutor = new TaskNonReentrantExecutor(executor, this);
        AsyncCallable<T> asyncCallable2 = new AsyncCallable<T>(this) { // from class: com.google.common.util.concurrent.ExecutionSequencer.2
            @Override // com.google.common.util.concurrent.AsyncCallable
            public ListenableFuture<T> call() throws Exception {
                if (!taskNonReentrantExecutor.trySetStarted()) {
                    return Futures.immediateCancelledFuture();
                }
                return asyncCallable.call();
            }

            public String toString() {
                return asyncCallable.toString();
            }
        };
        final SettableFuture create = SettableFuture.create();
        final ListenableFuture<Void> andSet = this.ref.getAndSet(create);
        final TrustedListenableFutureTask create2 = TrustedListenableFutureTask.create(asyncCallable2);
        andSet.addListener(create2, taskNonReentrantExecutor);
        final ListenableFuture<T> nonCancellationPropagating = Futures.nonCancellationPropagating(create2);
        Runnable runnable = new Runnable() { // from class: com.google.common.util.concurrent.ExecutionSequencer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ExecutionSequencer.lambda$submitAsync$0(TrustedListenableFutureTask.this, create, andSet, nonCancellationPropagating, taskNonReentrantExecutor);
            }
        };
        nonCancellationPropagating.addListener(runnable, MoreExecutors.directExecutor());
        create2.addListener(runnable, MoreExecutors.directExecutor());
        return nonCancellationPropagating;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$submitAsync$0(TrustedListenableFutureTask trustedListenableFutureTask, SettableFuture settableFuture, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, TaskNonReentrantExecutor taskNonReentrantExecutor) {
        if (trustedListenableFutureTask.isDone()) {
            settableFuture.setFuture(listenableFuture);
        } else if (listenableFuture2.isCancelled() && taskNonReentrantExecutor.trySetCancelled()) {
            trustedListenableFutureTask.cancel(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class TaskNonReentrantExecutor extends AtomicReference<RunningState> implements Executor, Runnable {
        public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {Ascii.DC4, -68, -64, 70, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        public static final int PlaceComponentResult = 181;
        @CheckForNull
        Executor delegate;
        @CheckForNull
        ExecutionSequencer sequencer;
        @CheckForNull
        Thread submitting;
        @CheckForNull
        Runnable task;

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0035). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(short r8, int r9, byte r10, java.lang.Object[] r11) {
            /*
                int r10 = r10 * 3
                int r10 = 16 - r10
                int r8 = r8 * 7
                int r8 = 106 - r8
                byte[] r0 = com.google.common.util.concurrent.ExecutionSequencer.TaskNonReentrantExecutor.KClassImpl$Data$declaredNonStaticMembers$2
                int r9 = r9 + 4
                byte[] r1 = new byte[r10]
                r2 = 0
                if (r0 != 0) goto L18
                r8 = r9
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r11
                r11 = r10
                goto L35
            L18:
                r3 = 0
            L19:
                int r4 = r3 + 1
                byte r5 = (byte) r8
                r1[r3] = r5
                int r9 = r9 + 1
                if (r4 != r10) goto L2a
                java.lang.String r8 = new java.lang.String
                r8.<init>(r1, r2)
                r11[r2] = r8
                return
            L2a:
                r3 = r0[r9]
                r6 = r9
                r9 = r8
                r8 = r6
                r7 = r11
                r11 = r10
                r10 = r3
                r3 = r1
                r1 = r0
                r0 = r7
            L35:
                int r10 = -r10
                int r9 = r9 + r10
                int r9 = r9 + 2
                r10 = r11
                r11 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r6 = r9
                r9 = r8
                r8 = r6
                goto L19
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ExecutionSequencer.TaskNonReentrantExecutor.a(short, int, byte, java.lang.Object[]):void");
        }

        private TaskNonReentrantExecutor(Executor executor, ExecutionSequencer executionSequencer) {
            super(RunningState.NOT_RUN);
            this.delegate = executor;
            this.sequencer = executionSequencer;
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            if (get() == RunningState.CANCELLED) {
                this.delegate = null;
                this.sequencer = null;
                return;
            }
            try {
                boolean z = true;
                Object[] objArr = new Object[1];
                a((byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1), KClassImpl$Data$declaredNonStaticMembers$2[16], (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[15];
                Object[] objArr2 = new Object[1];
                a(b, b2, (byte) (-b2), objArr2);
                this.submitting = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
                try {
                    ThreadConfinedTaskQueue threadConfinedTaskQueue = ((ExecutionSequencer) Objects.requireNonNull(this.sequencer)).latestTaskQueue;
                    if (threadConfinedTaskQueue.thread == this.submitting) {
                        this.sequencer = null;
                        if (threadConfinedTaskQueue.nextTask != null) {
                            z = false;
                        }
                        Preconditions.checkState(z);
                        threadConfinedTaskQueue.nextTask = runnable;
                        threadConfinedTaskQueue.nextExecutor = (Executor) Objects.requireNonNull(this.delegate);
                        this.delegate = null;
                    } else {
                        Executor executor = (Executor) Objects.requireNonNull(this.delegate);
                        this.delegate = null;
                        this.task = runnable;
                        executor.execute(this);
                    }
                } finally {
                    this.submitting = null;
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }

        /* JADX WARN: Type inference failed for: r1v4, types: [com.google.common.util.concurrent.ExecutionSequencer$1, java.lang.Thread] */
        @Override // java.lang.Runnable
        public final void run() {
            Executor executor;
            try {
                Object[] objArr = new Object[1];
                a((byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1), KClassImpl$Data$declaredNonStaticMembers$2[16], (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[15];
                Object[] objArr2 = new Object[1];
                a(b, b2, (byte) (-b2), objArr2);
                ?? r1 = 0;
                Thread thread = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
                if (thread != this.submitting) {
                    Runnable runnable = (Runnable) Objects.requireNonNull(this.task);
                    this.task = null;
                    runnable.run();
                    return;
                }
                ThreadConfinedTaskQueue threadConfinedTaskQueue = new ThreadConfinedTaskQueue();
                threadConfinedTaskQueue.thread = thread;
                ((ExecutionSequencer) Objects.requireNonNull(this.sequencer)).latestTaskQueue = threadConfinedTaskQueue;
                this.sequencer = null;
                try {
                    Runnable runnable2 = (Runnable) Objects.requireNonNull(this.task);
                    this.task = null;
                    runnable2.run();
                    while (true) {
                        Runnable runnable3 = threadConfinedTaskQueue.nextTask;
                        if (runnable3 == null || (executor = threadConfinedTaskQueue.nextExecutor) == null) {
                            break;
                        }
                        threadConfinedTaskQueue.nextTask = null;
                        threadConfinedTaskQueue.nextExecutor = null;
                        executor.execute(runnable3);
                    }
                } finally {
                    threadConfinedTaskQueue.thread = null;
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean trySetStarted() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.STARTED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean trySetCancelled() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.CANCELLED);
        }
    }
}
