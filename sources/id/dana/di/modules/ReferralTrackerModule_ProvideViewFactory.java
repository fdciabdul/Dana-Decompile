package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.referraltracker.ReferralTrackerContract;

/* loaded from: classes4.dex */
public final class ReferralTrackerModule_ProvideViewFactory implements Factory<ReferralTrackerContract.View> {
    private final ReferralTrackerModule getAuthRequestContext;

    private ReferralTrackerModule_ProvideViewFactory(ReferralTrackerModule referralTrackerModule) {
        this.getAuthRequestContext = referralTrackerModule;
    }

    public static ReferralTrackerModule_ProvideViewFactory MyBillsEntityDataFactory(ReferralTrackerModule referralTrackerModule) {
        return new ReferralTrackerModule_ProvideViewFactory(referralTrackerModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ReferralTrackerContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory());
    }
}
