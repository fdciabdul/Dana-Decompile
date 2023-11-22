package id.dana.myprofile.mepagerevamp.securitysettings;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SecuritySettingsModule_ProvidePresenterFactory implements Factory<SecuritySettingsContract.Presenter> {
    private final Provider<SecuritySettingsPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final SecuritySettingsModule getAuthRequestContext;

    private SecuritySettingsModule_ProvidePresenterFactory(SecuritySettingsModule securitySettingsModule, Provider<SecuritySettingsPresenter> provider) {
        this.getAuthRequestContext = securitySettingsModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static SecuritySettingsModule_ProvidePresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(SecuritySettingsModule securitySettingsModule, Provider<SecuritySettingsPresenter> provider) {
        return new SecuritySettingsModule_ProvidePresenterFactory(securitySettingsModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SecuritySettingsContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
