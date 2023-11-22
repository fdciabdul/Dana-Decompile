package io.reactivex.internal.schedulers;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, Disposable {
    static final int FUTURE_INDEX = 1;
    static final int PARENT_INDEX = 0;
    static final int THREAD_INDEX = 2;
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable actual;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {108, 11, -123, -39, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int MyBillsEntityDataFactory = 106;
    static final Object PARENT_DISPOSED = new Object();
    static final Object SYNC_DISPOSED = new Object();
    static final Object ASYNC_DISPOSED = new Object();
    static final Object DONE = new Object();

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 7
            int r6 = r6 + 99
            byte[] r0 = io.reactivex.internal.schedulers.ScheduledRunnable.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 * 3
            int r8 = 16 - r8
            int r7 = r7 * 12
            int r7 = 16 - r7
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L35
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r3 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L35:
            int r7 = -r7
            int r8 = r8 + 1
            int r6 = r6 + r7
            int r6 = r6 + 2
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.ScheduledRunnable.a(byte, int, byte, java.lang.Object[]):void");
    }

    public ScheduledRunnable(Runnable runnable, DisposableContainer disposableContainer) {
        super(3);
        this.actual = runnable;
        lazySet(0, disposableContainer);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        run();
        return null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Object obj2;
        Object obj3;
        boolean compareAndSet;
        Object obj4;
        Object obj5;
        try {
            byte b = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
            byte b4 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            Object invoke = cls.getMethod((String) objArr2[0], null).invoke(null, null);
            lazySet(2, invoke);
            try {
                this.actual.run();
            } finally {
                try {
                    lazySet(2, null);
                    obj4 = get(0);
                    if (obj4 != PARENT_DISPOSED) {
                        ((DisposableContainer) obj4).MyBillsEntityDataFactory(this);
                    }
                    do {
                        obj5 = get(1);
                        if (obj5 != SYNC_DISPOSED) {
                            return;
                        }
                        return;
                    } while (!compareAndSet(1, obj5, DONE));
                } catch (Throwable th) {
                    do {
                        if (obj == obj2) {
                            break;
                        } else if (obj == obj3) {
                            break;
                        }
                    } while (!compareAndSet);
                }
            }
            lazySet(2, null);
            obj4 = get(0);
            if (obj4 != PARENT_DISPOSED && compareAndSet(0, obj4, DONE) && obj4 != null) {
                ((DisposableContainer) obj4).MyBillsEntityDataFactory(this);
            }
            do {
                obj5 = get(1);
                if (obj5 != SYNC_DISPOSED || obj5 == ASYNC_DISPOSED) {
                    return;
                }
            } while (!compareAndSet(1, obj5, DONE));
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause == null) {
                throw th2;
            }
            throw cause;
        }
    }

    public final void setFuture(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == DONE) {
                return;
            }
            if (obj == SYNC_DISPOSED) {
                future.cancel(false);
                return;
            } else if (obj == ASYNC_DISPOSED) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        while (true) {
            Object obj5 = get(1);
            if (obj5 == DONE || obj5 == (obj3 = SYNC_DISPOSED) || obj5 == (obj4 = ASYNC_DISPOSED)) {
                break;
            }
            Object obj6 = get(2);
            try {
                byte b = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                byte b2 = (byte) (b - 1);
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
                byte b4 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                boolean z = obj6 != cls.getMethod((String) objArr2[0], null).invoke(null, null);
                if (z) {
                    obj3 = obj4;
                }
                if (compareAndSet(1, obj5, obj3)) {
                    if (obj5 != null) {
                        ((Future) obj5).cancel(z);
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
        do {
            obj = get(0);
            if (obj == DONE || obj == (obj2 = PARENT_DISPOSED) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((DisposableContainer) obj).MyBillsEntityDataFactory(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        Object obj = get(0);
        return obj == PARENT_DISPOSED || obj == DONE;
    }
}
