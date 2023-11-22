package io.branch.referral;

import android.content.Context;

/* loaded from: classes.dex */
class TrackingController {
    boolean PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackingController(Context context) {
        this.PlaceComponentResult = true;
        PrefHelper.BuiltInFictitiousFunctionClassFactory(context);
        this.PlaceComponentResult = PrefHelper.getAuthRequestContext("bnc_tracking_state");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
