package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.MerchantModule;
import id.dana.nearbyme.summary.MerchantListView;

@Component(dependencies = {ApplicationComponent.class}, modules = {MerchantModule.class})
@PerActivity
/* loaded from: classes8.dex */
public interface MerchantComponent {
    void KClassImpl$Data$declaredNonStaticMembers$2(MerchantListView merchantListView);
}
