package com.ipification.mobile.sdk.android.interceptor;

import android.content.Context;
import com.ipification.mobile.sdk.android.IPConfiguration;
import com.ipification.mobile.sdk.android.callback.CellularCallback;
import com.ipification.mobile.sdk.android.utils.DeviceUtils;
import com.ipification.mobile.sdk.android.utils.IPConstant;
import com.ipification.mobile.sdk.android.utils.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B9\u0012\u0006\u0010\u0004\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\n\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016R\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018"}, d2 = {"Lcom/ipification/mobile/sdk/android/interceptor/HandleRedirectInterceptor;", "T", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "p0", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "", "", "getAuthRequestContext", "(Ljava/lang/String;)V", "", "Z", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "Lcom/ipification/mobile/sdk/android/utils/DeviceUtils;", "PlaceComponentResult", "Lcom/ipification/mobile/sdk/android/utils/DeviceUtils;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/ipification/mobile/sdk/android/callback/CellularCallback;", "Lcom/ipification/mobile/sdk/android/callback/CellularCallback;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "scheduleImpl", "p1", "p2", "p3", "p4", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/ipification/mobile/sdk/android/callback/CellularCallback;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class HandleRedirectInterceptor<T> implements Interceptor {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public CellularCallback<T> BuiltInFictitiousFunctionClassFactory;
    public final Context MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public DeviceUtils KClassImpl$Data$declaredNonStaticMembers$2;
    public boolean getAuthRequestContext;
    public String scheduleImpl;

    public HandleRedirectInterceptor(Context context, String str, String str2, Boolean bool, CellularCallback<T> cellularCallback) {
        Intrinsics.checkParameterIsNotNull(context, "");
        Intrinsics.checkParameterIsNotNull(str, "");
        Intrinsics.checkParameterIsNotNull(str2, "");
        this.PlaceComponentResult = str2;
        this.scheduleImpl = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = DeviceUtils.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(context);
        this.getAuthRequestContext = Intrinsics.areEqual(bool, Boolean.TRUE);
        this.MyBillsEntityDataFactory = context;
        this.BuiltInFictitiousFunctionClassFactory = cellularCallback;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x02f4, code lost:
    
        if (r8 != true) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x02f6, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02f9, code lost:
    
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02fa, code lost:
    
        if (r8 == false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02fc, code lost:
    
        r3.addHeader(r1.headers().name(r6), r1.headers().value(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0311, code lost:
    
        if (r7 >= r5) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0313, code lost:
    
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0315, code lost:
    
        r3.code(200).message("success").body(r4);
        r1 = r1.body();
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0329, code lost:
    
        if (r1 == null) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x032b, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x032e, code lost:
    
        r1 = r3.build();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0335, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0242, code lost:
    
        if (kotlin.text.StringsKt.startsWith$default(r4, r16.PlaceComponentResult, false, 2, (java.lang.Object) null) == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0263, code lost:
    
        if (kotlin.text.StringsKt.startsWith$default(r4, r16.PlaceComponentResult, false, 2, (java.lang.Object) null) == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x026f, code lost:
    
        if (r1.headers().get("imbox_session_id") != null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0271, code lost:
    
        getAuthRequestContext("matched - process");
        r3 = new okhttp3.Response.Builder().request(r3).protocol(okhttp3.Protocol.HTTP_1_1);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, "");
        r4 = r1.body();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x028c, code lost:
    
        if (r4 != null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x028e, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwNpe();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0291, code lost:
    
        r4 = r4.contentType();
        r6 = r1.headers().get("location");
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x029d, code lost:
    
        if (r6 != null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x029f, code lost:
    
        r6 = r1.headers().get("Location");
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x02a7, code lost:
    
        if (r6 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x02a9, code lost:
    
        r6 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x02aa, code lost:
    
        r4 = okhttp3.ResponseBody.create(r4, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x02b6, code lost:
    
        if (r1.headers().size() <= 0) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x02b8, code lost:
    
        r5 = r1.headers().size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x02c0, code lost:
    
        if (r5 <= 0) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x02c2, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x02c3, code lost:
    
        r7 = r6 + 1;
        r8 = r1.headers().name(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x02cd, code lost:
    
        if (r8 == null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02d3, code lost:
    
        if (r8.length() <= 0) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02d5, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02d7, code lost:
    
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02d9, code lost:
    
        if (r8 != true) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02db, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02dd, code lost:
    
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x02de, code lost:
    
        if (r8 == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x02e0, code lost:
    
        r8 = r1.headers().value(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02e8, code lost:
    
        if (r8 == null) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02ee, code lost:
    
        if (r8.length() <= 0) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x02f0, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x02f2, code lost:
    
        r8 = false;
     */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okhttp3.Response intercept(okhttp3.Interceptor.Chain r17) {
        /*
            Method dump skipped, instructions count: 829
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipification.mobile.sdk.android.interceptor.HandleRedirectInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    private static void getAuthRequestContext(String p0) {
        IPConfiguration.Companion companion = IPConfiguration.INSTANCE;
        if (IPConfiguration.Companion.MyBillsEntityDataFactory().getCom.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String()) {
            IPConstant.Companion companion2 = IPConstant.INSTANCE;
            IPConstant PlaceComponentResult = IPConstant.Companion.PlaceComponentResult();
            StringBuilder sb = new StringBuilder();
            sb.append(PlaceComponentResult.DatabaseTableConfigUtil);
            sb.append("[HandleRedirectInterceptor] ");
            LogUtils.Companion companion3 = LogUtils.getAuthRequestContext;
            sb.append(LogUtils.Companion.MyBillsEntityDataFactory());
            sb.append(" - ");
            sb.append(p0);
            sb.append('\n');
            String obj = sb.toString();
            Intrinsics.checkParameterIsNotNull(obj, "");
            PlaceComponentResult.DatabaseTableConfigUtil = obj;
        }
    }
}
