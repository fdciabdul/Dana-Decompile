package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.merchantmanagement.MerchantManagementContract;
import id.dana.merchantmanagement.MerchantManagementPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MerchantManagementModule_ProvidePresenter$app_productionReleaseFactory implements Factory<MerchantManagementContract.Presenter> {
    private final MerchantManagementModule MyBillsEntityDataFactory;
    private final Provider<MerchantManagementPresenter> PlaceComponentResult;

    public static MerchantManagementContract.Presenter PlaceComponentResult(MerchantManagementModule merchantManagementModule, MerchantManagementPresenter merchantManagementPresenter) {
        return (MerchantManagementContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(merchantManagementModule.PlaceComponentResult(merchantManagementPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantManagementContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.PlaceComponentResult.get()));
    }
}
