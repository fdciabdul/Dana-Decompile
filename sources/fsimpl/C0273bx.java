package fsimpl;

import com.fullstory.rust.RustInterface;
import okhttp3.Interceptor;

/* renamed from: fsimpl.bx  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0273bx implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    private final RustInterface f7896a;
    private final boolean b;

    public C0273bx(RustInterface rustInterface, boolean z) {
        this.f7896a = rustInterface;
        this.b = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0052 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:22:0x0048, B:24:0x0052, B:25:0x0056, B:32:0x0069, B:35:0x006f, B:28:0x0060), top: B:38:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0060 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:22:0x0048, B:24:0x0052, B:25:0x0056, B:32:0x0069, B:35:0x006f, B:28:0x0060), top: B:38:0x0048 }] */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            okhttp3.Request r2 = r20.request()
            boolean r3 = fsimpl.C0256bg.d()
            if (r3 != 0) goto L13
            okhttp3.Response r1 = r1.proceed(r2)
            return r1
        L13:
            r3 = 0
            r5 = 0
            okhttp3.HttpUrl r6 = r2.url()     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L21
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L3c
            goto L22
        L21:
            r6 = r5
        L22:
            java.lang.String r5 = r2.method()     // Catch: java.lang.Throwable -> L36
            okhttp3.RequestBody r7 = r2.body()     // Catch: java.lang.Throwable -> L36
            if (r7 == 0) goto L31
            long r7 = r7.contentLength()     // Catch: java.lang.Throwable -> L36
            goto L32
        L31:
            r7 = r3
        L32:
            r9 = r5
            r13 = r7
            r8 = r6
            goto L40
        L36:
            r18 = r6
            r6 = r5
            r5 = r18
            goto L3d
        L3c:
            r6 = r5
        L3d:
            r13 = r3
            r8 = r5
            r9 = r6
        L40:
            long r5 = java.lang.System.nanoTime()
            okhttp3.Response r1 = r1.proceed(r2)
            long r10 = fsimpl.eU.a(r5)     // Catch: java.lang.Throwable -> L80
            okhttp3.ResponseBody r2 = r1.body()     // Catch: java.lang.Throwable -> L80
            if (r2 == 0) goto L56
            long r3 = r2.contentLength()     // Catch: java.lang.Throwable -> L80
        L56:
            r15 = r3
            okhttp3.Response r2 = r1.networkResponse()     // Catch: java.lang.Throwable -> L80
            r3 = 1
            if (r2 == 0) goto L60
            r2 = 1
            goto L69
        L60:
            okhttp3.Response r2 = r1.cacheResponse()     // Catch: java.lang.Throwable -> L80
            if (r2 == 0) goto L68
            r2 = 2
            goto L69
        L68:
            r2 = 0
        L69:
            boolean r4 = r0.b     // Catch: java.lang.Throwable -> L80
            if (r4 != 0) goto L6f
            if (r2 == r3) goto L80
        L6f:
            com.fullstory.rust.RustInterface r3 = r0.f7896a     // Catch: java.lang.Throwable -> L80
            fsimpl.em r4 = new fsimpl.em     // Catch: java.lang.Throwable -> L80
            int r12 = r1.code()     // Catch: java.lang.Throwable -> L80
            r7 = r4
            r17 = r2
            r7.<init>(r8, r9, r10, r12, r13, r15, r17)     // Catch: java.lang.Throwable -> L80
            r3.a(r4)     // Catch: java.lang.Throwable -> L80
        L80:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.C0273bx.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
