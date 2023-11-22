package id.dana.onboarding.track;

import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\t\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\fR$\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0080\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0080\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011"}, d2 = {"Lid/dana/onboarding/track/LocationPermissionTrackerImpl;", "Lid/dana/onboarding/track/LocationPermissionTracker;", "", "p0", "", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(ZLjava/lang/String;)V", "MyBillsEntityDataFactory", "(Z)V", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "", "Lkotlin/Pair;", "", "getAuthRequestContext", "[Lkotlin/Pair;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lid/dana/analytics/tracker/AnalyticsTrackerFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocationPermissionTrackerImpl implements LocationPermissionTracker {
    public Pair<String, Object>[] BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final AnalyticsTrackerFactory MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public Pair<String, Object>[] PlaceComponentResult;

    @Inject
    public LocationPermissionTrackerImpl(AnalyticsTrackerFactory analyticsTrackerFactory) {
        Intrinsics.checkNotNullParameter(analyticsTrackerFactory, "");
        this.MyBillsEntityDataFactory = analyticsTrackerFactory;
        this.BuiltInFictitiousFunctionClassFactory = new Pair[0];
        this.PlaceComponentResult = new Pair[0];
    }

    @Override // id.dana.onboarding.track.LocationPermissionTracker
    public final void MyBillsEntityDataFactory(boolean p0) {
        this.BuiltInFictitiousFunctionClassFactory = (Pair[]) ArraysKt.plus((Object[]) this.BuiltInFictitiousFunctionClassFactory, (Object[]) new Pair[]{TuplesKt.to("Result", Boolean.valueOf(p0))});
    }

    @Override // id.dana.onboarding.track.LocationPermissionTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0, String p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        this.PlaceComponentResult = (Pair[]) ArraysKt.plus((Object[]) this.PlaceComponentResult, (Object[]) new Pair[]{TuplesKt.to("Result", Boolean.valueOf(p0)), TuplesKt.to("Source", p1)});
    }
}
