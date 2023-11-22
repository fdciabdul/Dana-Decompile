package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108UX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012"}, d2 = {"Lkotlinx/coroutines/BlockingCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "", "state", "", "afterCompletion", "(Ljava/lang/Object;)V", "joinBlocking", "()Ljava/lang/Object;", "Ljava/lang/Thread;", "blockedThread", "Ljava/lang/Thread;", "Lkotlinx/coroutines/EventLoop;", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "", "isScopedCoroutine", "()Z", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BlockingCoroutine<T> extends AbstractCoroutine<T> {
    public static final byte[] MyBillsEntityDataFactory = {116, -27, -60, 115, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int PlaceComponentResult = 32;
    private final Thread blockedThread;
    private final EventLoop eventLoop;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = kotlinx.coroutines.BlockingCoroutine.MyBillsEntityDataFactory
            int r6 = r6 * 12
            int r6 = 15 - r6
            int r7 = r7 * 7
            int r7 = 106 - r7
            int r8 = r8 * 3
            int r8 = r8 + 13
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L36
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            int r6 = r6 + 1
            r4 = r0[r6]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L36:
            int r7 = r7 + r8
            int r7 = r7 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.BlockingCoroutine.a(short, short, byte, java.lang.Object[]):void");
    }

    @Override // kotlinx.coroutines.JobSupport
    @JvmName(name = "isScopedCoroutine")
    protected final boolean isScopedCoroutine() {
        return true;
    }

    public BlockingCoroutine(CoroutineContext coroutineContext, Thread thread, EventLoop eventLoop) {
        super(coroutineContext, true, true);
        this.blockedThread = thread;
        this.eventLoop = eventLoop;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    public final void afterCompletion(Object state) {
        try {
            byte b = (byte) (MyBillsEntityDataFactory[15] - 1);
            Object[] objArr = new Object[1];
            a(b, b, MyBillsEntityDataFactory[15], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = MyBillsEntityDataFactory[15];
            byte b3 = b2;
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr2);
            Unit unit = null;
            if (Intrinsics.areEqual(cls.getMethod((String) objArr2[0], null).invoke(null, null), this.blockedThread)) {
                return;
            }
            Thread thread = this.blockedThread;
            AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
            if (timeSource != null) {
                timeSource.unpark(thread);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                LockSupport.unpark(thread);
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public final T joinBlocking() {
        Unit unit;
        AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.registerTimeLoopThread();
        }
        try {
            EventLoop eventLoop = this.eventLoop;
            if (eventLoop != null) {
                EventLoop.incrementUseCount$default(eventLoop, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    EventLoop eventLoop2 = this.eventLoop;
                    long processNextEvent = eventLoop2 != null ? eventLoop2.processNextEvent() : LongCompanionObject.MAX_VALUE;
                    if (!isCompleted()) {
                        AbstractTimeSource timeSource2 = AbstractTimeSourceKt.getTimeSource();
                        if (timeSource2 != null) {
                            timeSource2.parkNanos(this, processNextEvent);
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            LockSupport.parkNanos(this, processNextEvent);
                        }
                    } else {
                        T t = (T) JobSupportKt.unboxState(getState$kotlinx_coroutines_core());
                        r3 = t instanceof CompletedExceptionally ? (CompletedExceptionally) t : null;
                        if (r3 == null) {
                            return t;
                        }
                        throw r3.cause;
                    }
                } finally {
                    EventLoop eventLoop3 = this.eventLoop;
                    if (eventLoop3 != null) {
                        EventLoop.decrementUseCount$default(eventLoop3, false, 1, null);
                    }
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            cancelCoroutine(interruptedException);
            throw interruptedException;
        } finally {
            AbstractTimeSource timeSource3 = AbstractTimeSourceKt.getTimeSource();
            if (timeSource3 != null) {
                timeSource3.unregisterTimeLoopThread();
            }
        }
    }
}
