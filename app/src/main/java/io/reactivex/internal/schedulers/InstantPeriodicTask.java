package io.reactivex.internal.schedulers;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class InstantPeriodicTask implements Callable<Void>, Disposable {
    final ExecutorService BuiltInFictitiousFunctionClassFactory;
    Thread MyBillsEntityDataFactory;
    final Runnable lookAheadTest;
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {105, 42, 72, -81, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int moveToNextValue = 242;
    static final FutureTask<Void> getAuthRequestContext = new FutureTask<>(Functions.getErrorConfigVersion, null);
    final AtomicReference<Future<?>> PlaceComponentResult = new AtomicReference<>();
    final AtomicReference<Future<?>> KClassImpl$Data$declaredNonStaticMembers$2 = new AtomicReference<>();

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = r6 + 13
            int r7 = r7 * 7
            int r7 = r7 + 99
            byte[] r0 = io.reactivex.internal.schedulers.InstantPeriodicTask.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r8 = r8 * 12
            int r8 = r8 + 4
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r8 = r8 + r7
            int r7 = r9 + 1
            int r8 = r8 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.InstantPeriodicTask.a(int, int, byte, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstantPeriodicTask(Runnable runnable, ExecutorService executorService) {
        this.lookAheadTest = runnable;
        this.BuiltInFictitiousFunctionClassFactory = executorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x007f, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0080, code lost:
    
        r2.cancel(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0084, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0085, code lost:
    
        r1 = r0.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0089, code lost:
    
        if (r1 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x008b, code lost:
    
        throw r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x008c, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0095, code lost:
    
        r10.MyBillsEntityDataFactory = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x004d, code lost:
    
        r3 = r10.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x004f, code lost:
    
        r6 = io.reactivex.internal.schedulers.InstantPeriodicTask.NetworkUserEntityData$$ExternalSyntheticLambda0[15];
        r7 = r6;
        r9 = new java.lang.Object[1];
        a(r6, r7, r7, r9);
        r6 = java.lang.Class.forName((java.lang.String) r9[0]);
        r1 = (byte) (io.reactivex.internal.schedulers.InstantPeriodicTask.NetworkUserEntityData$$ExternalSyntheticLambda0[15] - 1);
        r7 = r1;
        r9 = new java.lang.Object[1];
        a(r1, r7, r7, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x007c, code lost:
    
        if (r3 == r6.getMethod((java.lang.String) r9[0], null).invoke(null, null)) goto L11;
     */
    @Override // java.util.concurrent.Callable
    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Void call() throws java.lang.Exception {
        /*
            r10 = this;
            byte[] r0 = io.reactivex.internal.schedulers.InstantPeriodicTask.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Throwable -> L9f
            r1 = 15
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L9f
            byte r0 = (byte) r0     // Catch: java.lang.Throwable -> L9f
            byte r2 = (byte) r0     // Catch: java.lang.Throwable -> L9f
            byte r3 = (byte) r2     // Catch: java.lang.Throwable -> L9f
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L9f
            a(r0, r2, r3, r5)     // Catch: java.lang.Throwable -> L9f
            r0 = 0
            r2 = r5[r0]     // Catch: java.lang.Throwable -> L9f
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L9f
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L9f
            byte[] r3 = io.reactivex.internal.schedulers.InstantPeriodicTask.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Throwable -> L9f
            r3 = r3[r1]     // Catch: java.lang.Throwable -> L9f
            int r3 = r3 - r4
            byte r3 = (byte) r3     // Catch: java.lang.Throwable -> L9f
            byte r5 = (byte) r3     // Catch: java.lang.Throwable -> L9f
            byte r6 = (byte) r5     // Catch: java.lang.Throwable -> L9f
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L9f
            a(r3, r5, r6, r7)     // Catch: java.lang.Throwable -> L9f
            r3 = r7[r0]     // Catch: java.lang.Throwable -> L9f
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L9f
            r5 = 0
            java.lang.reflect.Method r2 = r2.getMethod(r3, r5)     // Catch: java.lang.Throwable -> L9f
            java.lang.Object r2 = r2.invoke(r5, r5)     // Catch: java.lang.Throwable -> L9f
            java.lang.Thread r2 = (java.lang.Thread) r2     // Catch: java.lang.Throwable -> L9f
            r10.MyBillsEntityDataFactory = r2
            java.lang.Runnable r2 = r10.lookAheadTest     // Catch: java.lang.Throwable -> L98
            r2.run()     // Catch: java.lang.Throwable -> L98
            java.util.concurrent.ExecutorService r2 = r10.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> L98
            java.util.concurrent.Future r2 = r2.submit(r10)     // Catch: java.lang.Throwable -> L98
        L41:
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.Future<?>> r3 = r10.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L98
            java.lang.Object r3 = r3.get()     // Catch: java.lang.Throwable -> L98
            java.util.concurrent.Future r3 = (java.util.concurrent.Future) r3     // Catch: java.lang.Throwable -> L98
            java.util.concurrent.FutureTask<java.lang.Void> r6 = io.reactivex.internal.schedulers.InstantPeriodicTask.getAuthRequestContext     // Catch: java.lang.Throwable -> L98
            if (r3 != r6) goto L8d
            java.lang.Thread r3 = r10.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L98
            byte[] r6 = io.reactivex.internal.schedulers.InstantPeriodicTask.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Throwable -> L84
            r6 = r6[r1]     // Catch: java.lang.Throwable -> L84
            byte r6 = (byte) r6     // Catch: java.lang.Throwable -> L84
            byte r7 = (byte) r6     // Catch: java.lang.Throwable -> L84
            byte r8 = (byte) r7     // Catch: java.lang.Throwable -> L84
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L84
            a(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L84
            r6 = r9[r0]     // Catch: java.lang.Throwable -> L84
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L84
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch: java.lang.Throwable -> L84
            byte[] r7 = io.reactivex.internal.schedulers.InstantPeriodicTask.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Throwable -> L84
            r1 = r7[r1]     // Catch: java.lang.Throwable -> L84
            int r1 = r1 - r4
            byte r1 = (byte) r1     // Catch: java.lang.Throwable -> L84
            byte r7 = (byte) r1     // Catch: java.lang.Throwable -> L84
            byte r8 = (byte) r7     // Catch: java.lang.Throwable -> L84
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L84
            a(r1, r7, r8, r9)     // Catch: java.lang.Throwable -> L84
            r1 = r9[r0]     // Catch: java.lang.Throwable -> L84
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L84
            java.lang.reflect.Method r1 = r6.getMethod(r1, r5)     // Catch: java.lang.Throwable -> L84
            java.lang.Object r1 = r1.invoke(r5, r5)     // Catch: java.lang.Throwable -> L84
            if (r3 == r1) goto L7f
            goto L80
        L7f:
            r4 = 0
        L80:
            r2.cancel(r4)     // Catch: java.lang.Throwable -> L98
            goto L95
        L84:
            r0 = move-exception
            java.lang.Throwable r1 = r0.getCause()     // Catch: java.lang.Throwable -> L98
            if (r1 == 0) goto L8c
            throw r1     // Catch: java.lang.Throwable -> L98
        L8c:
            throw r0     // Catch: java.lang.Throwable -> L98
        L8d:
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.Future<?>> r6 = r10.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L98
            boolean r3 = androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(r6, r3, r2)     // Catch: java.lang.Throwable -> L98
            if (r3 == 0) goto L41
        L95:
            r10.MyBillsEntityDataFactory = r5     // Catch: java.lang.Throwable -> L98
            goto L9e
        L98:
            r0 = move-exception
            r10.MyBillsEntityDataFactory = r5
            io.reactivex.plugins.RxJavaPlugins.PlaceComponentResult(r0)
        L9e:
            return r5
        L9f:
            r0 = move-exception
            java.lang.Throwable r1 = r0.getCause()
            if (r1 == 0) goto La7
            throw r1
        La7:
            goto La9
        La8:
            throw r0
        La9:
            goto La8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.InstantPeriodicTask.call():java.lang.Void");
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        AtomicReference<Future<?>> atomicReference = this.PlaceComponentResult;
        FutureTask<Void> futureTask = getAuthRequestContext;
        Future<?> andSet = atomicReference.getAndSet(futureTask);
        if (andSet != null && andSet != futureTask) {
            Thread thread = this.MyBillsEntityDataFactory;
            try {
                byte b = NetworkUserEntityData$$ExternalSyntheticLambda0[15];
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[15] - 1);
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                andSet.cancel(thread != cls.getMethod((String) objArr2[0], null).invoke(null, null));
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        Future<?> andSet2 = this.KClassImpl$Data$declaredNonStaticMembers$2.getAndSet(futureTask);
        if (andSet2 == null || andSet2 == futureTask) {
            return;
        }
        Thread thread2 = this.MyBillsEntityDataFactory;
        try {
            byte b5 = NetworkUserEntityData$$ExternalSyntheticLambda0[15];
            byte b6 = b5;
            Object[] objArr3 = new Object[1];
            a(b5, b6, b6, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            byte b7 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[15] - 1);
            byte b8 = b7;
            Object[] objArr4 = new Object[1];
            a(b7, b8, b8, objArr4);
            andSet2.cancel(thread2 != cls2.getMethod((String) objArr4[0], null).invoke(null, null));
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.PlaceComponentResult.get() == getAuthRequestContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.PlaceComponentResult.get();
            if (future2 == getAuthRequestContext) {
                Thread thread = this.MyBillsEntityDataFactory;
                try {
                    byte b = NetworkUserEntityData$$ExternalSyntheticLambda0[15];
                    byte b2 = b;
                    Object[] objArr = new Object[1];
                    a(b, b2, b2, objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b3 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[15] - 1);
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
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, future2, future));
    }
}
