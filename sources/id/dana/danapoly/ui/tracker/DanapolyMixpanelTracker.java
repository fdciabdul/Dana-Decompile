package id.dana.danapoly.ui.tracker;

import id.dana.analytics.tracker.AnalyticsTracker;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.tracker.constant.TrackerType;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0007\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0013\u0010\u000f\u001a\u00020\fX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/danapoly/ui/tracker/DanapolyMixpanelTracker;", "Lid/dana/danapoly/ui/tracker/DanapolyAnalyticTracker;", "", "p0", "", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(ILjava/lang/String;)V", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "PlaceComponentResult", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "Lid/dana/analytics/tracker/AnalyticsTracker;", "getAuthRequestContext", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/analytics/tracker/AnalyticsTrackerFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyMixpanelTracker implements DanapolyAnalyticTracker {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final AnalyticsTrackerFactory KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Lazy MyBillsEntityDataFactory;

    @Inject
    public DanapolyMixpanelTracker(AnalyticsTrackerFactory analyticsTrackerFactory) {
        Intrinsics.checkNotNullParameter(analyticsTrackerFactory, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = analyticsTrackerFactory;
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<AnalyticsTracker>() { // from class: id.dana.danapoly.ui.tracker.DanapolyMixpanelTracker$mixpanelTracker$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AnalyticsTracker invoke() {
                AnalyticsTrackerFactory analyticsTrackerFactory2;
                analyticsTrackerFactory2 = DanapolyMixpanelTracker.this.KClassImpl$Data$declaredNonStaticMembers$2;
                return analyticsTrackerFactory2.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL);
            }
        });
    }

    @Override // id.dana.danapoly.ui.tracker.DanapolyAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0, String p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        ((AnalyticsTracker) this.MyBillsEntityDataFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(DanapolyEvents.ROLL_DICE_RESULT, new Pair[]{TuplesKt.to(DanapolyProperty.DICE_NUMBER, Integer.valueOf(p0)), TuplesKt.to(DanapolyProperty.CARD_TYPE, p1)});
    }
}
