package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MerchantAverageRatingModule_ProvideMerchantAverageRatingPresenterFactory implements Factory<MerchantAverageRatingContract.Presenter> {
    private final MerchantAverageRatingModule MyBillsEntityDataFactory;
    private final Provider<MerchantAverageRatingPresenter> PlaceComponentResult;

    private MerchantAverageRatingModule_ProvideMerchantAverageRatingPresenterFactory(MerchantAverageRatingModule merchantAverageRatingModule, Provider<MerchantAverageRatingPresenter> provider) {
        this.MyBillsEntityDataFactory = merchantAverageRatingModule;
        this.PlaceComponentResult = provider;
    }

    public static MerchantAverageRatingModule_ProvideMerchantAverageRatingPresenterFactory BuiltInFictitiousFunctionClassFactory(MerchantAverageRatingModule merchantAverageRatingModule, Provider<MerchantAverageRatingPresenter> provider) {
        return new MerchantAverageRatingModule_ProvideMerchantAverageRatingPresenterFactory(merchantAverageRatingModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantAverageRatingContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.PlaceComponentResult.get()));
    }
}
