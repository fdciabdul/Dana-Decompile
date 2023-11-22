package id.dana.contract.services;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.services.ServicesContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ServicesModule_ProvidePresenterFactory implements Factory<ServicesContract.Presenter> {
    private final ServicesModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ServicesPresenter> MyBillsEntityDataFactory;

    private ServicesModule_ProvidePresenterFactory(ServicesModule servicesModule, Provider<ServicesPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = servicesModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ServicesModule_ProvidePresenterFactory BuiltInFictitiousFunctionClassFactory(ServicesModule servicesModule, Provider<ServicesPresenter> provider) {
        return new ServicesModule_ProvidePresenterFactory(servicesModule, provider);
    }

    public static ServicesContract.Presenter getAuthRequestContext(ServicesModule servicesModule, ServicesPresenter servicesPresenter) {
        return (ServicesContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(servicesModule.MyBillsEntityDataFactory(servicesPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ServicesContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.get()));
    }
}
