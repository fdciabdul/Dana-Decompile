package id.dana.domain.announcement.interactor;

import dagger.internal.Factory;
import id.dana.domain.announcement.AnnouncementRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveTrackedAnnouncementId_Factory implements Factory<SaveTrackedAnnouncementId> {
    private final Provider<AnnouncementRepository> announcementRepositoryProvider;

    public SaveTrackedAnnouncementId_Factory(Provider<AnnouncementRepository> provider) {
        this.announcementRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveTrackedAnnouncementId get() {
        return newInstance(this.announcementRepositoryProvider.get());
    }

    public static SaveTrackedAnnouncementId_Factory create(Provider<AnnouncementRepository> provider) {
        return new SaveTrackedAnnouncementId_Factory(provider);
    }

    public static SaveTrackedAnnouncementId newInstance(AnnouncementRepository announcementRepository) {
        return new SaveTrackedAnnouncementId(announcementRepository);
    }
}
