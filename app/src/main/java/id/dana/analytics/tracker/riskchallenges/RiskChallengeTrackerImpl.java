package id.dana.analytics.tracker.riskchallenges;

import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.analytics.tracker.riskchallenges.model.RiskChallengeTrackerModel;
import id.dana.tracker.constant.TrackerType;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0019\u0010\u0007\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\u0012J\u0017\u0010\n\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u0013J\u0019\u0010\f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\f\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0005\u0010\u0015J\u0017\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\f\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0019R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001c"}, d2 = {"Lid/dana/analytics/tracker/riskchallenges/RiskChallengeTrackerImpl;", "Lid/dana/analytics/tracker/riskchallenges/RiskChallengeTracker;", "", "MyBillsEntityDataFactory", "()I", "KClassImpl$Data$declaredNonStaticMembers$2", "", "getAuthRequestContext", "()Ljava/lang/String;", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/Throwable;", "PlaceComponentResult", "", "lookAheadTest", "()V", "scheduleImpl", "p0", "(Ljava/lang/String;)V", "(Ljava/lang/Throwable;)V", "Lid/dana/analytics/tracker/riskchallenges/model/RiskChallengeTrackerModel$RiskChallengeCompleteModel;", "(Lid/dana/analytics/tracker/riskchallenges/model/RiskChallengeTrackerModel$RiskChallengeCompleteModel;)V", "Lid/dana/analytics/tracker/riskchallenges/model/RiskChallengeTrackerModel$RiskChallengeOpenModel;", "(Lid/dana/analytics/tracker/riskchallenges/model/RiskChallengeTrackerModel$RiskChallengeOpenModel;)V", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "I", "Ljava/lang/String;", "Ljava/lang/Throwable;", "<init>", "(Lid/dana/analytics/tracker/AnalyticsTrackerFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RiskChallengeTrackerImpl implements RiskChallengeTracker {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final AnalyticsTrackerFactory getAuthRequestContext;
    private String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private Throwable lookAheadTest;

    @Inject
    public RiskChallengeTrackerImpl(AnalyticsTrackerFactory analyticsTrackerFactory) {
        Intrinsics.checkNotNullParameter(analyticsTrackerFactory, "");
        this.getAuthRequestContext = analyticsTrackerFactory;
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    public final void PlaceComponentResult(String p0) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    public final void getAuthRequestContext(String p0) {
        this.PlaceComponentResult = p0;
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    public final String PlaceComponentResult() {
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Please setSource first");
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    public final String getAuthRequestContext() {
        String str = this.PlaceComponentResult;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Please setChallengeType first");
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final int getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final int getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    public final void lookAheadTest() {
        this.BuiltInFictitiousFunctionClassFactory++;
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    public final void scheduleImpl() {
        this.MyBillsEntityDataFactory++;
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    public final void BuiltInFictitiousFunctionClassFactory(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.lookAheadTest = p0;
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final Throwable getLookAheadTest() {
        return this.lookAheadTest;
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(RiskChallengeTrackerModel.RiskChallengeCompleteModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Pair<String, Object>[] pairArr = {TuplesKt.to("Source", p0.NetworkUserEntityData$$ExternalSyntheticLambda0), TuplesKt.to(TrackerKey.Property.CHALLENGE_TYPE, p0.MyBillsEntityDataFactory), TuplesKt.to("Success", String.valueOf(p0.getScheduleImpl())), TuplesKt.to(TrackerKey.Property.USER_CANCEL, String.valueOf(p0.getLookAheadTest())), TuplesKt.to(TrackerKey.Property.ATTEMPT_REQUEST, Integer.valueOf(p0.PlaceComponentResult)), TuplesKt.to(TrackerKey.Property.ATTEMPT_VERIFY, Integer.valueOf(p0.BuiltInFictitiousFunctionClassFactory))};
        String str = p0.getAuthRequestContext;
        if (!(str == null || str.length() == 0)) {
            pairArr = (Pair[]) ArraysKt.plus((Object[]) pairArr, (Object[]) new Pair[]{TuplesKt.to("Error Code", p0.getAuthRequestContext)});
        }
        String str2 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
        if (!(str2 == null || str2.length() == 0)) {
            pairArr = (Pair[]) ArraysKt.plus((Object[]) pairArr, (Object[]) new Pair[]{TuplesKt.to("Error Message", p0.KClassImpl$Data$declaredNonStaticMembers$2)});
        }
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.RISK_CHALLENGE_COMPLETE, pairArr);
    }

    @Override // id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker
    public final void PlaceComponentResult(RiskChallengeTrackerModel.RiskChallengeOpenModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Pair<String, Object>[] pairArr = {TuplesKt.to("Source", p0.MyBillsEntityDataFactory), TuplesKt.to(TrackerKey.Property.CHALLENGE_TYPE, p0.PlaceComponentResult), TuplesKt.to("Fallback", p0.KClassImpl$Data$declaredNonStaticMembers$2), TuplesKt.to("Success", String.valueOf(p0.getLookAheadTest()))};
        String str = p0.BuiltInFictitiousFunctionClassFactory;
        if (!(str == null || str.length() == 0)) {
            pairArr = (Pair[]) ArraysKt.plus((Object[]) pairArr, (Object[]) new Pair[]{TuplesKt.to("Error Code", p0.BuiltInFictitiousFunctionClassFactory)});
        }
        String str2 = p0.getAuthRequestContext;
        if (!(str2 == null || str2.length() == 0)) {
            pairArr = (Pair[]) ArraysKt.plus((Object[]) pairArr, (Object[]) new Pair[]{TuplesKt.to("Error Message", p0.getAuthRequestContext)});
        }
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.RISK_CHALLENGE_OPEN, pairArr);
    }
}
