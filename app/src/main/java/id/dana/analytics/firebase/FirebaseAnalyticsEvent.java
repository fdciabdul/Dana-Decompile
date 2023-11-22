package id.dana.analytics.firebase;

import android.content.Context;
import android.os.Bundle;
import id.dana.analytics.tracker.EventStrategy;

/* loaded from: classes.dex */
public class FirebaseAnalyticsEvent implements EventStrategy {
    private Bundle BuiltInFictitiousFunctionClassFactory;
    private Context KClassImpl$Data$declaredNonStaticMembers$2;
    private String getAuthRequestContext;

    public FirebaseAnalyticsEvent(Context context, String str, Bundle bundle) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.getAuthRequestContext = str;
        this.BuiltInFictitiousFunctionClassFactory = bundle;
    }

    @Override // id.dana.analytics.tracker.EventStrategy
    public final void PlaceComponentResult() {
        com.google.firebase.analytics.FirebaseAnalytics.getInstance(this.KClassImpl$Data$declaredNonStaticMembers$2).logEvent(this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory);
    }
}
