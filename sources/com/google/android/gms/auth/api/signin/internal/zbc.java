package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import androidx.loader.content.AsyncTaskLoader;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.common.base.Ascii;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public final class zbc extends AsyncTaskLoader implements SignInConnectionListener {
    private final Semaphore zba;
    private final Set zbb;
    public static final byte[] MyBillsEntityDataFactory = {0, Byte.MIN_VALUE, -111, -10, 6, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int BuiltInFictitiousFunctionClassFactory = 221;

    public zbc(Context context, Set set) {
        super(context);
        this.zba = new Semaphore(0);
        this.zbb = set;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = r6 + 13
            int r7 = r7 * 7
            int r7 = 106 - r7
            byte[] r0 = com.google.android.gms.auth.api.signin.internal.zbc.MyBillsEntityDataFactory
            int r8 = r8 + 5
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L37
        L1b:
            r3 = 0
        L1c:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L37:
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
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.zbc.a(short, byte, int, java.lang.Object[]):void");
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public final /* synthetic */ Object loadInBackground() {
        Iterator it = this.zbb.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((GoogleApiClient) it.next()).maybeSignIn(this)) {
                i++;
            }
        }
        try {
            this.zba.tryAcquire(i, 5L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            InstrumentInjector.log_i("GACSignInLoader", "Unexpected InterruptedException", e);
            try {
                Object[] objArr = new Object[1];
                a((byte) (-MyBillsEntityDataFactory[16]), MyBillsEntityDataFactory[0], MyBillsEntityDataFactory[17], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a(MyBillsEntityDataFactory[0], (byte) (-MyBillsEntityDataFactory[16]), MyBillsEntityDataFactory[16], objArr2);
                ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.common.api.internal.SignInConnectionListener
    public final void onComplete() {
        this.zba.release();
    }

    @Override // androidx.loader.content.Loader
    public final void onStartLoading() {
        this.zba.drainPermits();
        forceLoad();
    }
}
