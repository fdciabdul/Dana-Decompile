package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MerchantDanaDealsModule_ProvideMerchantDealsPresenterFactory implements Factory<MerchantDanaDealsContract.Presenter> {
    private final MerchantDanaDealsModule MyBillsEntityDataFactory;
    private final Provider<MerchantDanaDealsPresenter> PlaceComponentResult;

    public static MerchantDanaDealsContract.Presenter BuiltInFictitiousFunctionClassFactory(MerchantDanaDealsModule merchantDanaDealsModule, MerchantDanaDealsPresenter merchantDanaDealsPresenter) {
        return (MerchantDanaDealsContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(merchantDanaDealsModule.PlaceComponentResult(merchantDanaDealsPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantDanaDealsContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.PlaceComponentResult.get()));
    }
}
