package id.dana.data.recentcontact.repository.source;

import dagger.internal.Factory;
import id.dana.data.recentcontact.repository.source.persistence.PersistenceRecentContactEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RecentContactEntityDataFactory_Factory implements Factory<RecentContactEntityDataFactory> {
    private final Provider<PersistenceRecentContactEntityData> persistenceRecentContactEntityDataProvider;

    public RecentContactEntityDataFactory_Factory(Provider<PersistenceRecentContactEntityData> provider) {
        this.persistenceRecentContactEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RecentContactEntityDataFactory get() {
        return newInstance(this.persistenceRecentContactEntityDataProvider.get());
    }

    public static RecentContactEntityDataFactory_Factory create(Provider<PersistenceRecentContactEntityData> provider) {
        return new RecentContactEntityDataFactory_Factory(provider);
    }

    public static RecentContactEntityDataFactory newInstance(PersistenceRecentContactEntityData persistenceRecentContactEntityData) {
        return new RecentContactEntityDataFactory(persistenceRecentContactEntityData);
    }
}
