package id.dana.domain.home.interactor;

import dagger.internal.Factory;
import id.dana.domain.home.HomeWidgetRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SavePromoBannerAnnouncementIntoPersistence_Factory implements Factory<SavePromoBannerAnnouncementIntoPersistence> {
    private final Provider<HomeWidgetRepository> homeWidgetRepositoryProvider;

    public SavePromoBannerAnnouncementIntoPersistence_Factory(Provider<HomeWidgetRepository> provider) {
        this.homeWidgetRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SavePromoBannerAnnouncementIntoPersistence get() {
        return newInstance(this.homeWidgetRepositoryProvider.get());
    }

    public static SavePromoBannerAnnouncementIntoPersistence_Factory create(Provider<HomeWidgetRepository> provider) {
        return new SavePromoBannerAnnouncementIntoPersistence_Factory(provider);
    }

    public static SavePromoBannerAnnouncementIntoPersistence newInstance(HomeWidgetRepository homeWidgetRepository) {
        return new SavePromoBannerAnnouncementIntoPersistence(homeWidgetRepository);
    }
}
