package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.donation.DonationContract;

/* loaded from: classes8.dex */
public final class DonationModule_ProvideDonationViewFactory implements Factory<DonationContract.View> {
    private final DonationModule BuiltInFictitiousFunctionClassFactory;

    private DonationModule_ProvideDonationViewFactory(DonationModule donationModule) {
        this.BuiltInFictitiousFunctionClassFactory = donationModule;
    }

    public static DonationModule_ProvideDonationViewFactory MyBillsEntityDataFactory(DonationModule donationModule) {
        return new DonationModule_ProvideDonationViewFactory(donationModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DonationContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
