package id.dana.contract.account;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.account.FirstTimeContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FirstTimeModule_ProvidePresenterFactory implements Factory<FirstTimeContract.Presenter> {
    private final FirstTimeModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<FirstTimePresenter> KClassImpl$Data$declaredNonStaticMembers$2;

    private FirstTimeModule_ProvidePresenterFactory(FirstTimeModule firstTimeModule, Provider<FirstTimePresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = firstTimeModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static FirstTimeModule_ProvidePresenterFactory getAuthRequestContext(FirstTimeModule firstTimeModule, Provider<FirstTimePresenter> provider) {
        return new FirstTimeModule_ProvidePresenterFactory(firstTimeModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FirstTimeContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
