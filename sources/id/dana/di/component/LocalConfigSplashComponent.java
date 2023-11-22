package id.dana.di.component;

import dagger.Component;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.LocalConfigSplashModule;
import id.dana.di.modules.LogoutModule;
import id.dana.onboarding.splash.LocalConfigSplashActivity;

@Component(dependencies = {ApplicationComponent.class}, modules = {LocalConfigSplashModule.class, DeepLinkModule.class, LogoutModule.class})
@PerActivity
/* loaded from: classes2.dex */
public interface LocalConfigSplashComponent {
    void KClassImpl$Data$declaredNonStaticMembers$2(LocalConfigSplashActivity localConfigSplashActivity);
}
