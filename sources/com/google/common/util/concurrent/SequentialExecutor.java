package com.google.common.util.concurrent;

import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class SequentialExecutor implements Executor {
    private final Executor executor;
    public static final byte[] getAuthRequestContext = {120, 42, -65, -64, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int MyBillsEntityDataFactory = 112;
    private static final Logger log = Logger.getLogger(SequentialExecutor.class.getName());
    private final Deque<Runnable> queue = new ArrayDeque();
    private WorkerRunningState workerRunningState = WorkerRunningState.IDLE;
    private long workerRunCount = 0;
    private final QueueWorker worker = new QueueWorker();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r5, int r6, byte r7, java.lang.Object[] r8) {
        /*
            int r7 = r7 * 2
            int r7 = r7 + 16
            int r6 = r6 * 15
            int r6 = r6 + 4
            byte[] r0 = com.google.common.util.concurrent.SequentialExecutor.getAuthRequestContext
            int r5 = r5 + 105
            byte[] r1 = new byte[r7]
            r2 = -1
            int r7 = r7 + r2
            if (r0 != 0) goto L19
            r5 = r6
            r2 = r1
            r3 = -1
            r1 = r0
            r0 = r8
            r8 = r7
            goto L35
        L19:
            r4 = r6
            r6 = r5
            r5 = r4
        L1c:
            int r2 = r2 + 1
            byte r3 = (byte) r6
            r1[r2] = r3
            if (r2 != r7) goto L2c
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r1, r6)
            r8[r6] = r5
            return
        L2c:
            r3 = r0[r5]
            r4 = r8
            r8 = r7
            r7 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r4
        L35:
            int r6 = r6 + r7
            int r5 = r5 + 1
            int r6 = r6 + 2
            r7 = r8
            r8 = r0
            r0 = r1
            r1 = r2
            r2 = r3
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.SequentialExecutor.a(int, int, byte, java.lang.Object[]):void");
    }

    static /* synthetic */ long access$308(SequentialExecutor sequentialExecutor) {
        long j = sequentialExecutor.workerRunCount;
        sequentialExecutor.workerRunCount = 1 + j;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SequentialExecutor(Executor executor) {
        this.executor = (Executor) Preconditions.checkNotNull(executor);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(final Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        synchronized (this.queue) {
            if (this.workerRunningState != WorkerRunningState.RUNNING && this.workerRunningState != WorkerRunningState.QUEUED) {
                long j = this.workerRunCount;
                Runnable runnable2 = new Runnable(this) { // from class: com.google.common.util.concurrent.SequentialExecutor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        runnable.run();
                    }

                    public String toString() {
                        return runnable.toString();
                    }
                };
                this.queue.add(runnable2);
                this.workerRunningState = WorkerRunningState.QUEUING;
                try {
                    this.executor.execute(this.worker);
                    if (this.workerRunningState != WorkerRunningState.QUEUING) {
                        return;
                    }
                    synchronized (this.queue) {
                        if (this.workerRunCount == j && this.workerRunningState == WorkerRunningState.QUEUING) {
                            this.workerRunningState = WorkerRunningState.QUEUED;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e) {
                    synchronized (this.queue) {
                        if ((this.workerRunningState == WorkerRunningState.IDLE || this.workerRunningState == WorkerRunningState.QUEUING) && this.queue.removeLastOccurrence(runnable2)) {
                            r7 = true;
                        }
                        if (!(e instanceof RejectedExecutionException) || r7) {
                            throw e;
                        }
                    }
                    return;
                }
            }
            this.queue.add(runnable);
        }
    }

    /* loaded from: classes7.dex */
    final class QueueWorker implements Runnable {
        public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {41, -91, 83, 107, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
        public static final int getAuthRequestContext = 2;
        @CheckForNull
        Runnable task;

        /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0033). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(int r7, int r8, short r9, java.lang.Object[] r10) {
            /*
                byte[] r0 = com.google.common.util.concurrent.SequentialExecutor.QueueWorker.KClassImpl$Data$declaredNonStaticMembers$2
                int r8 = r8 * 7
                int r8 = 106 - r8
                int r7 = r7 * 12
                int r7 = 15 - r7
                int r9 = r9 * 3
                int r9 = 16 - r9
                byte[] r1 = new byte[r9]
                r2 = 0
                if (r0 != 0) goto L19
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                goto L33
            L19:
                r3 = 0
            L1a:
                int r7 = r7 + 1
                int r4 = r3 + 1
                byte r5 = (byte) r8
                r1[r3] = r5
                if (r4 != r9) goto L2b
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L2b:
                r3 = r0[r7]
                r6 = r10
                r10 = r9
                r9 = r3
                r3 = r1
                r1 = r0
                r0 = r6
            L33:
                int r8 = r8 + r9
                int r8 = r8 + 2
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L1a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.SequentialExecutor.QueueWorker.a(int, int, short, java.lang.Object[]):void");
        }

        private QueueWorker() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                workOnQueue();
            } catch (Error e) {
                synchronized (SequentialExecutor.this.queue) {
                    SequentialExecutor.this.workerRunningState = WorkerRunningState.IDLE;
                    throw e;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
        
            r11.this$0.workerRunningState = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.IDLE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x007e, code lost:
        
            if (r1 == false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
        
            r1 = (byte) (com.google.common.util.concurrent.SequentialExecutor.QueueWorker.getAuthRequestContext - 2);
            r2 = r1;
            r7 = new java.lang.Object[1];
            a(r1, r2, r2, r7);
            r1 = java.lang.Class.forName((java.lang.String) r7[0]);
            r2 = com.google.common.util.concurrent.SequentialExecutor.QueueWorker.KClassImpl$Data$declaredNonStaticMembers$2[15];
            r3 = r2;
            r4 = new java.lang.Object[1];
            a(r2, r3, r3, r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00ae, code lost:
        
            ((java.lang.Thread) r1.getMethod((java.lang.String) r4[0], null).invoke(null, null)).interrupt();
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00b2, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00b3, code lost:
        
            r1 = r0.getCause();
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00b7, code lost:
        
            if (r1 != null) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00b9, code lost:
        
            throw r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00ba, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00bb, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00c1, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00c2, code lost:
        
            r11.task.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00c8, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00ca, code lost:
        
            r6 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00cb, code lost:
        
            r7 = com.google.common.util.concurrent.SequentialExecutor.log;
            r8 = java.util.logging.Level.SEVERE;
            r9 = new java.lang.StringBuilder();
            r9.append("Exception while executing runnable ");
            r9.append(r11.task);
            r7.log(r8, r9.toString(), (java.lang.Throwable) r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00eb, code lost:
        
            r11.task = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00ed, code lost:
        
            throw r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:?, code lost:
        
            return;
         */
        /* JADX WARN: Removed duplicated region for block: B:63:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void workOnQueue() {
            /*
                Method dump skipped, instructions count: 306
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.SequentialExecutor.QueueWorker.workOnQueue():void");
        }

        public final String toString() {
            Runnable runnable = this.task;
            if (runnable != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("SequentialExecutorWorker{running=");
                sb.append(runnable);
                sb.append("}");
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SequentialExecutorWorker{state=");
            sb2.append(SequentialExecutor.this.workerRunningState);
            sb2.append("}");
            return sb2.toString();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SequentialExecutor@");
        try {
            Object[] objArr = {this};
            byte b = (byte) (-getAuthRequestContext[5]);
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b3 = (byte) (getAuthRequestContext[5] + 1);
            byte b4 = b3;
            Object[] objArr3 = new Object[1];
            a(b3, b4, b4, objArr3);
            sb.append(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue());
            sb.append("{");
            sb.append(this.executor);
            sb.append("}");
            return sb.toString();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
