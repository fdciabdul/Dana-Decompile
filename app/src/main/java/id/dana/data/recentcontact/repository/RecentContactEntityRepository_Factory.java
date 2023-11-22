package id.dana.data.recentcontact.repository;

import dagger.internal.Factory;
import id.dana.data.recentcontact.repository.source.RecentContactEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RecentContactEntityRepository_Factory implements Factory<RecentContactEntityRepository> {
    private final Provider<RecentContactEntityDataFactory> recentContactEntityDataFactoryProvider;

    public RecentContactEntityRepository_Factory(Provider<RecentContactEntityDataFactory> provider) {
        this.recentContactEntityDataFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RecentContactEntityRepository get() {
        return newInstance(this.recentContactEntityDataFactoryProvider.get());
    }

    public static RecentContactEntityRepository_Factory create(Provider<RecentContactEntityDataFactory> provider) {
        return new RecentContactEntityRepository_Factory(provider);
    }

    public static RecentContactEntityRepository newInstance(RecentContactEntityDataFactory recentContactEntityDataFactory) {
        return new RecentContactEntityRepository(recentContactEntityDataFactory);
    }
}
