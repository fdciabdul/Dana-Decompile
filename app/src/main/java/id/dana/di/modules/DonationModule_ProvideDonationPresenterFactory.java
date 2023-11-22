package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.donation.DonationContract;
import id.dana.donation.DonationPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DonationModule_ProvideDonationPresenterFactory implements Factory<DonationContract.Presenter> {
    private final Provider<DonationPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final DonationModule MyBillsEntityDataFactory;

    private DonationModule_ProvideDonationPresenterFactory(DonationModule donationModule, Provider<DonationPresenter> provider) {
        this.MyBillsEntityDataFactory = donationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static DonationModule_ProvideDonationPresenterFactory MyBillsEntityDataFactory(DonationModule donationModule, Provider<DonationPresenter> provider) {
        return new DonationModule_ProvideDonationPresenterFactory(donationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DonationContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
