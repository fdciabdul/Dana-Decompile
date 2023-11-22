package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoContract;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MerchantInfoModule_ProvideMerchantInfoPresenterFactory implements Factory<MerchantInfoContract.Presenter> {
    private final MerchantInfoModule PlaceComponentResult;
    private final Provider<MerchantInfoPresenter> getAuthRequestContext;

    public static MerchantInfoContract.Presenter MyBillsEntityDataFactory(MerchantInfoModule merchantInfoModule, MerchantInfoPresenter merchantInfoPresenter) {
        return (MerchantInfoContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(merchantInfoModule.MyBillsEntityDataFactory(merchantInfoPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantInfoContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.MyBillsEntityDataFactory(this.getAuthRequestContext.get()));
    }
}
