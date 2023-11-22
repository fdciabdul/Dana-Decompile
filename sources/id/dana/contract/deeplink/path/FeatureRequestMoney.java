package id.dana.contract.deeplink.path;

import android.app.Activity;
import android.content.Intent;
import id.dana.requestmoney.RequestMoneyActivity;
import java.util.Map;

/* loaded from: classes4.dex */
public class FeatureRequestMoney extends BaseDeeplinkFeature {
    public FeatureRequestMoney(Activity activity, Map<String, String> map) {
        Intent BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(activity, map, RequestMoneyActivity.class);
        if (!map.isEmpty()) {
            BuiltInFictitiousFunctionClassFactory.putExtra("amount", map.get("amount"));
        }
        activity.startActivity(BuiltInFictitiousFunctionClassFactory);
    }
}
