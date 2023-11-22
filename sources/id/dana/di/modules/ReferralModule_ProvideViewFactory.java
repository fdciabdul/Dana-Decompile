package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onboarding.referral.ReferralContract;

/* loaded from: classes4.dex */
public final class ReferralModule_ProvideViewFactory implements Factory<ReferralContract.View> {
    private final ReferralModule KClassImpl$Data$declaredNonStaticMembers$2;

    private ReferralModule_ProvideViewFactory(ReferralModule referralModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = referralModule;
    }

    public static ReferralModule_ProvideViewFactory getAuthRequestContext(ReferralModule referralModule) {
        return new ReferralModule_ProvideViewFactory(referralModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ReferralContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory());
    }
}
