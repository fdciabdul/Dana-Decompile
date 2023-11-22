package id.dana.data.recentrecipient.source;

import dagger.internal.Factory;
import id.dana.data.recentrecipient.source.persistence.PersistenceRecentRecipientEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RecentRecipientEntityDataFactory_Factory implements Factory<RecentRecipientEntityDataFactory> {
    private final Provider<PersistenceRecentRecipientEntityData> persistenceRecentRecipientEntityDataProvider;

    public RecentRecipientEntityDataFactory_Factory(Provider<PersistenceRecentRecipientEntityData> provider) {
        this.persistenceRecentRecipientEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RecentRecipientEntityDataFactory get() {
        return newInstance(this.persistenceRecentRecipientEntityDataProvider.get());
    }

    public static RecentRecipientEntityDataFactory_Factory create(Provider<PersistenceRecentRecipientEntityData> provider) {
        return new RecentRecipientEntityDataFactory_Factory(provider);
    }

    public static RecentRecipientEntityDataFactory newInstance(PersistenceRecentRecipientEntityData persistenceRecentRecipientEntityData) {
        return new RecentRecipientEntityDataFactory(persistenceRecentRecipientEntityData);
    }
}
