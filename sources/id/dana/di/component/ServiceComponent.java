package id.dana.di.component;

import dagger.Component;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.paylater.PayLaterModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.service.ServicesActivity;

@Component(dependencies = {ApplicationComponent.class}, modules = {PlayStoreReviewModules.class, CheckoutH5EventModule.class, BottomSheetOnBoardingModule.class, DeepLinkModule.class, PayLaterModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface ServiceComponent {
    void PlaceComponentResult(ServicesActivity servicesActivity);
}
