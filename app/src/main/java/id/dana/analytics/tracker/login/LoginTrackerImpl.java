package id.dana.analytics.tracker.login;

import id.dana.analytics.tracker.AnalyticsTracker;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.analytics.tracker.performanceduration.DanaPerformanceDurationTracker;
import id.dana.analytics.tracker.performanceduration.PerformanceDurationModel;
import id.dana.tracker.constant.TrackerType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u001a¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\tJ\u001d\u0010\u000e\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u000fJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u000b\u0010\u0011J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\r\u0010\u000fJ\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\b\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0005\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0005\u0010\u0011J\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u000b\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u000fJ\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u000fJ\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\tJ/\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\u0019R\u0014\u0010\u000e\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u0012\u0010\u0005\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u001dX\u0080\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001dX\u0000¢\u0006\u0006\n\u0004\b\r\u0010\u001eR\u0016\u0010\b\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001fR\u0016\u0010 \u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001f"}, d2 = {"Lid/dana/analytics/tracker/login/LoginTrackerImpl;", "Lid/dana/analytics/tracker/login/LoginTracker;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "", "PlaceComponentResult", "(Ljava/util/List;)V", "MyBillsEntityDataFactory", "getAuthRequestContext", "()V", "", "(J)V", "lookAheadTest", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "p1", "p2", "p3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "Z", "", "Ljava/util/List;", "J", "moveToNextValue", "<init>", "(Lid/dana/analytics/tracker/AnalyticsTrackerFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LoginTrackerImpl implements LoginTracker {
    private long BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public List<String> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final List<String> PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final AnalyticsTrackerFactory getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private long moveToNextValue;

    @Inject
    public LoginTrackerImpl(AnalyticsTrackerFactory analyticsTrackerFactory) {
        Intrinsics.checkNotNullParameter(analyticsTrackerFactory, "");
        this.getAuthRequestContext = analyticsTrackerFactory;
        this.MyBillsEntityDataFactory = new ArrayList();
        this.PlaceComponentResult = new ArrayList();
    }

    @Override // id.dana.analytics.tracker.login.LoginTracker
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.clear();
        this.MyBillsEntityDataFactory.add(p0);
    }

    @Override // id.dana.analytics.tracker.login.LoginTracker
    public final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (this.MyBillsEntityDataFactory.size() == 1) {
            this.MyBillsEntityDataFactory.add(p0);
            return;
        }
        this.MyBillsEntityDataFactory.remove(1);
        this.MyBillsEntityDataFactory.add(p0);
    }

    @Override // id.dana.analytics.tracker.login.LoginTracker
    public final void PlaceComponentResult(List<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.clear();
        this.PlaceComponentResult.addAll(p0);
    }

    @Override // id.dana.analytics.tracker.login.LoginTracker
    public final void getAuthRequestContext(List<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.addAll(p0);
    }

    @Override // id.dana.analytics.tracker.login.LoginTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
    }

    @Override // id.dana.analytics.tracker.login.LoginTracker
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.BuiltInFictitiousFunctionClassFactory = System.currentTimeMillis();
    }

    @Override // id.dana.analytics.tracker.login.LoginTracker
    public final void getAuthRequestContext() {
        this.moveToNextValue = System.currentTimeMillis();
    }

    @Override // id.dana.analytics.tracker.login.LoginTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        DanaPerformanceDurationTracker.INSTANCE.KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.ViewScreenName.WA_OTP_SCREEN, TrackerDataKey.LoginProperties.WHATSAPP_OTP_ARRIVAL_IN_MILLIS, System.currentTimeMillis());
    }

    @Override // id.dana.analytics.tracker.login.LoginTracker
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        DanaPerformanceDurationTracker.INSTANCE.getAuthRequestContext(TrackerDataKey.ViewScreenName.WA_OTP_SCREEN, TrackerDataKey.LoginProperties.WHATSAPP_OTP_ARRIVAL_IN_MILLIS, System.currentTimeMillis());
    }

    @Override // id.dana.analytics.tracker.login.LoginTracker
    public final void MyBillsEntityDataFactory() {
        DanaPerformanceDurationTracker.INSTANCE.KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.ViewScreenName.SMS_OTP_SCREEN, TrackerDataKey.LoginProperties.SMS_OTP_ARRIVAL_IN_MILLIS, System.currentTimeMillis());
    }

    @Override // id.dana.analytics.tracker.login.LoginTracker
    public final void lookAheadTest() {
        DanaPerformanceDurationTracker.INSTANCE.getAuthRequestContext(TrackerDataKey.ViewScreenName.SMS_OTP_SCREEN, TrackerDataKey.LoginProperties.SMS_OTP_ARRIVAL_IN_MILLIS, System.currentTimeMillis());
    }

    @Override // id.dana.analytics.tracker.login.LoginTracker
    public final void PlaceComponentResult(long p0) {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).getAuthRequestContext("Login", TrackerDataKey.Property.CONVERSION_TIME, p0);
    }

    @Override // id.dana.analytics.tracker.login.LoginTracker
    public final void BuiltInFictitiousFunctionClassFactory(long p0) {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).getAuthRequestContext("Login", TrackerDataKey.LoginProperties.SMS_OTP_FLOW_IN_MILLIS, p0);
    }

    @Override // id.dana.analytics.tracker.login.LoginTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(long p0) {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).getAuthRequestContext("Login", TrackerDataKey.LoginProperties.WHATSAPP_OTP_FLOW_IN_MILLIS, p0);
    }

    @Override // id.dana.analytics.tracker.login.LoginTracker
    public final void PlaceComponentResult() {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2("Login", TrackerDataKey.Property.CONVERSION_TIME, System.currentTimeMillis());
    }

    @Override // id.dana.analytics.tracker.login.LoginTracker
    public final void getErrorConfigVersion() {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2("Login", TrackerDataKey.LoginProperties.SMS_OTP_FLOW_IN_MILLIS, System.currentTimeMillis());
    }

    @Override // id.dana.analytics.tracker.login.LoginTracker
    public final void scheduleImpl() {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2("Login", TrackerDataKey.LoginProperties.WHATSAPP_OTP_FLOW_IN_MILLIS, System.currentTimeMillis());
    }

    @Override // id.dana.analytics.tracker.login.LoginTracker
    public final void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2("Login", new Pair[]{TuplesKt.to("Login Challenge", this.MyBillsEntityDataFactory), TuplesKt.to("Login Type", p0), TuplesKt.to("Is Success", Boolean.FALSE)});
    }

    @Override // id.dana.analytics.tracker.login.LoginTracker
    public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2, String p3) {
        Pair pair;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        AnalyticsTracker KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL);
        Pair[] pairArr = new Pair[10];
        pairArr[0] = TuplesKt.to("Login Challenge", this.MyBillsEntityDataFactory);
        pairArr[1] = TuplesKt.to("$user_id", p0);
        pairArr[2] = TuplesKt.to("Login Type", p1);
        pairArr[3] = TuplesKt.to("Risk Challenge", CollectionsKt.toList(this.PlaceComponentResult));
        pairArr[4] = TuplesKt.to("KYC Level", p2);
        pairArr[5] = TuplesKt.to("Merchant Name", p3);
        pairArr[6] = TuplesKt.to("Is Success", Boolean.TRUE);
        long j = this.moveToNextValue - this.BuiltInFictitiousFunctionClassFactory;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            pair = TuplesKt.to(TrackerKey.LoginProperties.SECOND_CHALLENGE_IN_MILLIS, Long.valueOf(j));
        } else {
            pair = TuplesKt.to(TrackerKey.LoginProperties.FIRST_CHALLENGE_IN_MILLIS, Long.valueOf(j));
        }
        pairArr[7] = pair;
        DanaPerformanceDurationTracker danaPerformanceDurationTracker = DanaPerformanceDurationTracker.INSTANCE;
        Map<String, List<Long>> map = ((PerformanceDurationModel) CollectionsKt.first((List) DanaPerformanceDurationTracker.getAuthRequestContext(TrackerDataKey.ViewScreenName.PHONE_NUMBER_SCREEN))).getAuthRequestContext;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, List<Long>> entry : map.entrySet()) {
            if (Intrinsics.areEqual(entry.getKey(), TrackerDataKey.Property.CHECK_PHONE_NUMBER_LOGIC_IN_MILLIS)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Collection values = linkedHashMap.values();
        long j2 = 0;
        Iterator it = values.iterator();
        while (it.hasNext()) {
            j2 += CollectionsKt.sumOfLong((List) it.next());
        }
        DanaPerformanceDurationTracker danaPerformanceDurationTracker2 = DanaPerformanceDurationTracker.INSTANCE;
        pairArr[8] = TuplesKt.to(TrackerDataKey.Property.NATIVE_PERFORMANCE_DURATION_IN_MILLIS, Long.valueOf(DanaPerformanceDurationTracker.PlaceComponentResult((String[]) Arrays.copyOf(new String[]{TrackerDataKey.ViewScreenName.INPUT_PIN_SCREEN, TrackerDataKey.ViewScreenName.DANA_VIZ_SCREEN, TrackerDataKey.ViewScreenName.WA_OTP_SCREEN, TrackerDataKey.ViewScreenName.SMS_OTP_SCREEN}, 4)) + j2));
        DanaPerformanceDurationTracker danaPerformanceDurationTracker3 = DanaPerformanceDurationTracker.INSTANCE;
        pairArr[9] = TuplesKt.to(TrackerDataKey.Property.NON_NATIVE_PERFORMANCE_DURATION_IN_MILLIS, Long.valueOf(DanaPerformanceDurationTracker.lookAheadTest((String[]) Arrays.copyOf(new String[]{TrackerDataKey.ViewScreenName.INPUT_PIN_SCREEN, TrackerDataKey.ViewScreenName.DANA_VIZ_SCREEN, TrackerDataKey.ViewScreenName.WA_OTP_SCREEN, TrackerDataKey.ViewScreenName.SMS_OTP_SCREEN}, 4))));
        DanaPerformanceDurationTracker danaPerformanceDurationTracker4 = DanaPerformanceDurationTracker.INSTANCE;
        String[] strArr = (String[]) Arrays.copyOf(new String[]{TrackerDataKey.ViewScreenName.INTRODUCTION_SCREEN, TrackerDataKey.ViewScreenName.PHONE_NUMBER_SCREEN, TrackerDataKey.ViewScreenName.PERMISSION_LOCATION_SCREEN, TrackerDataKey.ViewScreenName.INPUT_PIN_SCREEN, TrackerDataKey.ViewScreenName.DANA_VIZ_SCREEN, TrackerDataKey.ViewScreenName.WA_OTP_SCREEN, TrackerDataKey.ViewScreenName.SMS_OTP_SCREEN}, 7);
        Intrinsics.checkNotNullParameter(strArr, "");
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2("Login", (Pair[]) ArraysKt.plus((Object[]) pairArr, (Object[]) ((Pair[]) ArraysKt.plus((Object[]) DanaPerformanceDurationTracker.BuiltInFictitiousFunctionClassFactory((String[]) Arrays.copyOf(strArr, strArr.length)), (Object[]) DanaPerformanceDurationTracker.KClassImpl$Data$declaredNonStaticMembers$2((String[]) Arrays.copyOf(strArr, strArr.length))))));
    }
}
