package com.twilio.verify.networking;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.common.net.HttpHeaders;
import com.twilio.verify.BuildConfig;
import com.twilio.verify.data.Base64EncoderKt;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ+\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0011"}, d2 = {"Lcom/twilio/verify/networking/RequestHelper;", "", "Lcom/twilio/verify/networking/HttpMethod;", "p0", "", "", "PlaceComponentResult", "(Lcom/twilio/verify/networking/HttpMethod;)Ljava/util/Map;", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;)Ljava/lang/String;", "Lcom/twilio/verify/networking/MediaTypeValue;", "p1", "getAuthRequestContext", "(Lcom/twilio/verify/networking/MediaTypeValue;Lcom/twilio/verify/networking/MediaTypeValue;)Ljava/util/Map;", "Lkotlin/Pair;", "MyBillsEntityDataFactory", "Lkotlin/Pair;", "BuiltInFictitiousFunctionClassFactory", "Lcom/twilio/verify/networking/BasicAuthorization;", "<init>", "(Landroid/content/Context;Lcom/twilio/verify/networking/BasicAuthorization;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class RequestHelper {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {10, -99, -17, -84, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4, 6, Ascii.ETB, -43, TarHeader.LF_CONTIG, 8, 4, 5, 2, 6, Ascii.ESC, -3, 14, 7, -29, 45, 0, 17};
    public static final int getAuthRequestContext = 31;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Pair<String, String> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Pair<String, String> PlaceComponentResult;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 8, 0})
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[HttpMethod.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            iArr[HttpMethod.Post.ordinal()] = 1;
            iArr[HttpMethod.Delete.ordinal()] = 2;
            iArr[HttpMethod.Get.ordinal()] = 3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 6
            int r7 = r7 + 97
            byte[] r0 = com.twilio.verify.networking.RequestHelper.BuiltInFictitiousFunctionClassFactory
            int r9 = r9 * 5
            int r9 = 23 - r9
            int r8 = r8 * 22
            int r8 = 25 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L34
        L19:
            r3 = 0
        L1a:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            int r8 = r8 + 1
            if (r4 != r9) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r8]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L34:
            int r9 = r9 + r7
            int r7 = r9 + (-8)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twilio.verify.networking.RequestHelper.a(int, int, int, java.lang.Object[]):void");
    }

    public RequestHelper(Context context, BasicAuthorization basicAuthorization) {
        Intrinsics.checkParameterIsNotNull(context, "");
        Intrinsics.checkParameterIsNotNull(basicAuthorization, "");
        this.BuiltInFictitiousFunctionClassFactory = new Pair<>(HttpHeaders.USER_AGENT, KClassImpl$Data$declaredNonStaticMembers$2(context));
        StringBuilder sb = new StringBuilder();
        sb.append(basicAuthorization.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(':');
        sb.append(basicAuthorization.MyBillsEntityDataFactory);
        String obj = sb.toString();
        Charset charset = Charsets.UTF_8;
        if (obj != null) {
            byte[] bytes = obj.getBytes(charset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "");
            String PlaceComponentResult = Base64EncoderKt.PlaceComponentResult(bytes, 2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Basic ");
            sb2.append(PlaceComponentResult);
            this.PlaceComponentResult = TuplesKt.to("Authorization", sb2.toString());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
        int i;
        StringBuilder sb = new StringBuilder();
        try {
            byte b = BuiltInFictitiousFunctionClassFactory[41];
            Object[] objArr = new Object[1];
            a(b, (byte) (b + 1), BuiltInFictitiousFunctionClassFactory[41], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (getAuthRequestContext & 1);
            byte b3 = BuiltInFictitiousFunctionClassFactory[41];
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 + 1), objArr2);
            CharSequence loadLabel = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(p0, null)).loadLabel(p0.getPackageManager());
            Intrinsics.checkExpressionValueIsNotNull(loadLabel, "");
            String str = p0.getPackageManager().getPackageInfo(p0.getPackageName(), 0).versionName;
            if (Build.VERSION.SDK_INT >= 28) {
                PackageInfo packageInfo = p0.getPackageManager().getPackageInfo(p0.getPackageName(), 0);
                Intrinsics.checkExpressionValueIsNotNull(packageInfo, "");
                i = (int) packageInfo.getLongVersionCode();
            } else {
                i = p0.getPackageManager().getPackageInfo(p0.getPackageName(), 0).versionCode;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Android ");
            sb2.append(Build.VERSION.RELEASE);
            sb2.append(" (");
            sb2.append(Build.VERSION.SDK_INT);
            sb2.append(')');
            String obj = sb2.toString();
            String str2 = Build.MODEL;
            sb.append(loadLabel);
            sb.append("; ");
            sb.append("Android");
            sb.append("; ");
            sb.append(str);
            sb.append("; ");
            sb.append(i);
            sb.append("; ");
            sb.append(obj);
            sb.append("; ");
            sb.append(str2);
            sb.append("; ");
            sb.append("VerifySDK");
            sb.append("; ");
            sb.append(BuildConfig.VERSION_NAME);
            sb.append("; ");
            sb.append(2007);
            String obj2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(obj2, "");
            return obj2;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public final Map<String, String> PlaceComponentResult(HttpMethod p0) {
        Map<String, String> mapOf = MapsKt.mapOf(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
        if (p0 == null) {
            return mapOf;
        }
        int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[p0.ordinal()];
        if (i == 1 || i == 2) {
            return MapsKt.plus(mapOf, getAuthRequestContext(MediaTypeValue.Json, MediaTypeValue.UrlEncoded));
        }
        if (i != 3) {
            return mapOf;
        }
        MediaTypeValue mediaTypeValue = MediaTypeValue.UrlEncoded;
        return MapsKt.plus(mapOf, getAuthRequestContext(mediaTypeValue, mediaTypeValue));
    }

    private static Map<String, String> getAuthRequestContext(MediaTypeValue p0, MediaTypeValue p1) {
        return MapsKt.mapOf(TuplesKt.to(MediaTypeHeader.Accept.getType(), p0.getType()), TuplesKt.to(MediaTypeHeader.ContentType.getType(), p1.getType()));
    }
}
