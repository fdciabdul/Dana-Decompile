package id.dana.contract.deeplink.path;

import android.net.Uri;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.BranchLinkConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/contract/deeplink/path/FeatureAppleZone;", "", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/Map;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeatureAppleZone {
    public static final FeatureAppleZone INSTANCE = new FeatureAppleZone();

    private FeatureAppleZone() {
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(Map<String, String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String str = p0.get("redirectUrl");
        if (str == null) {
            str = "";
        }
        String str2 = p0.get("bizOrderId");
        if (str2 == null) {
            str2 = "";
        }
        String str3 = p0.get(BranchLinkConstant.AppleZoneParams.PAYMENT_ORDER_ID);
        if (str3 == null) {
            str3 = "";
        }
        if (str.length() > 0) {
            if (str2.length() > 0) {
                if (str3.length() > 0) {
                    String obj = Uri.parse(str).buildUpon().appendQueryParameter("bizOrderId", str2).appendQueryParameter(BranchLinkConstant.AppleZoneParams.PAYMENT_ORDER_ID, str3).build().toString();
                    Intrinsics.checkNotNullExpressionValue(obj, "");
                    DanaH5.startContainerFullUrl(obj);
                }
            }
        }
    }
}
