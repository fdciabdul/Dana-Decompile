package id.dana.contract.deeplink.path;

import android.app.Activity;
import id.dana.animation.HomeTabActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/contract/deeplink/path/FeatureMerchantReview;", "", "Landroid/app/Activity;", "p0", "", "", "p1", "<init>", "(Landroid/app/Activity;Ljava/util/Map;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeatureMerchantReview {
    public FeatureMerchantReview(Activity activity, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(map, "");
        String str = map.get(HomeTabActivity.EXTRA_SHOP_ID);
        if (str != null) {
            String str2 = map.get("source");
            String str3 = str2 != null ? str2 : "";
            HomeTabActivity.Companion companion = HomeTabActivity.INSTANCE;
            HomeTabActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(activity, str3, str);
        }
    }
}
