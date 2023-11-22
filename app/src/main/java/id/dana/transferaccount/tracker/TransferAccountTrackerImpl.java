package id.dana.transferaccount.tracker;

import id.dana.analytics.tracker.AnalyticsTracker;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.tracker.constant.TrackerType;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/transferaccount/tracker/TransferAccountTrackerImpl;", "Lid/dana/transferaccount/tracker/TransferAccountTracker;", "", "p0", "", "p1", "", "p2", "", "BuiltInFictitiousFunctionClassFactory", "(ZILjava/lang/String;)V", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "PlaceComponentResult", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "getAuthRequestContext", "<init>", "(Lid/dana/analytics/tracker/AnalyticsTrackerFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferAccountTrackerImpl implements TransferAccountTracker {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final AnalyticsTrackerFactory getAuthRequestContext;

    @Inject
    public TransferAccountTrackerImpl(AnalyticsTrackerFactory analyticsTrackerFactory) {
        Intrinsics.checkNotNullParameter(analyticsTrackerFactory, "");
        this.getAuthRequestContext = analyticsTrackerFactory;
    }

    public final void BuiltInFictitiousFunctionClassFactory(boolean p0, int p1, String p2) {
        Intrinsics.checkNotNullParameter(p2, "");
        AnalyticsTracker KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL);
        String upperCase = String.valueOf(p0).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.TRANSFER_ACCOUNT_PROCESSING, new Pair[]{TuplesKt.to("Result", upperCase), TuplesKt.to("Fail Reason", p2), TuplesKt.to("Duration", Integer.valueOf(p1))});
    }
}
