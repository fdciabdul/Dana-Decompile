package id.dana.contract.deeplink.path;

import android.app.Activity;
import android.content.Intent;
import id.dana.service.ServicesActivity;
import java.util.Map;

/* loaded from: classes4.dex */
public class FeatureService {
    public FeatureService(Activity activity, Map<String, String> map) {
        Intent intent = new Intent(activity, ServicesActivity.class);
        if (!map.isEmpty()) {
            intent.putExtra(ServicesActivity.FILTER_SERVICES, map.get("services"));
            intent.putExtra("FILTER_BY", "key");
        }
        activity.startActivity(intent);
    }
}
