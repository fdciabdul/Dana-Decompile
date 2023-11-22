package id.dana.tracker.appsflyer;

import android.content.Context;
import id.dana.analytics.tracker.EventStrategy;
import java.util.Map;

/* loaded from: classes.dex */
public class AppsflyerEvent implements EventStrategy {
    String KClassImpl$Data$declaredNonStaticMembers$2;
    Map<String, Object> MyBillsEntityDataFactory;
    Context getAuthRequestContext;

    public AppsflyerEvent(Context context, String str, Map<String, Object> map) {
        this.getAuthRequestContext = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.MyBillsEntityDataFactory = map;
    }

    @Override // id.dana.analytics.tracker.EventStrategy
    public final void PlaceComponentResult() {
        AppsflyerTracker.getAuthRequestContext(this);
    }
}
