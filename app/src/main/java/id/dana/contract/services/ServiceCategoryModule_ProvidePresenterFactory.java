package id.dana.contract.services;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.services.ServiceCategoryContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ServiceCategoryModule_ProvidePresenterFactory implements Factory<ServiceCategoryContract.Presenter> {
    private final ServiceCategoryModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<ServiceCategoryPresenter> getAuthRequestContext;

    private ServiceCategoryModule_ProvidePresenterFactory(ServiceCategoryModule serviceCategoryModule, Provider<ServiceCategoryPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = serviceCategoryModule;
        this.getAuthRequestContext = provider;
    }

    public static ServiceCategoryModule_ProvidePresenterFactory PlaceComponentResult(ServiceCategoryModule serviceCategoryModule, Provider<ServiceCategoryPresenter> provider) {
        return new ServiceCategoryModule_ProvidePresenterFactory(serviceCategoryModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ServiceCategoryContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}
