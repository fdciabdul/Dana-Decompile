package id.dana.myprofile.mepagerevamp.securitysettings;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract;

/* loaded from: classes5.dex */
public final class SecuritySettingsModule_ProvideViewFactory implements Factory<SecuritySettingsContract.View> {
    private final SecuritySettingsModule PlaceComponentResult;

    private SecuritySettingsModule_ProvideViewFactory(SecuritySettingsModule securitySettingsModule) {
        this.PlaceComponentResult = securitySettingsModule;
    }

    public static SecuritySettingsModule_ProvideViewFactory PlaceComponentResult(SecuritySettingsModule securitySettingsModule) {
        return new SecuritySettingsModule_ProvideViewFactory(securitySettingsModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SecuritySettingsContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getBuiltInFictitiousFunctionClassFactory());
    }
}
