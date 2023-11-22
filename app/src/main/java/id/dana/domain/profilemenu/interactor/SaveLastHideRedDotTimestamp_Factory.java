package id.dana.domain.profilemenu.interactor;

import dagger.internal.Factory;
import id.dana.domain.profilemenu.SettingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveLastHideRedDotTimestamp_Factory implements Factory<SaveLastHideRedDotTimestamp> {
    private final Provider<SettingRepository> settingRepositoryProvider;

    public SaveLastHideRedDotTimestamp_Factory(Provider<SettingRepository> provider) {
        this.settingRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveLastHideRedDotTimestamp get() {
        return newInstance(this.settingRepositoryProvider.get());
    }

    public static SaveLastHideRedDotTimestamp_Factory create(Provider<SettingRepository> provider) {
        return new SaveLastHideRedDotTimestamp_Factory(provider);
    }

    public static SaveLastHideRedDotTimestamp newInstance(SettingRepository settingRepository) {
        return new SaveLastHideRedDotTimestamp(settingRepository);
    }
}
