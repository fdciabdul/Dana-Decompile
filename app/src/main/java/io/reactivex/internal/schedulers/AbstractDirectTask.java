package io.reactivex.internal.schedulers;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements Disposable, SchedulerRunnableIntrospection {
    private static final long serialVersionUID = 1811839108042568751L;
    protected final Runnable runnable;
    protected Thread runner;
    public static final byte[] MyBillsEntityDataFactory = {15, -40, -114, -21, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int PlaceComponentResult = 83;
    protected static final FutureTask<Void> FINISHED = new FutureTask<>(Functions.getErrorConfigVersion, null);
    protected static final FutureTask<Void> DISPOSED = new FutureTask<>(Functions.getErrorConfigVersion, null);

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x003a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 12
            int r6 = 15 - r6
            int r8 = r8 * 3
            int r8 = 16 - r8
            int r7 = r7 * 7
            int r7 = 106 - r7
            byte[] r0 = io.reactivex.internal.schedulers.AbstractDirectTask.MyBillsEntityDataFactory
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1d
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L3a
        L1d:
            r3 = 0
        L1e:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r6 = r6 + 1
            r4 = r0[r6]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L3a:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.AbstractDirectTask.a(short, int, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractDirectTask(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future == FINISHED || future == (futureTask = DISPOSED) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        Thread thread = this.runner;
        try {
            byte b = (byte) (MyBillsEntityDataFactory[15] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-MyBillsEntityDataFactory[15]);
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            future.cancel(thread != cls.getMethod((String) objArr2[0], null).invoke(null, null));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        Future<?> future = get();
        return future == FINISHED || future == DISPOSED;
    }

    public final void setFuture(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 == FINISHED) {
                return;
            }
            if (future2 == DISPOSED) {
                Thread thread = this.runner;
                try {
                    byte b = (byte) (MyBillsEntityDataFactory[15] + 1);
                    byte b2 = b;
                    Object[] objArr = new Object[1];
                    a(b, b2, b2, objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b3 = (byte) (-MyBillsEntityDataFactory[15]);
                    byte b4 = b3;
                    Object[] objArr2 = new Object[1];
                    a(b3, b4, b4, objArr2);
                    future.cancel(thread != cls.getMethod((String) objArr2[0], null).invoke(null, null));
                    return;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
        } while (!compareAndSet(future2, future));
    }

    public Runnable getWrappedRunnable() {
        return this.runnable;
    }
}
