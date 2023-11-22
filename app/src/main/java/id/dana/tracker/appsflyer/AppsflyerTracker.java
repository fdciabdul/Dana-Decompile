package id.dana.tracker.appsflyer;

import com.appsflyer.AppsFlyerLib;

/* loaded from: classes.dex */
public class AppsflyerTracker {
    private AppsflyerTracker() {
    }

    public static void getAuthRequestContext(AppsflyerEvent appsflyerEvent) {
        AppsFlyerLib.getInstance().logEvent(appsflyerEvent.getAuthRequestContext, appsflyerEvent.KClassImpl$Data$declaredNonStaticMembers$2, appsflyerEvent.MyBillsEntityDataFactory);
    }
}
