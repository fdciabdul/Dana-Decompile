package id.dana.data.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.reactivex.Observable;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\f8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0011"}, d2 = {"Lid/dana/data/util/AmcsGnSectionConfig;", "", "T", "", "key", "defaultValue", "Lio/reactivex/Observable;", "getGnSection", "(Ljava/lang/String;Ljava/lang/Object;)Lio/reactivex/Observable;", "Lcom/alibaba/fastjson/JSONArray;", "getGnSectionJSONArray", "(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONArray;", "Lcom/alibaba/fastjson/JSONObject;", "getGnSectionJSONObject", "(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;", "getGnSectionObject", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "()Lcom/alibaba/fastjson/JSONObject;", "gnSection", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class AmcsGnSectionConfig {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final AmcsGnSectionConfig INSTANCE;
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 1;
    private static int getAuthRequestContext;

    public static /* synthetic */ Object $r8$lambda$qN_eKeX2cuTBxoWr2t34rgM5cVc(String str, Object obj) {
        int i = MyBillsEntityDataFactory + 19;
        getAuthRequestContext = i % 128;
        char c = i % 2 != 0 ? '\\' : '!';
        Object m2140getGnSection$lambda0 = m2140getGnSection$lambda0(str, obj);
        if (c != '!') {
            Object obj2 = null;
            obj2.hashCode();
        }
        return m2140getGnSection$lambda0;
    }

    static {
        getAuthRequestContext();
        INSTANCE = new AmcsGnSectionConfig();
        int i = MyBillsEntityDataFactory + 37;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
    }

    static void getAuthRequestContext() {
        KClassImpl$Data$declaredNonStaticMembers$2 = 2081254493390214275L;
    }

    private AmcsGnSectionConfig() {
    }

    public final <T> Observable<T> getGnSection(final String key, final T defaultValue) {
        Observable<T> onErrorReturnItem = Observable.fromCallable(new Callable() { // from class: id.dana.data.util.AmcsGnSectionConfig$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return AmcsGnSectionConfig.$r8$lambda$qN_eKeX2cuTBxoWr2t34rgM5cVc(key, defaultValue);
            }
        }).onErrorReturnItem(defaultValue);
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "");
        int i = MyBillsEntityDataFactory + 61;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        return onErrorReturnItem;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        if ((r4 != null ? '\b' : 31) != 31) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002d, code lost:
    
        if ((r4 == null) != true) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002f, code lost:
    
        r5 = id.dana.data.util.AmcsGnSectionConfig.MyBillsEntityDataFactory + 45;
        id.dana.data.util.AmcsGnSectionConfig.getAuthRequestContext = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        if ((r5 % 2) == 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        r5 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        throw new id.dana.utils.exception.CallableReturnNullError("AmcsGnSectionConfig#getGnSection");
     */
    /* renamed from: getGnSection$lambda-0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.lang.Object m2140getGnSection$lambda0(java.lang.String r4, java.lang.Object r5) {
        /*
            int r0 = id.dana.data.util.AmcsGnSectionConfig.MyBillsEntityDataFactory
            int r0 = r0 + 9
            int r1 = r0 % 128
            id.dana.data.util.AmcsGnSectionConfig.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            r3 = 0
            java.lang.Object r4 = getGnSectionObject(r4, r5)
            if (r0 == 0) goto L29
            r3.hashCode()     // Catch: java.lang.Throwable -> L27
            r5 = 31
            if (r4 == 0) goto L22
            r0 = 8
            goto L24
        L22:
            r0 = 31
        L24:
            if (r0 == r5) goto L40
            goto L2f
        L27:
            r4 = move-exception
            throw r4
        L29:
            if (r4 == 0) goto L2c
            goto L2d
        L2c:
            r1 = 1
        L2d:
            if (r1 == r2) goto L40
        L2f:
            int r5 = id.dana.data.util.AmcsGnSectionConfig.MyBillsEntityDataFactory
            int r5 = r5 + 45
            int r0 = r5 % 128
            id.dana.data.util.AmcsGnSectionConfig.getAuthRequestContext = r0
            int r5 = r5 % 2
            if (r5 == 0) goto L3f
            int r5 = r3.length     // Catch: java.lang.Throwable -> L3d
            goto L3f
        L3d:
            r4 = move-exception
            throw r4
        L3f:
            return r4
        L40:
            id.dana.utils.exception.CallableReturnNullError r4 = new id.dana.utils.exception.CallableReturnNullError
            java.lang.String r5 = "AmcsGnSectionConfig#getGnSection"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.util.AmcsGnSectionConfig.m2140getGnSection$lambda0(java.lang.String, java.lang.Object):java.lang.Object");
    }

    @JvmStatic
    public static final <T> T getGnSectionObject(String key, T defaultValue) {
        JSONObject gnSection = INSTANCE.getGnSection();
        if (gnSection != null) {
            T t = (T) gnSection.get(key);
            if ((t != null ? '!' : (char) 11) == '!') {
                int i = MyBillsEntityDataFactory + 17;
                getAuthRequestContext = i % 128;
                if ((i % 2 != 0 ? (char) 16 : 'Z') != 'Z') {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return t;
                }
                return t;
            }
        }
        int i2 = getAuthRequestContext + 77;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        return defaultValue;
    }

    @JvmStatic
    public static final JSONArray getGnSectionJSONArray(String key) {
        JSONArray jSONArray;
        JSONObject gnSection = INSTANCE.getGnSection();
        Object[] objArr = null;
        if (!(gnSection == null)) {
            int i = getAuthRequestContext + 27;
            MyBillsEntityDataFactory = i % 128;
            if (i % 2 == 0) {
                jSONArray = gnSection.getJSONArray(key);
                int length = objArr.length;
            } else {
                jSONArray = gnSection.getJSONArray(key);
            }
            JSONArray jSONArray2 = jSONArray;
            int i2 = getAuthRequestContext + 97;
            MyBillsEntityDataFactory = i2 % 128;
            int i3 = i2 % 2;
            return jSONArray2;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
    
        if ((r0 != null ? ')' : ';') != ';') goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
    
        r4 = id.dana.data.util.AmcsGnSectionConfig.MyBillsEntityDataFactory + 51;
        id.dana.data.util.AmcsGnSectionConfig.getAuthRequestContext = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return r0.getJSONObject(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if (r0 != null) goto L18;
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.alibaba.fastjson.JSONObject getGnSectionJSONObject(java.lang.String r4) {
        /*
            int r0 = id.dana.data.util.AmcsGnSectionConfig.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L3e
            int r0 = r0 + 25
            int r1 = r0 % 128
            id.dana.data.util.AmcsGnSectionConfig.getAuthRequestContext = r1     // Catch: java.lang.Exception -> L3c
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L1b
            id.dana.data.util.AmcsGnSectionConfig r0 = id.dana.data.util.AmcsGnSectionConfig.INSTANCE
            com.alibaba.fastjson.JSONObject r0 = r0.getGnSection()
            r1.hashCode()     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L31
            goto L2c
        L19:
            r4 = move-exception
            throw r4
        L1b:
            id.dana.data.util.AmcsGnSectionConfig r0 = id.dana.data.util.AmcsGnSectionConfig.INSTANCE
            com.alibaba.fastjson.JSONObject r0 = r0.getGnSection()
            r2 = 59
            if (r0 == 0) goto L28
            r3 = 41
            goto L2a
        L28:
            r3 = 59
        L2a:
            if (r3 == r2) goto L31
        L2c:
            com.alibaba.fastjson.JSONObject r1 = r0.getJSONObject(r4)
            goto L3b
        L31:
            int r4 = id.dana.data.util.AmcsGnSectionConfig.MyBillsEntityDataFactory
            int r4 = r4 + 51
            int r0 = r4 % 128
            id.dana.data.util.AmcsGnSectionConfig.getAuthRequestContext = r0
            int r4 = r4 % 2
        L3b:
            return r1
        L3c:
            r4 = move-exception
            throw r4
        L3e:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.util.AmcsGnSectionConfig.getGnSectionJSONObject(java.lang.String):com.alibaba.fastjson.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0056, code lost:
    
        if (r0 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
    
        r5 = id.dana.data.util.AmcsGnSectionConfig.getAuthRequestContext + 87;
        id.dana.data.util.AmcsGnSectionConfig.MyBillsEntityDataFactory = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0061, code lost:
    
        if ((r5 % 2) != 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0063, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0065, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
    
        if (r5 == true) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0068, code lost:
    
        r0 = id.dana.data.foundation.utils.JsonUtil.MyBillsEntityDataFactory(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006c, code lost:
    
        r4.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006f, code lost:
    
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
    
        r4 = id.dana.data.foundation.utils.JsonUtil.MyBillsEntityDataFactory(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
    
        if (r0 != null) goto L13;
     */
    @kotlin.jvm.JvmName(name = "getGnSection")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.alibaba.fastjson.JSONObject getGnSection() {
        /*
            r10 = this;
            int r0 = id.dana.data.util.AmcsGnSectionConfig.MyBillsEntityDataFactory
            int r0 = r0 + 31
            int r1 = r0 % 128
            id.dana.data.util.AmcsGnSectionConfig.getAuthRequestContext = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r4 = 0
            r5 = -1
            r7 = 38820(0x97a4, float:5.4398E-41)
            if (r0 == r3) goto L39
            long r8 = android.os.SystemClock.currentThreadTimeMillis()
            int r0 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            int r7 = r7 / r0
            char[] r0 = new char[r1]
            r0 = {x0092: FILL_ARRAY_DATA , data: [17799, -11733} // fill-array
            java.lang.Object[] r5 = new java.lang.Object[r3]
            a(r7, r0, r5)
            r0 = r5[r2]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            org.json.JSONObject r0 = id.dana.data.util.ConfigCenterHelper.getSection(r0)
            if (r0 == 0) goto L77
            goto L58
        L39:
            long r8 = android.os.SystemClock.currentThreadTimeMillis()
            int r0 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            int r0 = r0 + r7
            char[] r5 = new char[r1]
            r5 = {x0098: FILL_ARRAY_DATA , data: [17799, -11733} // fill-array
            java.lang.Object[] r6 = new java.lang.Object[r3]
            a(r0, r5, r6)
            r0 = r6[r2]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            org.json.JSONObject r0 = id.dana.data.util.ConfigCenterHelper.getSection(r0)
            if (r0 == 0) goto L77
        L58:
            int r5 = id.dana.data.util.AmcsGnSectionConfig.getAuthRequestContext
            int r5 = r5 + 87
            int r6 = r5 % 128
            id.dana.data.util.AmcsGnSectionConfig.MyBillsEntityDataFactory = r6
            int r5 = r5 % r1
            if (r5 != 0) goto L65
            r5 = 0
            goto L66
        L65:
            r5 = 1
        L66:
            if (r5 == r3) goto L73
            com.alibaba.fastjson.JSONObject r0 = id.dana.data.foundation.utils.JsonUtil.MyBillsEntityDataFactory(r0)
            r4.hashCode()     // Catch: java.lang.Throwable -> L71
            r4 = r0
            goto L77
        L71:
            r0 = move-exception
            throw r0
        L73:
            com.alibaba.fastjson.JSONObject r4 = id.dana.data.foundation.utils.JsonUtil.MyBillsEntityDataFactory(r0)
        L77:
            int r0 = id.dana.data.util.AmcsGnSectionConfig.MyBillsEntityDataFactory
            int r0 = r0 + 83
            int r3 = r0 % 128
            id.dana.data.util.AmcsGnSectionConfig.getAuthRequestContext = r3
            int r0 = r0 % r1
            r1 = 41
            if (r0 == 0) goto L87
            r0 = 28
            goto L89
        L87:
            r0 = 41
        L89:
            if (r0 == r1) goto L91
            r0 = 55
            int r0 = r0 / r2
            return r4
        L8f:
            r0 = move-exception
            throw r0
        L91:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.util.AmcsGnSectionConfig.getGnSection():com.alibaba.fastjson.JSONObject");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        try {
            getonboardingscenario.MyBillsEntityDataFactory = i;
            int length = cArr.length;
            long[] jArr = new long[length];
            getonboardingscenario.getAuthRequestContext = 0;
            while (true) {
                if (!(getonboardingscenario.getAuthRequestContext < cArr.length)) {
                    break;
                }
                int i2 = $10 + 27;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4796183387843776835L);
                getonboardingscenario.getAuthRequestContext++;
            }
            char[] cArr2 = new char[length];
            getonboardingscenario.getAuthRequestContext = 0;
            while (true) {
                if ((getonboardingscenario.getAuthRequestContext < cArr.length ? ';' : 'S') == 'S') {
                    objArr[0] = new String(cArr2);
                    return;
                }
                int i4 = $11 + 5;
                $10 = i4 % 128;
                int i5 = i4 % 2;
                try {
                    cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                    getonboardingscenario.getAuthRequestContext++;
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
