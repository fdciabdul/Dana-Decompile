package id.dana.data.synccontact.repository;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.recentcontact.repository.RecentContactEntityRepository;
import id.dana.data.synccontact.mapper.ContactEntityMapper;
import id.dana.data.synccontact.mapper.ContactMapper;
import id.dana.data.synccontact.mapper.ContactSyncConfigMapper;
import id.dana.data.synccontact.repository.source.SyncContactDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SyncContactEntityRepository_Factory implements Factory<SyncContactEntityRepository> {
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<ContactEntityMapper> contactEntityMapperProvider;
    private final Provider<ContactMapper> contactMapperProvider;
    private final Provider<ContactSyncConfigMapper> contactSyncConfigMapperProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<RecentContactEntityRepository> recentContactEntityRepositoryProvider;
    private final Provider<SyncContactDataFactory> syncContactDataFactoryProvider;

    public SyncContactEntityRepository_Factory(Provider<ConfigEntityDataFactory> provider, Provider<SyncContactDataFactory> provider2, Provider<RecentContactEntityRepository> provider3, Provider<ContactMapper> provider4, Provider<ContactEntityMapper> provider5, Provider<ContactSyncConfigMapper> provider6, Provider<HoldLoginV1EntityRepository> provider7) {
        this.configEntityDataFactoryProvider = provider;
        this.syncContactDataFactoryProvider = provider2;
        this.recentContactEntityRepositoryProvider = provider3;
        this.contactMapperProvider = provider4;
        this.contactEntityMapperProvider = provider5;
        this.contactSyncConfigMapperProvider = provider6;
        this.holdLoginV1EntityRepositoryProvider = provider7;
    }

    @Override // javax.inject.Provider
    public final SyncContactEntityRepository get() {
        return newInstance(this.configEntityDataFactoryProvider.get(), this.syncContactDataFactoryProvider.get(), this.recentContactEntityRepositoryProvider.get(), this.contactMapperProvider.get(), this.contactEntityMapperProvider.get(), this.contactSyncConfigMapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static SyncContactEntityRepository_Factory create(Provider<ConfigEntityDataFactory> provider, Provider<SyncContactDataFactory> provider2, Provider<RecentContactEntityRepository> provider3, Provider<ContactMapper> provider4, Provider<ContactEntityMapper> provider5, Provider<ContactSyncConfigMapper> provider6, Provider<HoldLoginV1EntityRepository> provider7) {
        return new SyncContactEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static SyncContactEntityRepository newInstance(ConfigEntityDataFactory configEntityDataFactory, SyncContactDataFactory syncContactDataFactory, RecentContactEntityRepository recentContactEntityRepository, ContactMapper contactMapper, ContactEntityMapper contactEntityMapper, ContactSyncConfigMapper contactSyncConfigMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new SyncContactEntityRepository(configEntityDataFactory, syncContactDataFactory, recentContactEntityRepository, contactMapper, contactEntityMapper, contactSyncConfigMapper, holdLoginV1EntityRepository);
    }
}
