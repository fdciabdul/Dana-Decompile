package id.dana.analytics.tracker.riskchallenges;

import id.dana.analytics.tracker.TrackerKey;
import id.dana.analytics.tracker.riskchallenges.model.RiskChallengeTrackerModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H'¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u000fJ\u001b\u0010\u0007\u001a\u00020\r2\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0007\u0010\u0012J\u0017\u0010\n\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\f\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0014H&¢\u0006\u0004\b\u0005\u0010\u0015J\u0017\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0016H&¢\u0006\u0004\b\f\u0010\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/analytics/tracker/riskchallenges/RiskChallengeTracker;", "", "", "MyBillsEntityDataFactory", "()I", "KClassImpl$Data$declaredNonStaticMembers$2", "", "getAuthRequestContext", "()Ljava/lang/String;", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/Throwable;", "PlaceComponentResult", "", "lookAheadTest", "()V", "scheduleImpl", "p0", "(Ljava/lang/String;)V", "(Ljava/lang/Throwable;)V", "Lid/dana/analytics/tracker/riskchallenges/model/RiskChallengeTrackerModel$RiskChallengeCompleteModel;", "(Lid/dana/analytics/tracker/riskchallenges/model/RiskChallengeTrackerModel$RiskChallengeCompleteModel;)V", "Lid/dana/analytics/tracker/riskchallenges/model/RiskChallengeTrackerModel$RiskChallengeOpenModel;", "(Lid/dana/analytics/tracker/riskchallenges/model/RiskChallengeTrackerModel$RiskChallengeOpenModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface RiskChallengeTracker {
    Throwable BuiltInFictitiousFunctionClassFactory();

    void BuiltInFictitiousFunctionClassFactory(Throwable p0);

    int KClassImpl$Data$declaredNonStaticMembers$2();

    void KClassImpl$Data$declaredNonStaticMembers$2(RiskChallengeTrackerModel.RiskChallengeCompleteModel p0);

    int MyBillsEntityDataFactory();

    @TrackerKey.RiskChallenge.Source
    String PlaceComponentResult();

    void PlaceComponentResult(RiskChallengeTrackerModel.RiskChallengeOpenModel p0);

    void PlaceComponentResult(@TrackerKey.RiskChallenge.Source String p0);

    @TrackerKey.RiskChallenge.Type
    String getAuthRequestContext();

    void getAuthRequestContext(@TrackerKey.RiskChallenge.Type String p0);

    void lookAheadTest();

    void scheduleImpl();
}
