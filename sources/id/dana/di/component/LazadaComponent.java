package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.LazadaModule;
import id.dana.lazada.LazadaGuideActivity;

@Component(dependencies = {ApplicationComponent.class}, modules = {LazadaModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface LazadaComponent {
    void KClassImpl$Data$declaredNonStaticMembers$2(LazadaGuideActivity lazadaGuideActivity);
}
