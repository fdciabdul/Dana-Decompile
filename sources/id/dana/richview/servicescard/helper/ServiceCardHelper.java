package id.dana.richview.servicescard.helper;

import android.content.Context;
import android.text.TextUtils;
import id.dana.model.ThirdPartyService;
import id.dana.utils.ResourceUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u001f\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\n\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\r"}, d2 = {"Lid/dana/richview/servicescard/helper/ServiceCardHelper;", "", "Landroid/content/Context;", "p0", "", "p1", "PlaceComponentResult", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "(Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/model/ThirdPartyService;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Lid/dana/model/ThirdPartyService;)Ljava/lang/String;", "", "(Landroid/content/Context;Ljava/lang/String;)I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServiceCardHelper {
    public static final ServiceCardHelper INSTANCE = new ServiceCardHelper();

    private ServiceCardHelper() {
    }

    public static String PlaceComponentResult(Context p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (TextUtils.isEmpty(p1)) {
            return "";
        }
        String PlaceComponentResult = PlaceComponentResult(p1);
        Intrinsics.checkNotNullParameter(PlaceComponentResult, "");
        int identifier = (p0 == null || TextUtils.isEmpty(PlaceComponentResult)) ? 0 : p0.getResources().getIdentifier(PlaceComponentResult, "string", p0.getPackageName());
        return identifier > 0 ? p0.getString(identifier) : p1;
    }

    public static String BuiltInFictitiousFunctionClassFactory(Context p0, ThirdPartyService p1) {
        String PlaceComponentResult;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (!Intrinsics.areEqual(Locale.getDefault().getLanguage(), new Locale("in").getLanguage()) || p1.NetworkUserEntityData$$ExternalSyntheticLambda3 == null) {
            PlaceComponentResult = ResourceUtils.PlaceComponentResult(p0, p1.FragmentBottomSheetPaymentSettingBinding, p1.FragmentBottomSheetPaymentSettingBinding);
        } else {
            PlaceComponentResult = p1.NetworkUserEntityData$$ExternalSyntheticLambda3;
        }
        return PlaceComponentResult(p0, PlaceComponentResult);
    }

    private static String PlaceComponentResult(String p0) {
        String str;
        String replace;
        String str2 = p0;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        if (p0 == null || (replace = new Regex(" ").replace(str2, "_")) == null) {
            str = null;
        } else {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "");
            str = replace.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(str, "");
        }
        return str == null ? "" : str;
    }

    public static int BuiltInFictitiousFunctionClassFactory(Context p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        String PlaceComponentResult = PlaceComponentResult(p1);
        if (TextUtils.isEmpty(PlaceComponentResult)) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("icon_");
        sb.append(PlaceComponentResult);
        String obj = sb.toString();
        Intrinsics.checkNotNullParameter(p0, "");
        if (TextUtils.isEmpty(obj)) {
            return 0;
        }
        return p0.getResources().getIdentifier(obj, "drawable", p0.getPackageName());
    }
}
