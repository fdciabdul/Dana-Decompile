package id.dana.contract.deeplink.path;

import android.app.Activity;
import android.util.Base64;
import id.dana.drawable.NewNearbyMeActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007JB\u0010\r\u001a\u00020\f2\r\u0010\u0003\u001a\t\u0018\u00010\b¢\u0006\u0002\b\t2\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n¢\u0006\u0002\b\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/contract/deeplink/path/FeatureMerchantDetail;", "", "", "p0", "", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Z)Ljava/lang/String;", "Landroid/app/Activity;", "Lorg/jetbrains/annotations/NotNull;", "", "p2", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/app/Activity;Ljava/util/Map;Z)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeatureMerchantDetail {
    public static final FeatureMerchantDetail INSTANCE = new FeatureMerchantDetail();

    private FeatureMerchantDetail() {
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(Activity p0, Map<String, String> p1, boolean p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String str = p1.get("s");
        if (str == null) {
            str = "";
        }
        String KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(str, p2);
        String str2 = p1.get("m");
        String KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(str2 != null ? str2 : "", p2);
        String str3 = p1.get("source");
        if (str3 == null) {
            str3 = "Deeplink";
        }
        NewNearbyMeActivity.Companion companion = NewNearbyMeActivity.INSTANCE;
        NewNearbyMeActivity.Companion.BuiltInFictitiousFunctionClassFactory(p0, KClassImpl$Data$declaredNonStaticMembers$22, KClassImpl$Data$declaredNonStaticMembers$2, str3);
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(String p0, boolean p1) {
        if (p1) {
            try {
                byte[] decode = Base64.decode(p0, 0);
                Intrinsics.checkNotNullExpressionValue(decode, "");
                return new String(decode, Charsets.UTF_8);
            } catch (Exception unused) {
                return p0;
            }
        }
        return p0;
    }
}
