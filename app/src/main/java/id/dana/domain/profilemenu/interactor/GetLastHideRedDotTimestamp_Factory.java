package id.dana.domain.profilemenu.interactor;

import dagger.internal.Factory;
import id.dana.domain.profilemenu.SettingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetLastHideRedDotTimestamp_Factory implements Factory<GetLastHideRedDotTimestamp> {
    private final Provider<SettingRepository> settingRepositoryProvider;

    public GetLastHideRedDotTimestamp_Factory(Provider<SettingRepository> provider) {
        this.settingRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetLastHideRedDotTimestamp get() {
        return newInstance(this.settingRepositoryProvider.get());
    }

    public static GetLastHideRedDotTimestamp_Factory create(Provider<SettingRepository> provider) {
        return new GetLastHideRedDotTimestamp_Factory(provider);
    }

    public static GetLastHideRedDotTimestamp newInstance(SettingRepository settingRepository) {
        return new GetLastHideRedDotTimestamp(settingRepository);
    }
}
