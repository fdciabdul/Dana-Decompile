package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onboarding.referral.ReferralDialogContract;

/* loaded from: classes4.dex */
public final class ReferralDialogModule_ProvideViewFactory implements Factory<ReferralDialogContract.View> {
    private final ReferralDialogModule PlaceComponentResult;

    private ReferralDialogModule_ProvideViewFactory(ReferralDialogModule referralDialogModule) {
        this.PlaceComponentResult = referralDialogModule;
    }

    public static ReferralDialogModule_ProvideViewFactory MyBillsEntityDataFactory(ReferralDialogModule referralDialogModule) {
        return new ReferralDialogModule_ProvideViewFactory(referralDialogModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ReferralDialogContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getPlaceComponentResult());
    }
}
