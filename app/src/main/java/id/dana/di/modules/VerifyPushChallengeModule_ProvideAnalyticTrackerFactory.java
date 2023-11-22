package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.twilio.tracker.TwilioAnalyticTracker;
import id.dana.twilio.tracker.TwilioMixpanelTracker;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class VerifyPushChallengeModule_ProvideAnalyticTrackerFactory implements Factory<TwilioAnalyticTracker> {
    private final VerifyPushChallengeModule MyBillsEntityDataFactory;
    private final Provider<TwilioMixpanelTracker> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TwilioAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
