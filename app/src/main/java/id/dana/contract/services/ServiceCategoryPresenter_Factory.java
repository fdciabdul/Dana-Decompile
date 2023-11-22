package id.dana.contract.services;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.contract.services.ServiceCategoryContract;
import id.dana.domain.services.interactor.GetCategory;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ServiceCategoryPresenter_Factory implements Factory<ServiceCategoryPresenter> {
    private final Provider<ServiceCategoryContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ServiceCategoryMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<GetCategory> PlaceComponentResult;

    private ServiceCategoryPresenter_Factory(Provider<ServiceCategoryContract.View> provider, Provider<GetCategory> provider2, Provider<ServiceCategoryMapper> provider3, Provider<Context> provider4) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.MyBillsEntityDataFactory = provider4;
    }

    public static ServiceCategoryPresenter_Factory getAuthRequestContext(Provider<ServiceCategoryContract.View> provider, Provider<GetCategory> provider2, Provider<ServiceCategoryMapper> provider3, Provider<Context> provider4) {
        return new ServiceCategoryPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ServiceCategoryPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
