package id.dana.di.component;

import dagger.Component;
import id.dana.contract.services.ServiceCategoryModule;
import id.dana.di.PerActivity;
import id.dana.richview.servicescard.ServiceCategoryView;

@Component(dependencies = {ApplicationComponent.class}, modules = {ServiceCategoryModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface ServiceCategoryComponent {
    void MyBillsEntityDataFactory(ServiceCategoryView serviceCategoryView);
}
