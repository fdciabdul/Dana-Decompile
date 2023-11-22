package id.dana.richview.profile.switchautoroute;

import android.content.Context;
import id.dana.di.PerActivity;
import id.dana.richview.profile.switchautoroute.SwitchAutoRouteContract;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteAnalyticsTracker;", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteContract$AnalyticsTracker;", "", "p0", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Z)V", "Landroid/content/Context;", "PlaceComponentResult", "Landroid/content/Context;", "MyBillsEntityDataFactory", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public final class SwitchAutoRouteAnalyticsTracker implements SwitchAutoRouteContract.AnalyticsTracker {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Context MyBillsEntityDataFactory;

    @Inject
    public SwitchAutoRouteAnalyticsTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.MyBillsEntityDataFactory = context;
    }

    public final void BuiltInFictitiousFunctionClassFactory(String p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        SwitchAutoRouteAnalyticsTracker$trackAutoSwitchPayment$1 switchAutoRouteAnalyticsTracker$trackAutoSwitchPayment$1 = new SwitchAutoRouteAnalyticsTracker$trackAutoSwitchPayment$1(p0, p1);
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(this.MyBillsEntityDataFactory);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        switchAutoRouteAnalyticsTracker$trackAutoSwitchPayment$1.invoke((SwitchAutoRouteAnalyticsTracker$trackAutoSwitchPayment$1) PlaceComponentResult);
        PlaceComponentResult.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, (byte) 0));
    }
}
