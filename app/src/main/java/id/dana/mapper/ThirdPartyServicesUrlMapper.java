package id.dana.mapper;

import android.net.Uri;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.data.constant.UrlParam;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.model.ThirdPartyService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\b\u0010\tJ3\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\tJ\u0013\u0010\u000e\u001a\u00020\r*\u00020\u0002H\u0003¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/mapper/ThirdPartyServicesUrlMapper;", "", "", "p0", "p1", "p2", "Lid/dana/model/ThirdPartyService;", "p3", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/model/ThirdPartyService;)Ljava/lang/String;", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;)Ljava/lang/String;", "", "getAuthRequestContext", "(Ljava/lang/String;)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ThirdPartyServicesUrlMapper {
    public static final ThirdPartyServicesUrlMapper INSTANCE = new ThirdPartyServicesUrlMapper();

    private ThirdPartyServicesUrlMapper() {
    }

    @JvmStatic
    public static final String KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, ThirdPartyServiceResponse p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p3, "");
        return KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, p2, new ThirdPartyService(null, null, p3.getAction(), null, null, false, null, null, null, null, null, null, null, null, false, 0, null, null, null, null, null, null, null, null, false, null, p3.getNeedConsult(), null, null, null, null, 0, null, null, false, 0, null, null, null, null, null, false, -67108869, 1023, null));
    }

    @JvmStatic
    public static final String KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, ThirdPartyService p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p3, "");
        if (getAuthRequestContext(p0)) {
            return BuiltInFictitiousFunctionClassFactory(p0, p1, p2, p3);
        }
        Uri.Builder buildUpon = Uri.parse(p0).buildUpon();
        if (Intrinsics.areEqual("production", "production")) {
            buildUpon.scheme("https");
        }
        if (StringsKt.contains$default((CharSequence) p0, (CharSequence) "lifestyle-subscription-list", false, 2, (Object) null)) {
            buildUpon.appendQueryParameter("entryPoint", "allservices");
        }
        if (p1 != null) {
            buildUpon.appendQueryParameter("authCode", p1);
        }
        if (p2 != null) {
            buildUpon.appendQueryParameter(UrlParam.REQUEST_ID, p2);
        }
        if (p3.getSubSequence() && Intrinsics.areEqual(p3.BuiltInFictitiousFunctionClassFactory, "GET")) {
            buildUpon.appendQueryParameter(UrlParam.NEED_CONSULT, String.valueOf(p3.getSubSequence()));
        }
        String obj = buildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    @JvmStatic
    private static final boolean getAuthRequestContext(String str) {
        return StringsKt.contains$default((CharSequence) str, (CharSequence) "/#/", false, 2, (Object) null);
    }

    @JvmStatic
    private static final String BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2, ThirdPartyService p3) {
        StringBuilder sb = new StringBuilder(p0);
        if (StringsKt.contains$default((CharSequence) p0, (CharSequence) "lifestyle-subscription-list", false, 2, (Object) null)) {
            sb.append("?entryPoint=allservices");
        }
        if (p1 != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(DanaUrl.SERVICE_AUTHCODE);
            sb2.append(p1);
            sb.append(sb2.toString());
        }
        if (p2 != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("?requestId=");
            sb3.append(p2);
            sb.append(sb3.toString());
        }
        if (p3.getSubSequence() && Intrinsics.areEqual(p3.BuiltInFictitiousFunctionClassFactory, "GET")) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("?needConsult=");
            sb4.append(p3.getSubSequence());
            sb.append(sb4.toString());
        }
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return DanaH5.correctedUrl(obj);
    }
}
