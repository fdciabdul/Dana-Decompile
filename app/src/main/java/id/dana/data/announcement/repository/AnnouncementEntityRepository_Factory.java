package id.dana.data.announcement.repository;

import dagger.internal.Factory;
import id.dana.data.announcement.repository.source.AnnouncementEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class AnnouncementEntityRepository_Factory implements Factory<AnnouncementEntityRepository> {
    private final Provider<AnnouncementEntityDataFactory> announcementEntityDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;

    public AnnouncementEntityRepository_Factory(Provider<AnnouncementEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        this.announcementEntityDataFactoryProvider = provider;
        this.holdLoginV1EntityRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final AnnouncementEntityRepository get() {
        return newInstance(this.announcementEntityDataFactoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static AnnouncementEntityRepository_Factory create(Provider<AnnouncementEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        return new AnnouncementEntityRepository_Factory(provider, provider2);
    }

    public static AnnouncementEntityRepository newInstance(AnnouncementEntityDataFactory announcementEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new AnnouncementEntityRepository(announcementEntityDataFactory, holdLoginV1EntityRepository);
    }
}
