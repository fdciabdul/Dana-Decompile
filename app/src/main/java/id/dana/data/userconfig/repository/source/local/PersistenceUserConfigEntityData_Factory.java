package id.dana.data.userconfig.repository.source.local;

import dagger.internal.Factory;
import id.dana.data.userconfig.mapper.UserConfigQueryResultMapper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PersistenceUserConfigEntityData_Factory implements Factory<PersistenceUserConfigEntityData> {
    private final Provider<UserConfigPreference> userConfigPreferenceProvider;
    private final Provider<UserConfigQueryResultMapper> userConfigQueryResultMapperProvider;

    public PersistenceUserConfigEntityData_Factory(Provider<UserConfigPreference> provider, Provider<UserConfigQueryResultMapper> provider2) {
        this.userConfigPreferenceProvider = provider;
        this.userConfigQueryResultMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final PersistenceUserConfigEntityData get() {
        return newInstance(this.userConfigPreferenceProvider.get(), this.userConfigQueryResultMapperProvider.get());
    }

    public static PersistenceUserConfigEntityData_Factory create(Provider<UserConfigPreference> provider, Provider<UserConfigQueryResultMapper> provider2) {
        return new PersistenceUserConfigEntityData_Factory(provider, provider2);
    }

    public static PersistenceUserConfigEntityData newInstance(UserConfigPreference userConfigPreference, UserConfigQueryResultMapper userConfigQueryResultMapper) {
        return new PersistenceUserConfigEntityData(userConfigPreference, userConfigQueryResultMapper);
    }
}
