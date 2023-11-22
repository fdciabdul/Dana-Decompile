package id.dana.domain.home.interactor;

import dagger.internal.Factory;
import id.dana.domain.home.HomeWidgetRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPromoBannerAnnouncementFromPersistence_Factory implements Factory<GetPromoBannerAnnouncementFromPersistence> {
    private final Provider<HomeWidgetRepository> homeWidgetRepositoryProvider;

    public GetPromoBannerAnnouncementFromPersistence_Factory(Provider<HomeWidgetRepository> provider) {
        this.homeWidgetRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPromoBannerAnnouncementFromPersistence get() {
        return newInstance(this.homeWidgetRepositoryProvider.get());
    }

    public static GetPromoBannerAnnouncementFromPersistence_Factory create(Provider<HomeWidgetRepository> provider) {
        return new GetPromoBannerAnnouncementFromPersistence_Factory(provider);
    }

    public static GetPromoBannerAnnouncementFromPersistence newInstance(HomeWidgetRepository homeWidgetRepository) {
        return new GetPromoBannerAnnouncementFromPersistence(homeWidgetRepository);
    }
}
