package id.dana.domain.profilemenu.interactor;

import dagger.internal.Factory;
import id.dana.domain.profilemenu.SettingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUserConfigProfileNewFlag_Factory implements Factory<GetUserConfigProfileNewFlag> {
    private final Provider<SettingRepository> settingRepositoryProvider;

    public GetUserConfigProfileNewFlag_Factory(Provider<SettingRepository> provider) {
        this.settingRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetUserConfigProfileNewFlag get() {
        return newInstance(this.settingRepositoryProvider.get());
    }

    public static GetUserConfigProfileNewFlag_Factory create(Provider<SettingRepository> provider) {
        return new GetUserConfigProfileNewFlag_Factory(provider);
    }

    public static GetUserConfigProfileNewFlag newInstance(SettingRepository settingRepository) {
        return new GetUserConfigProfileNewFlag(settingRepository);
    }
}
