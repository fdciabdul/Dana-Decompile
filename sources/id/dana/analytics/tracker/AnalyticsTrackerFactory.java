package id.dana.analytics.tracker;

import id.dana.analytics.firebase.FirebaseAnalytics;
import id.dana.analytics.fullstory.FullStoryAnalytics;
import id.dana.analytics.mixpanel.MixpanelAnalytics;
import id.dana.tracker.constant.TrackerType;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000f"}, d2 = {"Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "", "", "p0", "Lid/dana/analytics/tracker/AnalyticsTracker;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lid/dana/analytics/tracker/AnalyticsTracker;", "Lid/dana/analytics/firebase/FirebaseAnalytics;", "MyBillsEntityDataFactory", "Lid/dana/analytics/firebase/FirebaseAnalytics;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/analytics/fullstory/FullStoryAnalytics;", "PlaceComponentResult", "Lid/dana/analytics/fullstory/FullStoryAnalytics;", "Lid/dana/analytics/mixpanel/MixpanelAnalytics;", "Lid/dana/analytics/mixpanel/MixpanelAnalytics;", "getAuthRequestContext", "p1", "p2", "<init>", "(Lid/dana/analytics/firebase/FirebaseAnalytics;Lid/dana/analytics/mixpanel/MixpanelAnalytics;Lid/dana/analytics/fullstory/FullStoryAnalytics;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnalyticsTrackerFactory {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final MixpanelAnalytics getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final FirebaseAnalytics BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FullStoryAnalytics KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public AnalyticsTrackerFactory(FirebaseAnalytics firebaseAnalytics, MixpanelAnalytics mixpanelAnalytics, FullStoryAnalytics fullStoryAnalytics) {
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "");
        Intrinsics.checkNotNullParameter(mixpanelAnalytics, "");
        Intrinsics.checkNotNullParameter(fullStoryAnalytics, "");
        this.BuiltInFictitiousFunctionClassFactory = firebaseAnalytics;
        this.getAuthRequestContext = mixpanelAnalytics;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = fullStoryAnalytics;
    }

    public final AnalyticsTracker KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        int hashCode = p0.hashCode();
        if (hashCode != -1658513466) {
            if (hashCode != -1066664664) {
                if (hashCode == -563351033 && p0.equals("firebase")) {
                    return this.BuiltInFictitiousFunctionClassFactory;
                }
            } else if (p0.equals(TrackerType.MIXPANEL)) {
                return this.getAuthRequestContext;
            }
        } else if (p0.equals(TrackerType.FULLSTORY)) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        throw new IllegalArgumentException();
    }
}
