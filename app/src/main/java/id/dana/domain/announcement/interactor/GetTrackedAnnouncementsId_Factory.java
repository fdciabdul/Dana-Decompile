package id.dana.domain.announcement.interactor;

import dagger.internal.Factory;
import id.dana.domain.announcement.AnnouncementRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetTrackedAnnouncementsId_Factory implements Factory<GetTrackedAnnouncementsId> {
    private final Provider<AnnouncementRepository> announcementRepositoryProvider;

    public GetTrackedAnnouncementsId_Factory(Provider<AnnouncementRepository> provider) {
        this.announcementRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetTrackedAnnouncementsId get() {
        return newInstance(this.announcementRepositoryProvider.get());
    }

    public static GetTrackedAnnouncementsId_Factory create(Provider<AnnouncementRepository> provider) {
        return new GetTrackedAnnouncementsId_Factory(provider);
    }

    public static GetTrackedAnnouncementsId newInstance(AnnouncementRepository announcementRepository) {
        return new GetTrackedAnnouncementsId(announcementRepository);
    }
}
