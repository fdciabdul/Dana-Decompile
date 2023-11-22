package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.sendmoney.ExpiryContract;
import id.dana.contract.sendmoney.ExpiryPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ExpiryModule_ProvideExpiryPresenterFactory implements Factory<ExpiryContract.Presenter> {
    private final Provider<ExpiryPresenter> BuiltInFictitiousFunctionClassFactory;
    private final ExpiryModule KClassImpl$Data$declaredNonStaticMembers$2;

    private ExpiryModule_ProvideExpiryPresenterFactory(ExpiryModule expiryModule, Provider<ExpiryPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = expiryModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ExpiryModule_ProvideExpiryPresenterFactory MyBillsEntityDataFactory(ExpiryModule expiryModule, Provider<ExpiryPresenter> provider) {
        return new ExpiryModule_ProvideExpiryPresenterFactory(expiryModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ExpiryContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
