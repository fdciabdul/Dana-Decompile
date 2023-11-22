package id.dana.donation;

import dagger.internal.Factory;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.donation.interactor.GetDonationCampaigns;
import id.dana.domain.featureconfig.interactor.GetDonationCampaignConfig;
import id.dana.donation.DonationContract;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DonationPresenter_Factory implements Factory<DonationPresenter> {
    private final Provider<DonationContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetAuthCode> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetDonationCampaignConfig> MyBillsEntityDataFactory;
    private final Provider<GetDonationCampaigns> PlaceComponentResult;

    private DonationPresenter_Factory(Provider<DonationContract.View> provider, Provider<GetDonationCampaigns> provider2, Provider<GetAuthCode> provider3, Provider<GetDonationCampaignConfig> provider4) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.MyBillsEntityDataFactory = provider4;
    }

    public static DonationPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<DonationContract.View> provider, Provider<GetDonationCampaigns> provider2, Provider<GetAuthCode> provider3, Provider<GetDonationCampaignConfig> provider4) {
        return new DonationPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DonationPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
