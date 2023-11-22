package id.dana.analytics.tracker.createpin;

import id.dana.analytics.tracker.AnalyticsTracker;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.tracker.constant.TrackerType;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\b\u001a\u0004\u0018\u00010\nX\u0080\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/analytics/tracker/createpin/InputConfirmPinTrackerImpl;", "Lid/dana/analytics/tracker/createpin/InputConfirmPinTracker;", "", "p0", "", "getAuthRequestContext", "(Z)V", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "<init>", "(Lid/dana/analytics/tracker/AnalyticsTrackerFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InputConfirmPinTrackerImpl implements InputConfirmPinTracker {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final AnalyticsTrackerFactory getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    @Inject
    public InputConfirmPinTrackerImpl(AnalyticsTrackerFactory analyticsTrackerFactory) {
        Intrinsics.checkNotNullParameter(analyticsTrackerFactory, "");
        this.getAuthRequestContext = analyticsTrackerFactory;
    }

    public final void getAuthRequestContext(boolean p0) {
        AnalyticsTracker KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL);
        Pair<String, Object>[] pairArr = new Pair[2];
        String str = this.BuiltInFictitiousFunctionClassFactory;
        if (str == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.to("Source", str);
        pairArr[1] = TuplesKt.to("Success", Boolean.valueOf(p0));
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.PIN_FORGOT, pairArr);
    }
}
