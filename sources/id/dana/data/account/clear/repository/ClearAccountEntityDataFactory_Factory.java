package id.dana.data.account.clear.repository;

import dagger.internal.Factory;
import id.dana.data.account.clear.repository.source.preference.PreferenceClearAccountEntityData;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ClearAccountEntityDataFactory_Factory implements Factory<ClearAccountEntityDataFactory> {
    private final Provider<PreferenceClearAccountEntityData> preferenceClearAccountEntityDataProvider;

    public ClearAccountEntityDataFactory_Factory(Provider<PreferenceClearAccountEntityData> provider) {
        this.preferenceClearAccountEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ClearAccountEntityDataFactory get() {
        return newInstance(this.preferenceClearAccountEntityDataProvider.get());
    }

    public static ClearAccountEntityDataFactory_Factory create(Provider<PreferenceClearAccountEntityData> provider) {
        return new ClearAccountEntityDataFactory_Factory(provider);
    }

    public static ClearAccountEntityDataFactory newInstance(PreferenceClearAccountEntityData preferenceClearAccountEntityData) {
        return new ClearAccountEntityDataFactory(preferenceClearAccountEntityData);
    }
}
