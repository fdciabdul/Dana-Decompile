package androidx.arch.core.executor;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.common.base.Ascii;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class DefaultTaskExecutor extends TaskExecutor {
    public static final byte[] MyBillsEntityDataFactory = {Ascii.EM, 60, 112, -12, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int getAuthRequestContext = 204;
    private volatile Handler BuiltInFictitiousFunctionClassFactory;
    private final Object PlaceComponentResult = new Object();
    private final ExecutorService KClassImpl$Data$declaredNonStaticMembers$2 = Executors.newFixedThreadPool(4, new ThreadFactory() { // from class: androidx.arch.core.executor.DefaultTaskExecutor.1
        private final AtomicInteger BuiltInFictitiousFunctionClassFactory = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory.getAndIncrement())));
            return thread;
        }
    });

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 12
            int r9 = 15 - r9
            int r7 = r7 * 3
            int r7 = 16 - r7
            byte[] r0 = androidx.arch.core.executor.DefaultTaskExecutor.MyBillsEntityDataFactory
            int r8 = r8 * 7
            int r8 = 106 - r8
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L37
        L1b:
            r3 = 0
        L1c:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            int r9 = r9 + 1
            r3 = r0[r9]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L37:
            int r9 = r9 + r7
            int r7 = r9 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.arch.core.executor.DefaultTaskExecutor.a(byte, short, byte, java.lang.Object[]):void");
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public final void getAuthRequestContext(Runnable runnable) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(runnable);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Runnable runnable) {
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            synchronized (this.PlaceComponentResult) {
                if (this.BuiltInFictitiousFunctionClassFactory == null) {
                    this.BuiltInFictitiousFunctionClassFactory = getAuthRequestContext(Looper.getMainLooper());
                }
            }
        }
        this.BuiltInFictitiousFunctionClassFactory.post(runnable);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        Thread thread = Looper.getMainLooper().getThread();
        try {
            byte b = (byte) (MyBillsEntityDataFactory[15] - 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = MyBillsEntityDataFactory[15];
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            return thread == cls.getMethod((String) objArr2[0], null).invoke(null, null);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private static Handler getAuthRequestContext(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler.createAsync(looper);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            } catch (InvocationTargetException unused2) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }
}
