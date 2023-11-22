package id.dana.contract.deeplink.path;

import android.app.Activity;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.drawable.NewNearbyMeActivity;
import id.dana.nearbyme.OtherStoreListActivity;
import id.dana.nearbyme.enums.SearchType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ,\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\u0002¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/contract/deeplink/path/FeatureNearbyAllShops;", "", "Landroid/app/Activity;", "p0", "", "", "p1", "", "MyBillsEntityDataFactory", "(Landroid/app/Activity;Ljava/util/Map;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeatureNearbyAllShops {
    public static final FeatureNearbyAllShops INSTANCE = new FeatureNearbyAllShops();

    private FeatureNearbyAllShops() {
    }

    @JvmStatic
    public static final void MyBillsEntityDataFactory(Activity p0, Map<String, String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String str = p1.get("mid");
        String str2 = str == null ? "" : str;
        String str3 = p1.get("source");
        if (str3 == null) {
            str3 = TrackerKey.SourceType.DEEP_LINK;
        }
        String str4 = str3;
        String str5 = p1.get(FeatureParams.NEARBY_REVAMP);
        if (!Boolean.parseBoolean(str5 != null ? StringsKt.trim((CharSequence) str5).toString() : null)) {
            OtherStoreListActivity.Companion companion = OtherStoreListActivity.INSTANCE;
            OtherStoreListActivity.Companion.BuiltInFictitiousFunctionClassFactory(p0, str2, "", SearchType.MERCHANTID_SORTED_BY_DISTANCE, "", str4);
            return;
        }
        NewNearbyMeActivity.Companion companion2 = NewNearbyMeActivity.INSTANCE;
        NewNearbyMeActivity.Companion.BuiltInFictitiousFunctionClassFactory(p0, str2, str4);
    }
}
