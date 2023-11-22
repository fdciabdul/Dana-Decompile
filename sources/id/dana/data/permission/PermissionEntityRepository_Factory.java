package id.dana.data.permission;

import dagger.internal.Factory;
import id.dana.data.storage.GeneralPreferencesDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PermissionEntityRepository_Factory implements Factory<PermissionEntityRepository> {
    private final Provider<GeneralPreferencesDataFactory> generalPreferencesDataFactoryProvider;

    public PermissionEntityRepository_Factory(Provider<GeneralPreferencesDataFactory> provider) {
        this.generalPreferencesDataFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PermissionEntityRepository get() {
        return newInstance(this.generalPreferencesDataFactoryProvider.get());
    }

    public static PermissionEntityRepository_Factory create(Provider<GeneralPreferencesDataFactory> provider) {
        return new PermissionEntityRepository_Factory(provider);
    }

    public static PermissionEntityRepository newInstance(GeneralPreferencesDataFactory generalPreferencesDataFactory) {
        return new PermissionEntityRepository(generalPreferencesDataFactory);
    }
}
