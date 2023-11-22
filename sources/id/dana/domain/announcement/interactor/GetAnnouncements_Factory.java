package id.dana.domain.announcement.interactor;

import dagger.internal.Factory;
import id.dana.domain.announcement.AnnouncementRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetAnnouncements_Factory implements Factory<GetAnnouncements> {
    private final Provider<AnnouncementRepository> announcementRepositoryProvider;

    public GetAnnouncements_Factory(Provider<AnnouncementRepository> provider) {
        this.announcementRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetAnnouncements get() {
        return newInstance(this.announcementRepositoryProvider.get());
    }

    public static GetAnnouncements_Factory create(Provider<AnnouncementRepository> provider) {
        return new GetAnnouncements_Factory(provider);
    }

    public static GetAnnouncements newInstance(AnnouncementRepository announcementRepository) {
        return new GetAnnouncements(announcementRepository);
    }
}
