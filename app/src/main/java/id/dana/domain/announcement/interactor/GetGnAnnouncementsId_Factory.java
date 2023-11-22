package id.dana.domain.announcement.interactor;

import dagger.internal.Factory;
import id.dana.domain.announcement.AnnouncementRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetGnAnnouncementsId_Factory implements Factory<GetGnAnnouncementsId> {
    private final Provider<AnnouncementRepository> announcementRepositoryProvider;

    public GetGnAnnouncementsId_Factory(Provider<AnnouncementRepository> provider) {
        this.announcementRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetGnAnnouncementsId get() {
        return newInstance(this.announcementRepositoryProvider.get());
    }

    public static GetGnAnnouncementsId_Factory create(Provider<AnnouncementRepository> provider) {
        return new GetGnAnnouncementsId_Factory(provider);
    }

    public static GetGnAnnouncementsId newInstance(AnnouncementRepository announcementRepository) {
        return new GetGnAnnouncementsId(announcementRepository);
    }
}
