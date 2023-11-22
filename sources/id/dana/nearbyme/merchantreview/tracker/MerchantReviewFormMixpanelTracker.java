package id.dana.nearbyme.merchantreview.tracker;

import android.content.Context;
import id.dana.analytics.mixpanel.MixPanelEvent;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.nearbyme.merchantreview.model.MerchantReviewFormAnalyticModel;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/nearbyme/merchantreview/tracker/MerchantReviewFormMixpanelTracker;", "Lid/dana/nearbyme/merchantreview/tracker/MerchantReviewFormAnalyticTracker;", "", "p0", "p1", "p2", "p3", "", "p4", "", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Lid/dana/nearbyme/merchantreview/model/MerchantReviewFormAnalyticModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/nearbyme/merchantreview/model/MerchantReviewFormAnalyticModel;)V", "Landroid/content/Context;", "PlaceComponentResult", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantReviewFormMixpanelTracker implements MerchantReviewFormAnalyticTracker {
    private final Context PlaceComponentResult;

    @Inject
    public MerchantReviewFormMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = context;
    }

    @Override // id.dana.nearbyme.merchantreview.tracker.MerchantReviewFormAnalyticTracker
    public final void getAuthRequestContext(String p0, String p1, String p2, String p3, boolean p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        MixPanelEvent.Builder authRequestContext = MixPanelEvent.Builder.getAuthRequestContext(this.PlaceComponentResult);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = TrackerKey.Event.NEARBY_REVIEW_FORM_OPEN;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "");
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("Source", StringsKt.capitalize(p0, locale));
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("Merchant Name", p1);
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("Merchant ID", p2);
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("Shop Name", p3);
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.NearbyMerchantProperty.UPDATE_REVIEW, String.valueOf(p4));
        new MixPanelEvent(authRequestContext, (byte) 0).PlaceComponentResult();
    }

    @Override // id.dana.nearbyme.merchantreview.tracker.MerchantReviewFormAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(MerchantReviewFormAnalyticModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MixPanelEvent.Builder authRequestContext = MixPanelEvent.Builder.getAuthRequestContext(this.PlaceComponentResult);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = TrackerKey.Event.NEARBY_REVIEW_FORM_SUBMIT;
        String str = p0.scheduleImpl;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "");
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("Source", StringsKt.capitalize(str, locale));
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("Merchant Name", p0.KClassImpl$Data$declaredNonStaticMembers$2);
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("Merchant ID", p0.BuiltInFictitiousFunctionClassFactory);
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2("Shop Name", p0.PlaceComponentResult);
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.NearbyMerchantProperty.HAS_REVIEW, String.valueOf(p0.getMyBillsEntityDataFactory()));
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.NearbyMerchantProperty.UPDATE_REVIEW, String.valueOf(p0.getGetAuthRequestContext()));
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.NearbyMerchantProperty.STARS_SUBMITTED, p0.getErrorConfigVersion);
        byte b = 0;
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.NearbyMerchantProperty.TAGS_SUBMITTED, p0.lookAheadTest.length() == 0 ? "No Tags" : p0.lookAheadTest);
        new MixPanelEvent(authRequestContext, b).PlaceComponentResult();
    }
}
