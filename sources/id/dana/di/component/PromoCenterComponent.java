package id.dana.di.component;

import dagger.Component;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.PromoCenterModule;
import id.dana.promocenter.views.PromoCenterActivity;
import id.dana.promodiscovery.views.PromoDiscoveryListActivity;

@Component(dependencies = {ApplicationComponent.class}, modules = {PromoCenterModule.class, DeepLinkModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface PromoCenterComponent {
    void BuiltInFictitiousFunctionClassFactory(PromoDiscoveryListActivity promoDiscoveryListActivity);

    void KClassImpl$Data$declaredNonStaticMembers$2(PromoCenterActivity promoCenterActivity);
}
