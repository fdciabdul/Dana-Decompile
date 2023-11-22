package id.dana.contract.services;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.services.ServiceCategoryContract;

/* loaded from: classes4.dex */
public final class ServiceCategoryModule_ProvideViewFactory implements Factory<ServiceCategoryContract.View> {
    private final ServiceCategoryModule MyBillsEntityDataFactory;

    private ServiceCategoryModule_ProvideViewFactory(ServiceCategoryModule serviceCategoryModule) {
        this.MyBillsEntityDataFactory = serviceCategoryModule;
    }

    public static ServiceCategoryModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(ServiceCategoryModule serviceCategoryModule) {
        return new ServiceCategoryModule_ProvideViewFactory(serviceCategoryModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ServiceCategoryContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext());
    }
}
