package id.dana.myprofile.mepagerevamp.profilesettings;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract;

/* loaded from: classes5.dex */
public final class ProfileSettingsModule_ProvideViewFactory implements Factory<ProfileSettingsContract.View> {
    private final ProfileSettingsModule PlaceComponentResult;

    private ProfileSettingsModule_ProvideViewFactory(ProfileSettingsModule profileSettingsModule) {
        this.PlaceComponentResult = profileSettingsModule;
    }

    public static ProfileSettingsModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(ProfileSettingsModule profileSettingsModule) {
        return new ProfileSettingsModule_ProvideViewFactory(profileSettingsModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ProfileSettingsContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getGetAuthRequestContext());
    }
}
