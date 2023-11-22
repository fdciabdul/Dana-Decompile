package id.dana.contract.services;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.services.ServiceCategoryContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class ServiceCategoryModule {
    private final ServiceCategoryContract.View getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public ServiceCategoryContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(ServiceCategoryPresenter serviceCategoryPresenter) {
        return serviceCategoryPresenter;
    }

    public ServiceCategoryModule(ServiceCategoryContract.View view) {
        this.getAuthRequestContext = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public ServiceCategoryContract.View getAuthRequestContext() {
        return this.getAuthRequestContext;
    }
}
