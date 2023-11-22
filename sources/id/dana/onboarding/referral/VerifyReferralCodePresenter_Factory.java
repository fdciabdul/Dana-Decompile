package id.dana.onboarding.referral;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.interactor.GetPersonalizedReferralConfig;
import id.dana.domain.geocode.interactor.GetIndoSubdivisionsByLocation;
import id.dana.domain.referral.interactor.VerifyReferralCode;
import id.dana.onboarding.referral.ReferralContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class VerifyReferralCodePresenter_Factory implements Factory<VerifyReferralCodePresenter> {
    private final Provider<GetPersonalizedReferralConfig> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ReferralContract.View> MyBillsEntityDataFactory;
    private final Provider<VerifyReferralCode> PlaceComponentResult;
    private final Provider<GetIndoSubdivisionsByLocation> getAuthRequestContext;

    private VerifyReferralCodePresenter_Factory(Provider<ReferralContract.View> provider, Provider<VerifyReferralCode> provider2, Provider<GetIndoSubdivisionsByLocation> provider3, Provider<GetPersonalizedReferralConfig> provider4) {
        this.MyBillsEntityDataFactory = provider;
        this.PlaceComponentResult = provider2;
        this.getAuthRequestContext = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
    }

    public static VerifyReferralCodePresenter_Factory getAuthRequestContext(Provider<ReferralContract.View> provider, Provider<VerifyReferralCode> provider2, Provider<GetIndoSubdivisionsByLocation> provider3, Provider<GetPersonalizedReferralConfig> provider4) {
        return new VerifyReferralCodePresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new VerifyReferralCodePresenter(this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
