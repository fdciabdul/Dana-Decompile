package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.MerchantContract;
import id.dana.nearbyme.MerchantPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MerchantModule_ProvidePresenterFactory implements Factory<MerchantContract.Presenter> {
    private final MerchantModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<MerchantPresenter> MyBillsEntityDataFactory;

    public static MerchantContract.Presenter getAuthRequestContext(MerchantModule merchantModule, MerchantPresenter merchantPresenter) {
        return (MerchantContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(merchantModule.BuiltInFictitiousFunctionClassFactory(merchantPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get()));
    }
}
