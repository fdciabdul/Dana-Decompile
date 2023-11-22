package id.dana.myprofile.mepagerevamp.profilesettings;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ProfileSettingsModule_ProvidePresenterFactory implements Factory<ProfileSettingsContract.Presenter> {
    private final Provider<ProfileSettingsPresenter> BuiltInFictitiousFunctionClassFactory;
    private final ProfileSettingsModule PlaceComponentResult;

    private ProfileSettingsModule_ProvidePresenterFactory(ProfileSettingsModule profileSettingsModule, Provider<ProfileSettingsPresenter> provider) {
        this.PlaceComponentResult = profileSettingsModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ProfileSettingsModule_ProvidePresenterFactory BuiltInFictitiousFunctionClassFactory(ProfileSettingsModule profileSettingsModule, Provider<ProfileSettingsPresenter> provider) {
        return new ProfileSettingsModule_ProvidePresenterFactory(profileSettingsModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ProfileSettingsContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
