package io.reactivex.android;

import android.os.Looper;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public abstract class MainThreadDisposable implements Disposable {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {61, 16, -46, 32, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 85;
    private final AtomicBoolean unsubscribed = new AtomicBoolean();

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 7
            int r7 = 106 - r7
            int r6 = r6 * 12
            int r6 = r6 + 4
            byte[] r0 = io.reactivex.android.MainThreadDisposable.BuiltInFictitiousFunctionClassFactory
            int r8 = r8 * 3
            int r8 = 16 - r8
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
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
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L34:
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + 2
            int r6 = r6 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.android.MainThreadDisposable.a(int, int, short, java.lang.Object[]):void");
    }

    protected abstract void onDispose();

    public static void verifyMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected to be called on the main thread but was ");
        try {
            byte b = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[15] + 1);
            byte b4 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
            throw new IllegalStateException(sb.toString());
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
        return this.unsubscribed.get();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.unsubscribed.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                onDispose();
            } else {
                AndroidSchedulers.PlaceComponentResult().scheduleDirect(new Runnable() { // from class: io.reactivex.android.MainThreadDisposable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MainThreadDisposable.this.onDispose();
                    }
                });
            }
        }
    }
}
