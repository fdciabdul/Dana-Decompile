package com.google.common.util.concurrent;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable DONE;
    private static final int MAX_BUSY_WAIT_SPINS = 1000;
    private static final Runnable PARKED;
    public static final byte[] getAuthRequestContext = {4, -41, 37, 5, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 131;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 7
            int r8 = r8 + 99
            int r7 = r7 + 4
            int r9 = r9 * 3
            int r9 = 16 - r9
            byte[] r0 = com.google.common.util.concurrent.InterruptibleTask.getAuthRequestContext
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L31
        L17:
            r3 = 0
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r9) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            int r7 = r7 + 1
            r3 = r0[r7]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L31:
            int r9 = -r9
            int r8 = r8 + r9
            int r8 = r8 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.InterruptibleTask.a(short, short, short, java.lang.Object[]):void");
    }

    abstract void afterRanInterruptiblyFailure(Throwable th);

    abstract void afterRanInterruptiblySuccess(@ParametricNullness T t);

    abstract boolean isDone();

    @ParametricNullness
    abstract T runInterruptibly() throws Exception;

    abstract String toPendingString();

    /* loaded from: classes7.dex */
    static final class DoNothingRunnable implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
        }

        private DoNothingRunnable() {
        }
    }

    static {
        DONE = new DoNothingRunnable();
        PARKED = new DoNothingRunnable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        try {
            byte b = getAuthRequestContext[16];
            byte b2 = (byte) (-getAuthRequestContext[15]);
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = getAuthRequestContext[15];
            Object[] objArr2 = new Object[1];
            a(b3, (byte) (b3 + 1), (byte) (-getAuthRequestContext[15]), objArr2);
            Object obj = null;
            Thread thread = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
            if (compareAndSet(null, thread)) {
                boolean z = !isDone();
                if (z) {
                    try {
                        obj = runInterruptibly();
                    } catch (Throwable th) {
                        try {
                            Platform.restoreInterruptIfIsInterruptedException(th);
                            if (!compareAndSet(thread, DONE)) {
                                waitForInterrupt(thread);
                            }
                            if (z) {
                                afterRanInterruptiblyFailure(th);
                                return;
                            }
                            return;
                        } finally {
                            if (!compareAndSet(thread, DONE)) {
                                waitForInterrupt(thread);
                            }
                            if (z) {
                                afterRanInterruptiblySuccess(NullnessCasts.uncheckedCastNullableTToT(null));
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause == null) {
                throw th2;
            }
            throw cause;
        }
    }

    private void waitForInterrupt(Thread thread) {
        Runnable runnable = get();
        Blocker blocker = null;
        int i = 0;
        boolean z = false;
        while (true) {
            boolean z2 = runnable instanceof Blocker;
            if (!z2 && runnable != PARKED) {
                break;
            }
            if (z2) {
                blocker = (Blocker) runnable;
            }
            i++;
            if (i > 1000) {
                Runnable runnable2 = PARKED;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    z = Thread.interrupted() || z;
                    LockSupport.park(blocker);
                }
            } else {
                Thread.yield();
            }
            runnable = get();
        }
        if (z) {
            thread.interrupt();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void interruptTask() {
        Runnable runnable = get();
        byte[] bArr = getAuthRequestContext;
        byte b = bArr[16];
        byte b2 = (byte) (-bArr[15]);
        Object[] objArr = new Object[1];
        a(b, b2, (byte) (b2 - 1), objArr);
        if (Class.forName((String) objArr[0]).isInstance(runnable)) {
            Blocker blocker = new Blocker();
            try {
                byte b3 = getAuthRequestContext[16];
                byte b4 = (byte) (-getAuthRequestContext[15]);
                Object[] objArr2 = new Object[1];
                a(b3, b4, (byte) (b4 - 1), objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b5 = getAuthRequestContext[15];
                Object[] objArr3 = new Object[1];
                a(b5, (byte) (b5 + 1), (byte) (-getAuthRequestContext[15]), objArr3);
                blocker.setOwner((Thread) cls.getMethod((String) objArr3[0], null).invoke(null, null));
                if (compareAndSet(runnable, blocker)) {
                    try {
                        ((Thread) runnable).interrupt();
                    } finally {
                        if (getAndSet(DONE) == PARKED) {
                            LockSupport.unpark((Thread) runnable);
                        }
                    }
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class Blocker extends AbstractOwnableSynchronizer implements Runnable {
        private final InterruptibleTask<?> task;

        @Override // java.lang.Runnable
        public final void run() {
        }

        private Blocker(InterruptibleTask<?> interruptibleTask) {
            this.task = interruptibleTask;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOwner(Thread thread) {
            super.setExclusiveOwnerThread(thread);
        }

        final Thread getOwner() {
            return super.getExclusiveOwnerThread();
        }

        public final String toString() {
            return this.task.toString();
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = get();
        if (runnable == DONE) {
            str = "running=[DONE]";
        } else if (runnable instanceof Blocker) {
            str = "running=[INTERRUPTED]";
        } else {
            byte[] bArr = getAuthRequestContext;
            byte b = bArr[16];
            byte b2 = (byte) (-bArr[15]);
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr);
            if (Class.forName((String) objArr[0]).isInstance(runnable)) {
                StringBuilder sb = new StringBuilder();
                sb.append("running=[RUNNING ON ");
                sb.append(((Thread) runnable).getName());
                sb.append("]");
                str = sb.toString();
            } else {
                str = "running=[NOT STARTED YET]";
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(", ");
        sb2.append(toPendingString());
        return sb2.toString();
    }
}
