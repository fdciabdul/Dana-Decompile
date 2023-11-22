package id.dana.contract.deeplink.path;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.drawable.NewNearbyMeActivity;
import id.dana.nearbyme.NearbyMeActivity;
import java.util.Map;

/* loaded from: classes4.dex */
public class FeatureNearbyMe {
    public FeatureNearbyMe(Activity activity, Map<String, String> map) {
        Intent intent = new Intent(activity, NewNearbyMeActivity.class);
        if (!map.isEmpty()) {
            intent.putExtra(NearbyMeActivity.EXTRA_SEARCH_KEYWORD, map.get("keyword"));
            intent.putExtra("EXTRA_SHOP_ID", map.get(FeatureParams.SHOP_ID));
            intent.putExtra("EXTRA_MERCHANT_ID", map.get("merchantId"));
            intent.putExtra(NearbyMeActivity.EXTRA_CATEGORY, map.get("category"));
            String str = map.get("lat");
            String str2 = map.get("long");
            String str3 = map.get("source") != null ? map.get("source") : TrackerKey.SourceType.DEEP_LINK;
            if (!TextUtils.isEmpty(str3)) {
                intent.putExtra("EXTRA_SOURCE", str3);
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                intent.putExtra(NearbyMeActivity.EXTRA_LOCATION_LAT, Double.parseDouble(str));
                intent.putExtra(NearbyMeActivity.EXTRA_LOCATION_LON, Double.parseDouble(str2));
            }
        }
        activity.startActivity(intent);
    }
}
