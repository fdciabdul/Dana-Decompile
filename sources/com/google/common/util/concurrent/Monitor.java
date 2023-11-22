package com.google.common.util.concurrent;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class Monitor {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {77, -56, -115, -110, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int MyBillsEntityDataFactory = 113;
    @CheckForNull
    private Guard activeGuards;
    private final boolean fair;
    private final ReentrantLock lock;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 12
            int r8 = 16 - r8
            int r9 = r9 * 3
            int r9 = r9 + 13
            byte[] r0 = com.google.common.util.concurrent.Monitor.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 * 7
            int r7 = r7 + 99
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L37
        L1a:
            r3 = 0
        L1b:
            r6 = r8
            r8 = r7
            r7 = r6
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L2d
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2d:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L37:
            int r8 = r8 + 1
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.a(short, short, short, java.lang.Object[]):void");
    }

    /* loaded from: classes7.dex */
    public static abstract class Guard {
        final Condition condition;
        final Monitor monitor;
        @CheckForNull
        Guard next;
        int waiterCount = 0;

        public abstract boolean isSatisfied();

        /* JADX INFO: Access modifiers changed from: protected */
        public Guard(Monitor monitor) {
            this.monitor = (Monitor) Preconditions.checkNotNull(monitor, BlobStatic.INVTP_TYPE_MONITOR);
            this.condition = monitor.lock.newCondition();
        }
    }

    public Monitor() {
        this(false);
    }

    public Monitor(boolean z) {
        this.activeGuards = null;
        this.fair = z;
        this.lock = new ReentrantLock(z);
    }

    public final void enter() {
        this.lock.lock();
    }

    public final boolean enter(long j, TimeUnit timeUnit) {
        boolean tryLock;
        long safeNanos = toSafeNanos(j, timeUnit);
        ReentrantLock reentrantLock = this.lock;
        if (!this.fair && reentrantLock.tryLock()) {
            return true;
        }
        boolean interrupted = Thread.interrupted();
        try {
            long nanoTime = System.nanoTime();
            long j2 = safeNanos;
            while (true) {
                try {
                    try {
                        tryLock = reentrantLock.tryLock(j2, TimeUnit.NANOSECONDS);
                        break;
                    } catch (Throwable th) {
                        th = th;
                        interrupted = true;
                        if (interrupted) {
                            try {
                                byte b = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                                Object[] objArr = new Object[1];
                                a(b, (byte) (b - 1), (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]), objArr);
                                Class<?> cls = Class.forName((String) objArr[0]);
                                byte b2 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
                                byte b3 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                                Object[] objArr2 = new Object[1];
                                a(b2, b3, (byte) (b3 - 1), objArr2);
                                ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                            } catch (Throwable th2) {
                                Throwable cause = th2.getCause();
                                if (cause != null) {
                                    throw cause;
                                }
                                throw th2;
                            }
                        }
                        throw th;
                    }
                } catch (InterruptedException unused) {
                    j2 = remainingNanos(nanoTime, safeNanos);
                    interrupted = true;
                }
            }
            if (interrupted) {
                try {
                    byte b4 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                    Object[] objArr3 = new Object[1];
                    a(b4, (byte) (b4 - 1), (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]), objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    byte b5 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
                    byte b6 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                    Object[] objArr4 = new Object[1];
                    a(b5, b6, (byte) (b6 - 1), objArr4);
                    ((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).interrupt();
                } catch (Throwable th3) {
                    Throwable cause2 = th3.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th3;
                }
            }
            return tryLock;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final void enterInterruptibly() throws InterruptedException {
        this.lock.lockInterruptibly();
    }

    public final boolean enterInterruptibly(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.lock.tryLock(j, timeUnit);
    }

    public final boolean tryEnter() {
        return this.lock.tryLock();
    }

    public final void enterWhen(Guard guard) throws InterruptedException {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.lock;
        boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        reentrantLock.lockInterruptibly();
        try {
            if (guard.isSatisfied()) {
                return;
            }
            await(guard, isHeldByCurrentThread);
        } catch (Throwable th) {
            leave();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
    
        if (awaitNanos(r11, r0, r3) != false) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean enterWhen(com.google.common.util.concurrent.Monitor.Guard r11, long r12, java.util.concurrent.TimeUnit r14) throws java.lang.InterruptedException {
        /*
            r10 = this;
            long r0 = toSafeNanos(r12, r14)
            com.google.common.util.concurrent.Monitor r2 = r11.monitor
            if (r2 != r10) goto L60
            java.util.concurrent.locks.ReentrantLock r2 = r10.lock
            boolean r3 = r2.isHeldByCurrentThread()
            boolean r4 = r10.fair
            r5 = 0
            r7 = 0
            if (r4 != 0) goto L29
            boolean r4 = java.lang.Thread.interrupted()
            if (r4 != 0) goto L23
            boolean r4 = r2.tryLock()
            if (r4 == 0) goto L29
            r8 = r5
            goto L34
        L23:
            java.lang.InterruptedException r11 = new java.lang.InterruptedException
            r11.<init>()
            throw r11
        L29:
            long r8 = initNanoTime(r0)
            boolean r12 = r2.tryLock(r12, r14)
            if (r12 != 0) goto L34
            return r7
        L34:
            boolean r12 = r11.isSatisfied()     // Catch: java.lang.Throwable -> L50
            if (r12 != 0) goto L49
            int r12 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r12 != 0) goto L3f
            goto L43
        L3f:
            long r0 = remainingNanos(r8, r0)     // Catch: java.lang.Throwable -> L50
        L43:
            boolean r11 = r10.awaitNanos(r11, r0, r3)     // Catch: java.lang.Throwable -> L50
            if (r11 == 0) goto L4a
        L49:
            r7 = 1
        L4a:
            if (r7 != 0) goto L4f
            r2.unlock()
        L4f:
            return r7
        L50:
            r11 = move-exception
            if (r3 != 0) goto L5c
            r10.signalNextWaiter()     // Catch: java.lang.Throwable -> L57
            goto L5c
        L57:
            r11 = move-exception
            r2.unlock()
            throw r11
        L5c:
            r2.unlock()
            throw r11
        L60:
            java.lang.IllegalMonitorStateException r11 = new java.lang.IllegalMonitorStateException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.enterWhen(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }

    public final void enterWhenUninterruptibly(Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.lock;
        boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        reentrantLock.lock();
        try {
            if (guard.isSatisfied()) {
                return;
            }
            awaitUninterruptibly(guard, isHeldByCurrentThread);
        } catch (Throwable th) {
            leave();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0051 A[Catch: all -> 0x0109, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x0109, blocks: (B:5:0x0019, B:7:0x001f, B:24:0x0051, B:35:0x00a6, B:36:0x00a9, B:11:0x0028, B:13:0x002d, B:15:0x0035, B:20:0x0041, B:22:0x004b, B:21:0x0047), top: B:71:0x0019, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x003b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean enterWhenUninterruptibly(com.google.common.util.concurrent.Monitor.Guard r17, long r18, java.util.concurrent.TimeUnit r20) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.enterWhenUninterruptibly(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }

    public final boolean enterIf(Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean isSatisfied = guard.isSatisfied();
            if (!isSatisfied) {
            }
            return isSatisfied;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean enterIf(Guard guard, long j, TimeUnit timeUnit) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        if (enter(j, timeUnit)) {
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                this.lock.unlock();
            }
        }
        return false;
    }

    public final boolean enterIfInterruptibly(Guard guard) throws InterruptedException {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        try {
            boolean isSatisfied = guard.isSatisfied();
            if (!isSatisfied) {
            }
            return isSatisfied;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean enterIfInterruptibly(Guard guard, long j, TimeUnit timeUnit) throws InterruptedException {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.lock;
        if (reentrantLock.tryLock(j, timeUnit)) {
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        }
        return false;
    }

    public final boolean tryEnterIf(Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.lock;
        if (reentrantLock.tryLock()) {
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        }
        return false;
    }

    public final void waitFor(Guard guard) throws InterruptedException {
        if (guard.monitor != this || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (guard.isSatisfied()) {
            return;
        }
        await(guard, true);
    }

    public final boolean waitFor(Guard guard, long j, TimeUnit timeUnit) throws InterruptedException {
        long safeNanos = toSafeNanos(j, timeUnit);
        if (guard.monitor != this || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (guard.isSatisfied()) {
            return true;
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return awaitNanos(guard, safeNanos, true);
    }

    public final void waitForUninterruptibly(Guard guard) {
        if (guard.monitor != this || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (guard.isSatisfied()) {
            return;
        }
        awaitUninterruptibly(guard, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean waitForUninterruptibly(com.google.common.util.concurrent.Monitor.Guard r10, long r11, java.util.concurrent.TimeUnit r13) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.waitForUninterruptibly(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }

    public final void leave() {
        ReentrantLock reentrantLock = this.lock;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                signalNextWaiter();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean isFair() {
        return this.fair;
    }

    public final boolean isOccupied() {
        return this.lock.isLocked();
    }

    public final boolean isOccupiedByCurrentThread() {
        return this.lock.isHeldByCurrentThread();
    }

    public final int getOccupiedDepth() {
        return this.lock.getHoldCount();
    }

    public final int getQueueLength() {
        return this.lock.getQueueLength();
    }

    public final boolean hasQueuedThreads() {
        return this.lock.hasQueuedThreads();
    }

    public final boolean hasQueuedThread(Thread thread) {
        return this.lock.hasQueuedThread(thread);
    }

    public final boolean hasWaiters(Guard guard) {
        return getWaitQueueLength(guard) > 0;
    }

    public final int getWaitQueueLength(Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        this.lock.lock();
        try {
            return guard.waiterCount;
        } finally {
            this.lock.unlock();
        }
    }

    private static long toSafeNanos(long j, TimeUnit timeUnit) {
        return Longs.constrainToRange(timeUnit.toNanos(j), 0L, 6917529027641081853L);
    }

    private static long initNanoTime(long j) {
        if (j <= 0) {
            return 0L;
        }
        long nanoTime = System.nanoTime();
        if (nanoTime == 0) {
            return 1L;
        }
        return nanoTime;
    }

    private static long remainingNanos(long j, long j2) {
        if (j2 <= 0) {
            return 0L;
        }
        return j2 - (System.nanoTime() - j);
    }

    private void signalNextWaiter() {
        for (Guard guard = this.activeGuards; guard != null; guard = guard.next) {
            if (isSatisfied(guard)) {
                guard.condition.signal();
                return;
            }
        }
    }

    private boolean isSatisfied(Guard guard) {
        try {
            return guard.isSatisfied();
        } catch (Error | RuntimeException e) {
            signalAllWaiters();
            throw e;
        }
    }

    private void signalAllWaiters() {
        for (Guard guard = this.activeGuards; guard != null; guard = guard.next) {
            guard.condition.signalAll();
        }
    }

    private void beginWaitingFor(Guard guard) {
        int i = guard.waiterCount;
        guard.waiterCount = i + 1;
        if (i == 0) {
            guard.next = this.activeGuards;
            this.activeGuards = guard;
        }
    }

    private void endWaitingFor(Guard guard) {
        int i = guard.waiterCount - 1;
        guard.waiterCount = i;
        if (i == 0) {
            Guard guard2 = this.activeGuards;
            Guard guard3 = null;
            while (guard2 != guard) {
                guard3 = guard2;
                guard2 = guard2.next;
            }
            if (guard3 == null) {
                this.activeGuards = guard2.next;
            } else {
                guard3.next = guard2.next;
            }
            guard2.next = null;
        }
    }

    private void await(Guard guard, boolean z) throws InterruptedException {
        if (z) {
            signalNextWaiter();
        }
        beginWaitingFor(guard);
        do {
            try {
                guard.condition.await();
            } finally {
                endWaitingFor(guard);
            }
        } while (!guard.isSatisfied());
    }

    private void awaitUninterruptibly(Guard guard, boolean z) {
        if (z) {
            signalNextWaiter();
        }
        beginWaitingFor(guard);
        do {
            try {
                guard.condition.awaitUninterruptibly();
            } finally {
                endWaitingFor(guard);
            }
        } while (!guard.isSatisfied());
    }

    private boolean awaitNanos(Guard guard, long j, boolean z) throws InterruptedException {
        boolean z2 = true;
        while (j > 0) {
            if (z2) {
                if (z) {
                    try {
                        signalNextWaiter();
                    } finally {
                        if (!z2) {
                            endWaitingFor(guard);
                        }
                    }
                }
                beginWaitingFor(guard);
                z2 = false;
            }
            j = guard.condition.awaitNanos(j);
            if (guard.isSatisfied()) {
                if (!z2) {
                    endWaitingFor(guard);
                }
                return true;
            }
        }
        return false;
    }
}
