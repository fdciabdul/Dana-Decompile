package id.dana.data.network.interceptor;

import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.iap.ac.config.lite.ConfigCenter;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.D;
import okhttp3.Interceptor;
import org.json.JSONArray;
import org.json.JSONException;

@Singleton
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/data/network/interceptor/ETagCacheInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "p0", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ETagCacheInterceptor implements Interceptor {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static long MyBillsEntityDataFactory = 8197404085124956295L;
    private static int getAuthRequestContext;

    @Inject
    public ETagCacheInterceptor() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
    
        if (MyBillsEntityDataFactory(r0.url().url().toString()) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
    
        if (MyBillsEntityDataFactory(r0.url().url().toString()) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
    
        r1.cacheControl(new okhttp3.CacheControl.Builder().noStore().build());
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
    
        r5 = r5.proceed(r1.build());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "");
        r0 = id.dana.data.network.interceptor.ETagCacheInterceptor.BuiltInFictitiousFunctionClassFactory + 81;
        id.dana.data.network.interceptor.ETagCacheInterceptor.getAuthRequestContext = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007f, code lost:
    
        return r5;
     */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okhttp3.Response intercept(okhttp3.Interceptor.Chain r5) throws java.io.IOException {
        /*
            r4 = this;
            int r0 = id.dana.data.network.interceptor.ETagCacheInterceptor.getAuthRequestContext
            int r0 = r0 + 29
            int r1 = r0 % 128
            id.dana.data.network.interceptor.ETagCacheInterceptor.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 47
            if (r0 != 0) goto L11
            r0 = 78
            goto L13
        L11:
            r0 = 47
        L13:
            java.lang.String r2 = ""
            if (r0 == r1) goto L3d
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)     // Catch: java.lang.Exception -> L3b
            okhttp3.Request r0 = r5.request()     // Catch: java.lang.Exception -> L3b
            okhttp3.Request$Builder r1 = r0.newBuilder()     // Catch: java.lang.Exception -> L3b
            okhttp3.HttpUrl r0 = r0.url()     // Catch: java.lang.Exception -> L3b
            java.net.URL r0 = r0.url()     // Catch: java.lang.Exception -> L3b
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L3b
            boolean r0 = MyBillsEntityDataFactory(r0)     // Catch: java.lang.Exception -> L3b
            r3 = 90
            int r3 = r3 / 0
            if (r0 != 0) goto L6a
            goto L5a
        L39:
            r5 = move-exception
            throw r5
        L3b:
            r5 = move-exception
            throw r5
        L3d:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            okhttp3.Request r0 = r5.request()
            okhttp3.Request$Builder r1 = r0.newBuilder()
            okhttp3.HttpUrl r0 = r0.url()
            java.net.URL r0 = r0.url()
            java.lang.String r0 = r0.toString()
            boolean r0 = MyBillsEntityDataFactory(r0)
            if (r0 != 0) goto L6a
        L5a:
            okhttp3.CacheControl$Builder r0 = new okhttp3.CacheControl$Builder
            r0.<init>()
            okhttp3.CacheControl$Builder r0 = r0.noStore()
            okhttp3.CacheControl r0 = r0.build()
            r1.cacheControl(r0)
        L6a:
            okhttp3.Request r0 = r1.build()
            okhttp3.Response r5 = r5.proceed(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            int r0 = id.dana.data.network.interceptor.ETagCacheInterceptor.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 81
            int r1 = r0 % 128
            id.dana.data.network.interceptor.ETagCacheInterceptor.getAuthRequestContext = r1
            int r0 = r0 % 2
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.network.interceptor.ETagCacheInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    private static boolean MyBillsEntityDataFactory(String p0) {
        ConfigCenter configCenter = ConfigCenter.getInstance();
        Object[] objArr = new Object[1];
        a(1 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), new char[]{65132, 51251, 35963, 25786, 65037, 1324, 5837, 3224, 52157, 52093, 23742, 64214, 38240, 61621, 35402, 46880, 24367, 42744, 45056, 27983, 10489, 27648, 64988, 23540, 62132}, objArr);
        JSONArray jSONArrayConfig = configCenter.getJSONArrayConfig(((String) objArr[0]).intern());
        if (p0 != null) {
            if (!(jSONArrayConfig == null)) {
                int i = BuiltInFictitiousFunctionClassFactory + 111;
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
                try {
                    int length = jSONArrayConfig.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        String string = jSONArrayConfig.getString(i3);
                        if (!TextUtils.isEmpty(string)) {
                            Intrinsics.checkNotNullExpressionValue(string, "");
                            if (StringsKt.startsWith$default(p0, string, false, 2, (Object) null)) {
                                int i4 = BuiltInFictitiousFunctionClassFactory + 113;
                                getAuthRequestContext = i4 % 128;
                                int i5 = i4 % 2;
                                return true;
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        }
        return false;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        int i2 = $11 + 101;
        $10 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if ((d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length ? '.' : (char) 24) == '.') {
                int i4 = $11 + 99;
                $10 = i4 % 128;
                int i5 = i4 % 2;
                d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (MyBillsEntityDataFactory ^ 3919452569568103912L)));
                d.MyBillsEntityDataFactory++;
            } else {
                objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
                return;
            }
        }
    }
}
