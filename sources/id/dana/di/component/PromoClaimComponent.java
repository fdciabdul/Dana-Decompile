package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.PromoClaimModule;
import id.dana.richview.promoclaim.PromoClaimView;

@Component(dependencies = {ApplicationComponent.class}, modules = {PromoClaimModule.class})
@PerActivity
/* loaded from: classes8.dex */
public interface PromoClaimComponent {
    void MyBillsEntityDataFactory(PromoClaimView promoClaimView);
}
