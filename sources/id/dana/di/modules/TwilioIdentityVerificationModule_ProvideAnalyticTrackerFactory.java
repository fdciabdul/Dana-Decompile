package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.twilio.tracker.TwilioAnalyticTracker;
import id.dana.twilio.tracker.TwilioMixpanelTracker;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class TwilioIdentityVerificationModule_ProvideAnalyticTrackerFactory implements Factory<TwilioAnalyticTracker> {
    private final Provider<TwilioMixpanelTracker> KClassImpl$Data$declaredNonStaticMembers$2;
    private final TwilioIdentityVerificationModule getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TwilioAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
