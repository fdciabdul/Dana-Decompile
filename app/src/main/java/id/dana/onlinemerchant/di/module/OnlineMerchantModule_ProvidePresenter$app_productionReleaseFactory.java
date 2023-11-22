package id.dana.onlinemerchant.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.onlinemerchant.OnlineMerchantContract;
import id.dana.contract.onlinemerchant.OnlineMerchantPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class OnlineMerchantModule_ProvidePresenter$app_productionReleaseFactory implements Factory<OnlineMerchantContract.Presenter> {
    private final Provider<OnlineMerchantPresenter> BuiltInFictitiousFunctionClassFactory;
    private final OnlineMerchantModule MyBillsEntityDataFactory;

    public static OnlineMerchantContract.Presenter MyBillsEntityDataFactory(OnlineMerchantModule onlineMerchantModule, OnlineMerchantPresenter onlineMerchantPresenter) {
        return (OnlineMerchantContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(onlineMerchantModule.KClassImpl$Data$declaredNonStaticMembers$2(onlineMerchantPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OnlineMerchantContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
