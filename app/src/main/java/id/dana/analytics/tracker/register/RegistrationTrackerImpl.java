package id.dana.analytics.tracker.register;

import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.analytics.utils.DateTimeUtil;
import id.dana.tracker.constant.TrackerType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J7\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000b\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014X\u0080\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015R$\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00180\u00170\u0016X\u0080\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/analytics/tracker/register/RegistrationTrackerImpl;", "Lid/dana/analytics/tracker/register/RegistrationTracker;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "p1", "p2", "p3", "p4", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "(J)V", "BuiltInFictitiousFunctionClassFactory", "()V", "getAuthRequestContext", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "", "Ljava/util/List;", "", "Lkotlin/Pair;", "", "MyBillsEntityDataFactory", "[Lkotlin/Pair;", "<init>", "(Lid/dana/analytics/tracker/AnalyticsTrackerFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RegistrationTrackerImpl implements RegistrationTracker {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final AnalyticsTrackerFactory getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public Pair<String, Object>[] PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public List<String> BuiltInFictitiousFunctionClassFactory;

    @Inject
    public RegistrationTrackerImpl(AnalyticsTrackerFactory analyticsTrackerFactory) {
        Intrinsics.checkNotNullParameter(analyticsTrackerFactory, "");
        this.getAuthRequestContext = analyticsTrackerFactory;
        this.BuiltInFictitiousFunctionClassFactory = new ArrayList();
        this.PlaceComponentResult = new Pair[0];
    }

    @Override // id.dana.analytics.tracker.register.RegistrationTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory.clear();
        this.BuiltInFictitiousFunctionClassFactory.add(p0);
    }

    @Override // id.dana.analytics.tracker.register.RegistrationTracker
    public final void PlaceComponentResult(String p0, String p1, String p2, String p3, String p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        DateTimeUtil dateTimeUtil = DateTimeUtil.INSTANCE;
        Locale PlaceComponentResult = DateTimeUtil.PlaceComponentResult();
        long time = new Date().getTime();
        Intrinsics.checkNotNullParameter("yyyy-MM-dd'T'HH:mm:ss", "");
        Intrinsics.checkNotNullParameter(PlaceComponentResult, "");
        String format = DateTimeUtil.PlaceComponentResult("yyyy-MM-dd'T'HH:mm:ss", PlaceComponentResult).format(new Date(time));
        Intrinsics.checkNotNullExpressionValue(format, "");
        this.PlaceComponentResult = new Pair[]{TuplesKt.to("Registration Challenge", this.BuiltInFictitiousFunctionClassFactory), TuplesKt.to(TrackerKey.RegistrationProperties.REGISTRATION_DATE, format), TuplesKt.to("$user_id", p0), TuplesKt.to("Referral Code", p1), TuplesKt.to(TrackerKey.RegistrationProperties.REFERRAL_TYPE, p2), TuplesKt.to(TrackerKey.Property.MEDIA_SOURCE, p3), TuplesKt.to("KYC Level", p4)};
    }

    @Override // id.dana.analytics.tracker.register.RegistrationTracker
    public final void PlaceComponentResult(long p0) {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).getAuthRequestContext("Registration Complete", TrackerDataKey.Property.CONVERSION_TIME, p0);
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).getAuthRequestContext("Registration Challenge", TrackerDataKey.Property.CONVERSION_TIME, p0);
    }

    @Override // id.dana.analytics.tracker.register.RegistrationTracker
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2("Registration Complete", TrackerDataKey.Property.CONVERSION_TIME, System.currentTimeMillis());
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2("Registration Challenge", TrackerDataKey.Property.CONVERSION_TIME, System.currentTimeMillis());
    }

    @Override // id.dana.analytics.tracker.register.RegistrationTracker
    public final void getAuthRequestContext() {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2("Registration Complete", this.PlaceComponentResult);
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2("Registration Challenge", new Pair[]{TuplesKt.to("Registration Challenge", this.BuiltInFictitiousFunctionClassFactory)});
    }
}
