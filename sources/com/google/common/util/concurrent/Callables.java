package com.google.common.util.concurrent;

import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class Callables {
    public static final byte[] PlaceComponentResult = {112, Ascii.US, -51, -82, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int BuiltInFictitiousFunctionClassFactory = 65;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = 16 - r6
            int r7 = r7 * 7
            int r7 = 106 - r7
            byte[] r0 = com.google.common.util.concurrent.Callables.PlaceComponentResult
            int r8 = r8 * 12
            int r8 = r8 + 4
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r4 = r7
            r3 = 0
            r7 = r6
            goto L2e
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r5
        L2e:
            int r8 = r8 + 1
            int r6 = r6 + r4
            int r6 = r6 + 2
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Callables.a(byte, short, byte, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$returning$0(Object obj) throws Exception {
        return obj;
    }

    private Callables() {
    }

    public static <T> Callable<T> returning(@ParametricNullness final T t) {
        return new Callable() { // from class: com.google.common.util.concurrent.Callables$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Callables.lambda$returning$0(t);
            }
        };
    }

    public static <T> AsyncCallable<T> asAsyncCallable(final Callable<T> callable, final ListeningExecutorService listeningExecutorService) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(listeningExecutorService);
        return new AsyncCallable() { // from class: com.google.common.util.concurrent.Callables$$ExternalSyntheticLambda3
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final ListenableFuture call() {
                ListenableFuture submit;
                submit = ListeningExecutorService.this.submit(callable);
                return submit;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Callable<T> threadRenaming(final Callable<T> callable, final Supplier<String> supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(callable);
        return new Callable() { // from class: com.google.common.util.concurrent.Callables$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Callables.lambda$threadRenaming$2(Supplier.this, callable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$threadRenaming$2(Supplier supplier, Callable callable) throws Exception {
        try {
            byte b = (byte) (PlaceComponentResult[15] - 1);
            Object[] objArr = new Object[1];
            a(b, b, PlaceComponentResult[15], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = PlaceComponentResult[15];
            byte b3 = b2;
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr2);
            Thread thread = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
            String name = thread.getName();
            boolean trySetName = trySetName((String) supplier.get(), thread);
            try {
                return callable.call();
            } finally {
                if (trySetName) {
                    trySetName(name, thread);
                }
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable threadRenaming(final Runnable runnable, final Supplier<String> supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(runnable);
        return new Runnable() { // from class: com.google.common.util.concurrent.Callables$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Callables.lambda$threadRenaming$3(Supplier.this, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$threadRenaming$3(Supplier supplier, Runnable runnable) {
        try {
            byte b = (byte) (PlaceComponentResult[15] - 1);
            Object[] objArr = new Object[1];
            a(b, b, PlaceComponentResult[15], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = PlaceComponentResult[15];
            byte b3 = b2;
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr2);
            Thread thread = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
            String name = thread.getName();
            boolean trySetName = trySetName((String) supplier.get(), thread);
            try {
                runnable.run();
            } finally {
                if (trySetName) {
                    trySetName(name, thread);
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

    private static boolean trySetName(String str, Thread thread) {
        try {
            thread.setName(str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
