package id.dana.contract.deeplink.path;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseActivity;
import java.util.Map;

/* loaded from: classes4.dex */
public class BaseDeeplinkFeature {
    /* JADX INFO: Access modifiers changed from: protected */
    public static Intent BuiltInFictitiousFunctionClassFactory(Activity activity, Map<String, String> map, Class<?> cls) {
        Intent intent = new Intent(activity, cls);
        if (!map.isEmpty()) {
            String PlaceComponentResult = PlaceComponentResult(map, activity);
            if (!TextUtils.isEmpty(PlaceComponentResult)) {
                intent.putExtra("source", PlaceComponentResult);
            }
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String PlaceComponentResult(Map<String, String> map, Activity activity) {
        String str = map != null ? map.get("source") : null;
        if (TextUtils.isEmpty(str) && (activity instanceof BaseActivity)) {
            str = ((BaseActivity) activity).getSource();
        }
        return TextUtils.isEmpty(str) ? TrackerKey.SourceType.DEEP_LINK : str;
    }
}
