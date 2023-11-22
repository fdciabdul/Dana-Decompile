package id.dana.data.splitbill.repository.source;

import dagger.internal.Factory;
import id.dana.data.splitbill.repository.source.persistence.PersistenceRecentPayerEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RecentPayerEntityDataFactory_Factory implements Factory<RecentPayerEntityDataFactory> {
    private final Provider<PersistenceRecentPayerEntityData> persistenceRecentPayerEntityDataProvider;

    public RecentPayerEntityDataFactory_Factory(Provider<PersistenceRecentPayerEntityData> provider) {
        this.persistenceRecentPayerEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RecentPayerEntityDataFactory get() {
        return newInstance(this.persistenceRecentPayerEntityDataProvider.get());
    }

    public static RecentPayerEntityDataFactory_Factory create(Provider<PersistenceRecentPayerEntityData> provider) {
        return new RecentPayerEntityDataFactory_Factory(provider);
    }

    public static RecentPayerEntityDataFactory newInstance(PersistenceRecentPayerEntityData persistenceRecentPayerEntityData) {
        return new RecentPayerEntityDataFactory(persistenceRecentPayerEntityData);
    }
}
