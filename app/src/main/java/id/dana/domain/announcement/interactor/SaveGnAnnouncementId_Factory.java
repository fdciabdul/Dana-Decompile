package id.dana.domain.announcement.interactor;

import dagger.internal.Factory;
import id.dana.domain.announcement.AnnouncementRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SaveGnAnnouncementId_Factory implements Factory<SaveGnAnnouncementId> {
    private final Provider<AnnouncementRepository> announcementRepositoryProvider;

    public SaveGnAnnouncementId_Factory(Provider<AnnouncementRepository> provider) {
        this.announcementRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveGnAnnouncementId get() {
        return newInstance(this.announcementRepositoryProvider.get());
    }

    public static SaveGnAnnouncementId_Factory create(Provider<AnnouncementRepository> provider) {
        return new SaveGnAnnouncementId_Factory(provider);
    }

    public static SaveGnAnnouncementId newInstance(AnnouncementRepository announcementRepository) {
        return new SaveGnAnnouncementId(announcementRepository);
    }
}
