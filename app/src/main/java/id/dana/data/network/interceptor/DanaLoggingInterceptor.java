package id.dana.data.network.interceptor;

import android.content.Context;
import android.graphics.Color;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import id.dana.analytics.mixpanel.MixPanelDataTracker;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.nio.charset.Charset;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Typography;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import okhttp3.Interceptor;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u0010X\u0007¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015"}, d2 = {"Lid/dana/data/network/interceptor/DanaLoggingInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/ResponseBody;", "p0", "", "MyBillsEntityDataFactory", "(Lokhttp3/ResponseBody;)Ljava/lang/String;", "Lokhttp3/Interceptor$Chain;", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "p1", "p2", "p3", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Context;", "PlaceComponentResult", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Lcom/google/gson/Gson;", "Lcom/google/gson/Gson;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DanaLoggingInterceptor implements Interceptor {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int getErrorConfigVersion = 0;
    private static int scheduleImpl = 1;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Gson KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Context BuiltInFictitiousFunctionClassFactory;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = {39889, 39888, 39902, 39929, 39916};
    private static boolean getAuthRequestContext = true;
    private static boolean lookAheadTest = true;
    private static int MyBillsEntityDataFactory = 909155236;

    @Inject
    public DanaLoggingInterceptor(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Gson();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
    
        if (r3 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        if ((r3 != null) != true) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
    
        r8 = r8.request().url().url().getPath();
        r4 = r1.body();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
    
        if (r4 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
    
        r4 = MyBillsEntityDataFactory(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005f, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, "");
        MyBillsEntityDataFactory(r8, r3, r4, r2);
     */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okhttp3.Response intercept(okhttp3.Interceptor.Chain r8) {
        /*
            r7 = this;
            int r0 = id.dana.data.network.interceptor.DanaLoggingInterceptor.scheduleImpl     // Catch: java.lang.Exception -> L6d
            int r0 = r0 + 43
            int r1 = r0 % 128
            id.dana.data.network.interceptor.DanaLoggingInterceptor.getErrorConfigVersion = r1     // Catch: java.lang.Exception -> L6d
            int r0 = r0 % 2
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            okhttp3.Request r1 = r8.request()
            okhttp3.Response r1 = r8.proceed(r1)
            java.lang.String r2 = "rpcId"
            java.lang.String r2 = r1.header(r2)
            java.lang.String r3 = "errorCode"
            java.lang.String r3 = r1.header(r3)
            if (r2 == 0) goto L69
            int r4 = id.dana.data.network.interceptor.DanaLoggingInterceptor.getErrorConfigVersion
            int r4 = r4 + 115
            int r5 = r4 % 128
            id.dana.data.network.interceptor.DanaLoggingInterceptor.scheduleImpl = r5
            int r4 = r4 % 2
            r5 = 0
            r6 = 1
            if (r4 != 0) goto L35
            r4 = 1
            goto L36
        L35:
            r4 = 0
        L36:
            if (r4 == r6) goto L3b
            if (r3 == 0) goto L69
            goto L44
        L3b:
            r4 = 57
            int r4 = r4 / r5
            if (r3 == 0) goto L41
            r5 = 1
        L41:
            if (r5 == r6) goto L44
            goto L69
        L44:
            okhttp3.Request r8 = r8.request()
            okhttp3.HttpUrl r8 = r8.url()
            java.net.URL r8 = r8.url()
            java.lang.String r8 = r8.getPath()
            okhttp3.ResponseBody r4 = r1.body()
            if (r4 == 0) goto L5f
            java.lang.String r4 = r7.MyBillsEntityDataFactory(r4)
            goto L60
        L5f:
            r4 = 0
        L60:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            r7.MyBillsEntityDataFactory(r8, r3, r4, r2)
            goto L69
        L67:
            r8 = move-exception
            throw r8
        L69:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            return r1
        L6d:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.network.interceptor.DanaLoggingInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    private final String MyBillsEntityDataFactory(ResponseBody p0) {
        Buffer KClassImpl$Data$declaredNonStaticMembers$22;
        Buffer clone;
        Charset forName;
        String str = "";
        try {
            BufferedSource source = p0.source();
            String str2 = 0;
            if ((source != null ? 'E' : Typography.quote) != '\"') {
                int i = scheduleImpl + 95;
                getErrorConfigVersion = i % 128;
                if (i % 2 != 0) {
                    source.getErrorConfigVersion(LongCompanionObject.MAX_VALUE);
                    int length = str2.length;
                } else {
                    source.getErrorConfigVersion(LongCompanionObject.MAX_VALUE);
                }
            }
            if (!(source != null)) {
                KClassImpl$Data$declaredNonStaticMembers$22 = null;
            } else {
                int i2 = getErrorConfigVersion + 35;
                scheduleImpl = i2 % 128;
                int i3 = i2 % 2;
                KClassImpl$Data$declaredNonStaticMembers$22 = source.KClassImpl$Data$declaredNonStaticMembers$2();
            }
            if ((KClassImpl$Data$declaredNonStaticMembers$22 != null ? (char) 2 : 'Q') == 2) {
                int i4 = getErrorConfigVersion + 43;
                scheduleImpl = i4 % 128;
                if (i4 % 2 != 0) {
                    clone = KClassImpl$Data$declaredNonStaticMembers$22.clone();
                    Object[] objArr = new Object[1];
                    a(Color.blue(0) + 127, new byte[]{-123, -124, -125, -126, -127}, null, null, objArr);
                    forName = Charset.forName(((String) objArr[0]).intern());
                } else {
                    clone = KClassImpl$Data$declaredNonStaticMembers$22.clone();
                    Object[] objArr2 = new Object[1];
                    a(20 >> Color.blue(0), new byte[]{-123, -124, -125, -126, -127}, null, null, objArr2);
                    forName = Charset.forName(((String) objArr2[0]).intern());
                }
                str2 = clone.getAuthRequestContext(forName);
            }
            try {
                String asString = ((JsonObject) this.KClassImpl$Data$declaredNonStaticMembers$2.fromJson(str2, JsonObject.class)).get("result").getAsJsonObject().get("errorMsg").getAsString();
                Intrinsics.checkNotNullExpressionValue(asString, "");
                str = asString;
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
        }
        int i5 = getErrorConfigVersion + 107;
        scheduleImpl = i5 % 128;
        if (i5 % 2 != 0) {
            return str;
        }
        int i6 = 61 / 0;
        return str;
    }

    private final void MyBillsEntityDataFactory(String p0, String p1, String p2, String p3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Operation Type", p0);
            jSONObject.put("Error Code", p1);
            jSONObject.put("Error Message", p2);
            jSONObject.put("Trace ID", p3);
        } catch (JSONException unused) {
            DanaLog.BuiltInFictitiousFunctionClassFactory("Mixpanel", DanaLogConstants.ExceptionType.MIXPANEL_MESSAGE_EXCEPTION);
        }
        MixPanelDataTracker.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, "Network Error", jSONObject);
        int i = getErrorConfigVersion + 119;
        scheduleImpl = i % 128;
        if (!(i % 2 == 0)) {
            return;
        }
        int i2 = 99 / 0;
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        int i2;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        try {
            char[] cArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                for (int i3 = 0; i3 < length; i3++) {
                    cArr3[i3] = (char) (cArr2[i3] ^ 4571606982258105150L);
                }
                cArr2 = cArr3;
            }
            int i4 = (int) (4571606982258105150L ^ MyBillsEntityDataFactory);
            if (!lookAheadTest) {
                if (!getAuthRequestContext) {
                    try {
                        bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                        char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                        while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                            cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i4);
                            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                        }
                        objArr[0] = new String(cArr4);
                        return;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                int i5 = $11 + 63;
                $10 = i5 % 128;
                if (i5 % 2 != 0) {
                }
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i4);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr5);
                return;
            }
            int i6 = $11 + 113;
            $10 = i6 % 128;
            int i7 = i6 % 2;
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (true) {
                if ((bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult ? 'c' : 'H') == 'H') {
                    objArr[0] = new String(cArr6);
                    return;
                }
                int i8 = $10 + 113;
                $11 = i8 % 128;
                if ((i8 % 2 == 0 ? '5' : '4') != '5') {
                    cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i4);
                    i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                } else {
                    cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult / 0) << bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] >> i] / i4);
                    i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >> 0;
                }
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i2;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
