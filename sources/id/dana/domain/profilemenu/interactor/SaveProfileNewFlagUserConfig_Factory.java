package id.dana.domain.profilemenu.interactor;

import dagger.internal.Factory;
import id.dana.domain.profilemenu.SettingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveProfileNewFlagUserConfig_Factory implements Factory<SaveProfileNewFlagUserConfig> {
    private final Provider<SettingRepository> settingRepositoryProvider;

    public SaveProfileNewFlagUserConfig_Factory(Provider<SettingRepository> provider) {
        this.settingRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveProfileNewFlagUserConfig get() {
        return newInstance(this.settingRepositoryProvider.get());
    }

    public static SaveProfileNewFlagUserConfig_Factory create(Provider<SettingRepository> provider) {
        return new SaveProfileNewFlagUserConfig_Factory(provider);
    }

    public static SaveProfileNewFlagUserConfig newInstance(SettingRepository settingRepository) {
        return new SaveProfileNewFlagUserConfig(settingRepository);
    }
}
