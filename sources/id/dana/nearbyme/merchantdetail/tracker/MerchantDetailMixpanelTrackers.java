package id.dana.nearbyme.merchantdetail.tracker;

import android.content.Context;
import id.dana.analytics.mixpanel.MixPanelEvent;
import id.dana.analytics.tracker.TrackerKey;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ/\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\r"}, d2 = {"Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailMixpanelTrackers;", "Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;", "", "p0", "p1", "p2", "p3", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Context;", "Landroid/content/Context;", "getAuthRequestContext", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantDetailMixpanelTrackers implements MerchantDetailAnalyticTracker {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Context getAuthRequestContext;

    @Inject
    public MerchantDetailMixpanelTrackers(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.getAuthRequestContext = context;
    }

    @Override // id.dana.nearbyme.merchantdetail.tracker.MerchantDetailAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        MixPanelEvent.Builder authRequestContext = MixPanelEvent.Builder.getAuthRequestContext(this.getAuthRequestContext);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = "Nearby Detail Open";
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("Source", p0);
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("Merchant Name", p1);
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("Shop Name", p2);
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.NearbyMerchantProperty.MCC_TYPE, p3);
        new MixPanelEvent(authRequestContext, (byte) 0).PlaceComponentResult();
    }

    @Override // id.dana.nearbyme.merchantdetail.tracker.MerchantDetailAnalyticTracker
    public final void PlaceComponentResult(String p0, String p1, String p2, String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        MixPanelEvent.Builder authRequestContext = MixPanelEvent.Builder.getAuthRequestContext(this.getAuthRequestContext);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = TrackerKey.Event.NEARBY_DETAIL_REVIEW_OPEN;
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("Source", p0);
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("Merchant Name", p1);
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("Shop Name", p2);
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.NearbyMerchantProperty.MCC_TYPE, p3);
        new MixPanelEvent(authRequestContext, (byte) 0).PlaceComponentResult();
    }

    @Override // id.dana.nearbyme.merchantdetail.tracker.MerchantDetailAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        MixPanelEvent.Builder authRequestContext = MixPanelEvent.Builder.getAuthRequestContext(this.getAuthRequestContext);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = TrackerKey.Event.NEARBY_DETAIL_PAGE_SHARE_LINK;
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("Merchant Name", p0);
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("Shop Name", p1);
        new MixPanelEvent(authRequestContext, (byte) 0).PlaceComponentResult();
    }
}
