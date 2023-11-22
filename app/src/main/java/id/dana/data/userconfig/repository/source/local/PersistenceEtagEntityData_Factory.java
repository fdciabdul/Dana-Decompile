package id.dana.data.userconfig.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PersistenceEtagEntityData_Factory implements Factory<PersistenceEtagEntityData> {
    private final Provider<UserConfigPreference> userConfigPreferenceProvider;

    public PersistenceEtagEntityData_Factory(Provider<UserConfigPreference> provider) {
        this.userConfigPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PersistenceEtagEntityData get() {
        return newInstance(this.userConfigPreferenceProvider.get());
    }

    public static PersistenceEtagEntityData_Factory create(Provider<UserConfigPreference> provider) {
        return new PersistenceEtagEntityData_Factory(provider);
    }

    public static PersistenceEtagEntityData newInstance(UserConfigPreference userConfigPreference) {
        return new PersistenceEtagEntityData(userConfigPreference);
    }
}
