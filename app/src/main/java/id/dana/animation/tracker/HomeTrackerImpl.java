package id.dana.animation.tracker;

import android.content.Context;
import dagger.Lazy;
import id.dana.R;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.animation.adapter.HomeAdapter;
import id.dana.model.ThirdPartyService;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.tracker.constant.TrackerType;
import id.dana.utils.ResourceUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0003\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J?\u0010\u0005\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0005\u0010\u0013R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u0017X\u0000¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001b0\u001aX\u0000¢\u0006\u0006\n\u0004\b\u0006\u0010\u001c"}, d2 = {"Lid/dana/home/tracker/HomeTrackerImpl;", "Lid/dana/home/tracker/HomeTracker;", "", "getAuthRequestContext", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "", "p0", "(Ljava/lang/String;)V", "PlaceComponentResult", "Landroid/content/Context;", "p1", "", "Lid/dana/model/ThirdPartyService;", "p2", "", "p3", "p4", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;ILjava/lang/Integer;)V", "Ldagger/Lazy;", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "Ldagger/Lazy;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "MyBillsEntityDataFactory", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "", "Ljava/util/Map;", "<init>", "(Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HomeTrackerImpl implements HomeTracker {
    public final Map<String, Object> BuiltInFictitiousFunctionClassFactory;
    public final AtomicBoolean MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Lazy<AnalyticsTrackerFactory> getAuthRequestContext;

    @Inject
    public HomeTrackerImpl(Lazy<AnalyticsTrackerFactory> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.getAuthRequestContext = lazy;
        this.MyBillsEntityDataFactory = new AtomicBoolean(true);
        this.BuiltInFictitiousFunctionClassFactory = new LinkedHashMap();
    }

    public final void getAuthRequestContext() {
        AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory(HomeAdapter.HomeWidget.SERVICES);
        if (this.MyBillsEntityDataFactory.get()) {
            this.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.ALL_SERVICE_LOAD_TIME, System.currentTimeMillis());
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory(HomeAdapter.HomeWidget.PROMO_CENTER);
        if (this.MyBillsEntityDataFactory.get()) {
            this.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.WHAT_S_NEW_LOAD_TIME, System.currentTimeMillis());
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory(HomeAdapter.HomeWidget.BOTTOM_BAR);
        if (this.MyBillsEntityDataFactory.get()) {
            this.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.BOTTOM_BAR_LOAD_TIME, System.currentTimeMillis());
        }
    }

    public final void PlaceComponentResult() {
        if (this.MyBillsEntityDataFactory.get()) {
            Map<String, Object> map = this.BuiltInFictitiousFunctionClassFactory;
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                arrayList.add(TuplesKt.to(entry.getKey(), entry.getValue()));
            }
            Object[] array = arrayList.toArray(new Pair[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            this.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.Event.HOME_ASSET_READY, (Pair[]) array);
            this.MyBillsEntityDataFactory.set(false);
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Context p0, String p1, List<ThirdPartyService> p2, int p3, Integer p4) {
        Object obj;
        String PlaceComponentResult;
        String str;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Iterator<T> it = p2.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ThirdPartyService) obj).NetworkUserEntityData$$ExternalSyntheticLambda8, p1)) {
                break;
            }
        }
        ThirdPartyService thirdPartyService = (ThirdPartyService) obj;
        if (!StringsKt.equals(p1, "service_paylater_loan_personal", true) || p3 <= 0) {
            if (StringsKt.equals(p1, "service_paylater_loan_personal", true) && p3 == 0) {
                PlaceComponentResult = ResourceUtils.PlaceComponentResult(p0, p0.getString(R.string.paylater_loan_personal_subtitle_due_today), p0.getString(R.string.paylater_loan_personal_subtitle_due_today));
            } else {
                String str2 = thirdPartyService != null ? thirdPartyService.lookAheadTest : null;
                if (str2 == null) {
                    str2 = "";
                }
                String str3 = thirdPartyService != null ? thirdPartyService.lookAheadTest : null;
                if (str3 == null) {
                    str3 = "";
                }
                PlaceComponentResult = ResourceUtils.PlaceComponentResult(p0, str2, str3);
            }
        } else {
            String str4 = thirdPartyService != null ? thirdPartyService.lookAheadTest : null;
            if (str4 == null) {
                str4 = "";
            }
            String str5 = thirdPartyService != null ? thirdPartyService.lookAheadTest : null;
            if (str5 == null) {
                str5 = "";
            }
            String PlaceComponentResult2 = ResourceUtils.PlaceComponentResult(p0, str4, str5);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            PlaceComponentResult = String.format(PlaceComponentResult2, Arrays.copyOf(new Object[]{String.valueOf(p3)}, 1));
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        }
        String str6 = thirdPartyService != null ? thirdPartyService.getErrorConfigVersion : null;
        if (str6 == null) {
            str6 = "";
        }
        String str7 = thirdPartyService != null ? thirdPartyService.getErrorConfigVersion : null;
        String PlaceComponentResult3 = ResourceUtils.PlaceComponentResult(p0, str6, str7 != null ? str7 : "");
        if (thirdPartyService == null || (str = thirdPartyService.com.iap.ac.android.biz.common.utils.log.LogConstants.RESULT_FALSE java.lang.String) == null) {
            str = ThirdPartyService.UIVersion.VERSION_1;
        }
        this.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.Event.SERVICE_FEATURED_DISPLAYED, p4 != null ? new Pair[]{TuplesKt.to(TrackerDataKey.Property.SERVICE_HIGHLIGHT, p1), TuplesKt.to(TrackerDataKey.Property.SERVICE_HIGHLIGHT_DESCRIPTION, PlaceComponentResult), TuplesKt.to(TrackerDataKey.Property.SERVICE_HIGHLIGHT_BUTTON, PlaceComponentResult3), TuplesKt.to(TrackerDataKey.Property.SERVICE_HIGHLIGHT_SLOT, p4), TuplesKt.to(TrackerDataKey.Property.UI_VERSION, str)} : new Pair[]{TuplesKt.to(TrackerDataKey.Property.SERVICE_HIGHLIGHT, p1), TuplesKt.to(TrackerDataKey.Property.SERVICE_HIGHLIGHT_DESCRIPTION, PlaceComponentResult), TuplesKt.to(TrackerDataKey.Property.SERVICE_HIGHLIGHT_BUTTON, PlaceComponentResult3), TuplesKt.to(TrackerDataKey.Property.UI_VERSION, str)});
    }

    public final void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.Event.TAP_FOUR_KING, new Pair[]{TuplesKt.to(TrackerDataKey.Property.FEATURE, p0)});
    }
}
