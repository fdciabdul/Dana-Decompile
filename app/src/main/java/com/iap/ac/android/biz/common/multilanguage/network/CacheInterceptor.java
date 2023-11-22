package com.iap.ac.android.biz.common.multilanguage.network;

import android.content.Context;
import android.os.Process;
import com.iap.ac.android.biz.common.http.HttpInterceptor;
import java.nio.charset.Charset;
import o.D;

/* loaded from: classes8.dex */
public class CacheInterceptor implements HttpInterceptor {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long BuiltInFictitiousFunctionClassFactory = 0;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int PlaceComponentResult;
    public static final Charset UTF_8;
    public Context context;

    static {
        getAuthRequestContext();
        Object[] objArr = new Object[1];
        a(((Process.getThreadPriority(0) + 20) >> 6) + 1, new char[]{50488, 50541, 27791, 61330, 58282, 61750, 2682, 41988, 63684}, objArr);
        UTF_8 = Charset.forName(((String) objArr[0]).intern());
        int i = PlaceComponentResult + 11;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
    }

    public CacheInterceptor(Context context) {
        this.context = context;
    }

    static void getAuthRequestContext() {
        BuiltInFictitiousFunctionClassFactory = -7944790894562524519L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0061, code lost:
    
        if (r0 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
    
        if (r0 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        com.iap.ac.android.biz.common.multilanguage.cache.HttpCache.saveCache(com.iap.ac.android.biz.common.ACManager.getInstance().getContext(), r1, r2, new java.lang.String(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007a, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007b, code lost:
    
        throw r7;
     */
    @Override // com.iap.ac.android.biz.common.http.HttpInterceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.iap.ac.android.biz.common.model.http.HttpResponse intercept(com.iap.ac.android.biz.common.http.HttpInterceptor.Chain r7) throws java.lang.Exception {
        /*
            r6 = this;
            int r0 = com.iap.ac.android.biz.common.multilanguage.network.CacheInterceptor.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 105
            int r1 = r0 % 128
            com.iap.ac.android.biz.common.multilanguage.network.CacheInterceptor.PlaceComponentResult = r1
            int r0 = r0 % 2
            com.iap.ac.android.biz.common.model.http.HttpRequest r0 = r7.request()
            java.lang.String r1 = r0.url
            java.lang.String r2 = r0.data
            android.content.Context r3 = r6.context
            java.lang.String r3 = com.iap.ac.android.biz.common.multilanguage.cache.HttpCache.queryCacheAndClearInvalidCache(r3, r1, r2)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            r5 = 0
            if (r4 != 0) goto L39
            com.iap.ac.android.biz.common.model.http.HttpResponse r7 = new com.iap.ac.android.biz.common.model.http.HttpResponse
            r0 = 304(0x130, float:4.26E-43)
            java.nio.charset.Charset r1 = com.iap.ac.android.biz.common.multilanguage.network.CacheInterceptor.UTF_8
            byte[] r1 = r3.getBytes(r1)
            r7.<init>(r0, r5, r1, r5)
            int r0 = com.iap.ac.android.biz.common.multilanguage.network.CacheInterceptor.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L37
            int r0 = r0 + 103
            int r1 = r0 % 128
            com.iap.ac.android.biz.common.multilanguage.network.CacheInterceptor.PlaceComponentResult = r1     // Catch: java.lang.Exception -> L37
            int r0 = r0 % 2
            return r7
        L37:
            r7 = move-exception
            goto L7c
        L39:
            com.iap.ac.android.biz.common.model.http.HttpResponse r7 = r7.proceed(r0)
            int r0 = r7.statusCode
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 74
            if (r0 != r3) goto L48
            r0 = 74
            goto L4a
        L48:
            r0 = 44
        L4a:
            if (r0 == r4) goto L4d
            goto L7d
        L4d:
            int r0 = com.iap.ac.android.biz.common.multilanguage.network.CacheInterceptor.PlaceComponentResult
            int r0 = r0 + 95
            int r3 = r0 % 128
            com.iap.ac.android.biz.common.multilanguage.network.CacheInterceptor.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r0 = r0 % 2
            r3 = 1
            if (r0 != 0) goto L5c
            r0 = 1
            goto L5d
        L5c:
            r0 = 0
        L5d:
            if (r0 == r3) goto L64
            byte[] r0 = r7.data
            if (r0 == 0) goto L7d
            goto L69
        L64:
            byte[] r0 = r7.data
            int r3 = r5.length     // Catch: java.lang.Throwable -> L7e
            if (r0 == 0) goto L7d
        L69:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r0)
            com.iap.ac.android.biz.common.ACManager r0 = com.iap.ac.android.biz.common.ACManager.getInstance()     // Catch: java.lang.Exception -> L37
            android.content.Context r0 = r0.getContext()     // Catch: java.lang.Exception -> L7a
            com.iap.ac.android.biz.common.multilanguage.cache.HttpCache.saveCache(r0, r1, r2, r3)     // Catch: java.lang.Exception -> L7a
            goto L7d
        L7a:
            r7 = move-exception
            throw r7
        L7c:
            throw r7
        L7d:
            return r7
        L7e:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.biz.common.multilanguage.network.CacheInterceptor.intercept(com.iap.ac.android.biz.common.http.HttpInterceptor$Chain):com.iap.ac.android.biz.common.model.http.HttpResponse");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (true) {
            if (d.MyBillsEntityDataFactory >= KClassImpl$Data$declaredNonStaticMembers$22.length) {
                break;
            }
            try {
                int i2 = $10 + 39;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (BuiltInFictitiousFunctionClassFactory ^ 3919452569568103912L)));
                d.MyBillsEntityDataFactory++;
            } catch (Exception e) {
                throw e;
            }
            throw e;
        }
        String str = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
        int i4 = $11 + 79;
        $10 = i4 % 128;
        if ((i4 % 2 != 0 ? '0' : 'L') != '0') {
            objArr[0] = str;
            return;
        }
        int i5 = 31 / 0;
        objArr[0] = str;
    }
}
